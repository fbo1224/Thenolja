<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	#changeBtn, #reset{
			border: none;
			background-color: rgb(70, 149, 151);
			width: 100px;
			height: 40px;
			color: white;
			margin-top: 30px;
			margin-left: 70px;
	}

	#changeBtn:hover, #reset:hover{
		color: black;
	}

	#word{
		text-align: center; 
		height: 100px;
		font-size: 40px;
		font-weight: bold;
		margin-top: 10px; 
		color: rgb(70, 149, 151);
	}

	input{
		width: 400px;
		height: 50px;
		border-color: rgb(230, 230, 230);
		border-radius: 10px;
		background-repeat: no-repeat;
		background-size: 30px;
		background-position: right;
		padding: 10px;
	}

</style>


</head>
<body>
	<%@ include file="../common/menubar.jsp" %> 
	
	
	<div class="outer">
		<br>
		<div id="word">
			<span align ="center">정보수정</span>

		</div>
		
		<form id="mypage-form" method="post" action="<%=contextPath%>/update.me">
			<table align="center">

				<tr>
					<td>이름</td>
					<td><input type="text" maxlength="5" required name="memName" value="<%= loginUser.getMemName() %>"></td>
					<td></td>
				</tr>
				<tr></tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" placeholder="-포함해서 입력해주세요." name="memPhone" value="<%= loginUser.getMemPhone() %>"></td>
					<td></td>
				</tr>
				<tr></tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" value="<%= loginUser.getEmail() %>"></td>
					<td></td>
				</tr>
				<tr></tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="text" name="memPwd" value="<%= loginUser.getMemPwd() %>"></td>
					<td></td>
				</tr>
				<tr></tr>

			</table>
			
			

			<div align="center">
				<button type="reset" id="reset">초기화</button>
				<button type="submit" id="changeBtn">변경하기</button>
				<input type="hidden" value="<%= loginUser.getMemNo() %>" name="memNo">
				<input type="hidden" value="<%= loginUser.getMemId() %>" name="memId">
			</div>

			<br><br>
		
		</form>
	</div>
	
	
	
	
</body>
</html>