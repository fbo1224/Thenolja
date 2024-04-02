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
		// 등록 submission 통신
		// 파라미터 한글 깨짐 방지를 위한 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		// 이벤트 등록 컨트롤러
		
		// 화면에서 넘어온 파라미터 값 세팅
		// request.getParameter에 작성하는 문자열은 > html 태그에 선언한 name과 일치해야함.
		String eventTitle = "";
		String eventContent = "";
		String eventYn = "";
		String eventStrtDt="";
		String eventEndDt="";
		String eventImg = "";
		int    writerNo = 0;
		
		eventTitle   = request.getParameter("eventTitle");
		eventContent = request.getParameter("eventContent");
		eventYn  	= request.getParameter("eventYn");
		eventStrtDt = request.getParameter("eventStrtDt");
		eventEndDt = request.getParameter("eventEndDt");
		eventImg = request.getParameter("eventImg");
		
		/* eventDate = request.getParameter("eventDate"); */
		
		/*
		 * eventDate = request.getParameter("eventStrtDt"); // eventStrtDt eventDate =
		 * request.getParameter("eventEndDt"); // eventStrtDt
		 */		
		
		eventImg  = request.getParameter("eventImg");
		// 1. 로그인이 된 경우 로그인 정보에 있는 MEM_NO 를 세팅 테스트
		// 2. 로그인이 안된 경우 writerNo를 임의값 1로 세팅해서 테스트
		writerNo = Integer.parseInt(request.getParameter("writerNo")); 
		
		System.out.println("eventTitle : " + eventTitle);
		System.out.println("eventContent : " + eventContent);
		System.out.println("eventYn : " + eventYn );
		System.out.println("eventStrtDt : " + eventStrtDt );
		System.out.println("eventEndDt : " + eventEndDt);
		System.out.println("eventImg : " + eventImg );
		System.out.println("writerNo : " + writerNo );
		
		int svc = 0;
		boolean rslt = false;
		
		// 이벤트 저장 서비스 호출
		Event event = new Event(eventTitle, eventContent, eventYn, eventStrtDt,eventEndDt, eventImg, writerNo);
		svc = new EventServiceImpl().insertEvent(event);
		
		System.out.println("[svc] " + svc);
		
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




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
