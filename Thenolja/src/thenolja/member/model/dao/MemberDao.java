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
//------------------------ 회원가입 -------------------------------------
	public int insertMember(Connection conn, Member member) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemName());
			pstmt.setString(2, member.getMemPhone());
			pstmt.setString(3, member.getMemId());
			pstmt.setString(4, member.getMemPwd());
			pstmt.setString(5, member.getNickname());
			pstmt.setString(6,member.getBornDate());
			pstmt.setString(7, member.getEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
//----------------------- 아이디 중복확인---------------------------------
	public int idCheck(Connection conn, String checkId) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("idCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, checkId);
			
			rset = pstmt.executeQuery();
			
			rset.next();
			
			count = rset.getInt("COUNT(*)");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return count;
	}
	
//----------------------------- 정보수정----------------------------------
	public int updateMember(Connection conn, Member member) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getMemPwd());
			pstmt.setString(3, member.getMemId());
			pstmt.setString(4, member.getMemName());
			pstmt.setString(5, member.getMemId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
//-------------------------회원 탈퇴------------------------------
	public int delete(Connection conn, int memNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
