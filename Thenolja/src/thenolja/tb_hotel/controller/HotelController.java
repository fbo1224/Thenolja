package thenolja.tb_hotel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HotelController {

	public String insert(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		
		view="views/hotel/insertHotel.jsp";
		return view;
	}
	
	public String hotelList(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		
		view = "views/hotel/hotelList.jsp";
		return view;
	}
	
	public String update(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		
		
		return view;
	}
	
	
	public String select(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		
		view = "views/hotel/hotelDetail.jsp";
		return view;
	}
}
