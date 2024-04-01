package thenolja.event.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.event.model.vo.Event;
import thenolja.event.service.EventServiceImpl;

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
	 * �씠踰ㅽ듃 紐⑸줉 議고쉶
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("[EventController]");
		System.out.println(request.getParameter("currentPage"));
		
		// Event 寃뚯떆�뙋 議고쉶
		
		// 1. EventVo 媛앹껜 �꽑�뼵
		ArrayList<Event> eventList = new ArrayList<Event>();
		
		// 2. �씠踰ㅽ듃 寃뚯떆�뙋 議고쉶 �꽌鍮꾩뒪 �샇異�
		EventServiceImpl eventSvcImpl = new EventServiceImpl();
		eventList = eventSvcImpl.selectEventList();
		
		System.out.println("[EventController eventList] " + eventList);
		
		//�쓳�떟�솕硫� �쓣�슦湲� (list媛앹껜, �럹�씠吏� 媛앹껜 setAttribute)
		request.setAttribute("eventList", eventList);
		//request.setAttribute("pagingVo", pagingVo);
		RequestDispatcher view = request.getRequestDispatcher("/view/event/eventList.jsp");
		view.forward(request, response);		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
