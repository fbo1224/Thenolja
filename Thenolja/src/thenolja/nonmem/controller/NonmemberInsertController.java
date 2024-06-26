package thenolja.nonmem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import thenolja.member.model.vo.Member;
import thenolja.nonmem.service.NonmemService;
import thenolja.tb_refund.model.vo.Refund;
import thenolja.tb_reservation.model.Service.ReserService;
import thenolja.tb_reservation.model.vo.Reservation;

/**
 * Servlet implementation class NonmemberInsertController
 */
@WebServlet("/insert.nonMem")
public class NonmemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NonmemberInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("nonMemName");
		String phone = request.getParameter("nonMemPhone");
		
		Member nonmem = new Member();
		nonmem.setMemName(name);
		nonmem.setMemPhone(phone);
		
		int result = new NonmemService().insertNonMem(nonmem);
		if(result > 0) {
			
					
			HttpSession session = request.getSession();
			session.setAttribute("nonmem", nonmem);
			
			response.sendRedirect(request.getContextPath() + "/nonmemDetail?memNo=" + nonmem.getMemNo());
			
		} else {
			request.setAttribute("errorMsg", "예약에 실패했습니다!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
