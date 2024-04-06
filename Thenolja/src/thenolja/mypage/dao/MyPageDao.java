package thenolja.mypage.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import thenolja.common.JDBCTemplate;
import thenolja.member.model.dao.MemberDao;
import thenolja.mypage.model.vo.MyPageCoupon;
import thenolja.mypage.model.vo.MyPageHeartList;
import thenolja.mypage.model.vo.Profile;

public class MyPageDao {
	
	private Properties prop = new Properties();
	
	public MyPageDao() {
		String sqlFile = MemberDao.class.getResource("/sql/member/member-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(sqlFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MyPageHeartList> selectHeartList(Connection conn, int memNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MyPageHeartList> list = new ArrayList();
		
		String sql = prop.getProperty("selectHeartList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				MyPageHeartList heartList = new MyPageHeartList(rset.getString("HOTEL_NAME"),
																rset.getString("HOTEL_LOCATION"),
																rset.getString("HOTEL_ADDRESS"),
																rset.getString("HOTEL_PATH"));
				list.add(heartList);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
//--------------------------------- 프사 유무 확인----------------------------------
	
	public String selectProfile(Connection conn, int memNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String filePath = null;
		
		String sql = prop.getProperty("selectProfile");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				filePath = rset.getString("PROFILE_PATH");				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return filePath;
	}
//---------------------------------프사 업뎃------------------------------------
	public int updateProfile(Connection conn, Profile profile) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateProfile");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, profile.getProfilePath());
			pstmt.setInt(2, profile.getMemNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
//-----------------------------------프사 사진 인서트-----------------------------------------
	public int insertProfile(Connection conn, Profile profile) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertProfile");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, profile.getMemNo());
			pstmt.setString(2, profile.getProfilePath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
//-------------------------------------쿠폰함 조회-------------------------------------------------
	

	public ArrayList<MyPageCoupon> selectCoupon(Connection conn, int memNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MyPageCoupon> list = new ArrayList();
		
		String sql = prop.getProperty("selectCoupon");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				MyPageCoupon couponList = new MyPageCoupon(rset.getInt("COUPON_NO"),
														   rset.getString("COUPON_CONTENT"),
														   rset.getString("COUPON_DATE"),
													   	   rset.getString("COUPON_CATE_CD"),
														   rset.getString("COUPON_CATE_NM"),
														   rset.getInt("COUPON_PERCENT"));
				
				list.add(couponList);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	
	
	
	
	
}
