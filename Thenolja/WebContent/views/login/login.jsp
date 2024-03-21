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
		div{border: 1px solid red;}
		#wrap{
			width: 1200px;
			height: 1000px;
			margin: auto;
		}

		#content{
			width: 50%;
			margin: auto;
		}

		.content{
			width: 100%;
			height: 20%;
			margin: auto;
		}

		#loginword > span{
			text-align: center; 
			height: 100px;
			font-size: 40px;
			font-weight: bold;
			margin-left: 240px;
		}
		#login-area{width: 100%; height: 100%;}
		
		#password{
			margin-top: 20px;
		}

		.input{
			width: 400px;
			height: 50px;
		}


		#content2 > a{
			text-align: center;
			text-decoration: none;
			color: black;
		}

		#loginbutton{
			border: none;
			background-color: blue;
			width: 100px;
			height: 50px;
		}

		div > .btn{
			width: 300px;
			height: 60px;
			background-color: rgb(70, 149, 151);
			color: white;
			font-size: 20px;
			font-weight: bold;
		}

	
	
	</style>

</head>
<body>
	<%@ include file="../common/menubar.jsp" %>

	
	<% if(loginUser == null) { %>    	
      
		<div id="wrap">
			<div id="content">
				<div id="loginword">
					<span>로그인</span>
				</div>
				<div id="login-area" class="content">
					<form action="<%= contextPath %>/login" method="post">
						<div id="contnet1">
							<table>
								<tr>
									<td>
										<input type="text" name="memId" id="id" class="input" placeholder="아이디 입력" maxlength="12" required>
										<br>아이디가 일치하지 않습니다.
									</td>
								</tr>
								<tr>
									<td>
										<input type="password" name="memPwd" id="password" class="input" placeholder="비밀번호 입력" maxlength="15" required>
										<br><a href="">비밀번호를 잊으셨나요?</a>
									</td>
								</tr>
							</table>
						</div>


						<div id="content2" class="content">
							<br><br>
							<a href="">아이디 찾기</a>
							/
							<a href="">비밀번호 찾기</a>&nbsp;&nbsp;|&nbsp;&nbsp;
							<a href="views\\member\\memberJoin.jsp" >회원가입</a>
						</div>

						<div id="content3">
							<button type="submit" class="btn">로그인</button>
						</div>

						<div id="content4" class="content">
							<button type="button" class="btn" onclick="enrollPage();">회원가입</button>

						</div>
					</form>
				
				</div>
			</div>
		<% } else { %>
			<div id="user-info">
            	<span><%= loginUser.getMemName() %></span>님 환영합니다~!!<br><br>
            <div>
                <a href="<%=contextPath %>/myPage" class="btn btn-sm btn-primary">마이페이지</a>
                <a href="<%=contextPath %>/logout" class="btn btn-sm btn-primary">로그아웃</a>
            </div>
        </div>

		<% } %>
		
	</div>
</body>
</html>