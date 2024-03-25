package thenolja.tb_hotel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RoomController {

	public String insertForm(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		
		int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
		request.setAttribute("hotelNo", hotelNo);
		
		view= "views/hotel/insertRoom.jsp";
		return view;
	}
	
	public String insert(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		
		request.getParameter("roomName");
		request.getParameter("maxPeople");
		
		// 사진 roomImg
		request.getParameter("in_time");
		request.getParameter("out_time");
		
		
		view="/";

		return view;		
	}
}
