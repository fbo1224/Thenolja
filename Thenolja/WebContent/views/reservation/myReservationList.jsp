<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="thenolja.tb_reservation.model.vo.Reservation, java.util.ArrayList,
				 thenolja.tb_review.model.vo.Review" %>
<%@ page import="java.text.SimpleDateFormat, java.util.Date"%>  				   
<%
	ArrayList<Reservation> reserList = (ArrayList<Reservation>)request.getAttribute("reserList");
	ArrayList<Review> reviewList = (ArrayList<Review>)request.getAttribute("reviewList");
	
	Date date = new Date();
    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy.MM.dd");
    String today = simpleDate.format(date);
	
%>    
<!DOCTYPE html>
<html lang="en">
<head>
    <title>숙소이용목록상세조회</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>

    div{
        box-sizing : border-box;
    }
    #output{
    	width: 1200px;
        height: auto;
        margin: auto;
    }
    #content{
        width: 1200px;
        height: 300px;
        margin-top: 20px;
    }
    #content_title{
        width: 100%;
        height: 100%;
        margin-top : 20px;
    }
    #left_img{
        float: left;

    }
    #left_title{
        margin-left: 60px;
    }
    #reser_info{
        width: 1000px;
        height: 80%;
        margin: auto;
        margin-top: 30px;
    }
    #reser_hotel_img{
        width: 25%;
        float: left;
    }
    #reser_hotel_img > img{
        border-radius: 10px;
    }
    #reser_detail > p{
        font-size: 20px;
    }
    #reser_detail > h3{
        font-weight: bold;
    }
    #reser_detail{
        width: 60%;
        height: 100%;
        float: left;
    }
    #review_in{
        width: 15%;
        height: 100%;
        float: left;
        position: relative;
    }
    #review_in > #reser_btn{
        width: 100px;
        height: 40px;
        border-radius: 10px;
        position: absolute;
        top : 0px;
        bottom: 50px;
        right: 0px;
        left: 0px;
        margin:auto;
    }
    #homeBtn {
    	text-align:center;
    }
    #goHome{
    	width : 300px;
    	height: 50px;
    	border-radius : 10px;
    	background-color: rgb(199, 199, 199);
    	border : 0;
    	margin-bottom: 100px;
    	font-size: 22px;
    }
    #goHome:hover{
    	font-size:23px;
    }

    /*********************/
</style>


</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<% if(loginUser == null) { %>
		<script>
			alert("로그인 페이지로 이동합니다.")
			location.href = '<%=contextPath%>/loginPage';
		</script>
	<% } %>
	<div id="output">
        <div id="content_title">
            <div id="left_img">
                <a href="<%=contextPath %>"><img src="https://www.pngarts.com/files/2/Left-Arrow-PNG-Free-Download.png" alt="왼쪽 화살표" width="40px"></a>
            </div>
            <div id="left_title"><h3>내 예약 내역</h3></div>
		</div>
    
		<% if(reserList.isEmpty()) { %>
			<table>
				<tr>
					<th style="font-size:40px;" colspan="5">예약 내역이 존재하지 않습니다.</th>
				</tr>
			</table>
		<% } else { %>
		<% for(Reservation r : reserList) { %>
		<div id="content">
	        <div id="reser_info">
	            <div id="reser_hotel_img"><img src="<%=r.getHotelPath() %>" alt="" width="220px" height="220px"></div>
				<input type="hidden" name="hotelNo" value="<%=r.getHotelNo() %>">
				<input type="hidden" name="roomNo" value="<%=r.getRoomNo() %>">
	            <div id="reser_detail">
	                <h3><%=r.getHotelName() %></h3>
	                <p><%=r.getRoomName() %></p>
	                <p><%=r.getPeople() %>인</p>
	                <p><%=r.getPaymentPrice() %>원</p>
	                <p><%=r.getCheckIn() %>&nbsp;&nbsp;<%=r.getCheckInTime() %> : 00 ~ <%=r.getCheckOut() %>&nbsp;&nbsp;<%=r.getCheckOutTime() %> : 00</p>
	            </div>


            <div id="review_in">
            <% if(today.compareTo(r.getCheckOut()) > 0) { %>
                <a href="<%=contextPath %>/review.insert?reserNo=<%=r.getReserNo() %>&hotelNo=<%=r.getHotelNo()%>&roomNo=<%=r.getRoomNo()%>"><button id="reser_btn" class="btn btn-outline-secondary">리뷰 작성</button></a>
            <% } else { %>
            	<button id="reser_btn" class="btn btn-outline-secondary" disabled>리뷰 작성</button>
            <% } %>
            </div>

        </div>
			<% } %>
		<% } %>
		</div>
	<div id="homeBtn">
		<a href="<%=contextPath%>"><button id="goHome" class="btn btn-info">메인으로 돌아가기</button></a>
	</div>
</div>

</body>
</html>