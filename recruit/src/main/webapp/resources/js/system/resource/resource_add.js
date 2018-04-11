
var pid = 0; //菜单父ID

$(function() {
    pid = $("#parentId").val();
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
					var node=parent.$("#resourceTree").tree('find',pid); 
		  	        parent.$("#resourceTree").tree('reload',node.target);   //刷新树
					parent.dataGrid.datagrid('reload'); //刷新父主页表格数据
				} else {
					$.messager.alert("操作提示", result.content, "error");
				}
				;

			}
		});
	}

}

