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
 * Servlet implementation class EventUpdateController
 */
@WebServlet("/updEvent")
public class EventUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventUpdateController() {
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
	 * 이벤트 수정
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[EventUpdateController]");
		
		// 파라미터
		int eventNo 		= Integer.parseInt( request.getParameter("eventNo") );
		int writerNo		= Integer.parseInt( request.getParameter("writerNo") );
		String title 		= request.getParameter("title"); 
		String content 		= request.getParameter("content"); 
		String eventYn  	= request.getParameter("status"); 
		String eventStrtDt  = request.getParameter("eventStrtDt"); 
		String eventEndDt 	= request.getParameter("eventEndDt");
		String eventImg		= request.getParameter("eventImg");
		
		System.out.println("[EventUpdateController eventNo] "     + eventNo);
		System.out.println("[EventUpdateController title] "		  + title);
		System.out.println("[EventUpdateController content] "	  + content);
		System.out.println("[EventUpdateController eventYn] "	  + eventYn);
		System.out.println("[EventUpdateController eventStrtDt] " + eventStrtDt);
		System.out.println("[EventUpdateController eventEndDt] "  + eventEndDt);
		System.out.println("[EventUpdateController eventImg] "    + eventImg);
		System.out.println("[EventUpdateController writerNo] "    + writerNo);
		
		int svc = 0;
		boolean rslt = false;
		
		Event evt = new Event(title, content, eventYn, 
							  eventStrtDt, eventEndDt, 
							  eventImg, writerNo, eventNo 
							  );
		svc = new EventServiceImpl().updateEventOne(evt);
		
		System.out.println("[EventUpdateController svc] " + svc);
		
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
