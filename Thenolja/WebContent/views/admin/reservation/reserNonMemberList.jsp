<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="java.text.SimpleDateFormat, java.util.Date"%>    
<% SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy.MM.dd"); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>비회원 예약 목록</title>
   	
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
                        <button type="button" class="btn btn-outline-info" onclick="searchNonMem()">검색</button>
                    </div>
                </div>

            </div>
            <div id="content_2">

                <div id="mem_list_header">

                    <div id="mem_title">
                        <h2>비회원 예약 목록</h2>
                    </div>
        
 					<div id="mem_sort">
			          	 <button class="sort-btn" id="oldest" onclick="location.href='${path}/oldestListNonMem.do?currentPage=1'">오래된순</button>
			   			 <button class="sort-btn" id="newest" onclick="location.href='${path}/reserNonMem?currentPage=1'">최신순</button>
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
                        <tr>
                        
                        
                        
                        <c:choose>
                        	<c:when test="${ requestScope.selectReserNonMember ne null && empty requestScope.selectReserNonMember}">
	                        	<tr>
                        			<th colspan="3">예약 비회원이 존재하지 않습니다.</th>
	                        	</tr>                        	
                        	</c:when>
                        	<c:when test="${requestScope.selectReserNonMember ne null}">
		                    	<c:forEach var="adminReserNon" items="${requestScope.selectReserNonMember}">
		                        	<tr>
		                        		<td>${adminReserNon.reserNo}</td>
		                        		<td>${adminReserNon.reserName}</td>
		                        		<td>${adminReserNon.memPhone}</td>                        		
		                        		<td><button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#myModal" onclick="detailReserNonMem(${adminReserNon.reserNo})">조회</button></td>
			                        	
										
										<c:choose>
											<c:when test="${adminReservation.reserStatus}">
												<td><button  class="btn btn-sm btn-outline-secondary" onclick="refundReserNonMem(${adminReserNon.reserNo})">환불처리</button></td>
											</c:when>
											<c:otherwise>
											    <td><button disabled class="btn btn-sm btn-outline-secondary" onclick="refundReserNonMem(${adminReserNon.reserNo})">환불처리</button></td>
											</c:otherwise>
										</c:choose>
			                            
		                          	</tr>      		                    	
		                    	</c:forEach>
                  		
                        	</c:when>
                        </c:choose>
                        
                       <c:choose>
                        	<c:when test="${ requestScope.oldReserNonMember ne null && empty requestScope.oldReserNonMember}">
	                        	<tr>
                        			<th colspan="3">예약 비회원이 존재하지 않습니다.</th>
	                        	</tr>                        	
                        	</c:when>
                        	<c:when test="${requestScope.oldReserNonMember ne null}">
		                    	<c:forEach var="adminReserNon" items="${requestScope.oldReserNonMember}">
		                        	<tr>
		                        		<td>${adminReserNon.reserNo}</td>
		                        		<td>${adminReserNon.reserName}</td>
		                        		<td>${adminReserNon.memPhone}</td>                        		
		                        		<td><button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#myModal" onclick="detailReserNonMem(${adminReserNon.reserNo})">조회</button></td>
			                        	
										
										<c:choose>
											<c:when test="${adminReservation.reserStatus}">
												<td><button  class="btn btn-sm btn-outline-secondary" onclick="refundReserNonMem(${adminReserNon.reserNo})">환불처리</button></td>
											</c:when>
											<c:otherwise>
											    <td><button disabled class="btn btn-sm btn-outline-secondary" onclick="refundReserNonMem(${adminReserNon.reserNo})">환불처리</button></td>
											</c:otherwise>
										</c:choose>
			                            
		                          	</tr>      		                    	
		                    	</c:forEach>
                  		
                        	</c:when>
                        </c:choose>
                        
                        
                        
                        
                        
                        
                                                
                        

                        

                        </tbody>
                      </table>

                </div>
        
                <div class="paging-area" align="center";>
                
                
                                
                
				<c:choose>
					<c:when test="${requestScope.selectReserNonMember ne null }">
						<c:if test="${ pageInfo.currentPage > 1 }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/reserNonMem?currentPage=${pageInfo.currentPage - 1}'"><</button>
						</c:if>
						<c:forEach begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }" var="i">
							<c:choose>
								<c:when test="${pageInfo.currentPage ne i }">
									<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/reserNonMem?currentPage=${ i }'">${ i }</button>
								</c:when>
								<c:otherwise>
									<button disabled class="btn btn-sm btn-outline-secondary">${ i }</button>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${ pageInfo.currentPage ne pageInfo.maxPage }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/reserNonMem?currentPage=${pageInfo.currentPage + 1}'">></button>
						</c:if>				
					</c:when>
					
					
					
					<c:otherwise>
						<c:if test="${ pageInfo.currentPage > 1 }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/oldestListNonMem.do?currentPage=${pageInfo.currentPage - 1}'"><</button>
						</c:if>
						<c:forEach begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }" var="i">
							<c:choose>
								<c:when test="${pageInfo.currentPage ne i }">
									<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/oldestListNonMem.do?currentPage=${ i }'">${ i }</button>
								</c:when>
								<c:otherwise>
									<button disabled class="btn btn-sm btn-outline-secondary">${ i }</button>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${ pageInfo.currentPage ne pageInfo.maxPage }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/oldestListNonMem.do?currentPage=${pageInfo.currentPage + 1}'">></button>
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
    
    	function searchNonMem(){
    		
    		$.ajax({
    			
    			url : 'reserSearchNonMem.do',
    			type : 'post',
    			data : {keyword : $('#keyword').val()},
    			success : function(result){
    				if(result.length === 0){
    					alert('예약 회원이 존재하지 않습니다.');
    					location.href = '${path}/reserNonMem?currentPage=1';
    				} else{
    					
    					
    					const date = new Date();
    					
    					const year = date.getFullYear();
    					
    					const month = date.getMonth() + 1;
    					
    					const day = date.getDate();
    					
    					const currentDate = year + '.' + (month < 10 ? '0' : "") + month + '.' + (day < 10 ? '0' : "") + day;
    		    		
    					console.log(currentDate);
    					
    					let resultStr = '';
    					
    					let checkInTime = '';
    					
    					for(let i = 0; i < result.length; i++){
    						const checkInTime = result[i].checkInTime;
    						console.log(checkInTime);
          					resultStr += '<tr>'
          							   + '<td>' + result[i].reserNo + '</td>'
          							   + '<td>' + result[i].reserName + '</td>'
          							   + '<td>' + result[i].memPhone + '</td>'
    	                        	   + '<td>' + '<button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#myModal" onclick="detailReserNonMem('+ result[i].reserNo+')">' + '조회' + '</button>' +'</td>';
    									
    		                            if(currentDate >= checkInTime) { 
    		                            	resultStr += '<td>' + '<button id="refundBtn"  disabled class="btn btn-sm btn-outline-secondary" onclick="refundReserNonMem('+ result[i].reserNo+')">' + '환불처리' + '</button>' + '</td>';
    		                      	    } else {
    		                      	    	resultStr += '<td>' +
    		                      	    	'<button id="refundBtn" class="btn btn-sm btn-outline-secondary" onclick="refundReserNonMem('+ result[i].reserNo+')">' + '환불처리' + '</button>' + '</td>';
    		                      	    }
    		                            resultStr += '</tr>'
    					};
      			
      				$('#mem_list tbody').html(resultStr);
	      						   console.log(resultStr);
    				}
    			}
    		});	
    		
    		
    	}
    	
    	
    	
    	
    	
    	function detailReserNonMem(e){
    		
    		$.ajax({
    			url : 'detailReserMem.do',
    			data : {reserNo : e},
    			type : 'get',
    			success : function(result){
    				$('#hotelName').text(result.hotelName);
    				$('#bicycle').text(result.bicycle);
    				$('#people').text(result.people);
    				$('#reserDate').text(result.reserDate);
    				$('#checkIn').text(result.checkInTime);
    				$('#checkOut').text(result.checkOutTime);
    				$('#payment').text(result.payment);
    				$('#paymentPrice').text(result.paymentPrice);
    				$('#hotelPath').attr("src", result.hotelPath);
    				
    			}
    		})
    	}
    
    </script>
    
    <script>
    	function refundReserNonMem(e){
    		
    		$.ajax({
    			url :  'refundReser.do',
    			data : {reserNo : e},
    			type : 'get',
    			success : function(result){
    				alert(result.message);
    				location.href = '${path}/reserNonMem?currentPage=1'
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
            <p class="modal-title"> 예약 상세 정보</p>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
            <table style="font-size: 13px;">
                <tr>
                    <td colspan="5" rowspan="5" width="120" height="120" ><img id="hotelPath" src="" alt=""  width="120px" height="100"></td>
                    <td width="200"><span id="hotelName"></span></td>
                    <td>이동방식 : <span id="bicycle"></span></td>
                </tr>
                <tr>
                    <td>인원수 : <span id="people"></span>명</td>
                    <td>예약일 : <span id="reserDate"></span></td>
                </tr>
                <tr>
                    <td>체크인 : <span id="checkIn"></span></td>
                    <td>체크아웃 :<span id="checkOut"></span></td>
                </tr>
    
                <tr>
                    <td>결제방식 : <span id="payment"></span></td>
                    <td>금액 : <span id="paymentPrice"></span>원</td>
                </tr>

              </table>

        </div>

    
        
      </div>
    </div>
  </div>
  











</body>
</html>