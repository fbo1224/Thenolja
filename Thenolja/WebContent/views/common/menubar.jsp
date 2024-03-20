<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String contextPath = request.getContextPath();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>review</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

    <style>
    div {
        box-sizing: border-box;
    }
    #header-navi{
        width: 1200px;
        height: 100px;
        margin: 0px auto;
        border-bottom: 3px solid darkcyan;
        display: flex;
        align-items: center;
        
    }
    #optionList{
        width: 100%;
        margin: 0px;
        display: flex;
        align-items: center;
        justify-content: space-evenly;
        padding-top: 30px;
    }
    li{
        list-style: none;
        float: left;
    }
    a{
        text-decoration: none;
        color: black;
        padding-right: 20px;
    }

    #header-title {
        display: inline-block;
        font-weight: bold;
        padding-top: 30px;
        font-size: 40px;
    }
    #logo-img{
        width:115px;
        height:100px;
    }
    #menu-list{
        margin-left: 400px;
    }

    </style>
    
</head>
<body>
    <header id="header-navi">
        <div>
           <img id="logo-img" src="./resources/img/logo.png"alt="logo"></div>
           <h2 id="header-title">더 놀자</h2>
        <div id="menu-list">
        <ul id="optionList" style="font-size: 20px;">
           <li><a href="#">로그인</a></li>
           <li><a href="#">비회원 예약</a></li>
           <li><a href="#">회원가입</a></li>
           <li><a href="#">고객센터</a></li>
        </ul>
        </div>
    </header>


    
</body>
</html>