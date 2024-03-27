<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String errorMsg = (String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서비스 실패 화면</title>
<style>
	h1{
		color : orangered;
		margin-top : 80px;
		text-align : center;
		font-size : 33px;
		font-weight : bold;
	}
</style>
</head>
<body>
	
	<%@ include file="menubar.jsp" %>
	
	<h1><%= errorMsg %></h2>



</body>
</html>