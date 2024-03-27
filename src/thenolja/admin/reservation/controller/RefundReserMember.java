package thenolja.admin.reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import thenolja.admin.reservation.model.service.ReservatoinService;

/**
 * Servlet implementation class RefundReserMember
 */
@WebServlet("/refundReser.do")
public class RefundReserMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefundReserMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int reserNo = Integer.parseInt(request.getParameter("reserNo"));
		
		int result = new ReservatoinService().refundReser(reserNo);
		
		JSONObject obj = new JSONObject();
		
		obj.put("message", "환불 처리 완료!");
		
		response.setContentType("application/json; charset=UTF-8");
		
		response.getWriter().print(obj.toString());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
