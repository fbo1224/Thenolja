package thenolja.tb_reservation.cotroller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.tb_reservation.model.Service.ReserService;
import thenolja.tb_reservation.model.vo.Reservation;
import thenolja.tb_review.model.service.ReviewService;
import thenolja.tb_review.model.vo.Review;

/**
 * Servlet implementation class MyReserListController
 */
@WebServlet("/myReser.list")
public class MyReserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyReserListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int reMemNo = Integer.parseInt(request.getParameter("reMemNo"));
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
		Date currentDate = new Date();
		ArrayList<Review> reviewList = new ReviewService().selectReviewList(reMemNo);
		ArrayList<Reservation> reserList = new ReserService().selectList(reMemNo);
		
		if(reserList != null) {
			for(int i = 0; i < reserList.size(); i++) {
				try {
					boolean reserStatus = dateformat.parse(reserList.get(i).getCheckOut()).before(currentDate);
					
					reserList.get(i).setReserStatus(reserStatus);
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
			}
			request.setAttribute("reserList", reserList);
			request.setAttribute("reviewList", reviewList);
			// System.out.println(review);
			request.getRequestDispatcher("views/reservation/myReservationList.jsp").forward(request, response);
			
		} else {
			request.setAttribute("errorMsg", "조회된 내역이 없습니다");
			
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
