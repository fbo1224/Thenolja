<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="thenolja.tb_reservation.model.vo.Reservation" %>
<%
	Reservation reser = (Reservation)session.getAttribute("reser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대기</title>
</head>
<body>


	<%@ include file="../common/menubar.jsp" %>
	
	예약중입니다.
	
	<button onclick="test2();">실행</button>

    <script>
        function test2(){

             setTimeout(function(){
                 alert('2초후에 뜹니다!')
             }, 2000);
             
        }
        
		$('#reser-btn').click(function(){	
			
			const reserNo = $(this).children().eq(0).text();
			
			// location.href = '<%=contextPath%>/reserDetail?reserNo=' + reserNo;
			// location.href = '<%=contextPath%>/views/reservation/detailReservation.jsp';
			
			
	     });
    </script>

</body>
</html>