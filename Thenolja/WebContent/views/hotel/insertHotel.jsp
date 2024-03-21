<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>숙소 추가</title>
		<style>
			div {
				box-sizing: border-box;
				border: 1px solid red;
			}

			#wrap {
				width: 1200px;
				height: 800px;
				margin: auto;
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
				height: 90%;
			}

			#content-div-half2 {
				width: 50%;
				height: 90%;
				float: right;
			}

			#addr-div,
			#hotel-cate,
			#hotel-nameNImg,
			#hotel-serviceList,
			#nameNPhone,
			#hotel-checkTime {
				width: 100%;
				height: 30%;
			}
	
			#hotel-serviceList h3{
				text-align: center;
			}
			#serviceList-half1{
				width: 40%;
				margin: auto;
				margin-top: 20px;
				
			}
			#serviceList-half2{
				width: 50%;
				margin: auto;
				margin-top: 20px;
				white-space: nowrap;
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
					<form id="content-add-form" action="#" enctype="multipart/form-date">
						<div id="content-div-half1">
							<div id="addr-div">
								<label>숙소상세주소</label><input type="text">
							</div>

							<div id="hotel-cate">
								<div style="width: 80%; height: 40%; margin: auto; margin-top: 10px; ">
								<label>숙소종류</label>
									<select>
										<option>호텔</option>
										<option>모텔</option>
										<option>게스트하우스</option>
										<option>캠핑/글림핑</option>
									</select>
								</div>
								<div style="width: 80%; height: 40%; margin: auto; margin-top: 10px;">
									<label>숙소명</label>
									<input type="text" name="hotelName">
								</div>
							</div>

							<div id="hotel-nameNImg">
								<label>숙소대표사진</label>
								<input type="file">
							</div>
						</div>

						<div id="content-div-half2">
							<div id="nameNPhone">
								<div>
									<label>대표자명</label>
									<input type="text">
								</div>

								<label>전화번호</label>
								<select>
									<option>010</option>
									<option>02</option>
								</select>-<input type="number">-<input type="number">
							</div>

							<div id="hotel-serviceList">
								<div>
									<h3>숙소 이용 가능한 서비스 목록</h3>
								</div>
								<div id="serviceList-half1">
									<label>wifi</label><input type="checkbox" value="wifi">
									<label>금연</label><input type="checkbox">
									<label>헬스장</label><input type="checkbox">
									<label>에어컨</label><input type="checkbox">
								</div>
								<div id="serviceList-half2">
									<label>주차장</label><input type="checkbox">
									<label>반려견동반</label><input type="checkbox">
									<label>엘레베이터</label><input type="checkbox">
									<label>pc</label><input type="checkbox">
								</div>

							</div>

							<div id="hotel-checkTime">
								<label>입퇴실 시간</label>
								<input type="time">
							</div>
						</div>
						<button type="submit">추가</button>
					</form>

				</div>
			</div>
	</body>

	</html>