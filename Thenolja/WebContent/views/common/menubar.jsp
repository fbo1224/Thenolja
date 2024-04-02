<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="thenolja.member.model.vo.Member" %>

<%
    String contextPath = request.getContextPath();
	
	Member loginUser = (Member)session.getAttribute("loginUser");

	String alertMsg = (String)session.getAttribute("alertMsg");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>review</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    
    <!-- font -->
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
	
    <!-- dateRangePicker,css  -->
    <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
	
	
<style>
*{
	font-family: "Noto Sans KR", sans-serif;
  	font-optical-sizing: auto;
  	font-weight: 400;
  	font-style: normal;
}
div {
    box-sizing: border-box;
}

#header-navi{
    width: 1200px;
    height: 100px;
    margin: 0px auto;
    border-bottom: 3px solid darkcyan;
    display: flex;
    align-items: center;
    
}
#optionList{
    width: 100%;
    margin: 0px;
    display: flex;
    align-items: center;
    justify-content: space-evenly;
    padding-top: 30px;
}
#header-navi li {
    list-style: none;
    float: left;
}
#header-navi a {
    text-decoration: none;
    color: black;
    padding-right: 20px;
}

#header-title {
    display: inline-block;
    font-weight: bold;
    padding-top: 30px;
    font-size: 40px;
}
#logo-img{
    width:115px;
    height:100px;
}
#menu-list{
    margin-left: 400px;
}
.card-body{
	flex: none;
	min-height: 0px;
	padding : 0px;
}


 #header{
        width:1200px;
        height: 180px;
        margin: auto;
   } 


    #tnj_header{
        width: 100%;
        height: 50%;
    }

    #line{
        width: 100%;
        height: 10%;
        border-bottom: 3px solid rgb(70, 149, 151);  
    }

    #tnj_menu{
        width: 100%;
        height: 40%;
    }


    #tnj_header > div{
        height: 100%;
    }

    #tnj_icon{
        width: 10%;
        float: left;
    }

    #tnj_title{
        width: 35%;
        float: left;
    }

    #admin_login{
        width: 55%;
        float: left;
    }

    #tnj_icon > img{
        width: 80px;
        float: right;
        padding-top: 25px;
    }


    #tnj_title > h2{
        padding-top: 50px;
        padding-left: 30px;
        font-weight: 700;
        font-size: 30px;
    }

    #tnj_title > h2 > a{
        color: black;
        text-decoration: none;
    }

    #admin_login > p{
        padding-top: 60px;
        font-size: 20px;
        text-align: right;
        padding-right: 50px;
    }
    

    #admin_login > p > a{
        color: black;
        text-decoration: none;
    }

    #navi{
        list-style: none;
        margin: 0;
        padding: 0;
        height: 100%;
        padding-left: 200px;
    }

    #navi > li{
        float: left;
        width: 15%;
        height: 100%;
        text-align: center;
    }
    #navi a{
	      width: 100%;
	      height: 100%;
	      text-decoration: none;
	      color: black;
	      display: block;
	      line-height: 38px;
	      font-size: 17px;
	      transform: scale(1);
	      position: relative;
	      z-index: 3;
	      
    }
        
    #navi > li > ul{
        list-style: none;
        padding: 0px;
        display:none;
        border: 1px solid #469597;
		position : relative;
        z-index: 3;
    }

    #navi > li > a:hover + ul{
        display:block;
    }
    
    #navi a:hover{
    	z-index: 3;
    }

    #navi > li > ul:hover{
        display: block;
    }

    #navi a:hover{
        font-size: 17px;
        font-weight: 700;
        
    }
    
    #navi > li > ul a{
        font-size: 17px;
        background : white;
        
    }
    .form-control{
		display: inline-block;
		width: auto;
	}
	.form-check-input {
		position:static;
	}

	#nonmemBtn{
		border: none;
		border-radius: 10px;
		background-color: white;
		
	}


	#modal-body > li{
        list-style: none;
        padding: 0px;
        display:none;
	}

	input{outline-color: rgb(70, 149, 151);}

	.modal-body > input{
		width: 200px;
		height: 30px;
	}

</style>
    
