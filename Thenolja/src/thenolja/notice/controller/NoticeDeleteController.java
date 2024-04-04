package thenolja.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.notice.service.NoticeServiceImpl;

/**
 * Servlet implementation class NoticeDeleteController
 * 공지사항 삭제
 */
@WebServlet("/delNotice")
public class NoticeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDeleteController() {
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
	 * 공지사항 삭제 처리
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 파라미터 값 확인
		System.out.println("[NoticeDeleteController param] " + request.getParameter("noticeNo"));
		
		int result  = 0;
		boolean rslt = false;
		int noticNo = Integer.parseInt( request.getParameter("noticeNo") );
		
		// 공지사항 삭제처리 서비스 호출
		result      = new NoticeServiceImpl().deleteNoticeOne(noticNo);
		
		// 정상처리 시 목록 화면으로 sendRedirect
		if(result > 0) {
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
