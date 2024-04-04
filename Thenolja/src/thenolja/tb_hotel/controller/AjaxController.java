package thenolja.tb_hotel.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import thenolja.common.model.vo.PageInfo;
import thenolja.tb_hotel.model.service.HotelService;
import thenolja.tb_hotel.model.service.RoomService;
import thenolja.tb_hotel.model.vo.Comment;
import thenolja.tb_hotel.model.vo.HotelCard;
import thenolja.tb_hotel.model.vo.HotelReview;

public class AjaxController {
	
	public void deleteHotel(HttpServletRequest request, HttpServletResponse response) {
		int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
		
		// System.out.println(hotelNo);
		
		int result = new HotelService().deleteHotel(hotelNo);
		ArrayList<HotelCard> hotelList = null;
		
		int listCount;   // 현재 일반게시판의 게시글 총 개수 => BOARD테이블로 부터 COUNT(*)활용해서 조회
		int currentPage; // 현재 페이지(사용자가 요청한 페이지) => request.getParameter("currentPage");
		int pageLimit;   // 페이지 하단에 보여질 페이징바의 최대 개수 => 10개로 고정
		int boardLimit;  // 한 페이지에 보여질 게시글의 최대 개수 => 10개로 고정
		
		int maxPage;     // 가장 마지막 페이지가 몇 번 페이지인지 (총 페이지의 개수)
		int startPage;   // 페이지 하단에 보여질 페이징바의 시작 수
		int endPage;     // 페이지 하단에 보여질 페이징바의 끝 수
		
		
		listCount = new HotelService().selectListCountRoomIn();
	
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
		
		if(result > 0) {
			hotelList = new HotelService().selectList(pi);
		}
		
		response.setContentType("application/json; charset=UTF-8");
		Gson gson = new Gson();
		Map<String, Object> datas = new HashMap<>();
		
		datas.put("hotelList", hotelList);
		datas.put("pi", pi);
		
		try {
			gson.toJson(datas, response.getWriter());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteRoom(HttpServletRequest request, HttpServletResponse response) {
		int roomNo = Integer.parseInt(request.getParameter("roomNo"));
		
		int result = new RoomService().deleteRoom(roomNo);
		
		String str = "삭제 실패";
		if(result > 0) {
			str = "삭제 성공";
		}
		
		response.setContentType("text/html; charset=UTF-8");
		try {
			response.getWriter().print(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void selectPopular(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<HotelCard> pList = new HotelService().selectPopular();
		
		
		response.setContentType("application/json; charset=UTF-8");
		Gson gson = new Gson();
		
		try {
			gson.toJson(pList, response.getWriter());
		} catch (JsonIOException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void locRecomData(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<HotelCard> rList = new HotelService().selectRecomData();
		
		response.setContentType("application/json; charset=UTF-8");
		Gson gson = new Gson();
		
		try {
			gson.toJson(rList, response.getWriter());
		} catch (JsonIOException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void searchLocation(HttpServletRequest request, HttpServletResponse response) {
		List<String> locList = new HotelService().selectLocation();
		
		response.setContentType("text/html; charset=UTF-8");
		try {
			response.getWriter().print(locList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void commentAdmin(HttpServletRequest request, HttpServletResponse response) {
		int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
		ArrayList<Comment> cList = new HotelService().commentAdmin(hotelNo);
		
		response.setContentType("application/json; charset=UTF-8");
		Gson gson = new Gson();
		try {
			gson.toJson(cList, response.getWriter());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void reviewList(HttpServletRequest request, HttpServletResponse response) {
		
		int listCount;   
		int currentPage; 
		int pageLimit;   
		int boardLimit;  
		
		int maxPage;     
		int startPage;   
		int endPage;     
		
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
		
		listCount = new HotelService().countReview(hotelNo);
		
		pageLimit = 5;
		boardLimit = 6;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit,
								  maxPage, startPage, endPage);
		
		
		ArrayList<HotelReview> reviewList = new HotelService().reviewList(pi,hotelNo);
		
		response.setContentType("application/json; charset=UTF-8");
		Gson gson = new Gson();
		Map<String, Object> datas = new HashMap<>();
		
		datas.put("reviewList", reviewList);
		datas.put("pi", pi);
		
		try {
			gson.toJson(datas, response.getWriter());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
