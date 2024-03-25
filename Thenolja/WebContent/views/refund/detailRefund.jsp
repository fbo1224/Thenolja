<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="thenolja.tb_refund.model.vo.Refund, thenolja.tb_reservation.model.vo.Reservation" %>  
<%
	Refund refund = (Refund)request.getAttribute("refund");

	Reservation reser = (Reservation)request.getAttribute("reser");

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
        height: 1200px;
        margin: auto;
    }
    
    /*********************/

    #content_title, #detail{width: 100%;}

    #content_title{height: 10%;}

    #left_img{
        width: 15%;
        height: 100%;
        float: left;
    }

    #left_img > a > img{
        margin-left: 120px;
        margin-top: 30px;
    }

    #left_title{
        width: 85%;
        height: 100%;
        float: left;
    }
    
    #left_title > h3 {
        margin-top: 35px;
    }

    #detail{height: 90%;}
    
    #reser_info{
        width: 100%;
        height: 25%;
    }
    #price_info{
        width: 100%;
        height: 75%;

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

    #reser_btn > p{
        width: 120px;
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
        padding-top: 20px;
    }
    
    #reser_price_info{
        width: 100%;
        height: 30%;
        padding-left: 120px;
        padding-top: 30px;
    }

    #reser_member {
        width: 100%;
        height: 20%;
        padding-left: 120px;
        padding-top: 30px;
    }

    #refund_member{
        width: 100%;
        height: 30%;
        padding-left: 120px;
        padding-top: 30px;
    }

    #refund_title {
        width: 20%;
        height: 20%;
        float: left;
    }
    #refund_update{
        width: 40%;
        height: 20%;
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



</style>


</head>
<body>
               
    <div id="content">
        <div id="content_title">
            <div id="left_img">
                <a href="#"><img src="https://www.pngarts.com/files/2/Left-Arrow-PNG-Free-Download.png" alt="왼쪽 화살표" width="40px"></a>
            </div>
            <div id="left_title"><h3>상세조회</h3></div>
        </div>
        <div id="detail">
            <div id="reser_info">

                <div id="reser_no"><p>No.<%= refund.getReserNo() %></p></div>

                <div id="reser_hotel_img"><img src="https://cf.bstatic.com/xdata/images/hotel/max1280x900/82237660.jpg?k=cb5db13896d348f7c4b47e3922a6753f83b5c36ba7b71a6f820523d07365fc2c&o=&hp=1" alt="" width="220px" height="220px"></div>

                <div id="reser_detail">
                    <h3>마리안느 호텔</h3>
                    <p>슈페리어 더블(오션뷰)</p>
                    <p>2인</p>
                    <p>117,000원</p>
                    <p>2024-02-28 ~ 2024-02-29</p>
                </div>

                <div id="reser_btn">
                    <p class="btn btn-secondary" >환불처리중</p>
                </div>
            </div>
        

            <div id="price_info">

            
                <div id="rser_price">
                    <h3>결제 금액</h3>
                    <hr>
                    <table>
                        <tr>
                            <td width="170x">결제금액 : <%=reser.getPaymentPrice() %></td>
                            <td><img src="https://cdn-icons-png.flaticon.com/512/561/561179.png" alt="" width="20px"></td>
                            <td width="170x">할인 금액 : 0원</td>
                            <td><img src="https://cdn-icons-png.flaticon.com/512/6492/6492285.png" alt="" width="25px"></td>
                            <td>결제금액 : <%=reser.getPaymentPrice() %></td>
                        </tr>
                    </table>
                </div>

                <div id="reser_price_info">
                    <h3>결제 내역</h3>
                    <hr>
                    <p>무통장입금</p>
                    <table>
                    <tr>
                        <td width="80px">신한은행</td> 
                        <td>110-424-432780</td>
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
                            <td><%=reser.getName() %></td>
                            <td width="80px">전화번호</td> 
                            <td><%=reser.getPhone() %></td>
                        </tr>
                        <tr>
                            <td>이동방식</td> 
                            <td colspan="3"><%=reser.getBicycle() %></td>
                        </tr>
                    </table>
                </div>

                <div id="refund_member">
                    <div id="refund_title"><h3>환불 정보</h3></div>
                    <div id="refund_update"><button class="btn btn-outline-secondary" data-toggle="modal" data-target="#myModal">수정하기</button></div>
                    <hr>
                    <table>
                    <tr>
                        <td width="80px">환불 수단</td> 
                        <td>계좌이체</td>
                    </tr>
                    <tr>
                        <td>결제 금액</td> 
                        <td><%=refund.getRefundPrice() %></td>
                    </tr>
                    <tr>
                        <td>예금주</td> 
                        <td><%= refund.getRefundName() %></td>
                    </tr>
                    <tr>
                        <td><%=refund.getBank() %></td> 
                        <td><%=refund.getAccNo() %></td>
                    </tr>
                </table>
                </div>


            </div>
        </div>

    </div>


</body>
</html>