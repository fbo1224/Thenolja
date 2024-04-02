<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList, thenolja.event.model.vo.Event" %>
   <%
	Event event   = (Event)request.getAttribute("event");
	String eventYn   = event.getEventYn();
	int eventNo 	= event.getEventNo();
  %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 수정/삭제 화면</title>
<style>
<style>
#txtArea_content{
	width:650px;
	height:350px;
}

.th_left{
    width:475px;
}

#spn_textcount{
	float:right;
}

#td_status_left{
	float:left;
	border: 1px solid #17a2b8;
}

#save{
    background: #17a2b8;
    color: #fff;
    border: 1px solid #17a2b8;

    /* background: cadetblue;
    color: #fff;
    border: 1px solid cadetblue; */
}


.radio-btn{
    position: relative;
    display: inline-block;
    margin: 5px 3px;
}

/* 게시여부 라디오버튼 영역 스타일적용 START */
.radio-btn-wrap{
	margin:-5px -4px;
	float:left;
}

.radio-btn{
	margin: 5px 4px;
}

.radio-btn-wrap .radio-btn input[type="radio"] {
    overflow: hidden;
    position: absolute;
    top: 0;
    left: 0;
    width: 0;
    height: 0;
    opacity: 0;
}

.radio-btn-wrap .radio-btn input[type="radio"]:checked + label{
    
    background: #17a2b8;
    color: #fff;
    border: 1px solid #17a2b8;
    
    /*background: cadetblue;
    color: #fff;
    border: 1px solid cadetblue;*/
}

.radio-btn-wrap .radio-btn label {
    display: block;
    height: 40px;
    padding: 0 15px;
    font-size: 16px;
    color: #636366;
    line-height: 38px;
    border: 1px solid #17a2b8;
    /*border: 1px solid cadetblue;*/
    border-radius: 24px;
    box-sizing: border-box;
    cursor: pointer;
}

	/* display: block;
    height: 40px;
    padding: 0 15px;
    font-size: 16px;
    color: #636366;
    line-height: 38px;
    border: 1px solid #aeaeb2;
    border-radius: 24px;
    box-sizing: border-box;
    cursor: pointer; */
/* 게시여부 라디오버튼 영역 스타일적용 END */

/* 첨부파일 영역 스타일적용 START */
.filebox{
	margin-top:8px;
}

.filebox label {
	float:left;
    display: inline-block;
    width: 140px;
    height: 48px;
    padding: 0 12px;
    color: #3a3a3d;
    font-size: 18px;
    line-height: 48px;
    border-radius: 4px;
    box-sizing: border-box;
    background-color: #9ca0a1;
    vertical-align: middle;
    cursor: pointer;
    text-align: center;
}

.filebox input[type="file"] {
    position: absolute;
    width: 0;
    height: 0;
    padding: 0;
    overflow: hidden;
    border: 0;
}

.filebox .upload-name {
    display: inline-block;
    padding: 0 32px 0 12px;
    background: none;
    vertical-align: middle;
    border: 0;
}

input[type="text"], input[type="password"] {
    width: 100%;
    height: 48px;
    padding: 0 16px;
    border-radius: 4px;
    background-color: #fafafa;
    color: #1a1d1d;
    font-size: 18px;
    line-height: 48px;
    box-sizing: border-box;
}

/* 삭제버튼 */
.btn-reset {
    display: none;
    position: absolute;
    top: 12px;
    right: 10px;
    width: 24px;
    height: 24px;
    background: url(../images/btn/btn_inp_reset.png) 0 0 no-repeat;
}

/* 첨부파일 영역 스타일적용 END */

</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>

