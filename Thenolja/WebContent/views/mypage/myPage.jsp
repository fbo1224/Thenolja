<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        margin-top: 50px;
        margin-left: 50px;
        font-weight: bold;
    }

    .img1{
        width: 50px;
        height: 50px;
        margin-top: 60px;
        margin-left: 87px;
    }

    .img2{
        width: 50px;
        height: 50px;
        margin-top: 60px;
        margin-left: 87px;
    }


    #name{
        font-size: 30px;
        font-weight: bold;
        margin-top: 50px;
    }

    #ct4_1 > div{
        font-size: 20px;
        font-weight: bold;
        margin-top: 30px;
        margin-left: 100px;
    }

    #update{
        margin-top: 50px;
        margin-left: 70px;
        width: 100px;
        height: 40px;
        background-color: rgb(70, 149, 151);
        font-size: 15px;
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
        margin-top: 30px;
        margin-left: 70px;
    }
    .link1{margin-left: 90px; margin-top: 10px; text-decoration: none; color: black;}
    .link1:hover{text-decoration: none;}

    .link2{margin-left: 80px; margin-top: 10px; text-decoration: none; color: black;}
    .link2:hover{text-decoration: none;}
</style>

</head>
<body>

		<%@ include file="../common/menubar.jsp" %>
	
    <div id="wrap">
        <div id="content1" class="content">
            <div id="ct1_1">
                <h3>마이페이지</h3>
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
            <div id="ct2_2">
                <div id="name"><%= loginUser.getMemName() %>님</div>
            </div>
            <div id="ct2_3">
                <div id="grade">Gold회원</div>
            </div>
            <div id="ct2_4">
                <div id="update"><a href="<%= contextPath %>/update.ck" style="color: white;">정보수정</a></div>
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
			 	
			  	
			  	
			<!-- 
			<script>
				function deleteMember(){
					
					const value = prompt('탈퇴를 원하신다면 "어쩌고저쩌고"를 정확히 입력해주세요.');
					
					if(value === ('어쩌고저쩌고')){
						return true;
					}
					else{
						return false;
					}
				}
			
			</script> 
			-->
			
			</form>
		 	</div>
			</div>
		</div>
	</div>
        
        
        
        
        
        <div id="content3" class="content">
            <div id="ct3_1"><a href="#"><img class="img1" src="./resources/mypage/coupon.png" alt="쿠폰"><div class="link1">쿠폰</div></a></div>
            <div id="ct3_2"><a href="#"><img class="img1" src="./resources/mypage/heart.png" alt="찜목록"><div class="link1">찜목록</div></a></div>
            <div id="ct3_3"><a href="#"><img class="img1" src="./resources/mypage/review.png" alt="리뷰"><div class="link1">리뷰</div></a></div>
            <div id="ct3_4"><a href="#"><img class="img1" src="./resources/mypage/event.png" alt="이벤트"><div class="link1">이벤트</div></a></div>
        </div>
        <div id="content4" class="content">
            
            <div id="ct4_1"><div>고객센터 >></div></div>
            <div id="ct4_2"><a href="#"><img class="img2" src="./resources/mypage/actions.png" alt="이용내역"><div class="link2">이용내역</div></a></div>
            <div id="ct4_3"><a href="#"><img class="img2" src="./resources/mypage/notice.png" alt="공지사항"><div class="link2">공지사항</div></a></div>
            <div id="ct4_4"><a href="#"><img class="img2" src="./resources/mypage/qna.png" alt="qna"><div class="link2" style="margin-left: 60px;">자주묻는질문</div></a></div>
            
        </div>


    </div>

</body>
</html>