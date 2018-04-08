
var dataGrid;
var parentCode = "home"; //根组织编码
var resourceName = "蜗牛人才网"

$(function() {

	//左边树形菜单数据加载
	$('#departTree').tree({
		url : "tree",
		onClick : function(node) {
			$(this).tree('expand', node.target); //展开	
			parentCode = node.id;
			//resourceName = resourceName + ">>" + node.text;
			dataGrid.datagrid('reload', {
				parentCode : parentCode
			}); //刷新主页表格数据
		}
	});

	//主页表格数据加载
	var mainGrid = '#main_grid';
	dataGrid = $(mainGrid).datagrid({
		fitColumns : false,
		border : false,
		url : 'page',
		queryParams : {
			parentCode : parentCode
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
			field : 'departName',
			title : '部门名称',
			align : 'center',
			width : '20%'
		}, {
			field : 'departCode',
			title : '部门编码',
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
		/*{field:'orderIndex',title:'排序',align:'center',width:'5%'},*/
		{
			field : 'createTime',
			title : '创建时间',
			align : 'center',
			width : '20%',
			formatter : function(value, row, index) {
				var unixTimestamp = new Date(value);
				return unixTimestamp.toLocaleString();
			}
		},
		/*{field:'remark',title:'备注',align:'center',width:'25%'}*/
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
	$('#mainIframe')[0].src = 'addip?parentCode=' + parentCode;
	$('#mainDialog').dialog({
		title : title,
		resizable : true,
		modal : true,
	});
	$('#mainDialog').dialog('open')
}

function addFun() {
	var data = $('#add-form').serialize();
	console.log("=========="+data);
	if ($('#add-form').form('validate')) {
		$.ajax({
			type : 'post',
			url : 'add',
			dataType : "json",
			data : data,
			success : function(result) {
				console.log(result+"=========="+result.type);
				if (result.type == "success") {
					parent.$('#mainDialog').dialog('close');
					parent.$.messager.show({
						title : '提示',
						msg : result.content,
						timeout : 1000,
						showType : 'slide'
					});
					var node=parent.$("#departTree").tree('find',parentCode); 
					console.log("====="+node)
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

//修改导航    
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
