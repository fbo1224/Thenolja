<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	int roomNo = (int)request.getAttribute("roomNo");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateRoom Form</title>
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
	<%@ include file="../common/menubar.jsp"%>
	<div id="wrap">
		<div id="title-div">
			<h2>객실정보수정</h2>
		</div>
		<div id="content-div">
			<form id="content-add-form" action="" enctype="multipart/form-data" method="post">
			<input type="hidden" value="" name="hotelNo" >
			<section id="content-add-sect">
				<div class="content-div-1">
					<div class="form-group">
					  <label>객실이름</label>
					  <input type="text" class="form-control" name="roomName" required >
					</div>
					
					<div class="form-group">
					  <label>최대인원</label>
					  <input type="text" class="form-control"  name="maxPeople" required >
					</div>
					
					<div class="form-group">
					  <label>객실 사진</label>
					  <input type="file"  name="roomImg" >
					</div>
					
					<div class="form-grop">
						<label>입실시간</label>
						<input type="time" name="in_time" required><br>				
						<label>퇴실시간</label>
						<input type="time" name="out_time" required>
					</div>
					
					<div class="form-group">
					  <label>객실 가격</label>
					  <input type="text"  name="roomPrice" required>
					</div>
					
					<div class="form-group">
					  <label>객실 번호</label>
					  <input type="text"  name="roomNum" required>
					</div>
				</div>
				</section>
				<div id="btn-div" align="center">
					<button class="btn btn btn-info">객실 추가</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>