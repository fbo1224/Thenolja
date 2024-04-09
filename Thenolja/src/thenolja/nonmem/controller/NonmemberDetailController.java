package thenolja.nonmem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.member.model.vo.Member;
import thenolja.nonmem.service.NonmemService;

/**
 * Servlet implementation class NonmemberDetailController
 */
@WebServlet("/nonmemDetail")
public class NonmemberDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NonmemberDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int reserNo = Integer.parseInt(request.getParameter("reserNo"));
		
		Member member = new NonmemService().selectNonMemNo(reserNo);
		
		
		
		if(member != null) {
			
			request.setAttribute("member", member);
			
			RequestDispatcher view = request.getRequestDispatcher("views/nonmem/nonDetailReservation.jsp");
			view.forward(request, response);
			
		} else {
			request.setAttribute("errorMsg", "예약을 실패하셨습니다.");
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
