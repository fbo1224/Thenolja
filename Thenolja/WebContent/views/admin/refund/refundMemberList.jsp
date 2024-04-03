<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList,   thenolja.admin.refund.model.vo.AdminRefund , thenolja.common.model.vo.PageInfo" %>    
<%
	ArrayList<AdminRefund> oldList = (ArrayList<AdminRefund>)request.getAttribute("OldRefundMemberList");
	ArrayList<AdminRefund> list = (ArrayList<AdminRefund>)request.getAttribute("selectRefundMemberList");

	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	
	int currentPage = pageInfo.getCurrentPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();
	int maxPage = pageInfo.getMaxPage();

%>    
    
    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <title>회원 환불 목록</title>
    
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
                        <input type="text" placeholder="회원  ID입력" id="keyword">
                    </div>
        
                    <div id="search_btn">
                        <button type="button" class="btn btn-outline-info" onclick="searchRefundMem()">검색</button>
                    </div>
                </div>

            </div>
            <div id="content_2">

                <div id="mem_list_header">

                    <div id="mem_title">
                        <h2>회원 환불 목록</h2>
                    </div>
        
 					<div id="mem_sort">
			          	 <button class="sort-btn" id="oldest" onclick="location.href='<%=contextPath%>/oldestRefundMemList.do?currentPage=1'">오래된순</button>
						 <button class="sort-btn" id="newest" onclick="location.href='<%=contextPath%>/refundMem?currentPage=1'">최신순</button>
					</div>
        
                </div>
        
                <div id="mem_list">
                    <table class="table table-hover">
                        <thead>
                          <tr>
                            <th>예약번호</th>
                            <th>아이디</th>
                            <th>예약자명</th>
                            <th>전화번호</th>
                            <th colspan="2"></th>
                          </tr>
                        </thead>
                        <tbody>
                        
                        
                         <% if(list!=null &&list.isEmpty()) { %>
                        	<tr>
                        		<th colspan="4">환불 회원이 존재하지 않습니다.</th>
                        	</tr>
                        <% } else { %>
                        	
                        	<%if(list != null){ %>
                        	<% for(AdminRefund refundMem : list) { %>
                        	<tr>
                        		<td><%=refundMem.getReserNo() %></td>
                        		<td><%=refundMem.getMemId() %>
                        		<td><%=refundMem.getReserName() %>
                        		<td><%=refundMem.getMemPhone() %>
                        	 	<td><button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#myModal" onclick="selectRefundMember(<%=refundMem.getReserNo()%>)">조회</button></td>
                        	</tr>
                        	
                        		<% } %>
                        	<% } %>
                        <% } %>
                        
                         <% if(oldList!=null &&oldList.isEmpty()) { %>
                        	<tr>
                        		<th colspan="4">환불 회원이 존재하지 않습니다.</th>
                        	</tr>
                        <% } else { %>
                        	
                          	
                       	<% if(oldList != null) { %>
                       		<%for(AdminRefund refundMem : oldList) { %>
                       	<tr>
                        		<td><%=refundMem.getReserNo() %></td>
                        		<td><%=refundMem.getMemId() %>
                        		<td><%=refundMem.getReserName() %>
                        		<td><%=refundMem.getMemPhone() %>	                       	   		
		                     	<td><button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#myModal" onclick="selectRefundMember(<%=refundMem.getReserNo()%>)">조회</button></td>
		                            
	                       	  </tr>
                       		<%} %>
                       	<% } %>
                  
                        <%} %>
        
                        </tbody>
                      </table>

                </div>
        
                <div class="paging-area" align="center";>
                
                <% if(list!=null) { %>
                	<% if(currentPage > 1) { %>
                    <button class="btn btn-sm btn-outline-secondary" onclick="location.href='<%=contextPath%>/refundMem?currentPage=<%=currentPage - 1%>'"><</button>
                    <% } %>
                    
                    <% for(int i = startPage; i <= endPage; i++) { %>
                    	<%if(currentPage != i) { %>
                    		 
                    		 <button class="btn btn-sm btn-outline-secondary" onclick="location.href='<%=contextPath%>/refundMem?currentPage=<%=i%>'"><%=i %></button>
                    	<% } else { %>
                    		 <button disabled class="btn btn-sm btn-outline-secondary"><%=i %></button>
                    	<% } %>
                    <% } %>
                    
                   <% if(currentPage != maxPage) { %>
                    <button class="btn btn-sm btn-outline-secondary" onclick="location.href='<%=contextPath%>/refundMem?currentPage=<%=currentPage + 1%>'">></button>
                   <% } %>
                  
                   <% } else { %>
                   
                    <%if(currentPage > 1) { %>
                	<button class="btn btn-sm btn-outline-secondary" onclick="location.href='<%=contextPath%>/oldestRefundMemList.do?currentPage=<%=currentPage - 1%>'"><</button>
     				<%} %>
                    
                    <% for(int i = startPage; i <= endPage; i ++) { %>
                    	<%if (currentPage != i)  { %>
                    	<button class="btn btn-sm btn-outline-secondary" onclick="location.href='<%=contextPath%>/oldestRefundMemList.do?currentPage=<%=i%>'"><%= i %></button>
                  		<% } else { %>
                    	<button disabled class="btn btn-sm btn-outline-secondary"><%= i %></button>
                    <% } %>
                   <%} %>
                  
                  <% if(currentPage != maxPage) { %>
                  <button class="btn btn-sm btn-outline-secondary" onclick="location.href='<%=contextPath%>/oldestRefundMemList.do?currentPage=<%=currentPage + 1%>'">></button>
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
    
    	function searchRefundMem(){
    		
    		$.ajax({
    		url : 'searchRefundMem.do',
    		type : 'post',
    		data : { keyword : $('#keyword').val()},
    		success : function(result){
    			if(result.length === 0){
  					alert('회원이 존재하지 않습니다.');
  					location.href = '<%=contextPath%>/refundMem?currentPage=1';
  					
  				} else {
  						let resultStr = '';
						
  						for(let i = 0; i < result.length; i++){
  							resultStr += '<tr>'
	  							   + '<td>' + result[i].reserNo + '</td>'
	  							   + '<td>' + result[i].memId + '</td>'
	  							   + '<td>' + result[i].reserName + '</td>'
	  							   + '<td>' + result[i].memPhone + '</td>'
	  							   + '<td>' + '<button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#myModal" onclick="selectRefundMember('+ result[i].reserNo+')">' + '조회' + '</button>' + '</td>'
	  							   + '</tr>'
	  			
  						};
  						
	  				$('#mem_list tbody').html(resultStr);
  				}

  				
  			
  			}
  		});
  		
  	}
 
    
    
        
    
    
    
    
    	function selectRefundMember(e){
    		console.log(e);
    		$.ajax({
    			url : 'refundMember.do',
    			data : {reserNo : e},
    			type : 'get',
    			success : function(result){
    				$('#hotelName').text(result.hotelName);
    				$('#refundName').text(result.refundName);
    				$('#reserDate').text(result.reserDate);
    				$('#bank').text(result.bank);
    				$('#refundPrice').text(result.refundPrice);
    				$('#refundAccNo').text(result.refundAccNo);
    				$('#hotelPath').attr("src", result.hotelPath);
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
            <p class="modal-title"> 환불 상세 정보</p>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
            <table style="font-size: 12px;">
                <tr>
                    <td colspan="5" rowspan="5" width="120" height="120" ><img id="hotelPath" src="" alt="" width="120px"></td>
                    <td width="200"><b>숙소 정보</b></td>
                    <td><b>환불자 정보</b></td>
                </tr>
                <tr>
                    <td><span id="hotelName"></span></td>
                    <td>예금주 : <span id="refundName"></span></td>
                
                </tr>
                <tr>
                    <td>예약일 : <span id="reserDate"></span></td>
                    <td>은행 : <span id="bank"></span></td>
                </tr>
    
                <tr>
                    <td>환불 금액 : <span id="refundPrice"></span></td>
                    <td>계좌번호 : <span id="refundAccNo"></span></td>
                </tr>

              </table>

        </div>

    
        
      </div>
    </div>
  </div>
  











</body>
</html>