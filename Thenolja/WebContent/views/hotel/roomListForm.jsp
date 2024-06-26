<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList, thenolja.tb_hotel.model.vo.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hotel List Form</title>
<link rel="stylesheet" href="views/hotel/css/roomListForm.css">
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />
	
	<div id="wrap">
	<c:choose>
	<c:when test="${ empty rooms }">
		<h3>등록된 객실이 없습니다.</h3>
	</c:when>
	<c:otherwise>
		<div id="title-div">
			<h2>등록된 객실들</h2>
		</div>
		<div id="content-div">
			<section id="content-add-sect">
			  <c:forEach var="r" items="${ rooms }">
				<div class="content-div-1">
					<div class="form-group">
					  <label>객실이름</label>
					  <input type="text" class="form-control" name="roomName" readonly value="${r.roomName }" >
					</div>
					
					<div class="form-group">
					  <label>최대인원</label>
					  <input type="text" class="form-control"  name="maxPeople" readonly value="${r.maxPeople }" >
					</div>
					
					<div class="form-group">
					  <label>객실 사진</label>
					  <img width="100px" height="100px" src="${ r.roomImgPath }" alt="beforeImg">
					</div>
					
					<div class="form-group">
						<label>입실시간</label>
						<input type="time" name="in_time" readonly value="${ r.checkInTime }" ><br>				
						<label>퇴실시간</label>
						<input type="time" name="out_time" readonly value="${ r.checkOutTime }" >
					</div>
					
					<div class="form-group">
					  <label>객실 가격</label>
					  <input type="text"  name="roomPrice" readonly value="${ r.roomPrice }">
					</div>
					
					<div class="form-group">
					  <label>객실 번호</label>
					  <input type="text"  name="roomNum" readonly  value="${ r.roomNum }">
					</div>
					<div id="btn-div" align="center">
						<button type="button" class="btn btn btn-info" onclick="updateRoom(this,${ r.roomNo});">객실정보수정</button>
					</div>
				</div>
			  </c:forEach>
			</section>
		</div>
	</c:otherwise>
	</c:choose>
	</div>
	<script>
		function updateRoom(e, roomNo){
			console.log(roomNo);
			location.href= "${ path }/updateRoomForm.rooms?roomNo=" + roomNo;
		}
	</script>
</body>
</html>