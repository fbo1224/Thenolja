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
 * Servlet implementation class EventDetailController
 */
@WebServlet("/detail.event")
public class EventDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 상세페이지 조회 시 파라미터 받기
				int eventNo = Integer.parseInt(request.getParameter("eventNo"));
				String flag  = request.getParameter("flag"); // 수정, 삭제 / 상세 페이지 구분을 위한 값 추가
				
				System.out.println("eventNo");
				System.out.println("flag");
				
				System.out.println("[EventDetailController eventNo] " + eventNo);  

				Event result = new Event();
				result = new EventServiceImpl().selectEventOne(eventNo, flag);
				System.out.println("[EventDetailController result] " + result);
				
				if(result != null) {
					request.setAttribute("event", result);
					request.getRequestDispatcher("views/event/eventDetail.jsp").forward(request, response); //포워딩
				
				}else { //실패 => 에러페이지 보내기
					
					request.setAttribute("errorMsg", "이벤트 상세 조회 실패");
					RequestDispatcher view = request.getRequestDispatcher("views/common/error.Msg");
					view.forward(request,response);	
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
