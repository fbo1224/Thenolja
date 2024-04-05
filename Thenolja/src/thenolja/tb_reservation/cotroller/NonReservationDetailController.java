package thenolja.tb_reservation.cotroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.tb_reservation.model.Service.ReserService;
import thenolja.tb_reservation.model.vo.Reservation;

/**
 * Servlet implementation class NonReservationDetailController
 */
@WebServlet("/nonReserDetail")
public class NonReservationDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NonReservationDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 예약 리스트에서 상세조회로 가는 서블릿
		int reserNo = Integer.parseInt(request.getParameter("reserNo"));
		
		Reservation reser = new ReserService().selectReserNo(reserNo);
			
		if(reser != null) {
			request.setAttribute("reser", reser);
			
			RequestDispatcher view = request.getRequestDispatcher("views/reservation/nonDetailReservation.jsp");
			view.forward(request, response);
			// 이거 어떤방식으로 만든건지 묻기
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
