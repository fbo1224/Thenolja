<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, thenolja.notice.model.vo.Notice" %>
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("noticeList");
	String loginId = list.get(0).getNoticeTitle();
	//System.out.println("noticeList = " + list); 컴파일에러 발생
%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>더놀자 > 공지사항 > 목록</title>
<style>

.outer{
	width : 1000px;
	height : 800px;
	margin : auto;
	}

#btn_reg{
	float:right;
	background-color:#17a2b8;
	margin:5px;
}
.align_center{
	text-align:center;
}  


</style>

</head>
 
<body>

<%@ include file="../common/menubar.jsp" %>

<div class="">

    <br>
   	 <h2 align="center">공지사항</h2>
    <br>
    
    <!-- 등록 버튼 영역 START -->
   	<%-- <a class="btn btn-sm btn-info" id="btn_reg" href="<%= contextPath %>/insertForm.notice">등록</a> --%>
	<a id="btn_reg" class="btn btn-primary" href="<%=contextPath%>/views/notice/noticeReg.jsp" role="button" style=>등록하기</a>
   	<!-- 등록 버튼 영역 END -->
   	
    <br>
    
    <table class="table table-hover">
        <thead>
          <tr>
            <th>no.</th>
            <th>제목</th>
             <th>작성자</th>
            <th>작성일</th>
            <th>조회수</th>
            <th>게시여부</th>
          </tr>
        </thead>
        <tbody>

         <!-- 공지사항이 있을수도있고 없을 수도 있음 -->
         <% if(list.isEmpty()) { %>   <!-- 비어있음    비어있는지 확인   위 상단 null값 이들어있고 list참조 null값이 들어있음 nullporinException 발생 -->
         	<tr class="align_center">
         		<th colspan="6">등록된 게시글이 존재하지 않습니다.</th>
         	</tr>
         <%}else{ %>
         <!-- 비어있지 않음 -->
         	<%for(Notice n: list) { %>
         		 <tr class="list">
         			<td><%= n.getNoticeNo() %></td>
         			<td><%= n.getNoticeTitle () %></td>
         			<td><%= n.getWriter() %></td>
         			<td><%= n.getCreateDate() %></td>
         			<td><%= n.getViewCount() %></td>
         			<td><%= n.getStatus() %></td>
         		</tr>
         	<% } %>

         <% } %>
        </tbody>
      </table>

	  <!-- 페이징영역 START -->
	  <nav aria-label="Page navigation example">
	    <ul class="pagination justify-content-center">
	      <li class="page-item disabled">
	        <a class="page-link"> < </a>
	      </li>
	      <li class="page-item"><a class="page-link" href="#">1</a></li>
	      <li class="page-item"><a class="page-link" href="#">2</a></li>
	      <li class="page-item"><a class="page-link" href="#">3</a></li>
	      <li class="page-item">
	        <a class="page-link" href="#"> > </a>
	      </li>
	    </ul>
	  </nav>	  
	  
	  <!-- 페이징영역 END -->

<br><br><br>
</div>
	<script>
		// loginId null 체크
		 <% if("".equals(loginId)){ %> 
			// 수정화면 진입 (관리자전용URL)
			 <% if("admin".contains(loginId)){  %> 
				$('tbody > tr.list').click(function(){
			        //location.href='<%=contextPath%>/detail.notice';  
			        const noticeNo = $(this).children().eq(0).text();
			        location.href= '<%= contextPath %>/selectUpdate.notice?noticeNo=' + noticeNo + '&flag=' + 'Y';
			      });
			 <% } else{ %> 
	        // 상세화면 진입 (회원전용URL)
		         $('tbody > tr.list').click(function(){
		          //location.href='<%=contextPath%>/detail.notice';  
		           const noticeNo = $(this).children().eq(0).text();
		           location.href= '<%= contextPath %>/detail.notice?noticeNo=' + noticeNo + '&flag=' + 'N';
		
		        }); 
			 <% } %> 
		 <% } %> 
		
		
	</script>
 <div id="footer">

        
        <div id="footer_2">
            <a href="#">개인정보보호정책</a> |
            <a href="#">이용약관</a> |
            <a href="#">청소년보호정책</a> |
            ©2024 TheNolJa
        </div>


        <div id="footer_3">

            <p>
                (주)더놀자

                주소 : 서울특별시 중구 남대문로 120 그레이츠 청계(구 대일빌딩) 2F <br>
                대표이사 : 동혁U | 책임자 : 동혁U ｜  개인정보관리책임자 : 동혁U<br>
                전자우편주소 : help@thenolja.kr | 전화번호 : 1544-9970 

            </p>
            
        </div>


</head>
<body>

</body>
</html>