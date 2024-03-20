<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>searchForm</title>
  
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="stylesheet" href="views/tb_hotel/css/jquery-ui.css">
<style>
	div{
		box-sizing: border-box;
	}

	#content-1{
		width: 100%;
		height: 120px;
		border: 1px solid red;
		display: flex;
		align-items: center;
		justify-content: center;
		
	}
	#select-form {
		width: 100%;
		height: 100%;
		display:flex;
		align-items: center;
		justify-content: center;
	}
	#people-input, #search-input, #checkIn_date, #checkOut_date{
		width: 230px;
		height: 40px;
		margin: 5px;
	}
</style>
</head>
<body>
<script>
        $.datepicker.setDefaults({
            dateFormat: 'yy/mm/dd',
            prevText: '이전 달',
            nextText: '다음 달',
            monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
            monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
            dayNames: ['일', '월', '화', '수', '목', '금', '토'],
            dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
            dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
            showMonthAfterYear: true,
            yearSuffix: '년'
        });

        $(function () {
            $('.datepicker').datepicker();
      
        });

        function clickBtn(){
			
            console.log($('#checkIn_date').val());
            console.log($('#checkOut_date').val());
        }
    </script>
    
<div id="content-1">
	<form id="select-form" action="">
		<div style="display: inline-block;">
			입실: <input id="checkIn_date" class="datepicker" readonly >
  			퇴실: <input id="checkOut_date" class="datepicker" readonly >
		</div>
		
		<input id="people-input" type="number" name="people" value="" placeholder="인원수를 입력해주세요.">
		<input id="search-input" type="text" name="search" required value="" placeholder="검색어를 입력해주세요.">
		<input type="submit" value="서치">
	</form>
</div>
</body>
</html>