<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
	<style>
		#enroll-form input{
			margin : 8px;
			width: 300px;
			height: 40px;
		}
		
		#title{
			font-weight="bolder";
		}
		
	</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %> 

	<div class="outer">
		<br>
		<h1 align ="center" id="title">회원가입</h2>
		
		<form id="enroll-form" method="post" action="<%=contextPath%>/insert.me">
			<table align="center" id="table">
				<tr>
					<td>아이디</td>
					<td><input type="text" maxlength="12" required name="userId"></td>
					<td><button class="btn btn-sm btn-primary" type="button" onclick="idCheck()">중복확인</button></td>
				</tr>
				
				<script>
					function idCheck(){
						
						const $userId = $('#enroll-form input[name=userId]');
						
						// AJAX요청
						$.ajax({ // 보낼 값이 많으므로 객체 만들기 {}
							url : 'idCheck.do',
							data : {checkId : $userId.val()},
							success : function(){
								 
								
							},
							error : function(){
								console.log('AJAX통신실패~@!');
							}
						});
						
						
					}
				
				</script>
				
				<tr>
					<td>비밀번호</td>
					<td><input type="password" maxlength="15" required name="userPwd"></td>
					<td></td>
				</tr>
				<tr>
					<td>비밀번호확인</td>
					<td><input type="password" maxlength="15" required></td>
					<td><span id="pwdCheck">비밀번호가 일치하지 않습니다.</span></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" maxlength="5" required name="memName"></td>
					<td></td>
				</tr>
								<tr>
					<td>닉네임</td>
					<td><input type="text" maxlength="30" required name="nickname"></td>
					<td></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" placeholder="-제외하고 입력해주세요." name="memphone"></td>
					<td></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email"></td>
					<td>@</td>
					<select>
						<option></option>
					</select>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="text" name="address" placeholder="생년월일 8자리를 입력해주세요."></td>
					<td></td>
				</tr>

			</table>

			<br><br>

			<div align="center">
				<button type="reset" class="btn btn-sm btn-secondary">취소</button>
				<button type="submit" class="btn btn-sm btn-primary" disabled>회원가입</button>
			</div>

			<br><br>
		
		</form>
	
	
	</div>




</body>
</html>