<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>리뷰 목록 조회</title>
    <style>
     div{
        box-sizing : border-box;
    }
    #content{
        width: 1200px;
        height: 1500px;
        margin-top: 20px;
        border: 1px solid black;
        margin: auto;
    }
    #content_title{
        width: 100%;
        height: 100%;
        margin-top : 20px;
    }
    #left_img{
        float: left;
		
    }
    #left_title{
        margin-left: 60px;
    }
    #reser_info{
        width: 1000px;
        height: 80%;
        margin: auto;
        margin-top: 30px;
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
    }
    #content > div{
    	margin: auto;
    }
    #content_1{
	    width: 80%;
	    height: 25%;
	    margin: auto;
	}
	</style>
	
</head>


<body>
	<%@ include file="../common/menubar.jsp" %>
    <div id="content">
		<div id="content_title">
		   	<div id="left_img">
	       		<a href="<%= contextPath%>"><img src="https://www.pngarts.com/files/2/Left-Arrow-PNG-Free-Download.png" alt="왼쪽 화살표" width="40px"></a>
		    </div>
		    <div id="left_title"><h3>리뷰 작성</h3></div>
		</div>
	<div id="content_1">
	    <div id="hotel-no">
	        No.845209342
	    </div>
	    <div>
           <div id="reser_hotel_img"><img src="https://cf.bstatic.com/xdata/images/hotel/max1280x900/82237660.jpg?k=cb5db13896d348f7c4b47e3922a6753f83b5c36ba7b71a6f820523d07365fc2c&o=&hp=1" alt="" width="220px" height="220px"></div>

            <div id="reser_detail">
                <h3>마리안느 호텔</h3>
                <p>슈페리어 더블(오션뷰)</p>
                <p>2인</p>
                <p>117,000원</p>
                <p>2024-02-28 ~ 2024-02-29</p>
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
	    <input type="file" name="up-file" id="file-up">
	    <button id="insert-img">사진추가</button>
	</div>
            
    <div id="content_4">
        <textarea name="review" id="review-content" cols="50" rows="20" style="resize:none;"></textarea>
    </div>
        
    <div id="footer">
        <button id="add" type="submit">등록하기</button>
    </div>

    </div>
    
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
             });


            $('#file-up').hide();
            $('#insert-img').click(function(){
                $('#file-up').click();
            });
        });
    </script>
</body>
</html>