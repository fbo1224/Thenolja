<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, thenolja.admin.member.model.vo.AdminMember, thenolja.common.model.vo.PageInfo" %>
<%
	
	ArrayList<AdminMember> list = (ArrayList<AdminMember>)request.getAttribute("selectMemberList");
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	
	int currentPage = pageInfo.getCurrentPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();
	int maxPage = pageInfo.getMaxPage();
	
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>회원조회</title>
 	<link rel="stylesheet" href="resources/css/admin_select.css">
</head>

<style>
       #detailList{
            width: 100%;
            height: 90%;
        }


        #mem_update{
            width: 10%;
            height: 10%;
            margin: auto;
            margin-top: 5%;
        }


</style>

<body>


    
    <div id="wrap">
        <div id="header">
        <%@ include file="../../common/adminMenubar.jsp" %> 
        </div>
               
        <div id="content">
            <div id="content_1">
                <div id="search_member">
                    <div id="search_id">
                        <input type="text" placeholder="회원 ID입력" id="keyword">
                    </div>        
                    <div id="search_btn">
                        <button type="button" class="btn btn-outline-info" onclick="searchMemId()">검색</button>
                    </div>
                </div>

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
                    <table class="table table-hover" id="mem_detail_List">
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
                       		<% for(AdminMember m : list) { %>
	                       	   <tr class="memNo">
	                       	   		<td><%= m.getMemNo() %></td>
	                       	   		<td><%= m.getMemId() %></td>
	                       	   		<td><%= m.getNickName() %></td>
	                       	   		<td><%= m.getGradeName() %></td>
	                       	   		
		                            <td><button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#memberModal" onclick="detailMem(<%= m.getMemNo() %>)">조회</button></td>
		                            <td><button class="btn btn-sm btn-outline-secondary" onclick="deleteMember(<%= m.getMemNo() %>)">삭제</button></td>
		                            
	                       	  </tr>
                       		<% } %>
                       <% } %>
                          
                          
                        </tbody>
                      </table>
                </div>
        
        
                <div class="paging-area" align="center";>
                
                	<%if(currentPage > 1) { %>
                	<button class="btn btn-sm btn-outline-secondary" onclick="location.href='<%=contextPath%>/selectMember?currentPage=<%=currentPage - 1%>'"><</button>
     				<%} %>
                    
                    <% for(int i = startPage; i <= endPage; i ++) { %>
                    	<%if (currentPage != i)  { %>
                    	<button class="btn btn-sm btn-outline-secondary" onclick="location.href='<%=contextPath%>/selectMember?currentPage=<%=i%>'"><%= i %></button>
                  		<% } else { %>
                    	<button disabled class="btn btn-sm btn-outline-secondary"><%= i %></button>
                    <% } %>
                   <%} %>
                  
                  <% if(currentPage != maxPage) { %>
                  <button class="btn btn-sm btn-outline-secondary" onclick="location.href='<%=contextPath%>/selectMember?currentPage=<%=currentPage + 1%>'">></button>
                  <%} %>
                </div>
        
            </div>
        </div>
        <div id="footer"></div>

    </div>
    
    
      <script>
  	function searchMemId(){
  	
  		$.ajax({
  			
  			url : 'searchMemberId.do',
  			type : 'post',
  			data : { keyword : $('#keyword').val()},
  			success : function(result){
  				console.log(result);
  				//$('.memNo').text(result);
  				if(result == null){
  					alert('회원이 존재하지 않습니다.');
  					location.href = '<%=contextPath%>/selectMember?currentPage=1';
  					
  				} else {
  						let resultStr = '';

  						resultStr += '<tr>'
	  							   + '<td>' + result.memNo + '</td>'
	  							   + '<td>' + result.memId + '</td>'
	  							   + '<td>' + result.nickName + '</td>'
	  							   + '<td>' + result.gradeName + '</td>'
	  							   + '<td>' + '<button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#memberModal" onclick="detailMem('+ result.memNo+')">' + '조회' + '</button>' + '</td>'
		                           + '<td>' + '<button class="btn btn-sm btn-outline-secondary" onclick="deleteMember('+ result.memNo+')">' + '삭제' + '</button>' + '</td>'
	  							   + '</tr>'
	  			
	  				$('#mem_list tbody').html(resultStr);
  				}

  				
  			
  			}
  		});
  		
  	}
 
  	
  	
  	
  	
  	function detailMem(e){
        				// console.log(e);
        				
        				$.ajax({
        					url : 'detailMember.do',
        					data : {memNo : e},
        					type : 'get',
        					success : function(result){
        						// console.log(result);
        						$('#name').text(result.memName);
        						$('#grade').text(result.gradeName);
        						$('#email').text(result.email);
        						$('#phone').text(result.memPhone);
        						$('#bornDate').text(result.bornDate);
        						$('#joinDate').text(result.joinDate);
        						$('#totalPrice').text(result.paymentPrice);
        						$('#updateMemNo').val(e);

        					}
        					
        				});
        				
        			}
        		
  
			      function deleteMember(e){
			          console.log(e);
			       
			          $.ajax({
			             url : 'deleteMember.do',
			             data : {memNo : e},
			             type : 'get',
			             success : function(result){
			             alert(result.message);
			             location.href = '<%=contextPath%>/selectMember?currentPage=1';
			             
			             }
			             
			          });
			          
			       }


      
      </script>
       
       
       
       
       
       

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
            <div id="detailList">
            
            	<input type="hidden" id="updateMemNo" name="member_No" value=""/>
            
                <table style="font-size: 14px;">
                    <tr>
                        <td colspan="5" rowspan="5" width="120" height="120" ><img src="https://static-00.iconduck.com/assets.00/address-book-new-icon-2048x2048-wtz2hcio.png" alt="" width="70px"></td>
                        <td width="200">이름 :<span id="name"></span></td>
                        <td width="200">등급 :
                            <select id="gradeSelect" name="grade">
                                <option value="1">FAMILY</option>
                                <option value="2">SILVER</option>
                                <option value="3">GOLD</option>
                                <option value="4">VIP</option>
                                <option value="5">VVIP</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>이메일 : <span id="email"></span></td>
                        <td>가입일 : <span id="joinDate"></span></td>
                    </tr>
                    <tr>
                        <td>전화번호 :<span id="phone"></span></td>
                       <td>총 이용 금액 : <span id="totalPrice"></span>원</td>
                     
                    </tr>
                    <tr>
                        <td>생년월일 : <span id="bornDate"></span></td>
                    </tr>
                  </table>

                <div id="mem_update">
                    <button class="btn btn-sm btn-outline-secondary" onclick="updateGrade()">수정</button>
                </div>



        </div>

    
        
      </div>
    </div>
  </div>
  </div>
  
  <script>
  	function updateGrade(){
  		
  		$.ajax({
  			
  			url : 'gradeUpdate.do',
  			type : 'get',
  			data : {memNo : $('#updateMemNo').val(),
  					gradeNo : $('#gradeSelect').val()},
  			success : function(result) {
  				// console.log(result);
  				alert('등급 수정이 완료되었습니다!');
  				location.reload(true);
  			}
  			
  		});
  		
  	}
  
  </script>
  
  




</body>
</html>