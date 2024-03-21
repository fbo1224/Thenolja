<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<style>
div {
	box-sizing: border-box;
}

#title-div {
	width: 100%;
	height: 10%;
	margin: auto;
	border-bottom:  1px solid gray;
	display: flex;
	align-items: center;
	justify-content: space-between;
}

#title-div>h2 {
	margin-top: 15px;
	margin-left: 15px;
	font-weight: bold;
}

#wrap {
	width: 1200px;
	height: 850px;
	margin: auto;
	padding : 10px;
}
#content-div{
	width: 100%;
	height: 80%;
	padding: 10px;
}
#content-add-form{
	width:100%;
}
#timeOptions{
	display: flex;
	align-items: center;
	flex-wrap: nowrap;
}
#timeOptions label{
	font-size: 12px;
}
[class *= content-div]{
	width: 30%;
	height: 50%;
	padding: 5px;
	margin: 3px;
	box-shadow: 2px 2px 2px gray;
	display:inline-block;
}

</style>
</head>
<body>
	<%@ include file="../common/adminMenubar.jsp" %>
	<div id="wrap">
		<div id="title-div">
			<h2>숙소추가하기</h2>
			<button class="btn btn btn-info" id="addBtn">객실추가하기</button>
		</div>
		<div id="content-div">
			<form id="content-add-form" action="/insert.rooms" enctype="multipart/form-data">
			
			<div class="content-div-1">
				<div class="form-group">
				  <label for="roomName">객실이름</label>
				  <input type="text" class="form-control" id="roomName" name="roomName" >
				</div>
				
				<div class="form-group">
				  <label for="maxPeople">최대인원</label>
				  <input type="text" class="form-control" id="maxPeople" name="maxPeople" >
				</div>
				
				<div class="form-group">
				  <label for="roomImg">숙소사진</label>
				  <input type="file" id="roomImg" name="roomImg">
				</div>
				
				<div id="timeOptions">
					<label>입실시간</label>
					<input type="time" name="in_time">				
					<label>퇴실시간</label>
					<input type="time" name="out_time">
				</div>
			</div>
			
			
				
				<button class="btn btn btn-info" >추가</button>
				
			</form>
		</div>
	</div>
	<script>
	let btnCnt= 0;
	$('#addBtn').click(function(){
		//console.log('click');
		if(btnCnt == 1){
			$('#addBtn').attr('disabled', true);
		}
		
		const temp = $('#content-add-form').children().filter('div').first().clone(false);
		
		// 클래스명 찾기
		let num = temp.attr('class');
		// 클래스명 마지막 숫자 뽑기
		lastNum = num.slice(-1);
		// console.log(lastNum);
		
		// 뽑아낸 클래스명 마지막 숫자 1증가
		const classNum = Number(lastNum) + 1;
		let newClass = temp.attr('class');
		
		// 찾아낸 클래스명에서 증가한 숫자 붙이기
		className = num.slice(0, -1);		
		temp.attr('class', className+classNum);
		// console.log(temp);
		
		console.log(temp.children().children('input').eq(0).attr('name','roomName'+classNum));
		console.log(temp.children().children('input').eq(1).attr('name','maxPeople'+classNum));
		console.log(temp.children().children('input').eq(2).attr('name','roomImg'+classNum));
		console.log(temp.children().children('input').eq(3).attr('name','in_time'+classNum));
		console.log(temp.children().children('input').eq(4).attr('name','out_time'+classNum));
		// 요소 붙이기
		$('#content-add-form').prepend(temp);
		btnCnt++;
	});
		
	</script>
</body>
</html>