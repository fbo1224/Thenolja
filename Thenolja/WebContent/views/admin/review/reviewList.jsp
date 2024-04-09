<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html lang="en">
<head>
    <title>리뷰 목록</title>
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
		
		padding-right : 15%;
		
		}


</style>  
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
		
            <jsp:include page="../../common/menubar.jsp"></jsp:include>

        </div>
               
        <div id="content">
            <div id="content_1">

                <div id="search_member">
                    <div id="search_id">
                        <input type="text" placeholder="회원 ID입력" id="keyword" maxlength="12">
                    </div>
        
                    <div id="search_btn">
                        <button type="button" class="btn btn-outline-info" onclick="searchReviewMember()">검색</button>
                    </div>
                </div>

            </div>
            <div id="content_2">

                <div id="mem_list_header">

                    <div id="mem_title">
                        <h2>리뷰목록</h2>
                    </div>
        
 					<div id="mem_sort">
			          	 <button class="sort-btn" id="oldest" onclick="location.href='${path}/oldestReviewList.do?currentPage=1'">오래된순</button>
			   			 <button class="sort-btn" id="newest" onclick="location.href='${path}/adminReviewList?currentPage=1'">최신순</button>
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
                        
 					<c:choose>
                       	<c:when test="${ requestScope.selectReviewMemberList ne null && empty requestScope.selectReviewMemberList }">
                         	   <tr>
                        			<th colspan="4">리뷰가 존재하지 않습니다.</th>                    	   
                       	  	   </tr>
                       	</c:when>
                       	<c:when test="${ requestScope.selectReviewMemberList ne null }">
                       		<c:forEach var="review" items="${ requestScope.selectReviewMemberList }">
                       			<tr>
	                       	   		<td>${review.hotelName}</td>
	                       	   		<td>${review.memId}</td>
	                       	   		<td>${review.nickName}</td>
	                       	   		<td>${review.createDate}</td>
                        			<td><button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#myModal" onclick="detailReview(${review.reserNo})">조회</button></td>
                        			<td><button class="btn btn-sm btn-outline-secondary" onclick="deleteReview(${review.reserNo})">삭제</button></td>
		                            
	                       	  </tr>
                       		</c:forEach>
                       	</c:when>
                       </c:choose> 

 					<c:choose>
                       	<c:when test="${ requestScope.oldReviewMemberList ne null && empty requestScope.oldReviewMemberList }">
                         	   <tr>
                        			<th colspan="4">리뷰가 존재하지 않습니다.</th>                    	   
                       	  	   </tr>
                       	</c:when>
                       	<c:when test="${ requestScope.oldReviewMemberList ne null }">
                       		<c:forEach var="review" items="${ requestScope.oldReviewMemberList }">
                       			<tr>
	                       	   		<td>${review.hotelName}</td>
	                       	   		<td>${review.memId}</td>
	                       	   		<td>${review.nickName}</td>
	                       	   		<td>${review.createDate}</td>
                        			<td><button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#myModal" onclick="detailReview(${review.reserNo})">조회</button></td>
                        			<td><button class="btn btn-sm btn-outline-secondary" onclick="deleteReview(${review.reserNo})">삭제</button></td>
		                            
	                       	  </tr>
                       		</c:forEach>
                       	</c:when>
                       </c:choose>	

                   
                        </tbody>
                      </table>

                </div>
        
                <div class="paging-area" align="center";>

				<c:choose>
					<c:when test="${requestScope.selectReviewMemberList ne null }">
						<c:if test="${ pageInfo.currentPage > 1 }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/adminReviewList?currentPage=${pageInfo.currentPage - 1}'"><</button>
						</c:if>
						<c:forEach begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }" var="i">
							<c:choose>
								<c:when test="${pageInfo.currentPage ne i }">
									<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/adminReviewList?currentPage=${ i }'">${ i }</button>
								</c:when>
								<c:otherwise>
									<button disabled class="btn btn-sm btn-outline-secondary">${ i }</button>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${ pageInfo.currentPage ne pageInfo.maxPage }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/adminReviewList?currentPage=${pageInfo.currentPage + 1}'">></button>
						</c:if>				
					</c:when>
					
					
					
					<c:otherwise>
						<c:if test="${ pageInfo.currentPage > 1 }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/oldestReviewList.do?currentPage=${pageInfo.currentPage - 1}'"><</button>
						</c:if>
						<c:forEach begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }" var="i">
							<c:choose>
								<c:when test="${pageInfo.currentPage ne i }">
									<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/oldestReviewList.do?currentPage=${ i }'">${ i }</button>
								</c:when>
								<c:otherwise>
									<button disabled class="btn btn-sm btn-outline-secondary">${ i }</button>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${ pageInfo.currentPage ne pageInfo.maxPage }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/oldestReviewList.do?currentPage=${pageInfo.currentPage + 1}'">></button>
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
    	
    	function searchReviewMember(){
    		
    		$.ajax({
    			
    			url : 'searchReview.do',
    			type : 'post',
    			data : {keyword : $('#keyword').val()},
    			success : function(result){
    				if(result.length === 0){
    					alert('회원이 존재하지 않습니다.');
    					location.href = '${path}/adminReviewList?currentPage=1';
    				} else{
    					let resultStr = '';
						for(let i = 0; i < result.length; i++){
							resultStr += '<tr>'
		  							   + '<td>' + result[i].hotelName + '</td>'
		  							   + '<td>' + result[i].memId + '</td>'
		  							   + '<td>' + result[i].nickName + '</td>'
		  							   + '<td>' + result[i].createDate + '</td>'
		  							   + '<td>' + '<button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#myModal" onclick="detailReview('+ result[i].reserNo+')">' + '조회' + '</button>' +'</td>'
	                  			   	   + '<td>' + '<button class="btn btn-sm btn-outline-secondary" onclick="deleteReview('+ result[i].reserNo+')">' +'삭제 ' + '</button>' + '</td>'
		  							   + '</tr>'
						};
  						
	  			
	  				$('#mem_list tbody').html(resultStr);
    					
    				}
    			}
    			
    			
    		});
    		
    		
    	}
 
    	
    
    
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
    				$('#imgPath').attr("src", result.imgPath);
    				$('#reserNo22').val(e);
    				selectCommentList();
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
    				location.href = '${path}/adminReviewList?currentPage=1'
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
		
		
            <table style="font-size: 14px;">
                <tr>
                    <td colspan="5" rowspan="5" width="120" height="120" id="hotelPath"><img id="imgPath" src="" alt="" width="120px" height="110px"></td>
                    <td width="160"><span id="hotelName"></span></td>
                    <td width="200"><span id="roomName"></span></td>
                    <td width="140"><span id="reviewScore"></span></td>
                </tr>
                <tr id="contentMessage">
                    <td colspan="3" width="300"><span id="reviewContent"></span></td>
                </tr>

              </table>

            <div class="container">
                  <div class="form-group">
                    <div><p style="font-size: 14px;">답글 작성</p></div>
                    <textarea class="form-control" rows="5" id="comment" name="text" cols="49"></textarea>
                  </div>
                  <button type="button" class="btn btn-sm btn-outline-secondary" style="float: right;" onclick="insertComment()" id="insertBtn">등록하기</button>
              </div>

        </div>

    
        
      </div>
    </div>
  </div>



	<script>
		
		function selectCommentList(){
			
			$.ajax({
				url : 'commentList.do',
				data : {reserNo : $('#reserNo22').val()},
				success : function(result){
					if(result == null){
						$('#comment').val('');
						$('#comment').attr('readonly', false);	
						$('#insertBtn').attr("disabled", false);
						
					}else {
						$('#comment').val(result['commentContent']);
						$('#comment').attr('readonly', true);	
						$('#insertBtn').attr("disabled", true);
						
						
					}
				},
				error : function(e){
					console.log(e);
				}
				
			});
		}
	

	
	
		function insertComment(){
			$.ajax({
				url : 'commentInsert.do',
				type : 'post',
				data : {
					content : $('#comment').val(),
					reserNo : $('#reserNo22').val(),
					memNo : ${loginUser.memNo}
				},
				success : function(result){
					console.log(result);	
					
					if(result == 'success'){
						selectCommentList();
						
					}
				}
			});
			
		}
	
	
	</script>




</body>
</html>