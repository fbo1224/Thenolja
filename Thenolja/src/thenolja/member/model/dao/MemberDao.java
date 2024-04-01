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
import thenolja.tb_reservation.model.vo.Reservation;

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
//----------------------------- 정보수정 비회원테이블--------------------------------
	public int updateNoMember(Connection conn, Member member) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateNoMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemName());
			pstmt.setString(2, member.getMemPhone());
			pstmt.setInt(3, member.getMemNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
//----------------------------- 정보수정 회원테이블----------------------------------
	public int updateMember(Connection conn, Member member) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getMemPwd());
			pstmt.setInt(3, member.getMemNo());
			
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
//----------------------------------아이디 찾기-------------------------------
	public Member findId(Connection conn, String memName, String bornDate, String email) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member findId = null;
		
		String sql = prop.getProperty("findID");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memName);
			pstmt.setString(2, bornDate);
			pstmt.setString(3, email);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				findId = new Member(rset.getString("MEM_ID"));
				                
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return findId;
	}
//---------------------------비밀번호 찾기(조회)-----------------------------------
	public int findPwd(Connection conn, String memId, String bornDate, String memPhone) {
		
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("findPwd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memId);
			pstmt.setString(2, bornDate);
			pstmt.setString(3, memPhone);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = 1;
			} else {
				count = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return count;
	}
	
	
//----------------------------비밀번호 찾기(재설정)----------------------------------
	public int resetPwd(Connection conn, String memId, String memPwd) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("resetPwd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memPwd);
			pstmt.setString(2, memId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
//-----------------------------------회원등급 조회  ------------------------------
	public String selectGrade(Connection conn, int memNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset= null;
		String result = "";
		
		String sql = prop.getProperty("selectGrade");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			
			rset = pstmt.executeQuery();
			
			rset.next();
				
			result = rset.getString("GRADE_NAME");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Member selectMember(Connection conn, int memNo) {
		
		Member member = new Member();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				member = new Member();
				member.setMemNo(rset.getInt("MEM_NO"));
				member.setMemId(rset.getString("MEM_ID"));
				member.setMemPwd(rset.getString("MEM_PWD"));
				member.setNickname(rset.getString("NICKNAME"));
				member.setBornDate(rset.getString("BORN_DATE"));
				member.setEmail(rset.getString("EMAIL"));
				member.setJoinDate(rset.getDate("JOIN_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return member;
	}
//----------------------------닉네임 중복확인-----------------------------------------
	public int nickNameCheck(Connection conn, String checkNickname) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("nicknameCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, checkNickname);
			
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
//----------------------------------이메일 중복확인-------------------------------------
	public int emailCheck(Connection conn, String checkEmail) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("emailCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, checkEmail);
			
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
//-------------------------------------찜목록 추가--------------------------------------
	public int heartInsert(Connection conn, int hotelNo, int memNo) {
		int count = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertHeart");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, hotelNo);
			pstmt.setInt(2, memNo);
			
			count = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return count;
	}
//------------------------------------------찜 목록 삭제-----------------------------------
	public int heartDelete(Connection conn, int hotelNo, int memNo) {
		int count = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteHeart");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, hotelNo);
			pstmt.setInt(2, memNo);
			
			count = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return count;
	}
	
	
	
	
	
	
}
