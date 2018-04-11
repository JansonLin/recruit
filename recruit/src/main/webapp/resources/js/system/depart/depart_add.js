
var parentCode = "home"; //根组织编码

$(function() {

	parentCode = $("#parentDepartCode").val();

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

