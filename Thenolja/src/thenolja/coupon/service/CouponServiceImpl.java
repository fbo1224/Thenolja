package thenolja.coupon.service;

import static thenolja.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import thenolja.coupon.dao.CouponDao;
import thenolja.coupon.model.vo.Coupon;

public class CouponServiceImpl {

	/*
	 * 
	 * 荑좏룿 紐⑸줉 議고쉶
	 * 
	 * */
	public ArrayList<Coupon> selectCouponList(){
		
		Connection con = getConnection();	// SQL-MAPPER�옉�꽦�맂 SQL 諛쏆븘�떞湲�
		ArrayList<Coupon> list = null;
		
		try {
			// dao�뿉�꽌 db connection �깮�꽦�븯怨� �뜲�씠�꽣 議고쉶�빐�꽌 list�뿉 �떞�븘�꽌 諛섑솚
			list = new CouponDao().selectCouponList(con);
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
	
}
