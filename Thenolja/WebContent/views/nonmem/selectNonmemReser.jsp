<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="thenolja.nonmem.model.vo.SelectNonmemReser"%>
    <%@ page import="java.util.ArrayList" %>
<%
	ArrayList<SelectNonmemReser> nonmemReser = (ArrayList) session.getAttribute("nonmemReser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비회원 예약조회 페이지</title>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	<%= nonmemReser.get(1).getMemName() %>
	<%= nonmemReser.get(1).getMemPhone() %>
	<%= nonmemReser.get(1).getMemStatus() %>
	
	
	
	
	
	
</body>
</html>