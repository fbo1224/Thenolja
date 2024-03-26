package thenolja.tb_review.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static thenolja.common.JDBCTemplate.*;

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

}
