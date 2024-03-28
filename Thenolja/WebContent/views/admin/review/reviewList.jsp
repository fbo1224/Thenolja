<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, thenolja.admin.review.model.vo.AdminReview, thenolja.common.model.vo.PageInfo" %>   
<%
	ArrayList<AdminReview> list = (ArrayList<AdminReview>)request.getAttribute("selectReviewMemberList");
	
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	
	int currentPage = pageInfo.getCurrentPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();
	int maxPage = pageInfo.getMaxPage();

%>    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <title>리뷰 목록</title>
 	<link rel="stylesheet" href="resources/css/admin_select.css">   
</head>

<style>
#contentMessage > td {
	text-align : left;
	padding-left : 10px;
}

</style>

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
                        <h2>리뷰목록</h2>
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
                            <th>숙소이름</th>
                            <th>아이디</th>
                            <th>닉네임</th>
                            <th>작성일</th>
                            <th colspan="2"></th>
                          </tr>
                        </thead>
                        <tbody>
                        
                        
                        <% if(list.isEmpty()) { %>
                        	<tr>
                        		<th colspan="4">리뷰가 존재하지 않습니다.</th>
                        	</tr>
                        <% } else { %>
                        	<% for(AdminReview review : list) { %>
                        		<tr>
                        			<td><%=review.getHotelName() %></td>
                        			<td><%=review.getMemId() %></td>
                        			<td><%=review.getNickName() %></td>
                        			<td><%=review.getCreateDate() %></td>
                        			<td><button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#myModal" onclick="detailReview(<%=review.getReserNo()%>)">조회</button></td>
                        			<td><button class="btn btn-sm btn-outline-secondary" onclick="deleteReview(<%=review.getReserNo()%>)">삭제</button></td>
                        		</tr>
                        	<% } %>
                        <% } %>
                   
                        </tbody>
                      </table>

                </div>
        
                <div class="paging-area" align="center";>
                
                	<%if(currentPage > 1) {%>
                    <button class="btn btn-sm btn-outline-secondary"  onclick="location.href='<%=contextPath%>/adminReviewList?currentPage=<%=currentPage - 1%>'"><</button>
                    <% } %>
                    
                    <% for(int i = startPage; i <= endPage; i++) { %>
                    	<% if(currentPage != i)  { %>
                    	<button class="btn btn-sm btn-outline-secondary" onclick="location.href='<%=contextPath%>/adminReviewList?currentPage=<%=i%>'"><%=i %></button>
                    	<% } else { %>
							<button disabled class="btn btn-sm btn-outline-secondary"><%= i %></button>
                		<% } %>
                		<% } %>
                		
                		<% if(currentPage != maxPage) { %>
                		<button class="btn btn-sm btn-outline-secondary" onclick="location.href='<%=contextPath%>/adminReviewList?currentPage=<%=currentPage + 1%>'">></button>
                		<% } %>
                	</div>
        

            </div>
        </div>
        <div id="footer"></div>

    </div>
    
    
    <script>
    	function detailReview(e){
    		$.ajax({
    			url : 'detailReview.do',
    			data : {reserNo : e},
    			type : 'get',
    			success : function(result){
    				console.log(result);
    				 // alert(e);
    				$('#hotelName').text(result.hotelName);
    				$('#roomName').text(result.roomName);
    				$('#reviewScore').text(result.reviewScore);
    				$('#reviewContent').text(result.reviewContent);
    				$('#reserNo22').val(e);
    			}
    		});
    	}
    
    
    </script>
    
    <script>
    	function deleteReview(e){
    		
    		$.ajax({
    			
    			url : 'deleteReview.do',
    			data : {reserNo : e},
    			type : 'get',
    			success : function(result){
    				alert(result.message);
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
            <p class="modal-title"> 리뷰 상세 조회</p>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
        
			<input type="hidden" id="reserNo22" name="reser_No" value=""/>
		
		
            <table>
                <tr>
                    <td colspan="5" rowspan="5" width="120" height="120" ><img src="" alt="" width="120px"></td>
                    <td width="120"><span id="hotelName"></span></td>
                    <td><span id="roomName"></span></td>
                    <td><span id="reviewScore"></span></td>
                </tr>
                <tr id="contentMessage">
                    <td colspan="3" width="300"><span id="reviewContent"></span></td>
                </tr>

              </table>

            <div class="container">
                  <div class="form-group">
                    <div><p>답글 작성</p></div>
                    <textarea class="form-control" rows="5" id="comment" name="text" cols="53"></textarea>
                  </div>
                  <button type="button" class="btn btn-sm btn-outline-secondary" style="float: right;" onclick="insertComment()">등록하기</button>
              </div>

        </div>

    
        
      </div>
    </div>
  </div>



	<script>
		
		function selectReplyList(){
			
			$.ajax({
				
				url : 'commentList.do',
				data : {reserNo : $('#reserNo22').val()},
				success : function(result){
					console.log(result);
				},
				error : function(e){
					console.log(e);
				}
				
			});
		}
	
	
		$(function(){
			
			
		});
	
	
	
	
	
		function insertComment(){
			$.ajax({
				url : 'commentInsert.do',
				type : 'post',
				data : {
					content : $('#comment').val(),
					reserNo : $('#reserNo22').val(),
					memNo : <%= loginUser.getMemNo() %>
				},
				success : function(result){
					// console.log(result);	
					
					if(result == 'success'){
						$('#comment').val('');
					}
				}
			});
			
		}
	
	
	</script>




</body>
</html>