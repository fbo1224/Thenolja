package thenolja.tb_hotel.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import thenolja.common.MyFileRenamePolicy;
import thenolja.common.model.vo.PageInfo;
import thenolja.tb_hotel.model.service.HotelService;
import thenolja.tb_hotel.model.vo.DetailHotel;
import thenolja.tb_hotel.model.vo.Hotel;
import thenolja.tb_hotel.model.vo.HotelCard;

public class HotelController {

	public String insertForm(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		
		view="views/hotel/insertHotel.jsp";
		return view;
	}
	
	public int insert(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		int result = 0;
		if(ServletFileUpload.isMultipartContent(request)) {
			// loadName 도로명주소
			// detailAddr 상세주소
			// hotelCate 숙소종류
			// hotelName 호텔이름
			// phone1 == 010 /전화번호
			// phone2 == xxxxxxxx
			// serList 서비스 리스트 
			// introText 소개말
			// hotelImg 대표사진
			String savePath = request.getServletContext()
			         .getRealPath("/resources/hotelImage");
			
			int maxSize = 1024 * 1024 * 10;
			
			MultipartRequest multiRequest = null;
			
			try {
				multiRequest =
						new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			// String letterNo = multiRequest.getParameter("letterNo"); // 우편번호 제외
			String loadName = multiRequest.getParameter("loadName");
			String detailAddr = multiRequest.getParameter("detailAddr");
			String hotelCate = multiRequest.getParameter("hotelCate");
			String hotelName = multiRequest.getParameter("hotelName");
			String ceoName = multiRequest.getParameter("ceoName");
			String phone1 = multiRequest.getParameter("phone1");
			String phone2 = multiRequest.getParameter("phone2");
			String[] serList = multiRequest.getParameterValues("serList");
			String introText = multiRequest.getParameter("introText");
			
			// hotelImg 파일
			System.out.println(String.join(",", serList));
			
			// 지역만뽑기
			String location = loadName.substring(0, loadName.indexOf(" ")+1);
			
			// 지역을 제외한 
			String newlocation = loadName.substring(loadName.indexOf(" ")+1);
			
			Hotel h = new Hotel();
			h.setHotelName(hotelName);
			h.setHotelPhone(phone1+phone2);
			h.setHotelLocation(location); // 지역
			h.setHotelAddress(loadName +' '+ detailAddr);
			h.setHotelCategory(hotelCate);
			h.setHotelIntro(introText);
			h.setHostName(ceoName);
			// 서비스 목록
			h.setSerList(serList);
			
			if(multiRequest.getOriginalFileName("hotelImg") != null) {
				h.setHotelPath("resources/hotelImage/"+multiRequest.getFilesystemName("hotelImg"));
			}
			
			// System.out.println(h);
			
			result = new HotelService().insertHotel(h);
		}
		return result;
	}
	
	public String hotelList(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		
		int listCount;   // 현재 일반게시판의 게시글 총 개수 => BOARD테이블로 부터 COUNT(*)활용해서 조회
		int currentPage; // 현재 페이지(사용자가 요청한 페이지) => request.getParameter("currentPage");
		int pageLimit;   // 페이지 하단에 보여질 페이징바의 최대 개수 => 10개로 고정
		int boardLimit;  // 한 페이지에 보여질 게시글의 최대 개수 => 10개로 고정
		
		int maxPage;     // 가장 마지막 페이지가 몇 번 페이지인지 (총 페이지의 개수)
		int startPage;   // 페이지 하단에 보여질 페이징바의 시작 수
		int endPage;     // 페이지 하단에 보여질 페이징바의 끝 수
		
		String loginStatus = "";
		if(request.getParameter("loginStatus") != null) {
			loginStatus = request.getParameter("loginStatus"); 
		}
		
		if(loginStatus != null && loginStatus.equals("A")) {
			// * listCount : 총 게시글의 수
			listCount = new HotelService().selectListCount();
		} else {
			listCount = new HotelService().selectListCountRoomIn();
		}
		
	
		// * currentPage : 현재 페이지(사용자가 요청한 페이지)
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		System.out.println("currentPage"+ currentPage);
		
		// * pageList : 페이징바 최대 개수
		pageLimit = 5;
		
		// * boardLimit : 한 페이지에 보여질 게시글의 최대 개수
		boardLimit = 6;
		
		// * maxPage : 가장 마지막 페이지가 몇 번 페이지인지(총 페이지 개수)
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
	
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		// 3) VO로 가공
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit,
								  maxPage, startPage, endPage);
		// System.out.println(pi);
		
		// 4) Service 호출
		ArrayList<HotelCard> hotelList = null;
		if(loginStatus.equals("A")) {
			hotelList = new HotelService().selectAllList(pi);
			request.setAttribute("loginStatus", loginStatus);
		} else {
			hotelList = new HotelService().selectList(pi);
		}
		
		// 확인용 출력
		// System.out.println(hotelList);
		
		// 5) 응답화면 지정
		request.setAttribute("hotelList", hotelList);
		request.setAttribute("pageInfo", pi);
		
		view = "views/hotel/hotelList.jsp";
		return view;
	}
	
	public String updateForm(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		view="views/hotel/updateHotel.jsp";
		// loadName 도로명주소
		// detailAddr 상세주소
		// hotelCate 숙소종류
		// hotelName 호텔이름
		// phone1 == 010 /전화번호
		// phone2 == xxxxxxxx
		// serList 서비스 리스트 
		// introText 소개말
		// hotelImg 대표사진
		
		int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
		
		int result = new HotelService().updateForm(hotelNo);
		
		
		return view;
	}
	
	
	public String update(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		// 업데이트 데이터 가지고 업데이트 수행
		
		view = "";
		return view;
	}
	
	
	public String select(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
		// System.out.println(hotelNo);
		
		// 선택한 호텔 정보 가져오기
		DetailHotel dh =  new HotelService().selectHotel(hotelNo);

		// System.out.println(dh);
		
		if(dh != null) {
			// request에 가져온정보들 담기
			request.setAttribute("hotelDetail", dh);
			view = "views/hotel/hotelDetail.jsp";
			
		} else {
			request.setAttribute("errorMsg", "조회에 실패했습니다.");
			view = "views/common/errorPage.jsp";
		}
		
		
		return view;
	}
}
