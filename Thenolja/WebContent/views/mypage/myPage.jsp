<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>

<style>
    div{border: 1px solid red; box-sizing: border-box;}


    .content{
        width: 963px;
        height: 150px;
        float: left;
        margin-left: 120px;
    }

    div > h1{
        font-size: 40px;
    }

    #wrap > hr{
        height: 1px;
        background-color: lightgray;
        border: none;
        margin: auto;
    }

    div > span{
        font-size: 15px;
        font-weight: bold;
    }

    #name{font-size: 30px; font-weight: bold;}

    .btn{
        border: none;
        background-color: rgb(70, 149, 151);
        width: 100px;
        height: 60px;
        float: right;
        color: white;
    }

    .content2{width: 320px; height: 100%; display:inline}

    .content3{width: 240px; height: 100%; float: left;}
    .content4{width: 240px; height: 100%; float: left;}

</style>

</head>
<body>


		<%@ include file="../common/menubar.jsp" %>
	
    <div id="wrap">
        <div id="content1" class="content">
            <h1>마이페이지</h1>
        </div>
        <div id="content2" class="content"><hr>
            <div class="content2">
                <span id="name"><%= loginUser.getMemName() %></span>
            </div>
            <div class="content2"></div>
            <div class="content2">
                <button class="btn" id="modify">정보수정</button>
                <button class="btn" id="without">회원탈퇴</button>
            </div>
        </div>
        <div id="content3" class="content"><hr>
            <div class="content3"></div>
            <div class="content3"></div>
            <div class="content3"></div>
            <div class="content3"></div>
        </div>
        <div id="content4" class="content"><hr>
            
            <div class="content4"><span>고객센터</span></div>
            <div class="content4"></div>
            <div class="content4"></div>
            <div class="content4"></div>
            
        </div>





    </div>

</body>
</html>