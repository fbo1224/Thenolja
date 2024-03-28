package thenolja.nonmem.controller;

import java.io.IOException;
import java.util.ArrayList;

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
		String nonmemPhone = request.getParameter("nonmemPhone");
	
		System.out.println(nonmemName);
		System.out.println(nonmemPhone);
		
		ArrayList<SelectNonmemReser> list = new NonmemService().selectNonmemReser(nonmemName, nonmemPhone);
		
		System.out.println(list);
		
		HttpSession session = request.getSession();
		session.setAttribute("nonmemReser", list);
		
		request.getRequestDispatcher("views\\nonmem\\selectNonmemReser.jsp").forward(request, response);
		/*if(result > 0) {
		} else {
			request.setAttribute("errorMsg", "조회된 결과가 없습니다.");
		}*/
		
	
	}
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
