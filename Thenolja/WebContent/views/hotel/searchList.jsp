<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList, thenolja.tb_hotel.model.vo.*, thenolja.common.model.vo.PageInfo " %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <!--
    	sList
    	pageInfo
    	searchData
		
-->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>searchList</title>
<style>
  
<style>
	div{
		box-sizing: border-box;
	}
	#wrap {
		width: 1200px;
		height: auto;
		margin: auto;
	}
	#content-2-lists {
		width: 100%;
		display: flex;
		align-items: center;
		justify-content: space-evenly;
		flex-wrap: wrap;
		padding: 10px;
	}
	
	.cards{
		width:	45%;
		height: 250px;
		margin: 10px;
		
	}
	.card-imgDiv, .card-info{
		display: inline-block;
		width: 50%;
		height: 100%;
	}
	.card-img{
		width: 100%;
		height: 100%;
		border-radius: 10px;
		cursor: pointer;
	}
	.card-info {
		float:right;
	}
	.card-info > h4 {
		text-align: center;
	}
	.card-info > p{
		margin: 0px;
		padding-left: 30px;
		margin-bottom: 10px;
	}
	.option-btns-room{
		margin: 20px 0px;
	}
	.option-btns{
		margin: 3px 0px;
	}
	.cards:hover{
		scale: 103%;
		box-shadow: 3px 3px 2px gray;
		border-radius: 10px;
	}
	.paging-area{
		padding: 10px;
		margin : 5px;
		border-top: 1px solid gray;
		border-bottom: 1px solid gray;
	}
</style>
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
			<c:if test="${ pageInfo.getCurrentPage() > 1}" >
        		<button class="btn btn btn-outline-info"
				onclick="pageMove(${ pageInfo.getCurrentPage()-1 })" >이전</button>
			</c:if>
			
			<c:forEach var="i" begin="${ pageInfo.getStartPage() }" end="${pageInfo.getEndPage() }" step="1">
				<c:choose>
        			<c:when test="${ pageInfo.getCurrentPage() ne i}">
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
        	
        	<c:if test="${ pageInfo.getCurrentPage() ne pageInfo.getMaxPage() }">
        			<button class="btn btn btn-outline-info"
        			onclick="pageMove(${pageInfo.getCurrentPage() + 1});" >다음</button>
        	</c:if>
	     </div>
</div>
	<script>
			$('.card-imgDiv').click(function(e){
				location.href ="${path}/select.hotels?hotelNo="+ $(this).attr('id')+"&daterange=${ searchData.getDaterange() }&location=${ searchData.getLocation() }&people=${ searchData.getMaxPeople() }";
			});
			
			function pageMove(currentPage){
				 location.href="${path}/searchList.hotels?currentPage="+currentPage+"&daterange=${ searchData.getDaterange()}&location=${ searchData.getLocation() }&people=${ searchData.getMaxPeople()}";
					 
			}
			
	</script>
</body>
</html>