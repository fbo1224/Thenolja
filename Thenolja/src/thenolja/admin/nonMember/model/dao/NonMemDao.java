package thenolja.admin.nonMember.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import thenolja.admin.nonMember.model.vo.NonMember;
import thenolja.common.JDBCTemplate;

public class NonMemDao {
	
	private Properties prop = new Properties();
	
	public NonMemDao() {
		
		String fileName = NonMemDao.class
								   .getResource("/sql/admin/nonMember/nonMember-mapper.xml")
								   .getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<NonMember> selectNonMemberList(Connection conn) {
		
		ArrayList<NonMember> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNonMemberList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				NonMember nonMem = new NonMember();
				
				nonMem.setMemNo(rset.getInt("MEM_NO"));
				nonMem.setMemName(rset.getString("MEM_NAME"));
				nonMem.setMemPhone(rset.getString("MEM_PHONE"));
				
				list.add(nonMem);
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
