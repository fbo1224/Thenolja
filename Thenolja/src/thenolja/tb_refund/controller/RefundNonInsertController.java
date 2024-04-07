package thenolja.tb_refund.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.tb_hotel.model.vo.Hotel;
import thenolja.tb_hotel.model.vo.Room;
import thenolja.tb_refund.model.service.RefundService;
import thenolja.tb_refund.model.vo.Refund;
import thenolja.tb_reservation.model.Service.ReserService;
import thenolja.tb_reservation.model.vo.Reservation;

/**
 * Servlet implementation class RefundNonInsertController
 */
@WebServlet("/nonRefund.insert")
public class RefundNonInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefundNonInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		int reserNo = Integer.parseInt(request.getParameter("reserNo"));
		String accNo = request.getParameter("accNo");
		String refundName = request.getParameter("refundName");
		String bankName = request.getParameter("bankName");
		int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
		int roomNo = Integer.parseInt(request.getParameter("roomNo"));	
		int refundPrice = Integer.parseInt(request.getParameter("refundPrice"));
		System.out.println(roomNo);
		System.out.println(hotelNo);
		// 3) 데이터 가공
		Refund refund = new Refund();
		refund.setReserNo(reserNo);
		refund.setRefundPrice(refundPrice);
		refund.setAccNo(accNo);
		refund.setRefundName(refundName);
		refund.setBank(bankName);
		
		int result1 = new RefundService().insertRefund(refund, reserNo);
		int result2 = new ReserService().deleteReser(reserNo);
		
		if(result1 * result2 > 0) {
			
			refund = new RefundService().selectRefund(reserNo);
			Reservation reser = new RefundService().selectReservation(reserNo);
			Hotel hotel = new ReserService().selectHotelNo(hotelNo);
			Room room = new ReserService().selectRoom(hotelNo, roomNo);
			
			if(refund != null && reser != null && hotel != null && room != null) {
				
				request.setAttribute("refund", refund);
				request.setAttribute("hotel", hotel);      
				request.setAttribute("room", room);
				request.setAttribute("reser", reser);
				// System.out.println(reser);
				RequestDispatcher view = request.getRequestDispatcher("views/refund/detailNonRefund.jsp");
				view.forward(request, response);
	   			
			} else {
				request.setAttribute("errorMsg", "환불 처리에 실패하셨습니다.");
				RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
				view.forward(request, response);
		/*	
			response.sendRedirect(request.getContextPath() + "/refundDetail?reserNo=" + refund.getReserNo());
			}*/
			}
		} else {
			request.setAttribute("errorMsg", "환불 처리에 실패했습니다!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
