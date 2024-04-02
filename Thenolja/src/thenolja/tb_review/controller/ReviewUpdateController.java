package thenolja.tb_review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import thenolja.tb_hotel.model.vo.Hotel;
import thenolja.tb_hotel.model.vo.Room;
import thenolja.tb_reservation.model.Service.ReserService;
import thenolja.tb_reservation.model.vo.Reservation;
import thenolja.tb_review.model.service.ReviewService;
import thenolja.tb_review.model.vo.Review;

/**
 * Servlet implementation class ReviewUpdateController
 */
@WebServlet("/update.review")
public class ReviewUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int reserNo = Integer.parseInt(request.getParameter("reserNo"));
		int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
		int roomNo = Integer.parseInt(request.getParameter("roomNo"));
		
		Review review = new ReviewService().selectReview(reserNo);
		Room room = new ReserService().selectRoom(hotelNo, roomNo);
		
		if(room != null && review != null) {
			request.setAttribute("room", room);
			request.setAttribute("review", review);

			request.getRequestDispatcher("views/review/updateReview.jsp").forward(request, response);
		} else {
	       	 request.setAttribute("errorMsg", "리뷰 수정에 실패하였습니다");
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
