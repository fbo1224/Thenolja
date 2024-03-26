<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	int hotelNo = (int)request.getAttribute("hotelNo");
    	int roomCnt = (int)request.getAttribute("roomCnt");
    	
    	System.out.println("hotelNO " + hotelNo);
    	System.out.println("roomCnt " + roomCnt);
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
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
[class *= content-div]{
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
.delBtn{
	float: right;
}

</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>
	<div id="wrap">
	<%if(roomCnt < 3){ %>
		<div id="title-div">
			<h2>숙소추가하기</h2>
		</div>
		<div id="content-div">
			<form id="content-add-form" action="<%= contextPath %>/insert.rooms" enctype="multipart/form-data" method="post">
			<input type="hidden" value="<%= hotelNo %>" name="hotelNo" >
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
	<%} else { %>
		<h1>호텔 숙소 등록은 3개 이상 할 수 없습니다.</h1>
		<button onclick="history.back();" >돌아가기</button>
	<%} %>	
	</div>
</body>
</html>