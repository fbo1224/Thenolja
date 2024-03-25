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
}
