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
<link rel="stylesheet" href="<%=basePath%>resources/css/common/reset.css">
<link rel="stylesheet" href="<%=basePath%>resources/easyui/themes/metro/easyui.css">
<link rel="stylesheet" href="<%=basePath%>resources/css/icon.css">
<link rel="stylesheet" href="<%=basePath%>resources/css/common.css">
<link rel="stylesheet" href="<%=basePath%>resources/css/main.css?v=1">
<title>用户添加</title>
</head>
<body class="easyui-layout ">
	<div data-options="region:'center',border:false,split:true" style="width:100%;padding:0 15px;">
		<div  class="easyui-tabs" height="80%">
        <div title="基本信息" style="padding:20px;display:none;">
		<div class="formList">
			<form id="add-form" method="post" action="">
				<ul class="itemList clearfix">
	                 <li class=" clearfix item50">
	                    <span class="itemName"><b>*</b>用户名称</span>
	                    <div class="itemCon">
	                        <input name="departId" type="hidden" value="${departId}" >
	                        <input class="easyui-textbox" name="userName"  data-options="width:150,required:true,missingMessage:'用户名称不能为空'" type="text">
	                    </div>
	                  </li>
	                  <li class="clearfix item50">
	                    <span class="itemName"><b>*</b>密码</span>
	                    <div class="itemCon">
	                        <input class="easyui-textbox" name="password"  data-options="width:150,required:true,missingMessage:'密码不能为空'" type="text">
	                    </div>
	                    </li> 
	                   <li class=" clearfix item50">
	                    <span class="itemName"><b>*</b>手机</span>
	                    <div class="itemCon">
	                        <input class="easyui-textbox" name="phone"  data-options="width:150,required:true,missingMessage:'手机不能为空'" type="text">
	                    </div>
	                  </li>
	                  <li class="clearfix item50">
	                    <span class="itemName"><b>*</b>姓名</span>
	                    <div class="itemCon">
	                        <input class="easyui-textbox" name="realName"  data-options="width:150" type="text">
	                    </div>
	                    </li> 
	                    <li class=" clearfix item50">
	                    <span class="itemName"><b>*</b>email</span>
	                    <div class="itemCon">
	                        <input class="easyui-textbox" name="email"  data-options="width:150,required:true,missingMessage:'email不能为空'" type="text">
	                    </div>
	                  </li>
	                  <li class="clearfix item50">
	                    <span class="itemName">出生日期</span>
	                    <div class="itemCon">
	                        <input class="easyui-datebox" name="birthday" data-options="width:150">
	                    </div>
	                    </li>      
	                   <li class="clearfix item50" >
	                    <span class="itemName"><b>*</b>状态</span>
	                    <div class="itemCon">
	                        <select class="easyui-combobox" name="status" data-options="width:150,required:true,editable:false,panelHeight:'auto',missingMessage:'状态不能为空'" type="text">
	                        <option value="1">启用</option>
	                        <option value="0">禁用</option>
	                        </select>
	                    </div>
	                   </li>
	                   <li class="clearfix item50" >
	                    <span class="itemName"><b>*</b>性别</span>
	                    <div class="itemCon">
	                        <select class="easyui-combobox" name="gender" data-options="width:150,required:true,editable:false,panelHeight:'auto',missingMessage:'状态不能为空'" type="text">
	                        <option value="1">男</option>
	                        <option value="2">女</option>
	                        </select>
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
		</div>
		
		<div title="角色信息" >
         <div data-options="region:'center',title:'主页'" split="true">
           <table id="main_grid" class="easyui-datagrid" ></table>
         </div>
         <div id="toolbar" style="display: none;">
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'iconBtn-setUp',
                       plain:true" onclick="empowerip();">角色授权</a>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'iconBtn-delete',
                 plain:true" onclick="delpowerFun();">取消授权</a>
         </div>
        </div>
		
		</div>
		<div class="fixedBtnBanner">
            <a href="#" class="easyui-linkbutton" data-options="" onclick="addFun()">保&nbsp存</a>
            <a href="#" class="easyui-linkbutton" data-options="" onclick="cancelFun()">取&nbsp消</a>
        </div>
         <div id="addDialog" class="easyui-dialog" closed="true" buttons="#dlg-buttons"  style="width:80%;height:100%;">
	      <iframe scrolling="auto" id='mainIframe'  frameborder="0"  src="" style="width:100%;height:100%;"></iframe>
	  </div> 
	</div>
</body>  
<script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/easyui/jquery.min.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/easyui/jquery.easyui.ext.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/js/system/user/user_add.js"></script>
</html>

