package thenolja.admin.review.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import thenolja.admin.review.model.vo.AdminReview;
import thenolja.common.JDBCTemplate;
import thenolja.common.model.vo.PageInfo;

public class ReviewDao {
	
	private Properties prop = new Properties();
	
	public ReviewDao() {
		
		String fileName = ReviewDao.class.getResource("/sql/admin/review/review-mapper.xml").getPath();		
	
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 페이징
	 */
	 public int selectReviewCount(Connection conn) {
		 
		 int listCount = 0;
		 PreparedStatement pstmt = null;
		 ResultSet rset = null;
		 String sql = prop.getProperty("selectReviewCount");
		 
		 try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			rset.next();
			
			listCount = rset.getInt("COUNT(*)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		 return listCount;
	 }
	 
	 /**
	  * 리뷰 목록 조회
	  */
	 public ArrayList<AdminReview> selectReviewMemberList(Connection conn, PageInfo pi){
		 
		 ArrayList<AdminReview> list = new ArrayList();
		 PreparedStatement pstmt = null;
		 ResultSet rset = null;
		 String sql = prop.getProperty("selectReviewMemberList");
		 
		 try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				AdminReview adminReview = new AdminReview();
				adminReview.setHotelName(rset.getString("HOTEL_NAME"));
				adminReview.setMemId(rset.getString("MEM_ID"));
				adminReview.setNickName(rset.getString("NICKNAME"));
				adminReview.setCreateDate(rset.getString("CREATE_DATE"));
				
				list.add(adminReview);

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
