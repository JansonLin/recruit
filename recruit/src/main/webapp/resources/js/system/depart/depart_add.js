
var parentCode = "home"; //根组织编码
var dataGrid;
$(function() {

	parentCode = $("#parentDepartCode").val();
    
	// 主页表格数据加载
	var mainGrid = '#main_grid';
	dataGrid = $(mainGrid).datagrid({
		fitColumns : false,
		border : false,
		url : '',
		method : 'get',
		pagination : true,
		striped : true,
		selectOnCheck : true,
		rownumbers : true,
		fit:false,
		idField : 'id',
		pageSize : 10,
		pageList : [ 10, 20, 45, 60, 75 ],
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
			width : '10%',
			formatter : function(stat) {
				if (stat == 1) {
					return "生效";
				} else if (stat == 0) {
					return "禁用";
				} else {
					return "其它";
				}
			}
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


function addFun() {
	var data = $('#add-form').serialize();
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
					var node=parent.$("#departTree").tree('find',parentCode); 
		  	        parent.$("#departTree").tree('reload',node.target);   //刷新树
					parent.dataGrid.datagrid('reload'); //刷新父主页表格数据
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

function empowerip() {
	var title = "角色授权";
	$('#mainIframe')[0].src = 'empowerip';
	$('#addDialog').dialog({
		title : title,
		resizable : true,
		modal : true,
	});
	$('#addDialog').dialog('open')
}

//取消角色授权
function delpowerFun(){
	 var rows = dataGrid.datagrid('getChecked');
	 if(null==rows){
		 return;
	 }
	 for(var i=0;i<rows.length;i++){
		 console.log(rows[i].id);
		 dataGrid.datagrid('deleteRow',rows[i].id);
	 }
	 
}


//会写选择的角色信息
function addLineFun(rows){
	for(var i=0;i<rows.length;i++){
		dataGrid.datagrid('appendRow',{
			id:rows[i].id,
			roleName: rows[i].roleName,
			ramrak: rows[i].remark,
			status: rows[i].status
		});
	}
}


function cancelFun(){
	 parent.$('#mainDialog').dialog('close');
}


