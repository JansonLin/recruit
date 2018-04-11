
var dataGrid;

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
		pageSize : 15,
		pageList : [ 15, 30, 45, 60, 75 ],
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
			field : 'operateName',
			title : '操作名称',
			align : 'center',
			width : '20%'
		}, {
			field : 'operateUser',
			title : '操作人',
			align : 'center',
			width : '20%'
		}, {
			field : 'email',
			title : 'email',
			align : 'center',
			width : '20%'
		},
		/* {field:'orderIndex',title:'排序',align:'center',width:'5%'}, */
		{
			field : 'operateTime',
			title : '操作时间',
			align : 'center',
			width : '20%',
			formatter : function(value, row, index) {
				var unixTimestamp = new Date(value);
				return unixTimestamp.toLocaleString();
			}
		}, {
			field : 'operateIp',
			title : '操作IP',
			align : 'center',
			width : '20%'
		}
		/* {field:'remark',title:'备注',align:'center',width:'25%'} */
		] ],
		toolbar : '#toolbar',
		onLoadSuccess : function() {
			$.messager.progress('close');
		}
	});

})

