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
/*
	var oEditors = [];
	$(function(){
      nhn.husky.EZCreator.createInIFrame({
          oAppRef: oEditors,
          elPlaceHolder: "ir1", //textarea에서 지정한 id와 일치해야 합니다. 
          //SmartEditor2Skin.html 파일이 존재하는 경로
          sSkinURI: "/TheNoleJa/WebContent/resources/SmartEditor2Skin.html",  
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
});
	
 */
 /************************ 
 * 함수설명 : 등록버튼 클릭 이벤트
 *************************/ 
 function regNotice(){
	 
 	console.log("title : " + $("#title").val() )
 	console.log("content : " + $("#txtArea_content").val() )
 	console.log("status : " + $("#status").val())
 	
 	var inptTitle   = $("#title").val();
 	var inptContent = $("#txtArea_content").val();
 	var chkStatus = $("#status").val();
 	
 	// 유효성 검사 함수 호출
 	if(validation()){
 		// confirm 함수는 확인창 결과값으로 TRUE와 FALSE 값을 RETURN 하게 됨.
 		if(confirm("게시글을 등록하시겠습니까?")){	
 			
 		// 게시글 저장 submission 정보 세팅
 		$.ajax({	
 			type : "POST",
 			url : "<%= contextPath %>/regNotice",
 			data : {title : inptTitle, content : inptContent, status : chkStatus},
 			success:function(data){
 				alert("정상적으로 게시글이 등록되었습니다.");
 				location.href="<%= contextPath %>/noticeList";
 			},
 			error:function(data){
 				alert("게시글 등록 중 오류가 발생하였습니다.");
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
 	if($("#status").val() == ""){
 		alert("노출여부를 선택해주세요.");
 		return;
 	}	
 	if($("#txtArea_content").val() == ""){
 		alert("내용을 입력해주세요.");
 		return;
 	}

 	return true;
 }
 
 
</script>
 
</head>
<body>

	

    <div class="outer">

        <h2 align="center">공지사항 작성하기</h2>
        <br><br>

        <form id="frm" action="<%= contextPath %>/regNotice" method="post" id="insert-form">
        
        	<%-- <input type="hidden" name="userNo" value="<%= loginUser.getUserNo() %>" /> --%>

            <div class="form-group">
                <label for="usr">제목</label>
                <input type="text" class="form-control" id="title" name="title">
            </div>
            
            
            <div class="form-group">
                <label for="comment">노출여부</label>
            
				<div class="input-group">
				  <div class="input-group-prepend">
				  </div>
				  <input type="radio" class="" id="status" name="status" value="Y">노출
				  <input type="radio" class="" id="status" name="status" value="N">비노출
				</div>            
            </div> 
            
            <div class="form-group">
                <label for="comment">내용</label>
                <textarea class="form-control" id="txtArea_content" name="content" rows="15" id="comment" style="resize:none;"></textarea>
            </div>

            <div align="center">
                <input type ="button" id="save"    class="btn btn-sm btn-info"      value="등록" onclick="regNotice();"/>
                <input type ="button"  id="cancle" class="btn btn-sm btn-secondary" value="취소" onclick="history.back();"/>
            </div>

        </form>
        
    </div>
</body>
</html>