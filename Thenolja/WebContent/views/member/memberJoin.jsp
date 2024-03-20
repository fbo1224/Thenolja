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
		}
	</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %> 
	<!-- 상위폴더로 가는 법 : ../ -->

	<div class="outer">
		<br>
		<h2 align ="center">회원가입</h2>
		
		<form id="enroll-form" method="post" action="<%=contextPath%>/insert.me">
			<table align="center">
				<tr>
					<td>* 아이디</td>
					<td><input type="text" maxlength="12" required name="userId"></td>
					<td><button type="button">중복확인</button></td>
					<!-- 중복확인 나중에 AJAX배우고 다음주..? -->
				</tr>
				<tr>
					<td>* 비밀번호</td>
					<td><input type="password" maxlength="15" required name="userPwd"></td>
					<td></td>
				</tr>
				<tr>
					<td>* 비밀번호확인</td>
					<td><input type="password" maxlength="15" required></td>
					<td></td>
				</tr>
				<tr>
					<td>* 이름</td>
					<td><input type="text" maxlength="5" required name="userName"></td>
					<td></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;전화번호</td>
					<td><input type="text" placeholder="-포함해서 입력해주세요." name="phone"></td>
					<td></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;이메일</td>
					<td><input type="email" name="email"></td>
					<td></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;주소</td>
					<td><input type="text" name="address"></td>
					<td></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;취미</td>
					<td colspan="2">
						<input type="checkbox" id="travel" value="여행" name="interest"><label for="travel">여행</label>
						<input type="checkbox" id="lodge" value="숙박" name="interest"><label for="lodge">숙박</label>
						<input type="checkbox" id="movie" value="영화" name="interest"><label for="movie">영화</label>

						<br>

						<input type="checkbox" id="lent" value="차량대여" name="interest"><label for="lent">차량대여</label>
						<input type="checkbox" id="tea" value="다도" name="interest"><label for="tea">다도</label>
						<input type="checkbox" id="java" value="자바" name="interest"><label for="java">자바</label>
					</td>
				</tr>
			</table>

			<br><br>

			<div align="center">
				<button type="reset">취소</button>
				<button type="submit">회원가입</button>
			</div>

			<br><br>
		
		</form>
	
	
	</div>




</body>
</html>