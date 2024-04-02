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
import thenolja.tb_hotel.model.vo.Hotel;
import thenolja.tb_hotel.model.vo.Room;
import thenolja.tb_reservation.model.Service.ReserService;
import thenolja.tb_reservation.model.vo.Reservation;

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
		
		ArrayList<Coupon> list = new ReserService().selectCouponList();
		int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
		int roomNo = Integer.parseInt(request.getParameter("roomNo"));		
		
		request.setAttribute("insertReservation", list);
		Reservation reser = new Reservation();
		
		Hotel hotel = new ReserService().selectHotelNo(hotelNo);
		Room room = new ReserService().selectRoom(hotelNo, roomNo);
		
		if(hotel != null && room != null) {
		request.setAttribute("reser", reser);
		request.setAttribute("hotel", hotel);      
		request.setAttribute("room", room);
		//System.out.println(list);
		
		//response.sendRedirect("/views/reservation/insertReservation.jsp");
		RequestDispatcher view = request.getRequestDispatcher("/views/reservation/insertReservation.jsp");
		
		view.forward(request, response);
		} else {
			request.setAttribute("errorMsg", "숙소 조회를 실패하셨습니다.");
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
