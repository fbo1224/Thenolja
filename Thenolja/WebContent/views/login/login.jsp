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

		#content2{
			color: lightgray;
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

		#id{
			background-image: url('resources/login/person.png');
			
			
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

		#content2 > a{
			text-decoration: none;
			color: rgb(99, 99, 99);
		}

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
					<span>로그인</span>
				</div>
				<div id="login-area" class="content">
					<form action="<%= contextPath %>/login" method="post">
						<div id="content1">
							<input type="text" name="memId" id="id" class="input" placeholder="아이디" maxlength="12" required>
							<input type="password" name="memPwd" id="password" class="input" placeholder="비밀번호" maxlength="15" required>
						</div>

						<div id="content2" class="content">
							<br><br>
							<a href="views\\member\\findId.jsp">아이디 찾기</a>
							|&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="views\\member\\findPwd.jsp">비밀번호 찾기</a>
						</div>

						<div id="content3">
							<button type="submit" class="btn">로그인</button>
						</div>

					</form>
				
				</div>
			</div>
		
		</div>
</body>
</html>