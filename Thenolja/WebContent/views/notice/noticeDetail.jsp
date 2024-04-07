<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, thenolja.notice.model.vo.Notice" %>
     <%
     Notice notice = (Notice)request.getAttribute("notice");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>더놀자 > 공지사항 > 상세</title>
<style>



#detail-area{
	width:100%;
	height:100%;
	word-break:break-all; /* 줄바꿈 처리 */
	/*border : 1px solid lightgreen;
    background-color: lightblue;
    color: white;
    font-weight: bold; */
}

#detail_title-area{
    display: flex;
    flex-wrap: wrap;
    align-items: flex-start;
    justify-content: space-between;
    padding: 20px 60px;
    box-sizing: border-box;
    border-bottom: 1px solid #d1d1d7;
    background-color: #f2f2f2;
}

#detail_content-area{
	width:100%;
	height:100%;
    padding: 60px;
    border-bottom: 1px solid #d1d1d7;
    color: #1a1d1d;
    font-size: 18px;
    line-height: 26px;
    white-space: break-spaces;
}
.detail_content-area{
	display:block;
}

.detail_title_name_td{
    width: 60%;
    color: #1a1d1d;
    font-size: 26px;
    font-weight: 700;
    line-height: 40px;
}

.detail_title_date_td{
	margin-right:0;
	padding-right:0;
}

.btn-wrap{
	display: flex;
    align-items: center;
    justify-content: center;
    margin-top: 40px;
}

#detail-golist{
	width:448px;
	color: #fff;
    background-color: #007bff;
    border-color: #007bff;
}

</style>

</head>
<body>
<%@ include file="../common/menubar.jsp" %>


<div class="outer">

	<br>
	<h2 align="center">공지사항</h2>
	<br>
	
	<br>
	<table id="detail-area">

		<!-- 타이틀 영역 -->
	    <tr id="detail_title-area">
	         <td class="detail_title_name_td" width="500" colspan="3"><%= notice.getNoticeTitle()  %></td>
	         <td class="detail_title_date_td"><%= notice.getCreateDate() %> </td>
	    </tr>
	    <!-- 컨텐츠영역 -->
	    <tr id="detail_content-area">
		   <td class="detail_content-area"><%= notice.getNoticeContent() %></td>  
	    </tr>
	
	</table>
	<div class="btn-wrap">
		<input type="button" id="detail-golist" class="btn btn-light"   value="목록으로 이동" onclick="history.back();"/>
		
        <!--작성자 보이게끔-->
        <!--로그인 유저가 작성자와 같은지-->
        <!-- 로그인 여부 판단 그리고 로그인유저의 이름(UNIQUE)이랑 공지사항의 작성자 (사용하기엔 무리) 이것은 적합하지 않음 -->
        <!-- 새롭게 조회해온 USER_NO컬럼값을 가지고 비교    매핑값? SERVLET키값= -->
	 
      
     <%--  <a href="<%= contextPath %>/updateForm.notice?noticeNo=<%= notice.getNoticeNo() %>"   
         class="btn btn-sm btn-warning">수정하기</a>

    	<a href="<%= contextPath %>/delete.notice?noticeNo=<%= notice.getNoticeNo() %>"
    	class="btn btn-sm btn-danger">삭제하기</a> --%>
	</div>	
	<br>
	<br><br>

</div>

</body>
</html>