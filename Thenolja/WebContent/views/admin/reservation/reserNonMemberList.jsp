<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>비회원 예약 목록</title>
   	
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
                        <input type="text" placeholder="예약자명 입력" name="memId">
                    </div>
        
                    <div id="search_btn">
                        <button type="submit" class="btn btn-outline-info">검색</button>
                    </div>
                </form>

            </div>
            <div id="content_2">

                <div id="mem_list_header">

                    <div id="mem_title">
                        <h2>비회원 예약 목록</h2>
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
                            <th>예약번호</th>
                            <th>예약자명</th>
                            <th>전화번호</th>
                            <th colspan="2"></th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td>3</td>
                            <td>이혜인</td>
                            <td>01020082008</td>
                            <td><button class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#myModal">조회</button></td>
                            <td><button class="btn btn-sm btn-outline-secondary">환불처리</button></td>
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
            <p class="modal-title"> 예약 상세 정보</p>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
            <table>
                <tr>
                    <td colspan="5" rowspan="5" width="120" height="120" ><img src="https://cf.bstatic.com/xdata/images/hotel/max1280x900/82237660.jpg?k=cb5db13896d348f7c4b47e3922a6753f83b5c36ba7b71a6f820523d07365fc2c&o=&hp=1" alt="" width="120px"></td>
                    <td width="200">마리안느 호텔</td>
                    <td>이동방식 : 차량</td>
                </tr>
                <tr>
                    <td>인원수 : 2명</td>
                    <td>예약일 : 2024.03.15</td>
                </tr>
                <tr>
                    <td>체크인 : 2024.03.23</td>
                    <td>체크아웃 : 2024.03.25</td>
                </tr>
    
                <tr>
                    <td>결제방식 : 계좌이체</td>
                    <td>금액 : 100000</td>
                </tr>

              </table>

        </div>

    
        
      </div>
    </div>
  </div>
  











</body>
</html>