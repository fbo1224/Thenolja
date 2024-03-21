package thenolja.admin.nonMember.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.admin.nonMember.model.service.NonMemService;
import thenolja.admin.nonMember.model.vo.NonMember;

/**
 * Servlet implementation class SelectNonMemController
 */
@WebServlet("/selectNonMem")
public class SelectNonMemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectNonMemController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) 인코딩
		
		// 2) 값뽑기
		
		// 3) 가공
		
		// 4) Service호출
		ArrayList<NonMember> list = new NonMemService().selectNonMemberList();
		request.setAttribute("selectNonMemberList", list);
		
		// 응답화면 띄우기
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/nonMember/nonMemberList.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
