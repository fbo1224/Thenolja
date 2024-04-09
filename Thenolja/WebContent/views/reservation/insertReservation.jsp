<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="thenolja.member.model.vo.Member, thenolja.tb_coupon.model.vo.Coupon" %>
<%@ page import="java.util.ArrayList, thenolja.tb_hotel.model.vo.Hotel, thenolja.tb_hotel.model.vo.Room
				,thenolja.tb_reservation.model.vo.ReserInfo" %>   
<%
	ArrayList<Coupon> list = (ArrayList<Coupon>)request.getAttribute("insertReservation");
	Hotel hotel = (Hotel)request.getAttribute("hotel");
	Room room = (Room)request.getAttribute("room");
	ReserInfo rinfo = (ReserInfo)request.getAttribute("rinfo");
%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>숙소이용목록상세조회</title>
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
        width: 900px;
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
        width: 250px;
        height: 250px;
        margin-left: 20px;
        margin-top: 20px;
    }
    #reser_detail{
        width: 70%;
        height: 90%;
        padding-top: 40px;
        font-size: 20px;
        margin-left: 400px;
    }
    #price_info{
        width:100%;
        height: 80%;
    }
    #reser_price{
        width:100%;
        height: 10%;
        font-size: 20px;
        padding-top: 40px;
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
        margin-top: 10px;
    }
    #mem-bicycle > input{
        margin-top: 20px;
        margin-left: 20px;
    }
    #reser-coupon{
        padding-left: 50px;
        width: 100%;
        height: 27%;
        margin-top: 20px;
        margin-bottom: 50px;
    }
    #in-coupon{
        width: 100px;
        height: 40px;
        margin-left: 3px;
        border-radius: 5px;
        border: 0;
        background-color: #5BA199;
        color: white;
        font-size: 17px;
        font-weight: bold;
    }
    #in-coupon:hover{font-size: 18px;}
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
        font-size: 23px;
        font-weight: bold;
        width: 300px;
        height: 50px;
    } 
    #payment:hover, #reser-btn:hover{
        font-size: 24px;
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
        font-size: 23px;
        font-weight: bold;
        margin-left: 300px;
    }

