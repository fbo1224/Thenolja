package thenolja.tb_reservation.cotroller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.tb_reservation.model.vo.Reservation;

/**
 * Servlet implementation class ReservationInsertController
 */
@WebServlet("/insert.reser")
public class ReservationInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String memName = request.getParameter("name");
		String phone = request.getParameter("phone");
		String bicycle = request.getParameter("bicycle");
		int couponNo = Integer.parseInt(request.getParameter("couponNo"));
		String payment = request.getParameter("payment");
		
		
		// 3) 데이터 가공
		Reservation reser = new Reservation();

	
		
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
