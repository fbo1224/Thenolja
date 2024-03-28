<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="thenolja.member.model.vo.Member" %>
<%@ page import="java.util.ArrayList" %>   
<%
%>   
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>비회원 숙소 예약</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
    * {
        box-sizing: border-box;
    }
    #content{
    	padding-top: 20px;
        width: 1200px;
        height: 1500px;
        margin: auto;
    }

    #detail{
        height: 95%;
    }

    #left_img{
        width: 5%;       
        float: left;
    }
    #left_title{
        width: 95%; 
    }
    #reser_info{
        width: 100%;
        height: 25%;
        border-bottom: 1px solid silver;
    }
    #reser_info, #reser_price{width: 100%;}
    #reser_hotel_img{
        width: 30%;
        height: 90%;
        margin-left: 30px;
        float: left;
    }
    #reser_hotel_img > img{
        border-radius: 10px;
    }
    #reser_detail{
        width: 70%;
        height: 90%;
        padding-top: 20px;
        font-size: 23px;
    }
    #price_info{
        width:100%;
        height: 80%;
    }
    #reser_price{
        width:100%;
        height: 10%;
        font-size: 25px;
        padding-top: 35px;
        border-bottom: 1px solid silver;
        text-align: center;
    }
    #reser_mem_info{
        width: 100%;
        height: 28%;
        border-bottom: 1px solid silver;
    }
    #reser_mem_info > *{
        margin-top: 10px;
        height: 100%;
    }
    #mem-name{
        width: 50%;
        height: 70%;
        float: left;
        padding-left: 50px;
    }

    #mem-bicycle{
        padding-left: 50px;
        height: 30%;
        padding-bottom: 20px;
        margin-left: 10px;
        margin-top: 10px;
    }
    #mem-bicycle > input{
        margin-top: 20px;
        margin-left: 20px;
    }
    #reser_pay{
        width: 100%;
        height: 28%;
        padding-left: 50px;
        padding-top: 40px;
        padding-bottom: 50px;
        border-top: 1px solid silver;
    }
    #payment{
        border-radius: 5px;
        border: 0;
        background-color: #5BA199;
        color: white;
        font-size: 30px;
        font-weight: bold;
        width: 500px;
        height: 50px;
    } 
    #payment:hover{
        font-size: 31px;
    }
    #reservation{
        width: 100%;
        height: 7%;
    }
    #reser-btn{
        width: 50%;
        height: 50px;
        border-radius: 5px;
        border: 0;
        background-color: #5BA199;
        color: white;
        font-size: 30px;
        font-weight: bold;
        margin-left: 300px;
    }
</style>
</head>
<body>
    
    <%@ include file="../common/menubar.jsp" %>
    <!-- 0. 전체 감싸는 div 시작 -->
    <div id="content">
    
    	<!-- 0-1. 왼쪽 상단 '<' 숙소예약 시작 -->
        <div id="content_title">
        
            <div id="left_img">
                <a href="<%= contextPath%>"><img src="https://www.pngarts.com/files/2/Left-Arrow-PNG-Free-Download.png" alt="왼쪽 화살표" width="40px"></a>
            </div>
            
            <div id="left_title">
            	<h2>비회원 숙소 예약</h2>
            </div>
        </div>
        <!-- /0-1. 왼쪽 상단 '<' 숙소예약 끝 -->
        
       <!-- 0-2. 호텔정보 & 가격 & 예약자 & 쿠폰 & 결제  정보 시작 -->
		<div id="detail">
		
			<!-- 0-2-1. 호텔 정보 -->
			<div id="reser_info">
				
	    		<div id="reser_hotel_img">
	    			<img src="https://cf.bstatic.com/xdata/images/hotel/max1280x900/82237660.jpg?k=cb5db13896d348f7c4b47e3922a6753f83b5c36ba7b71a6f820523d07365fc2c&o=&hp=1" alt="" width="300px" height="300px">
    			</div>
	
				<div id="reser_detail">
				
			        <h2>마리안느 호텔</h2>
			        <p>슈페리어 더블(오션뷰)</p>
			        <p>2인</p>
			        <p>117,000원</p>
			        <p>2024-02-28 ~ 2024-02-29</p>
			        
    			</div>
			</div>
			<!-- /0-2-1. 호텔 정보 끝 -->
			
			<!-- 0-2-2. 가격 & 예약자 & 쿠폰 & 결제 정보 시작 -->
	        <div id="price_info">
	        	
	        	<!-- 0-2-2-1. 가격정보 시작 -->
	        	<div id="reser_price">
	        		<table>
	        			<tr>
	        				<td width="400px">결제금액 : 333,000원</td>
							<td width="30px"><img src="https://cdn-icons-png.flaticon.com/512/561/561179.png" alt="" width="30px"></td>
							<td width="400px">할인 금액 : 0원</td>
							<td width="30px"><img src="https://cdn-icons-png.flaticon.com/512/6492/6492285.png" alt="" width="35px"></td>
							<td width="400px">결제금액 : 333,000원</td>
						</tr>
	               </table>
				</div>
				<!-- /0-2-2-1. 가격정보 끝 -->

				<form action="<%= contextPath %>/insert.nonMem" method="post" id="insert-form">
				
					<!-- 0-2-2-2. 예약자 정보 시작(얘 정보 뽑아서 DB에 저장할 용도) -->
					<div id="reser_mem_info">
					
		                <br>
						<h3 id="info" style="margin-left: 50px;">예약자 정보</h3>
						<br>
		                
	               		<div id="mem-name">
		                    <h5>*예약자 이름</h5>
		                    <input type="text" id="reser-name" name="nonMemName" placeholder="이름을 입력해주세요" style="width:300px; height:40px; border-radius: 5px;">
	           			</div>
		                <div id="mem-phone">
		                    <h5>*전화 번호</h5>
		                    <input type="text" id="reser-phone" name="nonMemPhone" placeholder="전화번호를 입력해주세요" style="width:300px; height:40px; border-radius: 5px;">
		                </div>
		                <div id="mem-bicycle">
							<br> <h5>*이동 방식</h5>
						    <input type="radio" name="bicycle" id="car" value="차량"> 차량
						    <input type="radio" name="bicycle" id="walk" checked value="도보"> 도보
						</div>
						
	                </div>
	                <!-- /0-2-2-2. 예약자 정보 끝 -->
	                
	                <!-- 0-2-2-4. 결제 정보 시작 -->
	                <div id="reser_pay">
	                    <h3>결제 수단</h3>
	                    <br>
	                    <input type="button" id="payment" value="무통장 입금">
	                    <br><br>
	                    <h5>신한은행 110-424-432780 예금주((주)더놀자)</h5>
	                    <h5 style="color:red">"반드시 예약자 성함으로 입금해주세요"</h5>
	                </div>
	                <!-- /0-2-2-4. 결제 정보 끝 -->
	                
	                <!-- 0-2-2-5. 폼태그 안에 있는 모든 정보를 서블릿으로 보내주는 버튼 div 시작 -->
	                <div id="reservation">
	                    <button type="submit" id="reser-btn">?원 결제하기</button>
	                </div>

	                <!-- /0-2-2-5. 폼태그 안에 있는 모든 정보를 서블릿으로 보내주는 버튼 div 끝 -->
	            </form>
			</div>
			<!-- /0-2-2. 가격 & 예약자 & 쿠폰 & 결제 정보 끝 -->
		</div>
		<!-- /0-2. 호텔정보 & 가격 & 예약자 & 쿠폰 & 결제  정보 끝 -->
    </div>
    <!-- /0. 전체 감싸는 div 끝 -->
    
    
   
				
</body>
</html>