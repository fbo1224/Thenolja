<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 재설정</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<style>
		/*div{border: 1px solid red;}*/
		#wrap{
			width: 1200px;
			height: 600px;
			margin: auto;
		}

		#content{
			width: 60%;
			margin: auto;
			border: 1px solid lightgray;
			margin-top: 50px;
		}


		#loginword{margin-top: 10px; color: rgb(70, 149, 151);}

		#loginword > span{
			text-align: center; 
			height: 100px;
			font-size: 40px;
			font-weight: bold;
		}
		
		
		#login-area{width: 100%; height: 100%;}
		
		#id, #password{
			margin-top: 20px;
		}

		.input{
			width: 400px;
			height: 50px;
			border-color: rgb(230, 230, 230);
			border-radius: 10px;
			background-repeat: no-repeat;
			background-size: 30px;
			background-position: right;
            padding-left: 10px;
            margin-top: 20px;
		}
		#content{text-align: center;}

		#content3{
			margin-top: 30px;
		}

		div > .btn{
			width: 150px;
			height: 40px;
			background-color: rgb(70, 149, 151);
			color: white;
			font-size: 15px;
			font-weight: bold;
			margin-bottom: 30px;
			margin: 40px;
            border-radius: 10px;
		}


		img{
			width: 200px;
			height: 200px;
		}

	
	
	</style>

</head>
<body>
	<%@ include file="../common/menubar.jsp" %>

	
      
		<div id="wrap">
			<div id="content">
				<div id="loginword">
					<span>새로운 비밀번호를 입력해주세요.</span>
				</div>
				<div id="login-area" class="content">
					<form action="<%= contextPath %>/findPwd" method="post">
						<div id="content1">
							<img src="resources/mypage/person.png" alt="프로필">
						</div>
						<div id="content2" class="content">
                            새로운 비밀번호
                            <input type="password" id="pwd1">
                            새로운 비밀번호 확인
                            <input type="password" id="newPwd">
                            <button id="pwdCheck1" onclick="pwdCheck()">비밀번호 확인</button>
						</div>

						<div id="content3">
                            <button class="btn" type="reset">취소</button>
                            <button class="btn" type="submit" id="next" disabled>변경하기</button>
						</div>
                        <div id="pwdCheck2"></div>
                    </form>

                    <script>
                        function pwdCheck(){
                            const pwd = document.getElementById('newPwd');
                            const pwdCheck = document.getElementById('pwdCheck2');
                            const next = document.getElementById('next');
                            
                            if('<%= loginUser.getMemPwd()%>' != pwd.value){
                                pwdCheck.innerHTML = "비밀번호가 일치하지 않습니다.";
                                pwd.value = '';
                                pwdCheck.style = "color:red; background-color:rgb(255, 218, 224); display:block;"
                                return false;
                            } 
                            else{
                                pwdCheck.innerHTML = "비밀번호가 일치합니다. ✓";
                                next.disabled = false;
                                pwdCheck.style = "color:green; background-color:lightgreen; display:block;";
        
                                return true;
                            }
                        }        
        
                    </script>
				</div>
			</div>
		
		</div>
</body>
</html>