package thenolja.tb_hotel.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import thenolja.common.MyFileRenamePolicy;
import thenolja.common.model.vo.PageInfo;
import thenolja.member.model.vo.Member;
import thenolja.tb_hotel.model.service.HotelService;
import thenolja.tb_hotel.model.vo.DetailHotel;
import thenolja.tb_hotel.model.vo.Hotel;
import thenolja.tb_hotel.model.vo.HotelCard;
import thenolja.tb_hotel.model.vo.SearchData;
import thenolja.tb_hotel.model.vo.SearchOptions;

public class HotelController {

	public String insertForm(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		
		view="views/hotel/insertHotel.jsp";
		return view;
	}
	
	public String insert(HttpServletRequest request, HttpServletResponse response, Member loginUser) {
		String view = "";
		int result = 0;
		
		if(ServletFileUpload.isMultipartContent(request)) {
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
			
			String loadName = multiRequest.getParameter("loadName");
			String detailAddr = multiRequest.getParameter("detailAddr");
			String hotelCate = multiRequest.getParameter("hotelCate");
			String hotelName = multiRequest.getParameter("hotelName");
			String ceoName = multiRequest.getParameter("ceoName");
			String phone1 = multiRequest.getParameter("phone1");
			String phone2 = multiRequest.getParameter("phone2");
			String[] serList = multiRequest.getParameterValues("serList");
			String introText = multiRequest.getParameter("introText");
			
			
			if(loadName.equals("")) {
				request.setAttribute("errorMsg", "호텔 주소가 올바르지 않습니다.");
				view="views/common/errorPage.jsp";
				return view;
			}
			
			// 지역만뽑기
			String location = loadName.substring(0, loadName.indexOf(" ")).trim();
			
			Hotel h = new Hotel();
			h.setHotelName(hotelName);
			h.setHotelPhone(phone1+phone2);
			h.setHotelLocation(location);  // 지역
			h.setHotelAddress(loadName);   // 주소
			h.setHotelDetail(detailAddr);  // 상세주소
			h.setHotelCategory(hotelCate);
			h.setHotelIntro(introText);
			h.setHostName(ceoName);
			// 서비스 목록
			h.setSerList(serList);
			
			if(multiRequest.getOriginalFileName("hotelImg") != null) {
				h.setHotelPath("resources/hotelImage/"+multiRequest.getFilesystemName("hotelImg"));
			}

			
			result = new HotelService().insertHotel(h);
		}
		if(result > 0) {
			view = request.getContextPath() + "/hotelList.hotels?currentPage=1&loginStatus="+loginUser.getMemStatus();
		}
		else {
			request.setAttribute("errorMsg", "hotel 추가 실패...");
			view="views/common/errorPage.jsp";	
		}
		return view;
	}
	
	public String hotelList(HttpServletRequest request, HttpServletResponse response, Member loginUser) {
		String view = "";
		
		int listCount;   // 현재 일반게시판의 게시글 총 개수 => BOARD테이블로 부터 COUNT(*)활용해서 조회
		int currentPage; // 현재 페이지(사용자가 요청한 페이지) => request.getParameter("currentPage");
		int pageLimit;   // 페이지 하단에 보여질 페이징바의 최대 개수 => 10개로 고정
		int boardLimit;  // 한 페이지에 보여질 게시글의 최대 개수 => 10개로 고정
		
		int maxPage;     // 가장 마지막 페이지가 몇 번 페이지인지 (총 페이지의 개수)
		int startPage;   // 페이지 하단에 보여질 페이징바의 시작 수
		int endPage;     // 페이지 하단에 보여질 페이징바의 끝 수
		
		
		
		if(loginUser != null && loginUser.getMemStatus().equals("A")) {
			// listCountRoomIn : 객실이 하나라도 있는 호텔의 총 갯수
			listCount = new HotelService().selectListCountRoomIn();
		} else {
			// listCount : 총 게시글의 수
			listCount = new HotelService().selectListCount();
		}
		
		// * currentPage : 현재 페이지(사용자가 요청한 페이지)
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
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

		// 4) Service 호출
		ArrayList<HotelCard> hotelList = null;
		if(loginUser != null && loginUser.getMemStatus().equals("A")) {
			hotelList = new HotelService().selectAllList(pi);
			request.setAttribute("loginStatus", loginUser.getMemStatus());
		} else {
			hotelList = new HotelService().selectList(pi);
		}
		
		// 5) 응답화면 지정
		request.setAttribute("hotelList", hotelList);
		request.setAttribute("pageInfo", pi);
		
		view = "views/hotel/hotelList.jsp";
		return view;
	}
	
