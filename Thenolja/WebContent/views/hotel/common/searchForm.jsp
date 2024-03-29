<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>searchForm</title>
  
   <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
   <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
   <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
   <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
   
<style>
	div{
		box-sizing: border-box;
	}

	#content-1{
		width: 1200px;
		margin: auto;
		height: 120px;
		border-top: 1px solid gray;
		border-bottom: 1px solid gray;
		display: flex;
		align-items: center;
		justify-content: center;		
	}
	#select-form {
		width: 80%;
		height: 100%;
		display:flex;
		align-items: center;
		justify-content: space-evenly;
	}
	#people-input, #search-input, #checkIn_date, #checkOut_date{
		width: 230px;
		height: 40px;
		margin: 5px;
	}
	#date {
		display: inline-block;
		font-size: 12px;
		color: green;
		text-align: center;
	}
</style>
</head>
<body>


<div id="content-1">
	<form id="select-form" action="#">
		<div style="display: inline-block;">
			<input class="form-control" type="text" name="daterange" value="" readonly/>
		</div>
		<span id="date"></span>
		<input class="form-control" id="people-input" type="number" name="people" min="1" max="99" placeholder="인원수를 입력해주세요." >
		
		<select id="locations" name="loc">
		</select>
		<input class="btn btn btn-info" id="search" type="button" value="서치">
	</form>
	
</div>

<script>
const toDay = new Date();
	let startDate;
	let endDate;
	let locations;
	
	$(function () {
	    $('input[name="daterange"]').daterangepicker({
	        minDate: new Date(),
	        "drops": "down",
	        "opens": "center",
	        "locale": {
	            "format": "YYYY-MM-DD",
	            "separator": " ~ ",
	            "applyLabel": "확인",
	            "cancelLabel": "취소",
	            "fromLabel": "From",
	            "toLabel": "To",
	            "customRangeLabel": "Custom",
	            "weekLabel": "W",
	            "daysOfWeek": ["일", "월", "화", "수", "목", "금", "토"],
	            "monthNames": ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
	        },
	        
	        "startDate": new Date(),
	        "endDate": new Date(),
	        
		    }, function (start, end, label) {
		    	// console.log(start.format('YYYY-MM-DD'));
		    	// console.log(end.format('YYYY-MM-DD'));
		    	startDate = start.format('YYYY-MM-DD');
		    	endDate = end.format('YYYY-MM-DD');
			    $('#date').text(startDate +' ~ '+endDate);
			});
		
	    // 지역 가져오기
	    $.ajax({
	    	url: "searchLocation.jqAjax",
	    	type: 'get',
	    	success: function(result){
	    		result = result.replaceAll("[","");
	    		result = result.replaceAll("]","");
	    		
	    		result = result.split(",")
	    		// console.log(result);
	    		for(let i = 0; i < result.length; i++){
	    			$('#locations').append('<option value="'+ result[i] +'">'+result[i]+'</option>');
	    		}
	    	},
	    	error: function(result){
	    		console.log(result);
	    	}
	    });
	    
	});
	
	// ajax 보류
	$('').click(function(){
		
		$.ajax({
			url: "searchData.jqAjax",
			data: {
				startDate : startDate,
				endDate : endDate,
				maxPeople : $('#people-input').val().trim(),
				location : $('#locations[name=loc] option:selected').text().trim(),
			},
			type: 'post',
			success: function(result){
				console.log(result);
			},
			error: function(result){
				
			}
		});
		
	})
	
</script>
    
</body>
</html>