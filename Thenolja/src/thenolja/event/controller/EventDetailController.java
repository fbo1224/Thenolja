package thenolja.event.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.notice.model.vo.Notice;
import thenolja.notice.service.NoticeServiceImpl;

/**
 * Servlet implementation class NoticeDetailController
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
	 * 怨듭��궗�빆 �긽�꽭�솕硫� 議고쉶
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// �긽�꽭�럹�씠吏� 議고쉶 �떆 �뙆�씪誘명꽣 諛쏄린
		int noticeNo = Integer.parseInt(request.getParameter("EventNo"));
		String flag  = request.getParameter("flag"); // �닔�젙, �궘�젣 / �긽�꽭 �럹�씠吏� 援щ텇�쓣 �쐞�븳 媛� 異붽�
		
		System.out.println("[EventDetailController noticeNo] " + noticeNo);  

		Notice result = new Notice();
		result = new NoticeServiceImpl().selectNoticeOne(noticeNo, flag);
		System.out.println("[EventDetailController result] " + result);
		
		if(result != null) {
			request.setAttribute("event", result);
			request.getRequestDispatcher("view/notice/eventDetail.jsp").forward(request, response); //�룷�썙�뵫
			
		}else { //�떎�뙣 => �뿉�윭�럹�씠吏� 蹂대궡湲�
			
			request.setAttribute("errorMsg", "�씠踰ㅽ듃 �긽�꽭 議고쉶 �떎�뙣");
			RequestDispatcher view = request.getRequestDispatcher("view/common/error.Msg");
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
