<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String memId = (String)request.getAttribute("memId");
	// System.out.println(memId);
%>
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
		
		.input{
			width: 250px;
			height: 40px;
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

		#checkBtn{
			width: 120px;
			height: 30px;
			background-color: #BBC6C8;
			color: black;
			font-size: 15px;
			border-radius: 10px;
			border: none;
		}


		img{
			width: 150px;
			height: 150px;
		}

		#newPwd1{
			margin-right: 120px;
		}
		#newPwd2{
			margin-left: 20px;
		}


	
	
	</style>

</head>
<body>
	<%@ include file="../common/menubar.jsp" %>

	
      
		<div id="wrap">
			<div id="content">
				<div id="loginword">
					<span>비밀번호 재설정</span>
				</div>
				<div id="login-area" class="content">
					<form action="<%= contextPath %>/find.resetPwd" method="post">
						<input type="hidden" name="memId" value="<%= memId %>">
						<div id="content1">
							<img src="resources/login/password.png" alt="프로필">
						</div>
						<div id="content2" class="content">
                            <span>새로운 비밀번호</span>
                            <input type="password" id="newPwd1" required class="input">
						</div>
						<div>
                            <span>비밀번호 확인</span>
                            <input type="password" id="newPwd2" required class="input" name="password">
                            <button type="button" onclick="pwdCheck()" id="checkBtn">비밀번호 확인</button>
						</div>
						<div id="checkPrint"></div>

						<script>
							function pwdCheck() {
								const newPwd1 = document.getElementById('newPwd1');
								const newPwd2 = document.getElementById('newPwd2');
								const checkPrint = document.getElementById('checkPrint');
								const next = document.getElementById('next');
								

								if(newPwd1.value != newPwd2.value){
									checkPrint.innerHTML = '비밀번호가 일치하지 않습니다.';
									checkPrint.style ="color: red;"
									newPwd1.value = '';
									newPwd2.value = '';

								}
								else {
									checkPrint.innerHTML = '비밀번호가 일치합니다. ✓';
									checkPrint.style ="color: green;"
								}

							}
						</script>
						
						<div id="content3">
                            <button class="btn" type="reset">취소</button>
                            <button class="btn" type="submit" id="next">변경하기</button>
						</div>
                        <div id="pwdCheck2"></div>
					</form>
				</div>
			</div>
		
		</div>
</body>
</html>