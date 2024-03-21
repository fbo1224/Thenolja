<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, thenolja.admin.member.model.vo.Member" %>
<%
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("selectMemberList");
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>회원조회</title>
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
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
                        <input type="text" placeholder="회원 ID입력" name="memId">
                    </div>
        
                    <div id="search_btn">
                        <button type="submit" class="btn btn-outline-info">검색</button>
                    </div>
                </form>

            </div>
            <div id="content_2">

                <div id="mem_list_header">

                    <div id="mem_title">
                        <h2>회원목록</h2>
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
                            <th>번호</th>
                            <th>아이디</th>
                            <th>닉네임</th>
                            <th>등급</th>
                            <th colspan="2"></th>
                          </tr>
                        </thead>
                        <tbody>
                       
                       <% if(list.isEmpty()) { %>
                       	   <tr>
                       	   		<th colspan="6">회원이 존재하지 않습니다.</th>                       	   
                       	  </tr>
                       <% } else { %>
                       		<% for(Member m : list) { %>
	                       	   <tr class="memNo" >
	                       	   		<td><%= m.getMemNo() %></td>
	                       	   		<td><%= m.getMemId() %></td>
	                       	   		<td><%= m.getNickName() %></td>
	                       	   		<td><%= m.getGradeName() %></td>
	                       	   		
		                            <td><button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#memberModal">조회</button></td>
		                            <td><button class="btn btn-sm btn-outline-secondary">삭제</button></td>
		                            <input type="hidden" name="memNo" value="<%= m.getMemNo() %>" > 
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
 <div class="modal" id="memberModal">

    <div class="modal-dialog">
      <div class="modal-content">
      
<!-- Modal Header -->
        <div class="modal-header">
            <p class="modal-title"> 회원 상세 정보</p>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
            <table>
                <tr>
                    <td colspan="5" rowspan="5" width="120" height="120" ><img src="https://static-00.iconduck.com/assets.00/address-book-new-icon-2048x2048-wtz2hcio.png" alt="" width="70px"></td>
                    <td width="200">이름 : </td>
                    <td width="200">등급 : </td>
                </tr>
                <tr>
                    <td>이메일 :</td>
                    <td>가입일 : </td>
                </tr>
                <tr>
                    <td>전화번호 : </td>
                    <td>숙소 이용 횟수 : 1회</td>
                </tr>
                <tr>
                    <td>생년월일 : </td>
                    <td></td>
                </tr>
	            
              </table>

        </div>

      </div>
    </div>
  </div>
  











</body>
</html>