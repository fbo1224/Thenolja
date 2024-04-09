<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="thenolja.tb_hotel.model.vo.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <c:if test="${ hotelInfo ne null }">
    	<c:set var="phoneNum" value="${ hotelInfo.hotelPhone.substring(4) }" />
    </c:if>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
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
#hotel-cate{
	width: 90%;
	height: 31%;
}
#hotel-serviceList{
	width: 90%;
	height: 62%;
	border-bottom: 1px solid gray;
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
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
.nameNimg-div{
	width:50%;
	height: 100%;
	display:inline-block;
	padding: 10px;
	text-align: center;
	float:left;
}
#nameNimg-div label {
	display: blick;
	padding: 10px;
}
#hotel-serviceList h3{
	text-align: center;
	margin: 0px;
	padding: 5px;
}
#serviceList-div{
	width: 80%;
	margin: auto;
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
	resize: false;
}
</style>
</head>
	<body>
		<jsp:include page="../common/menubar.jsp" />
			<div id="wrap">
				<div id="title-div">
					<h2>숙소정보수정하기</h2>
				</div>
				<div id="content-div">
				<c:choose>
					<c:when test="${ hotelInfo ne null }">
						<form method="post" id="content-add-form" action="${ path }/update.hotels" 
							enctype="multipart/form-data" >
							<div id="content-div-half1">
								<div id="addr-div">
									<input type="hidden" value="${ hotelInfo.hotelNo }" name="hotelNo" >
									<input type="button" onclick="findAddrs();" value="우편번호 찾기"><br>
									<input type="text" id="roadAddress"
									 placeholder="도로명주소" name="loadName" value="${ hotelInfo.hotelAddress }"
									 required readonly>
									<input type="text" id="detailAddress" placeholder="상세주소"
									 name="detailAddr" value="${ hotelInfo.hotelDetail }" maxlength="15" oninput="testVal(this, detailAddr);"
									 required>
									<span id="guide" style="color:#999;display:none"></span>
								</div>
	
								<div id="hotel-cate">
									<div class="hotel-cate-div" >
									<label>숙소종류</label>
										<select class="form-control" name="hotelCate">
											<option >호텔</option>
											<option >모텔</option>
											<option >게스트하우스</option>
											<option >캠핑/글림핑</option>
										</select>
									</div>
									<div class="hotel-cate-div">
										<label>숙소명</label>
										<input class="form-control" type="text" name="hotelName" value="${ hotelInfo.hotelName }" oninput="testVal(this, hotelName)" >
									</div>
								</div>
	
								<div id="hotel-nameNImg">
									<div class="nameNimg-div">
										<label>숙소대표사진</label>
										<input width="50%" type="file" name="hotelImg" oninput="testVal(this, hotelImg);">
									</div>
									<div class="nameNimg-div">
										<img width="50%" height="100%" src="${ hotelInfo.hotelPath }" alt="등록된이미지">
									</div>
								</div>
								<input type="hidden" name="beforeImgPath" value="${ hotelInfo.hotelPath }" >
							</div>
	
							<div id="content-div-half2">
								<div id="nameNPhone">
									<div id="nameNPhone-div-1">
										<label>대표자명</label>
										<input type="text" required class="form-control" name="ceoName" maxlength="8" oninput="testVal(this, ceoName);" value="${ hotelInfo.hostName }" >
									</div>
	
									<label id="phone-label">전화번호</label>
									<div id="nameNPhone-div-2">
										<input class="form-control" id="Phone-div-1" type="text" name="phone1" value="010" readonly>
										<input class="form-control" id="Phone-div-2" type="text" name="phone2" readonly
										 value="${ phoneNum }"
										 placeholder="-제외한 숫자만 입력해주세요.">
									</div>
								</div>
	
								<div id="hotel-serviceList">
									<div id="serviceList-div">
										<h3>숙소 이용 가능한 서비스 목록</h3>
									</div>
									<div id="serviceList-half1">
										<label>WIFI</label><input class="form-check-input" type="checkbox" value="1" name="serList">
										<label>금연</label><input class="form-check-input" type="checkbox" value="2" name="serList">
										<label>헬스장</label><input class="form-check-input" type="checkbox" value="3" name="serList">
										<label>에어컨</label><input class="form-check-input" type="checkbox" value="4" name="serList">
									</div>
									<div id="serviceList-half2">
										<label>주차장</label><input class="form-check-input" type="checkbox" value="5" name="serList">
										<label>반려견동반</label><input class="form-check-input" type="checkbox" value="6" name="serList">
										<label>엘레베이터</label><input class="form-check-input" type="checkbox" value="7" name="serList">
										<label>PC</label><input class="form-check-input" type="checkbox" value="8" name="serList">
									</div>
									
								</div>
	
							</div>
							
							<div id="intro-text-area">
								<label for="intro">소개말을 적어주세요</label>
								<div>
									<textarea required class="form-control" onkeydown="test()" rows="5" id="intro" name="introText" >${ hotelInfo.hotelIntro }</textarea>
								</div>
							</div>
							
							<div align="center">
								<button class="btn btn btn-outline-info" type="submit">수정하기</button>
								<button class="btn btn btn-outline-info" type="button" onclick="history.back();" >돌아가기</button>
							</div>
						</form>
					  </c:when>
					<c:otherwise>
						<h3>해당 숙소정보를 가져오지 못했습니다.</h3>
						<button class="btn btn btn-outline-info" onclick="history.back();" >돌아가기</button>
					</c:otherwise>
				</c:choose>
				</div>	
			</div>
				
		<script>
	    function findAddrs() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                var roadAddr = data.roadAddress;
	                if(data.buildingName !== '' && data.apartment === 'Y'){
	                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                }
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
	                
	                $('#detailAddress').val('');
	                
	            }
	        }).open();
	    }
	    
	    $('option').each(function(){
	    	if('${ hotelInfo.hotelCategory }' == $(this).text().trim()){
	    		$(this).attr('selected', 'true');
	    	}
	    });
	    
	</script>
	
	<c:if test="${ hotelInfo.serList ne null }">
		<c:forEach var="item" items="${ hotelInfo.serList }">
			<script>
			 	$('input[type=checkbox]').each(function(){
		 			if('${ item }' == $(this).prev().text()){
						$(this).attr('checked', 'true');
		 			}
			   	});
			</script>
		</c:forEach>
	</c:if>
	
	<script>
	const regNameRule = /^[a-zA-Z0-9ㄱ-ㅎㅏ-ㅣ가-힣\s]+$/;
	const regNum = /^[0-9]+$/;
	
	function test(){
		if($('#intro').val().includes("<script>")){
			alert('<script>태그는 입력 내용으로 사용할 수 없습니다.');
			$('#intro').val($('#intro').val().replaceAll("<script>", 'script '));
		}
	}
	
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