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
	border-radius: 10px;
	box-shadow: 2px 2px 2px gray;
}
#detail-content-img > img{
	width:100%;
	height: 500px;
	border-radius: 10px;
}
#detail-content-imgInfo{
	margin: auto;
	width: 80%;
	display: flex;
	justify-content: space-between;
	height: 40px;
	border-bottom: 1px solid gray;
	padding: 10px;
}
#detail-content-services{
	margin: auto;
	width: 80%;
	height: 50px;
	border-bottom: 1px solid gray;
}
#detail-content-services > ul {
	list-style: none;
	margin: 0px;
}

#detail-content-services li {
	padding: 10px;
	float: left;
}
#detail-content-rooms {
	margin: auto;
	width: 80%;
	padding: 10px;
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
	scale: 102%;
	cursor: pointer;
	border-color: skyblue;
}
.content-rooms-card img {
	width: 30%;
	height: 90%;
	border-radius: 10px;
	box-shadow: 2px 2px 2px gray;

}
#detail-content-intro {
	border-top: 1px solid gray;
}
#detail-content-intro, #detail-content-cancel {
	width: 80%;
	text-align: center;
	margin: auto;
	border-bottom: 1px solid gray;
}
#detail-content-intro, #detail-content-cancel {
	padding: 10px;
}
#detail-content-review {
	width: 80%;
	height: auto;
	overflow:hidden;
	margin: auto;
	padding: 10px;
	border-top: 1px solid gray;
	border-bottom: 1px solid gray;
}
.content-review-1 {
	width: 60%;
	height: 80px;
	margin: auto;
	margin-top: 15px;
	border-radius: 12px;
	padding: 10px;
	float:left;
}
.review-1-div {
	display: flex;
	justify-content: space-between;
	margin: 0px 3px;	
}
.review-1-content {
	font-size: 14px;
}
.admins {
	float: right;
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


	/*동혁 시작*/
{
    /*초기화*/
    margin: 0;
    padding: 0;
}

#favorite{

    /*100% 창 높이*/
    height: 100vh;
    /*사용자정의: var 함수로 핸들링*/
    --c: #ff6b81;
}

svg{
    width: 30px;
}

#heart{
    /*색 보충*/
    fill: #eee;

    /*stroke속성은 선, 문자, 원소등의 테두리에대해서 디자인 가능*/
    stroke: var(--c);
    /*선의 넓이*/
    stroke-width: 40px;
    /*선을 점선으로 설정, 점선의 길이 설정*/
    stroke-dasharray: 3000;
    /*displacement of line*/
    stroke-dashoffset: 3000;
    /*끝점은 둥글게*/
    stroke-linecap: round;
}

/*checkbox를 클릭할 경우 애니메이션 실행*/
#checkbox:checked + svg #heart{
    /*애니메이션실행: 애니메이션이름, 실행시간, 선형 마지막 정지한 프레임*/
    animation: drawHeart 1s linear forwards;
}

#checkbox:checked ~ span{
    /*애니메이션실행: 애니메이션이름, 실행시간, 선형 마지막 정지한 프레임*/
    animation: blink 0.5s ease-in-out forwards;
    /*애니메이션 딜레이*/
    animation-delay: 0.8s ;
}

#checkbox:checked + svg{
     /*애니메이션실행: 애니메이션이름, 실행시간, 선형 마지막 정지한 프레임*/
    animation: beat 1s linear forwards;;
}
#label{
    /*마우스 heart로 이동시 마우스 커서변동*/
    cursor: pointer;
}

/*애니메이션 효과 설정*/
/*heart 애니메이션*/
@keyframes drawHeart{
    0%{
        stroke-dashoffset: 2600;
    }
    80%{
        fill: #eee;
        stroke-dashoffset: 0;
    }
    100%{
        fill: var(--c);
        stroke-dashoffset: 0;
    }

}
/*점 애니메이션*/
@keyframes blink{
    0%{
        transform: translate(-50%, -50%) scale(0.5);
        opacity: 0.8;
    }
    80%{
        transform: translate(-50%, -50%) scale(1);
        opacity: 1;
    }
    100%{
        transform: translate(-50%, -50%) scale(1.1);
        opacity: 0;
    }
}

