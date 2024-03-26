package thenolja.admin.refund.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;


public class RefundDao {
	
private Properties prop = new Properties();
	
	public RefundDao() {
		
		String fileName = RefundDao.class.getResource("/sql/admin/refund/refund-mapper.xml").getPath();		
	
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * 페이징
	 */
	public int selectRefundMemCount(Connection conn) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectRefundMemCount");
		
		
		
		
		
	}

}
