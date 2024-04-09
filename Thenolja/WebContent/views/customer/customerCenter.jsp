<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>더놀자 > 고객센터 > 메인</title>

<style>
    /*div{border: 1px solid red; box-sizing: border-box;}*/

    #wrap{
        width: 900px;
        height: auto;
        margin: auto;
    }

    .content{
        width: 100%;
        height: 230px;
        border-bottom: 2px solid lightgray;
    }
    #content1 > div{
        float: left;
        width: 25%;
        height: 100%;
    }
    #content2 > div{
        float: left;
        width: 25%;
        height: 100%;
    }
    #content3 > div{
        float: left;
        width: 50%;
        height: 100%;
    }
    #content4 > div{
        float: left;
        width: 25%;
        height: 100%;
    }

    #ct1_1 > h3{
        margin-top: 35px;
        margin-left: 50px;
        font-weight: bold;
    }

    .img1{
        width: 50px;
        height: 50px;
    }

    .img1:hover{transform: scale(1.1);}
    .img2:hover{transform: scale(1.1);}

    .img2{
        width: 50px;
        height: 50px;
    }


    #name{
        font-size: 35px;
        font-weight: bold;
        margin-top: 50px;
    }

    #grade{
        font-size: 35px;
        font-weight: bold;
    }

    #gradeIcon{
        margin-top: 50px;
        display: inline-block;
    }

    #ct2_4 > button{
        border: none;
        background-color: rgb(70, 149, 151);
        width: 100px;
        height: 40px;
        color: white;
        margin-top: 40px;
        margin-left: 70px;
        border-radius: 10px;
    }
    #ct2_4 > button:hover{color: black;}

    .icon{
        display: flex;
        align-items: center;
        justify-content: center;
    }
    .iconImg{
        width: auto;
    }
    .iconImg > a > span {
        display: block;
        color: black;
    }
    .iconImg > a > span:hover{
        text-decoration: none;
    }
    a:hover{text-decoration: black;}
    
    #gradeInfo{
        display: none;
    }
    .img{
        width: 150px; 
        height: 150px; 
        margin-top: 40px; 
        margin-left: 40px;
        cursor:pointer;
    }
    .img:hover{opacity: 0.7;}
    #save{
        background-color: white;
        font-weight: bold;
        border: none;
        float: right;
    }
    #save:hover{background-color: black; color: white;}
</style>

</head>
<body>

		<%@ include file="../common/menubar.jsp" %>
	
    <div id="wrap">
        <div id="content1" class="content" style="height: 100px;">
            <div id="ct1_1">
                <h3>고객센터</h3>
            </div>
            <div id="ct1_2"></div>
            <div id="ct1_3"></div>
            <div id="ct1_4">
            </div>
        </div>
        
        <div id="content3" class="content">
            <div class="icon"><div class="iconImg"><a href=" ${ path } /noticeList?currentPage=1"><img class="img1" src="../../resources/mypage/bell.png" alt="공지사항"><span>공지사항</span></a></div></div>
            <div class="icon"><div class="iconImg"><a href="${ path } /eventList?currentPage=1"><img class="img1" src="../../resources/mypage/events.png" alt="이벤트"><span>이벤트</span></a></div></div>
            <div class="icon"><div class="iconImg"><a href="${ path } /couponList?currentPage=1"><div style="width: 80%;margin: auto;"><img class="img1" src="../../resources/mypage/coupons.png" alt="쿠폰"></div><span>쿠폰</span></a></div></div>
            <div class="icon"><div class="iconImg"><a href="javascript:void(0)" onclick="alert('페이지 준비중입니다. 잠시만 기다려주세요.^^')"><img class="img1" src="../../resources/mypage/question.png" alt="자주 묻는 질문"><span>자주 묻는 질문</span></a></div></div>
        </div>

    </div>

</body>
</html>