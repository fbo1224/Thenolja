package thenolja.nonmem.dao;

<<<<<<< HEAD
import static thenolja.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
=======
>>>>>>> 2be948c4e561aa2b3291af17841d6397db889afd
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
<<<<<<< HEAD

import thenolja.member.model.vo.Member;
import thenolja.tb_reservation.model.dao.ReserDao;

public class NonmemDao {

	private Properties prop = new Properties();
	
	public NonmemDao() {
		String fileName = ReserDao.class.getResource("/sql/nonmem/nonmem-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
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
	/*
	public Member selectNonMemNo(Connection conn, int memNo) {
		
		Member member = new Member();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNonMemNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
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
=======

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
	
	
	
	
>>>>>>> 2be948c4e561aa2b3291af17841d6397db889afd
}
