 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, thenolja.event.model.vo.Event" %>
     <%
     Event event = (Event)request.getAttribute("event");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>더놀자 > 이벤트 > 상세</title>
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

        #header, #footer {
            height: 15%;
        }

        #content{
            height: 70%;
        }

        #content_1{
            width: 100%;
            height : 100%;
        }
        
        #footer{
			height: 15%;
			margin: auto;
		}

	

	       
	

	#content_1{
	    width: 1200px;
	    margin : auto;
	}

#detail-area{
	width:100%;
	height:100%;
	word-break:break-all; /* 줄바꿈 처리 */
	/*border : 1px solid lightgreen;
    background-color: lightblue;
    color: white;
    font-weight: bold; */
}


#detail_content-area{
	width:100%;
	height:100%;
    padding: 60px;
    border-bottom: 1px solid #d1d1d7;
    color: #1a1d1d;
    font-size: 18px;
    line-height: 26px;
    white-space: break-spaces;
}

.detail_content-area{
	display:block;
}




.btn-wrap{
	display: flex;
    align-items: center;
    justify-content: center;
    margin-top: 40px;
}

#detail-golist{
	width:448px;
	color: #fff;
    background-color: #5BA199;
    border-color: none;
}

	#contentHeader{
	 padding-top:5%;
	}
   
   .detail_date{
   	float : right;
   }

   
img {
	padding-top:10%;
	padding-bottom:10%;
    margin: auto;
    display: block;
}
</style>

</head>
<body>
<%@ include file="../common/menubar.jsp" %>


<div class="outer">
<div id="content_1">


	<table id="detail-area">
        <div id="contentHeader"><h2 align="left">이벤트</h2></div>

        <hr>
		<!-- 타이틀 영역 -->
	    <tr id="detail_title-area">
	         <td class="detail_title_name_td"><b><%= event.getEventContent()  %></b></td>
	         <td class="detail_date">이벤트 기간 : <%= event.getEventStrtDt() %> ~ <%= event.getEventEndDt() %></td>	
	    </tr>
	    <!-- 컨텐츠영역 -->		
	</table>
	<hr>
	<img src="<%=event.getEventImg() %>">
		    
	<div class="btn-wrap">
		<input type="button" id="detail-golist" class="btn btn-light"   value="목록으로 이동" onclick="history.back();"/>
		
        <!--작성자 보이게끔-->
        <!--로그인 유저가 작성자와 같은지-->
        <!-- 로그인 여부 판단 그리고 로그인유저의 이름(UNIQUE)이랑 공지사항의 작성자 (사용하기엔 무리) 이것은 적합하지 않음 -->
        <!-- 새롭게 조회해온 USER_NO컬럼값을 가지고 비교    매핑값? SERVLET키값= -->
	 
      
      <a href="<%= contextPath %>/updateForm.event?eventNo=<%= event.getEventNo() %>"   
         class="btn btn-sm btn-warning">수정하기</a>

    	<a href="<%= contextPath %>/delete.event?eventNo=<%= event.getEventNo() %>"
    	class="btn btn-sm btn-danger">삭제하기</a>
	</div>	

</div>
</div>

   
   <%@ include file="../common/footer.jsp" %>

</body>
</html> 