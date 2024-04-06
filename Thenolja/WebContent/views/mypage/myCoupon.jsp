<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,thenolja.mypage.model.vo.MyPageCoupon" %>
<%
	ArrayList<MyPageCoupon> couponList = (ArrayList<MyPageCoupon>)request.getAttribute("couponList");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰함</title>
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
        background-color: lightgray;
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
    #img{
        border-radius: 10px;
        width: 100px;
        height: 95px;
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
            <div id="left_title"><span>쿠폰함</span></div>
		</div>
    	<% if(couponList.isEmpty()) { %>
			<table>
				<tr>
					<th style="font-size:40px;" colspan="5">쿠폰이 존재하지 않습니다.</th>
				</tr>
			</table>
		<% } else { %>
			<% for(MyPageCoupon c : couponList) { %>
			<div id="content">
		        <div id="reser_info">
		            <div id="img">
                           <img src="#" alt="쿠폰이미지" width="100px" height="100px">
                    </div>
                    <div id="reser_detail">
                        <h3><%= c.getCouponContent() %></h3><br>
                        <p><%= c.getCouponDate() %></p>
                        <p><%= c.getCouponPercent() %></p>
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