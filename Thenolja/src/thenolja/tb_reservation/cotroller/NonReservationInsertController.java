package thenolja.tb_reservation.cotroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import thenolja.member.model.vo.Member;
import thenolja.nonmem.service.NonmemService;
import thenolja.tb_hotel.model.vo.Hotel;
import thenolja.tb_hotel.model.vo.Room;
import thenolja.tb_reservation.model.Service.ReserService;
import thenolja.tb_reservation.model.vo.Reservation;

/**
 * Servlet implementation class NonReservationInsertController
 */
@WebServlet("/insertNon.reser")
public class NonReservationInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NonReservationInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("nonMemName");
		String phone = request.getParameter("nonMemPhone");
		String bicycle = request.getParameter("bicycle");
		int roomNo = Integer.parseInt(request.getParameter("roomNo"));
		
		Member nonmem = new Member();
		nonmem.setMemName(name);
		nonmem.setMemPhone(phone);
		nonmem = new NonmemService().insertNonMember(nonmem);
		
		int memNo = nonmem.getMemNo();
		
		Reservation reser = new Reservation();
		reser.setName(name);
		reser.setPhone(phone);
		reser.setBicycle(bicycle);
		reser.setRoomNo(roomNo);
		reser.setMemNo(memNo);
		
		reser = new ReserService().insertReser(reser);
		if(nonmem != null && reser != null ) {
			
			int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
			Hotel hotel = new ReserService().selectHotel();
			Room room = new ReserService().selectRoom(hotelNo, roomNo);
			
			if(hotel != null && room != null) {
				HttpSession session = request.getSession();
				session.setAttribute("reser", reser);
				session.setAttribute("nonmem", nonmem);
				session.setAttribute("hotel", hotel);
				session.setAttribute("room", room);
				
				response.sendRedirect(request.getContextPath() + "/nonReserDetail?reserNo=" + reser.getReserNo() + "&hotelNo=" + hotel.getHotelNo() +"&roomNo=" + room.getRoomNo());
				
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
