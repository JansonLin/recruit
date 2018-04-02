<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/inc.jsp"%>     
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>蜗牛人才网</title>

<link rel="stylesheet" href="<%=basePath%>resources/css/common/reset.css">
<link rel="stylesheet" href="<%=basePath%>resources/easyui/themes/metro/easyui.css">
<link rel="stylesheet" href="<%=basePath%>resources/ztree/zTreeStyle.css">
<link rel="stylesheet" href="<%=basePath%>resources/css/main.css">
</head>
<body class="easyui-layout" data-options='collapsible:true'>
    <!--头部banner start-->
    <div class="wu-header" data-options="region:'north',border:false,split:true" style="height:60px;">
    	<div class="wu-header-left">
        	<h1></h1>
        </div> 
        <div class="wu-header-right">
        	<ul>
        		<li>${roleName}：${user.realName}</li>
        		<li>修改密码</li>
        		<li><a id="loginout" href="<%=basePath%>loginout">退出登录</a></li>
        	</ul>
        </div>
    </div>

    <!--左边 树形导航-->
    <div class="wu-sidebar" data-options="region:'west',split:true,border:true,title:' '">
        <div class="easyui-accordion"  id="accordionid" data-options="border:false,fit:true">
            

        </div>
    </div>

    <!--主内容-->
    <div class="wu-main" data-options="region:'center',split:true,border:true">
		<div id="tabs" class="easyui-tabs" data-options="border:false,fit:true,tabHeight:34">
             <!-- <div title="首页" data-link="<%=basePath%>order/layout2" ></div>
             <div title="全部" id="00" data-options="href:'<%=basePath%>order/orderAll?delivery='" style="background:#f9f9f9;"></div> -->
        </div>
    </div>

    <!--底部 banner-->
    <!-- <div class="wu-footer" data-options="region:'south',border:true,split:true">
        &copy; 2017 佛山欧神诺陶瓷股份有限公司
    </div> -->
</body>
<script type="text/javascript">
	var orgId = '${user.orgId}';
</script> 
<script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/easyui/jquery.min.js"></script>
<script src="<%=basePath%>resources/js/common/less.min.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/js/common/common.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/js/system/login/login_main.js"></script>



</html>