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
 * Servlet implementation class EventRegController
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
		// �벑濡� submission �넻�떊
		// �뙆�씪誘명꽣 �븳湲� 源⑥쭚 諛⑹�瑜� �쐞�븳 �씤肄붾뵫 �꽕�젙
		request.setCharacterEncoding("UTF-8");
		// �씠踰ㅽ듃 �벑濡� 而⑦듃濡ㅻ윭
		
		// �솕硫댁뿉�꽌 �꽆�뼱�삩 �뙆�씪誘명꽣 媛� �꽭�똿
		// request.getParameter�뿉 �옉�꽦�븯�뒗 臾몄옄�뿴�� > html �깭洹몄뿉 �꽑�뼵�븳 name怨� �씪移섑빐�빞�븿.
		String eventTitle = "";
		String eventContent = "";
		String eventYn = "";
		String eventDate = "";
		String eventImg = "";
		int    writerNo = 0;
		
		eventTitle   = request.getParameter("eventTitle");
		eventContent = request.getParameter("eventContent");
		eventYn  	= request.getParameter("eventYn");
		eventDate  = request.getParameter("eventStrtDt"); // eventStrtDt
		eventDate  = request.getParameter("eventEndDt"); // eventStrtDt
		eventImg  = request.getParameter("eventImg");
		// 1. 濡쒓렇�씤�씠 �맂 寃쎌슦 濡쒓렇�씤 �젙蹂댁뿉 �엳�뒗 MEM_NO 瑜� �꽭�똿 �뀒�뒪�듃
		// 2. 濡쒓렇�씤�씠 �븞�맂 寃쎌슦 writerNo瑜� �엫�쓽媛� 1濡� �꽭�똿�빐�꽌 �뀒�뒪�듃
		writerNo = Integer.parseInt(request.getParameter("writerNo")); 
		
		System.out.println("eventTitle : " + eventTitle);
		System.out.println("eventContent : " + eventContent);
		System.out.println("eventYn : " + eventYn );
		System.out.println("eventDate : " + eventDate );
		System.out.println("eventImg : " + eventImg );
		System.out.println("writerNo : " + writerNo );
		
		int svc = 0;
		boolean rslt = false;
		
		// �씠踰ㅽ듃 ���옣 �꽌鍮꾩뒪 �샇異�
		Event event = new Event(eventTitle, eventContent, eventYn, eventDate, eventImg, writerNo);
		svc = new EventServiceImpl().insertEvent(event);
		
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




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
