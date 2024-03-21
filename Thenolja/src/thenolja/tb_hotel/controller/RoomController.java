package thenolja.tb_hotel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RoomController {

	public String insert(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		
		view= "views/hotel/insertRoom.jsp";
		return view;
	}
}
