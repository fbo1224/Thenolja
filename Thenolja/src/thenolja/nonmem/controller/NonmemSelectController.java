package thenolja.nonmem.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import thenolja.nonmem.model.vo.SelectNonmemReser;
import thenolja.nonmem.service.NonmemService;

/**
 * Servlet implementation class NonmemberSelectController
 */
@WebServlet("/selectNonmem")
public class NonmemSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NonmemSelectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nonmemName = request.getParameter("nonmemName");
		int nonmemNo = Integer.parseInt(request.getParameter("nonmemNo"));
	
		// System.out.println(nonmemName);
		// System.out.println(nonmemNo);
		ArrayList<SelectNonmemReser> list = new NonmemService().selectNonmemReser(nonmemName, nonmemNo);
		
		// System.out.println(list);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yy/MM/dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yy년MM월dd일");
		
		for(SelectNonmemReser sn : list) {
			try {
				Date date1 = sdf1.parse(sn.getCheckInDate());
				Date date2 = sdf1.parse(sn.getCheckOutDate());
				
				sn.setCheckInDate(sdf2.format(date1));
				sn.setCheckOutDate(sdf2.format(date2));
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
		
		
		HttpSession session = request.getSession();
		session.setAttribute("nonmemReser", list);
		
		
		if(!list.isEmpty()) {
			request.getRequestDispatcher("views\\nonmem\\nonDetailReservation.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMsg", "예약된 내역이 없습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
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
