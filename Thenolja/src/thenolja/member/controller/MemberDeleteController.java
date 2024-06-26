package thenolja.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import thenolja.member.model.service.MemberService;

/**
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/delete.me")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String memPwd = request.getParameter("memPwd");
		String pwdCheck = request.getParameter("pwdCheck");
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		
		
		int result = new MemberService().delete(memNo);
		
		if(pwdCheck.equals(memPwd)) {
		
			if(result > 0) {
				HttpSession session = request.getSession();
				session.removeAttribute("loginUser");
				
				session.setAttribute("alertMsg", "그동안 더놀자를 이용해주셔서 감사합니다.");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				request.setAttribute("errorMsg", "회원탈퇴에 실패하였습니다");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			} 
			
		} else {
			request.setAttribute("errorMsg", "비밀번호가 일치하지 않습니다!");
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
