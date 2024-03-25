package thenolja.tb_refund.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import thenolja.tb_refund.model.service.RefundService;
import thenolja.tb_refund.model.vo.Refund;

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
		
		Refund refund = new Refund();
		refund.setAccNo(accNo);
		refund.setRefundName(refundName);
		refund.setBank(bankName);
		
		int result = new RefundService().insertRefund(refund);
		
		//response.setContentType("text/html); charset=UTF-8");
		
		//response.getWriter().print(accNo, refundName, bankName);
		
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(refund, response.getWriter());
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
