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

<title>基础数据列表</title>
</head>
<body  class="easyui-layout">
	
	    <div data-options="region:'west',title:'菜单',split:true" style="width:25%;">
		   <div class="easyui-panel" style="padding:5px;height:100%">
			  <ul class="easyui-tree" id="departTree"></ul>
		   </div>
	    </div>
	    
	    <div data-options="region:'center',title:'主页'" split="true">
			<table id="main_grid" class="easyui-datagrid" style="width:100%;height:97%"></table>
		</div>
		<div id="toolbar" style="display: none;">
		   <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'iconBtn-setUp',plain:true" onclick="addip();">增加</a>
		   <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'iconBtn-modify',plain:true" onclick="editip();">修改</a>
		   <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'iconBtn-delete',plain:true" onclick="deleteip();">删除</a>
		  <!--  <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'iconBtn-setUp',plain:true" onclick="empowerFun();">角色授权</a> -->
	    </div>
			
		<div id="mainDialog" class="easyui-dialog" closed="true" buttons="#dlg-buttons"  style="width:80%;height:70%;">
	        <iframe scrolling="auto" id='mainIframe'  frameborder="0"  src="" style="width:100%;height:98%;"></iframe>
	    </div> 	
</body>    
<script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/easyui/jquery.min.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/js/system/depart/depart_main.js"></script>
</html>

