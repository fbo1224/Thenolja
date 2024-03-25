//package thenoleja.notice.controller;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import thenoleja.notice.model.vo.Notice;
//import thenoleja.notice.service.NoticeServiceImpl;
//
//
//
///**
// * Servlet implementation class NoticeinsertController
// */
//@WebServlet("/regNotice")
//public class NoticeInsertController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public NoticeInsertController() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("a");
//		
//		//post방식 작성
//		
//		//1)인코딩
//		request.setCharacterEncoding("UTF-8");
//		
//		//2)값뽑기
//		String NoticeTitle = request.getParameter("NoticeTitle");
//		String NoticeContent = request.getParameter("NoticeContent");
//		String WriterNo = request.getParameter("WriterNo");
//		
//		//NOTICE테이블에 INSERT시점에 NOTICE_WEITER컬럼이 NOT NULL제약조건
//		//추가적으로 공지사항 작성자의 USER_NO가 필요함    1. session  2. 
//		// session 서버의 하나의 저장소
//		
//		//3)VO가공
//		Notice notice = new Notice();
//		notice.setNoticeTitle(NoticeTitle);
//		notice.setNoticeContent(NoticeContent);
//		notice.setWriterNo(WriterNo);
//		
//		//4)Service단으로 넘겨주기
//		int result = new NoticeServiceImpl().insert(notice);
//		//INSERT INTO NOTICE VALUES(시퀀스,사용자가입력한제목,입력한내용,
//		//							공지사항작성자의 USERNO,....)
//		
//		
//		//5) 결과에 따라 응답페이지 지정
//		if(result > 0) {//성공 => 공지사항 목록을 보여줄 것   request값이 0보다 커야 성공 0보다 작다 -> 실패페이지
//			//forwarding   
//			
//		/*
//			 request.setAttribute("noticeList" "")
//			request.getRequestDispatcher("view/notice/noticeList.jsp")
//				.forward(request, response);
//		*/
//			
//			//sendRedirect
//			response.sendRedirect(request.getContextPath() + "/noticeList");
//			
//			
//		} else {//실패 => 에러페이지로 응답
//			request.setAttribute("errorMsg","공지사항 등록실패");
//			request.getRequestDispatcher("view/common/errorpage.jsp")
//				.forward(request, response);
//		}
//			
//	
//		
//		
//		
//		
//		
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		System.out.println("doPost");
//		doGet(request, response);
//		
//	}
//
//}
