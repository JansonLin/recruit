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
<link rel="stylesheet" href="<%=basePath%>resources/css/icon.css">
<link rel="stylesheet" href="<%=basePath%>resources/css/common.css">

<title>基础数据列表</title>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',border:false,split:true" style="width:100%;padding:0 15px;">
		<div class="formList">
			<form id="add-form" method="post" action="">
				<ul>
	                   <li class="clearfix">
	                    <span class="itemName"><b>*</b>菜单名称</span>
	                    <div class="itemCon">
	                        <input name="parentId" type="hidden" value="${pid}" >
	                        <input class="easyui-textbox" name="resourceName"  data-options="width:150,required:true,missingMessage:'菜单名称不能为空'" type="text">
	                    </div>
	                  </li>
	                  <li class="clearfix">
	                    <span class="itemName"><b>*</b>菜单编码</span>
	                    <div class="itemCon">
	                        <input class="easyui-textbox" name="resourceCode"  data-options="width:150,required:true,missingMessage:'基菜单编码不能为空'" type="text">
	                    </div>
	                    </li>     
	                   <li class="clearfix">
	                    <span class="itemName"><b>*</b>状态</span>
	                    <div class="itemCon">
	                        <select class="easyui-combobox" name="status" data-options="width:150,required:true,editable:false,panelHeight:'auto',missingMessage:'状态不能为空'" type="text">
	                        <option value="0">启用</option>
	                        <option value="1">禁用</option>
	                        </select>
	                    </div>
	                   </li>
	                  <li class="clearfix">
	                     <span class="itemName"><b>*</b>控制路径</span>
	                    <div class="itemCon">
	                        <input class="easyui-textbox" name="resourceUrl" data-options="width:150,required:true,missingMessage:'路径不能为空'" type="text">
	                    </div>
	                    </li>
	                  <li class="clearfix">
	                    <span class="itemName" >备注</span>
	                    <div class="itemCon">
	                       <input class="easyui-textbox" name="remark" data-options="width:200,height:60,multiline:true" type="text" style="margin-top:10px;">
	                    </div>
	                    </li>
	                </ul>               		
			</form>
		</div>
		
		<div class="fixedBtnBanner">
            <a href="#" class="easyui-linkbutton" data-options="" onclick="addFun()">保&nbsp存</a>
            <a href="#" class="easyui-linkbutton" data-options="" onclick="cancelFun()">取&nbsp消</a>
        </div>
	</div>
</body>  
<script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/easyui/jquery.min.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/js/system/resource/resource_main.js"></script>
</html>

