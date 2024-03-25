package thenolja.tb_refund.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import thenolja.tb_refund.model.service.RefundService;
import thenolja.tb_refund.model.vo.Refund;
import thenolja.tb_reservation.model.Service.ReserService;

/**
 * Servlet implementation class RefundUpdateController
 */
@WebServlet("/refund.insert")
public class RefundUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefundUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int accNo = Integer.parseInt(request.getParameter("accNo"));
		String refundName = request.getParameter("refundName");
		String bankName = request.getParameter("bankName");
		
		// 3) 데이터 가공
		Refund refund = new Refund();
		refund.setAccNo(accNo);
		refund.setRefundName(refundName);
		refund.setBank(bankName);
		
		int result = new RefundService().insertRefund(refund);
		
		
		if(result > 0) {
			
			refund = new RefundService().selectRefund();
			
			HttpSession session = request.getSession();
			session.setAttribute("refund", refund);
			
			response.sendRedirect(request.getContextPath() + "/refundDetail?reserNo=" + refund.getReserNo());
			
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
