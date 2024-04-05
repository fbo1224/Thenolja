package thenolja.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import thenolja.mypage.model.vo.MyFileRenamePolicy;
import thenolja.mypage.model.vo.Profile;
import thenolja.mypage.service.MyPageService;

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
		
		// System.out.println("insert profile servlet");
		
		request.setCharacterEncoding("UTF-8");
		if(ServletFileUpload.isMultipartContent(request)) {
			// size
			int maxSize = 1024 * 1024 * 10;
			
			// path
			String savePath = request.getServletContext().getRealPath("/resources/profile_upfiles");
			
			// 객체 생성과 파일 이름 수정
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy()); 
			//-------------------------------------------------------------------------------------------------------------------
			System.out.println(multiRequest);
			String filePath = multiRequest.getParameter("upfile");
			int memNo = Integer.parseInt(request.getParameter("memNo"));
			
			Profile profile = new Profile();
			profile.setMemNo(memNo);
			profile.setProfilePath(filePath);
			
			if(multiRequest.getOriginalFileName("upfile") != null) {
				profile.setOriginName(multiRequest.getOriginalFileName("upfile"));
				profile.setChangeName(multiRequest.getFilesystemName("upfile"));
				profile.setProfilePath("resources/profile_upfiles/" + profile.getChangeName());
			}
			
			int result = new MyPageService().updateProfile(profile);
			
			// System.out.println(memNo);
			if(result == 0) {
				new MyPageService().insertProfile(profile);
			}
			
		}
		request.getRequestDispatcher("views\\mypage\\myPage.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
