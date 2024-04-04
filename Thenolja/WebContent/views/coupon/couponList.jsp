<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, thenolja.coupon.model.vo.Coupon" %>
<%
	ArrayList<Coupon> list = (ArrayList<Coupon>)request.getAttribute("couponList");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>더놀자 > 쿠폰 > 목록</title>

<style>

/* 카테고리 영역 layout 기준 START */
.nav-area{
	margin-top:60px;
}

.coupon-cate{
    width: 150px;
    height: 50px;
    display: table-cell;
  }

.coupon-cate > a{
      display: block;
      width: 100%;
      height: 100%;
      text-decoration: none;
      color: black;
      font-weight: bold;
      font-size: 20px;
      line-height: 50px;
      
}

.coupon-cate-item{ 
	 border-bottom: 4px solid;
}

.coupon-cate > a:hover{
    font-size: 19px;
    color: #17a2b8;
}

.outer{
	display : inline-table;
  	width  : 1200px;
  	height : 600px;
  	margin : auto;
  	border :  1px ridge;
  	text-align:center;
	position: relative;
}
/* 카테고리 영역 layout 기준 START */


/* 이벤트 게시판 layout START */
.thumb-list{
	position:relative;
	margin: 160px 100px 0;
    display: flex;
    flex-wrap: wrap;		/* 이미지 일정하게 내리기 */
	list-style-type: none;	/* li태그 점 없애기 */
	padding-left:60px;
}

.thunmb-list li{	
	width:440px;
	float:left;
	position:relative;
}

.thumb-list.coupon li .txt-box .title {
    margin-top: 4px;
}


.thumb-list li .txt-box .title {
    overflow: hidden;
    display: block;
    color: #1a1d1d;
    font-size: 24px;
    line-height: 35px;
    text-overflow: ellipsis;
    white-space: nowrap;
}


.thumb-list.coupon li .img-box {
   width: 380px;
   height: 170px;
   border-radius: 16px;
   overflow: hidden;
   background-color: #ededed;
   margin: 50px 12px auto 60px;
}

/* 게시판 이미지 크기 등 설정 */
.thumb-list li .img-box img {
    /* width: 100%; */
    height: 100%;
    object-fit: cover;
    transform:scale(1);
    transition: all 0.5s;
}

.thumb-list li .txt-box {
    padding: 30px;
}

.thumb-list.coupon li .txt-box .category-box {
    display: flex;
}

/* svg css적용 */
.svg-icon-wrapper{
	float:left;
    /* width: 100px; */
    margin-top: 50px;	
}

.svg-item{
	position: relative;
	height:30px;
	width:70px;
}

/* 쿠폰 컨텐트(제목) css적용 */
.coupon-contents{
	margin-right:13%;
	font-family: NotoSansKR, '맑은고딕', Malgun Gothic, dotum, '돋음', arial, sans-serif;
	font-weight: revert;	
}

/* 쿠폰 사용기한 css적용 */
.coupon-use-date{
	display: block;
    position: relative;
    margin-left: 260px;
    margin-top:75px;
    font-size: 13px;	/* 폰트사이즈 */
    font-weight:bolder;	/* 폰트굵기 */
    opacity:0.7; 		/* 글씨 투명도 조절 */
}

/* 정렬 selectbox css적용 */
.coupon-list-order-item{
    position: relative;
    float: right;
    margin: 60px;	
}

.coupon-list-order-item-selectbox{
    border-radius: 50px;
    border: none;
    font-size: 13px;
    width: 74px;
    font-weight: bolder;	
}

</style>


</head>
<body>

<%@ include file="../common/menubar.jsp" %>

   <br>
   	 <h2 align="center">쿠폰 발행</h2>
    <br>
    
    <!-- 쿠폰발행 컨텐츠 전체 영역 START -->
    <div class="" style="margin-left:100px;">
	    <!-- 카테고리 메뉴영역 START -->
		<div class="nav-area" align="center">
		    <div class="coupon-cate"><a class="coupon-cate-item" href="#" style="width: 85px;">모텔</a></div>
		    <div class="coupon-cate"><a class="coupon-cate-item" href="#" style="width: 85px;">호텔</a></div>
		    <div class="coupon-cate"><a class="coupon-cate-item" href="#" style="width: 85px;">글램핑</a></div>
		 	<div class="coupon-cate"><a class="coupon-cate-item" href="#" style="width: 85px;">팬션</a></div> 
		 	<div class="coupon-cate"><a class="coupon-cate-item" href="#" style="width: 85px;">카라반</a></div> 
	 	</div>
	 	<!-- 카테고리 메뉴영역 END -->
	 	
	 	<!-- 정렬 SELECTBOX 영역 START -->
	 	<div class="coupon-list-order-wrapper">
	 		<div class="coupon-list-order-item">
	 			<!-- 최신순 : createDate기준으로 ASC정렬하여 조회 / 오래된 순 : createDate기준으로 DESC정렬하여 조회 -->
	 			<select class="coupon-list-order-item-selectbox">
	 				<option name="" value="ASC">최신순</option>
	 				<option name="" value="DESC">오래된순</option>
	 			</select>
	 			
	 			<a id="btn_reg" class="btn btn-primary" href="<%=contextPath%>/views/coupon/couponReg.jsp" role="button" style="background-color:#17a2b8;">발행하기</a>
	 			
	 		</div>	
	 	</div>
	 	<!-- 정렬 SELECTBOX 영역 END -->
	 	
	 	
	 	<!-- 쿠폰컨텐츠 영역 START -->
	 	<div class="contents-area" algin="center">
			<ul id="evtIng" class="thumb-list coupon">
				<% for( Coupon n : list ) { %>
				<li>
					<div class="img-box">
					<img class="" src=""></img>
						<div class="svg-icon-wrapper">
							<svg class="svg-item" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-envelope-heart" viewBox="0 0 14 14">
		  						<path fill-rule="evenodd" d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2zm2-1a1 1 0 0 0-1 1v.217l3.235 1.94a2.8 2.8 0 0 0-.233 1.027L1 5.384v5.721l3.453-2.124q.219.416.55.835l-3.97 2.443A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741l-3.968-2.442q.33-.421.55-.836L15 11.105V5.383l-3.002 1.801a2.8 2.8 0 0 0-.233-1.026L15 4.217V4a1 1 0 0 0-1-1zm6 2.993c1.664-1.711 5.825 1.283 0 5.132-5.825-3.85-1.664-6.843 0-5.132"/>
							</svg>					
						</div>
						<!-- 쿠폰 내용 노출되느 부분 START -->
						<div>
							<h5 class="coupon-contents"><%=n.getCouponContent() %></h5>
							<!-- 어떤 값으로 세팅해줘야 하는지..? 결정안됨.. -->
							<span class="coupon-use-date">사용기한 : 7일 후</span>
						</div>
						<!-- 쿠폰 내용 노출되느 부분 END -->
					</div>
				</li>
				<% } %>
			</ul>	 	
	 	</div>
	 	<!-- 쿠폰컨텐츠 영역 END -->
	 	
	 </div>
	<!-- 실제 구현 시 반복할 부분 END -->

</body>
</html>