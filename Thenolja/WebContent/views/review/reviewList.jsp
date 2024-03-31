<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="thenolja.tb_review.model.vo.Review, java.util.ArrayList, 
				thenolja.common.model.vo.PageInfo, thenolja.tb_reservation.model.vo.Reservation" %>  
<%
	Review review = (Review)request.getAttribute("review");

	ArrayList<Review> reviewList = (ArrayList<Review>)request.getAttribute("reviewList");
	PageInfo pi = (PageInfo)request.getAttribute("pageInfo");
	Reservation reser = (Reservation)request.getAttribute("reser");
	
	// 페이징바 만들 때 필요한 변수 미리 세팅
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
    div{
        box-sizing : border-box;
    }
    #output{
    	width: 1200px;
        height: auto;
        margin: auto;
    }
    #content{
        width: 1200px;
        height: 200px;
        margin-top: 30px;
        border: 1px solid black;
    }
    #content_title{
        width: 100%;
        height: 100%;
        margin-top : 20px;
    }
    #left_img{
        float: left;

    }
    #left_title{
        margin-left: 60px;
    }
    #review_detail{
        width: 60%;
        height: 100%;
        border: 1px solid black;
    }
    #content > div{
        float: left;
    }
    #reivew_set{
        width: 40%;
        height: 100%;
        border: 1px solid black;
    }
    #review_set > #reser_review_img{
        float: left
    }
    #reser_review_img{
        border-radius: 10px;
    }
    #updateReview{
        border: 0;
        color: white;
        background-color: rgb(91, 161, 153);
        border-radius: 5px;
        margin-left: 80px;
        font-size: 17px;
        margin-top: 80px;
    }
    #updateReview:hover{
        font-size: 17.3px;
    }
    #cancel{
        margin-left: 40px;
        margin-bottom: 300px;
        font-size: 20px;
    }
    #review_img{
        width: 40%;
        height: 100%;
    }
    #reivew_set > div{
        float: left;
    }
    #img_btn{
        width: 60%;
        height: 100%;
    }
    #hotel_name{
        width: 100%;
        height: 25%;
    }
    #review_content{
        width: 100%;
        height: 75%;
    }
</style>
</head>
<body>
	
	<%@ include file="../common/menubar.jsp" %>
	<div id="output">
		<div id="content_title">
			<div id="left_img">
				<a href="<%=contextPath%>"><img src="https://www.pngarts.com/files/2/Left-Arrow-PNG-Free-Download.png" alt="왼쪽 화살표" width="40px"></a>
			</div>
			<div id="left_title"><h3>REVIEW</h3></div>
		</div>
		<% if(reviewList.isEmpty()) { %>
		<table>
			<tr>
				<th style="font-size:40px;" colspan="5">작성된 리뷰가 존재하지 않습니다.</th>
			</tr>
		</table>
		<% } else { %>
		<%for(Review r : reviewList){ %>
		<div id="content">
			<div id="review_detail">
			<input type="hidden" name="hotelNo">
				<div id="hotel_name">
					마리안느&nbsp;
				</div>
				<div id="review_content">
					<%=review.getContent() %>
				</div>
			</div>
			<div id="reivew_set">
				<div id="review_img"><img id="reser_review_img" src="<%=review.getImgPath() %>" alt="숙소사진" width="190px" height="190px"></div>
				<div id="img_btn">
					<a href="update.review?reserNo=<%=review.getReserNo()%>"><button id="updateReview">리뷰 수정</button></a>
					<input id="cancel" type="button" value="X" style="border: 0; background-color: white;">
				</div>
			</div>
		</div> 
		<% } %>
		<% } %>
	</div>	
		
		
		
</body>
</html>