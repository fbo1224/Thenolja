<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, thenolja.tb_hotel.model.vo.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateRoom Form</title>
<link rel="stylesheet" href="views/hotel/css/updateRoomForm.css">
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />
	
	<div id="wrap">
		<div id="title-div">
			<h2>객실정보수정</h2>
		</div>
		<div id="content-div">
			<form id="content-add-form" action="${ path }/updateRoom.rooms" enctype="multipart/form-data" method="post">
			<input type="hidden" name="roomNo" value="${ roomNo }" >
			<section id="content-add-sect">
				<div class="content-div-1">
					<div class="form-group">
					  <label>객실이름</label>
					  <input type="text" class="form-control" name="roomName" required oninput="testVal(this,roomName);" value="${ room.roomName }">
					</div>
					
					<div class="form-group">
					  <label>최대인원</label>
					  <input type="text" class="form-control" maxlength="3" name="maxPeople" required oninput="testVal(this,maxPeople);"  value="${ room.maxPeople }" >
					</div>
					
					<div class="form-group">
					  <label>객실 사진</label>
					  <input type="file"  name="roomImg" oninput="testVal(this, roomImg);" >
					  <img width="100px" height="100px" src="${ room.roomImgPath }" >
					  <input type="hidden" name="roomImgBefore" value="${ room.roomImgPath}">
					  <input type="hidden" name="roomImgNo" value="${ room.roomImgNo}">
					</div>
					
					<div class="form-grop">
						<label>입실시간</label>
						<input type="time" name="in_time" required value="${room.checkInTime }"><br>				
						<label>퇴실시간</label>
						<input type="time" name="out_time" required value="${ room.checkOutTime }">
					</div>
					
					<div class="form-group">
					  <label>객실 가격</label>
					  <input type="text"  name="roomPrice" maxlength="9" required oninput="testVal(this, roomPrice);" value="${ room.roomPrice }">
					</div>
					
					<div class="form-group">
					  <label>객실 번호</label>
					  <input type="text"  name="roomNum" maxlength="9" required oninput="testVal(this, roomNum);" value="${ room.roomNum }">
					</div>
				</div>
				</section>
				<div id="btn-div" align="center">
					<button type="submit" class="btn btn btn-info">객실 수정</button>
				</div>
			</form>
		</div>
	</div>
	<script>
	const regNameRule = /^[a-zA-Z0-9ㄱ-ㅎㅏ-ㅣ가-힣\s]+$/;
	const regNum = /^[1-9]+$/;
	
	function testVal(e, tag) {
		if($(e).val().charAt(0) === ' '){
			alert('입력은 공백으로 시작할수 없습니다.');
			$(e).val('');
			return;
		}
		
		if(tag.name === 'roomName'){
			if($(e).val() === ''){
				return;
			}
			if(!regNameRule.test($(e).val())){
				alert('입력할수 없는 문자입니다.');
				$(e).val('');
				return;
			}	
		}
		else if(tag.name === 'maxPeople' ||
				tag.name === 'roomPrice' ||
				tag.name === 'roomNum') {
					if($(e).val() == " "){
						return;
					}
					if(!regNum.test($(e).val())){
						alert('공백과 문자가 없는 숫자만 입력해주세요.');
						$(e).val('');
						return;
					}
		}
		else if(tag.name === 'roomImg'){
			if($(e).val().substring($(e).val().lastIndexOf(".")) !== ".jpg" &&
			   $(e).val().substring($(e).val().lastIndexOf(".")) !== ".png" &&
			   $(e).val().substring($(e).val().lastIndexOf(".")) !== ".jpeg"
			) {
				alert('.jpg, .png, .jpeg 형식의 사진 파일만 가능합니다.');
				$(e).val('');
				return;
			}
		}
	}
	</script>
</body>
</html>