package thenolja.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/update.me")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		request.setCharacterEncoding("UTF-8");
		
		String memName = request.getParameter("memName");
		String email = request.getParameter("email");
		String memPwd = request.getParameter("memPwd");
		
		String memId = request.getParameter("memId");
		
		Member member = new Member();
		member.setMemName(memName);
		member.setEmail(email);
		member.setMemPwd(memPwd);
		member.setMemId(memId);
		
		int result = new MemberService().updateMember(member);
		
		if(result > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "변경되었습니다.");
			
			// String memPwd = ((Member)session.getAttribute("loginUser")).getMemPwd();
			Member updateMem = new MemberService().login(memId, memPwd);
			
			session.setAttribute("loginUser", updateMem);
			response.sendRedirect(request.getContextPath() + "/myPage");
		} else {
			request.setAttribute("errorMsg", "정보수정에 실패하였습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}*/
		System.out.println("정보수정2 서블릿");
		request.getRequestDispatcher("views\\member\\memberUpdate.jsp").forward(request, response);
	
	
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
