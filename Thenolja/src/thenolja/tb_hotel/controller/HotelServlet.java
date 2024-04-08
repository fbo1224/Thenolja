package thenolja.tb_hotel.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import thenolja.member.model.vo.Member;

/**
 * Servlet implementation class HotelServlet
 */
@WebServlet("*.hotels")
public class HotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String view = "";
		boolean flag = true;
		
		// 요청한 url 전부 보여줌
		String mapping = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
		
		HotelController hc = new HotelController();
		
		// 로그인정보 가져오기
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		request.setCharacterEncoding("UTF-8");
		
		switch(mapping) {
		
			case "hotelList" : view =  hc.hotelList(request, response, loginUser); break;
									
			case "select" : view =  hc.select(request, response); break;
		
			case "searchList" : view = hc.searchList(request, response); break;
			
			default : request.setAttribute("errorMsg", "올바른 접근이 아닙니다.");
			  view = "views/common/errorPage.jsp"; 		
		}
		
		// 관리자영역
		if(loginUser != null && loginUser.getMemStatus().equals("A")) { 
			switch(mapping) {
			
			case "insertForm" : view =  hc.insertForm(request, response); break;
			
			case "insert" : view =  hc.insert(request, response, loginUser);
			
							if(view.equals(request.getContextPath() + "/hotelList.hotels?currentPage=1&loginStatus="+loginUser.getMemStatus())) flag = false;	
							break;
			case "updateForm" : view =  hc.updateForm(request, response);  break;
			
			case "update" : view =  hc.update(request, response, loginUser);
							if(view.equals(request.getContextPath() + "/hotelList.hotels?currentPage=1&loginStatus="+loginUser.getMemStatus())) flag = false;
							break;
			}
			
		} 
		
		if(flag) {
			request.getRequestDispatcher(view).forward(request, response);
		} else {
			response.sendRedirect(view);
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
