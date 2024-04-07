package thenolja.tb_hotel.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import thenolja.member.model.vo.Member;
import thenolja.tb_hotel.model.service.HotelService;
import thenolja.tb_hotel.model.vo.Comment;
import thenolja.tb_hotel.model.vo.HotelCard;

/**
 * Servlet implementation class AjaxController
 */
@WebServlet("*.jqAjax")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();

		String mapping = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
		
		AjaxController ac = new AjaxController();
		
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		boolean flag = true;
		Gson gson = new Gson();
		String str = "";
		Map<String, Object> datas = null;
		ArrayList<HotelCard> List = null;
		ArrayList<Comment> cList = null;
		List<String> locList = null;
		
		switch(mapping) {
			case "popularData"    : List = ac.selectPopular(request, response); break;
			case "locRecomData"   : List = ac.locRecomData(request, response); break;
			case "commentAdmin"   : cList = ac.commentAdmin(request, response); break;
			case "reviewList"     : datas = ac.reviewList(request, response); break;
			case "searchLocation" : locList = ac.searchLocation(request, response); flag = false; break;
		}
		
		if(loginUser != null && loginUser.getMemStatus().equals("A")) {
			switch(mapping) {
				case "deleteHotel" : datas =  ac.deleteHotel(request, response); break;
				case "deleteRoom"  : str = ac.deleteRoom(request, response); flag = false; break; 
			}
		}
		
		if(flag) {
			response.setContentType("application/json; charset=UTF-8");
			if(mapping.equals("deleteHotel")) {
				gson.toJson(datas, response.getWriter());
				
			} else if(mapping.equals("popularData")) {
				gson.toJson(List, response.getWriter());
				
			} else if(mapping.equals("locRecomData")) {
				gson.toJson(List, response.getWriter());
				
			} else if(mapping.equals("commentAdmin")) {
				gson.toJson(cList, response.getWriter());
				
			} else if(mapping.equals("reviewList")) {
				gson.toJson(datas, response.getWriter());
			}
				
		} else {
			response.setContentType("text/html; charset=UTF-8");
			if(mapping.equals("deleteRoom")) {
				response.getWriter().print(str);
				
			} else if(mapping.equals("searchLocation")) {
				response.getWriter().print(locList);
			}
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
