<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="thenolja.tb_review.model.vo.Review, java.util.ArrayList,thenolja.common.model.vo.PageInfo" %>  
<%
	Review review = (Review)request.getAttribute("review");

	ArrayList<Review> reviewList = (ArrayList<Review>)request.getAttribute("reviewList");
	PageInfo pi = (PageInfo)request.getAttribute("pageInfo");
	
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
        height: 200px;
        margin-top: 20px;
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
	   <th colspan="5">내역이 존재하지 않습니다.</th>
	</tr>
	</table>
	<% } else { %>
        <% for(Review r : reviewList) { %>
            <div id="content">
                <div id="review_detail">
                </div>
			</div>
            <% } %>
            <% } %>
    </div>
	
	
	
	
	
	
	
	
	
	
</body>
</html>