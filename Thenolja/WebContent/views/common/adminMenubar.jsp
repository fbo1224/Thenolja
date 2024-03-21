<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <title>관리자메뉴바</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    
<style>
    
  div{
           /*border: 1px solid red;*/
            box-sizing: border-box;
        }
  
   

    #header{
        width:1200px;
        height: 180px;
        margin: auto;
    } 
    
    /*********************************/


    #tnj_header{
        width: 100%;
        height: 50%;
    }

    #line{
        width: 100%;
        height: 10%;
        border-bottom: 3px solid rgb(70, 149, 151);  
    }

    #tnj_menu{
        width: 100%;
        height: 40%;
    }


    #tnj_header > div{
        height: 100%;
    }

    #tnj_icon{
        width: 10%;
        float: left;
    }

    #tnj_title{
        width: 35%;
        float: left;
    }

    #admin_login{
        width: 55%;
        float: left;
    }

    #tnj_icon > img{
        width: 80px;
        float: right;
        padding-top: 25px;
    }


    #tnj_title > h2{
        padding-top: 50px;
        padding-left: 30px;
    }

    #tnj_title > h2 > a{
        color: black;
        text-decoration: none;
    }

    #admin_login > p{
        padding-top: 60px;
        font-size: 20px;
        text-align: right;
        padding-right: 50px;
    }
    

    #admin_login > p > a{
        color: black;
        text-decoration: none;
    }

    #navi{
        list-style: none;
        margin: 0;
        padding: 0;
        height: 100%;
        padding-left: 200px;
    }

    #navi > li{
        float: left;
        width: 15%;
        height: 100%;
        text-align: center;
    }
    #navi a{
            width: 100%;
            height: 100%;
            text-decoration: none;
            color: black;
            display: block;
            line-height: 38px;
            font-size: 17px;
            transform: scale(1);
            position: relative;
            z-index: 3;
        }
        
        #navi > li > ul{
            list-style: none;
            padding: 0px;
            display:none;
        }

        #navi > li > a:hover + ul{
            display:block;
        }

        #navi > li > ul:hover{
            display: block;
        }

        #navi a:hover{
            font-size: 17px;
            font-weight: 700;
        }
        
        #navi > li > ul a{
            font-size: 17px;
            background-color: #E5E3E4;
        }
      	.form-control{
			display: inline-block;
			width: auto;
		}
		.form-check-input {
			position:static;
		}

</style>
</head>
<body>
    <div id="header">
        
        <div id="tnj_header">
            

            <div id="tnj_icon">
                <img src="resources/img/logo.png" alt="logo">
            </div>

            <div id="tnj_title">
                <h2><a href="<%= contextPath %>">관리자</a></h2>
            </div>

            <div id="admin_login">
                <p><a href="#">로그아웃</a></P>
            </div>

        </div>

        <div id="line"></div>

        <div id="tnj_menu">
            <ul id="navi">
                <li>
                    <a href="#">회원관리</a>
                    <ul>
                        <li><a href="<%= contextPath %>/selectMember">회원조회</a></li>
                        <li><a href="#">회원 예약 조회</a></li>
                        <li><a href="#">탈퇴 회원 조회</a></li>
                    </ul>
                </li>
    
                <li>
                    <a href="#">비회원관리</a>
                    <ul>
                        <li><a href="#">비회원 조회</a></li>
                        <li><a href="#">비회원 예약 조회</a></li>
                    </ul>
                </li>
    
                <li>
                    <a href="#">숙소관리</a>
                    <ul>
                        <li><a href="#">숙소 조회</a></li>
                    </ul>
                </li>
                
                <li>
                    <a href="#">결제관리</a>
                    <ul>
                        <li><a href="#">회원 환불 조회</a></li>
                        <li><a href="#">비회원 환불 조회</a></li>
                    </ul>
    
                </li>
    
                <li>
                    <a href="#">고객센터관리</a>
                    <ul>
                        <li><a href="#">공지사항</a></li>
                        <li><a href="#">이벤트</a></li>
                        <li><a href="#">쿠폰</a></li>
                        <li><a href="#">리뷰</a></li>
                    </ul>
    
                </li>
    
            </ul>

        </div>

    </div>
</body>
</html>