<script type="text/javascript">
/**************************************************** 
* 함수설명 : 수정/삭제 클릭 이벤트
* 수정일자 : 2024.03.28
* 수정내용 : 수정,삭제 버튼 클릭 시 노출메시지 구분 값 및 변수 추가
*         유효성검사(validation함수 파라미터 추가)
*         수정 / 삭제인 경우 호출 URL 분리
*****************************************************/ 
function updEvent(eventYn){
	
	var inptTitle   = $('#title').val();
	var inptContent = $('#txtArea_content').val();
	var chkStatus   = $('input[name="status"]:checked').val();
	var confirmMsg;	// 수정, 삭제 버튼 클릭 시 확인 메시지
	
	
	if(typeof eventYn != "undefined"){
		if(eventYn == "UPD") confirmMsg = "이벤트를 수정하시겠습니까?";
		if(eventYn == "DEL") confirmMsg = "이벤트를 삭제하시겠습니까?";
	}
	
	// 유효성 검사 함수 호출
	if(validation(eventYn)){
		// confirm 함수는 확인창 결과값으로 TRUE와 FALSE 값을 RETURN 하게 됨.
		if(confirm(confirmMsg)){
		
		// 수정, 삭제부분 공통적인 부분 변수처리
		var eventNo = <%=eventNo%>;
		var mappingUrl;
		var dataObj;
		var rsltMsg;
		
		// 수정, 삭제인 경우 각각 데이터 세팅
		if(eventYn == "UPD"){
			mappingUrl  = "/updEvent";
			dataObj 	= {eventTitle : inptTitle, eventContent : inptContent, eventYn : chkStatus, writerNo: 1}
			rsltMsg     = "이벤트등록이 정상적으로 수정되었습니다.";
		}
		if(eventYn == "DEL"){
			mappingUrl  = "/delEvent";
			dataObj 	= {eventNo : eventNo}
			rsltMsg     = "이벤트등록이 정상적으로 삭제되었습니다.";
		}
		
		// 게시글 저장 submission 정보 세팅
		$.ajax({
			type : "POST",
			url  : "<%=contextPath%>" + mappingUrl,
			data : dataObj,
			
			// 정상적으로 처리되면 공지사항 목록으로 이동
			success:function(res){
				
				if(res == "SUCCESS"){
					location.href= "<%= contextPath %>/eventList"
					alert(rsltMsg);
				}else{
					alert("이벤트등록 수정/삭제 중 오류가 발생하였습니다.");
					return;					
				}
			},
			error:function(e){
				alert("이벤트등록 수정/삭제 중 오류가 발생하였습니다.");
				return;
			}
			
		});		
		
	    }
	}
}

/************************************* 
* 함수설명 : 공지사항 등록 시 유효성 검사(필수값)
* 수정내용 : 삭제버튼 클릭 시 유효성 검사 skip처리
**************************************/
function validation(eventYn){
	
	// 삭제버튼 클릭 시 skip 처리 함
	if(typeof eventYn != "undefined" && eventYn == "DEL") return true;
	
	// 각 필드 필수값 체크
	var content = $("#txtArea_content").val();
	
	// 공지사항 제목 체크
	if($("#title").val() == ""){ 
		alert("제목을 입력하세요.");
		$("#title").focus();
		return;
	}
	// 라디오버튼 (게시여부) 체크여부 확인
	if( !$('input[name="status"]').is(':checked') ){
		alert("이벤트진행여부를 선택해주세요.");
		return;
	}
	
	// 공지사항 내용 체크
	if($("#txtArea_content").val() == ""){
		alert("이벤트 내용을 입력해주세요.");
		$("#txtArea_content").focus();
		return;
	}	
	
	// 공지사항 제목 글자수 체크
	if($("#title").val().length > 30){ 
		alert("이벤트 제목은 최대 30자까지만 입력 가능합니다.");
		$("#title").focus();
		return;
	}	
	
	// 공지사항 내용 글자수 체크
	if(content.length > 400){
		$("#txtArea_content").val($("#txtArea_content").val().substring(0, 400));
		alert("이벤트게시글은 400자까지만 입력 가능합니다.");
		return;
	}
	return true;
}

/*********************************** 
* 함수설명 : 공지사항 내용 글자 count하는 부분
************************************/
function countText(){
 debugger
	var content = $("#txtArea_content").val();
	// 글자수 세기
	if(content.length == 0 || content == ''){
		$('#spn_textcount').text('0/400');
	}else{
		$('#spn_textcount').text(content.length + '/400');
	}
	
	// 글자 수 제한
	if(content.length > 400){
		$("#txtArea_content").val($("#txtArea_content").val().substring(0, 400));
		alert("이벤트게시글 400자까지만 입력 가능합니다.");
		return;
	}
}
</script>

