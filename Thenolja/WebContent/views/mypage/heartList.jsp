<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,thenolja.mypage.model.vo.MyPageHeartList" %>  
<%
	ArrayList<MyPageHeartList> heartList = (ArrayList<MyPageHeartList>)request.getAttribute("heartList");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찜 목록 조회</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>

    div{
    	/*border: 1px solid red;*/
        box-sizing : border-box;
    }
    #output{
    	width: 1200px;
        height: auto;
        margin: auto;
    }
    #content{
        width: 600px;
        height: auto;
        margin-top: 20px;
        margin: auto;
    }
    #content_title{
        height: 100%;
        margin-top : 20px;
    }
    #left_title{
        text-align: center;
        font-size: 50px;
        font-weight: bold;
        color: #5BA199;
    }
    #reser_info{
        width: 600px;
        height: 200px;
        margin: auto;
        margin-top: 30px;
        border: outset;
        border-radius: 10px;
    }
    #reser_hotel_img{
        width: 25%;
        float: left;
    }
    #reser_hotel_img > img{
        border-radius: 10px;
        width: 200px;
        height: 195px;
    }

    #reser_detail{
        margin-left: 250px;
    }
    #reser_detail > p{
        font-size: 20px;
    }
    #reser_detail > span{
        font-weight: bold;
        font-size: 40px;
    }
    #homeBtn {
    	text-align:center;
        margin: auto;
    }
    #goHome{
    	width : 300px;
    	height: 50px;
    	border-radius : 10px;
    	background-color: #5BA199;
    	border: none;
    	margin-top:100px;
    	font-size: 22px;
    }
    #goHome:hover{
    	color:black;
    }

    #heart > img{
        width: 25px;
        height: 25px;
        float: right;
        margin-top: 10px;
    }

    /*********************/
</style>

</head>
<body>
	<%@ include file="../common/menubar.jsp"%>

	<div id="output">
        <div id="content_title">
            <div id="left_title"><span>내 찜목록</span></div>
		</div>
    	<% if(heartList.isEmpty()) { %>
			<table>
				<tr>
					<th style="font-size:40px;" colspan="5">찜한 내역이 존재하지 않습니다.</th>
				</tr>
			</table>
		<% } else { %>
			<% for(MyPageHeartList h : heartList) { %>
			<div id="content">
			        <div id="reser_info">
			            <div id="reser_hotel_img">
                            <img src="<%= h.getHotelPath() %>" alt="호텔이미지" width="220px" height="220px">
                        </div>
                        <div id="reser_detail">
                            <h3><%= h.getHotelName() %></h3><br>
                            <p><%= h.getHotelLocation() %></p>
                            <p><%= h.getHotelAddress() %></p>
                        </div>
                        <div id="heart"><img src="resources/mypage/myHeart.png" alt="하트이미지"></div>
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