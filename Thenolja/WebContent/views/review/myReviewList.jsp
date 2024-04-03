<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="thenolja.tb_review.model.vo.Review, java.util.ArrayList" %>  
<%
	ArrayList<Review> myList = (ArrayList<Review>)request.getAttribute("myList");
	
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
        height: 180px;
        margin-top: 20px;
        border: 1px solid silver;
        border-radius: 20px;
    }
    #content_title{
        width: 100%;
        height: 50px;
        margin-top : 20px;
        border-bottom: 1px solid black;
    }
    #left_img{
        float: left;

    }
    #left_title{
        margin-left: 60px;
    }
    #review_detail{
        width: 70%;
        height: 100%;
    }
    #review_detail > *{
    	padding-left: 30px;
    	margin-top: 5px;'
    }
    #content > div{
        float: left;
    }
    #reivew_set{
        width: 30%;
        height: 100%;
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
        margin-left: 40px;
        font-size: 17px;
        margin-top: 70px;
    }
    #updateReview:hover{
        font-size: 17.3px;
    }
    #cancel{
        margin-left: 40px;
        font-size: 20px;
    }
    #review_img{
        width: 40%;
        height: 100%;
        margin-top: 14px;
    }
    #reivew_set > div{
        float: left;
    }
    #img_btn{
        width: 60%;
        height: 100%;
    }
    #nickName{
        width: 100%;
        height: 30%;
        font-size:23px;
        font-weight:bord;
    }
    #score{
        width: 100%;
        height: 70%;
        font-size: 18px;
    }
    #hotelName{
    	font-size: 18px;
    }
    #reviewCC{font-size: 15px;}
    #homeBtn {
    	text-align:center;
    	margin-top:100px;
    }
    #goHome{
    	width : 300px;
    	height: 50px;
    	border-radius : 10px;
    	background-color: #5BA199;
    	border : 0;
    	margin-bottom: 100px;
    	font-size: 22px;
    }
    #goHome:hover{
    	font-size:23px;
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
			<div id="left_title"><h3>MY REVIEW</h3></div>
		</div>
		<% if(myList.isEmpty()) { %>
		<table>
			<tr>
				<th style="font-size:40px;" colspan="5">작성된 리뷰가 존재하지 않습니다.</th>
			</tr>
		</table>
		<% } else { %>
		<%for(Review r : myList){ %>
		<div id="content">
			<div id="review_detail">
				<div id="hotel_name">
					<span id="nickName"><%=r.getNickName() %></span>님<br>
					<span id="hotelName"><%=r.getHotelName() %></span>&nbsp;&nbsp;<span id="score"><%=r.getScore() %></span><br><br>
					<span id="roomName"><%=r.getRoomName() %></span>
				</div>
				<div id="review_content">
					<span id="reviewCC"><%=r.getContent() %></span>
				</div>
			</div>
			<div id="reivew_set">
				<div id="review_img"><img id="reser_review_img" src="<%=r.getImgPath() %>" alt="숙소사진" width="150px" height="150px"></div>
				<div id="img_btn">
					<a href="update.review?reserNo=<%=r.getReserNo()%>&hotelNo=<%=r.getHotelNo()%>&roomNo=<%=r.getRoomNo()%>"><button id="updateReview">리뷰 수정</button></a>
					<a href="delete.review?reserNo=<%=r.getReserNo()%>">
					<input id="cancel" type="button" value="X" style="border: 0; background-color: white;"></a>
				</div>
			</div>
		</div> 
		<% } %>
		<% } %>
	<div id="homeBtn">
	<a href="<%=contextPath%>"><button id="goHome" class="btn btn-info">메인으로 돌아가기</button></a>
	</div>
	</div>	
		
		
</body>
</html>