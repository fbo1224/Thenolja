<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%--  <%
    	LoginUser loginuser = session
    	String adminNm = loginuser.getNickname;
    	int memNo = lgoinUser.getMemno;
    %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>더놀자 > 이벤트 > 등록</title>
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

.regc {
	display : none;
	float : center;
	

}



/* 첨부파일 영역 스타일적용 END */


</style>

<%@ include file="../common/menubar.jsp" %>

<script type="text/javascript">
	
	
/************************ 
* 함수설명 : 등록버튼 클릭 이벤트
*************************/ 
function regEvent(){

	var inptTitle = $('#title').val();
	var inptContent = $('#txtArea_content').val();
	var chkStatus   = $('input[name="status"]:checked').val();
	
	//유효성 검사 함수 호출
	if(validation()){
		// confirm 함수는 확인창 결과값으로 TRUE와 FALSE 값을 RETURN 하게 됨.
		if(confirm("게시글 등록하시겠습니까?")){
		// 게시글 저장 submission 정보 세팅	
		
		
		$.ajax({
			type:"POST",
			url : "<%=contextPath%>/eventReg",
			data : {eventTitle : inptTitle, eventContent : inptContent, eventYn : chkStatus, writerNo: 1},
			success:function(res){
			
			
			if(res == "SUCCESS"){
				alert("이벤트게시글이 정상적으로 등록되었습니다.");
				location.href="<%= contextPath%>/eventList"
					}else{
						alert("이벤트 등록 중 오류가 발생하였습니다.");
						return;
					}
				},
				error:function(e){
					alert("게시글 등록 중 오류가 발생하였습니다.");
					return;
				}
				
			});
			
			}
		}
}	
	
/********************************* 
* 함수설명 : 이벤트 등록 시 유효성 검사(필수값)
**********************************/
function validation(){
	
	// 각 필드 필수값 체크
	var content = $("#txtArea_content").val();
	
	// 이벤트 제목 체크
	if($("#title").val() == ""){ 
		alert("제목을 입력하세요.");
		$("#title").focus();
		return;
	}
	// 라디오버튼 (게시여부) 체크여부 확인
	if( !$('input[name="status"]').is(':checked') ){
		alert("이벤트 진행상태를 선택해주세요.");
		return;
	}

	// 이벤트 내용 체크
	if($("#txtArea_content").val() == ""){
		alert("이벤트 내용을 입력해주세요.");
		$("#txtArea_content").focus();
		return;
	}	
	
	// 이벤트 제목 글자수 체크
	if($("#title").val().length > 30){ 
		alert("이벤트 제목은 최대 30자까지만 입력 가능합니다.");
		$("#title").focus();
		return;
	}
	
	// 이벤트 내용 글자수 체크
	if(content.length > 400){
		$("#txtArea_content").val($("#txtArea_content").val().substring(0, 400));
		alert("이벤트내용은 400자까지만 입력 가능합니다.");
		return;
	}
	return true;
}

/*********************************** 
* 함수설명 : 이벤트 내용 글자 count하는 부분
************************************/
function countText(){

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
		alert("이벤트등록은 400자까지만 입력 가능합니다.");
		return;
	}
}	
	
	
</script>
</head>
<body>

<br><br><br>

	<div class="container">
		<!-- logo START -->
			<div id="logo" class="logo_main" align="center"></div>
		<!-- logo END -->	

		<!-- form태그 시작 -->
		<form id="frm" action="<%=contextPath%>/regEvent" method="post">
		   <table class="table-light table-striped text-center" width="100%">
			  <tr>
				 <th class="th_left"><span>이벤트제목</span></th>
				 <td><input type="text" id="title" name="title" maxlength="26" style="width:650px;"/></td>
			  </tr>
			  
			  	<!-- 게시여부 영역  STRT -->
           		<th class="th_left"><span>이벤트상태여부</span></th>
				<td>
					<div class="radio-btn-wrap" id="event_rdo_wrap">
						<span class="radio-btn">
							<input type="radio" id="rdo_statusY" name="status" checked="" value="Y">	
								<label for="rdo_statusY">진행</label>
						</span>
								
						<span class="radio-btn">	
							<input type="radio" id="rdo_statusN" name="status" value="N">	
								<label for="rdo_statusN">종료</label>
						</span>
					</div>
	            </td>
            <!-- 게시여부 영역  END -->
			  	
  		<!-- 이벤트 내용 -->
  		
  		
 		  <tr>
            <th><span>이벤트 내용</span>	</th>
            <td>
                <textarea rows="10" cols="30" id="txtArea_content" name="content" onkeyup="countText();"></textarea>
            </td>
        </tr>
        
        <tr>  
        	<td></td>   
            <td>
            	<span id="spn_textcount">0/400</span>
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
						<input type="text" id="fileName_110" class="upload-name inp" placeholder="선택된 사진파일 없음" title="선택된 사진파일 없음" readonly="">
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
  		
 <!-- 
 		<h6>이벤트 등록정보</h6>
 		관리자명 :admin 
 		관리자 번호 :  
		이벤트기간 :  -->
		<tr>
			<td>시작 : <input type="datetime-local" name="datetime-local"></td>
		</tr>
		<tr>
			<td>끝  : <input type="datetime-local" name="datetime-local"></td>
		</tr>
		<!--년도,월,일 /오전/오후 시,분을 입력 받을 수 있는 텍스트 상자 -->
		</table>
	
	<table>
		<tr>
			<td colspan="2" id="">
			<input type="button" id="reg"    class="btn btn-primary" value="등록" onclick="regEvent();">
			<input type="button" id="cancel" class="btn btn-primary" value="취소" onclick="history.back();">
			</td>
		</tr>
	</table>
</form>
<!-- form태그 끝 -->	
	
	
	
	
	
	
	
	
	
	
	

 

</body>
</html>