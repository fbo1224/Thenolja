 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, thenolja.event.model.vo.Event, thenolja.common.model.vo.PageInfo" %>
<%
    ArrayList<Event> list = (ArrayList<Event>)request.getAttribute("eventList");
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	
	int currentPage = pageInfo.getCurrentPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();
	int maxPage = pageInfo.getMaxPage();	
%>    


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>더놀자 > 이벤트 > 목록</title>

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
		
		
		/* body layout 기준 */
		body, ul, li, strong, p{
		   border: 0;
		    padding: 0;
		    margin: 0;
		    color: inherit;
		    font-size: inherit;
		    line-height: inherit;
		    vertical-align: top; 
		}
		/* body layout 기준 */
		a {
		   text-decoration:none;
		}
		
		img {
		   vertical-align:top;
		   border:0;
		}
		
		li {
		    display: list-item;
		    text-align: -webkit-match-parent;
		    unicode-bidi: isolate;
		}
		
	
		#btn_reg{
		   float:right;
		   background-color:#17a2b8;
		   margin:5px;
		}
	
		
		/* 이벤트 게시판 layout START */
		.thumb-list event{
		   padding-left: 25%;
		}
		
		.align_center{
			padding-left:42%;
		}
		
		
		
		.thumb-list{
		   position:relative;
		   padding-left: 25%;
		    display: flex;
		    flex-wrap: wrap;      /* 이미지 일정하게 내리기 */
		   list-style-type: none;   /* li태그 점 없애기 */
		}
		
		.thunmb-list li{   
		   width:440px;
		   float:left;
		   position:relative;
		}
		
		.thumb-list.event li .txt-box .title {
		    margin-top: 4px;
		}
		
		
		.thumb-list li .txt-box .title {
		    overflow: hidden;
		    display: block;
		    color: #1a1d1d;
		    font-size: 20px;
		    line-height: 35px;
		    text-overflow: ellipsis;
		    white-space: nowrap;
		}
		
		
		.thumb-list.event li .img-box {
	
		   border-radius: 16px;
		   overflow: hidden;
		}
		
		/* 게시판 이미지 크기 등 설정 */
		.thumb-list li .img-box img {
		    object-fit: cover;
		    transform:scale(1);
		    transition: all 0.5s;
		}
		
		.thumb-list li .txt-box {
		    padding: 30px;
		}
		
		.thumb-list.event li .txt-box .category-box {
		    display: flex;
		}
		
		.thumb-list.event li .flag {
		    position: initial;
		    width: auto;
		    vertical-align: top;
		    min-width: 46px;
		}
		
		.flag.small {
		    height: 22px;
		    padding: 0 6px;
		    font-size: 12px;
		    line-height: 22px;
		}
		.flag {
		    display: inline-block;
		    height: 48px;
		    padding: 0 20px;
		    color: #fff;
		    font-size: 15px;
		    line-height: 48px;
		    text-align: center;
		    box-sizing: border-box;
		    white-space: nowrap;
		}
		
		.flag.type01 {
		    background-color: #eb008b;
		}
		.flag.type08 {
		    background-color: #D1D1D7;
		}
		/* 이벤트 게시판 layout END */
		#contentHeader{
		 padding-top:5%;
		}
	   
	   .sort-btn{
	    	
	    	border : none;
	    	background : white;
	    	float: right;
	
	    }
	    
	     .sort-btn:hover{
	    	
	    	color : #5BA199;
	    }
</style>
	
	



</head>
<body>

<%@ include file="../common/menubar.jsp" %>

    <div id="content_1">

        <div id="contentHeader"><h2 align="left">이벤트</h2></div>

        <hr>
        	<button class="sort-btn">오래된순</button>
			<button class="sort-btn">최신순</button>
	        <!-- 등록 버튼 영역 START -->
    		<a id="btn_reg" class="btn btn-primary" href="<%=contextPath%>/views/event/eventReg.jsp" role="button" style=>등록하기</a>		     
    <%if(loginUser != null && loginUser.getMemStatus().equals("A")){ %>
	    <script>
	    	$("#btn_reg").show();
	    </script>    
    <%} else { %>
	    <script>
	    	$("#btn_reg").hide();
	    </script>    
    <% } %>  
       <!-- 등록 버튼 영역 END -->
       
     <br>
    <!-- 실제 구현 시 반복할 부분 START -->
     <ul id="evtIng" class="thumb-list event">
       
       <% if(list.isEmpty()) { %>
             <tr>
                <th colspan="6" ></th>
                <span class="align_center">등록된 게시글이 존재하지 않습니다.</span>
             </tr>
          <%}else{ %>
             <!-- 비어있지 않음 -->
             <%for( Event n: list) { %>
                <li>
                <a href="javascript:void(0);" onclick="clckEvent ('<%= n.getEventNo() %>')">    
                <div id="eventContent">
                 <div class="img-box">         
                      <img width="608" height="304" src="<%= n.getEventImg() %>" alt="" onerror="this.onerror=null; this.src=&quot;/static/images/temp/img_thumb04.jpg&quot;;">
                   </div> 
                   <div class="txt-box">                                                         
                      <div class="category-box">
                         <% if( "Y".equals(n.getEventYn()) ) { %>
                            <span class="flag type01 small">진행중</span>                           
                      </div>                                                                  
                               <strong class="title"><%=n.getEventContent() %></strong>
                               <!-- 이벤트 시작일 ~ 종료일 세팅 -->
                               <p class="date"><%=n.getEventStrtDt() %> ~ <%=n.getEventEndDt() %></p>   
                         <% } else { %>
                            <span class="flag type08 small">종료</span>
                            <span class="txt">더놀자</span>                              
                         <% } %>                                                   
                   <div>                                                                     
                <a>                                                                        
             </li>                   
                
             <% } %>
 
          <% } %>
		 
	  </ul>
		                

   </div>

   
   
   <%@ include file="../common/footer.jsp" %>
   
   <script type="text/javascript">
/*****************************************
* 함수설명 : 이벤트 클릭 이벤트 처리   로그인계정 조건추가
******************************************/
function clckEvent(eventNo){

   if(typeof eventNo != "undefined" && eventNo != ""){
       
      <%if(loginUser != null){ %>
      
          <%if("A".equals(loginUser.getMemStatus())){ %>
            // 관리자인 경우 (수정화면)
            location.href= '<%=contextPath %>/selectUpdate.event?eventNo=' + eventNo + '&flag=' + 'Y';
         <%}else{%>
            // 일반회원인 경우 (상세화면)
             location.href= '<%=contextPath %>/detail.event?eventNo=' + eventNo + '&flag=' + 'N';
          <%}%>
          
      <%}%>    
   }
}

</script>
   
</body>
</html> 