	public String updateForm(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
		Hotel h = new Hotel();
		h = new HotelService().updateForm(hotelNo);
		
		if(h != null) {
			request.setAttribute("hotelInfo", h);
			view="views/hotel/updateHotel.jsp";
		} else {
			request.setAttribute("errorMsg", "조회에 실패했습니다.");
			view = "views/common/errorPage.jsp";
		}
		
		return view;
	}
	
	
	public String update(HttpServletRequest request, HttpServletResponse response, Member loginUser) {
		Hotel h = null;
		int result = 0;
		String view = "";

		if(ServletFileUpload.isMultipartContent(request)) {
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
			
			int hotelNo = Integer.parseInt(multiRequest.getParameter("hotelNo"));
			String loadName = multiRequest.getParameter("loadName");
			String detailAddr = multiRequest.getParameter("detailAddr");
			String hotelCate = multiRequest.getParameter("hotelCate");
			String hotelName = multiRequest.getParameter("hotelName");
			String ceoName = multiRequest.getParameter("ceoName");
			String phone1 = multiRequest.getParameter("phone1");
			String phone2 = multiRequest.getParameter("phone2");
			String[] serList = multiRequest.getParameterValues("serList");
			String introText = multiRequest.getParameter("introText");
			String beforeImgPath = multiRequest.getParameter("beforeImgPath");
			
			// 지역만뽑기
			String location = loadName.substring(0, loadName.indexOf(" ")).trim();
			
			h = new Hotel();
			h.setHotelName(hotelName);
			h.setHotelPhone(phone1+phone2);
			h.setHotelLocation(location); // 지역
			h.setHotelAddress(loadName);
			h.setHotelDetail(detailAddr);
			h.setHotelCategory(hotelCate);
			h.setHotelIntro(introText);
			h.setHostName(ceoName);
			h.setHotelPath(beforeImgPath);
			h.setHotelNo(hotelNo);
			
			// 서비스 목록
			h.setSerList(serList);
			
			String beforeImgName = beforeImgPath.substring(h.getHotelPath().lastIndexOf("/") + 1);
			
			if(multiRequest.getOriginalFileName("hotelImg") != null) {
				h.setHotelPath("resources/hotelImage/" + multiRequest.getFilesystemName("hotelImg"));
				new File(savePath + "/" + beforeImgName).delete();
			}
		}
		
		result = new HotelService().updateHotel(h);
		
		if(result > 0) {
			view = request.getContextPath() + "/hotelList.hotels?currentPage=1&loginStatus="+loginUser.getMemStatus();
		} else {
			request.setAttribute("errorMsg", "호텔정보 수정에 실패했습니다.");
			view = "views/common/errorPage.jsp";
		}
		return view;
	}
	
	public String select(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
		String daterange = "";
		String location = "";
		int maxPeople = 0;
		SearchData searchData = null;
		
		if(request.getParameter("daterange") != null &&
		   request.getParameter("location").trim() != null &&
		   request.getParameter("people") != null
		  ) {
			daterange = request.getParameter("daterange");
			location = request.getParameter("location").trim();
			maxPeople = Integer.parseInt(request.getParameter("people"));
			
			searchData = new SearchData();
			searchData.setDaterange(daterange);
			searchData.setLocation(location);
			searchData.setMaxPeople(maxPeople);
			request.setAttribute("searchData", searchData);
		}

		// 선택한 호텔 정보 가져오기
		DetailHotel dh =  new HotelService().selectHotel(hotelNo);
		
		if(dh != null) {
			request.setAttribute("hotelDetail", dh);
			view = "views/hotel/hotelDetail.jsp";
			
		} else {
			request.setAttribute("errorMsg", "조회에 실패했습니다.");
			view = "views/common/errorPage.jsp";
		}
		return view;
	}
	
	//
	public String searchList(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		
		String daterange = request.getParameter("daterange");
		String location = request.getParameter("location").trim();
		int maxPeople = Integer.parseInt(request.getParameter("people"));
		
		SearchData searchData = new SearchData();
		searchData.setDaterange(daterange);
		searchData.setLocation(location);
		searchData.setMaxPeople(maxPeople);
		
		String startDate = daterange.substring(0,daterange.indexOf(" "));
		String endDate = daterange.substring(daterange.lastIndexOf(" ") + 1);
		SearchOptions so = new SearchOptions();
		
		if(daterange.equals("")) {
			request.setAttribute("errorMsg", "날짜를 꼭 선택해주세요.");
			view = "views/common/errorPage.jsp";
			return view;
		}
		
		int listCount;
		int currentPage;
		int pageLimit;   
		int boardLimit;  
		
		int maxPage;     
		int startPage;   
		int endPage;
		
		listCount = new HotelService().searchListCount(startDate,endDate,location,maxPeople);
		
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		pageLimit = 5;
		
		boardLimit = 6;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
	
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		// 3) VO로 가공
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit,
								  maxPage, startPage, endPage);
		
		so.setMaxPeople(maxPeople);
		so.setLocation(location);
		so.setStartDate(startDate);
		so.setEndDate(endDate);
	
		ArrayList<HotelCard> sList = new HotelService().searchList(so, pi);
		
		// 응답 경로 지정
		request.setAttribute("sList", sList);
		request.setAttribute("pageInfo", pi);
		request.setAttribute("searchData", searchData);
		view = "views/hotel/searchList.jsp";
		return view;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
