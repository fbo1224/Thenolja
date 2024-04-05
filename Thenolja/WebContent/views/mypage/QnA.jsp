<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>자주 묻는 질문</title>

<style>
    div{border: 1px solid red;}
    #wrap{
        width: 900px;
        height: auto;
        margin: auto;
        margin-top: 100px;
    }

    #table{
        border: 1px solid ;
    }

    #title{
        font-size: 40px;
        font-weight: bold;
    }
</style>

</head>
<body>
	
	<%@ include file="../common/menubar.jsp"%>
	
    <div id="wrap">
        <div id="content" class="container">
            <table align="center" id="table" class="table table-hover">
                <thead>
                    <tr>
                        <th id="title">자주 묻는 질문</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td class="question">예약을 취소하고 싶어요</td>
                    </tr>
                    <tr>
                        <td class="answer">마이페이지 > 예약내역 > 예약내역 상세조회 > 환불하기 버튼으로 예약을 취소할 수 있습니다.</td>
                    </tr>
                    <tr>
                        <td class="question">프로필 사진 변경을 할 수 있나요?</td>
                    </tr>
                    <tr>
                        <td class="answer">사진 변경은 마이페이지 > 프로필 사진 클릭 > 바꾸고 싶은 사진 선택으로 하실 수 있습니다.</td>
                    </tr>
                    <tr>
                        <td class="question">쿠폰 적용은 어떻게 하나요?</td>
                    </tr>
                    <tr>
                        <td class="answer">쿠폰적용은 예약 화면에서 쿠폰 적용 버튼을 클릭하시면 됩니다.</td>
                    </tr>
                    <tr>
                        <td class="question">숙박업주인데 더놀자와 제휴 맺고 싶어요.</td>
                    </tr>
                    <tr>
                        <td class="answer">제휴문의는 메인페이지 하단의 더놀자 전화번호로 문의 주시기 바랍니다.</td>
                    </tr>
                </tbody>
            </table>

            <script>
                $('.answer').hide();

                if($('.question').click()
                
            </script>








        </div>
    </div>
	










</body>
</html>