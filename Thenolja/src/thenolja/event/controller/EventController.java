package thenolja.event.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.common.model.vo.PageInfo;
import thenolja.event.model.vo.Event;
import thenolja.event.service.EventServiceImpl;
import thenolja.notice.service.NoticeServiceImpl;

/**
 * Servlet implementation class EventController
 */
@WebServlet("/eventList")
public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 이벤트 목록 조회
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("[EventController]");
		System.out.println(request.getParameter("currentPage"));
		
		// Event 게시판 조회
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new EventServiceImpl().selectListCount();
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		pageLimit = 5;
		
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);		
		
		// 1. EventVo 객체 선언
		ArrayList<Event> eventList = new ArrayList<Event>();
		
		// 2. 이벤트 게시판 조회 서비스 호출
		EventServiceImpl eventSvcImpl = new EventServiceImpl();
		eventList = eventSvcImpl.selectEventList(pi);
		
		System.out.println("[EventController eventList] " + eventList);
		
		//응답화면 띄우기 (list객체, 페이징 객체 setAttribute)
		request.setAttribute("eventList", eventList);
		request.setAttribute("pageInfo" , pi);
		RequestDispatcher view = request.getRequestDispatcher("/views/event/eventList.jsp");
		view.forward(request, response);		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
