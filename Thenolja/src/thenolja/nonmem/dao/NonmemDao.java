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
import thenolja.member.model.vo.Member;
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

	public ArrayList<SelectNonmemReser> selectNonmemReser(Connection conn, String nonmemName, int nonmemNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SelectNonmemReser> list = new ArrayList();
		
		
		String sql = prop.getProperty("selectNonmemReser");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nonmemName);
			pstmt.setInt(2, nonmemNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				SelectNonmemReser nonmemReser = new SelectNonmemReser(rset.getInt("MEM_NO"),
										                              rset.getString("MEM_NAME"),
										                              rset.getString("MEM_PHONE"),
										                              rset.getString("MEM_STATUS"),
										                              rset.getInt("RESER_NO"),
										                              rset.getString("RESER_NAME"),
										                              rset.getString("RESER_PHONE"),
										                              rset.getString("CHECKIN_DATE"),
										                              rset.getString("CHECKOUT_DATE"),
												                 	  rset.getString("BICYCLE"),
												                 	  rset.getInt("PEOPLE"),
												                 	  rset.getString("PAYMENT_PRICE"),
												                 	  rset.getInt("ROOM_NO"),
												                 	  rset.getString("ROOM_NAME"),
												                 	  rset.getInt("ROOM_NUM"),
												                 	  rset.getInt("MAX_PEOPLE"),
												                 	  rset.getString("CHECKIN_TIME"),
												                 	  rset.getString("CHECKOUT_TIME"),
												                 	  rset.getInt("HOTEL_NO"),
												                 	  rset.getString("HOTEL_NAME"),
												                 	  rset.getString("HOTEL_LOCATION"),
												                 	  rset.getString("HOTEL_ADDRESS"),
												                 	  rset.getString("HOTEL_PATH"),
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
			JDBCTemplate.close(pstmt);
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
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return member;
	}
	
	public Member selectNonMemNo(Connection conn, int memNo) {
		
		Member member = new Member();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNonMem");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
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
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return member;
	}
	
	public ArrayList<SelectNonmemReser> selectReserInfo(Connection conn, String memName, int memNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SelectNonmemReser> list = new ArrayList();
		
		
		String sql = prop.getProperty("selectReserInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memName);
			pstmt.setInt(2, memNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				SelectNonmemReser nonmemReser = new SelectNonmemReser(rset.getInt("MEM_NO"),
						                            rset.getString("MEM_NAME"),
						                            rset.getString("MEM_PHONE"),
						                            rset.getString("MEM_STATUS"),
						                            rset.getInt("RESER_NO"),
						                            rset.getString("RESER_NAME"),
						                            rset.getString("RESER_PHONE"),
						                            rset.getString("CHECKIN_DATE"),
						                            rset.getString("CHECKOUT_DATE"),
								                 	rset.getString("BICYCLE"),
								                 	rset.getInt("PEOPLE"),
								                 	rset.getString("PAYMENT_PRICE"),
								                 	rset.getInt("ROOM_NO"),
								                 	rset.getString("ROOM_NAME"),
								                 	rset.getInt("ROOM_NUM"),
								                 	rset.getInt("MAX_PEOPLE"),
								                 	rset.getString("CHECKIN_TIME"),
								                 	rset.getString("CHECKOUT_TIME"),
								                 	rset.getInt("HOTEL_NO"),
								                 	rset.getString("HOTEL_NAME"),
								                 	rset.getString("HOTEL_LOCATION"),
								                 	rset.getString("HOTEL_ADDRESS"),
								                 	rset.getString("HOTEL_PATH"),
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

	public int insertNonMember(Connection conn, Member nonmem) {
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
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public Member selectNonMember(Connection conn) {
		
		Member nonmem = new Member();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNonMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				nonmem = new Member();
				nonmem.setMemNo(rset.getInt("MEM_NO"));
				nonmem.setMemName(rset.getString("MEM_NAME"));
				nonmem.setMemPhone(rset.getString("MEM_PHONE"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nonmem;
	}
	
}
