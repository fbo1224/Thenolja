package thenolja.coupon.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thenolja.coupon.model.vo.Coupon;
import thenolja.coupon.service.CouponServiceImpl;

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
	 * 荑좏룿 紐⑸줉 議고쉶
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[CouponController]");
		
		// 荑좏룿 紐⑸줉 �꽌鍮꾩뒪 媛앹껜 �꽑�뼵 諛� �샇異�
		ArrayList <Coupon> cpnList = new ArrayList<Coupon>();
		CouponServiceImpl cpSvc = new CouponServiceImpl();
		cpnList = cpSvc.selectCouponList();
		
		for(int i=0; i<cpnList.size(); i++) {
			System.out.println("[CouponController result] " + cpnList.get(i).getClass());
		}
		
		//�쓳�떟�솕硫� �쓣�슦湲� (list媛앹껜, �럹�씠吏� 媛앹껜 setAttribute)
		request.setAttribute("couponList", cpnList);
		//request.setAttribute("pagingVo", pagingVo);
		RequestDispatcher view = request.getRequestDispatcher("/views/coupon/couponList.jsp");
		view.forward(request, response);		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
