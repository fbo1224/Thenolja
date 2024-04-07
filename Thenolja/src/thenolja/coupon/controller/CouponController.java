package thenolja.coupon.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.common.model.vo.PageInfo;
import thenolja.coupon.model.vo.Coupon;
import thenolja.coupon.service.CouponServiceImpl;
import thenolja.event.service.EventServiceImpl;

/**
 * Servlet implementation class CouponController
 */
@WebServlet("/couponList")
public class CouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CouponController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 쿠폰목록
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[CouponController]");
		
		// Event 게시판 조회
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new CouponServiceImpl().selectListCount();
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
		
		// 쿠폰목록 조회
		ArrayList <Coupon> cpnList = new ArrayList<Coupon>();
		CouponServiceImpl cpSvc = new CouponServiceImpl();
		cpnList = cpSvc.selectCouponList(pi);
		
		for(int i=0; i<cpnList.size(); i++) {
			System.out.println("[CouponController result] " + cpnList.get(i).getClass());
		}
		
		// 쿠폰정보 setAttribute
		request.setAttribute("couponList", cpnList);
		request.setAttribute("pageInfo"  , pi);
		RequestDispatcher view = request.getRequestDispatcher("/views/coupon/couponList.jsp");
		view.forward(request, response);		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
