package thenolja.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.member.model.service.MemberService;

/**
 * Servlet implementation class HeartSelectController
 */
@WebServlet("/selectHeart")
public class HeartSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeartSelectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		
		int selectHeart = new MemberService().selectHeart(hotelNo, memNo);
		
		response.setContentType("text/html; charset=UTF-8");
		
		response.getWriter().print(selectHeart);
		
		// System.out.println("hotelNo넘긴값 :" + hotelNo);
		// System.out.println("memNo넘긴값 :" + memNo);
		
		// System.out.println("결과값: " + selectHeart);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
