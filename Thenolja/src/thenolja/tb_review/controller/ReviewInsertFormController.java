package thenolja.tb_review.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import thenolja.common.MyFileRenamePolicy;
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
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 1024 * 1024 * 10;
			
			HttpSession session = request.getSession();
			ServletContext application = session.getServletContext();
			String savePath = application.getRealPath("/resources/reviewImage/");
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			
		int reserNo = Integer.parseInt(request.getParameter("reserNo"));
		String imgPath = request.getParameter("upfile");
		String content = request.getParameter("content");
		int score = Integer.parseInt(request.getParameter("starScore"));
		
		Review review = new Review();
		review.setReserNo(reserNo);
		review.setImgPath(imgPath);
		review.setContent(content);
		review.setScore(score);
		
		if(multiRequest.getOriginalFileName("upfile") != null) {
			review.setImgPath(multiRequest.getOriginalFileName("upfile"));
			
			review.setImgPath(multiRequest.getFilesystemName("upfile"));
			review.setImgPath("resources/reviewImage");
		}
		int result = new ReviewService().insertReview(review);
		
		if(result > 0) {
       	 request.getSession().setAttribute("alertMsg", "게시글 등록성공");
    	 
       	 response.sendRedirect(request.getContextPath() + "/reviewList?currentPage=1");
       	 
       	} else {
        
       	 request.setAttribute("errorMsg", "게시글 작성 실패");
       	 request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);;
        }         
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
