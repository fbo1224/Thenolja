<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
   

    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <title>환불 비회원 목록</title>
	
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
		
		padding-right : 25%;
		
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
                        <input type="text" placeholder="예약자명 입력" id="keyword" maxlength="4">
                    </div>
        
                    <div id="search_btn">
                        <button type="button" class="btn btn-outline-info" onclick="searchRefundNonMem()">검색</button>
                    </div>
                </div>

            </div>
            <div id="content_2">

                <div id="mem_list_header">

                    <div id="mem_title">
                        <h2>비회원 환불 목록</h2>
                    </div>
        
 					<div id="mem_sort">
			          	 <button class="sort-btn" id="oldest" onclick="location.href='${path}/oldestNonRefund.do?currentPage=1'">오래된순</button>
			   			 <button class="sort-btn" id="newest"  onclick="location.href='${path}/refundNonMem?currentPage=1'">최신순</button>			          	 
					</div>
        
                </div>
        
                <div id="mem_list">
                    <table class="table table-hover">
                        <thead>
                          <tr>
                            <th>예약번호</th>
                            <th>예약자명</th>
                            <th>전화번호</th>
                            <th colspan="2"></th>
                          </tr>
                        </thead>
                        <tbody>
                        
                        <c:choose>
                       	<c:when test="${ requestScope.selectRefundNonMemberList ne null && empty requestScope.selectRefundNonMemberList }">
                         	   <tr>
                        			<th colspan="3">환불 비회원이 존재하지 않습니다.</th>                	   
                       	  	   </tr>
                       	</c:when>
                       	<c:when test="${ requestScope.selectRefundNonMemberList ne null }">
                       		<c:forEach var="refunNonMem" items="${ requestScope.selectRefundNonMemberList }">
                       			<tr>
	                       	   		<td>${refunNonMem.reserNo}</td>
	                       	   		<td>${refunNonMem.reserName}</td>
	                       	   		<td>${refunNonMem.memPhone}</td>
	                       	   		
									<td><button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#myModal" onclick="selectRefundMember(${refunNonMem.reserNo})">조회</button></td>
		                            
	                       	  </tr>
                       		</c:forEach>
                       	</c:when>
                       </c:choose>
                        
                        <c:choose>
                       	<c:when test="${ requestScope.oldRefundNonMemberList ne null && empty requestScope.oldRefundNonMemberList }">
                         	   <tr>
                        			<th colspan="3">환불 비회원이 존재하지 않습니다.</th>                	   
                       	  	   </tr>
                       	</c:when>
                       	<c:when test="${ requestScope.oldRefundNonMemberList ne null }">
                       		<c:forEach var="refunNonMem" items="${ requestScope.oldRefundNonMemberList }">
                       			<tr>
	                       	   		<td>${refunNonMem.reserNo}</td>
	                       	   		<td>${refunNonMem.reserName}</td>
	                       	   		<td>${refunNonMem.memPhone}</td>
	                       	   		
									<td><button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#myModal" onclick="selectRefundMember(${refunNonMem.reserNo})">조회</button></td>
		                            
	                       	  </tr>
                       		</c:forEach>
                       	</c:when>
                       </c:choose>       
       
       

                        </tbody>
                      </table>

                </div>
        
                <div class="paging-area" align="center";>
                
                
				<c:choose>
					<c:when test="${requestScope.selectRefundNonMemberList ne null }">
						<c:if test="${ pageInfo.currentPage > 1 }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/refundNonMem?currentPage=${pageInfo.currentPage - 1}'"><</button>
						</c:if>
						<c:forEach begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }" var="i">
							<c:choose>
								<c:when test="${pageInfo.currentPage ne i }">
									<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/refundNonMem?currentPage=${ i }'">${ i }</button>
								</c:when>
								<c:otherwise>
									<button disabled class="btn btn-sm btn-outline-secondary">${ i }</button>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${ pageInfo.currentPage ne pageInfo.maxPage }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/refundNonMem?currentPage=${pageInfo.currentPage + 1}'">></button>
						</c:if>				
					</c:when>
					
					
					
					<c:otherwise>
						<c:if test="${ pageInfo.currentPage > 1 }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/oldestNonRefund.do?currentPage=${pageInfo.currentPage - 1}'"><</button>
						</c:if>
						<c:forEach begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }" var="i">
							<c:choose>
								<c:when test="${pageInfo.currentPage ne i }">
									<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/oldestNonRefund.do?currentPage=${ i }'">${ i }</button>
								</c:when>
								<c:otherwise>
									<button disabled class="btn btn-sm btn-outline-secondary">${ i }</button>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${ pageInfo.currentPage ne pageInfo.maxPage }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/oldestNonRefund.do?currentPage=${pageInfo.currentPage + 1}'">></button>
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
    	
    	function searchRefundNonMem(){
    		
    		$.ajax({
    			
    			url : 'searchRefundNonMem.do',
    			type : 'post',
    			data : {keyword : $('#keyword').val()},
    			success : function(result){
    				if(result.length === 0){
    					alert('환불 비회원이 존재하지 않습니다.');
    					location.href = '${path}/refundNonMem?currentPage=1';
    				} else {
    					
    					let resultStr = '';
    					
    					for(let i = 0 ; i <result.length; i++){
    						resultStr += '<tr>'
  							  + '<td>' + result[i].reserNo + '</td>'
  							  + '<td>' + result[i].reserName + '</td>'
  							  + '<td>' + result[i].memPhone + '</td>'
  							  + '<td>' + '<button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#myModal" onclick="selectRefundMember('+result[i].reserNo+')">' + '조회' + '</button>' +'</td>'
  							  + '</tr>'
  							  				
    					}
    		
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
    		})
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
                    <td colspan="5" rowspan="5" width="120" height="120" ><img id="hotelPath" src="" alt=""  width="120px" height="100"></td>
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