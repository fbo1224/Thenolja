<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList, thenolja.tb_hotel.model.vo.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteListForm</title>
<link rel="stylesheet" href="views/hotel/css/deleteListForm.css">
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />
	
	<div id="wrap">
	<c:choose>
		<c:when test="${ rooms ne null and empty rooms }">
			<h3>등록된 객실이 없습니다.</h3>
		</c:when>
		<c:otherwise>
		<div id="title-div">
			<h2>등록된 객실들</h2>
		</div>
		<div id="content-div">
			<section id="content-add-sect">
			<c:forEach var="r" items="${ rooms }">
				<div class="content-div-1" id="${ r.roomNo }">
					<div class="form-group">
					  <label>객실이름</label>
					  <input type="text" class="form-control" name="roomName" readonly value="${ r.roomName }" >
					</div>
					
					<div class="form-group">
					  <label>최대인원</label>
					  <input type="text" class="form-control"  name="maxPeople" readonly value="${ r.maxPeople }" >
					</div>
					
					<div class="form-group">
					  <label>객실 사진</label>
					  <img width="100px" height="100px" src="${ r.roomImgPath }" alt="beforeImg">
					</div>
					
					<div class="form-grop">
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
						<button type="button" class="btn btn-sm btn-danger roomBtn" data-toggle="modal" data-target="#myModal" onclick="">객실삭제</button>
					</div>
				</div>
				</c:forEach>
			</section>
		</div>
		</c:otherwise>
	</c:choose>
	</div>
	
	<!-- The Modal -->
		<div class="modal" id="myModal">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <!-- Modal Header -->
		      <div class="modal-header">
		        <h4 class="modal-title">객실삭제</h4>
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		      </div>
		
		      <!-- Modal body -->
		      <div class="modal-body" align="center">
		        	정말로 삭제하시겠습니까?
		      </div>
		
		      <!-- Modal footer -->
		      <div class="modal-footer .hr-footer">
		      	<button type="button" class="btn btn-danger deleteRoomBtn" data-dismiss="modal">삭제</button>
		        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">닫기</button>
		      </div>
		
		    </div>
		  </div>
		</div>
		
	<script>
	
			let roomNo;
			$('.roomBtn').click(function(e){
				roomNo = $(this).parent().parent().attr('id');
			});
			
			$('.deleteRoomBtn').click(function(e){
				$.ajax({
						url: 'deleteRoom.jqAjax',
						data: {
							roomNo : roomNo,
						},
						type: 'get',
						success : function(result){
							alert(result);
						},
						error: function(error){
							alert(result);
						},
						async: false
					});
				location.reload();
			});
			
		</script>
</body>
</html>