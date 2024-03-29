package thenolja.admin.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import thenolja.admin.member.model.service.MemberService;
import thenolja.admin.member.model.vo.AdminMember;

/**
 * Servlet implementation class SelectMemberIdController
 */
@WebServlet("/searchMemberId.do")
public class SelectMemberIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectMemberIdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String keyword = request.getParameter("keyword");
	
		AdminMember adminMember = new MemberService().selectMemberId(keyword);
		
	      response.setContentType("application/json; charset=UTF-8");
	      
	      new Gson().toJson(adminMember, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
