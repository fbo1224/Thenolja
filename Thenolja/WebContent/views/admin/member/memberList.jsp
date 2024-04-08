<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<body>

    <c:set var="path" value="${ pageContext.request.contextPath }" />

    <div id="wrap">
        <div id="header">
            <jsp:include page="../../common/menubar.jsp"></jsp:include>
        </div>
               
        <div id="content">
            <div id="content_1">
                <div id="search_member">
                    <div id="search_id">
                        <input type="text" placeholder="회원 ID입력" id="keyword" maxlength="12">
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
			          	 <button class="sort-btn" id="oldest" onclick="location.href='${path}/oldestList.do?currentPage=1'">오래된순</button>
			   			 <button class="sort-btn" id="newest" onclick="location.href='${path}/selectMember?currentPage=1'">최신순</button>
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
                        
                       <c:choose>
                       	<c:when test="${ requestScope.selectMemberList ne null && empty requestScope.selectMemberList }">
                         	   <tr>
                       	   			<th colspan="6">회원이 존재하지 않습니다.</th>                       	   
                       	  	   </tr>
                       	</c:when>
                       	<c:when test="${ requestScope.selectMemberList ne null }">
                       		<c:forEach var="m" items="${ requestScope.selectMemberList }">
                       			<tr>
	                       	   		<td>${m.memNo}</td>
	                       	   		<td>${m.memId}</td>
	                       	   		<td>${m.nickName}</td>
	                       	   		<td>${m.gradeName}</td>
	                       	   		
		                            <td><button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#memberModal" onclick="detailMem(${m.memNo})">조회</button></td>
		                            <td><button class="btn btn-sm btn-outline-secondary" onclick="deleteMember(${m.memNo})">삭제</button></td>
		                            
	                       	  </tr>
                       		</c:forEach>
                       	</c:when>
                       </c:choose>
                        
                       
              		  <c:choose>
              		  	<c:when test="${ requestScope.memberOldsetList ne null && empty requestScope.memberOldsetList }">
                       	   <tr>
                       	   		<th colspan="6">회원이 존재하지 않습니다.</th>                       	   
                       	  </tr>              		  	
              		  	</c:when>
              		  	<c:when test="${requestScope.memberOldsetList ne null }">
                       		<c:forEach var="m" items="${ requestScope.memberOldsetList }">
	                       		<tr>
		                       	   		<td>${m.memNo}</td>
		                       	   		<td>${m.memId}</td>
		                       	   		<td>${m.nickName}</td>
		                       	   		<td>${m.gradeName}</td>
		                       	   		
			                            <td><button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#memberModal" onclick="detailMem(${m.memNo})">조회</button></td>
			                            <td><button class="btn btn-sm btn-outline-secondary" onclick="deleteMember(${m.memNo})">삭제</button></td>
			                            
		                       	 </tr>              		  		
              		  		</c:forEach>
              		  	</c:when>
              		  </c:choose>
                          
                        </tbody>
                      </table>
                </div>

                <div class="paging-area" align="center";>
                
                
                
                
				<c:choose>
					<c:when test="${requestScope.selectMemberList ne null }">
						<c:if test="${ pageInfo.currentPage > 1 }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/selectMember?currentPage=${pageInfo.currentPage - 1}'"><</button>
						</c:if>
						<c:forEach begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }" var="i">
							<c:choose>
								<c:when test="${pageInfo.currentPage ne i }">
									<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/selectMember?currentPage=${ i }'">${ i }</button>
								</c:when>
								<c:otherwise>
									<button disabled class="btn btn-sm btn-outline-secondary">${ i }</button>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${ pageInfo.currentPage ne pageInfo.maxPage }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/selectMember?currentPage=${pageInfo.currentPage + 1}'">></button>
						</c:if>				
					</c:when>
					
					
					
					<c:otherwise>
						<c:if test="${ pageInfo.currentPage > 1 }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/oldestList.do?currentPage=${pageInfo.currentPage - 1}'"><</button>
						</c:if>
						<c:forEach begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }" var="i">
							<c:choose>
								<c:when test="${pageInfo.currentPage ne i }">
									<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/oldestList.do?currentPage=${ i }'">${ i }</button>
								</c:when>
								<c:otherwise>
									<button disabled class="btn btn-sm btn-outline-secondary">${ i }</button>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${ pageInfo.currentPage ne pageInfo.maxPage }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/oldestList.do?currentPage=${pageInfo.currentPage + 1}'">></button>
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
  			
  			url : 'searchMemberId.do',
  			type : 'post',
  			data : { keyword : $('#keyword').val()},
  			success : function(result){
  				console.log(result);
  				//$('.memNo').text(result);
  				if(result == null){
  					alert('회원이 존재하지 않습니다.');
  					location.href = '${path}/selectMember?currentPage=1';
  					
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
        						if(result.profilePath == null) {
        							$('#profilePath').attr("src", "./resources/mypage/user.png");
        						} else{
        							
        							$('#profilePath').attr("src", result.profilePath);
        						}
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
			             location.href = '${path}/selectMember?currentPage=1';
			             
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
                        <td colspan="5" rowspan="5" width="120" height="120" ><img id="profilePath" src="" alt="" width="70px"></td>
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