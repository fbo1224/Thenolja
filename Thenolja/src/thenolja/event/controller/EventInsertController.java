package thenolja.event.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.event.model.vo.Event;
import thenolja.event.service.EventServiceImpl;

/**
 * Servlet implementation class EventInsertController
 */
@WebServlet("/eventReg")
public class EventInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("[EventInsertController]");
		String evtTitle 	= "";
		String evtContent 	= "";
		String evtYn 		= "";
		String eventImg		= "";
		String evtStrtDt 	= "";
		String evtEndDt 	= "";
		String createDate   = "";
		
		evtTitle 	 = request.getParameter("eventTitle");
		evtContent 	 = request.getParameter("eventContent");
		evtYn 		 = request.getParameter("eventYn");
		evtStrtDt 	 = request.getParameter("eventStrtDt");
		evtEndDt 	 = request.getParameter("eventEndDt");
		// writerNo 	 = request.getParameter("writerNo");
		int writerNo = 1; 
		createDate    = request.getParameter("createDate");
		
		System.out.println("EventInsertController evtTitle "   + evtTitle);
		System.out.println("EventInsertController evtContent " + evtContent);
		System.out.println("EventInsertController evtYn "      + evtYn);
		System.out.println("EventInsertController "            + evtStrtDt);
		System.out.println("EventInsertController "            + evtEndDt);
		
		Event evt = new Event(evtTitle, evtContent, evtYn, 
							  evtStrtDt, evtEndDt, eventImg, writerNo, createDate);
		
		int svc = new EventServiceImpl().insertEventInfo(evt);
		boolean rslt = false;
		
		// 정상처리 시 목록 화면으로 sendRedirect
		if(svc > 0) {
			rslt = true;
			// 등록완료 후 response 객체에 contentType 설정
			response.setContentType("text/html charset=UTF-8");
			response.getWriter().write("SUCCESS");
		}
		
		// 저장 실패 시 등록화면으로 sendRedirect
		else {
			rslt = false;
			// 등록완료 후 response 객체에 contentType 설정
			response.setContentType("text/html charset=UTF-8");
			response.getWriter().write("FAIL");
		}
	}

}
