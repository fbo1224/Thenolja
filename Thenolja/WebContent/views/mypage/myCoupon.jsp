<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,thenolja.mypage.model.vo.MyPageCoupon" %>
<%--<%@ page import="java.text.SimpleDateFormat, java.util.Date" %> --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<%--
<%
	ArrayList<MyPageCoupon> couponList = (ArrayList<MyPageCoupon>)request.getAttribute("couponList");
	SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
%>  
 --%>
   <c:set var="current" value="<%= new java.util.Date() %>" />

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
    #reser_detail{
        margin-left: 250px;
        margin-top : 10px;
    }
    #reser_detail > p{
        font-size: 18px;
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

    #coupon > img{
        width: 130px;
        height: 13 0px;
        float: left;
        margin-top: 20px;
        margin-left: 20px;
    }

    /*********************/
</style>

</head>
<body>
	<%--<%@ include file="../common/menubar.jsp"%> --%>
	<jsp:include page="../common/menubar.jsp" />

	<div id="output">
        <div id="content_title">
            <div id="left_title"><span>쿠폰함</span></div>
		</div>
    	<c:choose>
	    	<c:when test="${ empty requestScope.couponList }">
	    	<%--<% if(couponList.isEmpty()) { --%>
				<table>
					<tr>
						<th style="font-size:40px;" colspan="5">쿠폰이 존재하지 않습니다.</th>
					</tr>
				</table>
			</c:when>
			<%--<% } else { --%>
			
			<c:otherwise>
			<c:forEach var="c" items="${ requestScope.couponList }">
				<%--<% for(MyPageCoupon c : couponList) { --%>
				<div id="content">
			        <div id="reser_info">
	                    <div id="coupon"><img src="resources/mypage/coupons.png" alt="쿠폰이미지"></div>
	                    <div id="reser_detail">
	                    
	                    <%--
	                    	Date newDate = sdf.parse(c.getCouponDate()); 
	                   	--%>
	                   	
	                   	
	                   	<%--
	                    	SimpleDateFormat sdf2 = new SimpleDateFormat("yy년MM월dd일");
	                    	String date = sdf2.format(newDate);
	                    --%>
	                    
	                        <h3>${ c.couponContent } <%--<%= c.getCouponContent() --%></h3><br>
	                        <p>사용기한 : ${ c.couponDate } <%--<%= date --%></p>
	                        <p>할인율 : ${ c.couponPercent } <%--<%= c.getCouponPercent() --%></p>
	                        ${c.couponDate }
	                    </div>
			        </div>
				</div>
				<%--<% } --%>
			<%--<% } --%>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	<div id="homeBtn">
		<a href="${ path }"><button id="goHome" class="btn btn-info">메인으로 돌아가기</button></a>
	</div>
</div>

    <script>
        $(document).ready(function(){
            $('#content').hover(function(){
                $('#reser_info').css('border', 'none');
                $('#reser_info').css('border', '3px solid black');
            },function(){
                $('#reser_info').css('border', 'outset');
            });
        });
    </script>

</body>
</html>