/*두근두근 애니메이션*/
@keyframes beat {
    0%{
        transform: scale(1);
    }
    70%{
        transform: scale(1);
    }
    80%{
        transform: scale(1.2);
    }
    100%{
        transform: scale(1);
    }
}
#favorite{
	float:right;
	margin-top:10px;
}
	/*동혁 끝*/

</style>
</head>
<body>
	<%@ include file="./common/searchForm.jsp" %>
	<div id="detail-wrap">
		<%if(dh != null) { %>
		<div id="detail-content">
			<div id="detail-content-btns">
			<a href="<%=contextPath%>/insertReservation?hotelNo=<%= dh.getHotelNo() %>">
				<button class="btn btn-sm btn-primary" >예약하기</button></a>
			<a href="<%=contextPath%>/nonInsertReservation">
				<button class="btn btn-sm btn-primary" >비회원예약하기</button></a>
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
					 <span><%= dh.getCountReviews() %> 개의 리뷰</span>
					 <span><a href="#reviews">리뷰조회</a></span>
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
				
				<!-- 동혁 시작-->
				<% if(loginUser != null) { %> 
					<div id="favorite">
						<form method="get" action="">
							<label for="checkbox" id="label">
						        <input type="checkbox" id="checkbox" name="heart" value="heart" hidden onclick="JJIM();">
						        <svg t="1689815540548" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2271"><path d="M742.4 101.12A249.6 249.6 0 0 0 512 256a249.6 249.6 0 0 0-230.72-154.88C143.68 101.12 32 238.4 32 376.32c0 301.44 416 546.56 480 546.56s480-245.12 480-546.56c0-137.92-111.68-275.2-249.6-275.2z" fill="#231F20" p-id="2272" id="heart"></path></svg>
						    </label>
					    </form>
					</div>
					
					<script>
						function JJIM(){
							
						}
					</script>
				<% } %>
				<!-- 동혁 끝 -->
			</div>
			
			<div id="detail-content-rooms">
				<h3 style="text-align: center; margin-top: 5px;">객실</h3>
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
							<%-- 객실예약 기능 추가 예정 --%>
							<a href="<%=contextPath%>/insertReservation">
							<button class="btn btn-sm btn-info">객실 예약</button></a>
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
					<a name="reviews"></a>
					<%for(HotelReview hr : dh.getReviewList() ){ %>
					<div class="content-review-1 card" id="<%= hr.getReserNo() %>">
						<div class="review-1-div">
							<span>작성자 : <%= hr.getReserName() %> </span>
							<span>작성일 : <%= hr.getCreateDate() %> </span>
							<span>리뷰 점수 <%= hr.getReviewScore() %></span>
						</div>
						<div class="review-1-content">
							<span><%= hr.getReviewContent() %></span>
						</div>
					</div>
					<%} %>
				</div>
			</div>
			
		</div>
		<%} else { %>
			<h1>찾을 수 없습니다.</h1>
		<%} %>
	</div>
	
	<script>
		$(function(){
			$.ajax({
				url: "commentAdmin.jqAjax",
				data: {
					hotelNo: '<%= dh.getHotelNo() %>'
				},
				type: 'get',
				success: function(result){
					
					if(result != null){
						for(let i = 0; i < result.length; i++){
							$('.content-review-1').each(function(idx, ele){
								if($(ele).attr('id') == result[i].reserNo){
									// console.log(result);
									$(ele).after('<div class="content-review-1 card admins" style="border: 1px solid skyblue;" >'
												+'<div class="review-1-div">'
												  +'<p>작성자 : '+ result[i].nickname +'</p>'
												  +'<p>작성일 : '+ result[i].createDate +'</p>'   
											    +'</div>'
											    +'<div class="review-1-content" >'
											    	+'<span>'+ result[i].commentContent +'</span>'
											    +'</div>'
											+'</div>');
								
								}
							});	
						}
					}
					
				},
				error : function(result){
					console.log(result);
				},
				
			});
			
		});
	</script>
	

	
	
	
</body>
</html>