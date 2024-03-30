package thenolja.tb_hotel.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.tb_hotel.model.service.HotelService;

/**
 * Servlet implementation class AjaxController
 */
@WebServlet("*.jqAjax")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();

		String mapping = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
		
		AjaxController ac = new AjaxController();
		
		switch(mapping) {
			case "deleteHotel" : ac.deleteHotel(request, response); break;
			case "deleteRoom"  : ac.deleteRoom(request, response); break;
			case "popularData" : ac.selectPopular(request, response); break;
			case "locRecomData" : ac.locRecomData(request, response); break;
			
			case "searchLocation" : ac.searchLocation(request, response); break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
