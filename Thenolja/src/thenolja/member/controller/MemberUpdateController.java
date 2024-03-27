package thenolja.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import thenolja.member.model.service.MemberService;
import thenolja.member.model.vo.Member;

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

		
		request.setCharacterEncoding("UTF-8");
		
		String memName = request.getParameter("memName");
		String email = request.getParameter("email");
		String memPwd = request.getParameter("memPwd");
		String memPhone = request.getParameter("memPhone");
		
		String memId = request.getParameter("memId");
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		
		Member member = new Member();
		member.setMemName(memName);
		member.setEmail(email);
		member.setMemPwd(memPwd);
		member.setMemNo(memNo);
		member.setMemId(memId);
		member.setMemPhone(memPhone);
		
		int result = new MemberService().updateMember(member);
		
		if(result > 0) {
			// 1. db가서 memNo로 객체 하나 가져오기
			// 2. 이 밑에 로그인 할 때 member.getMemId()
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "변경되었습니다.");
			
			// String memPwd = ((Member)session.getAttribute("loginUser")).getMemPwd();
			Member updateMem = new MemberService().login(memId, memPwd);
			
			session.setAttribute("loginUser", updateMem);
			response.sendRedirect(request.getContextPath() + "/myPage");
		} else {
			request.setAttribute("errorMsg", "정보수정에 실패하였습니다.");
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
