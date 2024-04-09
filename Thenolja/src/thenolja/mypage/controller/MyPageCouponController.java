package thenolja.mypage.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.mypage.model.vo.MyPageCoupon;
import thenolja.mypage.service.MyPageService;

/**
 * Servlet implementation class MyPageCouponController
 */
@WebServlet("/mypage.coupon")
public class MyPageCouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageCouponController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int memNo = Integer.parseInt(request.getParameter("memNo"));
		
		// System.out.println(memNo);
		SimpleDateFormat dateformat = new SimpleDateFormat("yy/MM/dd");
		SimpleDateFormat dateformat2 = new SimpleDateFormat("yy년 MM월 dd일");
		
		ArrayList<MyPageCoupon> couponList = new MyPageService().selectCoupon(memNo);
		for( MyPageCoupon mp : couponList) {
			
			try {
				
				Date date = dateformat.parse(mp.getCouponDate());
				mp.setCouponDate(dateformat2.format(date));
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		request.setAttribute("couponList", couponList);
		
		request.getRequestDispatcher("views\\mypage\\myCoupon.jsp").forward(request, response);
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
