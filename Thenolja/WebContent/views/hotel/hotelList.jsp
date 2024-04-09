<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, thenolja.tb_hotel.model.vo.HotelCard, thenolja.common.model.vo.PageInfo" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="views/hotel/css/hotelList.css" >
</head>

<body>
	<jsp:include page="./common/searchForm.jsp" />
	
	<div id="wrap">
		<div id="content-2-lists">
			<c:choose>
				<c:when test="${ empty hotelList }">
				<div>
					<h3>조회된 호텔이 없습니다.</h3>
				</div>	
				</c:when>
				<c:otherwise>
					<c:forEach var="hc" items="${ hotelList }">
					<div class="cards">
						<div class="card-imgDiv" id="${ hc.hotelNo }">
							<img class="card-img" src="${ hc.hotelPath }">
						</div>
	  					<div class="card-info">
							<h4>${hc.hotelLocation}</h4>
							<p>숙소명 : ${hc.hotelName}</p>
							<p>종류 : ${hc.hotelCategory}<p>
							<c:choose>
								<c:when test='${ loginUser ne null and loginUser.getMemStatus().equals("Y") }'>
									<p>가격 : ${ hc.roomPrice }</p>
								</c:when>
								<c:when test='${ loginStatus ne null && loginStatus.equals("A") }'>
									<div class="option-btns-room" align="center">
										<a class="btn btn-sm btn-primary" href="${ path }/insertForm.rooms?hotelNo=${ hc.hotelNo }">객실추가</a>
										<a class="btn btn-sm btn-info" href="${ path }/updateListForm.rooms?hotelNo=${hc.hotelNo}">객실정보수정</a>
										<a class="btn btn-sm btn-danger roomBtn" href="${ path }/deleteListForm.rooms?hotelNo=${hc.hotelNo  }" >객실삭제</a>
									</div>
									<div class="option-btns" align="center">
										<a class="btn btn btn-info" href="${ path }/updateForm.hotels?hotelNo=${ hc.hotelNo}">숙소정보수정</a>
										<a class="btn btn btn-danger hotelBtn" data-toggle="modal" data-target="#myModal" >숙소삭제</a>
									</div>
								</c:when>
							</c:choose>
	  					</div>
	  				</div>
					</c:forEach>
  				</c:otherwise>
  			</c:choose>	
		</div>
		
		<div class="paging-area" align="center">
			<c:choose>
			<c:when test='${ loginStatus ne null and loginStatus.equals("A") }'>
	        	<c:if test="${pageInfo.currentPage gt 1}">
	        		<button class="btn btn btn-outline-info"
					onclick="location.href='${ path }/hotelList.hotels?currentPage=${ pageInfo.currentPage - 1}&loginStatus=${ loginStatus }' " >이전</button>
				</c:if>
				
				<c:forEach var="i" begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }" step="1">	       
		        		<c:choose>
		        			<c:when test="${ pageInfo.currentPage ne i }">
		        				<button class="btn btn btn-outline-info"
		        				onclick=" location.href='${ path }/hotelList.hotels?currentPage=${ i }&loginStatus=${ loginStatus }'" >${ i }</button>
		        			</c:when>
		        			<c:otherwise>
		        			<button
			        			class="btn btn btn-outline-info"
			        			disabled >${ i }</button>
		        			</c:otherwise>
		        		</c:choose>
	        	</c:forEach>
	        		<c:if test="${ pageInfo.currentPage ne pageInfo.maxPage }">
	        			<button class="btn btn btn-outline-info"
	        			onclick=" location.href='${ path }/hotelList.hotels?currentPage=${ pageInfo.currentPage + 1 }&loginStatus=${ loginStatus }' " >다음</button>
	        		</c:if>
	        </c:when>	
	        
	        <c:otherwise>	
	        	<c:if test="${pageInfo.currentPage > 1}">
	        		<button class="btn btn btn-outline-info"
					onclick="location.href='${ path }/hotelList.hotels?currentPage=${ pageInfo.currentPage - 1}'" >이전</button>
				</c:if>
				
	        	<c:forEach var="i" begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }" step="1">	       
		        		<c:choose>
		        			<c:when test="${ pageInfo.currentPage ne i }">
		        				<button class="btn btn btn-outline-info"
		        				onclick=" location.href='${ path }/hotelList.hotels?currentPage=${ i }'" >${ i }</button>
		        			</c:when>
		        			<c:otherwise>
		        				<button
			        			class="btn btn btn-outline-info"
			        			disabled >${ i }</button>
		        			</c:otherwise>
		        		</c:choose>
	        	</c:forEach>
	        	
	        	<c:if test="${ pageInfo.currentPage ne pageInfo.maxPage }">
	        			<button class="btn btn btn-outline-info"
	        			onclick=" location.href='${ path }/hotelList.hotels?currentPage=${ pageInfo.currentPage + 1 }'" >다음</button>
	        		</c:if>
	        </c:otherwise>
	        </c:choose>	
	     </div>

		<!-- The Modal -->
		<div class="modal" id="myModal">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <!-- Modal Header -->
		      <div class="modal-header">
		        <h4 class="modal-title">숙소삭제</h4>
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		      </div>
		
		      <!-- Modal body -->
		      <div class="modal-body" align="center">
		        	정말로 삭제하시겠습니까?
		      </div>
		
		      <!-- Modal footer -->
		      <div class="modal-footer .hr-footer">
		      	<button type="button" class="btn btn-danger deleteHotelBtn" data-dismiss="modal">삭제</button>
		        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal" >닫기</button>
		      </div>
		
		    </div>
		  </div>
		</div>
		
		<script>
		let hotelNo;
		
		function deleteAjax(){
			$.ajax({
				url: 'deleteHotel.jqAjax',
				data: {
					hotelNo : hotelNo,
					currentPage: 1,
				},
				type: 'get',
				success : function(result){
					// 호텔 삭제후 ajax
					// 기존  html요소 지우고  결과값으로 다시 요소 만들기 
					$('#content-2-lists').empty();
					$('.paging-area').empty();
					
					if(result.hotelList === null ){
						$('#content-2-lists').append(
								'<div><h3>조회된 호텔이 없습니다.</h3></div>');
					} else {
						for(let i = 0; i < result.hotelList.length; i++){
							$('#content-2-lists').append(
									'<div class="cards">'
										+'<div class="card-imgDiv" id="'+result.hotelList[i].hotelNo+'">'
											+'<img class="card-img" src="'+result.hotelList[i].hotelPath+'">'
										+'</div>'
									+'<div class="card-info">'
										+'<h4>'+result.hotelList[i].hotelLocation+'</h4>'
										+'<p>숙소명 : '+result.hotelList[i].hotelName+'</p>'
										+'<p>종류 : '+result.hotelList[i].hotelCategory+'</p>'
											+'<div class="option-btns-room" align="center">'
												+' <a class="btn btn-sm btn-primary" href="${ path }/insertForm.rooms?hotelNo="'+result.hotelList[i].hotelNo+'>객실추가</a>'
												+' <a class="btn btn-sm btn-info" href="${ path }/updateListForm.rooms?hotelNo="'+result.hotelList[i].hotelNo+'>객실정보수정</a>'
												+' <a class="btn btn-sm btn-danger roomBtn" href="${ path }/deleteListForm.rooms?hotelNo="'+result.hotelList[i].hotelNo+'>객실삭제</a>'		
											+'</div>'
											+'<div class="option-btns" align="center">'
												+' <a class="btn btn btn-info" href="${ path }/updateForm.hotels?hotelNo="'+result.hotelList[i].hotelNo+'>숙소정보수정</a>'
												+' <a class="btn btn btn-danger hotelBtn" data-toggle="modal" data-target="#myModal">숙소삭제</a>'
											+'</div>'
									+'</div>'
								+'</div>');
						}
				
						if(result.pi.currentPage > 1){
							$('.paging-area').append(' <button class="btn btn btn-outline-info" onclick="move('+(result.pi.currentPage-1)+');">이전</button>');	
						}
						for(let i = result.pi.startPage; i <= result.pi.endPage; i++){
		        			if(result.pi.currentPage != i) {
		        				$('.paging-area').append(' <button class="btn btn btn-outline-info" onclick="move('+i+')">'+i+'</button>');
		        			} else {
		        				$('.paging-area').append(' <button class="btn btn btn-outline-info" disabled>'+i+'</button>');
		        			}
		        		}
						if(result.pi.currentPage != result.pi.maxPage){
							$('.paging-area').append(' <button class="btn btn btn-outline-info" onclick="move(' + (result.pi.currentPage+1) +');">다음</button>');
		        		} 
		
					}
				},
				error: function(error){
					alert(error);
				},
			
				});
		}
			function move(currentPage){
				location.href="${ path }/hotelList.hotels?currentPage="+currentPage+"${loginUser.memStatus}";
			}
			
			$(document).on('click', '.hotelBtn', function(e){
				hotelNo = $(this).parent().parent().prev().attr('id');
			});
			
			$('.deleteHotelBtn').click(function(e){
				deleteAjax();
			})
			
		</script>
		
		<script>
		$(document).on('click', '.card-imgDiv', function(e){
			location.href = '${ path }/select.hotels?hotelNo='+ $(this).attr('id');
		});
			
			/*
			$('.card-imgDiv').click(function(e){
				location.href = '${ path }/select.hotels?hotelNo='+ $(this).attr('id');
			});
			*/
		</script>
	</div>
</body>
</html>