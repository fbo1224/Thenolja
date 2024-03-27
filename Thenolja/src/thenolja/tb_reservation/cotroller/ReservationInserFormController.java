package thenolja.tb_reservation.cotroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.member.model.vo.Member;
import thenolja.tb_coupon.model.vo.Coupon;
import thenolja.tb_reservation.model.Service.ReserService;

/**
 * Servlet implementation class insertReservation
 */
@WebServlet("/insertReservation")
public class ReservationInserFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationInserFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		ArrayList<Coupon> list = new ReserService().selectCoupon();
		
		request.setAttribute("insertReservation", list);
		//System.out.println(list);
		
		//response.sendRedirect("/views/reservation/insertReservation.jsp");
		RequestDispatcher view = request.getRequestDispatcher("/views/reservation/insertReservation.jsp");
		
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
