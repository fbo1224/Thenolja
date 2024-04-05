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
			border-radius: 10px;
	}

	#changeBtn:hover, #reset:hover, #pwdCheck1:hover{
		color: black;
	}

	#pwdCheck1{
		border: none;
		background-color: rgb(202, 202, 161);
		width: 100px;
		height: 40px;
		color: white;
		font-size: 13px;
		border-radius: 10px;
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

	#pwdCheck2{
            margin: auto;
            height: 20px;
			display: none;
			border-radius: 10px;
        }

	.input:focus{
		border-color: rgb(70, 149, 151);
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
					<td><input type="text" maxlength="5" required name="memName" value="<%= loginUser.getMemName() %>" autofocus></td>
					<td></td>
				</tr>
				<tr></tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" placeholder="-포함해서 입력해주세요." name="memPhone" value="<%= loginUser.getMemPhone() %>" required></td>
					<td></td>
				</tr>
				<tr></tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" value="<%= loginUser.getEmail() %>" required></td>
					<td></td>
				</tr>
				<tr></tr>
				<tr>
					<td>새로운 비밀번호</td>
					<td><input type="password" name="memPwd" id="newPwd1" required></td>
				</tr>
				<tr>
					<td>새로운 비밀번호 확인</td>
					<td><input type="password" id="newPwd2" required></td>
					<td><button type="button" id="pwdCheck1" onclick="pwdCheck()">비밀번호 확인</button></td>
				</tr>
				<tr>
					<td></td>
					<td><div id="pwdCheck2"></div></td>
				</tr>

			</table>

			<script>
				function(){
					const phone = document.getElementsByName('memPhone');

					const regExp = /^\d{3}-\d{3,4}-\d{4}$/;

					if(!regExp.test(phone.value)){
						phone.style="border-color: red;"
						phone.value = '';
					}

				}
			</script>
			
			<script>
				function pwdCheck(){
					const pwd1 = document.getElementById('newPwd1');
					const pwd2 = document.getElementById('newPwd2');
					const pwdCheck = document.getElementById('pwdCheck2');
					const next = document.getElementById('next');
					
					if(pwd1.value != pwd2.value){
						pwdCheck.innerHTML = "비밀번호가 일치하지 않습니다.";
						pwd1.value = '';
						pwd2.value = '';
						pwdCheck.style = "color:red;  display:block;"
						/*next.disabled = true;*/
						return false;
					}
					else{+
						pwdCheck.innerHTML = "비밀번호가 일치합니다. ✓";
						pwdCheck.style = "color:green; display:block;";
						/*next.disabled = false;*/

						return true;
					}
				}        

			</script>

			<div align="center">
				<button type="reset" id="reset">초기화</button>
				<button type="submit" id="changeBtn" id="next">변경하기</button>
				<input type="hidden" value="<%= loginUser.getMemNo() %>" name="memNo">
				<input type="hidden" value="<%= loginUser.getMemId() %>" name="memId">
			</div>

			<br><br>
		
		</form>
	</div>
	
	
	
	
</body>
</html>