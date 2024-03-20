<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="thenolja.member.model.vo.Member" %>
<%
	// Member loginUser = (Member)session.getAttribute("loginUser");
	
	// String alertMsg = (String)session.getAttribute("alertMsg");
%>
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
		#wrap{
			width: 1200px;
			height: 800px;
		}


		#content{
			width: 50%;
			height: 500px;
			margin: auto;
		}

		#content1 > span{
			text-align: center; 
			height: 100px;
			font-size: 40px;
			font-weight: bold;
			margin-left: 240px;
		}
		#login-area{width: 100%; height: 200px;}
		#login-area > form{
			margin-left: 100px;
			margin-top: 50px;
		}
		
		#password{
			margin-top: 20px;
		}

		.input{
			width: 400px;
			height: 50px;
		}

		.content3{
			width: 300px;
			height: 100%;
		}

		#content2{width: 100%; height: 100px;}
		#content3{width: 100%; height: 100px;}

		#content2 > a{
			text-align: center;
			text-decoration: none;
			color: black;
		}

		#footer{
			width: 100%;
			height: 100px;
		}

		#loginbutton{
			border: none;
			background-color: blue;
			width: 100px;
			height: 50px;
		}

		.btn{
			width: 300px;
			height: 60px;
			background-color: rgb(70, 149, 151);
			color: white;
			font-size: 20px;
			font-weight: bold;
		}

		#content2{
			text-align: center;
		}
	
		/* div{border: 1px solid red;} */
	
	</style>

</head>
<body>
	<%@ include file="../common/menubar.jsp" %>

	
	<% if(loginUser == null) { %>
		<div id="wrap">
			<div id="content">
				<div id="content1" class="content">
					<span>로그인</span>
				</div>
				<div id="login-area" class="content">
					<form action="<%= contextPath %>/login" method="post">
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
						<div id="content2" class="content">
							<br><br>
							<a href="">아이디 찾기</a>
							/
							<a href="">비밀번호 찾기</a>&nbsp;&nbsp;|&nbsp;&nbsp;
							<a href="../member/memberJoin.jsp" >회원가입</a>
						</div>
						<div id="content3" class="content">
							<div class="content3">
								<button type="submit" class="btn">로그인</button>
							</div>
							<div class="content3">
								<button type="button" class="btn" onclick="enrollPage();">회원가입</button>
							</div>
						</div>
					</form>
				
				</div>
			</div>
			<div id="footer"></div>
		<% } else { %>
			        <div id="user-info">
            <span><%= loginUser.getMemName() %></span>님 환영합니다~!!<br><br>
            <div>
                <a href="<%=contextPath %>/myPage" class="btn btn-sm btn-primary">마이페이지</a>
                <!-- <a href="/jsp/logout">로그아웃</a> -->
                <a href="<%=contextPath %>/logout" class="btn btn-sm btn-primary">로그아웃</a>
            </div>
        </div>
		<% } %>
		
	</div>
</body>
</html>