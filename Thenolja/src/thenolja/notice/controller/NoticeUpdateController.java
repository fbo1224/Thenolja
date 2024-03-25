package thenoleja.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenoleja.notice.model.vo.Notice;
import thenoleja.notice.service.NoticeServiceImpl;

/**
 * Servlet implementation class NoticeUpdateController
 */
@WebServlet("/update.notice")
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
		
		
		//POST방식
		//인코딩
		request.setCharacterEncoding("UTF-8");
		
		//2) 값뽑기
		
		String noticeTitle = request.getParameter("Title");
		String noticeContent = request.getParameter("Content");
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		
		//가공
		Notice notice = new  Notice();
		
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);
		notice.setNoticeNo(noticeNo);

		
		//service 호출
		
		int result = new NoticeServiceImpl().update(notice);
		
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/detail.notice=" + noticeNo);
			
		}else {
			request.setAttribute("errorMsg", "공지사항 수정 실패했습니다.");
			request.getRequestDispatcher("views.common/errorpage.jsp")
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
