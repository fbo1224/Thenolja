<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="java.text.SimpleDateFormat, java.util.Date"%>    
<%@ page import="java.util.ArrayList, thenolja.admin.reservation.model.vo.AdminReservation, thenolja.common.model.vo.PageInfo" %>    
<% SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy.MM.dd"); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>예약 회원 조회</title>

 	<link rel="stylesheet" href="resources/css/admin_select.css">

</head>
<body>
    
    <div id="wrap">
        <div id="header">
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
                        <h2>회원 예약 목록</h2>
                    </div>
        
 					<div id="mem_sort">
			          	 <button class="sort-btn" id="oldest" onclick="location.href='${path}/oldReserList.do?currentPage=1'">오래된순</button>
			   			 <button class="sort-btn" id="newest" onclick="location.href='${path}/reserMember?currentPage=1'">최신순</button>
					</div>
        
                </div>
                

                <div id="mem_list">
                	<c:set var="current" value="<%= new java.util.Date() %>" />
                	<fmt:formatDate value="${ current }" type="both" pattern="yyyy.MM.dd" />
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
                        
                        <c:choose>
                        	<c:when test="${ requestScope.selectReserMember ne null && empty requestScope.selectReserMember}">
	                        	<tr>
	                        		<td colspan="4">예약 회원이 존재하지 않습니다.</td>
	                        	</tr>                        	
                        	</c:when>
                        	<c:when test="${requestScope.selectReserMember ne null}">
		                    	<c:forEach var="adminReservation" items="${requestScope.selectReserMember}">
		                        	<tr>
		                        		<td>${adminReservation.reserNo}</td>
		                        		<td>${adminReservation.memId}</td>
		                        		<td>${adminReservation.reserName}</td>
		                        		<td>${adminReservation.memPhone}</td>
			                        	<td><button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#myModal" onclick="detailReserMem(${adminReservation.reserNo})">조회</button></td>
			                        	
										
										<c:choose>
											<c:when test="${adminReservation.reserStatus}">
												<td><button id="refundBtn"  disabled class="btn btn-sm btn-outline-secondary" onclick="refundReserMem(${adminReservation.reserNo})">환불처리</button></td>
											</c:when>
											<c:otherwise>
												<td><button id="refundBtn" class="btn btn-sm btn-outline-secondary" onclick="refundReserMem(${adminReservation.reserNo})">환불처리</button></td>
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
					<c:when test="${requestScope.selectReserMember ne null }">
						<c:if test="${ pageInfo.currentPage > 1 }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/reserMember?currentPage=${pageInfo.currentPage - 1}'"><</button>
						</c:if>
						<c:forEach begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }" var="i">
							<c:choose>
								<c:when test="${pageInfo.currentPage ne i }">
									<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/reserMember?currentPage=${ i }'">${ i }</button>
								</c:when>
								<c:otherwise>
									<button disabled class="btn btn-sm btn-outline-secondary">${ i }</button>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${ pageInfo.currentPage ne pageInfo.maxPage }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/reserMember?currentPage=${pageInfo.currentPage + 1}'">></button>
						</c:if>				
					</c:when>
					
					<c:otherwise>
						<c:if test="${ pageInfo.currentPage > 1 }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/oldReserList.do?currentPage=${pageInfo.currentPage - 1}'"><</button>
						</c:if>
						<c:forEach begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }" var="i">
							<c:choose>
								<c:when test="${pageInfo.currentPage ne i }">
									<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/oldReserList.do?currentPage=${ i }'">${ i }</button>
								</c:when>
								<c:otherwise>
									<button disabled class="btn btn-sm btn-outline-secondary">${ i }</button>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${ pageInfo.currentPage ne pageInfo.maxPage }">
							<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${path}/oldReserList.do?currentPage=${pageInfo.currentPage + 1}'">></button>
						</c:if>							
					</c:otherwise>
	
                  </c:choose>

                	
                </div>
        
        

            </div>
        </div>
        <div id="footer">
       		<%@ include file="../../common/footer.jsp" %>          
        </div>

    </div>
    
    
    <script>
    
    	function searchMemId(){
			
    		$.ajax({
    			
    			url : 'reserSearchMemId.do',
    			type : 'post',
    			data : { keyword : $('#keyword').val()},
    			success : function(result){
    				if(result.length === 0){
    					alert('예약 회원이 존재하지 않습니다.');
    					location.href = '${path}/reserMember?currentPage=1';
    				} else{
    					
    					
    					const date = new Date();
    					
    					const year = date.getFullYear();
    					
    					const month = date.getMonth() + 1;
    					
    					const day = date.getDate();
    					
    					const currentDate = year + '.' + (month < 10 ? '0' : "") + month + '.' + (day < 10 ? '0' : "") + day;
    		    		
    					console.log(currentDate);
    					
    					
    					let resultStr = '';
    					
    					for(let i = 0; i < result.length; i++){
    						const checkInTime = result[i].checkInTime;
    						console.log(checkInTime);
          					resultStr += '<tr>'
          							   + '<td>' + result[i].reserNo + '</td>'
          							   + '<td>' + result[i].memId + '</td>'
          							   + '<td>' + result[i].reserName + '</td>'
          							   + '<td>' + result[i].memPhone + '</td>'
    	                        	   + '<td>' + '<button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#myModal" onclick="detailReserMem('+ result[i].reserNo+')">' + '조회' + '</button>' +'</td>';
    									
    		                            if(currentDate >= checkInTime) { 
    		                            	resultStr += '<td>' + '<button id="refundBtn"  disabled class="btn btn-sm btn-outline-secondary" onclick="refundReserMem('+ result[i].reserNo+')">' + '환불처리' + '</button>' + '</td>';
    		                      	    } else {
    		                      	    	resultStr += '<td>' +
    		                        		'<button id="refundBtn" class="btn btn-sm btn-outline-secondary" onclick="refundReserMem('+ result[i].reserNo+')">' + '환불처리' + '</button>' + '</td>';	
    		                      	    }
    		                            resultStr += '</tr>'
    					};
      			
      				$('#mem_list tbody').html(resultStr);
	      						   console.log(resultStr);
    				}
    				
    			}
    			
    		});
    		
    	}
    
    
    
    
    
    
    	function detailReserMem(e){
    		console.log(e);
    		
    		$.ajax({
    			url : 'detailReserMem.do',
    			data : {reserNo : e},
    			type : 'get',
    			success : function(result){
    				console.log(result);
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
    
    	function refundReserMem(e){
    		
    		$.ajax({
    			url : 'refundReser.do',
    			data : {reserNo : e},
    			type : 'get',
    			success : function(result){
    				alert(result.message);
    				location.href = '${path}/reserMember?currentPage=1';
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
            <p class="modal-title"> 예약 상세 정보</p>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
        	
        	<input type="hidden" id="reserNo22" name="reser_No" value=""/>
        
            <table style="font-size: 13px;">
                <tr>
                    <td colspan="5" rowspan="5" width="120" height="120" ><img id="hotelPath" src="" alt="" width="120px" height="100"></td>
                    <td width="200"><span id="hotelName"></span></td>
                    <td>이동방식 : <span id="bicycle"></span></td>
                </tr>
                <tr>
                    <td>인원수 : <span id="people"></span>명</td>
                    <td>예약일 : <span id="reserDate"></span></td>
                </tr>
                <tr>
                    <td>체크인 : <span id="checkIn"></span></td>
                    <td>체크아웃 : <span id="checkOut"></span></td>
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