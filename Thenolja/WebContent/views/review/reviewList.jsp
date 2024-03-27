<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>리뷰 목록 조회</title>
    <style>
        #output{
            width: 1200px;
            height: 1500px;
            margin: auto;
        }
        #output > div{
            box-sizing: border-box;   
        }
        #header-navi{
            width: 1200px;
            height: 7%;
            border-bottom: 3px solid darkcyan;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }
        #logo-img{
            padding-top: 30px;
            margin-left: 20px;
           	width: 100px;
           	height: 75px;
        }
        #optionList{
            width: 50%;
            margin-top: 40px;
            display: flex;
            align-items: center;
            justify-content: space-evenly;
            font-size: 20px;
        }
        li{
            list-style: none;
            float: left;
        }
        a{
            text-decoration: none;
            color: black;
        }
        #header-title {
            display: inline-block;
            margin-bottom: 30px;
        }
        #header{
            width: 100%;
            height: 10%;
            border-bottom: 1px solid silver;
        }
        #header > *{
            float: left;
        }
        #c-img{
            width: 35px;
            padding-top: 105px;
            padding-left: 30px;
        }
        #c-img, #heCon{
            margin: 0px;
        }
        #heCon{
            padding-top: 110px;
            font-size: 30px;
            font-weight: 700;
            margin-left: 30px;
            font-family: "Lucida Console", "Courier New", monospace;
        }
        #content{
            width: 100%;
            height: 75%;
            margin:auto;
            padding-top: 2%;
            border: 1px solid;
        }
        #content > *{
            padding-left: 30px;
            margin: auto;
            height: 100%;
        }
    </style>
</head>
<body>

    <div id="output">
        <header id="header-navi">
            <div>
               <img id="logo-img" src="./resources/image/thenoljaLogo.png" width="90px" height="80px" alt="logo" >
               <h1 id="header-title">더 놀자</h1>
            </div>
            <ul id="optionList">
               <li><a href="#">로그아웃</a></li>
               <li><a href="#">로그인</a></li>
               <li><a href="#">비회원 예약</a></li>
               <li><a href="#">회원가입</a></li>
               <li><a href="#">고객센터</a></li>
            </ul>
         </header>
        <div id="header">
            <img id="c-img" src="https://cdn-icons-png.flaticon.com/512/7693/7693271.png" alt="취소이미지">
            <div id="heCon">Review (5)</div>
        </div>
        <div id="content">
            <div id="re-ment">
                <div id="re-comment">
                    <div id="info"></div>
                    <div id="comment"></div>
                </div>
                <div id="re-info">
                    <a id="re-img" href=""></a>
                    <button type="button"></button>
                    <button type="button"></button>
                </div>
            </div>
        </div>
    </div>
    
</body>
</html>