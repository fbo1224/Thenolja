<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="thenolja.tb_hotel.model.vo.*, java.util.Calendar, java.text.SimpleDateFormat" %>   
    
    <%
     	DetailHotel dh = (DetailHotel)request.getAttribute("hotelDetail");
		
		SimpleDateFormat newForm = new SimpleDateFormat("yy/MM/dd");
		
		Calendar cal = Calendar.getInstance();
		
		//오늘 날짜
		String today = newForm.format(cal.getTime());

		// 내일 날짜
		cal.add(Calendar.DATE, 1);
		String tomo = newForm.format(cal.getTime());
		
		String dateRangeForm = today + " ~ " + tomo;
		
		System.out.println(dateRangeForm);
		// 해당 호텔 위치
		System.out.println(dh.getHotelLocation());
		
		int defaultPeople = 2;
		// Date
		// people 2 기본적으로 2로 설정
		// location
    	
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
#favorite{

    /*100% 창 높이*/
    <%--height: 100vh;--%>
    /*사용자정의: var 함수로 핸들링*/
    --c: #ff6b81;
    float:right;
	margin-top:10px;
}

svg{
    width: 30px;
}

#heart{
    /*색 보충*/
    fill: lightgray;

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
        fill: #lightgray;
        stroke-dashoffset: 0;
    }
    100%{
        fill: var(--c);
        stroke-dashoffset: 0;
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
	/*동혁 끝*/

</style>
</head>
<body>
	<%@ include file="./common/searchForm.jsp" %>
	<div id="detail-wrap">
		<%if(dh != null) { %>
		<div id="detail-content">
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
					<% } %>
					
				</ul>
				
				<!-- 동혁 시작-->
				<% if(loginUser != null) { %> 
					<div id="favorite">
						<label for="checkbox" id="label"></label>
					</div>
					
					<script>
						window.onload = function(){
							$.ajax({
								url : 'selectHeart',
								type : 'get',
								data : {
				            		   memNo : <%= loginUser.getMemNo() %>,
				            		   hotelNo : <%= dh.getHotelNo() %>
				            		   },
								success: function(result){
									console.log(result);
									let resultStr;
									
									if(result != 0){
										resultStr = '<input type="checkbox" id="checkbox" name="heart" value="heart" onclick="heartClick();" checked hidden>'+
								        '<svg t="1689815540548" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2271"><path d="M742.4 101.12A249.6 249.6 0 0 0 512 256a249.6 249.6 0 0 0-230.72-154.88C143.68 101.12 32 238.4 32 376.32c0 301.44 416 546.56 480 546.56s480-245.12 480-546.56c0-137.92-111.68-275.2-249.6-275.2z" fill="#231F20" p-id="2272" id="heart"></path></svg>';
									} else {
										resultStr = '<input type="checkbox" id="checkbox" name="heart" value="heart" onclick="heartClick();" hidden>'+
								        '<svg t="1689815540548" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2271"><path d="M742.4 101.12A249.6 249.6 0 0 0 512 256a249.6 249.6 0 0 0-230.72-154.88C143.68 101.12 32 238.4 32 376.32c0 301.44 416 546.56 480 546.56s480-245.12 480-546.56c0-137.92-111.68-275.2-249.6-275.2z" fill="#231F20" p-id="2272" id="heart"></path></svg>';
									}
									
									$('#label').html(resultStr);
								}
							})
						}
							
					// 클릭할 시 insert, delete 시작
		               function heartClick(){
		            	   const cb = document.getElementById('checkbox');
		            	   
			            	   var hc = '';
			            	   if(cb.checked == true){
			                       hc = 'insertheart';
			                       
			            	   } else {
			            		   hc = 'deleteheart';
			            	   }
		                   
		            	   $.ajax({
		            		   url : hc,
		            		   type: 'post',
		            		   data : {
		            		   memNo : <%= loginUser.getMemNo() %>,
		            		   hotelNo : <%= dh.getHotelNo() %>
		            		   },
		            		   success: function(result){
		            			   console.log(result);
		            		   },
		            		   error: function(e){
		           				console.log(e);
		           			}
		            	   })
		                }
		            // 클릭할 시 insert, delete 끝
		            
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
							<%if(searchDataForm != null) {%>
								<p>쿠폰적용가능</p>
								<a href="<%=contextPath%>/insertReservation?hotelNo=<%= dh.getHotelNo()%>&roomNo=<%= ri.getRoomNo() %>&daterange=<%= searchDataForm.getDaterange()%>&location=<%= searchDataForm.getLocation() %>&people=<%= searchDataForm.getMaxPeople()%>">
								<button class="btn btn-sm btn-info">객실 예약</button></a>
								<a href="<%=contextPath%>/nonInsertReservation?hotelNo=<%= dh.getHotelNo()%>&roomNo=<%= ri.getRoomNo() %>&daterange=<%= searchDataForm.getDaterange()%>&location=<%= searchDataForm.getLocation() %>&people=<%= searchDataForm.getMaxPeople()%>">
								<button class="btn btn-sm btn-primary" >비회원예약하기</button></a>
							<%} else { %>
								<p>쿠폰적용가능</p>
								<a href="<%=contextPath%>/insertReservation?hotelNo=<%= dh.getHotelNo()%>&roomNo=<%= ri.getRoomNo() %>&daterange=<%= dateRangeForm %>&location=<%= dh.getHotelLocation() %>&people=<%= defaultPeople %>">
								<button class="btn btn-sm btn-info">객실 예약</button></a>
								<a href="<%=contextPath%>/nonInsertReservation?hotelNo=<%= dh.getHotelNo()%>&roomNo=<%= ri.getRoomNo() %>&daterange=<%= dateRangeForm %>&location=<%= dh.getHotelLocation() %>&people=<%= defaultPeople %>">
								<button class="btn btn-sm btn-primary" >비회원예약하기</button></a>
							<%} %>
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
	</div>
			
	</div>
		<%} else { %>
			<h1>찾을 수 없습니다.</h1>
		<%} %>
	</div>
	
	<style>
		body{
		    background-color: #f4f7f6;
		    margin-top:20px;
		}
		.card {
		    background: #fff;
		    transition: .5s;
		    border: 0;
		    margin-bottom: 30px;
		    border-radius: .55rem;
		    position: relative;
		    width: 100%;
		    box-shadow: 0 1px 2px 0 rgb(0 0 0 / 10%);
		}
		.chat-app .people-list {
		    width: 280px;
		    position: absolute;
		    left: 0;
		    top: 0;
		    padding: 20px;
		    z-index: 7
		}
		
		.chat-app .chat {
		    border-left: 1px solid #eaeaea
		}
		
		.people-list {
		    -moz-transition: .5s;
		    -o-transition: .5s;
		    -webkit-transition: .5s;
		    transition: .5s
		}
		
		.people-list .chat-list li {
		    padding: 10px 15px;
		    list-style: none;
		    border-radius: 3px
		}
		
		.people-list .chat-list li:hover {
		    background: #efefef;
		    cursor: pointer
		}
		
		.people-list .chat-list li.active {
		    background: #efefef
		}
		
		.people-list .chat-list li .name {
		    font-size: 15px
		}
		
		.people-list .chat-list img {
		    width: 45px;
		    border-radius: 50%
		}
		
		.people-list img {
		    float: left;
		    border-radius: 50%
		}
		
		.people-list .about {
		    float: left;
		    padding-left: 8px
		}
		
		.people-list .status {
		    color: #999;
		    font-size: 13px
		}
		
		.chat .chat-header {
		    padding: 15px 20px;
		    border-bottom: 2px solid #f4f7f6
		}
		
		.chat .chat-header img {
		    float: left;
		    border-radius: 40px;
		    width: 40px
		}
		
		.chat .chat-header .chat-about {
		    float: left;
		    padding-left: 10px
		}
		
		.chat .chat-history {
		    padding: 20px;
		    border-bottom: 2px solid #fff
		}
		
		.chat .chat-history ul {
		    padding: 0
		}
		
		.chat .chat-history ul li {
		    list-style: none;
		    margin-bottom: 30px
		}
		
		.chat .chat-history ul li:last-child {
		    margin-bottom: 0px
		}
		
		.chat .chat-history .message-data {
		    margin-bottom: 15px
		}
		
		.chat .chat-history .message-data img {
		    border-radius: 40px;
		    width: 40px
		}
		
		.chat .chat-history .message-data-time {
		    color: #434651;
		    padding-left: 6px
		}
		
		.chat .chat-history .message {
		    color: #444;
		    padding: 18px 20px;
		    line-height: 26px;
		    font-size: 16px;
		    border-radius: 7px;
		    display: inline-block;
		    position: relative
		}
		
		.chat .chat-history .message:after {
		    bottom: 100%;
		    left: 7%;
		    border: solid transparent;
		    content: " ";
		    height: 0;
		    width: 0;
		    position: absolute;
		    pointer-events: none;
		    border-bottom-color: #fff;
		    border-width: 10px;
		    margin-left: -10px
		}
		
		.chat .chat-history .my-message {
		    background: #efefef
		}
		
		.chat .chat-history .my-message:after {
		    bottom: 100%;
		    left: 30px;
		    border: solid transparent;
		    content: " ";
		    height: 0;
		    width: 0;
		    position: absolute;
		    pointer-events: none;
		    border-bottom-color: #efefef;
		    border-width: 10px;
		    margin-left: -10px
		}
		
		.chat .chat-history .other-message {
		    background: #e8f1f3;
		    text-align: right
		}
		
		.chat .chat-history .other-message:after {
		    border-bottom-color: #e8f1f3;
		    left: 93%
		}
		
		.chat .chat-message {
		    padding: 20px
		}
		
		.online,
		.offline,
		.me {
		    margin-right: 2px;
		    font-size: 8px;
		    vertical-align: middle
		}
		
		.online {
		    color: #86c541
		}
		
		.offline {
		    color: #e47297
		}
		
		.me {
		    color: #1d8ecd
		}
		
		.float-right {
		    float: right
		}
		
		.clearfix:after {
		    visibility: hidden;
		    display: block;
		    font-size: 0;
		    content: " ";
		    clear: both;
		    height: 0
		}
		
		@media only screen and (max-width: 767px) {
		    .chat-app .people-list {
		        height: 465px;
		        width: 100%;
		        overflow-x: auto;
		        background: #fff;
		        left: -400px;
		        display: none
		    }
		    .chat-app .people-list.open {
		        left: 0
		    }
		    .chat-app .chat {
		        margin: 0
		    }
		    .chat-app .chat .chat-header {
		        border-radius: 0.55rem 0.55rem 0 0
		    }
		    .chat-app .chat-history {
		        height: 300px;
		        overflow-x: auto
		    }
		}
		
		@media only screen and (min-width: 768px) and (max-width: 992px) {
		    .chat-app .chat-list {
		        height: 650px;
		        overflow-x: auto
		    }
		    .chat-app .chat-history {
		        height: 600px;
		        overflow-x: auto
		    }
		}
		
		@media only screen and (min-device-width: 768px) and (max-device-width: 1024px) and (orientation: landscape) and (-webkit-min-device-pixel-ratio: 1) {
		    .chat-app .chat-list {
		        height: 480px;
		        overflow-x: auto
		    }
		    .chat-app .chat-history {
		        height: calc(100vh - 350px);
		        overflow-x: auto
		    }
		}
		.paging-area{
			margin-top: 10px;
			margin-bottom: 10px;
		}
	</style>
	
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />

	<div class="container review-div">
		<div class="row clearfix">
		    <div class="col-lg-12">
		        <div class="card chat-app">
		            <div class="chat">
		                <div class="chat-header clearfix">
		                    <div class="row">
		                        <div class="col-lg-6">
		                            <img src="<%= dh.getHotelPath() %>" alt="avatar">
		                            <div class="chat-about">
		                                <h6 class="m-b-0"><%= dh.getHotelName() %></h6>
		                            </div>
		                        </div>
		                    </div>
		                </div>
		                <a name="reviews"></a>
		                <div class="chat-history">
		                    <ul class="m-b-0" id="review-ul">
		                    </ul>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
		<div class="paging-area" align="center">
		</div>
		
	<script>
	
	function reviewAjax(value){
		$('#review-ul').empty();
		$('.paging-area').empty();		
		
		$.ajax({
			url: "reviewList.jqAjax",
			data: {
				hotelNo : '<%= dh.getHotelNo() %>',
				currentPage: value,
			},
			type: 'get',
			success: function(result){
				//console.log(result);
				for(let i = 0; i < result.reviewList.length; i++){
					$('#review-ul').append('<li class="clearfix" id="'+result.reviewList[i].reserNo+'">'
										   +'<div class="message-data">'
											   	+'<span class="message-data-time">'+result.reviewList[i].reserName+'</span>'
				                                +'<span class="message-data-time">'+result.reviewList[i].createDate+'</span>'
				                                +'<span class="message-data-time">'+result.reviewList[i].reviewScore+'</span>'
					                       +'</div>'
										   +'<div class="message my-message">'
										   	  +result.reviewList[i].reviewContent
										   +'</div>'	 
										  +'</li>');
				}
				
				if(result.pi.currentPage > 1){
					$('.paging-area').append(
					'<button class="btn btn btn-outline-info" onclick="reviewAjax(' + (result.pi.currentPage-1) +');">'
						+'이전'
					+'</button>');
				}
				
			   	for(let i = result.pi.startPage; i <= result.pi.endPage; i++){
        			if(result.pi.currentPage != i) {
        				$('.paging-area').append('<button class="btn btn btn-outline-info" onclick="reviewAjax('+ i +')">'
        						+i
        					+'</button>')
        			}
        			else {
        				$('.paging-area').append('<button class="btn btn btn-outline-info"disabled >'
        						+i
        						+'</button>')
        			}
        		}
			   	
			   	// 임시방편
        		if(result.pi.currentPage != result.pi.maxPage && result.pi.currentPage != 1){
        			$('.paging-area').append('<button class="btn btn btn-outline-info" onclick="reviewAjax('+(result.pi.currentPage+1)+')">'
        			+'다음'
        			+'</button>');
        		}
        		
        		
			},
			error: function(result){
				console.log(result);	
			},
			async: false
		});
		
		$.ajax({
			url: "commentAdmin.jqAjax",
			data: {
				hotelNo: '<%= dh.getHotelNo() %>'
			},
			type: 'get',
			success: function(result){
				if(result != null){
					for(let i = 0; i < result.length; i++){
						$('#review-ul').children().each(function(idx, ele){
							if($(ele).attr('id') == result[i].reserNo){
								$(ele).after('<li class="clearfix">'
											+'<div class="message-data text-right">'
							    				+'<span class="message-data-time">작성자 : '+ result[i].nickname +'</span>'
												+'<span class="message-data-time">작성일 : '+ result[i].createDate +'</span>'
							    			+'</div>'
											+'<div class="message other-message float-right">'
												+'<span class="message-data-time">'+ result[i].commentContent +'</span>'
										    +'</div>'
										+'</li>');
							}
						});	
					}
				}
				
			},
			error : function(result){
				console.log(result);
			},
			async: false
		});

	}
	
	$(function(){
		reviewAjax(1);
	});
		
	</script>
	

	
	
	
</body>
</html>