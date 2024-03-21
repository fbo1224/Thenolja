package thenolja.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import thenolja.member.model.vo.Member;
import thenolja.member.model.service.MemberService;

/**
 * Servlet implementation class MemberInsertController
 */
@WebServlet("/insert.me")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String memId = request.getParameter("memId");
		String memPwd = request.getParameter("memPwd");
		String memName = request.getParameter("memName");
		String nickname = request.getParameter("nickname");
		String memPhone = request.getParameter("memPhone");
		String email = request.getParameter("email");
		String bornDate = request.getParameter("bornDate");
	
		
		// 객체에 담기
		Member member = new Member();
		member.setMemId(memId);
		member.setMemPwd(memPwd);
		member.setMemName(memName);
		member.setNickname(nickname);
		member.setMemPhone(memPhone);
		member.setEmail(email);
		member.setBornDate(bornDate);
		
		int result = new MemberService().insertMember(member);
		
		if(result > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "회원가입 성공");
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("errorMsg", "회원가입 실패");
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
