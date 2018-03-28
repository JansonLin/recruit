<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>  
<%@ include file="/include/inc.jsp"%>
<html>
	<head>
		<title>蜗牛人才网后台管理</title>
	</head>

	<body><c:redirect url="system/login/login"/></body>
</html>
