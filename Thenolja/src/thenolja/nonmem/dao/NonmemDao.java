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
	
	/*
	public int insertNonMem(Connection conn, Member nonmem) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNonMem");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nonmem.getMemName());
			pstmt.setString(2, nonmem.getMemPhone());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public Member selectNonMem(Connection conn) {
		
		Member member = new Member();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNonMem");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				member = new Member();
				member.setMemNo(rset.getInt("MEM_NO"));
				member.setMemName(rset.getString("MEM_NAME"));
				member.setMemPhone(rset.getString("MEM_PHONE"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return member;
	}
	*/
	
}
