<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ page import="java.text.SimpleDateFormat, java.util.Date"%>    
<%
	Date date = new Date();
	SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy년 M월 d일");
	String today = simpleDate.format(date);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>관리자메인페이지</title>
    <style>

        div{
            box-sizing : border-box;
        }


        #wrap{
            width: 1200px;
            height: 1200px;
            margin: auto;
        }

  
        #wrap > div{
            width: 100%;
        }

        #content{
            height: 70%;
        }
		 
		
		
		#header, #footer{
            height: 15%;
        }


        #content > div{
            height: 100%;
            float: left;
        }

        #content_1{
            width : 70%;
        }

        #content_2{
            width : 30%; 
        }
        
        
        #content2 > div{
       	 	width: 100%;
    	}
    	
	    #today {
	        height: 15%;
	    }
	
	    #today > p{
	        font-size: 20px;
	        font-weight: 700;
	        margin-top: 5%;
	    }
	
	    #today_content{
	        height: 85%;
	        
	    }
	
	    #today_content > div{
	        width: 60%;
	    }
	
	    #today > p{
	        padding-top: 20%;
	    }
	
	    #today_content > div{
	        height: 30%;
	        border-radius: 50%;
	        border: 1px solid #5BA199;
	        color: #5BA199;
	        margin: auto;
	        margin-top: 5%;
	    }
	
	    #today_content > div > p {
	        text-align: center;
	        font-size: 20px;
	        font-weight: 700;
	        padding-top: 35%;
	    }
	
	    #today_content > div:hover{
	        height: 30%;
	        border-radius: 50%;
	        background-color: #5BA199;
	        color: white;
	        transition: 0.8s ease-out;
	    }
	
	
	    #reser_list , #refund_list{
	        width: 80%;
	        height: 50%;
	        margin: auto;
	        padding-top: 10%;
	    }
	
	    #reser_list_title, #refund_list_title{
	
	        font-size: 20px;
	        font-weight: 700;
	
	    }
	        



    </style>


