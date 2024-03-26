package thenolja.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NoticeinsertFormController
 */
@WebServlet("/insertForm.notice")
public class NoticeinsertFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeinsertFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//관리자가 아닐경우에도 포워딩이 수행됨
		
				HttpSession session = request.getSession();
			//	Member loginUser = (Member)session.getAttribute("loginUser");
					
	//			if(loginUser != null && loginUser.getUserId().equals("admin")) {
				
				//응답화면	
				RequestDispatcher view = request.getRequestDispatcher("view/notice/noticeEnrollForm.jsp");
				view.forward(request, response);
			
		/*				
				}else {
					session.setAttribute("alertMsg", "관리자가 아닙니다. ");
					response.sendRedirect(request.getContextPath());
				}	
				*/
			}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
