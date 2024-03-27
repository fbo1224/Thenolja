package thenolja.tb_hotel.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.tb_hotel.model.service.HotelService;

/**
 * Servlet implementation class AjaxController
 */
@WebServlet("/jqAjax.do")
public class AjaxDeleteHotelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxDeleteHotelController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
		
		// System.out.println(hotelNo);
		
		int result = new HotelService().deleteHotel(hotelNo);
		String str = "삭제 실패";
		if(result > 0) {
			str = "삭제 성공";
		}
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print(str);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
