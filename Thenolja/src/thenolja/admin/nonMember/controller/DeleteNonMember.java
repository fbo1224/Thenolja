package thenolja.admin.nonMember.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import thenolja.admin.nonMember.model.service.NonMemService;

/**
 * Servlet implementation class DeleteNonMember
 */
@WebServlet("/deleteNonMember.do")
public class DeleteNonMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNonMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int nonMemNo = Integer.parseInt(request.getParameter("nonMemNo"));
		
		int result = new NonMemService().deleteNonMember(nonMemNo);
		
		JSONObject obj = new JSONObject();
		
		obj.put("message", "삭제 성공!");
		
		response.setContentType("application/json; charset=UTF-8");
		
		response.getWriter().print(obj.toString());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
