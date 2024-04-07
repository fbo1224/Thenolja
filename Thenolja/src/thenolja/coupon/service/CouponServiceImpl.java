package thenolja.coupon.service;

import static thenolja.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import thenolja.common.JDBCTemplate;
import thenolja.common.model.vo.PageInfo;
import thenolja.coupon.dao.CouponDao;
import thenolja.coupon.model.vo.Coupon;
import thenolja.notice.dao.NoticeDao;

public class CouponServiceImpl {

	/*
	 * 
	 * 쿠폰목록 조회
	 * 
	 * */
	public ArrayList<Coupon> selectCouponList(PageInfo pi){
		
		Connection con = getConnection();	// SQL-연결정보 호출
		ArrayList<Coupon> list = null;
		
		try {
			
			// 쿠폰조회 dao 호출
			list = new CouponDao().selectCouponList(con, pi);
			System.out.println("[CouponServiceImpl selectCouponList] " + list);
			for(int i=0; i<list.size(); i++) {
				System.out.println("[CouponServiceImpl rslt] " + list.get(i).getCouponNo());
				System.out.println("[CouponServiceImpl rslt] " + list.get(i).getCouponCode());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	/**
	 * 페이징(관리자)
	 * @return
	 */
	
	public int selectListCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new NoticeDao().selectListCount(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}	
	
}
