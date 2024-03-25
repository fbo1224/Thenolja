<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="thenolja.member.model.vo.Member" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
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
			width: 50%;
			margin: auto;
			border: 1px solid lightgray;
			margin-top: 50px;
		}

		.content{
			width: 100%;
			margin: auto;
		}

		#loginword{margin-top: 10px; color: rgb(70, 149, 151);}

		#loginword > span{
			text-align: center; 
			height: 100px;
			font-size: 40px;
			font-weight: bold;
		}
		
		
		#login-area{width: 100%; height: 100%;}
		
		#pwdCheck2, #password{
			margin-top: 20px;
		}

        #pwdCheck2{
            background-color: rgb(255, 218, 224);
            color: red;
            margin: auto;
            margin-top: 10px;
            height: 30px;
        }

		#password{
			background-image: url('resources/login/password.png');
		}

		.input:focus{
			border-color: rgb(70, 149, 151);
		}

		.input{
			width: 400px;
			height: 50px;
			border-color: rgb(230, 230, 230);
			border-radius: 10px;
			background-repeat: no-repeat;
			background-size: 30px;
			background-position: right;
		}
		#content{text-align: center;}

		#content3{
			margin-top: 50px;
		}

		div > .btn{
			width: 400px;
			height: 50px;
			background-color: rgb(70, 149, 151);
			color: white;
			font-size: 20px;
			font-weight: bold;
			margin-bottom: 30px;
		}

	
	
	</style>

</head>
<body>
	<%@ include file="../common/menubar.jsp" %>

	
      
		<div id="wrap">
			<div id="content">
				<div id="loginword">
					<span>비밀번호 확인</span>
				</div>
				<div id="login-area" class="content">
				
					<!-- <form action="<%-- ><%= contextPath %>--%>/#" method="post"> -->
						<div id="content1">
							<input type="password" name="memPwd" id="password" class="input" placeholder="본인 확인을 위해 비밀번호를 입력해주세요." maxlength="15" required>
							<div id="pwdCheck2" class="input"></div>
						</div>

						<div id="content3">
                            <button class="btn" onclick="pwdCheck()">비밀번호 확인</button>
							<button type="submit" class="btn" id="next" disabled onclick="location.href='<%= contextPath%>/update.me'">다음</button>
						</div>
                        
                        <script>
                            function pwdCheck(){
                                const pwd = document.getElementById('password');
                                const pwdCheck = document.getElementById('pwdCheck2');
                                const next = document.getElementById('next');
                                
                                if('<%= loginUser.getMemPwd()%>' != pwd.value){
                                	pwdCheck.innerHTML = "비밀번호가 일치하지 않습니다.";
                                    pwd.value = '';
                                    return false;
                                } 
                                else{
                                    pwdCheck.innerHTML = "비밀번호가 일치합니다.";
                                    next.disabled = false;
                                    return true;
                                }
                            }        

                        </script>

					<!-- </form> -->
				
				</div>
			</div>
		
		</div>
</body>
</html>