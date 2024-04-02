package thenolja.event.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.event.model.vo.Event;
import thenolja.event.service.EventServiceImpl;
import thenolja.notice.model.vo.Notice;
import thenolja.notice.service.NoticeServiceImpl;

/**
 * Servlet implementation class NoticeUpdateController
 * 怨듭��궗�빆 �닔�젙
 */
@WebServlet("/updEvent")
public class EventUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventUpdateController() {
        super();
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
	 * 怨듭��궗�빆 �닔�젙 泥섎━
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// �뙆�씪誘명꽣 媛� �솗�씤
		System.out.println("[EventUpdateController param] " + request.getParameter("eventNo"));
		
		request.setCharacterEncoding("UTF-8");
		
		// �솕硫댁뿉�꽌 �꽆�뼱�삩 �뙆�씪誘명꽣 媛� �꽭�똿
		// request.getParameter�뿉 �옉�꽦�븯�뒗 臾몄옄�뿴�� > html �깭洹몄뿉 �꽑�뼵�븳 name怨� �씪移섑빐�빞�븿.
		int  eventNo 		= 0;
		String eventTitle 	= "";
		String eventContent = "";
		String eventStrtDt 	= "";
		String eventEndDt 	= "";
		String eventYn 		= "";	
		String eventImg 	= "";
		int writerNo		= 0;
		int result  		= 0;
		
	    eventNo 	 = Integer.parseInt( request.getParameter("eventNo") );
		eventTitle   = request.getParameter("eventTitle");
		eventContent = request.getParameter("eventContent");
		eventStrtDt  = request.getParameter("eventStrtDt");
		eventEndDt   = request.getParameter("eventEndDt");
		eventYn      = request.getParameter("eventYn");
		
		
		System.out.println("eventTitle   : " + eventTitle);
		System.out.println("eventContent : " + eventContent);
		System.out.println("eventYn  : " + eventYn);
		System.out.println("eventNo : " + eventNo);
		System.out.println("eventYn length  : " + eventYn.length());
		
		int svc = 0;
		boolean rslt = false;
		
		// �씠踰ㅽ듃 �닔�젙 �꽌鍮꾩뒪 �샇異�
		Event event = new Event(eventNo, eventTitle, eventContent, 
								eventStrtDt, eventEndDt, eventYn, 
								eventImg, writerNo);
		svc = new EventServiceImpl().updateEventOne(event);
		
		System.out.println("[svc] " + svc);
		
		// �젙�긽泥섎━ �떆 紐⑸줉 �솕硫댁쑝濡� sendRedirect
		if(svc > 0) {
			rslt = true;
			// �벑濡앹셿猷� �썑 response 媛앹껜�뿉 contentType �꽕�젙
			response.setContentType("text/html charset=UTF-8");
			response.getWriter().write("SUCCESS");
		}
		
		// ���옣 �떎�뙣 �떆 �벑濡앺솕硫댁쑝濡� sendRedirect
		else {
			rslt = false;
			// �벑濡앹셿猷� �썑 response 媛앹껜�뿉 contentType �꽕�젙
			response.setContentType("text/html charset=UTF-8");
			response.getWriter().write("FAIL");
		}		
		
	}

}
