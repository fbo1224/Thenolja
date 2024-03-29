package thenolja.tb_review.model.dao;

import static thenolja.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import thenolja.common.model.vo.PageInfo;
import thenolja.tb_review.model.vo.Review;

public class ReviewDao {
	
	private Properties prop = new Properties();
	
	public ReviewDao() {
		
		String filePath = ReviewDao.class.getResource("/sql/tb_review/review-mapper.xml")
							.getPath();
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public int selectListCount(Connection conn) {
		
	      int listCount = 0;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      String sql = prop.getProperty("selectListCount");
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         
	         rset = pstmt.executeQuery();
	         
	         rset.next();
	         
	         listCount = rset.getInt("COUNT(*)");
	         
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	      
	      return listCount;
	}
	
	public ArrayList<Review> selectList(Connection conn, PageInfo pi){
		
 
		return ;
	}
	public int insertReview(Connection conn, Review review) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, review.getReserNo());
			pstmt.setString(2, review.getImgPath());
			pstmt.setString(3, review.getContent());
			pstmt.setInt(4, review.getScore());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
