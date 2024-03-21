<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<head>
		<meta charset="UTF-8">
		<title>숙소 추가</title>
		<style>
			div {
				box-sizing: border-box;
			}

			#wrap {
				width: 1200px;
				height: 850px;
				margin: auto;
				padding : 10px;
			}

			#title-div {
				width: 100%;
				height: 10%;
				margin: auto;
			}

			#title-div>h2 {
				margin-top: 15px;
				margin-left: 15px;
				font-weight: bold;
			}

			#content-div {
				width: 100%;
				height: 90%;
				margin: auto;
			}

			#content-add-form {
				width: 100%;
				height: 100%;
				padding: 5px;
			}

			#content-div-half1 {
				display: inline-block;
				width: 50%;
				height: 70%;
			}

			#content-div-half2 {
				width: 50%;
				height: 70%;
				float: right;
			}

			#addr-div,
			#hotel-nameNImg,
			#nameNPhone,
			#hotel-checkTime {
				width: 90%;
				height: 31%;
				border-top: 1px solid gray;
				border-bottom: 1px solid gray;
			}
			#hotel-cate, #hotel-serviceList{
				width: 90%;
				height: 31%;
			}
			#addr-div {
				padding: 5px;
			}
			#addr-div input {
				margin: 2px;
			}
			#hotel-cate{
				padding: 10px;
			}
			.hotel-cate-div{
				width: 80%;
				height: 40%;
				margin: auto;
				padding: 10px;
			}
			.hotel-cate-div label{
				width: 72px;
				margin: 0px;
			}
			.hotel-cate-div input{
				padding: 5px;
			}
			.hotel-cate-div select{
				width: 50%;
				padding: 5px;
			}
			#phone-label{
				margin-left: 50px;
			}
			#nameNPhone-div-1{
				width: 80%; 
				margin: auto;
			 	padding: 10px;
			 	text-align: center;
			}
			#nameNPhone-div-2{
				width:80%;
				margin: auto;
			}
			#Phone-div-1{
				width: 60px;
			}
			#Phone-div-2{
				width: 60%;
			}
			#nameNimg-div{
				width:80%;
				margin:auto;
				padding: 10px;
				text-align: center;
			}
			#nameNimg-div label {
				display: blick;
				padding: 10px;
			}
			
			#nameNimg-div input {
				padding: 10px;
			}
			#hotel-serviceList h3{
				text-align: center;
				margin: 0px;
				padding: 5px;
			}
			#serviceList-half1{
				width: 80%;
				margin: auto;
				display:flex;
				align-items: center;
				justify-content: space-between;
			}
			#serviceList-half2{
				width: 80%;
				margin: auto;
				display:flex;
				align-items: center;
				justify-content: space-between;
			}
			#serviceList-half1 label,input{
				margin: 0px;
			}
			#serviceList-half2 label,input{
				padding: 5px;
				margin: 0px;
			}
			label{
				font-size: 18px;
				margin: 0px;
			}
			#intro-text-area {
				width: 100%;
				padding: 5px;
			}
			#intro-text-area  {
			
			}
			#intro-text-area label{
				display:block;
				text-align: center;
			}
			#intro-text-area div{
				width: 50%;
				margin: auto;
			}
			#intro-text-area textarea{
				width: 100%;
				resize:false;
			}
			.checkTime-div{
			 width: 60%; 
			 height: 40%;
			 margin: auto;
			 padding: 15px;
			}
			.checkTime-div input{
			
			}
		</style>
	</head>

	<body>
		<%@ include file="../common/adminMenubar.jsp" %>

			<div id="wrap">
				<div id="title-div">
					<h2>숙소추가하기</h2>
				</div>
				<div id="content-div">
					<form id="content-add-form" action="#" enctype="multipart/form-data">
						<div id="content-div-half1">
							<div id="addr-div">
								<input type="text" id="sample4_postcode" placeholder="우편번호" name="letterNo">
								<input type="button" onclick="findAddrs();" value="우편번호 찾기"><br>
								<input type="text" id="sample4_roadAddress" placeholder="도로명주소">
								<%-- <input type="text" id="sample4_jibunAddress" placeholder="지번주소"> --%>
								<span id="guide" style="color:#999;display:none"></span>
								<input type="text" id="sample4_detailAddress" placeholder="상세주소" name="detailAddr">
								<input type="text" id="sample4_extraAddress" placeholder="참고항목" name="abouts">
							</div>

							<div id="hotel-cate">
								<div class="hotel-cate-div" >
								<label>숙소종류</label>
									<select class="form-control">
										<option>호텔</option>
										<option>모텔</option>
										<option>게스트하우스</option>
										<option>캠핑/글림핑</option>
									</select>
								</div>
								<div class="hotel-cate-div">
									<label>숙소명</label>
									<input class="form-control" type="text" name="hotelName">
								</div>
							</div>

							<div id="hotel-nameNImg">
								<div id="nameNimg-div">
									<label>숙소대표사진</label>
									<input type="file">
								</div>
							</div>
						</div>

						<div id="content-div-half2">
							<div id="nameNPhone">
								<div id="nameNPhone-div-1">
									<label>대표자명</label>
									<input type="text" class="form-control" name="ceoName">
								</div>

								<label id="phone-label">전화번호</label>
								<div id="nameNPhone-div-2">
									<input class="form-control" id="Phone-div-1" type="text" name="phone1" value="010" readonly>
									<input class="form-control" id="Phone-div-2" type="text" name="phone2" placeholder="-제외한 숫자만 입력해주세요.">
								</div>
							</div>

							<div id="hotel-serviceList">
								<div>
									<h3>숙소 이용 가능한 서비스 목록</h3>
								</div>
								<div id="serviceList-half1">
									<label>wifi</label><input class="form-check-input" type="checkbox" value="wifi">
									<label>금연</label><input class="form-check-input" type="checkbox" value="금연">
									<label>헬스장</label><input class="form-check-input" type="checkbox" value="헬스장">
									<label>에어컨</label><input class="form-check-input" type="checkbox" value="에어컨">
								</div>
								<div id="serviceList-half2">
									<label>주차장</label><input class="form-check-input" type="checkbox" value="주차장">
									<label>반려견동반</label><input class="form-check-input" type="checkbox" value="반려견동반">
									<label>엘레베이터</label><input class="form-check-input" type="checkbox" value="엘레베이터">
									<label>pc</label><input class="form-check-input" type="checkbox" value="pc">
								</div>

							</div>

							<div id="hotel-checkTime">
								<div class="checkTime-div">
									<label>입실시간</label>
									<input type="time" name="in_time">
								</div>
								<div class="checkTime-div" >
									<label>퇴실시간</label>
									<input type="time" name="out_time">
								</div>
							</div>
						</div>
						
						<div id="intro-text-area">
							<label for="intro">소개말을 적어주세요</label>
							<div>
								<textarea class="form-control" rows="5" id="intro"></textarea>
							</div>
						</div>
						
						<div align="center">
							<button class="btn btn btn-outline-info" type="submit">추가</button>
						</div>
					</form>

				</div>
			</div>
			
			
			
		<script>
		console.log();
	    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
	    function findAddrs() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var roadAddr = data.roadAddress; // 도로명 주소 변수
	                var extraRoadAddr = ''; // 참고 항목 변수
	
	                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                    extraRoadAddr += data.bname;
	                }
	                // 건물명이 있고, 공동주택일 경우 추가한다.
	                if(data.buildingName !== '' && data.apartment === 'Y'){
	                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                }
	                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                if(extraRoadAddr !== ''){
	                    extraRoadAddr = ' (' + extraRoadAddr + ')';
	                }
	
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('sample4_postcode').value = data.zonecode;
	                document.getElementById("sample4_roadAddress").value = roadAddr;
	                //document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
	                
	                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
	                if(roadAddr !== ''){
	                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
	                } else {
	                    document.getElementById("sample4_extraAddress").value = '';
	                }
	
	                var guideTextBox = document.getElementById("guide");
	                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
	                if(data.autoRoadAddress) {
	                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
	                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
	                    guideTextBox.style.display = 'block';
	
	                } else if(data.autoJibunAddress) {
	                    var expJibunAddr = data.autoJibunAddress;
	                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
	                    guideTextBox.style.display = 'block';
	                } else {
	                    guideTextBox.innerHTML = '';
	                    guideTextBox.style.display = 'none';
	                }
	            }
	        }).open();
	    }
	</script>
	</body>

	</html>