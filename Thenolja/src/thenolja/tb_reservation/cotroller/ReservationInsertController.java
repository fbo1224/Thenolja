  package thenolja.tb_reservation.cotroller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import thenolja.tb_coupon.model.vo.Coupon;
import thenolja.tb_hotel.model.vo.Hotel;
import thenolja.tb_hotel.model.vo.Room;
import thenolja.tb_reservation.model.Service.ReserService;
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
		
		String name = request.getParameter("memName");
		String phone = request.getParameter("memPhone");
		String bicycle = request.getParameter("bicycle");
		String checkIn = request.getParameter("checkIn");
		String checkOut = request.getParameter("checkOut");
		int people = Integer.parseInt(request.getParameter("people"));
		int roomNo = Integer.parseInt(request.getParameter("roomNo"));
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		int paymentPrice = Integer.parseInt(request.getParameter("paymentPrice"));
		int couponNo = Integer.parseInt(request.getParameter("couponNo"));
		
		// 3) 데이터 가공
		Reservation reser = new Reservation();
		reser.setName(name);
		reser.setPhone(phone);
		reser.setBicycle(bicycle);
		reser.setCheckIn(checkIn);
		reser.setCheckOut(checkOut);
		reser.setPeople(people);
		reser.setRoomNo(roomNo);
		reser.setReMemNo(memNo);
		reser.setPaymentPrice(paymentPrice);
		
		reser = new ReserService().insertReser(reser);
		System.out.println(reser);
		Coupon coupon = new ReserService().selectoCoupon(couponNo);
		
		// 여기까지 INSERT는 정상적으로 됐음.
		// 근데 detailReservation.jsp로 넘어갈 때 servlet을 통해서 유저 객체를 넘겨주어야함.
		
		if(reser != null && coupon != null) {
			
			// int reserNo = Integer.parseInt(request.getParameter("reserNo"));
			// DB하이 ~
		//
		//	reser = new ReserService().selectReservation();
			int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
			// Room room = new ReserService().updateRoom();
			
			Hotel hotel = new ReserService().selectHotelNo(hotelNo);
			Room room = new ReserService().selectRoom(hotelNo, roomNo);
				
			if(hotel != null && room != null && reser != null) {
				HttpSession session = request.getSession();
				session.setAttribute("reser", reser);
				session.setAttribute("hotel", hotel);
				session.setAttribute("room", room);
				session.setAttribute("coupon", coupon);

				response.sendRedirect(request.getContextPath() + "/reserDetail?reserNo=" + reser.getReserNo());
//			response.sendRedirect(request.getContextPath() + "/views/reservation/waitingPage.jsp");
				} else {
					request.setAttribute("errorMsg", "예약에 실패했습니다!");
					request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
					
					
				}
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
