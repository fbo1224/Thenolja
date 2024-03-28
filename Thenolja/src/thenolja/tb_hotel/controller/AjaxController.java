package thenolja.tb_hotel.controller;

import java.io.IOException;

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
	
	
}
