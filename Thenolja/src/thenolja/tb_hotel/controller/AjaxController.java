package thenolja.tb_hotel.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.tb_hotel.model.service.HotelService;
import thenolja.tb_hotel.model.service.RoomService;

public class AjaxController {
	
	public void deleteHotel(HttpServletRequest request, HttpServletResponse response) {
		int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
		
		// System.out.println(hotelNo);
		
		int result = new HotelService().deleteHotel(hotelNo);
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
	
	
	public void searchData(HttpServletRequest request, HttpServletResponse response) {
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String location = request.getParameter("location");
		int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
		
		System.out.println(startDate);
		System.out.println(endDate);
		System.out.println(location);
		System.out.println(maxPeople);
		
		
	}
	
	public void searchLocation(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<String> locList = new HotelService().selectLocation();
		
		response.setContentType("text/html; charset=UTF-8");
		try {
			response.getWriter().print(locList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
