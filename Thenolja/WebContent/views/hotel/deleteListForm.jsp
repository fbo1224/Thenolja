<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList, thenolja.tb_hotel.model.vo.*"%>
    <%
    	int hotelNo = (int)request.getAttribute("hotelNo");
        ArrayList<Room> rooms = (ArrayList<Room>)request.getAttribute("rooms");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteListForm</title>
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

#title-div > h2 {
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
	height: 70%;
	padding: 10px;
}
.content-div-1:hover {
	border-radius: 10px;
	border: 1px solid gray;
	box-shadow: 5px 3px 3px gray;
}

#content-add-sect{
	display:flex;
	align-items: center;
	height: 100%;
}
#btn-div{
	margin-top: 10px;
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>
	<div id="wrap">
	<%if(rooms != null && rooms.isEmpty()) {%>
		<h3>등록된 객실이 없습니다.</h3>
	<%} else { %>
	<div id="title-div">
		<h2>등록된 객실들</h2>
	</div>
	<div id="content-div">
		<section id="content-add-sect">
		<%for(Room r: rooms){ %>
			<div class="content-div-1" id="<%= r.getRoomNo() %>">
				<div class="form-group">
				  <label>객실이름</label>
				  <input type="text" class="form-control" name="roomName" readonly value="<%= r.getRoomName() %>" >
				</div>
				
				<div class="form-group">
				  <label>최대인원</label>
				  <input type="text" class="form-control"  name="maxPeople" readonly value="<%= r.getMaxPeople() %>" >
				</div>
				
				<div class="form-group">
				  <label>객실 사진</label>
				  <img width="100px" height="100px" src="<%= r.getRoomImgPath()  %>" alt="beforeImg">
				</div>
				
				<div class="form-grop">
					<label>입실시간</label>
					<input type="time" name="in_time" readonly value="<%= r.getCheckInTime() %>" ><br>				
					<label>퇴실시간</label>
					<input type="time" name="out_time" readonly value="<%= r.getCheckOutTime() %>" >
				</div>
				
				<div class="form-group">
				  <label>객실 가격</label>
				  <input type="text"  name="roomPrice" readonly value="<%= r.getRoomPrice() %>">
				</div>
				
				<div class="form-group">
				  <label>객실 번호</label>
				  <input type="text"  name="roomNum" readonly  value="<%= r.getRoomNum() %>">
				</div>
				<div id="btn-div" align="center">
					<button type="button" class="btn btn-sm btn-danger roomBtn" data-toggle="modal" data-target="#myModal" onclick="">객실삭제</button>
				</div>
			</div>
			<%} %>
		</section>
	</div>
	<%} %>
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
			
			$('.deleteRoomBtn').click(function(e){ // 의미없음
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