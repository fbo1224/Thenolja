<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<!-- CSS -->
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />

<!-- JS -->
  <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>

<style>
	div{
		box-sizing: border-box;
	}
	#wrap{
		width: 1200px;
		height: 1000px;
		margin: auto;
	}
	
	.swiper {
      width: 100%;
      height: 350px;
      padding: 20px;
    }
    .swiper-slide {
      text-align: center;
      font-size: 18px;
      background: #fff;
      display: flex;
      justify-content: center;
      align-items: center;
    }
    .swiper-slide img {
      display: block;
      width: 100%;
      height: 100%;
      object-fit: cover;
    }
    .card-imgDiv, .card-info{
		display: inline-block;
		width: 50%;
		height: 100%;
	}
    .card-img{
		width: 100%;
		height: 100%;
		border-radius: 10px;
		cursor: pointer;
	}
	.card-info {
		float:right;
		display:flex;
		align-items: center;
		justify-content: center;
		flex-direction: column;
	}
	.card-info > h4 {
		text-align: center;
	}
	.card-info > p{
		margin: 0px;
		padding-left: 30px;
		margin-bottom: 10px;
	}
	.cards{
		width:	100%;
		height: 250px;
		margin: 10px;	
	}
	.mainPage-title-div {
		margin: 25px auto;
		border-bottom: 1px solid gray;
	}
	.mainPage-title-div > h3 {
		margin: 3px;
	}
	.swiper-button-prev{
		display: block;
		left: 1px;
	}
	.swiper-button-next{
		display: block;
		right: 1px;
	}
</style>
</head>

<body>
	<%@ include file="views/common/menubar.jsp" %>
	<%@ include file="views/hotel/common/searchForm.jsp" %>
	
	<div id="wrap">
		<div class="mainPage-title-div">
			<h3>요즘 인기있는 숙소</h3>
		</div>
		 <div class="swiper mySwiper">
		    <div class="swiper-wrapper populars">
		    </div>
		    
	    	<div class="swiper-pagination"></div>
		    <div class="swiper-button-next"></div>
		    <div class="swiper-button-prev"></div>
		    <div class="swiper-pagination"></div>
	  	</div>
  	
		<div class="mainPage-title-div">
			<h3>지역별 추천숙소</h3>
		</div>	
		 <div class="swiper mySwiper-2">
		    <div class="swiper-wrapper recommands">
		    </div>
	  	</div>
		
	</div>
	
	<script>
	$(function (){
		
		// 인기있는
		$.ajax({
			url:"popularData.jqAjax",
			type: 'post',
			success: function(result){
				for(let i = 0; i < result.length; i++){
					$('.populars').append('<div class="swiper-slide">'
							+'<div class="cards" id="'+ result[i].hotelNo +'">'
								+'<div class="card-imgDiv">'
									+'<img class="card-img" src="'+result[i].hotelPath+'">'
								+'</div>'
								+'<div class="card-info">'
									+'<h4>'+result[i].hotelLocation+'</h4>'
									+'<p>숙소명 : '+result[i].hotelName +'</p>'
									+'<p>종류 : '+result[i].hotelCategory+'</p>'
								+'</div>'
							+'</div>'	
						+'</div>');	
				}
			},
			async : false,
			error: function(){
				
			},
		});
		
		// 추천숙소 ajax
		$.ajax({
			url:"locRecomData.jqAjax",
			type: 'post',
			success: function(result){
				for(let i = 0; i < result.length; i++){
					$('.recommands').append('<div class="swiper-slide">'
							+'<div class="card" id="'+ result[i].hotelNo +'"style="width:280px; cursor: pointer;">'
							 	+'<img class="card-img-top" src="'+ result[i].hotelPath +'" alt="Card image">'
							    +'<div class="card-body">'
							    +'<h4 class="card-title">'+ result[i].hotelName +'</h4>'
							    +'<p class="card-text">'+ result[i].hotelLocation +'</p>'							   
							    +'</div>'
							+'</div>'
						+'</div>');	
				}
			},
			async : false,
			error: function(){
				
			},
		});
		
		var swiper = new Swiper(".mySwiper", {
		      slidesPerView: 3,
		      spaceBetween: 30,
		      freeMode: true,
		      pagination: {
		        el: ".swiper-pagination",
		        clickable: true,
		      },
		      navigation: {
		          nextEl: ".swiper-button-next",
		          prevEl: ".swiper-button-prev",
		      },
		});
		
		// 하단 swipper/ 갯수설정, 세부 설정 필요
		var swiper = new Swiper(".mySwiper-2", {
		      slidesPerView: 4,
		      spaceBetween: 20,
		      freeMode: true,
		      pagination: {
		        el: ".swiper-pagination",
		        clickable: true,
		      },		      
		});
		
		$('.cards').click(function(e){
			location.href = '<%= contextPath %>/select.hotels?hotelNo='+ $(this).attr('id');
		});
		
		$('.card').click(function(e){
			location.href = '<%= contextPath %>/select.hotels?hotelNo='+ $(this).attr('id');
		});
	
	})
	</script>
</body>
</html>