package thenolja.tb_reservation.cotroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.tb_hotel.model.vo.Hotel;
import thenolja.tb_hotel.model.vo.Room;
import thenolja.tb_reservation.model.Service.ReserService;
import thenolja.tb_reservation.model.vo.Reservation;

/**
 * Servlet implementation class MyReserListController
 */
@WebServlet("/myReser.list")
public class MyReserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyReserListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int reMemNo = Integer.parseInt(request.getParameter("reMemNo"));
		ArrayList<Reservation> reserList = new ReserService().selectList(reMemNo);
		int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
		
		if(reserList != null) {
			Reservation reser = new ReserService().selectReservation();
			Hotel hotel = new ReserService().selectHotel();
			Room room = new ReserService().selectRoom();
			
			request.setAttribute("reserList", reserList);
			request.setAttribute("reser", reser);
			request.setAttribute("hotel", hotel);
			request.setAttribute("room", room);
			
			request.getRequestDispatcher("views/reservation/myReservationList.jsp").forward(request, response);
			
		} else {
			request.setAttribute("errorMsg", "조회된 내역이 없습니다");
			
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
