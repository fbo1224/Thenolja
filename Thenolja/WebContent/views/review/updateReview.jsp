<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="thenolja.tb_reservation.model.vo.Reservation, thenolja.tb_hotel.model.vo.Hotel,
				thenolja.tb_hotel.model.vo.Room, thenolja.tb_review.model.vo.Review" %>  
<%
	Review r = (Review)request.getAttribute("review");
	Room room = (Room)request.getAttribute("room");
	Hotel hotel = (Hotel)request.getAttribute("hotel");
	Reservation reser = (Reservation)request.getAttribute("reser");
%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html>
<html lang="en">
<head>
    <title>리뷰 수정</title>
    <style>
     div{
        box-sizing : border-box;
    }
    #content{
        width: 1200px;
        height: 1500px;
        margin-top: 20px;
        margin: auto;
    }
    #content_title{
        width: 100%;
        height: 5%;
        margin-top : 20px;
    }
    #left_img{
        float: left;
    }
    #left_title{
        margin-left: 60px;
        margin-top : 20px;
    }
    #content > div{
    	margin: auto;
    }
    #content_1{
	    width: 80%;
	    height: 20%;
	    margin: auto;
	}
	#content_2{
		width: 40%;
		height: 8%;
        text-align: left;
        font-size: 50px;
    }
    #starList{
        width: 100%;
        height: 100%;
    }
	#content_3{
		width: 80%;
		height: 5%;
	}
    #content_4{
        width: 80%;
        height: 45%;
        margin: auto;
        padding-top: 70px;
    }
   	#hotel-no{
        font-size:18px;
        margin-top:20px;
        margin-left: 20px;
        width: 100%;
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
        margin-left: 30px;
    }
   	#insert-img{
        width: 60%;
        height: 80%;
        margin-left: 80px;
        margin-top : 10px;
        background-color: silver;
        text-align: center;
        line-height: 60px;
        border: 0;
        color : white;
        font-size: 25px;
        font-weight: 700;
        border-radius: 10px;
    }
    #insert-img:hover{
        font-size: 26px;
        background-color: gray;
    }
    #review-content{
        font-size:25px;
        margin-left: 40px;
    }
    #footer{
        width: 80%;
        height: 17%;
        margin: auto;
        padding-left: 180px;
        
    }
    #add{
        border: 0;
        border-radius: 30px;
        text-align: center;
        width: 80%;
        height: 80px;
        font-size: 30px;
        color:white;
        background-color: rgb(29, 146, 97);
    }
    #add:hover{
    	font-size: 32px;
    	background-color: rgb(50, 146, 97);
    }
    #review_img{
    	border-radius: 5px;
    }
	</style>
	
</head>


<body>
   	<jsp:include page="../common/menubar.jsp"/>
   	<c:set var="path" value="${ pageContext.request.contextPath }"/>
   	
	<form action="${ path }/reviewUpdate.do?reserNo=${ reser.reserNo }&hotelNo=${ hotel.hotelNo }&roomNo=${ r.roomNo}" method="post" enctype="multipart/form-data">
    <div id="content">
		<div id="content_title">
		   	<div id="left_img">
	       		<a href="${ path }"><img src="https://www.pngarts.com/files/2/Left-Arrow-PNG-Free-Download.png" alt="왼쪽 화살표" width="40px"></a>
		    </div>
		    <div id="left_title"><h3>리뷰 작성</h3></div>
		</div>
	<div id="content_1">
	    <div id="hotel-no">
	        No.${ r.reserNo }
	    </div>
	    <div>
           <div id="reser_hotel_img"><img src="${ hotel.hotelPath }" alt="" width="220px" height="220px"></div>
	            <div id="reser_detail">
                <h3>${ hotel.hotelName }</h3>
                <p>${ room.roomName }</p>
                <p>${ reser.people }인</p>
                <p>${ reser.paymentPrice }원</p>
                <p>${ reser.checkIn }&nbsp;&nbsp;${ room.checkInTime } : 00 ~ ${ reser.checkOut }&nbsp;&nbsp;${ room.checkOutTime } : 00</p>
           </div>
    	</div>
    </div>
    <div id="content_2">
        <div id="starList">
            <span class="star" value="0">☆</span>
            <span class="star" value="1">☆</span>
            <span class="star" value="2">☆</span>
            <span class="star" value="3">☆</span>
            <span class="star" value="4">☆</span>
        </div>
    </div>
	<div id="content_3">
	    <input type="file" name="upfile" id="file-up">
	    <button type="button" id="insert-img">사진추가</button>
	    <c:if test="${ review ne null }">
     	<label style="margin-left: 20px;">첨부파일 :&nbsp;&nbsp; <img id="review_img" src="${ review.imgPath }" width="100px" height="100px"></label>
     	<input type="hidden" name="fileNo" value="${ review.fileNo }"/>
     	<input type="hidden" name="changeName" value="${ review.changeName }"/>
		</c:if>
	</div>
    <div id="content_4">
        <textarea name="reviewContent" id="review-content" cols="70" rows="15" style="resize:none;">${ r.content }</textarea>
    </div>
        
    <div id="footer">
        <button id="add" type="submit">등록하기</button>
    </div>
	<input id="starScore" type="hidden" name="starScore" value="">
</div>
</form>    
     <script>
        $(function(){
            let starScore = 0;
            $('.star').click(function(e){
                if($(e.target).text() == '★'){
                    for(let i = 4; i >= $(e.target).attr('value'); i--){
                        $('.star').eq(i).text('☆').css('color', 'black'); 
                    }
                    starScore = $(e.target).attr('value')
                    console.log(starScore);
                    return;
                }

                for(let i = 0; i <= $(e.target).attr('value') ; i++){
                    if($(e.target).attr('value') >= $('.star').eq(i).attr('value')){
                        $('.star').eq(i).text('★').css('color', 'orange');
                    }
                }
                starScore = parseInt($(e.target).attr('value')) + 1;
                console.log(starScore);
                $('#starScore').val(starScore);
             });


            $('#file-up').hide();
            $('#insert-img').click(function(){
                $('#file-up').click();
            });
        });
        
        function insertReview(){
        	$.ajax({
        		url : 'reviewInsert.do',
        		type : 'post',
        		data : {
        			reserNo : ${ reser.reserNo },
        			imgPath : $('#file-up').val(),
        			content : $('#review-content').val(),
        			score : $('.star').val()
        		},
        		success : function(result){
        			console.log(result);
        		}
        	})
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    </script>
</body>
</html>