</head>
<body>
	<div class="container">
	
	<!-- logo START -->
	<div id="logo" class="logo_main" align="center">
		<!-- <img id="main_logo" class="left_logo" src = "../../../../resources/img/TheNoleJa_Logo.png" alt="NoleJa_Logo"/> -->
	</div>
	<!-- logo END -->	
	
	<!-- FORM 영역 START -->
	<form id="frm" action="<%=contextPath%>/regEvent" method="post">
		<table class="table-light table-striped text-center" width="100%">
			<tr>
				<th class="th_left"><span>이벤트제목</span></th>
				<td><input type="text" id="title" name="title" maxlength="26" value="<%=event.getEventTitle()%>" style="width:650px;"/></td>
			</tr>
			
       <tr>
       		<!-- 게시여부 영역  STRT -->  <!-- notice.getStatus()  -->
           	<th class="th_left"><span>진행</span></th>
				<td>
					<div class="radio-btn-wrap" id="event_rdo_wrap">
						<span class="radio-btn">
								<!-- 조회 데이터 유무에 따른 처리  -->
								<% if(!"".equals(eventYn)) { %>
								
									<% if("Y".equals(eventYn)) { %>
										<input type="radio" id="rdo_statusY" name="status" checked="" value=" <%=eventYn %> ">
									<% } else { %>
										<input type="radio" id="rdo_statusY" name="status"value="Y">
									
									<% } %>
								
								<% } %>
								
								<label for="rdo_statusY">진행중</label>
						</span>
								
						<span class="radio-btn">
								<!-- 조회 데이터 유무에 따른 처리  -->
								<% if(!"".equals(eventYn)) { %>
									
									<% if("N".equals(eventYn)) { %>
										<input type="radio" id="rdo_statusN" name="status" checked="" value=" <%=eventYn %> ">
									<% } else { %>
										<input type="radio" id="rdo_statusN" name="status" value="N">
									<% } %>
								<% } %>
								
								<label for="rdo_statusN">종료</label>
						</span>
					</div>
	            </td>
            <!-- 게시여부 영역  END -->
            
        </tr>			
			
       <tr>
            <th><span>내용</span>	</th>
            <td>
                <textarea rows="10" cols="30" id="txtArea_content" name="content" onkeyup="countText();"><%= event.getEventContent() %></textarea>
            </td>
        </tr>
        
        <tr>  
        	<td></td>   
            <td>
            	<span id="spn_textcount">0/400</span>
                <script type="text/javascript">
                	countText();
                </script>
            </td>
            <td></td>
        </tr>
         
        <!-- 첨부파일 전체영역 START -->         
		<tr data-attr_seq="194" data-attr_disp_form_cd="FD" data-attr_calc_typ_cd="null" data-attr_mndt_inpt_yn="Y">	
			<th><span>사진</span></th>	
			
			<td>
				<div class="filebox">	
			
					<label for="file_110" tabindex="0">사진파일찾기</label>	
						<input type="file" id="file_110" name="fileUpload" data-file_id="110" tabindex="-1">	
						<input type="hidden" id="apndFileId_110" data-attr_item_sno="" data-prod_id="">	
					
					<!-- 업로드 영역 START -->
					<div class="upload-box">
						<input type="text" id="fileName_110" class="upload-name inp" placeholder="선택된 파일 없음" title="선택된 파일 없음" readonly="">
						<button type="button" class="btn-reset" id="fileReset"><span class="blind">삭제</span></button>	
					</div>
					<!-- 업로드 영역 END -->
				
				</div>
					<ul class="list-text interval bullet">	
						<!-- <li>허용 파일 형식 : pdf, jpg/jpeg, png, gif, doc/docx, hwp (15MB 미만)</li> -->
					</ul>	
			</td>
		</tr> 
		<!-- 첨부파일 전체영역 END -->                
                 
        <tr>
            <td colspan="2">
                <input type="button" id="save"   class="btn btn-primary" value="수정" onclick="updEvent('UPD');"/>
                <input type="button" id="save"   class="btn btn-primary" style="background-color:#eb008b; border-color:#eb008b;" value="삭제" onclick="updEvent('DEL')" />
                <input type="button" id="cancle" class="btn btn-light"   value="취소" onclick="history.back();"/>
            </td>
        </tr>		
		</table>
	
	</form>
	<!-- FORM 영역 END -->

	</div>





</body>
</html>