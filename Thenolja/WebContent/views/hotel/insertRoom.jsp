<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div {
	box-sizing: border-box;
}

#title-div {
	width: 100%;
	height: 10%;
	margin: auto;
	border-bottom:  1px solid gray;
	display: flex;
	align-items: center;
	justify-content: space-between;
}

#title-div>h2 {
	margin-top: 15px;
	margin-left: 15px;
	font-weight: bold;
}

#wrap {
	width: 1200px;
	height: 850px;
	margin: auto;
	padding : 10px;
}
#content-div{
	width: 100%;
	height: 80%;
	padding: 10px;
}
#content-add-form{
	width:100%;
	height: 80%;
}
#timeOptions{
	display: flex;
	align-items: center;
	flex-wrap: nowrap;
}
#timeOptions label{
	font-size: 12px;
}
.content-div-1{
	width: 32%;
	height: 60%;
	padding: 5px;
	margin: auto;
	border-radius: 8px;
	box-shadow: 5px 3px 3px gray;
	display: inline-block;
}
#content-add-sect{
	display:flex;
	align-items: center;
}
#btn-div{
	margin-top: 20px;
}

</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />
	<div id="wrap">
	<c:choose>
		<c:when test="${ roomCnt lt 3 }">
			<div id="title-div">
				<h2>객실추가</h2>
			</div>
			<div id="content-div">
				<form id="content-add-form" action="${ path }/insert.rooms" enctype="multipart/form-data" method="post">
				<input type="hidden" value="${ hotelNo }" name="hotelNo" >
				<section id="content-add-sect">
					<div class="content-div-1">
						<div class="form-group">
						  <label>객실이름</label>
						  <input type="text" class="form-control" maxlength="25" name="roomName" oninput="testVal(this, roomName);" required >
						</div>
						
						<div class="form-group">
						  <label>최대인원</label>
						  <input type="text" class="form-control" maxlength="3" name="maxPeople" oninput="testVal(this, maxPeople);" required >
						</div>
						
						<div class="form-group">
						  <label>객실 사진</label>
						  <input id="attachImg" type="file"  name="roomImg" oninput="testVal(this, roomImg);" required>
						</div>
						
						<div class="form-grop">
							<label>입실시간</label>
							<input type="time" name="in_time" required><br>
							<label>퇴실시간</label>
							<input type="time" name="out_time" required>
						</div>
						
						<div class="form-group">
						  <label>객실 가격</label>
						  <input type="text"  name="roomPrice" maxlength="9" oninput="testVal(this, roomPrice);" required>
						</div>
						
						<div class="form-group">
						  <label>객실 번호</label>
						  <input type="text"  name="roomNum" maxlength="9" oninput="testVal(this, roomNum);" required>
						</div>
					</div>
				</section>
				<div id="btn-div" align="center">
					<button class="btn btn btn-info">객실 추가</button>
				</div>
				</form>
			</div>
		</c:when>
		<c:otherwise>
			<h1>호텔 숙소 등록은 3개 이상 할 수 없습니다.</h1>
			<button type="button" class="btn btn-lg btn-outline-info" onclick="history.back();" >돌아가기</button>
		</c:otherwise>
	</c:choose>	
	</div>
	
	<script>
	const regNameRule = /^[a-zA-Z0-9ㄱ-ㅎㅏ-ㅣ가-힣\s]+$/;
	const regNum = /^[0-9]+$/;
	
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
					if(isNaN($(e).val())){
						alert('올바른 숫자만 입력해주세요.');
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