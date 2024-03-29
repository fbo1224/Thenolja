<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
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
	
</style>
</head>

<body>
	<%@ include file="views/common/menubar.jsp" %>
	<%@ include file="views/hotel/common/searchForm.jsp" %>
	<div id="wrap">
		
	</div>
	
	<script>
		$ajax({
			url:"",
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