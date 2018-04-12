<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="<%=basePath%>resources/easyui/themes/metro/easyui.css">
<link rel="stylesheet" href="<%=basePath%>resources/css/main.css">
<link rel="stylesheet" href="<%=basePath%>resources/css/icon.css">

<title>角色列表</title>
</head>
<body  class="easyui-layout">
	
	    <div data-options="region:'center',title:'主页'" split="true">
			<table id="main_grid" class="easyui-datagrid" style="width:100%;height:97%"></table>
		</div>
		<div id="toolbar" style="display: none;">
		   <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'iconBtn-setUp',plain:true" onclick="submitFun();">确定</a>
		   <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'iconBtn-modify',plain:true" onclick="cancelFun();">取消</a>
	    </div>
			
</body>    
<script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/easyui/jquery.min.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/js/system/common/role_empower.js"></script>
</html>

