package thenolja.tb_reservation.cotroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.tb_hotel.model.vo.Hotel;
import thenolja.tb_hotel.model.vo.Room;
import thenolja.tb_reservation.model.Service.ReserService;

/**
 * Servlet implementation class NonReservationInsertFormController
 */
@WebServlet("/nonInsertReservation")
public class NonReservationInsertFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NonReservationInsertFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
		int roomNo = Integer.parseInt(request.getParameter("roomNo"));		
		
		
		Hotel hotel = new ReserService().selectHotelNo(hotelNo);
		Room room = new ReserService().selectRoom(hotelNo, roomNo);
		
		if(hotel != null && room != null) {
			request.setAttribute("hotel", hotel);      
			request.setAttribute("room", room);
			
			RequestDispatcher view = request.getRequestDispatcher("views/reservation/nonInsertReservation.jsp");
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
