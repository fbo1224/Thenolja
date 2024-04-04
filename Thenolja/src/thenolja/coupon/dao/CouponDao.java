package thenolja.coupon.dao;

import static thenolja.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import oracle.net.nt.TcpNTAdapter;
import thenolja.coupon.model.vo.Coupon;
import thenolja.notice.dao.NoticeDao;
import thenolja.notice.model.vo.Notice;

public class CouponDao {

	private Properties prop = new Properties();
	
	public CouponDao() {
	
	String fileName = CouponDao.class
							   .getResource("/sql/coupon/coupon-mapper.xml")
							   .getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * 荑좏룿 紐⑸줉 議고쉶
	 * 
	 * */
	public ArrayList<Coupon> selectCouponList(Connection conn){
		
		System.out.println("[CouponDao conn] " + conn);
		
		ArrayList<Coupon> list = new ArrayList(); // �옓 �쁺�뿭 怨듦컙 二쇱냼媛�
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectCouponList");
		System.out.println("[CouponDao selectCouponList sql] " + sql);
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery(); // �떎�젣 荑쇰━臾몄씠 �닔�뻾�릺�뒗 遺�遺�
			
			while(rset.next()) {
				//while 諛섎났臾� �븞�뿉 吏��뿭蹂��닔 
				Coupon cpn = new Coupon();
				cpn.setCouponNo(rset.getInt("COUPON_NO"));
				cpn.setCouponContent(rset.getString("COUPON_CONTENT"));
				cpn.setCouponDate(rset.getString("COUPON_DATE"));
				cpn.setCouponCode(rset.getString("COUPON_CODE"));
				cpn.setCouponCateCd(rset.getString("COUPON_CATE_CD"));
				cpn.setCouponCateNm(rset.getString("COUPON_CATE_NM"));
				cpn.setCouponPercent(rset.getInt("COUPON_PERCENT"));
				cpn.setWriter(rset.getString("WRITER"));
				
				list.add(cpn);
			}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	
	}	
	
	
}
