package thenolja.tb_hotel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// 요청한 url 전부 보여줌
		// System.out.println(uri);
		
		String mapping = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
		// System.out.println(mapping);
		
		HotelController hc = new HotelController();
		
		String view = "";
		int result = 0;
		boolean flag = true;
		request.setCharacterEncoding("UTF-8");
	
		switch(mapping) {
			// insertHotel.jsp
			case "insertForm" : view =  hc.insertForm(request, response); break;
			
			//
			case "insert" : result =  hc.insert(request, response);
							// hotelList로 이동
							if(result > 0) {
								view = request.getContextPath() + "/hotelList.hotels?currentPage=1";
								flag = false;
							}
							// 실패시 에러페이지로.
							else {
								request.setAttribute("errorMsg", "hotel 추가 실패...");
								view="views/common/errorPage.jsp";	
							}
							break;
			
			// hotelList.jsp
			case "hotelList" : view =  hc.hotelList(request, response); break;
			
			// updateHotel.jsp
			case "updateForm" : view =  hc.updateForm(request, response);  break;
			
			// 
			case "update" : result =  hc.update(request, response);
							if(result > 0) {
								view = request.getContextPath() + "/hotelList.hotels?currentPage=1";
								flag = false;
							} else {
								request.setAttribute("errorMsg", "호텔정보 수정에 실패했습니다.");
								view = "views/common/errorPage.jsp";
							}
							break;

			// hotelDetail
			case "select" : view =  hc.select(request, response); break;
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
