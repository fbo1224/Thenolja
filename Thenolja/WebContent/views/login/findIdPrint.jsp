<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member findId =(Member)request.getAttribute("findId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 ID 조회</title>
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
					<span>요청하신 아이디 찾기 결과입니다.</span>
				</div>
				<div id="login-area" class="content">
					<form action="<%= contextPath %>/findId" method="post">
						<div id="content1">
							<img src="resources/mypage/person.png" alt="프로필">
						</div>
						<div id="content2" class="content">
							<% if(findId == null) {  %>
								<div>입력하신 정보로 조회된 아이디가 존재하지 않습니다.</div>
							<% } else { %>
								<div>입력하신 정보로 조회된 아이디는 <%= findId.getMemId() %>입니다.</div>
							<% } %>
						</div>

					</form>
						<div id="content3">
							<button class="btn" onclick="location.href='<%= contextPath %>/loginPage'">로그인</button>
                            <button class="btn" onclick="location.href='#'">비밀번호 찾기</button>
						</div>

				
				</div>
			</div>
		
		</div>
</body>
</html>