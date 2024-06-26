<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList, thenolja.admin.member.model.vo.AdminMember, thenolja.common.model.vo.PageInfo"%>

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
            <jsp:include page="../../common/menubar.jsp"></jsp:include>
        </div>

               
        <div id="content">
            <div id="content_1">

                <div id="search_member">
                    <div id="search_id">
                        <input type="text" placeholder="탈퇴 회원 ID입력" id="keyword" maxlength="12">
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
			          	 <button class="sort-btn" id="oldest" onclick="location.href='${path}/oldestDeleteMemList.do?currentPage=1'">오래된순</button>
			   			 <button class="sort-btn" id="newest" onclick="location.href='${path}/accountCancellation?currentPage=1'">최신순</button>			      
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
                        
                        <c:choose>
                        	<c:when test="${ requestScope.deleteMemberList ne null && empty requestScope.deleteMemberList}">
	                        	<tr>
	                        		<th colspan="4">탈퇴 회원이 존재하지 않습니다.</th> 
	                        	</tr>    
	                        </c:when>                    	
                        	<c:when test="${ requestScope.deleteMemberList ne null }">
                        		<c:forEach var="m" items="${ requestScope.deleteMemberList }">
	                        		<tr>
	                        			<td>${m.memNo}</td>
	                        			<td>${m.memId}</td>
	                        			<td>${m.nickName}</td>
	                        			<td>${m.gradeName}</td>
	                        			<td><button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#myModal" onclick="detailDeleteMem(${m.memNo})">조회</button></td>
	                            		<td><button class="btn btn-sm btn-outline-secondary" onclick="completeDeleteMem(${m.memNo})">삭제</button></td>
	                        		</tr>                        		
                        		</c:forEach>
                        	</c:when>
                        </c:choose>



                      	<c:choose>
                      		<c:when test="${requestScope.oldDeleteMemberList ne null && empty requestScope.oldDeleteMemberList }">
	                        	<tr>
	                        		<th colspan="3">탈퇴 회원이 존재하지 않습니다.</th>
	                        	</tr>                      		
                      		</c:when>
                      		<c:when test="${ requestScope.oldDeleteMemberList ne null}">
                      			<c:forEach var="m" items="${requestScope.oldDeleteMemberList }">
	                       			<tr>
		                       	   		<td>${m.memNo}</td>
		                       	   		<td>${m.memId}</td>
		                       	   		<td>${m.nickName}</td>
		                       	   		<td>${m.gradeName}</td>
		                       	   		
			                            <td><button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#myModal" onclick="detailDeleteMem(${m.memNo})">조회</button></td>
	                            		<td><button class="btn btn-sm btn-outline-secondary" onclick="completeDeleteMem(${m.memNo})">삭제</button></td>
			                            
		                       	  </tr>                      				
                      			</c:forEach>
                      		</c:when>
                      	</c:choose>
                      
                          
                        </tbody>
                      </table>

                </div>
                
                
                
                <div class="paging-area" align="center";>                
				
				<c:choose>
					<c:when test="${requestScope.deleteMemberList ne null }">
						<c:if test="${ pageInfo.currentPage > 1 }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/accountCancellation?currentPage=${pageInfo.currentPage - 1}'"><</button>
						</c:if>
						<c:forEach begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }" var="i">
							<c:choose>
								<c:when test="${pageInfo.currentPage ne i }">
									<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/accountCancellation?currentPage=${ i }'">${ i }</button>
								</c:when>
								<c:otherwise>
									<button disabled class="btn btn-sm btn-outline-secondary">${ i }</button>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${ pageInfo.currentPage ne pageInfo.maxPage }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/accountCancellation?currentPage=${pageInfo.currentPage + 1}'">></button>
						</c:if>				
					</c:when>
					
					
					
					<c:otherwise>
						<c:if test="${ pageInfo.currentPage > 1 }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/oldestDeleteMemList.do?currentPage=${pageInfo.currentPage - 1}'"><</button>
						</c:if>
						<c:forEach begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }" var="i">
							<c:choose>
								<c:when test="${pageInfo.currentPage ne i }">
									<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/oldestDeleteMemList.do?currentPage=${ i }'">${ i }</button>
								</c:when>
								<c:otherwise>
									<button disabled class="btn btn-sm btn-outline-secondary">${ i }</button>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${ pageInfo.currentPage ne pageInfo.maxPage }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/oldestDeleteMemList.do?currentPage=${pageInfo.currentPage + 1}'">></button>
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
    
    	function searchMemId(){
    		
    		$.ajax({
    		
    			url : 'searchDeleteMemberId.do',
    			type : 'post',
    			data : {keyword : $('#keyword').val()},
    			success : function(result){
    				
    				if(result == null){
      					alert('탈퇴 회원이 존재하지 않습니다.');
      					location.href = '${path }/accountCancellation?currentPage=1';
      					
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
    				if(result.profilePath == null) {
						$('#profilePath').attr("src", "./resources/mypage/user.png");
					} else{
    				$('#profilePath').attr("src", result.profilePath);
    				
					}
    				
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
    				location.href = '${path }/accountCancellation?currentPage=1';
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