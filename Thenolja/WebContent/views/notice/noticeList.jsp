<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="thenolja.member.model.vo.Member" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%-- <%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("noticeList");
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	
	int currentPage = pageInfo.getCurrentPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();
	int maxPage = pageInfo.getMaxPage();	
%> --%>
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

<jsp:include page="menubar.jsp"/>



    <br>
   	 <h2 align="center">공지사항</h2>
    <br>
    <!-- 등록 버튼 영역 START -->
	<a id="btn_reg" class="btn btn-primary" href="${ path } /views/notice/noticeReg.jsp" role="button" style=>등록하기</a>
  
  	<c:choose>
  	<c:when test="${loginUser != null} " 
  		${} 
  	</c:when>
  	<c:when test="${} " 
  		${} 
  	</c:when>
  	<c:when test="${} " 
  		${} 
  	</c:when>
  	<c:when test="${} " 
  		${} 
  	</c:when>
  		${} 
  	<c:otherwise>
  		${} 
  	</c:otherwise>
  	
  	</c:choose>
  
  
  
  
  <%--   <%if(loginUser != null && loginUser.getMemStatus().equals("A")){ %>
	    <script>
	    	$("#btn_reg").show();
	    </script>
	<%} else{ %>
	    <script>
	    	$("#btn_reg").hide();
	    </script>
	<% } %>  
   	<!-- 등록 버튼 영역 END -->
   	
     <!-- 관리자가 아니면 등록하기 버튼 숨김처리 -->
    <% if(!"A".equals(loginUser.getMemStatus())) { %>
    <!-- 	<script>
    		$("#btn_reg").style.display='none';
    	</script> -->
    <% } %>  	
     --%>
    <br>
    
    <table class="table table-hover">
        <thead>
          <tr>
            <th>no.</th>
            <th>제목</th>
             <th>작성자</th>
            <th>작성일</th>
            <th>조회수</th>
            <!-- 일반 사용자인 경우 게시여부 td태그 그리기 x -->
			<%if(loginUser != null && "A".equals(loginUser.getMemStatus())){ %>
            	<th>게시여부</th>
            <% } %>
          </tr>
        </thead>
        <tbody>

         <!-- 공지사항이 있을수도있고 없을 수도 있음 -->
         <!-- 비어있음    비어있는지 확인   위 상단 null값 이들어있고 list참조 null값이 들어있음 nullporinException 발생 -->
         <% if(list.isEmpty()) { %>   
         	<tr class="align_center">
         		<th colspan="6">등록된 게시글이 존재하지 않습니다.</th>
         	</tr>
         <%}else{ %>
         <!-- 비어있지 않음 -->
         	<%for(int i=0; i<list.size(); i++) { %>
         	
         		<!-- 일반 회원인 경우 -->
         		<% if(loginUser != null && !"A".equals(loginUser.getMemStatus())) { %>
			         
			         <% if(!"Y".equals(list.get(i).getStatus())) { %>	
			         	<!-- <tr class="align_center">
			         		<th colspan="6">등록된 게시글이 존재하지 않습니다.</th>
			         	</tr>  	 -->
			         	 
			         <% } else { %>
			           <tr id="tr_notice" class="list">						 
		         		 <td><%= list.get(i).getNoticeNo() %></td>			${NoticeNo} 
		         		 <td><%= list.get(i).getNoticeTitle () %></td>		${NoticeTitle} 
		         		 <td><%= list.get(i).getWriter() %></td>			${Writer} 
		         		 <td><%= list.get(i).getCreateDate() %></td>		${CreateDate} 
		         		 <td><%= list.get(i).getViewCount() %></td>			${ViewCount} 
		         		</tr>
			         <% } %>
			         	      		
         		<% } else { %>
         		<!-- 관리자인 경우 -->
         		 <tr id="tr_notice" class="list">
         			<td><%= list.get(i).getNoticeNo() %></td>
         			<td><%= list.get(i).getNoticeTitle () %></td>
         			<td><%= list.get(i).getWriter() %></td>
         			<td><%= list.get(i).getCreateDate() %></td>
         			<td><%= list.get(i).getViewCount() %></td>
         			<td><%= list.get(i).getStatus() %></td>
         		</tr>
         		<% } %>
         		
         	<% } %>

         <% } %>
        </tbody>
      </table>

	  <!-- 페이징영역 START -->
 	  <div class="paging-area" align="center">
 	  <% if(list != null) { %>
 		<% if(currentPage > 1) { %>
			<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${ path } /noticeList?currentPage=<%=currentPage - 1%>'"><</button> 	     
 	     <% } %>

        <% for(int i = startPage; i <= endPage; i++) { %>
             <% if (currentPage != i) { %>
               <button class="btn btn-sm btn-outline-secondary" onclick="location.href='${ path } /noticeList?currentPage=<%=i%>'"><%= i %></button>
                    
	         <% } else { %>
	           <button disabled class="btn btn-sm btn-outline-secondary"><%= i %></button>
	         <% } %>
                    		
        <% } %> 	     
 	     
         <% if(currentPage != maxPage) { %>
         <button class="btn btn-sm btn-outline-secondary" onclick="location.href='${ path } /noticeList?currentPage=<%=currentPage + 1%>'">></button>
         <% } %> 	     
 	 
 	 <% }else { %>

       <%if(currentPage > 1) { %>
           <button class="btn btn-sm btn-outline-secondary" onclick="location.href='${ path } /noticeList?currentPage=<%=currentPage - 1%>'"><</button>
     	<%} %>
                    
        <% for(int i = startPage; i <= endPage; i ++) { %>
             <%if (currentPage != i)  { %>
               <button class="btn btn-sm btn-outline-secondary" onclick="location.href='${ path } /noticeList?currentPage=<%=i%>'"><%= i %></button>
             <% } else { %>
               <button disabled class="btn btn-sm btn-outline-secondary"><%= i %></button>
             <% } %>
        <%} %>
                  
             <% if(currentPage != maxPage) { %>
               <button class="btn btn-sm btn-outline-secondary" onclick="location.href='${ path } /noticeList?currentPage=<%=currentPage + 1%>'">></button>
             <%} %>
 	     	     
 	  <% } %> 
 	  </div>  
	  
	  <!-- 페이징영역 END -->

<br><br><br>
</div>
	<script>
			// loginId null 체크
			// 수정화면 진입 (관리자전용URL)
			<%if(loginUser != null){ %>
			
			 	<%if("A".equals(loginUser.getMemStatus())){ %>
					$('tbody > tr.list').click(function(){
				        //location.href='<%=contextPath%>/detail.notice';  
				        const noticeNo = $(this).children().eq(0).text();
				        location.href= '<%= contextPath %>/selectUpdate.notice?noticeNo=' + noticeNo + '&flag=' + 'Y';
				      })
				 <% } else { %>
				
			        	// 상세화면 진입 (회원전용URL)
				       $('tbody > tr.list').click(function(){
				          //location.href='<%=contextPath%>/detail.notice';  
				           const noticeNo = $(this).children().eq(0).text();
				           location.href= '<%= contextPath %>/detail.notice?noticeNo=' + noticeNo + '&flag=' + 'N';
				        });
			     <% } %>
			     
		     <%}%>
		
	</script>

</head>
<body>

</body>
</html>