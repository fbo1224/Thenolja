<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
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
		width: 300px;
		height: 40px;
		border-color: rgb(230, 230, 230);
		border-radius: 10px;
		background-repeat: no-repeat;
		background-size: 30px;
		background-position: right;
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

	td{
		border-bottom: 1px solid lightgray;
		margin-bottom: 10px;
	}

	#title{
		margin-top: 30px; 
		color: rgb(70, 149, 151);
		height: 100px;
	}

	#title > span{
		text-align: center;
		font-weight: bold;
		font-size: 40px;
	}
		
	#table{
		margin-top: 30px;
		border-collapse: separate;
		border-spacing : 15px;
	}
</style>
	
	
</head>
<body>

	<%@ include file="../common/menubar.jsp" %> 

	<div class="outer">
		<br>
		<div id="title" align="center">
			<span>회원가입</span>
		</div>
		<form id="enroll-form" method="post" action="<%=contextPath%>/insert.me">
			<table align="center" id="table">
				<tr>
					<td>아이디</td>
					<td><input type="text" maxlength="12" required name="memId" autofocus></td>
					<td><button class="btn btn-sm btn-primary" type="button" onclick="idCheck();">중복확인</button></td>
				</tr>
				
				<script>
					function idCheck(){
						
						const $memId = $('#enroll-form input[name=memId]');
						// console.log($memId);
						// AJAX요청
						$.ajax({ // 보낼 값이 많으므로 객체 만들기 {}
							url : 'idCheck.do',
							data : {checkId : $memId.val()},
							success : function(result){
								
								if(result =='NNNNN'){ // 중복된 아이디
									alert('이미 존재하거나 탈퇴한 회원의 아이디입니다.');
								
									$memId.val('').focus();
								
								} else { // 중복 X == 사용 가능
									
									if(confirm('사용 가능한 아이디입니다. 사용하시겠습니까?')){
										// 아이디 값은 변경이 불가능하도록 == readonly
										$memId.attr('readonly', true);
										
										// 중복확인 전 막아두었던 submit버튼 활성화
										$('#enroll-form button[type=submit]').removeAttr('disabled');
									}
									else{
										$memId.focus();
									}
								}
							},
							error : function(){
								console.log('AJAX통신실패');
							}
						});
					}
				
				</script>
				
				<tr>
					<td>비밀번호</td>
					<td><input type="password" maxlength="15" required name="memPwd" class="pwdCheck"></td>
					<td></td>
				</tr>
				
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" maxlength="15" required class="pwdCheck"></td>
					
					<td><button onclick="pwdCheck()" class="btn btn-sm btn-primary">일치확인</button></td>

					<script>
						function pwdCheck(){
							const p1 = document.getElementsByClassName('pwdCheck')[0].value;
							const p2 = document.getElementsByClassName('pwdCheck')[1].value;
							const memJoin = document.getElementById('memJoin');
							const name = document.getElementById('name');
							if(p1 != p2){
								alert("비밀번호가 일치하지 않습니다!");
									p1 = null;
									p2 = null;
								return false;
							}
							else{
								alert("비밀번호가 일치합니다.");
								name.disabled = false;
								memJoin.disabled = false;
								return true;
							}
						}
					</script>
					
				</tr>
				
				<tr>
					<td>이름</td>
					<td><input type="text" maxlength="5" required name="memName" disabled id="name"></td>
					<td></td>
				</tr>
				
				<tr>
					<td>닉네임</td>
					<td><input type="text" maxlength="30" required name="nickname"></td>
					<td></td>
				</tr>
				
				<tr>
					<td>전화번호</td>
					<td><input type="text" placeholder="-제외하고 입력해주세요." maxlength="11" name="memPhone" required></td>
					<td></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" placeholder="@포함하여 입력해주세요." required></td>
					<td></td>
					<!--
					<td>@</td>
					<td>
						<select>
							<option value="직접입력">직접입력</option>
							<option value="naver.com">naver.com</option>
							<option value="daum.net">daum.net</option>
							<option value="gmail.com">gmail.com</option>
						</select>
					</td>
					-->
				</tr>
				
				<tr>
					<td>생년월일</td>
					<td><input type="text" name="bornDate" placeholder="생년월일 8자리를 입력해주세요." required></td>
					<td></td>
				</tr>

			</table>

			<br><br>

			<div align="center">
				<button type="reset" class="btn btn-sm btn-secondary">취소</button>
				<button type="submit" class="btn btn-sm btn-primary" disabled id="memJoin">회원가입</button>
			</div>

			<br><br>
		
		</form>
	
	
	</div>




</body>
</html>