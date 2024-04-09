<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList, thenolja.tb_hotel.model.vo.*, thenolja.common.model.vo.PageInfo " %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>searchList</title>
<link rel="stylesheet" href="views/hotel/css/searchList.css">
</head>
<body>
	<div id="wrap">
		<jsp:include page="./common/searchForm.jsp" />
		<div id="content-2-lists">
			<c:choose>
				<c:when test="${ empty sList }">
					<div>
						<h3>조회된 호텔이 없습니다.</h3>
					</div>	
				</c:when>
				
				<c:otherwise>
					<c:forEach var="hc" items="${ sList }">
						<div class="cards">
							<div class="card-imgDiv" id="${ hc.getHotelNo() }">
								<img class="card-img" src="${ hc.getHotelPath() }">
							</div>
		  					<div class="card-info">
								<h4>${ hc.getHotelLocation()  }</h4>
								<p>숙소명 : ${ hc.getHotelName() }</p>
								<p>종류 : ${ hc.getHotelCategory() }</p>
								<p>가격 : ${ hc.getRoomPrice() }</p>
		  					</div>
		  				</div>
	  				</c:forEach>
				</c:otherwise>
 			</c:choose>
		</div>
		<div class="paging-area" align="center">
			<c:if test="${ pageInfo.currentPage > 1}" >
        		<button class="btn btn btn-outline-info"
				onclick="pageMove(${ pageInfo.currentPage-1 })" >이전</button>
			</c:if>
			
			<c:forEach var="i" begin="${ pageInfo.startPage }" end="${pageInfo.endPage }" step="1">
				<c:choose>
        			<c:when test="${ pageInfo.currentPage ne i}">
	        			<button class="btn btn btn-outline-info"
	        			onclick="pageMove(${ i })">${ i }</button>
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
        			onclick="pageMove(${pageInfo.currentPage + 1});" >다음</button>
        	</c:if>
	     </div>
	     
</div>

	<script>
			$('.card-imgDiv').click(function(e){
				location.href ="${path}/select.hotels?hotelNo="+ $(this).attr('id')+"&daterange=${ searchData.daterange }&location=${ searchData.location }&people=${ searchData.maxPeople }";
			});
			
			function pageMove(currentPage){
				 location.href="${path}/searchList.hotels?currentPage="+currentPage+"&daterange=${ searchData.daterange }&location=${ searchData.location }&people=${ searchData.maxPeople}";	 				
			}
			
	</script>
</body>
</html>