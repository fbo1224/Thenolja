package thenolja.admin.refund.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import thenolja.admin.refund.model.vo.AdminRefund;
import thenolja.common.JDBCTemplate;
import thenolja.common.model.vo.PageInfo;


public class RefundDao {
	
private Properties prop = new Properties();
	
	public RefundDao() {
		
		String fileName = RefundDao.class.getResource("/sql/admin/refund/refund-mapper.xml").getPath();		
	
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * 페이징
	 */
	public int selectRefundMemCount(Connection conn) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectRefundMemCount");
		
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
	 * 환불 회원 목록
	 */
	public ArrayList<AdminRefund> selectRefundMemberList(Connection conn, PageInfo pi) {
		
		ArrayList<AdminRefund> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectRefundMemberList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				AdminRefund adminRefund = new AdminRefund();
				
				adminRefund.setReserNo(rset.getInt("RF_RESER_NO"));
				adminRefund.setMemId(rset.getString("MEM_ID"));
				adminRefund.setReserName(rset.getString("RESER_NAME"));
				adminRefund.setMemPhone(rset.getString("MEM_PHONE"));
				
				list.add(adminRefund);
				
			}
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;

	}
	
	/**
	 * 회원 환불 상세 조회
	 */
	
	public AdminRefund selectRefundMember (Connection conn, int reserNo) {
		
		AdminRefund adminRefund = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectRefundMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reserNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				adminRefund = new AdminRefund();
				adminRefund.setHotelName(rset.getString("HOTEL_NAME"));
				adminRefund.setHotelPath(rset.getString("HOTEL_PATH"));
				adminRefund.setRefundName(rset.getString("REFUND_NAME"));
				adminRefund.setBank(rset.getString("BANK"));
				adminRefund.setRefundAccNo(rset.getString("REFUND_ACC_NO"));
				adminRefund.setRefundPrice(rset.getInt("REFUND_PRICE"));
				adminRefund.setReserDate(rset.getString("RESER_DATE"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return adminRefund;
		
	}
	
	/**
	 * 비회원 환불 수
	 */
	public int selectRefundNonMemberCount(Connection conn) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectRefundNonMemberCount");
		
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
	 * 비회원 목록
	 */
	public ArrayList<AdminRefund> selectRefundNonMemberList(Connection conn, PageInfo pi){
		
		ArrayList<AdminRefund> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectRefundNonMemberList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				AdminRefund adminRefund = new AdminRefund();
				
				adminRefund.setReserNo(rset.getInt("RF_RESER_NO"));
				adminRefund.setReserName(rset.getString("RESER_NAME"));
				adminRefund.setMemPhone(rset.getString("MEM_PHONE"));
				
				list.add(adminRefund);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	
	
	/**
	 * 회원 환불 조회 검색
	 */
	public ArrayList<AdminRefund> selectRefundeMemberId(Connection conn, String keyword) {
		
		ArrayList<AdminRefund> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectRefundeMemberId");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				AdminRefund adminRefund = new AdminRefund();
				adminRefund = new AdminRefund();
				adminRefund.setReserNo(rset.getInt("RF_RESER_NO"));
				adminRefund.setMemId(rset.getString("MEM_ID"));
				adminRefund.setReserName(rset.getString("RESER_NAME"));
				adminRefund.setMemPhone(rset.getString("MEM_PHONE"));
				
				list.add(adminRefund);
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
	 * 비회원 검색
	 */
	public ArrayList<AdminRefund> searchRefundNonMem(Connection conn, String keyword) {
		
		ArrayList<AdminRefund> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchRefundNonMem");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				AdminRefund adminRefund = new AdminRefund();
				adminRefund = new AdminRefund();
				adminRefund.setReserNo(rset.getInt("RF_RESER_NO"));
				adminRefund.setReserName(rset.getString("RESER_NAME"));
				adminRefund.setMemPhone(rset.getString("MEM_PHONE"));
				
				list.add(adminRefund);
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
