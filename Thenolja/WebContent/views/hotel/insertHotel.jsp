<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
<html>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<head>
	<meta charset="UTF-8">
	<title>숙소 추가</title>
	<link rel="stylesheet" href="views/hotel/css/insertHotel.css">
</head>
	<body>
		<jsp:include page="../common/menubar.jsp" />
			<div id="wrap">
				<div id="title-div">
					<h2>숙소추가하기</h2>
				</div>
				<div id="content-div">
					<form method="post" id="content-add-form" action="${ path }/insert.hotels" 
					enctype="multipart/form-data" >
						<div id="content-div-half1">
							<div id="addr-div">
								<input type="button" onclick="findAddrs();" value="우편번호 찾기"><br>
								<input type="text" id="roadAddress" placeholder="도로명주소" name="loadName" readonly required>
								<input type="text" id="detailAddress" placeholder="상세주소" maxlength="15" name="detailAddr" oninput="testVal(this, detailAddr)" required>
								<span id="guide" style="color:#999;display:none"></span>
							</div>

							<div id="hotel-cate">
								<div class="hotel-cate-div" >
								<label>숙소종류</label>
									<select class="form-control" name="hotelCate">
										<option>호텔</option>
										<option>모텔</option>
										<option>게스트하우스</option>
										<option>캠핑/글림핑</option>
									</select>
								</div>
								<div class="hotel-cate-div">
									<label>숙소명</label>
									<input class="form-control" type="text" name="hotelName" required oninput="testVal(this, hotelName)">
								</div>
							</div>

							<div id="hotel-nameNImg">
								<div id="nameNimg-div">
									<label>숙소대표사진</label>
									<input type="file" name="hotelImg" oninput="testVal(this, hotelImg);" required>
								</div>
							</div>
						</div>

						<div id="content-div-half2">
							<div id="nameNPhone">
								<div id="nameNPhone-div-1">
									<label>대표자명</label>
									<input type="text" required class="form-control" name="ceoName" maxlength="8" oninput="testVal(this, ceoName);">
								</div>

								<label id="phone-label">전화번호</label>
								<div id="nameNPhone-div-2">
									<input class="form-control" id="Phone-div-1" type="text" name="phone1" value="010" readonly>
									<input class="form-control" maxlength="8" id="Phone-div-2" type="text" name="phone2" required oninput="testVal(this, phone2);" placeholder="-제외한 숫자만 입력해주세요.">
								</div>
							</div>

							<div id="hotel-serviceList">
								<div id="serviceList-div">
									<h3>숙소 이용 가능한 서비스 목록</h3>
								</div>
								<div id="serviceList-half1">
									<label>wifi</label><input class="form-check-input" type="checkbox" value="1" name="serList">
									<label>금연</label><input class="form-check-input" type="checkbox" value="2" name="serList">
									<label>헬스장</label><input class="form-check-input" type="checkbox" value="3" name="serList">
									<label>에어컨</label><input class="form-check-input" type="checkbox" value="4" name="serList">
								</div>
								<div id="serviceList-half2">
									<label>주차장</label><input class="form-check-input" type="checkbox" value="5" name="serList">
									<label>반려견동반</label><input class="form-check-input" type="checkbox" value="6" name="serList">
									<label>엘레베이터</label><input class="form-check-input" type="checkbox" value="7" name="serList">
									<label>pc</label><input class="form-check-input" type="checkbox" value="8" name="serList">
								</div>

							</div>

						</div>
						
						<div id="intro-text-area">
							<label for="intro">소개말을 적어주세요</label>
							<div>
								<textarea required onkeydown="test()" class="form-control" rows="5" id="intro" name="introText"></textarea>
							</div>
						</div>
						
						<div align="center">
							<button class="btn btn btn-outline-info" type="submit">추가</button>
							<button class="btn btn btn-outline-info" type="button" onclick="history.back();" >돌아가기</button>
						</div>
					</form>

				</div>
			</div>
				
		<script>		
		function test(){
			if($('#intro').val().includes("<script>")){
				alert('<script>태그는 입력 내용으로 사용할 수 없습니다.');
				$('#intro').val($('#intro').val().replaceAll("<script>", 'script '));
			}
		}
	    
	    function findAddrs() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                var roadAddr = data.roadAddress;
	                document.getElementById("roadAddress").value = roadAddr;
	             
	                var guideTextBox = document.getElementById("guide");
	              
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
	
	<script>
	const regNameRule = /^[a-zA-Z0-9ㄱ-ㅎㅏ-ㅣ가-힣\s]+$/;
	const regNum = /^[0-9]+$/;
	
	function testVal(e, tag) {
		if($(e).val().charAt(0) === ' '){
			alert('입력은 공백으로 시작할수 없습니다.');
			$(e).val('');
			return;
		}
		
		if(tag.name === 'detailAddr' || tag.name === 'hotelName' || tag.name === 'ceoName'){
			if($(e).val() === ''){
				return;
			}
			if(!regNameRule.test($(e).val())){
				alert('입력할수 없는 문자입니다.');
				$(e).val('');
				return;
			}	
		}
		else if(tag.name === 'phone2') {
			if(isNaN($(e).val())){
				alert('올바른 숫자만 입력해주세요.');
				$(e).val('');
				return;
			}
		}
		else if(tag.name === 'hotelImg') {
			if($(e).val().substring($(e).val().lastIndexOf(".")) !== ".jpg" &&
			   $(e).val().substring($(e).val().lastIndexOf(".")) !== ".png" &&
			   $(e).val().substring($(e).val().lastIndexOf(".")) !== ".jpeg"
			  ){
				alert('.jpg, .png, .jpeg 형식의 사진 파일만 가능합니다.');
				$(e).val('');
				return;
			}
		}
	}
		
	</script>
	</body>
	</html>