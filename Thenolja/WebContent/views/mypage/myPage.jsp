<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String gradeName = (String)session.getAttribute("gradeName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/heart.css">

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
        width: 25%;
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
        cursor:pointer
    }
</style>

</head>
<body>

		<%@ include file="../common/menubar.jsp" %>
	
    <div id="wrap">
        <div id="content1" class="content" style="height: 100px;">
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
            	
                <div id="profile" onclick="profileClick();">
                    <!--<img class="img" src="./resources/mypage/user.png" alt="프로필">-->
                </div>
                
                <!-- SELECT PROFILE PATH-->
                <script>
                    $.ajax({
                        url: 'selectProfile',
                        data:{memNo : <%= loginUser.getMemNo()%>},
                        success: function(result){
                            console.log(result);
							let resultStr;
                            
                            if(result.equals('')){
                                resultStr = '<div id="profile" onclick="profileClick();"><img class="img" src="./resources/mypage/user.png" alt="프로필"></div>'
                            } else {
                                resultStr = '<div id="profile" onclick="profileClick();"><img class="img" src="result" alt="프로필"></div>'
                            }
                            $('#profile').html(resultStr);
                        }
                    });
                </script>

                <input id="profileChange" type="file" hidden>
                <!-- INSERT PROFILE PATH
                <script>
                    function profileClick(){
                        $('#profileChange').click();

                        $.ajax({
                            url:'insertProfile',
                            type:'get',
                            data:{
                                memNo : <%--<%= loginUser.getMemNo() %>--%>
                            },
                            success:function(result){
                                console.log(result);
                                if(result > 0){
                                    $('.img').attr(src,'./resources/mypage/user.png');
                                }
                            }
                        });
                    }

                </script>
                -->
            </div>
            <div id="ct2_2">
                <div id="name"><%= loginUser.getMemName() %>님</div>
            </div>
            <div id="ct2_3">
                <div id="gradeIcon">
                
                <!-- 회원등급에 따라 색 조정 -->
                <% if(gradeName.equals("FAMILY")) { %>
                    <span id="grade" style="color: chocolate;"><%= gradeName %></span>
                    <img src="./resources/mypage/FAMILY.png" alt="회원등급" style="width: 40px; height: 40px; margin-bottom: 10px;">
				<% } else if(gradeName.equals("SILVER")) { %>
					<span id="grade" style="color: silver;"><%= gradeName %></span>
                    <img src="./resources/mypage/SILVER.png" alt="회원등급" style="width: 40px; height: 40px; margin-bottom: 10px;">
				<% } else if(gradeName.equals("GOLD")) { %>
					<span id="grade" style="color: gold;"><%= gradeName %></span>
                    <img src="./resources/mypage/GOLD.png" alt="회원등급" style="width: 40px; height: 40px; margin-bottom: 10px;">
				<% } else if(gradeName.equals("VIP")) { %>
					<span id="grade" style="color: yellowgreen;"><%= gradeName %></span>
                    <img src="./resources/mypage/VIP.png" alt="회원등급" style="width: 40px; height: 40px; margin-bottom: 10px;">
                <% } else { %>
                	<span id="grade" style="color: plum;"><%= gradeName %></span>
                    <img src="./resources/mypage/VVIP.png" alt="회원등급" style="width: 40px; height: 40px; margin-bottom: 10px;">
                <% } %>
                    
                </div>
                <div id="gradeInfo">
                    <p>
                        <br><span style="font-weight: bold;">등급표</span><br><br>
                        <span style="color: plum; border-bottom: 1px solid plum;">VVIP</span>
                        <span style="color: yellowgreen; border-bottom: 1px solid yellowgreen;">VIP</span>
                        <span style="color: gold; border-bottom: 1px solid gold;">GOLD</span>
                        <span style="color: silver; border-bottom: 1px solid silver;">SILVER</span>
                        <span style="color: chocolate; border-bottom: 1px solid chocolate;">FAMILY</span>
                    </p>
                </div>
            </div>

            <script>
                $(document).ready(function(){
                    $("#gradeIcon").hover(function(){
                        $("#gradeInfo").css("display", "block");
                    },function(){
                        $("#gradeInfo").css("display", "none");
                    })
                });
            </script>

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
			   	<label for="memPwd" style="font-size:20px; color:orangered">회원탈퇴시 회원혜택을 이용할 수 없습니다.</label><br>
			   	<input type="password" name="memPwd" class="form-control" placeholder="비밀번호를 입력해주세요." id="deletePwd" required>
                <button type="submit" class="btn btn-sm btn-danger" onclick="return deleteMember();" style="float: right;">탈퇴하기</button>
			</div>
			 	<input type="hidden" value="<%= loginUser.getMemNo() %>" name="memNo">
			 	<input type="hidden" value="<%= loginUser.getMemPwd() %>" name="pwdCheck">
			 	<input type="hidden" value="<%= loginUser.getMemNo() %>" name="reMemNo">
			</form>
		 	</div>
			</div>
		</div>
	</div>
        
        <div id="content3" class="content">

            <div class="icon"><div class="iconImg"><a href="#"><img class="img1" src="./resources/mypage/coupons.png" alt="쿠폰"><span>쿠폰함</span></a></div></div>
            <div class="icon"><div class="iconImg"><a href="<%= contextPath %>/mypage.heart?memNo=<%= loginUser.getMemNo() %>"><img class="img1" src="./resources/mypage/favorite.png" alt="찜목록"><span>찜목록</span></a></div></div>
            <div class="icon"><div class="iconImg"><a href="<%= contextPath%>/myReview.list?memNo=<%= loginUser.getMemNo()%>"><div style="width: 80%;margin: auto;"><img class="img1" src="./resources/mypage/review.png" alt="리뷰"></div><span>내 리뷰</span></a></div></div>
            <div class="icon"><div class="iconImg"><a href="#"><img class="img1" src="./resources/mypage/events.png" alt="이벤트"><span>이벤트</span></a></div></div>
        </div>
        <div id="content4" class="content">
            
            <div class="icon"><div class="iconImg"><a href="<%=contextPath%>/myReser.list?reMemNo=<%=loginUser.getMemNo()%>"><div style="width: 80%;margin: auto;"><img class="img1" src="./resources/mypage/reservation.png" alt="예약내역"></div><span>예약내역</span></a></div></div>
            <div class="icon"><div class="iconImg"><a href="#"><div style="width: 80%;margin: auto;"><img class="img1" src="./resources/mypage/action.png" alt="이용내역"></div><span>이용내역</span></a></div></div>
            <div class="icon"><div class="iconImg"><a href="#"><div style="width: 80%;margin: auto;"><img class="img1" src="./resources/mypage/bell.png" alt="공지사항"></div><span>공지사항</span></a></div></div>
            <div class="icon"><div class="iconImg"><a href="#"><div style="width: 50%;margin: auto;"><img class="img1" src="./resources/mypage/question.png" alt="자주 묻는 질문"></div><span>자주 묻는 질문</span></a></div></div>
            
        </div>


    </div>

</body>
</html>