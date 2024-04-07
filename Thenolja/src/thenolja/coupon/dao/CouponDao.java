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
import thenolja.common.model.vo.PageInfo;
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
	 * 쿠폰 목록 조회
	 * 
	 * */
	public ArrayList<Coupon> selectCouponList(Connection conn, PageInfo pi){
		
		System.out.println("[CouponDao conn] " + conn);
		
		ArrayList<Coupon> list = new ArrayList<Coupon>(); // 
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectCouponList");
		System.out.println("[CouponDao selectCouponList sql] " + sql);
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);				
			
			rset = pstmt.executeQuery(); //쿠폰목록 조회
			
			while(rset.next()) {
				// 쿠폰 목록 조회 결과 VO에 세팅
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
