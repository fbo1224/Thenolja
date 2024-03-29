  package thenolja.tb_reservation.cotroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import thenolja.member.model.service.MemberService;
import thenolja.member.model.vo.Member;
import thenolja.tb_hotel.model.vo.Hotel;
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
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		// int memNo = Integer.parseInt(request.getParameter("memNo"));
		// String payment = request.getParameter("payment");
		
		// 3) 데이터 가공
		Reservation reser = new Reservation();
		reser.setName(name);
		reser.setPhone(phone);
		reser.setBicycle(bicycle);
		reser.setMemNo(memNo);
		// reser.setReMemNo(memNo);
		// reser.setPayment(payment);d
		
		int result = new ReserService().insertReser(reser);
		
		// 여기까지 INSERT는 정상적으로 됐음.
		// 근데 detailReservation.jsp로 넘어갈 때 servlet을 통해서 유저 객체를 넘겨주어야함.
		
		if(result > 0) {
			
			// int reserNo = Integer.parseInt(request.getParameter("reserNo"));
			// DB하이 ~
				reser = new ReserService().selectReservation();

				HttpSession session = request.getSession();
				session.setAttribute("reser", reser);

				response.sendRedirect(request.getContextPath() + "/reserDetail?reserNo=" + reser.getReserNo());
//			response.sendRedirect(request.getContextPath() + "/views/reservation/waitingPage.jsp");
			
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
