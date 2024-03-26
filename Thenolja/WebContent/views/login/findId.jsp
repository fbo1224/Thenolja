<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<style>


</style>

</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<span>아이디 찾기</span>

	<form action="<%=contextPath%>/findId" method="post" id="findIdform">
        <input type="text" name="name" class="ipt" placeholder="이름"> 
        <input type="text" name="bornDate" class="ipt" placeholder="생년월일">
        <input type="text" name="phone" class="ipt" placeholder="전화번호">

        <div><button></button></div>
        <div><button></button></div>





    </form>


</body>
</html>