<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList,   thenolja.admin.refund.model.vo.AdminRefund , thenolja.common.model.vo.PageInfo" %>    
<%

	ArrayList<AdminRefund> list = (ArrayList<AdminRefund>)request.getAttribute("selectRefundMemberList");


%>    
    
    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <title>회원 환불 목록</title>
    
    <link rel="stylesheet" href="resources/css/admin_select.css">    
</head>
<body>
    
    <div id="wrap">
        <div id="header">

       		<%@ include file="../../common/adminMenubar.jsp" %> 
	
        </div>
               
        <div id="content">
            <div id="content_1">

                <form action="#" method="get" id="search_member">
                    <div id="search_id">
                        <input type="text" placeholder="회원  ID입력" name="memId">
                    </div>
        
                    <div id="search_btn">
                        <button type="submit" class="btn btn-outline-info">검색</button>
                    </div>
                </form>

            </div>
            <div id="content_2">

                <div id="mem_list_header">

                    <div id="mem_title">
                        <h2>회원 환불 목록</h2>
                    </div>
        
                    <div id="mem_sort">
                        <select>
                            <option value="newest">최신순</option>
                            <option value="oldset">오래된순</option>
                        </select>
        
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
                        
                        
                        <% if(list.isEmpty()) { %>
                        	<tr>
                        		<th colspan="4">환불 회원이 존재하지 않습니다.</th>
                        	</tr>
                        <% } else { %>
                        
                        	<% for(AdminRefund adminRefund : list) { %>
                        	<tr>
                        		<td><%=adminRefund.getReserNo() %></td>
                        		<td><%=adminRefund.getMemId() %>
                        		<td><%=adminRefund.getReserName() %>
                        		<td><%=adminRefund.getMemPhone() %>
                        	 	<td><button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#myModal">조회</button></td>
                        	</tr>
                        	
                        	
                        	<% } %>
                        <% } %>
                        
        
                        </tbody>
                      </table>

                </div>
        
                <div class="paging-area" align="center";>
                    <button class="btn btn-sm btn-outline-secondary"><</button>
                    <button class="btn btn-sm btn-outline-secondary">1</button>
                    <button class="btn btn-sm btn-outline-secondary">2</button>
                    <button class="btn btn-sm btn-outline-secondary">3</button>
                    <button class="btn btn-sm btn-outline-secondary">4</button>
                    <button class="btn btn-sm btn-outline-secondary">5</button>
                    <button class="btn btn-sm btn-outline-secondary">></button>
                </div>
        

            </div>
        </div>
        <div id="footer"></div>

    </div>

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
            <table>
                <tr>
                    <td colspan="5" rowspan="5" width="120" height="120" ><img src="https://cf.bstatic.com/xdata/images/hotel/max1280x900/82237660.jpg?k=cb5db13896d348f7c4b47e3922a6753f83b5c36ba7b71a6f820523d07365fc2c&o=&hp=1" alt="" width="120px"></td>
                    <td width="200">숙소 정보</td>
                    <td>환불자 정보</td>
                </tr>
                <tr>
                    <td>마리안느 호텔</td>
                    <td>예금주 : 이혜인</td>
                
                </tr>
                <tr>
                    <td>예약일 : 2024.03.15</td>
                    <td>은행 : 국민은행</td>
                </tr>
    
                <tr>
                    <td>환불 금액 : 300000</td>
                    <td>계좌번호 : 3339191831</td>
                </tr>

              </table>

        </div>

    
        
      </div>
    </div>
  </div>
  











</body>
</html>