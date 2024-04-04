package thenolja.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import thenolja.common.MyFileRenamePolicy;

/**
 * Servlet implementation class MyPageProfileController
 */
@WebServlet("/insertProfile")
public class InsertProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		request.setCharacterEncoding("UTF-8");
		if(ServletFileUpload.isMultipartContent(request)) {
			// size
			int maxSize = 1024 * 1024 * 10;
			
			// path
			String savePath = request.getServletContext().getRealPath("/resources/profile_upfiles");
			
			// 객체 생성과 파일 이름 수정
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy()); 
			//-------------------------------------------------------------------------------------------------------------------
			
			//if(multiRequest.getOriginalFileName("") != null) {
				
			//}
			
		}*/
		int memNo = Integer.parseInt(request.getParameter("memNo"));
	
		
		System.out.println(memNo);
		System.out.println("insert profile servlet 호출");
		//int count = new MyPageService().insertFilePath(memNo);
		
		response.setContentType("text/html; charset=UTF-8");
		
		//response.getWriter().print(count);
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
