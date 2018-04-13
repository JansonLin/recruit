
var dataGrid;

$(function() {

    var roleIds = $("#roleIds").val();
	// 主页表格数据加载
	var mainGrid = '#main_grid';
	dataGrid = $(mainGrid).datagrid({
		fitColumns : false,
		border : false,
		url : '/system/sysRole/userRoleEditPage?roleIds='+roleIds,
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
	
	 var data ="userId="+$("#userId").val();
	 var rows = dataGrid.datagrid('getChecked');
	 if(null==rows){
		 return;
	 }
	 var roleIds=new Array()
		if(null!=rows){
			for(var i=0;i<rows.length;i++){
				roleIds[i] = rows[i].id;
			}
	 }
	 data = data+"&roleIds="+roleIds;
	 console.log(data);
	 $.ajax({
			type : 'post',
			url : 'userRoleSave',
			dataType : "json",
			data : data,
			success : function(result) {
				if (result.type == "success") {
					parent.$('#editDialog').dialog('close');
					/*parent.$.messager.show({
						title : '提示',
						msg : result.content,
						timeout : 1000,
						showType : 'slide'
					});*/
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
	// parent.addLineFun(rows);
	// parent.$('#editDialog').dialog('close');
	  //console.log(limits);
  }
  
  function cancelFun(){
	  parent.$('#editDialog').dialog('close');
  }
