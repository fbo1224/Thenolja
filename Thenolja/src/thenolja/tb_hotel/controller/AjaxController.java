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
	
	public Map<String, Object> deleteHotel(HttpServletRequest request, HttpServletResponse response) {
		int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
		
		int result = new HotelService().deleteHotel(hotelNo);
		ArrayList<HotelCard> hotelList = null;
		
		int listCount;   
		int currentPage; 
		int pageLimit;   
		int boardLimit;  
		
		int maxPage;     
		int startPage;  
		int endPage;
		
		
		listCount = new HotelService().selectListCountRoomIn();
	

		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
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
		
		if(result > 0) {
			hotelList = new HotelService().selectList(pi);
		}
		
		Map<String, Object> datas = new HashMap<>();
		
		datas.put("hotelList", hotelList);
		datas.put("pi", pi);
		
		return datas;
	}
	
	public String deleteRoom(HttpServletRequest request, HttpServletResponse response) {
		int roomNo = Integer.parseInt(request.getParameter("roomNo"));
		
		int result = new RoomService().deleteRoom(roomNo);
		
		String str = "삭제 실패";
		if(result > 0) {
			str = "삭제 성공";
		}
		
		return str;
		
	}
	
	
	public ArrayList<HotelCard> selectPopular(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<HotelCard> pList = new HotelService().selectPopular();
		
		return pList;
	}
	
	public ArrayList<HotelCard> locRecomData(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<HotelCard> rList = new HotelService().selectRecomData();

		return rList;
	}
	
	public List<String> searchLocation(HttpServletRequest request, HttpServletResponse response) {
		List<String> locList = new HotelService().selectLocation();
		
		return locList;
	}
	
	public ArrayList<Comment> commentAdmin(HttpServletRequest request, HttpServletResponse response) {
		int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
		ArrayList<Comment> cList = new HotelService().commentAdmin(hotelNo);
		
		return cList;
	}
	
	public Map<String, Object> reviewList(HttpServletRequest request, HttpServletResponse response) {
		
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
	
		Map<String, Object> datas = new HashMap<>();
		
		datas.put("reviewList", reviewList);
		datas.put("pi", pi);
		
		return datas;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
