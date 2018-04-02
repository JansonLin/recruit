/*$(function(){
	$('.multistageTree a').bind("click",function(){
		var title = $(this).text();
		var id = $(this).attr('data-id');
		var parTitle = $(this).closest('.panel').find('.panel-title').text();
		var tabTitle = '<span>'+parTitle+'</span>-'+title
		var url = $(this).attr('data-link');
		var iconCls = $(this).attr('data-icon');
		
		addTab(title,url,iconCls,id);
	});	 
	$('.wu-side-tree .tree-indent,.wu-side-tree .tree-icon,.multistageTree .tree-icon').remove();
    $('.initClick').click();
    
    
    
})
*/
$(function(){
	$.ajax({
		url:'/system/sysResource/rootTree',  
        type:'post',  
        dataType:'json', 
        success:function(data){
        	console.log(data);
        	$.each(data,function(i,menu){
        		$('#accordionid').accordion('add', {
                    title: menu.resourceName,
                    content: "<ul class='easyui-tree multistageTree' id='tree"+i+"'  data-options='lines:false' ></ul>",
                    selected: true,
                });
                $.parser.parse();
                $("#tree" + i).tree({
            	    url: "/system/sysResource/tree?id="+menu.id,		
            		onClick: function(node){
            	       if (node.state == 'closed'){  
                         $(this).tree('expand', node.target);  
                       }else{  
                             $(this).tree('collapse', node.target);  
                       }  	
            		   var tabTitle = node.text;
                       var url = node.attributes.url;
                       var icon = node.iconcls;
                       var id = node.id;
            		   if(null==url||url.length<1){
            				return;
            		   }   
                       addTab(tabTitle, url, icon,id); 
            		},
                    onLoadSuccess:function(node, data)  {  
                       $("#tree" + i).tree("collapseAll"); 
                       if(i==0){ //默认选中第一个
                    	   console.log(data[0]);
	                    	var tree = data[0];  
	                    	var n = $('#tree0').tree('find', data[0].id);
	                       	//调用选中事件
	                       	$('#tree0').tree('expandTo', n.target); 
	                       	addTab(tree.text,tree.attributes.url,tree.iconcls,tree.id)
                       };
                       $('.multistageTree .tree-icon').remove();
                    }
            	});
                
        	});
        	
        }
	});
});

function addTab(title,url,icon,id){
	if(!$('#tabs').tabs('exists',title)){
		$('#tabs').tabs('add',{
			title:title,
			loadMsg:'加载中...',
			content:createFrame(url),
			closable:true,
			icon:icon
		});
	}else{
		$('#tabs').tabs('select',title);
	}
}
function createFrame(url)
{
	
	var s = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;" onload="$(this).show();")></iframe>';
	return s;
}