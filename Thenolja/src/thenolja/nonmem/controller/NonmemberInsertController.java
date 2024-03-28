package thenolja.nonmem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.tb_refund.model.vo.Refund;
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
		
		String name = request.getParameter("memName");
		String phone = request.getParameter("memPhone");
		
		// 3) 데이터 가공
		Reservation reser = new Reservation();
		reser.setName(name);
		reser.setPhone(phone);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
