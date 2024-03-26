<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../common/menubar.jsp" %>
<%
	//String contextPaths = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 등록 화면</title>

<!-- SmartEditor를 사용하기 위해서 다음 js파일을 추가(경로확인) -->
<script type="text/javascript" scr="<%=contextPath%>/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>
<!-- SmartEditor를 사용하기 위해서 다음 js파일을 추가(경로확인) -->
<script type="text/javascript" scr="http://code.jquery.com/jquery-1.9.0.min.js" charset="utf-8"></script>
<script type="text/javascript">
/**************************
* 함수설명 : 스마트에디터 기본 세팅
**************************/
/* var oEditors = [];
$(function(){
      nhn.husky.EZCreator.createInIFrame({
          oAppRef: oEditors,
          elPlaceHolder: "ir1", //textarea에서 지정한 id와 일치해야 합니다. 
          //SmartEditor2Skin.html 파일이 존재하는 경로
          sSkinURI: "/smarteditorSample/SE2/SmartEditor2Skin.html",  
          htParams : {
              // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
              bUseToolbar : true,             
              // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
              bUseVerticalResizer : true,     
              // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
              bUseModeChanger : true,         
              fOnBeforeUnload : function(){
                   
              }
          }, 
          fOnAppLoad : function(){
              //기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
              oEditors.getById["ir1"].exec("PASTE_HTML", ["기존 DB에 저장된 내용을 에디터에 적용할 문구"]);
          },
          fCreator: "createSEditor2"
      });
      
      //저장버튼 클릭시 form 전송
      $("#save").click(function(){
          oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
          $("#frm").submit();
      });    
}); *
 
/************************ 
* 함수설명 : 등록버튼 클릭 이벤트
*************************/ 
function regNotice(){
	
	var inptTitle   = $('#title').val();
	var inptContent = $('#txtArea_content').val();
	//var chkStatus   = $('#notice_status').val(); 
	var chkStatus = "Y"; 
	
	// 유효성 검사 함수 호출
	if(validation()){
		// confirm 함수는 확인창 결과값으로 TRUE와 FALSE 값을 RETURN 하게 됨.
		if(confirm("게시글을 등록하시겠습니까?")){	
		// 게시글 저장 submission 정보 세팅
		
		$.ajax({
			type: "POST",
			url : "<%=contextPath%>/regNotice",
			data : {title : inptTitle, content : inptContent, status : chkStatus},
			success:function(res){
				alert("게시글이 정상적으로 등록되었습니다.");
				location.href= "<%= contextPath %>/noticeList"
			},
			error:function(e){
				alert("게시글 등록중 오류가 발생하였습니다.");
				return;
			}
			
		});		
		
	    }
	}
}

/********************************* 
* 함수설명 : 공지사항 등록 시 유효성 검사
**********************************/
function validation(){
	// 각 필드 필수값 체크
	if($("#title").val() == ""){ 
		alert("제목을 입력하세요.");
		return;
	}
	if($("#txtArea_content").val() == ""){
		alert("내용을 입력해주세요.");
		return;
	}

	return true;
}

/*********************************** 
* 함수설명 : 공지사항 내용 글자 count하는 부분
************************************/
function countText(){

	var content = $("#txtArea_content").val();
	// 글자수 세기
	if(content.length == 0 || content == ''){
		$('#spn_textcount').text('0/1000');
	}else{
		$('#spn_textcount').text(content.length + '/1000');
	}
	
	// 글자 수 제한
	if(content.length > 1000){
		$("#txtArea_content").val($("#txtArea_content").val().substring(0, 1000));
		alert("공지사항은 1000자까지만 입력 가능합니다.");
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
	<form id="frm" action="<%=contextPath%>/regNotice" method="post">
		<table class="table-light table-striped text-center" width="100%">
			<tr>
				<td>제목</td>
				<td><input type="text" id="title" name="title" style="width:650px;"/></td>
			</tr>
       <tr>
            <td>내용</td>
            <td>
                <textarea rows="10" cols="30" id="txtArea_content" name="content" onkeyup="countText();"></textarea>
            </td>
        </tr>
        
        <tr>  
        	<td></td>   
            <td>
            	<span id="spn_textcount" style="float:right;margin-right:205px;" >0/1000</span>
            </td>
            <td></td>
        </tr>
                 
        <tr>
            <td colspan="2">
                <input type="button" id="save"   class="btn btn-primary" value="등록" onclick="regNotice();"/>
                <input type="button" id="cancle" class="btn btn-light"   value="취소" onclick="history.back();"/>
            </td>
        </tr>		
		</table>
	
	</form>
	<!-- FORM 영역 END -->

	</div>

</body>
</html>