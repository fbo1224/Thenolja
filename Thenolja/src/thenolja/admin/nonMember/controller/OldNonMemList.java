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
import thenolja.common.model.vo.PageInfo;

/**
 * Servlet implementation class OldNonMemList
 */
@WebServlet("/oldestNonMemList.do")
public class OldNonMemList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OldNonMemList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new NonMemService().selectListCount();
		
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		// System.out.println(listCount);
		// System.out.println(currentPage);
		
		pageLimit = 5;
		
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		// System.out.println(maxPage);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		
		// System.out.println(pi);
		
		
		ArrayList<NonMember> list = new NonMemService().oldNonMemList(pi);
		request.setAttribute("pageInfo", pi);
		
		request.setAttribute("oldNonMemList", list);
		
		// 응답화면 띄우기
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/nonMember/nonMemberList.jsp");
		view.forward(request, response);
		
		System.out.println(list);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
