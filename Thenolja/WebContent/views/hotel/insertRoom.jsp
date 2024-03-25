<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	int hotelNo = (int)request.getAttribute("hotelNo");
    	System.out.println("hotelNo " + hotelNo);
    %>
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
	height: 80%;
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
	width: 32%;
	height: 60%;
	padding: 5px;
	margin: auto;
	border-radius: 8px;
	box-shadow: 5px 3px 3px gray;
	display: inline-block;
}
#content-add-sect{
	display:flex;
	align-items: center;
}
#btn-div{
	margin-top: 20px;
}
.delBtn{
	float: right;
}

</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>
	<div id="wrap">
		<div id="title-div">
			<h2>숙소추가하기</h2>
			<button class="btn btn btn-info" id="addBtn">객실추가하기</button>
		</div>
		<div id="content-div">
			<form id="content-add-form" action="<%= contextPath %>/insert.rooms" enctype="multipart/form-data" method="post">
			<input type="hidden" value="<%= hotelNo %>" name="hotelNo" >
			<section id="content-add-sect">
				<div class="content-div-1">
					<button type="button" id="deleteBtn" class="btn btn-sm btn-danger delBtn" onclick="delBtn(this);" >삭제</button>
					
					<div class="form-group">
					  <label>객실이름</label>
					  <input type="text" class="form-control" name="roomName" required >
					</div>
					
					<div class="form-group">
					  <label>최대인원</label>
					  <input type="text" class="form-control"  name="maxPeople" required >
					</div>
					
					<div class="form-group">
					  <label>객실 사진</label>
					  <input type="file"  name="roomImg" >
					</div>
					
					<div class="form-grop">
						<label>입실시간</label>
						<input type="time" name="in_time" required><br>				
						<label>퇴실시간</label>
						<input type="time" name="out_time" required>
					</div>
					
					<div class="form-group">
					  <label>객실 가격</label>
					  <input type="text"  name="roomPrice" required>
					</div>
					
					<div class="form-group">
					  <label>객실 번호</label>
					  <input type="text"  name="roomNum" required>
					</div>
				</div>
			</section>
			<div id="btn-div" align="center">
				<button class="btn btn btn-info" >추가</button>
			</div>
			</form>
		</div>
	</div>
	<script>
	let btnCnt= 0;
	// 객실추가는 최소 1개는 존재해야함
	// 객실정보추가 창이 1개라면 삭제할 수 없음
	// 처음으로 페이지에 오면 삭제못함
	$('#deleteBtn').attr('disabled', true);
	
	$('#addBtn').click(function(){
		btnCnt++;
		if(btnCnt < 2){
			$('#addBtn').attr('disabled', false);
			$('#deleteBtn').attr('disabled', false);
		}else {
			$('#addBtn').attr('disabled', true);
		}
		
		const temp = $('#content-add-form').children().children().filter('div').first().clone(true);
		
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
		temp.children().children('input').eq(0).attr('name','roomName'+classNum);
		temp.children().children('input').eq(1).attr('name','maxPeople'+classNum);
		temp.children().children('input').eq(2).attr('name','roomImg'+classNum);
		temp.children().children('input').eq(3).attr('name','in_time'+classNum);
		temp.children().children('input').eq(4).attr('name','out_time'+classNum);
		temp.children().children('input').eq(5).attr('name','roomPrice'+classNum);
		temp.children().children('input').eq(6).attr('name','roomNum'+classNum);
		
		// 요소 붙이기
		$('#content-add-sect').prepend(temp);
		if(btnCnt == 0){
			$('#deleteBtn').attr('disabled', false);	
		}
	});
	
	// 버튼 클릭시 객실정보 삭제
	function delBtn(e) {
		btnCnt--;
		if(btnCnt < 2){
			$('#addBtn').attr('disabled', false);
		} else {
			$('#addBtn').attr('disabled', true);
		}
		$('.'+e.parentNode.className).remove();
		
		if(btnCnt == 0){
			$('#deleteBtn').attr('disabled', true);	
		}
	};
	
	</script>
</body>
</html>