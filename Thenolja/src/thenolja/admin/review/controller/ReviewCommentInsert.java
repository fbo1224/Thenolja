package thenolja.admin.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.admin.review.model.service.ReviewService;
import thenolja.admin.review.model.vo.AdminComment;

/**
 * Servlet implementation class ReviewCommentInsert
 */
@WebServlet("/commentInsert.do")
public class ReviewCommentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewCommentInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		
		int reserNo = Integer.parseInt(request.getParameter("reserNo"));
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		String content = request.getParameter("content");
		
		AdminComment adminComment = new AdminComment();
		adminComment.setCommentReserNo(reserNo);
		adminComment.setCommentMemNo(String.valueOf(memNo));
		adminComment.setCommentContent(content);
		
		int result = new ReviewService().insertComment(adminComment);
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print(result > 0 ?  "success" : "fail");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
