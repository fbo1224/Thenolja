<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList,  thenolja.admin.nonMember.model.vo.NonMember" %>    
<%
	ArrayList<NonMember> list = (ArrayList<NonMember>)request.getAttribute("selectNonMemberList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>관리자메인페이지</title>

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
                        <input type="text" placeholder="예약자명 입력" name="nonMemId">
                    </div>
        
                    <div id="search_btn">
                        <button type="submit" class="btn btn-outline-info">검색</button>
                    </div>
                </form>

            </div>
            <div id="content_2">

                <div id="mem_list_header">

                    <div id="mem_title">
                        <h2>비회원목록</h2>
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
                            <th>비회원 번호</th>
                            <th>예약자명</th>
                            <th>전화번호</th>
                          	<th></th>
                          </tr>
                        </thead>
                        <tbody>
                        <% if(list.isEmpty()) {%>
                        	<tr>
                        		<th colspan="3">비회원이 존재하지 않습니다.</th>
                        	</tr>
                        <%} else { %>	
                        	
                        	<% for(NonMember n : list) { %>
                          <tr>
                            <td><%= n.getMemNo() %></td>
                            <td><%= n.getMemName() %></td>
                            <td><%= n.getMemPhone() %></td>
                             <td><button class="btn btn-sm btn-outline-secondary">삭제</button></td>
                          </tr>
                         <% } %>
                        <% }  %>
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











</body>
</html>