</head>
<body>
    
    <div id="wrap">
        <div id="header">
	        <%@ include file="menubar.jsp" %> 
        </div>
               
        <div id="content">
            <div id="content_1">
            	 <div id="reser_list">
                    <div id="reser_list_title"><p>최근 예약 내역</p></div>
                    <table class="table table-bordered" style="text-align: center";>
                        <thead>
                          <tr>
                            <th>예약번호</th>
                            <th>예약자명</th>
                            <th>전화번호</th>
                          </tr>
                        </thead>
                        <tbody>
                        </tbody>
                      </table>
                </div>
        
                <div id="refund_list">
                    <div id="refund_list_title"><p>최근 환불 내역</p></div>
                    <table class="table table-bordered" style="text-align: center";>
                        <thead>
                          <tr>
                            <th>예약번호</th>
                            <th>환불자명</th>
                            <th>환불금액</th>
                          </tr>
                        </thead>
                        <tbody>
                        </tbody>
                      </table>
                      </div>
        
            </div>
            <div id="content_2">
            	<div id="today"><p>Today 현황</p></div>

        <div id="today_content">
            <div id="today_join" data-toggle="modal" data-target="#myModal" onclick="detailJoin()"><p>회원가입<br><span id="join"></span>명 </p> </div>

            <div id="today_reser" data-toggle="modal" data-target="#myReserModal" onclick="detailReser()"><p>예약<br><span id="todayReser"></span>건</p></div>
    
            <div id="today_refund"><p>결제금액 <br><span id="todayPrice"></span>원</p></div>
            		
            
            </div>
        </div>
   	 </div>
     <div id="footer">
       	<%@ include file="footer.jsp" %> 
     </div>
    
    
    <script>
 
    	$(function(){
    		
    		$.ajax({
    			
    			url : 'reserTop.do',
    			type : 'post',
    			success : function(result){
    				
    				let resultStr = '';
    				for(let i = 0; i < result.length; i++){
    					
    					resultStr += '<tr>'
    							  + '<td>' + result[i].reserNo + '</td>'
    							  + '<td>' + result[i].reserName + '</td>'
    							  + '<td>' + result[i].memPhone + '</td>'
    							  + '<tr>'
    				};
    				$('#reser_list tbody').html(resultStr);
    				
    			} 
    		});
    		
    		
    		$.ajax({
    			
    			url : 'refundTop.do',
    			type : 'post',
    			success : function(result){
    				let resultStr = '';
    				for(let i = 0; i < result.length; i++){
    					
    					resultStr += '<tr>'
    							  + '<td>' + result[i].reserNo + '</td>'
    							  + '<td>' + result[i].refundName + '</td>'
    							  + '<td>' + result[i].refundPrice + '</td>'
    							  + '</tr>'
    				};
    				$('#refund_list tbody').html(resultStr);
    			}
    			
    		});
    		
    		
    		$.ajax({
    			
    			url : 'todayJoin.do',
    			type : 'post',
    			success : function(result){
    				$('#join').text(result);	
    			}
    		});
    		
    		
    		$.ajax({
    			
    			url : 'todayReser.do',
    			type : 'post',
    			success : function(result){
    				$('#todayReser').text(result);
    			}
    		});
    		
    		$.ajax({
    			
    			url : 'todayPrice.do',
    			type : 'post',
    			success : function(result){
    				$('#todayPrice').text(result);
    			}
    		});
    		
    	})
    	
    	function detailJoin(){
    		
    		$.ajax({
    			
    			url : 'detailJoinMember.do',
    			type : 'post',
    			success : function(result){
    				let resultStr = '';
                    if(result.length === 0) {
                    	resultStr += '<tr>'
                				  + '<th colspan="3">오늘은 가입자가 없습니다.</th>'
                				  + '</tr>'
               		} else {
    				for(let i = 0; i < result.length; i++){
	    					
	    					resultStr += '<tr>'
	    							  + '<td>' + result[i].memNo + '</td>'
	    							  + '<td>' + result[i].memId + '</td>'
	    							  + '<td>' + result[i].nickName + '</td>'
	    							  + '<tr>'
	    				};
	    				$('#joinDetail tbody').html(resultStr);
               		}    				
                    $('#joinDetail tbody').html(resultStr);
    			}
    		});
    	}
    	
    	function detailReser(){
    		
    		$.ajax({
    			
    			url : 'todayDetailReser.do',
    			type : 'post',
    			success : function(result){
    				let resultStr = '';
                    if(result.length === 0) {
                    	resultStr += '<tr>'
                				  + '<th colspan="4">오늘은 예약자가 없습니다.</th>'
                				  + '</tr>'
               		} else {
    				for(let i = 0; i < result.length; i++){
	    					
	    					resultStr += '<tr>'
	    							  + '<td>' + result[i].reserNo + '</td>'
	    							  + '<td>' + result[i].reserName + '</td>'
	    							  + '<td>' + result[i].hotelName + '</td>'
	    							  + '<td>' + result[i].paymentPrice + '</td>'
	    							  + '<tr>'
	    				};
	    				$('#reserDetail tbody').html(resultStr);
               		}    				
                    $('#reserDetail tbody').html(resultStr);
    			}
    		});
    	}
    	
    	
    
    </script>
    
 <!-- 오늘 가입자 명단 모달 -->   
 <div class="modal" id="myModal">

    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
            <p class="modal-title"><%=today %> 가입자</p>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
					<table id="joinDetail" class="table table-bordered" style="text-align: center";>
                        <thead>
                          <tr>
                          	<th>번호</th>
                            <th>아이디</th>
                            <th>닉네임</th>
                          </tr>
                        </thead>
                        <tbody>
                        </tbody>
                      </table>
        </div>
     
      </div>
    </div>
  </div>
      
    
    
<!-- 오늘 가입자 명단 모달 -->   
 <div class="modal" id="myReserModal">

    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
            <p class="modal-title"><%=today %> 예약자</p>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
					<table id="reserDetail" class="table table-bordered" style="text-align: center";>
                        <thead>
                          <tr>
                          	<th>번호</th>
                            <th>예약자명</th>
                            <th>숙소명</th>
                            <th>가격</th>
                          </tr>
                        </thead>
                        <tbody>
                        </tbody>
                      </table>
        </div>
     
      </div>
    </div>
  </div>   

    
    

</body>
</html>