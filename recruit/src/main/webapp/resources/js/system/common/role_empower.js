
var dataGrid;

$(function() {


	// 主页表格数据加载
	var mainGrid = '#main_grid';
	dataGrid = $(mainGrid).datagrid({
		fitColumns : false,
		border : false,
		url : '/system/sysRole/page',
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
		onLoadSuccess : function() {
			$.messager.progress('close');
		}
	});

})

  function submitFun(){
	 var rows = dataGrid.datagrid('getChecked');
	 if(null==rows){
		 return;
	 }
	 parent.addLineFun(rows);
	 parent.$('#addDialog').dialog('close');
	  //console.log(limits);
  }
  
  function cancelFun(){
	  parent.$('#addDialog').dialog('close');
  }
