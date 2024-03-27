<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String gradeName = (String)session.getAttribute("gradeName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>

<style>
    /*div{border: 1px solid red; box-sizing: border-box;}*/

    #wrap{
        width: 900px;
        height: auto;
        margin: auto;
    }

    .content{
        width: 100%;
        height: 200px;
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
        width: 25%;
        height: 100%;
    }
    #content4 > div{
        float: left;
        width: 25%;
        height: 100%;
    }

    #ct1_1 > h3{
        margin-top: 120px;
        margin-left: 50px;
        font-weight: bold;
    }

    .img1{
        width: 50px;
        height: 50px;
    }

    .img2{
        width: 50px;
        height: 50px;
    }


    #name{
        font-size: 30px;
        font-weight: bold;
        margin-top: 50px;
    }

    #customer{
        font-size: 20px;
        font-weight: bold;
        margin-left: 100px;
    }


    #grade{
        font-size: 30px;
        font-weight: bold;
        margin-top: 50px;
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

    
</style>

</head>
<body>

		<%@ include file="../common/menubar.jsp" %>
	
    <div id="wrap">
        <div id="content1" class="content">
            <div id="ct1_1">
                <h3>내 정보</h3>
            </div>
            <div id="ct1_2"></div>
            <div id="ct1_3"></div>
            <div id="ct1_4">
            </div>
        </div>
        <div id="content2" class="content">
            <div id="ct2_1">
                <img class="img" src="./resources/mypage/profile.png" alt="프로필" style="width: 120px; height: 120px; margin-top: 40px; margin-left: 50px;">
            </div>
            <div id="ct2_2"><div id="name"><%= loginUser.getMemName() %>님</div></div>
            <div id="ct2_3">
                    <div id="grade" style="color: goldenrod;"><%= gradeName %></div>
            </div>

            <div id="ct2_4">
                <button type="button" id="update" onclick="location.href='<%= contextPath %>/update.ck'">정보수정</button>
                <button type="button" data-toggle="modal" data-target="#deleteForm">회원탈퇴</button>
            </div>
        </div>
        <!-- 회원탈퇴 모달 -->
	<div class="modal" id="deleteForm">
		<div class="modal-dialog">
	 		<div class="modal-content">
	
	        <!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title" style="color:red">회원 탈퇴</h4>
			 	<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			
			<!-- Modal body -->
			<div class="modal-body">
			<form action="<%=contextPath%>/delete.me" method="post">
			       	
			<div class="form-group">
			   	<label for="memPwd" style="font-size:12px; color:red">탈퇴를 원하신다면 비밀번호를 입력해주세요.</label>
			   	<input type="password" name="memPwd" class="form-control" placeholder="비밀번호를 입력해주세요." id="deletePwd" required>
                <button type="submit" class="btn btn-sm btn-primary" onclick="return deleteMember();">회원 탈퇴</button>
			</div>
			 	<input type="hidden" value="<%= loginUser.getMemNo() %>" name="memNo">
			 	<input type="hidden" value="<%= loginUser.getMemPwd() %>" name="pwdCheck">
			 	
			</form>
		 	</div>
			</div>
		</div>
	</div>
        
        <div id="content3" class="content">

            <div class="icon"><div class="iconImg"><a href="#"><img class="img1" src="./resources/mypage/coupon.png" alt="쿠폰"><span>쿠폰함</span></a></div></div>
            <div class="icon"><div class="iconImg"><a href="#"><img class="img1" src="./resources/mypage/heart.png" alt="찜목록"><span>찜목록</span></a></div></div>
            <div class="icon"><div class="iconImg"><a href="#"><div style="width: 80%;margin: auto;"><img class="img1" src="./resources/mypage/review.png" alt="리뷰"></div><span>내 리뷰</span></a></div></div>
            <div class="icon"><div class="iconImg"><a href="#"><img class="img1" src="./resources/mypage/event.png" alt="이벤트"><span>이벤트</span></a></div></div>
        </div>
        <div id="content4" class="content">
            
            <div><span id="customer">고객센터 >></span></div>
            <div class="icon"><div class="iconImg"><a href="#"><div style="width: 80%;margin: auto;"><img class="img1" src="./resources/mypage/actions.png" alt="이용내역"></div><span>이용내역</span></a></div></div>
            <div class="icon"><div class="iconImg"><a href="#"><div style="width: 80%;margin: auto;"><img class="img1" src="./resources/mypage/notice.png" alt="공지사항"></div><span>공지사항</span></a></div></div>
            <div class="icon"><div class="iconImg"><a href="#"><div style="width: 50%;margin: auto;"><img class="img1" src="./resources/mypage/qna.png" alt="자주 묻는 질문"></div><span>자주 묻는 질문</span></a></div></div>
            
        </div>


    </div>

</body>
</html>