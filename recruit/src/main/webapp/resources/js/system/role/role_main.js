
var dataGrid;
var resourceName = "蜗牛人才网"

$(function() {


	// 主页表格数据加载
	var mainGrid = '#main_grid';
	dataGrid = $(mainGrid).datagrid({
		fitColumns : false,
		border : false,
		url : 'page',
		method : 'get',
		pagination : true,
		striped : true,
		selectOnCheck : true,
		rownumbers : true,
		idField : 'id',
		pageSize : 20,
		pageList : [ 20, 30, 45, 60, 75 ],
		loadMsg : "数据加载中....",
		columns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			field : 'id',
			title : 'ID',
			align : 'center',
			hidden : true
		}, {
			field : 'roleName',
			title : '角色名称',
			align : 'center',
			width : '20%'
		}, {
			field : 'ramrak',
			title : '备注',
			align : 'center',
			width : '30%'
		}, {
			field : 'status',
			title : '状态',
			align : 'center',
			width : '5%',
			formatter : function(stat) {
				if (stat == 1) {
					return "生效";
				} else if (stat == 0) {
					return "禁用";
				} else {
					return "其它";
				}
			}
		},
		{
			field : 'createTime',
			title : '创建时间',
			align : 'center',
			width : '20%',
			formatter : function(value, row, index) {
				var unixTimestamp = new Date(value);
				return unixTimestamp.toLocaleString();
			}
		}, {
			field : 'creator',
			title : '创建人',
			align : 'center',
			width : '20%'
		}
		] ],
		toolbar : '#toolbar',
		onDblClickRow : function(rowIndex, rowData) {
			editip(rowData);
		},
		onLoadSuccess : function() {
			$.messager.progress('close');
		}
	});

})

function addip() {
	var title = resourceName + ">>>>>详细信息添加";
	$('#mainIframe')[0].src = 'addip';
	$('#mainDialog').dialog({
		title : title,
		resizable : true,
		modal : true,
	});
	$('#mainDialog').dialog('open')
}


// 修改导航
function editip(rowData) {
	var title = resourceName + "详细信息修改";
	var row;
	if (null != rowData) {
		row = rowData;
	} else if (null != dataGrid.datagrid('getSelections')) {
		row = dataGrid.datagrid('getSelections')[0];
	}
	if (row) {
		$('#mainIframe')[0].src = 'editip?id=' + row.id;
		$('#mainDialog').dialog({
			title : title,
			resizable : true,
			modal : true,
		});
		$('#mainDialog').dialog('open')
	} else {
		$.messager.alert("操作提示", "请选择修改的信息!", "info");
	}
}

//删除信息
function deleteFun(){
	var row  = dataGrid.datagrid('getSelections');
	if(row.length<1){
		$.messager.alert("操作提示", "请选择删除的信息!","info");	
		return;
	}
	var ids=[]; 
	$.each(row,function(i){
	   var id=row[i].id;     
       ids.push(id);
	});
	console.log(ids);
	$.messager.confirm('询问', '确认删除当前选择记录？', function(b) {
		if(b){
			$.ajax({
				url: "delete?ids="+ids,
				type: "POST",
				dataType: "json",
				success: function(result) {
			    	console.log(result);
			     	if(result.type="success"){
			        	parent.$.messager.show({
			    			 title:'提示',
			    			 msg:result.content,
			    			 timeout:1000,
			    			 showType:'slide'
			    		   });
			        	dataGrid.datagrid('reload');  //刷新父主页表格数据
				      /*  var node=$("#moudleTree").tree('find',pid); 
			        	$("#moudleTree").tree('reload',node.target); */
			    	}else{
			        	$.messager.alert("操作提示", result.content,"error");
			    	}; 
				}
			});
		}
	});
}
