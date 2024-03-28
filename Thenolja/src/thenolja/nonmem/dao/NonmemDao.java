package thenolja.nonmem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import thenolja.admin.member.model.dao.MemberDao;
import thenolja.member.model.vo.Member;
import thenolja.nonmem.model.vo.SelectNonmemReser;

public class NonmemDao {
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		String sqlFile = MemberDao.class.getResource("/sql/nonmem/nonmem-mapper.xml").getPath();
	}

	public Member selectNonmemReser(Connection conn, String nonmemName, String nonmemPhone) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		SelectNonmemReser nonmemReser = null;
		
		String sql = prop.getProperty("selectNonmemReser");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nonmemName);
			pstmt.setString(2, nonmemPhone);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				nonmemReser = new Member(rset.getInt("MEM_NO"),
						                 rset.getString("MEM_NAME"),
						                 rset.getString("MEM_PHONE"),
						                 rset.getString("MEM_STATUS"));
				

				
				
				
				
			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
}
