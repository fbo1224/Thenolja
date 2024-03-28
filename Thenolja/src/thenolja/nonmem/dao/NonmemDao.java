package thenolja.nonmem.dao;

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
import thenolja.nonmem.model.vo.SelectNonmemReser;


public class NonmemDao {
	
	private Properties prop = new Properties();
	
	public NonmemDao() {
		String sqlFile = MemberDao.class.getResource("/sql/nonmem/nonmem-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(sqlFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<SelectNonmemReser> selectNonmemReser(Connection conn, String nonmemName, String nonmemPhone) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SelectNonmemReser> list = new ArrayList();
		
		
		String sql = prop.getProperty("selectNonmemReser");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nonmemName);
			pstmt.setString(2, nonmemPhone);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				SelectNonmemReser nonmemReser = new SelectNonmemReser(rset.getInt("MEM_NO"),
						                            rset.getString("MEM_NAME"),
						                            rset.getString("MEM_PHONE"),
						                            rset.getString("MEM_STATUS"),
						                            rset.getInt("RESER_NO"),
						                            rset.getString("RESER_NAME"),
						                            rset.getString("CHECKIN_TIME"),
						                            rset.getString("CHECKOUT_TIME"),
								                 	rset.getString("BICYCLE"),
								                 	rset.getInt("PEOPLE"),
								                 	rset.getString("ROOM_NAME"),
								                 	rset.getInt("ROOM_NUM"),
								                 	rset.getInt("MAX_PEOPLE"),
								                 	rset.getString("CHECKIN_TIME"),
								                 	rset.getString("CHECKOUT_TIME"),
								                 	rset.getString("ROOM_IMG"));
				list.add(nonmemReser);
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
