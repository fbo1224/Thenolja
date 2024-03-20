<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String contextPath = request.getContextPath();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴바</title>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
        div{
            margin: auto;
            box-sizing: border-box;
            /*border: 1px solid red;*/
        }

        #wrap{
            width: 1200px;
            height: 150px;
        }

        #header1{
            width: 80%;
            height: 140px;
        }

        #header2{
            width: 80%;
            height: 10px;
            padding: 5px;
        }


        div > hr{
            height: 5px;
            background-color: rgb(70, 149, 151);
            border: none;
            margin: auto;
        }

        #logo{
            width: 100px; 
            height: 75px;
            margin-top: 70px;
            margin-right: 100px;
            left: 250px;
            top: 25px;
        }

        .menu{
            float: right;
            height: 100%;
            width: 200px;
            text-align: center;
            font-size: 20px;
        }

        .menu > div > a{
            text-decoration: none;
            color: black;
            margin-bottom: 10px;
        }

        #menu1{
            float: left;

        }

        .detailMenu1{
            width: 100%;
            height: 80%;
            float: left;
        }

        .detailMenu2{
            width: 100%;
            height: 20%;
            float: left;
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
           <img id="logo-img" src="Thenolja/resources/img/logo.png"alt="logo"></div>
           <h2 id="header-title">더 놀자</h2>
        <div id="menu-list">
        <ul id="optionList" style="font-size: 20px;">
           <li><a href="#">로그인</a></li>
           <li><a href="#">비회원 예약</a></li>
           <li><a href="#">회원가입</a></li>
           <li><a href="#">고객센터</a></li>
        </ul>


     

    
</body>
</html>