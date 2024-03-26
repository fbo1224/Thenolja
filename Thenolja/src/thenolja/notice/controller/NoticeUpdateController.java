package thenolja.notice.controller;

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
 * Servlet implementation class NoticeUpdateController
 */
@WebServlet("/selectNoticeInfo")
public class NoticeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("[NoticeUpdateController] param " + request.getParameter("noticeNo"));
		
		//인코딩  POST방식
		request.setCharacterEncoding("UTF-8");
		
		// 1. 파라미터로 넘어온 noticeNo(공지사항 번호) 정수형으로 파싱(변환)하여 noticeNo변수에 저장
		// 값 뽑기
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		String noticeTitle = request.getParameter("noticetitle");
		String noticeContent = request.getParameter("noticecontent");
		
		//2. 가공
		Notice notice = new Notice();
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);
		notice.setNoticeNo(noticeNo);
		
		// 3.ServiceImpl로 호출
		Notice result = new Notice();
		result = new NoticeServiceImpl().selectNoticeOne(noticeNo);
		
		System.out.println("[NoticeUpdateController result] " + result);
		
		
		//3)응답화면지정 
		if( noticeNo > 0) { 
			
			response.sendRedirect(request.getContextPath() + "/selectNoticeInfo?noticeNo=" + noticeNo);
			
			
		} else {
			request.setAttribute("errorMsg", "공지사항 수정 실패~");
			request.getRequestDispatcher("views/common/errorPage.jsp")
				   .forward(request, response);
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
