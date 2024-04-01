package thenolja.tb_reservation.cotroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import thenolja.member.model.service.MemberService;
import thenolja.member.model.vo.Member;
import thenolja.nonmem.service.NonmemService;
import thenolja.tb_hotel.model.vo.Hotel;
import thenolja.tb_hotel.model.vo.Room;
import thenolja.tb_reservation.model.Service.ReserService;
import thenolja.tb_reservation.model.vo.Reservation;

/**
 * Servlet implementation class ReservationDetailController
 */
@WebServlet("/reserDetail")
public class ReservationDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		request.setCharacterEncoding("UTF-8");

		int reserNo = Integer.parseInt(request.getParameter("reserNo"));
		Reservation reser = new ReserService().selectReserNo(reserNo);
		System.out.println(reserNo);
	//	Hotel hotel = new ReserService().selectReserNo(reserNo);
	//	int memNo = Integer.parseInt(request.getParameter("memNo"));
	//	Member member = new MemberService().selectMember (memNo);
		// int memNo = Integer.parseInt(request.getParameter("memNo"));
		// Member member = new NonmemService().selectNonMemNo(memNo);
			
		if(reser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("reser", reser);
			RequestDispatcher view = request.getRequestDispatcher("views/reservation/detailReservation.jsp");
			view.forward(request, response);
			// response.sendRedirect("views/reservation/detailReservation.jsp");
			
		} else {
			request.setAttribute("errorMsg", "예약을 실패하셨습니다.");
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
