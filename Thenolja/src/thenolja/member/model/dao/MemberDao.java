package thenolja.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import thenolja.common.JDBCTemplate;
import thenolja.member.model.vo.Member;

public class MemberDao {

	private Properties prop = new Properties();
	
	public MemberDao() {
		String sqlFile = MemberDao.class.getResource("/sql/member/member-mapper.xml").getPath();
		
		
		
		try {
			prop.loadFromXML(new FileInputStream(sqlFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//---------------------로그인
	
	public Member login(Connection conn, String memId, String memPwd) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member loginUser = null;
		
		String sql = prop.getProperty("login");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memId);
			pstmt.setString(2, memPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				loginUser = new Member(rset.getInt("MEM_NO"),
						               rset.getString("MEM_NAME"),
						               rset.getString("MEM_PHONE"),
						               rset.getString("MEM_ID"),
						               rset.getString("MEM_PWD"),
						               rset.getString("NICKNAME"),
						               rset.getString("EMAIL"),
						               rset.getString("BORN_DATE"),
						               rset.getDate("JOIN_DATE"),
						               rset.getString("MEM_STATUS"),
						               rset.getString("DELETE_YN"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return loginUser;
	}
	
	
	
	
}
