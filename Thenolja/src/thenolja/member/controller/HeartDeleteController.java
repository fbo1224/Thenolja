package thenolja.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import thenolja.member.model.service.MemberService;

/**
 * Servlet implementation class HeartDeleteController
 */
@WebServlet("/deleteheart")
public class HeartDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeartDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		
		//System.out.println(hotelNo);
		//System.out.println(memNo);
		
		int count = new MemberService().heartDelete(hotelNo, memNo);
		
		if(count > 0) {
			HttpSession session = request.getSession();
			request.setAttribute("alertMsg", "찜 목록에서 삭제되었습니다.");
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
