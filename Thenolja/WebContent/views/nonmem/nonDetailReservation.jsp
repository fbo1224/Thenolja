<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="thenolja.nonmem.model.vo.SelectNonmemReser"%>
<%@ page import="thenolja.tb_reservation.model.vo.Reservation, thenolja.member.model.vo.Member, thenolja.tb_hotel.model.vo.Room" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat, java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%
	ArrayList<SelectNonmemReser> nonmemReser = (ArrayList) session.getAttribute("nonmemReser");
	SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
--%>
<%--<% Date newDate = sdf.parse(r.getCheckInDate()); --%>
<%--<% Date newDate2 = sdf.parse(r.getCheckOutDate()); --%>
<%--<%
// System.out.println(c.getCheckInDate());
// System.out.println(newDate);
SimpleDateFormat sdf2 = new SimpleDateFormat("yy년MM월dd일");
String date1 = sdf2.format(newDate);
String date2 = sdf2.format(newDate2);
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비회원 예약조회 페이지</title>
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
        font-weight: bold;
    }

    #reser_no > p {
        padding-left: 130px;
    }

    #reser_hotel_img > img {
        width: 200px;
        height: 200px;
        float: left;
    }

    #reser_hotel_img > img {
        margin-left: 120px;
        border-radius: 10px;
        margin-top: 15px;
    }


    #reser_detail{
        width: 45%;
        height: 90%;
        float: left;
        margin-left: 30px;
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
        padding-top: 20px;
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
	
    <jsp:include page="../common/menubar.jsp"/>
    
    <div id="content">
        <div id="content_title">
            <div id="left_img">
                <a href="${ path }"><img src="https://www.pngarts.com/files/2/Left-Arrow-PNG-Free-Download.png" alt="왼쪽 화살표" width="40px"></a>
            </div>
            <div id="left_title"><h3>예약조회</h3></div>
        </div>
        <div id="detail">
            <div id="reser_info">
            
      			<c:forEach var="r" items="${ sessionScope.nonmemReser }">
	                <div id="reser_no"><p>No.${ r.reserNo }</p></div>
	                
	                <div id="reser_hotel_img"><img src="${ r.hotelPath }"></div>
	
	                <div id="reser_detail">
	                    <h3>${ r.hotelName }</h3>
	                    <p>${ r.roomName }</p>
	                    <p>${ r.people }명</p>
	                    <p>${ r.paymentPrice }원</p>
	                    
                       <p>${ r.checkInDate } ~ ${ r.checkOutDate }</p>
                       
                       
                       <p>오후 ${ r.checkInTime - 12 }시 ~ 오전${ r.checkOutTime }시</p>
		                       
	                       
	                       
	                </div>
				</c:forEach>
				
	                <div id="reser_btn">
	                    <button class="btn btn-outline-secondary" data-toggle="modal" data-target="#myModal">환불하기</button>
	                </div>
	            </div>
		        
	            <div id="price_info">
	            	<c:forEach var="r" items="${ sessionScope.nonmemReser }">
		                <div id="rser_price">
		                    <h3>결제 금액</h3>
		                    <hr>
		                    <table>
		                        <tr>
		                            <td width="170x">예약금액 : ${ r.paymentPrice }</td>
		                            <td><img src="https://cdn-icons-png.flaticon.com/512/561/561179.png" alt="" width="20px"></td>
		                            <td width="170x">할인 금액 : 0원</td> <!--  나중에 스크립틀릿 만들어서 넣어놓기 -->
		                            <td><img src="https://cdn-icons-png.flaticon.com/512/6492/6492285.png" alt="" width="25px"></td>
		                            <td>결제금액 : ${ r.paymentPrice } <!-- 얘는 나중에 예약금액 - 할인금액 만들어서 하기 -->
		                    </table>
		                </div>
					</c:forEach>
		                <div id="reser_price_info">
			                <c:forEach var="r" items="${ sessionScope.nonmemReser }">
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
			                        <td>${ r.reserName }</td>
			                    </tr>
			                    </table>
							</c:forEach>
		                </div>
	                <div id="reser_member">
		                <c:forEach var="r" items="${ sessionScope.nonmemReser }">
		                    <h3>예약자 정보</h3>
		                    <hr>
		                    <table>
		                    	<tr>
		                            <td width="80px">이름</td> 
		                            <td>${ r.reserName }</td>
		                            <td width="80px">전화번호</td> 
		                            <td>${ r.reserPhone }</td>
		                        </tr>
		                        <tr>
		                            <td>차량</td> 
		                            <td colspan="3">${ r.bicycle }</td>
		                        </tr>
		                    </table>
	                    </c:forEach>
	                </div>
	            </div>
	        </div>
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
		        <c:forEach var="r" items="${ sessionScope.nonmemReser }">
			        <form action="${ path }/refund.insert?reserNo=${ r.reserNo }%reMemNo=${ r.memNo }&hotelNo=${ r.hotelNo }&roomNo=${ r.roomNo }"  method="post"> 
			            <label for="text">예금주</label>
			            <input type="text" id="refund_name" required name="refundName"><br><br>
			            <input type="hidden" name="refundPrice" value="${ r.paymentPrice }">
			            <input type="hidden" value="${ r.reserNo }" name="reserNo"/>
			            <label for="text">환불계좌</label>
			            <select id="bank_name" name="bankName">
			                <option>신한은행</option>
			                <option>국민은행</option>
			                <option>농협은행</option>
			                <option>우리은행</option>
			            </select>
			            <input id="acc" type="text" placeholder="계좌번호 입력 -제외" required name="accNo">
			            <div id="refund_btn">
			                <br>
			                <button type="submit" class="btn btn-dark">확인</button>
			                <button type="button" class="btn btn-light" data-dismiss="modal">취소</button>
			                
			            </div>
			        </form>
		        </c:forEach>
	        </div>
	      </div>
	    </div>
  	</div>
	<br><br><br><br><br><br><br><br><br><br>
</body>
</html>