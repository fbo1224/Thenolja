<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ page import="java.util.ArrayList,   thenolja.admin.nonMember.model.vo.NonMember , thenolja.common.model.vo.PageInfo" %>    
<%
	ArrayList<NonMember> oldList = (ArrayList<NonMember>)request.getAttribute("oldNonMemList");
	
	ArrayList<NonMember> list = (ArrayList<NonMember>)request.getAttribute("selectNonMemberList");
	
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	
	int currentPage = pageInfo.getCurrentPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();
	int maxPage = pageInfo.getMaxPage();


%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>비회원 목록</title>

 	<link rel="stylesheet" href="resources/css/admin_select.css">    
<style>
        .sort-btn{
        	
        	border : none;
        	background : white;
        	float: right;
        	padding-top : 10%;
        }
        
         .sort-btn:hover{
        	
        	color : #5BA199;
        }

		#oldest {
		
		padding-right : 25%;
		
		}


</style>
</head>
<body>
    
    <div id="wrap">
        <div id="header">     		
       		<jsp:include page="../../common/menubar.jsp"></jsp:include>
        </div>       
        <div id="content">
            <div id="content_1">

                <div id="search_member">
                    <div id="search_id">
                        <input type="text" placeholder="예약자명 입력" id="keyword" maxlength="4">
                    </div>
        
                    <div id="search_btn">
                        <button type="submit" class="btn btn-outline-info" onclick="searchNonMemName()">검색</button>
                    </div>
                </div>

            </div>
            <div id="content_2">

                <div id="mem_list_header">

                    <div id="mem_title">
                        <h2>비회원목록</h2>
                    </div>
        
 					<div id="mem_sort">
			          	 <button class="sort-btn" id="oldest" onclick="location.href='${path}/oldestNonMemList.do?currentPage=1'">오래된순</button>
			   			 <button class="sort-btn" id="newest" onclick="location.href='${path}/selectNonMem?currentPage=1'">최신순</button>
					</div>
        
                </div>
        
                <div id="mem_list">
                    <table class="table table-hover">
                        <thead>
                          <tr>
                            <th>비회원 번호</th>
                            <th>예약자명</th>
                            <th>전화번호</th>
                          	<th></th>
                          </tr>
                        </thead>
                        <tbody>
                        
                        <c:choose>
                        	<c:when test="${requestScope.selectNonMemberList ne null && empty selectNonMemberList }">
	                        	<tr>
	                        		<th colspan="3">비회원이 존재하지 않습니다.</th>
	                        	</tr>                        	
                        	</c:when>
                        	<c:when test="${requestScope.selectNonMemberList ne null}">
                        		<c:forEach var="n" items="${requestScope.selectNonMemberList}">
		                          <tr>
		                            <td>${n.memNo}</td>
		                            <td>${n.memName}</td>
		                            <td>${n.memPhone}</td>
		                            <td><button class="btn btn-sm btn-outline-secondary" onclick="deleteNonMember(${n.memNo}">삭제</button></td>
		                          </tr>                        		
                        		</c:forEach>
                        	</c:when>
                        </c:choose>
                        
						<c:choose>
						<c:when test="${ requestScope.oldNonMemList ne null && empty requestScope.oldNonMemList }">
						  <tr>
						  		<th colspan="3">비회원이 존재하지 않습니다.</th>                       	   
						 </tr>              		  	
						</c:when>
						<c:when test="${requestScope.oldNonMemList ne null }">
						<c:forEach var="n" items="${ requestScope.oldNonMemList }">
							<tr>
		                            <td>${n.memNo}</td>
		                            <td>${n.memName}</td>
		                            <td>${n.memPhone}</td>
						      		<td><button class="btn btn-sm btn-outline-secondary" onclick="deleteNonMember(${n.memNo})">삭제</button></td>
						      
							 </tr>              		  		
						</c:forEach>
						</c:when>
						</c:choose>

                        </tbody>
                      </table>

                </div>  
        
     		<div class="paging-area" align="center";>
     		
     		
     		 <c:choose>
					<c:when test="${requestScope.selectNonMemberList ne null }">
						<c:if test="${ pageInfo.currentPage > 1 }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/selectNonMem?currentPage=${pageInfo.currentPage - 1}'"><</button>
						</c:if>
						<c:forEach begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }" var="i">
							<c:choose>
								<c:when test="${pageInfo.currentPage ne i }">
									<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/selectNonMem?currentPage=${ i }'">${ i }</button>
								</c:when>
								<c:otherwise>
									<button disabled class="btn btn-sm btn-outline-secondary">${ i }</button>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${ pageInfo.currentPage ne pageInfo.maxPage }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/selectNonMem?currentPage=${pageInfo.currentPage + 1}'">></button>
						</c:if>				
					</c:when>
					
					<c:otherwise>
						<c:if test="${ pageInfo.currentPage > 1 }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/oldestNonMemList.do?currentPage=${pageInfo.currentPage - 1}'"><</button>
						</c:if>
						<c:forEach begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }" var="i">
							<c:choose>
								<c:when test="${pageInfo.currentPage ne i }">
									<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/oldestNonMemList.do?currentPage=${ i }'">${ i }</button>
								</c:when>
								<c:otherwise>
									<button disabled class="btn btn-sm btn-outline-secondary">${ i }</button>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${ pageInfo.currentPage ne pageInfo.maxPage }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/oldestNonMemList.do?currentPage=${pageInfo.currentPage + 1}'">></button>
						</c:if>							
					</c:otherwise>
	
                  </c:choose>

                </div>
        

            </div>
        </div>
        <div id="footer">
     		<jsp:include page="../../common/footer.jsp"></jsp:include> 
        </div>

    </div>
    
    <script>
    
    	function searchNonMemName(){
    		
    		$.ajax({
    			
    			url : 'searchNonMemName.do',
    			type : 'post',
    			data : {keyword : $('#keyword').val()},
    			success : function(result){
    				if(result == null){
      					alert('비회원이 존재하지 않습니다.');
      					location.href = '${path}/selectNonMem?currentPage=1';
      					
      				} else {
      						let resultStr = '';

      					resultStr += '<tr>'
      							   + '<td>' + result.memNo + '</td>'
      							   + '<td>' + result.memName + '</td>'
      							   + '<td>' + result.memPhone + '</td>'
      							   + '<td>' + '<button class="btn btn-sm btn-outline-secondary" onclick="deleteNonMember('+ result.memNo+')">' + '삭제' + '</button>' + '</td>'
      							   + '</tr>'
      			
      				$('#mem_list tbody').html(resultStr);
      				}
    				
    			}
    			
    			
    		});
    		
    		
    		
    	}
    
    	
    	
    	
    	
    	function deleteNonMember(e){
    		
    		$.ajax({
    			url : 'deleteNonMember.do',
    			data : {nonMemNo : e},
    			type : 'get',
    			success : function(result){
    				alert(result.message);
    				location.href = '${path}/selectNonMem?currentPage=1';
    			}
    		});
    		
    	}
    	
    </script>











</body>
</html>