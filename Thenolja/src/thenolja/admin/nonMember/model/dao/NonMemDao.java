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
import thenolja.common.model.vo.PageInfo;

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
	
	
	/**
	 * 페이징
	 */
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
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return listCount;
		
	}
	
	
	
	/**
	 * 비회원 전체 조회
	 */
	public ArrayList<NonMember> selectNonMemberList(Connection conn, PageInfo pi) {
		
		ArrayList<NonMember> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNonMemberList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
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
