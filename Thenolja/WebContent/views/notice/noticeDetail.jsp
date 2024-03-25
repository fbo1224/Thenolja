<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, thenoleja.notice.model.vo.Notice" %>
     <%
     Notice notice = (Notice)request.getAttribute("notice");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세화면</title>
<style>

#detail-area{
	border : 1px solid lightgreen;
    background-color: lightblue;
    color: white;
    font-weight: bold;
}

</style>

</head>
<body>
<%@ include file="../common/menubar.jsp" %>


<div class="outer">

<br>

<h2 align="center">공지사항 상세보기</h2>

<br><br>

<table id="detail-area">

    <tr>
        <th width="90">제목</th>
         <td width="500" colspan="3"><%= notice.getNoticeTitle()  %></td> 
    </tr>
    <tr>
        <th>작성자</th>
         <td><%= notice.getWriter() %></td> 
        <th>작성일</th>
        <td><%= notice.getCreateDate() %></td>
    </tr>
    <tr>
        <th>내용</th>
        <td colspan="3">
            <p style="height:200px;"><%= notice.getNoticeContent() %></p>
        </td>
    </tr>


</table>
<br><br><br>


<div align="center">
    <a href="<%=contextPath%>/noticeList" class="btn btn-sm btn-primary">목록으로 돌아가기</a>
        <!--작성자 보이게끔-->
        <!--로그인 유저가 작성자와 같은지-->
        <!-- 로그인 여부 판단 그리고 로그인유저의 이름(UNIQUE)이랑 공지사항의 작성자 (사용하기엔 무리) 이것은 적합하지 않음 -->
        <!-- 새롭게 조회해온 USER_NO컬럼값을 가지고 비교    매핑값? SERVLET키값= -->
	 
      
      <a href="<%= contextPath %>/updateForm.notice?noticeNo=<%= notice.getNoticeNo() %>"   
         class="btn btn-sm btn-warning">수정하기</a>

    <a href="<%= contextPath %>/delete.notice?noticeNo=<%= notice.getNoticeNo() %>"
    class="btn btn-sm btn-danger">삭제하기</a>
 
</div>




</div>

</body>
</html>