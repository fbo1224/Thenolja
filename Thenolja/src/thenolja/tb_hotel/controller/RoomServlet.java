package thenolja.tb_hotel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import thenolja.member.model.vo.Member;

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
		String uri = request.getRequestURI();
		
		String mapping = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
		
		RoomController rc = new RoomController();
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		String view = "";
		boolean flag = true;
		if(loginUser != null && loginUser.getMemStatus().equals("A")) {
			switch(mapping) {
				case "insertForm" : view =  rc.insertForm(request, response); break;
				case "insert" : view =  rc.insert(request, response); break;
				case "updateListForm" : view =  rc.updateListForm(request, response); break;
				case "updateRoomForm" : view =  rc.updateRoomForm(request, response); break;
				case "updateRoom" : view =  rc.updateRoom(request, response); break;
				case "deleteListForm" : view = rc.deleteListForm(request, response); break;
			}
		
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
