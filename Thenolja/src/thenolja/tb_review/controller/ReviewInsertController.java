package thenolja.tb_review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.tb_hotel.model.service.HotelService;
import thenolja.tb_hotel.model.vo.Hotel;
import thenolja.tb_hotel.model.vo.Room;
import thenolja.tb_reservation.model.Service.ReserService;
import thenolja.tb_reservation.model.vo.Reservation;

/**
 * Servlet implementation class ReviewInsertController
 */
@WebServlet("/review.insert")
public class ReviewInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int reserNo = Integer.parseInt(request.getParameter("reserNo"));
		int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
	//	int roomNo = Integer.parseInt(request.getParameter("roomNo"));
		// int score = Integer.parseInt(request.getParameter("starScore"));
		
		// System.out.println(score);
		
		Reservation reser = new ReserService().selectReserNo(reserNo);
		Hotel hotel = new ReserService().selectHotelNo(hotelNo);
	//	Room room = new ReserService().selectRoomNo(roomNo, hotelNo);
		
		if(reser != null && hotel != null) {
			request.setAttribute("reser", reser);
			request.setAttribute("hotel", hotel);
	//		request.setAttribute("room", room);
			request.getRequestDispatcher("views/review/insertReview.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMsg", "작성할 수 없습니다");
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
