<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정/삭제 화면</title>
<style>
#insert-form{
    width: 800px;
    margin: auto;
}
label{
    font-weight: bold;
}


</style>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>>

	<div class="outer">
		<h2 align="center">공지사항 수정하기</h2>
		<br><br>
		
	<!-- FORM 영역 START -->
	<form id="frm" action="<%=contextPath%>/selectNoticeInfo" method="post">
		<table class="table-light table-striped text-center" width="100%">
			<tr>
				<td>제목</td>
				<td><input type="text" id="title" name="title" style="width:650px;"/></td>
			</tr>
       <tr>
            <td>내용</td>
            <td>
                <textarea rows="10" cols="30" id="txtArea_content" name="content" style="width:650px; height:350px;"></textarea>
                <!-- <input id="textLengthCheck"  placeholder="내용을 입력하세요."> -->
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="button" id="save"   class="btn btn-primary" value="등록" onclick="regNotice();"/>
                <input type="button" id="cancle" class="btn btn-light"   value="취소" onclick="history.back();"/>
            </td>
        </tr>		
		</table>
	
	</form>
	<!-- FORM 영역 END -->

	</div>	
		
		
		
		
	
		
		
</body>
</html>