package thenolja.admin.reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import thenolja.admin.reservation.model.service.ReservatoinService;
import thenolja.admin.reservation.model.vo.AdminReservation;

/**
 * Servlet implementation class detailReserMember
 */
@WebServlet("/detailReserMem.do")
public class DetailReserMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailReserMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int reserNo = Integer.parseInt(request.getParameter("reserNo"));
		
		AdminReservation adminReser = new ReservatoinService().selectDetailReserMember(reserNo);
		
		response.setContentType("application/json; charset=UTF-8");
		
		new Gson().toJson(adminReser, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
