package thenolja.tb_review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.common.model.vo.PageInfo;
import thenolja.tb_review.model.service.ReviewService;
import thenolja.tb_review.model.vo.Review;

/**
 * Servlet implementation class ReviewListController
 */
@WebServlet("/reviewList")
public class ReviewListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
		ArrayList<Review> reviewList = new ReviewService().selectList(hotelNo);
	//	int roomNo = Integer.parseInt(request.getParameter("roomNo"));
		if(reviewList != null) {
			request.setAttribute("reviewList", reviewList);
			request.getRequestDispatcher("/views/review/reviewList.jsp").forward(request, response);
	 	} else {
	        
	      	 request.setAttribute("errorMsg", "조회된 리뷰가 없습니다.");
	      	 request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);;
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
