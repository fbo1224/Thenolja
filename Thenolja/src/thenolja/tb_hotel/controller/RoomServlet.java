package thenolja.tb_hotel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RoomServlet
 */
@WebServlet("*.rooms")
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("*.rooms");
		
		String uri = request.getRequestURI();
		// 요청한 url 전부 보여줌
		System.out.println(uri);
		
		String mapping = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
		System.out.println(mapping);
		
		RoomController rc = new RoomController();
		String view = "";
		boolean flag = true;
		
		switch(mapping) {
			// insertRoom.jsp
			case "insertForm" : view =  rc.insert(request, response); break;
		
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
