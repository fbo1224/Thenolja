<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>리뷰 목록 조회</title>
    <style>
    div{
       border: 1px solid red;
        box-sizing : border-box;
    }

    #content{
        width: 1200px;
        height: 1500px;
        margin: auto;
    }
    
    /*********************/

    #content_title, #detail{width: 100%;}

    #content_title{height: 10%;}

    #left_img{
        width: 5%;
        height: 100%;
        float: left;
    }

    #left_img > a > img{
        margin-top: 20px;
    }

    #left_title{
        width: 95%;
        height: 100%;
        float: left;
    }
    
    #left_title > h3 {
        margin-top: 25px;
    }
    
    
	</style>
	
</head>


<body>
	<%@ include file="../common/menubar.jsp" %>
    <div id="content">
	<div id="content_title">
	   	<div id="left_img">
       		<a href="<%= contextPath%>"><img src="https://www.pngarts.com/files/2/Left-Arrow-PNG-Free-Download.png" alt="왼쪽 화살표" width="40px"></a>
	    </div>
	    <div id="left_title"><h3>상세조회</h3></div>
	</div>
    </div>
</body>
</html>