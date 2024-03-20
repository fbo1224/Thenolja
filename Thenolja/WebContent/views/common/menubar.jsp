<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="thenolja.member.model.vo.Member" %>
<%
	String contextPath = request.getContextPath();
	// String alertMsg = (String)request.getAttribute("alertMsg");
	
	// System.out.println(contextPath);
	// System.out.println(alertMsg);
	Member loginUser = (Member)session.getAttribute("loginUser");
	
	String alertMsg = (String)session.getAttribute("alertMsg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴바</title>

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
        
        .detailMenu1 > span{
        	font-size:20px;
        }

        
    </style>
</head>
<body>
	<div id="wrap">
        <div id="header1">
            
            <div id="menu1" class="menu">
                <a href="<%= contextPath%>"><img src="resources/img/Logo.png" id="logo"></a>
            </div>

            <% if(loginUser == null){  %> <!-- 로그아웃 상태라면 -->

	            <div id="menu2" class="menu">
	                <div class="detailMenu1"></div>
	                <div class="detailMenu2">
	                    <a href="<%= contextPath %>/customerService">고객센터</a>
	                </div>
	            </div>
	            <div id="menu3" class="menu">
	                <div class="detailMenu1"></div>
	                <div class="detailMenu2">
	                    <a href="<%= contextPath %>/myPage">마이페이지</a>
	                </div>
	            </div>
	
	            <div id="menu4" class="menu">
	                <div class="detailMenu1"></div>
	                <div class="detailMenu2"><a href="<%= contextPath %>/loginPage">로그인</a></div>
	                
                <% } else { %> <!-- 로그인상태라면 -->
                	<div id="menu2" class="menu">
	                <div class="detailMenu1">
	                	<span><%= loginUser.getMemName() %>님 환영합니다</span>
	                </div>
	                <div class="detailMenu2">
	                    <a href="<%= contextPath %>/customerService">고객센터</a>
	                </div>
	            </div>
	            <div id="menu3" class="menu">
	                <div class="detailMenu1"></div>
	                <div class="detailMenu2">
	                    <a href="<%= contextPath %>/myPage">마이페이지</a>
	                </div>
	            </div>
	
	            <div id="menu4" class="menu">
	                <div class="detailMenu1"></div>
	                <div class="detailMenu2"><a href="<%= contextPath %>/logout">로그아웃</a></div>
                	
                <% }%>
            </div>
        </div>
        
        <div id="header2"><hr></div>





    </div>




</body>
</html>