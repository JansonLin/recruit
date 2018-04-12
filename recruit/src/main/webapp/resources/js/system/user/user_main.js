
var dataGrid;
var departId = 1; // 根组织编码
var resourceName = "蜗牛人才网"

$(function() {

	// 左边树形菜单数据加载
	$('#departTree').tree({
		url : "/system/sysDepart/tree",
		onClick : function(node) {
			$(this).tree('expand', node.target); // 展开
			departId = node.attributes.departId;
			dataGrid.datagrid('reload', {
				departId : departId
			}); // 刷新主页表格数据
		}
	});

	// 主页表格数据加载
	var mainGrid = '#main_grid';
	dataGrid = $(mainGrid).datagrid({
		fitColumns : false,
		border : false,
		url : 'page',
		queryParams : {
			departId : departId
		},
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
			field : 'userName',
			title : '用户名',
			align : 'center',
			width : '20%'
		}, {
			field : 'phone',
			title : '电话号码',
			align : 'center',
			width : '20%'
		}, {
			field : 'email',
			title : 'email',
			align : 'center',
			width : '20%'
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
		/* {field:'orderIndex',title:'排序',align:'center',width:'5%'}, */
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
		/* {field:'remark',title:'备注',align:'center',width:'25%'} */
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
	$('#mainIframe')[0].src = 'addip?departId=' + departId;
	$('#mainDialog').dialog({
		title : title,
		resizable : true,
		modal : true,
	});
	$('#mainDialog').dialog('open')
}


// 修改导航
function editip(rowData) {
	var title = "详细信息修改";
	var row;
	if (null != rowData) {
		row = rowData;
	} else if (null != dataGrid.datagrid('getSelections')) {
		row = dataGrid.datagrid('getSelections')[0];
	}
	if (row) {
		$('#mainIframe')[0].src = 'detailEditip?detailId=' + row.id;
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
