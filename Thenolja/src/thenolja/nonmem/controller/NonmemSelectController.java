package thenolja.nonmem.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import thenolja.nonmem.model.vo.SelectNonmemReser;
import thenolja.nonmem.service.NonmemService;

/**
 * Servlet implementation class NonmemberSelectController
 */
@WebServlet("/selectNonmem")
public class NonmemSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NonmemSelectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nonmemName = request.getParameter("nonmemName");
		int nonmemNo = Integer.parseInt(request.getParameter("nonmemNo"));
	
		// System.out.println(nonmemName);
		// System.out.println(nonmemNo);
		ArrayList<SelectNonmemReser> list = new NonmemService().selectNonmemReser(nonmemName, nonmemNo);
		
		// System.out.println(list);
		
		HttpSession session = request.getSession();
		session.setAttribute("nonmemReser", list);
		
		
		if(!list.isEmpty()) {
			request.getRequestDispatcher("views\\nonmem\\nonDetailReservation.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMsg", "예약된 내역이 없습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
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
