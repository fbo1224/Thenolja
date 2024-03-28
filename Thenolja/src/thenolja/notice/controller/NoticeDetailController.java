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
 * Servlet implementation class NoticeDetailController
 */
@WebServlet("/detail.notice")
public class NoticeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 공지사항 상세화면 조회
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 상세페이지 조회 시 파라미터 받기
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		String flag  = request.getParameter("flag"); // 수정, 삭제 / 상세 페이지 구분을 위한 값 추가
		
		System.out.println("[NoticeDetailController noticeNo] " + noticeNo);  

		Notice result = new Notice();
		result = new NoticeServiceImpl().selectNoticeOne(noticeNo, flag);
		System.out.println("[NoticeDetailController result] " + result);
		
		if(result != null) {
			request.setAttribute("notice", result);
			request.getRequestDispatcher("views/notice/noticeDetail.jsp").forward(request, response); //포워딩
			
		}else { //실패 => 에러페이지 보내기
			
			request.setAttribute("errorMsg", "공지사항 상세 조회 실패");
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
