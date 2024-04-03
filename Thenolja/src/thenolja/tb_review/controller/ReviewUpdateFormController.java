package thenolja.tb_review.controller;

import java.io.File;
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
 * Servlet implementation class ReviewUpdateFormController
 */
@WebServlet("/reviewUpdate.do")
public class ReviewUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if(ServletFileUpload.isMultipartContent(request)) {
			// System.out.println("sdfsdf");
			
		int maxSize = 1024 * 1024 * 10;
		
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		String savePath = application.getRealPath("/resources/reviewImage/");
		
		MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
		
		
		int reserNo = Integer.parseInt(multiRequest.getParameter("reserNo"));
		String imgPath = multiRequest.getParameter("upfile");
		String content = multiRequest.getParameter("reviewContent");
		String score = multiRequest.getParameter("starScore");
		
		Review review = new Review();
		review.setReserNo(reserNo);
		review.setImgPath(imgPath);
		review.setContent(content);
		review.setScore(score);
	//	System.out.println(content);
		
		if(multiRequest.getOriginalFileName("upfile") != null) {
			review.setOriginName(multiRequest.getOriginalFileName("upfile"));
			review.setChangeName(multiRequest.getFilesystemName("upfile"));
			review.setImgPath("resources/reviewImage/" + review.getChangeName());
		}
		int result = new ReviewService().updateReview(review);
		
			if(result > 0) {
	       	 // request.getSession().setAttribute("alertMsg", "게시글 등록성공");
			//	 int roomNo = Integer.parseInt(request.getParameter("roomNo"));
				int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
		       	 response.sendRedirect(request.getContextPath() + "/reviewList?hotelNo=" + hotelNo);
		       	 
	       	} else {
	        
		       	 request.setAttribute("errorMsg", "리뷰 작성 실패");
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
