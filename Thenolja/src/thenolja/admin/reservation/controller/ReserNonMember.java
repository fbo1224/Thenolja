package thenolja.admin.reservation.controller;

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

import thenolja.admin.reservation.model.service.ReservatoinService;
import thenolja.admin.reservation.model.vo.AdminReservation;
import thenolja.common.model.vo.PageInfo;

/**
 * Servlet implementation class ReserNonMember
 */
@WebServlet("/reserNonMem")
public class ReserNonMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserNonMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new ReservatoinService().selectNonMemCount();
		
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		pageLimit = 5;
		
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		// System.out.println(pi);
		
		ArrayList<AdminReservation> list = new ReservatoinService().selectReserNonMember(pi);
	    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy.MM.dd");
	    Date current = new Date();
	    
	    for(int i = 0; i < list.size(); i++) {
        	try {
				boolean reserStatus = simpleDate.parse(list.get(i).getCheckInTime()).before(current);
				list.get(i).setReserStatus(reserStatus);
        	} catch (ParseException e) {
				e.printStackTrace();
			}
	    }
	    
		request.setAttribute("selectReserNonMember", list);
		request.setAttribute("pageInfo", pi);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/reservation/reserNonMemberList.jsp");
		
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
