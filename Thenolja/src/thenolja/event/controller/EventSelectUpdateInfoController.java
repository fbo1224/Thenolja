package thenolja.event.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.event.model.vo.Event;
import thenolja.event.service.EventServiceImpl;
import thenolja.event.model.vo.Event;
import thenolja.event.service.EventServiceImpl;

/**
 * Servlet implementation class EventUpdateController
 */
@WebServlet("/selectUpdate.event")
public class EventSelectUpdateInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventSelectUpdateInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 이벤트 수정화면 정보 조회
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("[EventSelectUpdateInfoController]");
		// 상세페이지 조회 시 파라미터 받기
		int eventNo = Integer.parseInt(request.getParameter("eventNo"));
		String flag  = request.getParameter("flag");
		
		System.out.println(request.getParameter("eventNo"));
		System.out.println(request.getParameter("flag"));
		
		System.out.println("[NoticeDetailController eventNo] " + eventNo);  
		System.out.println("[NoticeDetailController flag] " 	+ flag);  

		Event result = new Event();
		result = new EventServiceImpl().selectEventOne(eventNo, flag);
		
		if(result != null) {
			request.setAttribute("event", result);
			request.getRequestDispatcher("view/event/eventUpd.jsp").forward(request, response); //포워딩
		}else { //실패 => 에러페이지 보내기
			request.setAttribute("errorMsg", "이벤트 상세 조회 실패");
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.Msg");
			view.forward(request,response);	
		}		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
