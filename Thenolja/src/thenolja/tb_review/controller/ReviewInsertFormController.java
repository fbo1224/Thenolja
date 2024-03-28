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
 * Servlet implementation class ReviewInsertFormController
 */
@WebServlet("/reviewInsert.do")
public class ReviewInsertFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsertFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		int reserNo = Integer.parseInt(request.getParameter("reserNo"));
		String imgPath = request.getParameter("imgPath");
		String content = request.getParameter("content");
		int score = Integer.parseInt(request.getParameter("score"));
		
		Review review = new Review();
		review.setReserNo(reserNo);
		review.setImgPath(imgPath);
		review.setContent(content);
		review.setScore(score);
		
		int result = new ReviewService().insertReview(review);
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print(result > 0 ? "success" : "fail");
				
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
