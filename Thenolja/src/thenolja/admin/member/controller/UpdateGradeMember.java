package thenolja.admin.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.admin.member.model.service.MemberService;
import thenolja.admin.member.model.vo.AdminMember;

/**
 * Servlet implementation class UpdateGradeMember
 */
@WebServlet("/gradeUpdate.do")
public class UpdateGradeMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGradeMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		int gradeNo = Integer.parseInt(request.getParameter("gradeNo"));
		
		AdminMember adminMember = new AdminMember();
		adminMember.setMemNo(memNo);
		adminMember.setGradeNo(gradeNo);
		
		int result = new MemberService().updateGrade(adminMember);
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print(result > 0 ?  "success" : "fail");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