</head>
<body>
	<script>
			// script태그 안에서도 스크립틀릿 같은 JSP요소를 사용할 수 있음
			
			const msg = '<%= alertMsg %>'; 
			// 문자열을 넘겨받았기 때문에 문자열로 묶어주어야 가져올 수 있다.
			
			if(msg != 'null'){ // 양 옆에 따옴표를 붙였기 때문에 문자열null과 비교
				alert(msg);
			
				// menubar.jsp가 로딩 될 때마다 alert이 계속 수행됨
				// session에 들어있는 alertMsg키값에 해당하는 벨류값을 지워줄 것!
				// XX.removeAttribute("키값");
				<% session.removeAttribute("alertMsg"); %>
			}
	</script>
	<%if(loginUser != null && loginUser.getMemStatus().equals("A")){ %>

		<div id="header">
	        <div id="tnj_header">
	            <div id="tnj_icon">
	                <img src="resources/img/logo.png" alt="logo">
	            </div>
	
	            <div id="tnj_title">
	                <h2><a href="<%= contextPath %>/adminMain">관리자</a></h2>
	            </div>
	
	            <div id="admin_login">
	                <p><a href="<%= contextPath %>/logout">로그아웃</a></P>
	            </div>
	        </div>
	        <div id="line"></div>
	        <div id="tnj_menu">
	            <ul id="navi">
	                <li>
	                    <a href="#">회원관리</a>
	                    <ul>
	                        <li><a href="<%= contextPath %>/selectMember?currentPage=1">회원조회</a></li>
	                        <li><a href="<%= contextPath %>/reserMember?currentPage=1">회원 예약 조회</a></li>
	                        <li><a href="<%= contextPath %>/accountCancellation?currentPage=1">탈퇴 회원 조회</a></li>
	                    </ul>
	                </li>
	    
	                <li>
	                    <a href="#">비회원관리</a>
	                    <ul>
	                        <li><a href="<%= contextPath %>/selectNonMem?currentPage=1">비회원 조회</a></li>
	                         <li><a href="<%= contextPath %>/reserNonMem?currentPage=1">비회원 예약 조회</a></li>
	                    </ul>
	                </li>
	    
	                <li>
	                    <a href="#">숙소관리</a>
	                    <ul>
	                    	<li><a href="<%= contextPath %>/hotelList.hotels?currentPage=1&loginStatus=<%= loginUser.getMemStatus() %>">숙소 관리</a></li>
	                    	<li><a href="<%= contextPath %>/insertForm.hotels">숙소 추가</a></li>
	                        <li><a href="<%= contextPath %>/hotelList.hotels?currentPage=1">숙소 조회</a></li>
	                    </ul>
	                </li>
	                
	                <li>
	                    <a href="#">결제관리</a>
	                    <ul>
                        <li><a href="<%= contextPath %>/refundMem?currentPage=1">회원 환불 조회</a></li>
                        <li><a href="<%= contextPath %>/refundNonMem?currentPage=1">비회원 환불 조회</a></li>
	                    </ul>
	    
	                </li>
	    
	                <li>
	                    <a href="#">고객센터관리</a>
	                    <ul>
	                        <li><a href="<%=contextPath %>/noticeList">공지사항</a></li>
	                        <li><a href="<%=contextPath %>/eventList?currentPage=1">이벤트</a></li>
	                        <li><a href="<%=contextPath %>/couponList">쿠폰</a></li>
	                        <li><a href="<%= contextPath %>/adminReviewList?currentPage=1">리뷰</a></li>
	                    </ul>
	    
	                </li>
	    
	            </ul>
	
	        </div>
	
	    </div>
	<%} else { %>
		<header id="header-navi">
		    <div>
		       <a href="<%= contextPath %>"><img id="logo-img" src="./resources/img/logo.png"alt="logo"></a></div>
		       <h2 id="header-title">더 놀자</h2>
		    <div id="menu-list">
		    <ul id="optionList" style="font-size: 20px;">
		    
		   		<% if(loginUser == null){  %> <!-- 로그아웃 상태라면 -->
		        	<li><a href="<%= contextPath %>/loginPage">로그인</a></li>
		        <% } else { %> <!-- 로그인상태라면 -->
		        	<li><a href="<%= contextPath %>/logout">로그아웃</a></li>
		        <% }%>
		        
		        <% if(loginUser == null){  %><!-- 로그아웃 상태라면 -->
		         	<li><a href="<%= contextPath %>/loginPage" id="logoutMP" onclick="alert('로그인이 필요합니다.')">마이페이지</a></li>
		        <% } else { %> <!-- 로그인상태라면 -->
		         	<li><a href="<%= contextPath %>/myPage">마이페이지
		         	</a></li>
		        <% } %>
		        
		        <% if(loginUser == null){  %><!-- 로그아웃 상태라면 -->
		         	<li><a href="<%= contextPath %>/memberJoin">회원가입</a></li>
		        <% } else { %> <!-- 로그인상태라면 -->
		          	<li></li>
		        <% } %>
		        
		        <% if(loginUser == null){  %><!-- 로그아웃 상태라면 -->
		        	<li>
		        	<button type="button" id="nonmemBtn" data-toggle="modal" data-target="#nonmemReser">
						비회원 예약조회
					</button></li>
		        <% } else { %> <!-- 로그인상태라면 -->
		         	<li>
		         	<a href="#">고객센터</a>
		         	<ul>
	                    <li><a href="<%=contextPath %>/noticeList">공지사항</a></li>
	                    <li><a href="<%=contextPath %>/eventList?currentPage=1">이벤트</a></li>
	                    <li><a href="<%=contextPath %>/couponList">쿠폰</a></li>
	                    <li><a href="<%= contextPath %>/adminReviewList?currentPage=1">리뷰</a></li>
	                </ul>
		         	</li>
	         	<% } %>
		    </ul>
		    </div>
		</header>
	<% } %>
	<!-- The Modal -->
	<div class="modal" id="nonmemReser">
	  <div class="modal-dialog">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="modal-title">비회원 예약조회</h4>
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	      </div>
	
	      <!-- Modal body -->
		  	<form action="<%= contextPath %>/selectNonmem" method="get">
	      		<div class="modal-body">
					예약번호<br><input type="text" maxlength="11" name="nonmemNo" required><br>
					예약자 성함<br><input type="text" maxlength="15" name="nonmemName" required>
				</div>
				
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary" data-toggle="modal">조회</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
				</div>
			</form>

	
	    </div>
	  </div>
	</div>

	
</body>
</html>