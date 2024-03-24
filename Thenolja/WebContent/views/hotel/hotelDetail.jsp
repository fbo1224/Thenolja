<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
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
	height: 600px;
}
.content-rooms-card{
	width: 80%;
	height: 28%;
	margin: auto;
	border: 1px solid gray;
	border-radius: 12px;
	display: flex;
	align-items: center;
	justify-content: space-evenly;
	margin-top: 10px;
}
.content-rooms-card img {
	width: 30%;
	height: 90%;
	border-radius: 10px;
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
	height: 250px;
	margin: auto;
	border-top: 1px solid gray;
	border-bottom: 1px solid gray;
}
.content-review-1 {
	width: 60%;
	height: 40%;
	margin: auto;
	margin-top: 15px;
	border-radius: 12px;
}
.review-1-div {
	display: flex;
	justify-content: space-between;
	margin: 0px 3px;	
}
#detail-content-imgInfo span{
	padding: 3px;
}

</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div id="detail-wrap">
		<%@ include file="./common/searchForm.jsp" %>
		
		<div id="detail-content">
			<div id="detail-content-btns">
				<button class="btn btn-sm btn-primary" >예약하기</button>
				<button class="btn btn-sm btn-primary" >비회원예약하기</button>
			</div>
			
			<div id="detail-content-title">
				<h3>
					<span>마리안느</span> <span>호텔</span>
				</h3>
			</div>
			<div id="detail-content-img">
				<img src="resources/img/pepe4.jpg" alt="pic">
			</div>
			
			<div id="detail-content-imgInfo">
				<div>
					<span>★</span>
					<span>993개의 리뷰</span>
					<span>리뷰조회</span>
				</div>
				<div>
					<span>호텔/특급</span>
				</div>
			</div>
			
			<div id="detail-content-services">
				<ul>
					<li>WIFI</li>
					<li>금연</li>
					<li>헬스장</li>
					<li>에어컨</li>
					<li>주차장</li>
					<li>반려견동반</li>
					<li>엘레베이터</li>
					<li>PC</li>				
				</ul>
			</div>
			
			<div id="detail-content-rooms">
				<h3 style="text-align: center; margin-top: 5px;">객실 선택</h3>
				<div class="content-rooms-card">
					<img src="resources/img/pepe3.jpg">
					<div>
						<h3>오션뷰 1호실</h3>
						<p>입실 16:00</p>
						<p>퇴실 11:00</p>
					</div>
					<div>
						<p>쿠폰적용가능</p>
						<button class="btn btn-sm btn-info">객실 예약</button>
					</div>
				</div>
				
				<div class="content-rooms-card">
					<img src="resources/img/pepe4.jpg">
					<div>
						<h3>오션뷰 1호실</h3>
						<p>입실 16:00</p>
						<p>퇴실 11:00</p>
					</div>
					<div>
						<p>쿠폰적용가능</p>
						<button class="btn btn-sm btn-info">객실 예약</button>
					</div>
				</div>
				
				<div class="content-rooms-card">
					<img src="resources/img/pepe5.jpg">
					<div>
						<h3>오션뷰 1호실</h3>
						<p>입실 16:00</p>
						<p>퇴실 11:00</p>
					</div>
					<div>
						<p>쿠폰적용가능</p>
						<button class="btn btn-sm btn-info">객실 예약</button>
					</div>
				</div>
			</div>
			
			<div id="detail-content-intro">
				<h3>숙소소개</h3>
				<p>
				    강문해변 앞에 자리 잡아 객실에서 드넓고 아름다운 바다를 감상할 수 있습니다.<br>
				    아름다운 대자연과 어우러지는 특별하고도 환상적인 경험을 느낄 수 있습니다.
				</p>
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
					<div class="content-review-1 card">
						<div class="review-1-div">
							<span>user01</span><span>골드</span>
						</div>
						<div>
							<span>청결하고 사장님이 친절하셔서 부담없이 이용했습니다!</span>
						</div>
					</div>
					<div class="content-review-1 card">
						<div class="review-1-div card-body">
							<span>user02</span><span>실버</span>
						</div>
						<div >
							<span>청결하고 사장님이 친절하셔서 부담없이 이용했습니다!</span>
						</div>
					</div>
				</div>
			</div>
			
		</div>
		
	</div>
</body>
</html>