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
.contents-area{
	margin-top:60px;
}

.coupon-cate{
    width: 100%;
    height: 50px;
  }

.coupon-cate > a{
      display: block;
      width: 100%;
      height: 100%;
      text-decoration: none;
      color: #ededed;
      font-size: 20px;
      line-height: 50px;
      
}

.coupon-cate-item{ 
	 border-bottom: 4px solid;
}

.outer{
	display : inline-table;
  	width  : 1200px;
  	height : 600px;
  	margin : auto;
  	text-align:center;
	position: relative;
}
/* 카테고리 영역 layout 기준 START */


/* 이벤트 게시판 layout START */
.thumb-list{
	position:relative;
    display: flex;
    flex-wrap: wrap;		/* 이미지 일정하게 내리기 */
	list-style-type: none;	/* li태그 점 없애기 */
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
   width: 400px;
   height: 170px;
   overflow: hidden;
   float:left;
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
    margin-right: -220px;
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
    border: none;
    font-size: 13px;
    width: 74px;
    font-weight: bolder;	
}

.filed-title{
	display:block;
	float:left;
	font-weight: bolder;
}

.filed-title-content{
	display:block;
	float:left;
	font-weight: bolder;
}

.filed-title-content-inpt{
	display:block;
	float:left;
}

.filed-title-msg{
	display:block;
	float:left;
}

</style>


</head>
<body>

<%@ include file="../common/menubar.jsp" %>

   <br>
   	 <h3 align="left" style="position:relative; margin-left:100px; font-weight:bolder;">쿠폰 발행</h3>
   	 <a id="btn_reg" class="btn btn-primary" href="<%=contextPath%>/views/coupon/couponReg.jsp" role="button" style="background-color:#17a2b8;float:right; margin-right:60px; margin-bottom:10px;">발행하기</a>
    <br>
    
    <!-- 쿠폰발행 컨텐츠 전체 영역 START -->
    <div class="" style="margin-left:100px;">
	    <!-- 경계선영역 START -->
		 <div class="nav-area" align="center">
		    <div class="coupon-cate"><a class="coupon-cate-item" href="javascript(void:0)"></a></div>
	 	</div>
	 	<!-- 경계선영역 END -->
	 	
	 	<!-- 쿠폰정보 입력 영역 START -->
	 	<div class="contents-area">
			<ul id="evtIng" class="thumb-list coupon">
				<li>
					<div class="img-box">
					<img class="" src=""></img>
							<!-- 관리자번호 타이틀 -->
	 						<span class="filed-title">관리자번호</span>
							
							<!-- 관리자번호 입력란 -->
							<div>
								<input type="text" class="filed-title-content-inpt" placeholder="관리자 번호를 입력해주세요.">
							</div>
													
						<!-- 관리자번호 노출되는 부분 END -->
					</div>
					
					<div class="img-box">
					<img class="" src=""></img>
							<!-- 쿠폰명 타이틀 -->
	 						<span class="filed-title">쿠폰명</span>
							
							<!-- 쿠폰명 -->
							<div>
								<input type="text" class="filed-title-content-inpt" placeholder="누구나 5%할인 쿠폰!">
							</div>
													
						<!-- 쿠폰명 노출되는 부분 END -->
					</div>

					<div class="img-box">
					<img class="" src=""></img>
							<!-- 쿠폰내용 타이틀 -->
	 						<span class="filed-title">쿠폰내용</span>
							
							<!-- 쿠폰내용 -->
							<div>
								<input type="text" class="filed-title-content-inpt" placeholder="5%할인">
							</div>
													
						<!-- 쿠폰내용 노출되는 부분 END -->
					</div>	
					
				</li>
			</ul>
			
			<!-- 경계선영역 START -->
			 <div class="nav-area" align="center">
			    <div class="coupon-cate"><a class="coupon-cate-item" href="#"></a></div>
		 	</div>
		 	<!-- 경계선영역 END -->
		 	
	 	</div>
	 	<!-- 쿠폰컨텐츠 영역 END -->
	 	
	 </div>
	<!-- 실제 구현 시 반복할 부분 END -->

</body>
</html>