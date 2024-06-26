package thenolja.admin.reservation.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import thenolja.admin.member.model.vo.AdminMember;
import thenolja.admin.reservation.model.vo.AdminReservation;
import thenolja.common.JDBCTemplate;
import thenolja.common.model.vo.PageInfo;

public class ReservationDao {
		
		private Properties prop = new Properties();
		
		public ReservationDao() {
			
			String fileName = ReservationDao.class.getResource("/sql/admin/reservation/reservation-mapper.xml").getPath();		
		
			try {
				prop.loadFromXML(new FileInputStream(fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	
	
	/**
	 * RESER COUNT
	 */
	public int selectReserCount(Connection conn) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReserCount");
		
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
	 * 예약 목록 조회
	 */
	
	public ArrayList<AdminReservation> selectReserMember(Connection conn, PageInfo pi) {
		
		ArrayList<AdminReservation> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReserMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				AdminReservation adminReser = new AdminReservation();
				adminReser.setReserNo(rset.getInt("RESER_NO"));
				adminReser.setMemId(rset.getString("MEM_ID"));
				adminReser.setReserName(rset.getString("RESER_NAME"));
				adminReser.setMemPhone(rset.getString("MEM_PHONE"));
				adminReser.setCheckInTime(rset.getString("CHECKIN_TIME"));
				
				list.add(adminReser);
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
	 * 예약 상세 조회
	 */
	public AdminReservation selectDetailReserMember(Connection conn, int reserNo){
		
		AdminReservation adminReser = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectDetailReserMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reserNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				adminReser = new AdminReservation();
				adminReser.setHotelName(rset.getString("HOTEL_NAME"));
				adminReser.setHotelPath(rset.getString("HOTEL_PATH"));
				adminReser.setReserDate(rset.getString("RESER_DATE"));
				adminReser.setCheckInTime(rset.getString("CHECKIN_TIME"));
				adminReser.setCheckOutTime(rset.getString("CHECKOUT_TIME"));
				adminReser.setBicycle(rset.getString("BICYCLE"));
				adminReser.setPeople(rset.getInt("PEOPLE"));
				adminReser.setPayment(rset.getString("PAYMENT"));
				adminReser.setPaymentPrice(rset.getInt("PAYMENT_PRICE"));
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return adminReser;
	}

	/**
	 * 환불처리
	 */
	public int refundReser(Connection conn, int reserNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("refundReser");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reserNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	/**
	 * 비회원 예약 수
	 */
	public int selectNonMemCount(Connection conn) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNonMemCount");
		
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
	 * 비회원 예약 목록 조회
	 */
	public ArrayList<AdminReservation> selectReserNonMember(Connection conn, PageInfo pi){
		
		ArrayList<AdminReservation> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReserNonMember");
	
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				AdminReservation adminReser = new AdminReservation();
				adminReser.setReserNo(rset.getInt("RESER_NO"));
				adminReser.setReserName(rset.getString("RESER_NAME"));
				adminReser.setMemPhone(rset.getString("MEM_PHONE"));
				adminReser.setCheckInTime(rset.getString("CHECKIN_TIME"));
				
				list.add(adminReser);
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
	 * 예약 회원 검색
	 */
	public ArrayList<AdminReservation> searchReserMember(Connection conn, String keyword) {
		
		ArrayList<AdminReservation> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchReserMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				AdminReservation adminReservation = new AdminReservation();
				adminReservation = new AdminReservation();
				adminReservation.setReserNo(rset.getInt("RESER_NO"));
				adminReservation.setMemId(rset.getString("MEM_ID"));
				adminReservation.setReserName(rset.getString("RESER_NAME"));
				adminReservation.setMemPhone(rset.getString("MEM_PHONE"));
				adminReservation.setCheckInTime(rset.getString("CHECKIN_TIME"));
				
				list.add(adminReservation);
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
	 * 예약 비회원 검색
	 */
	public ArrayList<AdminReservation> searchNonMemName(Connection conn, String keyword){
		
		ArrayList<AdminReservation> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchNonMemName");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				AdminReservation adminReservation = new AdminReservation();
				
				adminReservation.setReserNo(rset.getInt("RESER_NO"));
				adminReservation.setReserName(rset.getString("RESER_NAME"));
				adminReservation.setMemPhone(rset.getString("MEM_PHONE"));
				adminReservation.setCheckInTime(rset.getString("CHECKIN_TIME"));
				
				list.add(adminReservation);
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
	 * 메인페이지 예약 5
	 */
	public ArrayList<AdminReservation> reserTopFive(Connection conn){
		
		ArrayList<AdminReservation> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("reserTopFive");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				AdminReservation adminReservation = new AdminReservation();
				adminReservation.setReserNo(rset.getInt("RESER_NO"));
				adminReservation.setReserName(rset.getString("RESER_NAME"));
				adminReservation.setMemPhone(rset.getString("MEM_PHONE"));
				
				list.add(adminReservation);
				
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
	 * 메인페이지 예약
	 */
	public int todayReserCount(Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("todayReserCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			rset.next();
			
			result = rset.getInt("COUNT(*)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	
	/**
	 * 메인페이지 가격
	 */
	public int todayPrice(Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("todayPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			rset.next();
			
			result = rset.getInt("SUM(PAYMENT_PRICE)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	
	/**
	 * 오래된 회원 예약
	 */
	public ArrayList<AdminReservation> reserOldestList(Connection conn, PageInfo pi){
		
		ArrayList<AdminReservation> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("reserOldestList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				AdminReservation adminReservation = new AdminReservation();
				adminReservation.setReserNo(rset.getInt("RESER_NO"));
				adminReservation.setMemId(rset.getString("MEM_ID"));
				adminReservation.setReserName(rset.getString("RESER_NAME"));
				adminReservation.setMemPhone(rset.getString("MEM_PHONE"));
				adminReservation.setCheckInTime(rset.getString("CHECKIN_TIME"));
				
				list.add(adminReservation);
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
	 * 오래된 비회원 예약
	 */
	public ArrayList<AdminReservation> oldReserNonMember(Connection conn, PageInfo pi){
		
		ArrayList<AdminReservation> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset  = null;
		String sql = prop.getProperty("oldReserNonMember");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				AdminReservation adminReservation = new AdminReservation();
				adminReservation.setReserNo(rset.getInt("RESER_NO"));
				adminReservation.setReserName(rset.getString("RESER_NAME"));
				adminReservation.setMemPhone(rset.getString("MEM_PHONE"));
				adminReservation.setCheckInTime(rset.getString("CHECKIN_TIME"));
				
				list.add(adminReservation);

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
	 * 오늘 예약 목록
	 */
	public ArrayList<AdminReservation> todayReserDetail(Connection conn){
		
		ArrayList<AdminReservation> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("todayReserDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				AdminReservation adminReservation = new AdminReservation();
				
				adminReservation.setReserNo(rset.getInt("RESER_NO"));
				adminReservation.setReserName(rset.getString("RESER_NAME"));
				adminReservation.setHotelName(rset.getString("HOTEL_NAME"));
				adminReservation.setPaymentPrice(rset.getInt("PAYMENT_PRICE"));
				
				list.add(adminReservation);
				
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
