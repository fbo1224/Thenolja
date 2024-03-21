<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<div id="wrap">
				<div id="title-div">
					<h2>숙소추가하기</h2>
				</div>
				<div id="content-div">
					<form id="content-add-form" action="/insert.hotels" enctype="multipart/form-data">
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
			
</body>
</html>