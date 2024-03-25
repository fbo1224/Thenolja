<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="thenolja.tb_hotel.model.vo.*" %>    
    
    <%
     	DetailHotel dh = (DetailHotel)request.getAttribute("hotelDetail");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

#detail-content{
	width: 100%;
	height: 100%;
	padding-bottom: 50px;
}
#detail-wrap {
	width: 1200px;
	height: auto;
	margin: auto;
}
#content-title {
	display: flex;
	align-items: center;
	justify-content: space-around;
}
#detail-content-btns{
	float: right;
}
#detail-content-title{
	margin: auto;
	margin-top: 30px;
	width: 80%;
}
#detail-content-img{
	margin: auto;
	width: 80%;
	box-shadow: 2px 2px 2px gray;
}
#detail-content-img > img{
	width:100%;
	height: 500px;
}
#detail-content-imgInfo{
	margin: auto;
	width: 80%;
	display: flex;
	justify-content: space-between;
	height: 50px;
	border-bottom: 1px solid gray;
}
#detail-content-services{
	margin: auto;
	width: 80%;
	height: 50px;
	border-bottom: 1px solid gray;
}
#detail-content-services > ul {
	margin: 0px;
}

#detail-content-services li {
	padding: 10px;
}
#detail-content-rooms {
	margin: auto;
	width: 80%;
	
}
.content-rooms-card{
	width: 80%;
	height: 28%;
	margin: auto;
	border: 1px solid gray;
	border-radius: 12px;
	display: flex;
	align-items: center;
	justify-content: space-between;
	margin-top: 10px;
	padding: 10px;
}
.content-rooms-card:hover{
	cursor: pointer;
	scale: 105%;
	border-color: skyblue;
}
.content-rooms-card img {
	width: 30%;
	height: 90%;
	border-top-left-radius: 10px;
	border-bottom-left-radius: 10px;
	box-shadow: 2px 2px 2px gray;
}
#detail-content-intro, #detail-content-cancel {
	width: 80%;
	text-align: center;
	margin: auto;
	border-bottom: 1px solid gray;
}
#detail-content-intro, #detail-content-cancel h3 {
	margin-top: 10px;
}
#detail-content-review {
	width: 80%;
	margin: auto;
	padding: 10px;
	border-top: 1px solid gray;
	border-bottom: 1px solid gray;
}
.content-review-1 {
	width: 60%;
	height: 40%;
	margin: auto;
	margin-top: 15px;
	border-radius: 12px;
	padding: 10px;
}
.review-1-div {
	display: flex;
	justify-content: space-between;
	margin: 0px 3px;	
}
#detail-content-imgInfo span{
	padding: 3px;
}
.content-rooms-card div {
	padding: 5px;
	font-size: 14px;
}
.room-infos {
	width: 40%;
}

</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div id="detail-wrap">
		<%@ include file="./common/searchForm.jsp" %>
		<%if(dh != null) { %>
		<div id="detail-content">
			<div id="detail-content-btns">
				<button class="btn btn-sm btn-primary" >예약하기</button>
				<button class="btn btn-sm btn-primary" >비회원예약하기</button>
			</div>
			
			<div id="detail-content-title">
				<h3>
					<span><%= dh.getHotelName() %></span> <span>호텔</span>
				</h3>
			</div>
			<div id="detail-content-img">
				<img src="<%= dh.getHotelPath() %>" alt="pic">
			</div>
			
			<div id="detail-content-imgInfo">
				<div>
					 <span>★</span>
					 <span><%= dh.getCountReviews() %>개의 리뷰</span>
					 <span>리뷰조회</span>
				</div>
				<div>
					<span><%= dh.getHotelCate() %></span>
				</div>
			</div>
			
			<div id="detail-content-services">
				<ul>
					<%for(ServiceList sl : dh.getSerList()) { %>
						<li><%= sl.getServiceName() %></li>
					<%} %>
					
				</ul>
			</div>
			
			<div id="detail-content-rooms">
				<h3 style="text-align: center; margin-top: 5px;">객실 선택</h3>
					<%for(RoomInfo ri : dh.getRoomList()) { %>
					<div class="content-rooms-card">
						<img src="<%= ri.getRoomImg() %>">
						<div class="room-infos">
							<h4><%= ri.getRoomName() %></h4>
							<p>입실시간 : <%= ri.getCheckInTime() %></p>
							<p>퇴실시간 : <%= ri.getCheckOutTime() %></p>
							<p>가격 : <%= ri.getRoomPrice() %></p>
						</div>
						<div>
							<p>쿠폰적용가능</p>
							<button class="btn btn-sm btn-info">객실 예약</button>
						</div>
					</div>			
					<%} %>
			</div>
			
			<div id="detail-content-intro">
				<h3>숙소소개</h3>
				<p><%= dh.getHotelIntro() %></p>
			</div>
			
			<div id="detail-content-cancel">
				<h3>예약 취소 및 환불 규정</h3>
				<p>
				    자세한 사항은 더놀자 홈페이지 고객센터의 자주 묻는 질문에서 확인해주세요.
				</p>
			</div>
			
			<div>
				<h3 style="text-align: center; margin-top: 10px;">이용자 후기</h3>
				<div id="detail-content-review">
					<%for(HotelReview hr : dh.getReviewList() ){ %>
					<div class="content-review-1 card">
						<div class="review-1-div">
							<span><%= hr.getReserName() %></span><span><%= hr.getCreateDate() %></span>
						</div>
						<div>
							<span><%= hr.getReviewContent() %></span>
						</div>
					</div>
					<%} %>
				</div>
			</div>
			
		</div>
		<%} else{ %>
			<h1>찾을 수 없습니다.</h1>
		<%} %>
	</div>
</body>
</html>