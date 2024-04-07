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
		// System.out.println("*.hotels");
		String uri = request.getRequestURI();
		String view = "";
		boolean flag = true;
		// 요청한 url 전부 보여줌
		// System.out.println(uri);
		
		String mapping = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
		// System.out.println(mapping);
		
		HotelController hc = new HotelController();
		
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		System.out.println(loginUser);
		
		request.setCharacterEncoding("UTF-8");
		
		if(loginUser != null && loginUser.getMemStatus().equals("A")) {
			switch(mapping) {
			// insertHotel.jsp
			case "insertForm" : view =  hc.insertForm(request, response); break;
			
			// 뷰 응답 controller에서 할 것.
			case "insert" : view =  hc.insert(request, response);
							// hotelList로 이동
							if(view.equals(request.getContextPath() + "/hotelList.hotels?currentPage=1&loginStatus=A")) flag = false;	
							break;
			
			// updateHotel.jsp
			case "updateForm" : view =  hc.updateForm(request, response);  break;
			
			case "update" : view =  hc.update(request, response);
							if(view.equals(request.getContextPath() + "/hotelList.hotels?currentPage=1&loginStatus=A")) flag = false;
							break;
			// hotelList.jsp
			case "hotelList" : view =  hc.hotelList(request, response); break;
										
			// hotelDetail
			case "select" : view =  hc.select(request, response); break;
			
			// searchList
			case "searchList" : view = hc.searchList(request, response); break;				
			}
			
		} else if(loginUser == null || loginUser.getMemStatus().equals("Y") ) {
			switch(mapping) {
			
			// hotelList.jsp
			case "hotelList" : view =  hc.hotelList(request, response); break;
										
			// hotelDetail
			case "select" : view =  hc.select(request, response); break;
			
			// searchList
			case "searchList" : view = hc.searchList(request, response); break;
			}
		}
		else {
			request.setAttribute("errorMsg", "올바른 접근이 아닙니다.");
			view="views/common/errorPage.jsp";
		}
		
		if(flag) {
			System.out.println("test");
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
