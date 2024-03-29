<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="thenolja.tb_review.model.vo.Review, java.util.ArrayList" %>  
<%
	Review review = (Review)request.getAttribute("review");

	ArrayList<Review> reviewList = (ArrayList<Review>)request.getAttribute("reviewList");
%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
        height: 300px;
        margin-top: 20px;
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
</style>
</head>
<body>
	
	
	<%@ include file="../common/menubar.jsp" %>
	
		<div id="output">
        <div id="content_title">
            <div id="left_img">
                <a href="<%=contextPath%>"><img src="https://www.pngarts.com/files/2/Left-Arrow-PNG-Free-Download.png" alt="왼쪽 화살표" width="40px"></a>
            </div>
            <div id="left_title"><h3>내 예약 내역</h3></div>
		</div>
	<% if(reviewList.isEmpty()) { %>
	<table>
	<tr>
	   <th colspan="5">내역이 존재하지 않습니다.</th>
	</tr>
	</table>
	<% } else { %>
	</div>
	<% for(Review r : reviewList) { %>
		<div id="content">
	        <div id="reser_info">
	            <div id="reser_hotel_img"><img src="https://cf.bstatic.com/xdata/images/hotel/max1280x900/82237660.jpg?k=cb5db13896d348f7c4b47e3922a6753f83b5c36ba7b71a6f820523d07365fc2c&o=&hp=1" alt="" width="220px" height="220px"></div>
	
	            <div id="reser_detail">
	                <h3>마리안느 호텔</h3>
	                <p>슈페리어 더블(오션뷰)</p> 
	                <p>2인</p>
	                <p>117,000원</p>
	                <p>2024-02-28 ~ 2024-02-29</p>
	            </div>
	
			</div>
		</div>
	<% } %>
	<% } %>
</body>
</html>