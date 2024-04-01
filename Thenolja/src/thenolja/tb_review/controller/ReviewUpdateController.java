package thenolja.tb_review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		Review review = new ReviewService().selectReview(reserNo);
		
		if(review != null) {
			 request.setAttribute("review", review);
	       	 response.sendRedirect(request.getContextPath() + "/views/review/updateReview.jsp");
      	} else {
       
	       	 request.setAttribute("errorMsg", "리뷰 작성 실패");
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
