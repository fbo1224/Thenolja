package thenolja.tb_hotel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HotelServlet
 */
@WebServlet("*.hotels")
public class HotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("*.hotels");
		
		String uri = request.getRequestURI();
		// 요청한 url 전부 보여줌
		System.out.println(uri);
		
		String mapping = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
		System.out.println(mapping);
		
		HotelController hc = new HotelController();
		String view = "";
		boolean flag = true;
		
		switch(mapping) {
		case "insert" : view =  hc.insert(request, response); break;
		case "hotelList" : view =  hc.hotelList(request, response); break;
		case "update" : view =  hc.update(request, response); flag = false; break;
		case "select" : view =  hc.select(request, response); break;
		case "insertRooms" : view =  hc.insertRooms(request, response); break;
		}
		
		if(flag) {
			request.getRequestDispatcher(view).forward(request, response);
			
		} else {
			response.sendRedirect(view);
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