<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, thenolja.admin.member.model.vo.AdminMember, thenolja.common.model.vo.PageInfo"%>

<%
	AdminMember member = (AdminMember)request.getAttribute("member");
	ArrayList<AdminMember> oldList = (ArrayList<AdminMember>)request.getAttribute("oldDeleteMemberList");
	ArrayList<AdminMember> list = (ArrayList<AdminMember>)request.getAttribute("deleteMemberList");
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	
	int currentPage = pageInfo.getCurrentPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();
	int maxPage = pageInfo.getMaxPage();

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>탈퇴 회원 조회</title>
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
		
		padding-right : 20%;
		
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
                        <input type="text" placeholder="탈퇴 회원 ID입력" id="keyword">
                    </div>
        
                    <div id="search_btn">
                        <button type="submit" class="btn btn-outline-info" onclick="searchMemId()">검색</button>
                    </div>
                    
                </div>

            </div>
            <div id="content_2">

                <div id="mem_list_header">

                    <div id="mem_title">
                        <h2>탈퇴 회원목록</h2>
                    </div>
        
                   	<div id="mem_sort">
			          	 <button class="sort-btn" id="oldest" onclick="location.href='<%=contextPath%>/oldestDeleteMemList.do?currentPage=1'">오래된순</button>
			   			 <button class="sort-btn" id="newest" onclick="location.href='<%=contextPath%>/accountCancellation?currentPage=1'">최신순</button>			      
					</div>
        
                </div>
        
                <div id="mem_list">
                    <table class="table table-hover">
                        <thead>
                          <tr>
                            <th>번호</th>
                            <th>아이디</th>
                            <th>닉네임</th>
                            <th>등급</th>
                            <th colspan="2"></th>
                          </tr>
                        </thead>
                        <tbody>
                        <% if(list!=null &&list.isEmpty()) { %>
                        	<tr>
                        		<th colspan="4">탈퇴 회원이 존재하지 않습니다.</th> 
                        	</tr>
                        <% } else { %>
                        	<%if(list != null){ %>
                        	<% for (AdminMember m : list) { %>
                        		<tr>
                        			<td><%= m.getMemNo() %></td>
                        			<td><%= m.getMemId() %></td>
                        			<td><%= m.getNickName() %></td>
                        			<td><%= m.getGradeName() %></td>
                        			<td><button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#myModal" onclick="detailDeleteMem(<%= m.getMemNo() %>)">조회</button></td>
                            		<td><button class="btn btn-sm btn-outline-secondary" onclick="completeDeleteMem(<%= m.getMemNo() %>)">삭제</button></td>
                        		</tr>
                        	<% }  %>
                        <% } %>
                        
                      <% } %>
                      
                        <% if(oldList!=null &&oldList.isEmpty()) { %>
                        	<tr>
                        		<th colspan="3">탈퇴 회원이 존재하지 않습니다.</th>
                        	</tr>
                        <% } else { %>
                      
                           	<% if(oldList != null) { %>
                       		<%for(AdminMember m : oldList) { %>
                       	<tr>
	                       	   		<td><%= m.getMemNo() %></td>
	                       	   		<td><%= m.getMemId() %></td>
	                       	   		<td><%= m.getNickName() %></td>
	                       	   		<td><%= m.getGradeName() %></td>
	                       	   		
		                            <td><button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#myModal" onclick="detailDeleteMem(<%= m.getMemNo() %>)">조회</button></td>
                            		<td><button class="btn btn-sm btn-outline-secondary" onclick="completeDeleteMem(<%= m.getMemNo() %>)">삭제</button></td>
		                            
	                       	  </tr>
                       		<%} %>
                       	<% } %>
					<% } %>
                      
                      
                          
                        </tbody>
                      </table>

                </div>
                
                
                
        
                <div class="paging-area" align="center";>
                
                <% if(list!=null) { %>
	                <% if(currentPage > 1) { %>
	                 <button class="btn btn-sm btn-outline-secondary" onclick="location.href='<%=contextPath%>/accountCancellation?currentPage=<%=currentPage - 1%>'"><</button>
	                <% } %>
	                
	                
                	<% for(int i = startPage; i <= endPage; i++) { %>
                		<% if (currentPage != i) { %>
                    	<button class="btn btn-sm btn-outline-secondary" onclick="location.href='<%=contextPath%>/accountCancellation?currentPage=<%=i%>'"><%= i %></button>
                    
	                    <% } else { %>
	                    <button disabled class="btn btn-sm btn-outline-secondary"><%= i %></button>
	                    <% } %>
                    		
                    <% } %>
                    
                    <% if(currentPage != maxPage) { %>
                    <button class="btn btn-sm btn-outline-secondary" onclick="location.href='<%=contextPath%>/accountCancellation?currentPage=<%=currentPage + 1%>'">></button>
                	<% } %>
                	
                <% } else { %>
                	
                	<%if(currentPage > 1) { %>
                	<button class="btn btn-sm btn-outline-secondary" onclick="location.href='<%=contextPath%>/oldestDeleteMemList.do?currentPage=<%=currentPage - 1%>'"><</button>
     				<%} %>
                    
                    <% for(int i = startPage; i <= endPage; i ++) { %>
                    	<%if (currentPage != i)  { %>
                    	<button class="btn btn-sm btn-outline-secondary" onclick="location.href='<%=contextPath%>/oldestDeleteMemList.do?currentPage=<%=i%>'"><%= i %></button>
                  		<% } else { %>
                    	<button disabled class="btn btn-sm btn-outline-secondary"><%= i %></button>
                    <% } %>
                   <%} %>
                  
                  <% if(currentPage != maxPage) { %>
                  <button class="btn btn-sm btn-outline-secondary" onclick="location.href='<%=contextPath%>/oldestDeleteMemList.do?currentPage=<%=currentPage + 1%>'">></button>
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
    
    	function searchMemId(){
    		
    		$.ajax({
    		
    			url : 'searchDeleteMemberId.do',
    			type : 'post',
    			data : {keyword : $('#keyword').val()},
    			success : function(result){
    				
    				if(result == null){
      					alert('탈퇴 회원이 존재하지 않습니다.');
      					location.href = '<%=contextPath%>/accountCancellation?currentPage=1';
      					
      				} else {
      						let resultStr = '';

      					resultStr += '<tr>'
      							   + '<td>' + result.memNo + '</td>'
      							   + '<td>' + result.memId + '</td>'
      							   + '<td>' + result.nickName + '</td>'
      							   + '<td>' + result.gradeName + '</td>'
      							   + '<td>' + '<button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#myModal" onclick="detailDeleteMem('+ result.memNo+')">' + '조회' + '</button>' + '</td>'
    	                           + '<td>' + '<button class="btn btn-sm btn-outline-secondary" onclick="completeDeleteMem('+ result.memNo+')">' + '삭제' + '</button>' + '</td>'
      							   + '</tr>'
      			
      				$('#mem_list tbody').html(resultStr);
      				}

    				
    				
    			}
    			
    		});
    		
    		
    	}
    
    
    
    
    
    
    
    
    
    
    
    
    	function detailDeleteMem(e){
    		console.log(e);
    		$.ajax({
    			url : 'detailMember.do',
    			data : {memNo : e},
    			type : 'get',
    			success : function(result){
    				$('#name').text(result.memName);
    				$('#grade').text(result.gradeName);
    				$('#email').text(result.email);
    				$('#joinDate').text(result.joinDate);
    				$('#phone').text(result.memPhone);
    				$('#totalPrice').text(result.paymentPrice);
    				$('#bornDate').text(result.bornDate);
    				$('#profilePath').attr("src", result.profilePath);
    				
    				
    			}
    			
    		});
    	}
    
    </script>
    
    <script>
    	function completeDeleteMem(e){
    		console.log(e);
    		$.ajax({
    			url : 'deleteCompelete.do',
    			data : {memNo : e},
    			type : 'get',
    			success : function(result){
    				alert(result.message);
    				location.href = '<%=contextPath%>/accountCancellation?currentPage=1';
    			}
    			
    		});
    		
    	}
    
    </script>
    
    
    
    
    
    
    
    

 <!-- 회원 상세 조회 모달 -->
 <div class="modal" id="myModal">

    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
            <p class="modal-title">탈퇴 회원 상세 정보</p>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
            <table style="font-size: 14px;">
                <tr>
                    <td colspan="5" rowspan="5" width="120" height="120" ><img id="profilePath" src="" alt="" width="70px"></td>
                    <td width="200">이름 : <span id="name"></span></td>
                    <td width="200">등급 : <span id="grade"></span></td>
                </tr>
                <tr>
                    <td>이메일 : <span id="email"></span></td>
                    <td>가입일 : <span id="joinDate"></span></td>
                </tr>
                <tr>
                    <td>전화번호 : <spna id="phone"></spna></td>
                    <td>총 이용 금액 : <span id="totalPrice"></span></td>
                </tr>
                <tr>
                    <td>생년월일 : <span id="bornDate"></span></td>
                    <td></td>
                </tr>
              </table>

        </div>

    
        
      </div>
    </div>
  </div>
  











</body>
</html>