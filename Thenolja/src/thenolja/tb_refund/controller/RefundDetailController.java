package thenolja.tb_refund.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.tb_refund.model.service.RefundService;

/**
 * Servlet implementation class RefundDetailController
 */
@WebServlet("/detail.refund")
public class RefundDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefundDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int reserNo = Integer.parseInt(request.getParameter("reserNo"));
		
		int result = new RefundService().deleteReser(reserNo);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "수정이 완료되었습니다");
			request.getRequestDispatcher("views/common/menubar.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMsg", "실행이 취소되었습니다");
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
