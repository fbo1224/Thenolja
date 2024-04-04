package thenolja.admin.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import thenolja.admin.member.model.vo.AdminMember;
import thenolja.common.JDBCTemplate;
import thenolja.common.model.vo.PageInfo;

public class MemberDao {
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		
		String fileName = MemberDao.class.getResource("/sql/admin/member/member-mapper.xml").getPath();		
	
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
	 * 멤버 전체 조회 페이지
	 */
	public ArrayList<AdminMember> selectMemberList(Connection conn, PageInfo pi){

	      ArrayList<AdminMember> list = new ArrayList();
	      ResultSet rset = null;
	      PreparedStatement pstmt = null;
	      
	      String sql = prop.getProperty("selectMemberList");
	      
	      try {
	    	  
			pstmt = conn.prepareStatement(sql);
			
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();

			while(rset.next()) {
				AdminMember member = new AdminMember();
	            member.setMemNo(rset.getInt("MEM_NO"));
	            member.setMemId(rset.getString("MEM_ID"));
	            member.setNickName(rset.getString("NICKNAME"));
	            member.setGradeName(rset.getString("GRADE_NAME"));
	            list.add(member);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	         JDBCTemplate.close(rset);
	         JDBCTemplate.close(pstmt);
	      }

	      return list;	
	}
	
	
	
	public AdminMember selectMember(Connection conn, int MemNo) {
		
		AdminMember member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, MemNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new AdminMember();
				member.setMemName(rset.getString("MEM_NAME"));
				member.setEmail(rset.getString("EMAIL"));
				member.setMemPhone(rset.getString("MEM_PHONE"));
				member.setBornDate(rset.getString("BORN_DATE"));
				member.setGradeName(rset.getString("GRADE_NAME"));
				member.setJoinDate(rset.getString("JOIN_DATE"));
				member.setPaymentPrice(rset.getInt("PAYMENT_PRICE"));
				member.setProfilePath(rset.getString("PROFILE_PATH"));
			
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return member;
		
	}
	
	/**
	 * 
	 * 삭제
	 */
	public int deleteMember(Connection conn, int memNo) {
		
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
	
	/**
	 * 회원 탈퇴 수
	 */
	public int selectDeleteCount(Connection conn) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectDeleteCount");
		
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
	 * 탈퇴 회원 목록 조회
	 */
	public ArrayList<AdminMember> selectDeleteMemberList(Connection conn, PageInfo pi){
		
		ArrayList<AdminMember> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectDeleteMemberList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				AdminMember adminMember = new AdminMember();
				
				adminMember.setMemNo(rset.getInt("MEM_NO"));
				adminMember.setMemId(rset.getString("MEM_ID"));
				adminMember.setNickName(rset.getString("NICKNAME"));
				adminMember.setGradeName(rset.getString("GRADE_NAME"));
				
				list.add(adminMember);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	
	public int completeDelete(Connection conn, int memNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("completeDelete");
		
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
	
	
	/**
	 * 등급 수정
	 */
	public int updateGrade(Connection conn, AdminMember adminMember) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateGrade");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, adminMember.getGradeNo());
			pstmt.setInt(2, adminMember.getMemNo());
			
			result = pstmt.executeUpdate();
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}
	
	
	/**
	 * 멤버 아이디로 검색
	 */
	public AdminMember selectMemberId(Connection conn, String keyword) {
		
		AdminMember adminMember = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMemberId");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
			
				adminMember = new AdminMember();
				adminMember.setMemNo(rset.getInt("MEM_NO"));
				adminMember.setMemId(rset.getString("MEM_ID"));
				adminMember.setNickName(rset.getString("NICKNAME"));
				adminMember.setGradeName(rset.getString("GRADE_NAME"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return adminMember;
		
		
	}
	
	
	/**
	 * 탈퇴 회원 아이디로 검색
	 */
	public AdminMember selectDeleteMemberId(Connection conn, String keyword) {
		
		AdminMember adminMember = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectDeleteMemberId");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				adminMember = new AdminMember();
				adminMember.setMemNo(rset.getInt("MEM_NO"));
				adminMember.setMemId(rset.getString("MEM_ID"));
				adminMember.setNickName(rset.getString("NICKNAME"));
				adminMember.setGradeName(rset.getString("GRADE_NAME"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return adminMember;
	}
	
	
	/**
	 * 가입자 수
	 */
	public int countJoinMember(Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("countJoinMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			rset.next();
			
			result = rset.getInt("COUNT(*)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	/**
	 * 오래된 순
	 */
	public ArrayList<AdminMember> memberOldestList(Connection conn, PageInfo pi){
		
		ArrayList<AdminMember> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("memberOldestList");
		
		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				AdminMember adminMember = new AdminMember();
				adminMember.setMemNo(rset.getInt("MEM_NO"));
				adminMember.setMemId(rset.getString("MEM_ID"));
				adminMember.setNickName(rset.getString("NICKNAME"));
				adminMember.setGradeName(rset.getString("GRADE_NAME"));
				
				list.add(adminMember);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	
	/**
	 * 탈퇴회원 오래된 순 정렬
	 */
	public ArrayList<AdminMember> oldDeleteMemberList(Connection conn, PageInfo pi){
		
		ArrayList<AdminMember> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("oldDeleteMemberList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				AdminMember adminMember = new AdminMember();
				adminMember.setMemNo(rset.getInt("MEM_NO"));
				adminMember.setMemId(rset.getString("MEM_ID"));
				adminMember.setNickName(rset.getString("NICKNAME"));
				adminMember.setGradeName(rset.getString("GRADE_NAME"));
				
				list.add(adminMember);
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
