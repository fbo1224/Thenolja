<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList, thenolja.tb_hotel.model.vo.*, thenolja.common.model.vo.PageInfo " %>
    <%
	ArrayList<HotelCard> list = (ArrayList<HotelCard>)request.getAttribute("sList");
	PageInfo pi = (PageInfo)request.getAttribute("pageInfo");
	
	SearchData searchData= null;
	if(request.getAttribute("searchData") != null){
		searchData = (SearchData)request.getAttribute("searchData");
	}
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();

%>    
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
		<%@ include file="./common/searchForm.jsp" %>
		<div id="content-2-lists">
			<%if(list.isEmpty()){ %>
				<div>
					<h3>조회된 호텔이 없습니다.</h3>
				</div>	
				<%} else { %>
					<%for(HotelCard hc : list){ %>
					<div class="cards">
						<div class="card-imgDiv" id="<%= hc.getHotelNo() %>">
							<img class="card-img" src="<%= hc.getHotelPath() %>">
						</div>
	  					<div class="card-info">
							<h4><%= hc.getHotelLocation() %></h4>
							<p>숙소명 : <%= hc.getHotelName() %></p>
							<p>종류 : <%= hc.getHotelCategory() %><p>
							<p>가격 : <%= hc.getRoomPrice() %></p>
	  					</div>
	  				</div>
					<%} %>
  				<%} %>
  			
		</div>
	
		<div class="paging-area" align="center">
        	<%if(currentPage > 1){ %>
        		<button class="btn btn btn-outline-info"
				onclick="pageMove(<%= currentPage-1 %>)" >이전</button>
			<%} %>
			
        	<%for(int i = startPage; i <= endPage; i++){ %>
        		<% if(currentPage != i) { %>
        			<button class="btn btn btn-outline-info"
        			onclick="pageMove(<%= i %>)"><%= i %></button>
        		<%} else { %>
        			<button
        			class="btn btn btn-outline-info"
        			disabled ><%= i %></button>
        		<%} %>
        	<%} %>
        	
        	<%if(currentPage != maxPage){ %>
        		<button class="btn btn btn-outline-info"
        		onclick="pageMove(<%= currentPage + 1 %>);" >다음</button>
        	<%} %>
	     </div>
</div>
	<script>
			$('.card-imgDiv').click(function(e){
				location.href = '<%= contextPath %>/select.hotels?hotelNo='+ $(this).attr('id')+"&daterange=<%= searchData.getDaterange()%>&location=<%= searchData.getLocation() %>&people=<%= searchData.getMaxPeople()%>";
			});
			
			function pageMove(currentPage){
				 location.href="<%= contextPath %>/searchList.hotels?currentPage="+currentPage+"&daterange=<%= searchData.getDaterange()%>&location=<%= searchData.getLocation() %>&people=<%= searchData.getMaxPeople()%>";
					 
			}
			
	</script>
</body>
</html>