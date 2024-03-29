<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<!-- CSS -->
<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />

<!-- JS -->
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

<style>
	div{
		box-sizing: border-box;
	}
	#wrap{
		width: 1200px;
		height: 800px;
		border: 1px solid red;
		margin: auto;
	}
	.swiper-container{
		width: 100%;
	}
	
	.swiper-wrapper {
		width: 100%;
	}
	.swiper-container {
      width: 100%;
      height: 100%;
    }

    .swiper-slide {
      text-align: center;
      font-size: 18px;
      background: #fff;
      display: flex;
      justify-content: center;
      align-items: center;
    }
</style>
</head>

<body>
	<%@ include file="views/common/menubar.jsp" %>
	<%@ include file="views/hotel/common/searchForm.jsp" %>
	
	<div id="wrap">
	
		<div class="swiper-container">
		  <div class="swiper-wrapper">
		    <div class="swiper-slide">Slide 1</div>
		    <div class="swiper-slide">Slide 2</div>
		    <div class="swiper-slide">Slide 3</div>
		  </div>
		</div>
		
	</div>
	
	<script>
		const mySwiper = new Swiper('.swiper-container', {
		  direction: 'horizontal',
		  slidesPerView: 1,
		  navigation: {
			    nextEl: '.swiper-button-next',
			    prevEl: '.swiper-button-prev',
			  },
		  pagination: {
			    el: '.swiper-pagination',
			    type: 'bullets'
			  },
			  
		});
		
		$.ajax({
			url:"favoriteData.jqAjax",
			type: 'post',
			success: function(result){
				console.log(result);
			},
			error: function(){
				
			},
			
		});
	</script>
</body>
</html>