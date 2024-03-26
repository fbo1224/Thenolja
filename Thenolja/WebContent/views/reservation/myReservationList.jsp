<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="thenolja.tb_reservation.model.vo.Reservation, java.util.ArrayList" %>  
<%
	Reservation reser = (Reservation)request.getAttribute("reser");

	ArrayList<Reservation> boardList = (ArrayList<Reservation>)request.getAttribute("reserList");
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

    #content{
        width: 1200px;
        height: 300px;
        margin: auto;
        margin-top: 20px;
    }
    #content_title{
        width: 100%;
        height: 20%;
    }
    #left_img{
        float: left;

    }
    #left_title{
        margin-left: 60px;
    }
    #reser_info{
        width: 80%;
        height: 80%;
        margin: auto;
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
    /*********************/
</style>


</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
    <div id="content">
        <div id="content_title">
            <div id="left_img">
                <a href="#"><img src="https://www.pngarts.com/files/2/Left-Arrow-PNG-Free-Download.png" alt="왼쪽 화살표" width="40px"></a>
            </div>
            <div id="left_title"><h3>내 예약 내역</h3></div>
        </div>
        <div id="reser_info">
            <div id="reser_hotel_img"><img src="https://cf.bstatic.com/xdata/images/hotel/max1280x900/82237660.jpg?k=cb5db13896d348f7c4b47e3922a6753f83b5c36ba7b71a6f820523d07365fc2c&o=&hp=1" alt="" width="220px" height="220px"></div>

            <div id="reser_detail">
                <h3>마리안느 호텔</h3>
                <p>슈페리어 더블(오션뷰)</p>
                <p>2인</p>
                <p>117,000원</p>
                <p>2024-02-28 ~ 2024-02-29</p>
            </div>

            <div id="review_in">
                <button id="reser_btn" class="btn btn-outline-secondary" data-toggle="modal" data-target="#myModal">리뷰작성</button>
            </div>
        </div>
        
	</div>
	
	    <div id="my_btn">
	    <a href="<%=contextPath%>/myReser.list?memNo=<%=reser.getReMemNo()%>">
	    	<button class="btn btn-outline-secondary" style="width:200px; height:50px;">내 예약 내역 조회</button>
	    </a>
    </div>
	<br><br><br><br><br><br><br><br><br><br>
</body>
</html>