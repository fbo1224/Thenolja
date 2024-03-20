<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  
<style>
	div{
		box-sizing: border-box;
	}
	#wrap {
		width: 1200px;
		height: auto;
		margin: auto;
	}
	#content-2-lists {
		width: 100%;
		border: 1px solid red;
		display: flex;
		align-items: center;
		justify-content: space-evenly;
		flex-wrap: wrap;
		padding: 50px;
	}
	
	#card{
		width:	45%;
		height: 30%;
		margin: 10px;
		box-shadow: 3px 3px 2px gray;
		display: flex;
		border-radius: 10px;
	}
	#card-imgDiv, #card-info{
		width: 50%;
		height: 100%;
	}
	#card-img{
		width: 100%;
		height: 100%;
		border-radius: 10px;
	}

	#card-info >h4 {
		text-align: center;
	}
	#card-info > p{
		margin: 0px;
		padding-left: 30px;
		margin-bottom: 10px;
	}
</style>
</head>
<body>


	<%@ include file="../common/menubar.jsp" %>
	
	<div id="wrap" style="border: 1px solid red">
	
		<%@ include file="./common/searchForm.jsp" %>
		
		<div id="content-2-lists">
			<div id="card">
  				<div id="card-imgDiv"><img id="card-img" src="views\tb_hotel\css\pepe2.jpeg"></div>
  				<div id="card-info">
					<h4>부산</h4>
					<p>판다호텔</p>
					<p>호텔<p>
					<p><span>★</span><span>4.8</span></p>
					<p>159,000</p>
  				</div>
			</div>
			<div id="card">
  				<div id="card-imgDiv"><img id="card-img" src="views\tb_hotel\css\pepe2.jpeg"></div>
  				<div id="card-info">
					<h4>부산</h4>
					<p>판다호텔</p>
					<p>호텔<p>
					<p><span>★</span><span>4.8</span></p>
					<p>159,000</p>
  				</div>
			</div>
			<div id="card">
  				<div id="card-imgDiv"><img id="card-img" src="views\tb_hotel\css\pepe2.jpeg"></div>
  				<div id="card-info">
					<h4>부산</h4>
					<p>판다호텔</p>
					<p>호텔<p>
					<p><span>★</span><span>4.8</span></p>
					<p>159,000</p>
  				</div>
			</div>
			<div id="card">
  				<div id="card-imgDiv"><img id="card-img" src="views\tb_hotel\css\pepe2.jpeg"></div>
  				<div id="card-info">
					<h4>부산</h4>
					<p>판다호텔</p>
					<p>호텔<p>
					<p><span>★</span><span>4.8</span></p>
					<p>159,000</p>
  				</div>
			</div>
			<div id="card">
  				<div id="card-imgDiv"><img id="card-img" src="views\tb_hotel\css\pepe2.jpeg"></div>
  				<div id="card-info">
					<h4>부산</h4>
					<p>판다호텔</p>
					<p>호텔<p>
					<p><span>★</span><span>4.8</span></p>
					<p>159,000</p>
  				</div>
			</div>
			<div id="card">
  				<div id="card-imgDiv"><img id="card-img" src="views\tb_hotel\css\pepe2.jpeg"></div>
  				<div id="card-info">
					<h4>부산</h4>
					<p>판다호텔</p>
					<p>호텔<p>
					<p><span>★</span><span>4.8</span></p>
					<p>159,000</p>
  				</div>
			</div>
		
			
		</div>
	</div>
</body>
</html>