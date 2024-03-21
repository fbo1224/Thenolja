package thenolja.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import thenolja.member.model.service.MemberService;
import thenolja.member.model.vo.Member;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String memId = request.getParameter("memId");
		String memPwd = request.getParameter("memPwd");
		
		Member loginUser = new MemberService().login(memId, memPwd);
		
		// System.out.println(loginUser);
		
		if(loginUser == null) {
			request.setAttribute("errorMsg", "로그인에 실패하였습니다!");
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			
			session.setAttribute("loginUser", loginUser);
			session.setAttribute("alertMsg", "로그인 성공!");
			
			if(loginUser.getMemStatus().equals("Y")) {
			
				response.sendRedirect(request.getContextPath());
			} else {
				response.sendRedirect(request.getContextPath()+"/views/common/adminMain.jsp");
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
