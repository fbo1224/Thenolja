package thenolja.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.notice.model.vo.Notice;
import thenolja.notice.service.NoticeServiceImpl;

/**
 * Servlet implementation class NoticeInsertController
 */
@WebServlet("/regNotice")
public class NoticeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertController() {
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
	 * 공지사항 등록
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getRequestURI());
		System.out.println(request.getContentType());
		// 등록 submission 통신
		// 파라미터 한글 깨짐 방지를 위한 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		
		// 화면에서 넘어온 파라미터 값 세팅
		// request.getParameter에 작성하는 문자열은 > html 태그에 선언한 name과 일치해야함.
		String title   = "";
		String content = "";
		String status  = "";
		//int writerNo   = 0;
		title    = request.getParameter("title");
		content  = request.getParameter("content");
		status   = request.getParameter("status");
		//writerNo = Integer.parseInt(request.getParameter("writerNo"));
		
		
		System.out.println("title : "    + title);
		System.out.println("content : "  + content);
		System.out.println("status : "   + status);
		//System.out.println("writerNo : " + writerNo);
		
		int svc = 0;
		boolean rslt = false;
		
		// 공지사항 저장 서비스 호출
		Notice notice = new Notice(title, content, status);
		svc = new NoticeServiceImpl().insertNotice(notice);
		
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

}
