<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
       		
       		<%@ include file="../../common/menubar.jsp" %> 
        </div>       
        <div id="content">
            <div id="content_1">

                <div id="search_member">
                    <div id="search_id">
                        <input type="text" placeholder="예약자명 입력" id="keyword">
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
			          	 <button class="sort-btn" id="oldest" onclick="location.href='<%=contextPath%>/oldestNonMemList.do?currentPage=1'">오래된순</button>
			   			 <button class="sort-btn" id="newest" onclick="location.href='<%=contextPath%>/selectNonMem?currentPage=1'">최신순</button>
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
                        <% if(list!=null &&list.isEmpty()) { %>
                        	<tr>
                        		<th colspan="3">비회원이 존재하지 않습니다.</th>
                        	</tr>
                        <%} else { %>	
                        	<%if(list != null){ %>
                        	<% for(NonMember n : list) { %>
                          <tr>
                            <td><%= n.getMemNo() %></td>
                            <td><%= n.getMemName() %></td>
                            <td><%= n.getMemPhone() %></td>
                            <td><button class="btn btn-sm btn-outline-secondary" onclick="deleteNonMember(<%=n.getMemNo()%>)">삭제</button></td>
                          </tr>
                         <% } %>
                        <% }  %>
                        <% } %>
                          
                          	<% if(oldList!=null &&oldList.isEmpty()) { %>
	                        	<tr>
	                        		<th colspan="3">비회원이 존재하지 않습니다.</th>
	                        	</tr>
                       		 <%} else { %>
                        
                         	<% if(oldList != null) { %>
                       		<%for(NonMember n : oldList) { %>
                       	<tr>
	                       	   		<td><%= n.getMemNo() %></td>
	                                <td><%= n.getMemName() %></td>
	                                <td><%= n.getMemPhone()%></td>
		                            <td><button class="btn btn-sm btn-outline-secondary" onclick="deleteMember(<%=  n .getMemNo() %>)">삭제</button></td>
		                            
	                       	  </tr>
	                       		<%} %>
	                       	<% } %>
	 					<% } %>
	                        
                        
                        
                        
                        
                        </tbody>
                      </table>

                </div>  
        
     <div class="paging-area" align="center";>
               
               <% if(list!=null) { %>
                	<%if(currentPage > 1) { %>
                	<button class="btn btn-sm btn-outline-secondary" onclick="location.href='<%=contextPath%>/selectNonMem?currentPage=<%=currentPage - 1%>'"><</button>
     				<%} %>
                    
                    <% for(int i = startPage; i <= endPage; i ++) { %>
                    	<%if (currentPage != i)  { %>
                    	<button class="btn btn-sm btn-outline-secondary" onclick="location.href='<%=contextPath%>/selectNonMem?currentPage=<%=i%>'"><%= i %></button>
                  		<% } else { %>
                    	<button disabled class="btn btn-sm btn-outline-secondary"><%= i %></button>
                    <% } %>
                   <%} %>
                  
                  <% if(currentPage != maxPage) { %>
                  <button class="btn btn-sm btn-outline-secondary" onclick="location.href='<%=contextPath%>/selectNonMem?currentPage=<%=currentPage + 1%>'">></button>
                  <%} %>
                  
                   <% } else { %>

                    <%if(currentPage > 1) { %>
                	<button class="btn btn-sm btn-outline-secondary" onclick="location.href='<%=contextPath%>/oldestNonMemList.do?currentPage=<%=currentPage - 1%>'"><</button>
     				<%} %>
                    
                    <% for(int i = startPage; i <= endPage; i ++) { %>
                    	<%if (currentPage != i)  { %>
                    	<button class="btn btn-sm btn-outline-secondary" onclick="location.href='<%=contextPath%>/oldestNonMemList.do?currentPage=<%=i%>'"><%= i %></button>
                  		<% } else { %>
                    	<button disabled class="btn btn-sm btn-outline-secondary"><%= i %></button>
                    <% } %>
                   <%} %>
                  
                  <% if(currentPage != maxPage) { %>
                  <button class="btn btn-sm btn-outline-secondary" onclick="location.href='<%=contextPath%>/oldestNonMemList.do?currentPage=<%=currentPage + 1%>'">></button>
                  <%} %>
                  
                  <%} %>
                  
                  
                  
                  
                  
                  
                  
                </div>
        

            </div>
        </div>
        <div id="footer">
        	<%@ include file="../../common/footer.jsp" %> 
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
      					location.href = '<%=contextPath%>/selectNonMem?currentPage=1';
      					
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
    			}
    		});
    		
    	}
    	
    </script>











</body>
</html>