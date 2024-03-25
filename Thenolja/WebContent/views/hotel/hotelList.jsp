<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, thenolja.tb_hotel.model.vo.HotelCard, thenolja.common.model.vo.PageInfo" %>    
<%
	ArrayList<HotelCard> list = (ArrayList<HotelCard>)request.getAttribute("hotelList");
	PageInfo pi = (PageInfo)request.getAttribute("pageInfo");
	
	// 페이징바 만들 때 필요한 변수 미리 세팅
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  
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
		box-shadow: 3px 3px 2px gray;
		border-radius: 10px;
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
	}
	.card-info {
		float:right;
	}
	.card-info >h4 {
		text-align: center;
	}
	.card-info > p{
		margin: 0px;
		padding-left: 30px;
		margin-bottom: 10px;
	}
	.paging-area {
		float:
	}
</style>
</head>
<body>


	<%@ include file="../common/menubar.jsp"%>
	<div id="wrap">
	
		<%@ include file="./common/searchForm.jsp" %>
		
		<div id="content-2-lists">
			<%if(list.isEmpty()){ %>
				<div class="cards">
					<h3>조회된 호텔이 없습니다.</h3>
				</div>	
				<%} else { %>
					<%for(HotelCard hc : list){ %>
					<div class="cards" id="<%= hc.getHotelNo() %>" >
						<div class="card-imgDiv"><img class="card-img" src="<%= hc.getHotelPath() %>"></div>
	  					<div class="card-info">
							<h4><%= hc.getHotelLocation() %></h4>
							<p>이름 : <%= hc.getHotelName() %></p>
							<p>종류 : <%= hc.getHotelCategory() %><p>
							<p><span>★</span><span>4.8</span></p>
							<p>가격 : <%= hc.getRoomPrice() %></p>
	  					</div>
	  				</div>
					<%} %>
  				<%} %>
		
		</div>
		
		<script>
			$('.cards').click(function(e){
				location.href = '<%= contextPath %>/select.hotels?hotelNo='+ $(this).attr('id');
			});
		</script>
		
		<div class="paging-area" align="center">
	        	<%if(currentPage > 1){ %>
	        		<button class="btn btn-lg btn-outline-danger"
					onclick=" location.href='<%= contextPath %>/hotelList.hotels?currentPage=<%= currentPage - 1 %>' " >이전</button>
				<%} %>
				
	        	<%for(int i = startPage; i <= endPage; i++){ %>
	        		<% if(currentPage != i) { %>
	        			<button class="btn btn-sm btn-outline-danger"
	        			onclick=" location.href='<%= contextPath %>/hotelList.hotels?currentPage=<%= i %>'" ><%= i %></button>
	        		<%} else { %>
	        			<button
	        			class="btn btn btn-info"
	        			disabled ><%= i %></button>
	        		<%} %>
	        	<%} %>
	        	
	        	<%if(currentPage != maxPage){ %>
	        		<button class="btn btn btn-outline-danger"
	        		onclick=" location.href='<%= contextPath %>/hotelList.hotels?currentPage=<%= currentPage + 1 %>' " >다음</button>
	        	<%} %>
	     </div>
	</div>
</body>
</html>