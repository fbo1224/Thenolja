<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비회원 예약조회 페이지</title>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	<h1>비회원 예약조회 페이지</h1>

	비회원테이블에서 시작, 예약테이블 조인(회원번호)
	1. 예약번호
	2. 예약자 이름
	3. 입실날짜
	4. 퇴실날짜
	5. 이동방식
	6. 인원수
	
	여기부터 객실테이블 조인(객실번호)
	1. 객실이름
	2. 객실호수
	3. 최대인원
	4. 입실시간
	5. 퇴실시간
	
	객실사진 테이블 조인(객실번호)
	1. 객실사진
	
	+ 환불하기 버튼


</body>
</html>