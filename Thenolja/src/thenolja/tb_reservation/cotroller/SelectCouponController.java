package thenolja.tb_reservation.cotroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.tb_coupon.model.vo.Coupon;
import thenolja.tb_reservation.model.Service.ReserService;

/**
 * Servlet implementation class SelectCouponController
 */
@WebServlet("/selectCoupon")
public class SelectCouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectCouponController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Coupon> list = new ReserService().selectCouponList();
		request.setAttribute("insertReservation", list);
		//System.out.println(list);
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
