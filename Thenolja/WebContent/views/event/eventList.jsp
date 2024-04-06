<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, thenolja.event.model.vo.Event" %>
<%
	ArrayList<Event> list = (ArrayList<Event>)request.getAttribute("eventList");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>더놀자 > 이벤트 > 목록</title>
<%@ include file="../common/menubar.jsp" %>
<style>

#content{
	width:1200px;
	height : 800px;
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
	font-family: NotoSansKR, '맑은고딕', Malgun Gothic, dotum, '돋음', arial, sans-serif;    
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

.outer{
	width : 1200px;
	height : 800px;
	margin : auto;
	}

#btn_reg{
	float:right;
	background-color:#17a2b8;
	margin:5px;
}
.align_center{
	text-align:center;
}  

/* 이벤트 게시판 layout START */
#evtIng{
	padding-left: 350px;
	padding-top : 150px;
}

.thumb-list{
	position:relative;
	margin: 30px -18px 0;
    display: flex;
    flex-wrap: wrap;		/* 이미지 일정하게 내리기 */
	list-style-type: none;	/* li태그 점 없애기 */
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
    font-size: 24px;
    line-height: 35px;
    text-overflow: ellipsis;
    white-space: nowrap;
}


.thumb-list.event li .img-box {
   width: 440px;
   height: 234px;
   border-radius: 16px;
   overflow: hidden;
}

/* 게시판 이미지 크기 등 설정 */
.thumb-list li .img-box img {
    /* width: 100%; */
    height: 100%;
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
</style>


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


</head>
<body>

	<div id="content">
		<br>
   	 <h2 align="center">이벤트</h2>
    <br>
    
    <!-- 등록 버튼 영역 START -->
	<a id="btn_reg" class="btn btn-primary" href="<%=contextPath%>/views/event/eventReg.jsp" role="button" style=>등록하기</a>
   	<!-- 등록 버튼 영역 END -->
   	
    <br>
	<!-- 실제 구현 시 반복할 부분 START -->
 	<ul id="evtIng" class="thumb-list event">
		
		<% if(list.isEmpty()) { %>
         	<tr class="align_center">
         		<th colspan="6">등록된 게시글이 존재하지 않습니다.</th>
         	</tr>
         <%}else{ %>
            <!-- 비어있지 않음 -->
         	<%for( Event n: list) { %>
	         	<li>
					<a href="javascript:void(0);" onclick="clckEvent ('<%= n.getEventNo() %>')">				
						<div class="img-box">			
							<img src="<%= n.getEventImg() %>" alt="당신의 직춘기 레벨을 진단해보세요!" onerror="this.onerror=null; this.src=&quot;/static/images/temp/img_thumb04.jpg&quot;;">
						</div> 
						<div class="txt-box">																			
							<div class="category-box">
								<% if( "Y".equals(n.getEventYn()) ) { %>
									<span class="flag type01 small">진행중</span>		
									<span class="txt">더놀자</span>									
							</div>																						
										<strong class="title"><%=n.getEventContent() %></strong>
										<!-- 이벤트 시작일 ~ 종료일 세팅 -->
										<p class="date"><%=n.getEventStrtDt() %> ~ <%=n.getEventEndDt() %></p>	
								<% } else { %>
									<span class="flag type08 small">종료</span>
									<span class="txt">더놀자</span>										
								<% } %>																	
						</div>																							
					</a>																								
				</li> 	         		
         		
         	<% } %>

         <% } %>

	</ul>
	
	</div>

	
</body>
</html>