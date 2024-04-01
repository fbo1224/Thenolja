<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, thenolja.tb_hotel.model.vo.HotelCard, thenolja.common.model.vo.PageInfo" %>    
<%
	ArrayList<HotelCard> list = (ArrayList<HotelCard>)request.getAttribute("hotelList");
	PageInfo pi = (PageInfo)request.getAttribute("pageInfo");
	String loginStatus = (String)request.getAttribute("loginStatus");
	
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
	<%@ include file="./common/searchForm.jsp" %>
	<div id="wrap">
			
		<div id="content-2-lists">
			<%if(list.isEmpty()){ %>
				<div class="cards">
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
							<%if(loginUser != null && loginUser.getMemStatus().equals("Y")){ %>
								<p><span>★</span><span>4.8</span></p>
								<p>가격 : <%= hc.getRoomPrice() %></p>
							<%} else if(loginStatus != null && loginStatus.equals("A")) {%>
								<div class="option-btns-room" align="center">
									<a class="btn btn-sm btn-primary" href="<%= contextPath %>/insertForm.rooms?hotelNo=<%= hc.getHotelNo() %>">객실추가</a>
									<a class="btn btn-sm btn-info" href="<%= contextPath %>/updateListForm.rooms?hotelNo=<%= hc.getHotelNo() %>">객실정보수정</a>
									<a class="btn btn-sm btn-danger roomBtn" href="<%= contextPath %>/deleteListForm.rooms?hotelNo=<%= hc.getHotelNo() %>" >객실삭제</a>
								</div>
								<div class="option-btns" align="center">
									<a class="btn btn btn-info" href="<%= contextPath %>/updateForm.hotels?hotelNo=<%= hc.getHotelNo() %>">숙소정보수정</a>
									<a class="btn btn btn-danger hotelBtn" data-toggle="modal" data-target="#myModal" >숙소삭제</a>
								</div>
							<%} %>
	  					</div>
	  				</div>
					<%} %>
  				<%} %>
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
			$('.hotelBtn').click(function(e){
				hotelNo = $(this).parent().parent().prev().attr('id');
			});
			
			$('.deleteHotelBtn').click(function(e){
				$.ajax({
					url: 'deleteHotel.jqAjax',
					data: {
						hotelNo : hotelNo,
					},
					type: 'get',
					success : function(result){
						alert(result);
					},
					error: function(error){
						alert(error);
					},
					async: false
				});
				
				location.reload();
			})
			
		</script>
		
		<script>
			$('.card-imgDiv').click(function(e){
				location.href = '<%= contextPath %>/select.hotels?hotelNo='+ $(this).attr('id');
			});
		</script>
		
		<div class="paging-area" align="center">
			<%if(loginStatus != null && loginStatus.equals("A")){ %>
	        	<%if(currentPage > 1){ %>
	        		<button class="btn btn btn-outline-info"
					onclick=" location.href='<%= contextPath %>/hotelList.hotels?currentPage=<%= currentPage - 1 %>&loginStatus=A' " >이전</button>
				<%} %>
				
	        	<%for(int i = startPage; i <= endPage; i++){ %>
	        		<% if(currentPage != i) { %>
	        			<button class="btn btn btn-outline-info"
	        			onclick=" location.href='<%= contextPath %>/hotelList.hotels?currentPage=<%= i %>&loginStatus=A'" ><%= i %></button>
	        		<%} else { %>
	        			<button
	        			class="btn btn btn-outline-info"
	        			disabled ><%= i %></button>
	        		<%} %>
	        	<%} %>
	        	
	        	<%if(currentPage != maxPage){ %>
	        		<button class="btn btn btn-outline-info"
	        		onclick=" location.href='<%= contextPath %>/hotelList.hotels?currentPage=<%= currentPage + 1 %>&loginStatus=A' " >다음</button>
	        	<%} %>
	        	
	        <%} else { %>	
	        
	        	<%if(currentPage > 1){ %>
	        		<button class="btn btn btn-outline-info"
					onclick=" location.href='<%= contextPath %>/hotelList.hotels?currentPage=<%= currentPage - 1 %>' " >이전</button>
				<%} %>
				
	        	<%for(int i = startPage; i <= endPage; i++){ %>
	        		<% if(currentPage != i) { %>
	        			<button class="btn btn btn-outline-info"
	        			onclick=" location.href='<%= contextPath %>/hotelList.hotels?currentPage=<%= i %>'" ><%= i %></button>
	        		<%} else { %>
	        			<button
	        			class="btn btn btn-outline-info"
	        			disabled ><%= i %></button>
	        		<%} %>
	        	<%} %>
	        	
	        	<%if(currentPage != maxPage){ %>
	        		<button class="btn btn btn-outline-info"
	        		onclick=" location.href='<%= contextPath %>/hotelList.hotels?currentPage=<%= currentPage + 1 %>' " >다음</button>
	        	<%} %>
	        <%} %>	
	     </div>
	</div>
</body>
</html>