
$(function() {

	$('#limitTree').tree({
		url : "limitTree",
		checkbox:true,
	    onClick: function(node){
		  $(this).tree('expand',node.target);  //展开	
		}
	});

});




function addFun() {
	var data = $('#add-form').serialize();
	var limits="";
	var nodes = $('#limitTree').tree('getChecked');
	  nodes.forEach(function( val, index ) {
		  limits = limits+val.id;
		  if(nodes.length-1!=index){
			  limits = limits+",";
		  }
	  });
	data = data+"&&limits="+limits  
	if ($('#add-form').form('validate')) {
		$.ajax({
			type : 'post',
			url : 'add',
			dataType : "json",
			data : data,
			success : function(result) {
				if (result.type == "success") {
					parent.$('#mainDialog').dialog('close');
					parent.$.messager.show({
						title : '提示',
						msg : result.content,
						timeout : 1000,
						showType : 'slide'
					});
					parent.dataGrid.datagrid('reload'); // 刷新父主页表格数据
				} else {
					parent.$.messager.show({
						title : '错误',
						msg : result.content,
						timeout : 1000,
						showType : 'slide'
					});
				}
				;

			}
		});
	}

}
