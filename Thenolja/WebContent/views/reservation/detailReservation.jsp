<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="thenolja.tb_reservation.model.vo.Reservation, thenolja.member.model.vo.Member, 
				thenolja.tb_hotel.model.vo.Hotel, thenolja.tb_hotel.model.vo.Room" %>  
<%
	Reservation reser = (Reservation)session.getAttribute("reser");
	Room room = (Room)session.getAttribute("room");
	Hotel hotel = (Hotel)session.getAttribute("hotel");
	
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
        /*border: 1px solid red;*/
        box-sizing : border-box;
    }

    #content{
        width: 1200px;
        height: 840px;
        margin: auto;
    }
    
    /*********************/

   #content_title, #detail{width: 100%;}

    #content_title{height: 10%;}

    #left_img{
        width: 5%;
        height: 100%;
        float: left;
    }

    #left_img > a > img{
        margin-top: 20px;
    }

    #left_title{
        width: 95%;
        height: 100%;
        float: left;
    }
    
    #left_title > h3 {
        margin-top: 25px;
    }

    #detail{height: 90%;}
    
    #reser_info{
        width: 100%;
        height: 35%;
    }
    #price_info{
        width: 100%;
        height: 65%;

    }

    #reser_no {
        width: 100%;
        height: 10%;
    }

    #reser_no > p {
        margin-top: 10px;
        padding-left: 120px;
    }

    #reser_hotel_img {
        width: 30%;
        height: 90%;
        float: left;
    }

    #reser_hotel_img > img {
        margin-left: 120px;
        border-radius: 10px;
    }


    #reser_detail{
        width: 45%;
        height: 90%;
        float: left;
    }

    #reser_detail > p{
        padding-top: 7px;
    }
    
    #reser_btn{
        width: 25%;
        height: 90%;
        float: left;
        position: relative;
    }

    #reser_btn > button{
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

    #rser_price{
        width: 100%;
        height: 20%;
        padding-left: 120px;
        padding-top: 5px;
    }
    
    #reser_price_info{
        width: 100%;
        height: 50%;
        padding-left: 120px;
        padding-top: 30px;
    }

    #reser_member {
        width: 100%;
        height: 30%;
        padding-left: 120px;
        padding-top: 30px;
    }

    table{
        width: 70%;

    }

    hr{
        border: 1px solid;
        width: 90%;
        margin-left: 1px;
    }

    #refund_name{
       margin-left: 20px;
    }

    #bank_name{
        margin-left: 7px;
    }

    #refund_btn > button{
        float: right;
    }
    #my_btn{
    	width: 200px;
    	height: 50px;
    	border: 1px solid black;
    	margin: auto;
		margin-top: 100px;	
    }
	#my_btn > button{
		width: 200px;
		height: 50px;
	}

</style>


</head>
<body>
	
    <%@ include file="../common/menubar.jsp" %>
    <div id="content">
        <div id="content_title">
            <div id="left_img">
                <a href="<%= contextPath%>"><img src="https://www.pngarts.com/files/2/Left-Arrow-PNG-Free-Download.png" alt="왼쪽 화살표" width="40px"></a>
            </div>
            <div id="left_title"><h3>상세조회</h3></div>
        </div>
        <div id="detail">
            <div id="reser_info">

                <div id="reser_no"><p>No.<%= reser.getReserNo() %></p></div>
                
                <div id="reser_hotel_img"><img src="https://cf.bstatic.com/xdata/images/hotel/max1280x900/82237660.jpg?k=cb5db13896d348f7c4b47e3922a6753f83b5c36ba7b71a6f820523d07365fc2c&o=&hp=1" alt="" width="220px" height="220px"></div>

                <div id="reser_detail">
				<input type="hidden" name="hotelNo" value="<%=hotel.getHotelNo() %>">
			        <h2><%=hotel.getHotelName() %></h2>
			        <p><%=room.getRoomName() %></p>
			        <p><%=room.getMaxPeople() %>인</p>
			        <p><%=room.getRoomPrice() %>원</p>
			        <p><%=room.getCheckInTime() %> : 00 ~ <%=room.getCheckOutTime() %> : 00</p>
                </div>

                <div id="reser_btn">
                    <button class="btn btn-outline-secondary" data-toggle="modal" data-target="#myModal">환불하기</button>
                </div>
            </div>
        

            <div id="price_info">

            
                <div id="rser_price">
                    <h3>결제 금액</h3>
                    <hr>
                    <table>
                        <tr>
                            <td width="170x">예약금액 : <%= reser.getPaymentPrice() %></td>
                            <td><img src="https://cdn-icons-png.flaticon.com/512/561/561179.png" alt="" width="20px"></td>
                            <td width="170x">할인 금액 : 0원</td> <!--  나중에 스크립틀릿 만들어서 넣어놓기 -->
                            <td><img src="https://cdn-icons-png.flaticon.com/512/6492/6492285.png" alt="" width="25px"></td>
                            <td>결제금액 : <%= reser.getPaymentPrice() %> <!-- 얘는 나중에 예약금액 - 할인금액 만들어서 하기 -->
                    </table>
                </div>

                <div id="reser_price_info">
                    <h3>결제 내역</h3>
                    <hr>
                    <p>무통장 입금</p>
                    <table>
                    <tr>
                        <td width="80px">신한은행</td> 
                        <td>110-404-432780</td>
                    </tr>
                    <tr>
                        <td>예금주</td> 
                        <td>(주)더놀자</td>
                    </tr>
                    <tr>
                        <td>입금자명</td> 
                        <td><%=reser.getName() %></td>
                    </tr>
                    </table>
                </div>

                <div id="reser_member">
                    <h3>예약자 정보</h3>
                    <hr>
                    <table>
                    <tr>
                            <td width="80px">이름</td> 
                            <td><%= reser.getName() %></td>
                            <td width="80px">전화번호</td> 
                            <td><%= reser.getPhone() %></td>
                        </tr>
                        <tr>
                            <td>차량</td> 
                            <td colspan="3"><%= reser.getBicycle() %></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>

    </div>
    <div id="my_btn">
	    <a href="<%=contextPath%>/myReser.list?reMemNo=<%= reser.getReMemNo()%>&hotelNo=<%=hotel.getHotelNo()%>">
	    	<button class="btn btn-outline-secondary" style="width:200px; height:50px;">내 예약 내역 조회</button>
	    </a>
    </div>
      <!-- The Modal -->
  <div class="modal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">환불 계좌 입력</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
        <form action="<%= contextPath %>/refund.insert"  method="post"> 
            <label for="text">예금주</label>
            <input type="text" id="refund_name" required name="refundName"><br><br>
            
            <input type="hidden" value="<%= reser.getReserNo() %>" name="reserNo"/>
            <label for="text">환불계좌</label>
            <select id="bank_name" name="bankName">
                <option>신한은행</option>
                <option>국민은행</option>
                <option>농협은행</option>
                <option>우리은행</option>
            </select>
            <input id="acc" type="text" placeholder="계좌번호 입력" required name="accNo">
            <div id="refund_btn">
                <br>
                <button type="submit" class="btn btn-dark">확인</button>
                <button type="button" class="btn btn-light" data-dismiss="modal">취소</button>
                
            </div>
        </form>
        </div>
      </div>
    </div>
  </div>
	
	<br><br><br><br><br><br><br><br><br><br>
</body>
</html>