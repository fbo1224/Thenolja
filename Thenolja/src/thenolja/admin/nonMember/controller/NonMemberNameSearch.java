package thenolja.admin.nonMember.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import thenolja.admin.nonMember.model.service.NonMemService;
import thenolja.admin.nonMember.model.vo.NonMember;

/**
 * Servlet implementation class NonMemberNameSearch
 */
@WebServlet("/searchNonMemName.do")
public class NonMemberNameSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NonMemberNameSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String keyword = request.getParameter("keyword");
		
		NonMember nonMember = new NonMemService().selectNonMemberName(keyword);
		
		response.setContentType("application/json; charset=UTF-8");
      
     	new Gson().toJson(nonMember, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
