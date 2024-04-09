<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="thenolja.tb_hotel.model.vo.*, java.util.*" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="views/hotel/css/hotelDetail.css" >
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
</head>

<body>
	<jsp:include page="./common/searchForm.jsp"/>
	
	<div id="detail-wrap">
		
		<c:choose>
			<c:when test="${ hotelDetail ne null }">
			<div id="detail-content">
				<div id="detail-content-title">
					<h3>
						<span>${hotelDetail.hotelName}</span> <span>호텔</span>
					</h3>
				</div>
				<div id="detail-content-img">
					<img src="${ hotelDetail.hotelPath }" alt="pic">
				</div>
				
				<div id="detail-content-imgInfo">
					<div>
						 <span>★</span>
						 <span>${hotelDetail.countReviews} 개의 리뷰</span>
						 <span><a href="#reviews">리뷰조회</a></span>
					</div>
					<div>
						<span>${ hotelDetail.hotelCate }</span>
					</div>
				</div>
				
				<div id="detail-content-services">
					<ul>
						<c:forEach var="sl" items="${ hotelDetail.serList }">
							<li>${ sl.serviceName}</li>
						</c:forEach>
					</ul>
					
					<!-- 동혁 시작-->
					<c:if test="${ loginUser ne null }"> 
						<div id="favorite">
							<label for="checkbox" id="label"></label>
						</div>
					</c:if>
					<!-- 동혁 끝 -->
				</div>
				
				<div id="detail-content-rooms">
					<h3 style="text-align: center; margin-top: 5px;">객실</h3>
						<c:forEach var="ri" items="${ hotelDetail.roomList }">
						<div class="content-rooms-card">
							<img src="${ ri.roomImg}">
							<div class="room-infos">
								<h4>${ ri.roomName }</h4>
								<p>입실시간 : ${ ri.checkInTime }</p>
								<p>퇴실시간 : ${ ri.checkOutTime }</p>
								<p>가격 : ${ ri.roomPrice }</p>
							</div>
							<div>
								<c:choose>
									<c:when test="${ searchData ne null }">
										<p>쿠폰적용가능</p>
										<a href="${ path }/insertReservation?hotelNo=${ hotelDetail.hotelNo }&roomNo=${ ri.roomNo }&daterange=${ searchData.daterange }&location=${ searchData.location}&people=${searchData.maxPeople}">
										<button class="btn btn-sm btn-info">객실 예약</button></a>
										<a href="${ path }/nonInsertReservation?hotelNo=${ hotelDetail.hotelNo }&roomNo=${ ri.roomNo }&daterange=${ searchData.daterange }&location=${ searchData.location}&people=${searchData.maxPeople}">
										<button class="btn btn-sm btn-primary" >비회원예약하기</button></a>
									</c:when>
									<c:otherwise>
										<p>쿠폰적용가능</p>
										<a href="${ path }/insertReservation?hotelNo=${ hotelDetail.hotelNo }&roomNo=${ ri.roomNo }&daterange=${ dateRangeForm }&location=${ hotelDetail.hotelLocation }&people=${ searchData.maxPeople }">
										<button class="btn btn-sm btn-info">객실 예약</button></a>
										<a href="${ path }/nonInsertReservation?hotelNo=${ hotelDetail.hotelNo }&roomNo=${ ri.roomNo }&daterange=${ dateRangeForm }&location=${ hotelDetail.hotelLocation }&people=${ searchData.maxPeople }">
										<button class="btn btn-sm btn-primary" >비회원예약하기</button></a>
									</c:otherwise>
							 	</c:choose>
							</div>
						</div>			
						</c:forEach>
						
				</div>
				
				<div id="detail-content-intro">
					<h3>숙소소개</h3>
					<p>${ hotelDetil.hotelIntro}</p>
				</div>
				
				<div id="detail-content-cancel">
					<h3>예약 취소 및 환불 규정</h3>
					<p>
					    자세한 사항은 더놀자 홈페이지 고객센터의 자주 묻는 질문에서 확인해주세요.
					</p>
				</div>	
		  </div>
		</c:when>
		<c:otherwise>
			<div>
				<h1>찾을 수 없습니다.</h1>
			</div>
		</c:otherwise>
	</c:choose>
	</div>


	<div class="container review-div">
		<div class="row clearfix">
		    <div class="col-lg-12">
		        <div class="card chat-app">
		            <div class="chat">
		                <div class="chat-header clearfix">
		                    <div class="row">
		                        <div class="col-lg-6">
		                            <img src="${hotelDetail.hotelPath}" alt="avatar">
		                            <div class="chat-about">
		                                <h6 class="m-b-0">${hotelDetail.hotelName}</h6>
		                            </div>
		                        </div>
		                    </div>
		                </div>
		                <a name="reviews"></a>
		                <div class="chat-history">
		                    <ul class="m-b-0" id="review-ul">
		                    </ul>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
		
		<div class="paging-area" align="center">
		</div>
	</div>
		
	<script>
	
	function reviewAjax(value){
		$('#review-ul').empty();
		$('.paging-area').empty();		
		
		$.ajax({
			url: "reviewList.jqAjax",
			data: {
				hotelNo : ${hotelDetail.hotelNo},
				currentPage: value,
			},
			type: 'get',
			success: function(result){
				for(let i = 0; i < result.reviewList.length; i++){
					$('#review-ul').append('<li class="clearfix" id="'+result.reviewList[i].reserNo+'">'
										   +'<div class="message-data">'
											   	+'<span class="message-data-time">'+result.reviewList[i].reserName+'</span>'
				                                +'<span class="message-data-time">'+result.reviewList[i].createDate+'</span>'
				                                +'<span class="message-data-time">'+result.reviewList[i].reviewScore+'</span>'
					                       +'</div>'
										   +'<div class="message my-message">'
										   	  +result.reviewList[i].reviewContent
										   +'</div>'	 
										  +'</li>');
				}
				
				if(result.pi.currentPage > 1){
					$('.paging-area').append(
					'<button class="btn btn btn-outline-info" onclick="reviewAjax(' + (result.pi.currentPage-1) +');">'
						+'이전'
					+'</button>');
				}
				
			   	for(let i = result.pi.startPage; i <= result.pi.endPage; i++){
        			if(result.pi.currentPage != i) {
        				$('.paging-area').append('<button class="btn btn btn-outline-info" onclick="reviewAjax('+ i +')">'
        						+i
        					+'</button>')
        			}
        			else {
        				$('.paging-area').append('<button class="btn btn btn-outline-info"disabled >'
        						+i
        						+'</button>')
        			}
        		}
			   	
			   	// 임시방편
        		if(result.pi.currentPage != result.pi.maxPage && result.pi.currentPage != 1){
        			$('.paging-area').append('<button class="btn btn btn-outline-info" onclick="reviewAjax('+(result.pi.currentPage+1)+')">'
        			+'다음'
        			+'</button>');
        		}
			},
			error: function(result){
				console.log(result);	
			}
		});
		
		$.ajax({
			url: "commentAdmin.jqAjax",
			data: {
				hotelNo: ${hotelDetail.hotelNo}
			},
			type: 'get',
			success: function(result){
				if(result != null){
					for(let i = 0; i < result.length; i++){
						$('#review-ul').children().each(function(idx, ele){
							if($(ele).attr('id') == result[i].reserNo){
								$(ele).after('<li class="clearfix">'
											+'<div class="message-data text-right">'
							    				+'<span class="message-data-time">작성자 : '+ result[i].nickname +'</span>'
												+'<span class="message-data-time">작성일 : '+ result[i].createDate +'</span>'
							    			+'</div>'
											+'<div class="message other-message float-right">'
												+'<span class="message-data-time">'+ result[i].commentContent +'</span>'
										    +'</div>'
										+'</li>');
							}
						});	
					}
				}
				
			},
			error : function(result){
				console.log(result);
			},
			async: false
		});

	}
	
	$(function(){
		reviewAjax(1);
	});
	
	</script>
	
	<c:if test="${ loginUser ne null }">
		<script>
		window.onload = function(){
			$.ajax({
				url : 'selectHeart',
				type : 'get',
				data : {
		        		   memNo : ${ loginUser.memNo },
		        		   hotelNo : ${ hotelDetail.hotelNo }
	        		   },
				success: function(result){
					let resultStr;
					
					if(result != 0){
						resultStr = '<input type="checkbox" id="checkbox" name="heart" value="heart" onclick="heartClick();" checked hidden>'+
				        '<svg t="1689815540548" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2271"><path d="M742.4 101.12A249.6 249.6 0 0 0 512 256a249.6 249.6 0 0 0-230.72-154.88C143.68 101.12 32 238.4 32 376.32c0 301.44 416 546.56 480 546.56s480-245.12 480-546.56c0-137.92-111.68-275.2-249.6-275.2z" fill="#231F20" p-id="2272" id="heart"></path></svg>';
					} else {
						resultStr = '<input type="checkbox" id="checkbox" name="heart" value="heart" onclick="heartClick();" hidden>'+
				        '<svg t="1689815540548" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2271"><path d="M742.4 101.12A249.6 249.6 0 0 0 512 256a249.6 249.6 0 0 0-230.72-154.88C143.68 101.12 32 238.4 32 376.32c0 301.44 416 546.56 480 546.56s480-245.12 480-546.56c0-137.92-111.68-275.2-249.6-275.2z" fill="#231F20" p-id="2272" id="heart"></path></svg>';
					}
					
					$('#label').html(resultStr);
				}
			})
		}
			
		// 클릭할 시 insert, delete 시작
	   function heartClick(){
		   const cb = document.getElementById('checkbox');
		   
	    	   var hc = '';
	    	   if(cb.checked == true){
	               hc = 'insertheart';
	               
	    	   } else {
	    		   hc = 'deleteheart';
	    	   }
	    	   
		   $.ajax({
			   url : hc,
			   type: 'post',
			   data : {
			   memNo : ${ loginUser.memNo },
			   hotelNo : ${ hotelDetail.hotelNo }
			   },
			   success: function(result){
				   console.log(result);
			   },
			   error: function(e){
					console.log(e);
				}
		   })
	    }
		// 클릭할 시 insert, delete 끝
		</script>
	</c:if>
</body>
</html>