</style>
</head>
<body>
    
    <jsp:include page="../common/menubar.jsp"/>
    
    <c:set var="path" value="${ pageContext.request.contextPath }"/>
    
    <c:choose>
    <c:when test="${ empty sessionScope.loginUser }">
		<form action="${path }/login" method="post"></form>
	<script>
		alert("로그인이 되어있지 않습니다. 로그인페이지로 이동합니다.");
	 </script>
	</c:when>
	<c:otherwise>
    
    <div id="content">
    	
        <div id="content_title">
        
            <div id="left_img">
                <a href="${path }"><img src="https://www.pngarts.com/files/2/Left-Arrow-PNG-Free-Download.png" alt="왼쪽 화살표" width="40px"></a>
            </div>
            
            <div id="left_title">
            	<h2>숙소 예약</h2>
            </div>
        </div>
       
		<div id="detail">
			<div id="reser_info">
	    		<div id="reser_hotel_img">
	    			<img src=<c:out value = "${ hotel.hotelPath }"/> alt="" width="300px" height="300px">
    			</div>
	
				<div id="reser_detail">
				<input type="hidden" name="hotelNo" value="${ hotel.hotelNo }">
				<input type="hidden" name="roomNum" value="${ room.roomNo }">
			        <h2><c:out value= "${ hotel.hotelName }"/></h2>
			        <p><c:out value= "${ room.roomName }"/></p>
			        <p><c:out value= "${ rinfo.people }"/>인&nbsp;<small>최대인원&nbsp;<c:out value = "${ room.maxPeople }"/>인</small></p>
			        <p><c:out value= "${ room.roomPrice }"/>원</p>
			        <p><c:out value="${ rinfo.startDate }"/>&nbsp;&nbsp;<c:out value="${ room.checkInTime }"/> : 00 ~ 
			        <c:out value="${ rinfo.endDate }"/>&nbsp;&nbsp;<c:out value="${ room.checkOutTime }"/>: 00</p>
    			</div>
			</div>
	        <div id="price_info">
	        	<div id="reser_price">
	        		<table>
	        			<tr>
	        				<td width="400px">결제금액 : <c:out value="${ room.roomPrice }"/>원</td>
							<td width="20px"><img src="https://cdn-icons-png.flaticon.com/512/561/561179.png" alt="" width="20px"></td>
							<td width="400px">할인 금액 : <span id="pprice">0</span>원</td>
							<td width="25px"><img src="https://cdn-icons-png.flaticon.com/512/6492/6492285.png" alt="" width="25px"></td>
							<td width="400px" style="font-weight: bold;" >결제금액 : <span id="payPrice"><c:out value= "${ room.roomPrice }"/></span> 원</td>
						</tr>
	               </table>
				</div>

				<form action="${path}/insert.reser?memNo=${ sessionScope.loginUser.memNo }&hotelNo=${ hotel.hotelNo }&roomNo=${ room.roomNo }" method="post" id="insert-form">
					<input id="hidePrice" type="hidden" name="paymentPrice" value="${ room.roomPrice }">
					<input id="couponNo" type="hidden" name="couponNo" value="0">
					<input type="hidden" name="checkIn" value="${ rinfo.startDate }">
					<input type="hidden" name="checkOut" value="${ rinfo.endDate }">
					<input type="hidden" name="people" value="${ rinfo.people }">
					
					<div id="reser_mem_info">
		                <br>
						<h3 id="info" style="margin-left: 50px;">예약자 정보</h3>
						<br>
	               		<div id="mem-name">
		                    <h5>예약자 이름</h5>
		                    <input type="text" id="reser-name" name="memName" placeholder="이름을 입력해주세요" style="width:300px; height:40px; border-radius: 5px;" maxlength="4">
	           			</div>
		                <div id="mem-phone">
		                    <h5>전화 번호</h5>
		                    <input type="text" id="reser-phone" name="memPhone" placeholder="전화번호를 입력해주세요" style="width:300px; height:40px; border-radius: 5px;" maxlength="11">
		                </div>
		                <div id="mem-bicycle">
							<br> <h5>이동 방식</h5>
						    <input type="radio" name="bicycle" id="car" value="차량"> 차량
						    <input type="radio" name="bicycle" id="walk" checked value="도보"> 도보  
						</div>
						
	                </div>
	                
	                
	                <div id="reser-coupon">
	                
	                    <br>
	                    <h3>할인</h3>
	                    <br>
	                    <h5>쿠폰</h5>
	                    <br>
	                    <input id="couponInput" type="text" name="couponName" style="width:300px; height:40px; border-radius: 5px;" placeholder="[10% 혜택] 회원 등급 쿠폰">
	                    
	                    <button type="button" data-toggle="modal" data-target="#myModal" id="in-coupon">쿠폰 적용</button>
	           
	                </div>
	               
	                <div id="reser_pay">
	                    <h3>결제 수단</h3>
	                    <br>
	                    <input type="button" id="payment" value="무통장 입금">
	                    <br><br>
	                    <h5>신한은행 110-424-432780 예금주((주)더놀자)</h5>
	                    <h5 style="color:red">"반드시 예약자 성함으로 입금해주세요"</h5>
	                </div>
	                
	                <div id="reservation">
	                    <button type="submit" id="reser-btn"><span id="lastPay"><c:out value="${ room.roomPrice }"/></span>원 결제하기</button>
	                </div>

	            </form>
			</div>
		</div>
    </div>
   
    <script>
    
	let coupon = {};
    
    $(function(){
    	$.ajax({
    		url: "cupon.jqAjax",
    		type: 'get',
    		data:{
    			memberNo: ${ loginUser.memNo }
    		},
    		success : function(result){
    			// console.log(result);
    			if(result.length == 0){
    				$('#couponTable').append('<tr>'
	                   +'<th colspan="5">쿠폰이 존재하지 않습니다.</th>'
		                +'</tr>');
    				$('#payPrice').append(
    					'${ room.roomPrice }'
					);ss
    			} else{
    				for(let i = 0; i < result.length; i++){
    					
    					$('#couponTable').append(
    						'<tbody>'
    							+ '<tr class="list" id="ab' + i + '>'
    							  + '<input type="radio" " onclick="return getPercent(this);">'
	    			              + '<td name="couponNo">' + result[i].couponNo +'</td>'
	    			              + '<td>' + result[i].couponContent + '</td>'
	    			              + '<td>' + result[i].couponDate + '</td>'
	    			              + '<td>' + result[i].couponCode + '</td>'
	    			              + '<td id="percent' + i + '" name="percent">' + result[i].couponPercent + '%</td>'
    			                  +'</tr></tbody>');
    				}
    				
    			}
    		},
    		error: function(result){
    			console.log(result);
    		}
    		
    	});
    	
    });

	function getPercent(e){
		$('#pprice').empty();
		$('#payPrice').empty();
		$('#lastPay').empty();
		couponNo = $(e).children().eq(0).text();
		content = $(e).children().eq(1).text();
		date = $(e).children().eq(2).text();
		code = $(e).children().eq(3).text();
		percent = $(e).children().eq(4).text();
		
		// console.log(parseInt("2%"));
		
		$('#couponInput').val(content +' '+ percent + ' 할인!');
		coupon.couponNo = couponNo;
		coupon.content = content;
		coupon.date = date;
		coupon.code = code;
		coupon.percent = parseInt(percent);
	 	// console.log(parseInt(percent));
	 	$('#pprice').append('<span name="couponPrice">' + ((coupon.percent* 0.01)*<%=room.getRoomPrice()%>) + '</span>');
	 	console.log($('#hidePrice'));
		$('#hidePrice').val((<%=room.getRoomPrice()%> - ((coupon.percent* 0.01)*<%=room.getRoomPrice()%>)));
		console.log($('#hidePrice'));
		$('#couponNo').val(coupon.couponNo);
		// console.log($('#couponNo').val(coupon.couponNo));
		//console.log($('#hidePrice').val());
		$('#payPrice').append('<span>' + (<%=room.getRoomPrice()%> - ((coupon.percent* 0.01)*<%=room.getRoomPrice()%>)) + '</span>');
		$('#lastPay').append('<span>' + (<%=room.getRoomPrice()%> - ((coupon.percent* 0.01)*<%=room.getRoomPrice()%>)) + '</span>');
	}	
    </script>
    
    
    <div class="container">
    	<!-- The Modal -->
	 	<div class="modal fade" id="myModal">
			<div class="modal-dialog modal-dialog-centered">
	      		<div class="modal-content">
	        		<div class="modal-header">
			        <h4 class="modal-title">내 쿠폰</h4>
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        		</div>
	        
			        <div class="modal-body">
			        <table class="table table-hover" id="couponTable">
			        
			        
			        
			        
			        
			        
			        
			        
			        
		        		
	                </table>
					</div>
				
					<div class="modal-footer">
		         	<button type="button" id="aaaa" class="btn btn-secondary" data-dismiss="modal">적용</button>
		       		</div>
	     		</div>
			</div>
		</div>
	</div>
</c:otherwise>
</c:choose>

<%@ include file="../common/footer.jsp" %>











</body>
</html>