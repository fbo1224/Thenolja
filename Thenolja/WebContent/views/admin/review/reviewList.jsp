<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, thenolja.admin.review.model.vo.AdminReview, thenolja.common.model.vo.PageInfo" %>   
<%
	ArrayList<AdminReview> list = (ArrayList<AdminReview>)request.getAttribute("selectReviewMemberList");
%>    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <title>리뷰 목록</title>
 	<link rel="stylesheet" href="resources/css/admin_select.css">   
</head>
<body>
    
    <div id="wrap">
        <div id="header">
		
			<%@ include file="../../common/adminMenubar.jsp" %> 

        </div>
               
        <div id="content">
            <div id="content_1">

                <form action="#" method="get" id="search_member">
                    <div id="search_id">
                        <input type="text" placeholder="회원  ID입력" name="memId">
                    </div>
        
                    <div id="search_btn">
                        <button type="submit" class="btn btn-outline-info">검색</button>
                    </div>
                </form>

            </div>
            <div id="content_2">

                <div id="mem_list_header">

                    <div id="mem_title">
                        <h2>리뷰목록</h2>
                    </div>
        
                    <div id="mem_sort">
                        <select>
                            <option value="newest">최신순</option>
                            <option value="oldset">오래된순</option>
                        </select>
        
                    </div>
        
                </div>
        
                <div id="mem_list">
                    <table class="table table-hover">
                        <thead>
                          <tr>
                            <th>숙소이름</th>
                            <th>아이디</th>
                            <th>닉네임</th>
                            <th>작성일</th>
                            <th colspan="2"></th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td>마리안느 호텔</td>
                            <td>dlgPdls</td>
                            <td>이혜인</td>
                            <td>2024.01.11</td>
                            <td><button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#myModal">조회</button></td>
                          </tr>
                        </tbody>
                      </table>

                </div>
        
                <div class="paging-area" align="center";>
                    <button class="btn btn-sm btn-outline-secondary"><</button>
                    <button class="btn btn-sm btn-outline-secondary">1</button>
                    <button class="btn btn-sm btn-outline-secondary">2</button>
                    <button class="btn btn-sm btn-outline-secondary">3</button>
                    <button class="btn btn-sm btn-outline-secondary">4</button>
                    <button class="btn btn-sm btn-outline-secondary">5</button>
                    <button class="btn btn-sm btn-outline-secondary">></button>
                </div>
        

            </div>
        </div>
        <div id="footer"></div>

    </div>

 <!-- 회원 상세 조회 모달 -->
 <div class="modal" id="myModal">

    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
            <p class="modal-title"> 리뷰 상세 조회</p>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">

            <table>
                <tr>
                    <td colspan="5" rowspan="5" width="120" height="120" ><img src="https://cf.bstatic.com/xdata/images/hotel/max1280x900/82237660.jpg?k=cb5db13896d348f7c4b47e3922a6753f83b5c36ba7b71a6f820523d07365fc2c&o=&hp=1" alt="" width="120px"></td>
                    <td width="90">마리안느 호텔</td>
                    <td>오션뷰 1호실</td>
                    <td>⭐︎⭐︎⭐︎⭐︎⭐︎</td>
                </tr>
                <tr>
                    <td colspan="3">너무너무 좋았고 청결하고 바퀴벌레가 한마리 나오긴 했지만 발로 밟아 죽여버리니 상쾌한 기분으로 아침을 맞이할  수 있어 좋았어용 ^^.</td>
                </tr>

              </table>

            <div class="container">
                <form action="/action_page.php">
                  <div class="form-group">
                    <div><p>답글 작성</p></div>
                    <textarea class="form-control" rows="5" id="comment" name="text" cols="50"></textarea>
                  </div>
                  <button type="submit" class="btn btn-sm btn-outline-secondary" style="float: right;">등록하기</button>
                </form>
              </div>

        </div>

    
        
      </div>
    </div>
  </div>
  











</body>
</html>