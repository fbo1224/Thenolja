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
			width: 120px;
			height: 50px;
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
		font-size: 16px;
		padding-left: 10px;
	}

	#title{
		margin-top: 20px; 
		color: rgb(70, 149, 151);
		height: 100px;
		border-bottom: 1px solid lightgray;
	}

	#title > span{
		text-align: center;
		font-weight: bold;
		font-size: 45px;
	}
		
	#table{
		margin-top: 20px;
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
					<td id="idWord">아이디</td>
					<td><input type="text" maxlength="12" required name="memId" placeholder="4~12 영숫자" autofocus></td>
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
										//$('#enroll-form button[type=submit]').removeAttr('disabled');
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
					<td><input type="password" maxlength="15" required name="memPwd" class="pwdCheck" placeholder="4~15 영숫자"></td>
					<td></td>
				</tr>
				
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" maxlength="15" required id="memPwd2" class="pwdCheck"></td>
					
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
								memJoin.disabled = false;
								return true;
							}
						}
					</script>
					
				</tr>
				
				<tr>
					<td>이름</td>
					<td><input type="text" maxlength="5" required name="memName" id="name"></td>
					<td></td>
				</tr>
				
				<tr>
					<td>닉네임</td>
					<td><input type="text" maxlength="10" required name="nickname" placeholder="한글 또는 영숫자"></td>
					<td><button class="btn btn-sm btn-primary" type="button" onclick="nickNameCheck();">중복확인</button></td>
				</tr>

				<script>
					function nickNameCheck(){
						
						const $nickname = $('#enroll-form input[name=nickname]');
						// console.log($nickname);
						$.ajax({ 
							url : 'nickNameCheck.do',
							data : {checkNickname : $nickname.val()},
							success : function(result){
								
								if(result =='NNNNN'){ // 중복된 닉네임
									alert('중복되는 닉네임입니다.');
								
									$nickname.val('').focus();
								
								} else { // 중복 X == 사용 가능
									
									if(confirm('사용 가능한 닉네임입니다. 사용하시겠습니까?')){
										$nickname.attr('readonly', true);
									}
									else{
										$nickname.focus();
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
					<td>전화번호</td>
					<td><input type="text" placeholder="-제외하고 입력해주세요." maxlength="11" name="memPhone" required></td>
					<td id="phoneMent"></td>
				</tr>

				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" placeholder="@포함하여 입력해주세요." required></td>
					<td><button class="btn btn-sm btn-primary" type="button" onclick="emailCheck();">중복확인</button></td>
				</tr>

				<script>
					function emailCheck(){
						
						const $email = $('#enroll-form input[name=email]');
						// console.log($nickname);
						$.ajax({ 
							url : 'emailCheck.do',
							data : {checkEmail : $email.val()},
							success : function(result){
								
								if(result =='NNNNN'){ // 중복된 닉네임
									alert('중복되는 이메일입니다.');
								
									$email.val('').focus();
								
								} else { // 중복 X == 사용 가능
									
									if(confirm('사용 가능한 이메일입니다. 사용하시겠습니까?')){
										$email.attr('readonly', true);
										
										// 중복확인 전 막아두었던 submit버튼 활성화
										$('#enroll-form button[type=submit]').removeAttr('disabled');
									}
									else{
										$email.focus();
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
					<td>생년월일</td>
					<td><input type="text" name="bornDate" placeholder="생년월일 8자리를 입력해주세요." maxlength="8" required></td>
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

		<!-- 정규표현식 -->
		<script>
			/* 아이디 */
			$('input[name=memId]').blur(function(){
				const idReg =  /^[A-Za-z0-9]{4,12}$/;
				const idVal = $('input[name=memId]').val();

				if(!idReg.test(idVal)){
					$('input[name=memId]').val('');
					$('input[name=memId]').css('border-color','orangered');
				}
				else{
					$('input[name=memId]').css('border-color', 'rgb(230, 230, 230)');
				}
			});
		</script>

		<script>
			/* 비밀번호 */
			$('input[name=memPwd]').blur(function(){
				const pwdReg =  /^[A-Za-z0-9]{4,15}$/;
				const pwdVal = $('input[name=memPwd]').val();

				if(!pwdReg.test(pwdVal)){
					$('input[name=memPwd]').val('');
					$('input[name=memPwd]').css('border-color','orangered');
				}
				else{
					$('input[name=memPwd]').css('border-color','rgb(230, 230, 230)');
				}
			});
		</script>

		<script>
			/* 비밀번호 확인 */
				$('#memPwd2').blur(function(){
					const pwdReg2 = /^[A-Za-z0-9]{4,15}$/;
					const pwdVal2 = $('#memPwd2').val();

					if(!pwdReg2.test(pwdVal2)){
						$('#memPwd2').val('');
						$('#memPwd2').css('border-color','orangered');
					}
					else{
						$('#memPwd2').css('border-color','rgb(230, 230, 230)');
					}
				});
		</script>

		<script>
			/* 이름 */
			$('input[name=memName]').blur(function(){
					const memNameReg = /^[ㄱ-ㅎ|가-힣|a-z|A-Z|]{2,15}$/;
					const memNameVal = $('input[name=memName]').val();

					if(!memNameReg.test(memNameVal)){
						$('input[name=memName]').val('');
						$('input[name=memName]').css('border-color','orangered');
					}
					else{
						$('input[name=memName]').css('border-color','rgb(230, 230, 230)');
					}
				});
		</script>

		<script>
			/* 닉네임 */
			$('input[name=nickname]').blur(function(){
					const nicknameReg = /^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9|]{2,15}$/;
					const nicknameVal = $('input[name=nickname]').val();

					if(!nicknameReg.test(nicknameVal)){
						$('input[name=nickname]').val('');
						$('input[name=nickname]').css('border-color','orangered');
					}
					else{
						$('input[name=nickname]').css('border-color','rgb(230, 230, 230)');
					}
				});
		</script>

		<script>
			/* 전화번호 */
			$('input[name=memPhone]').blur(function(){
				const phoneReg = /^01([0|1|])-?([0-9]{4})-?([0-9]{4})$/;
				const phoneVal = $('input[name=memPhone]').val();

				if(!phoneReg.test(phoneVal)){
					$('input[name=memPhone]').val('');
					$('input[name=memPhone]').css('border-color','orangered');
				}
				else{
					$('input[name=memPhone]').css('border-color','rgb(230, 230, 230)');
				}
			});
		</script>

		<script>
			/* 이메일 */
			$('input[name=email]').blur(function(){
				const emailReg = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/
				const emailVal = $('input[name=email]').val();

				if(!emailReg.test(emailVal)){
					$('input[name=email]').val('');
					$('input[name=email]').css('border-color','orangered');
				}
				else{
					$('input[name=email]').css('border-color','rgb(230, 230, 230)');
				}
			});
		</script>

		<script>
			/* 생년월일 */
			$('input[name=bornDate]').blur(function(){
				const bornDateReg = /^(19|20)\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\d|3[01])$/
				const bornDateVal = $('input[name=bornDate]').val();

				if(!bornDateReg.test(bornDateVal)){
					$('input[name=bornDate]').val('');
					$('input[name=bornDate]').css('border-color','orangered');
				}
				else{
					$('input[name=bornDate]').css('border-color','rgb(230, 230, 230)');
				}
			});
		</script>
	</div>




</body>
</html>