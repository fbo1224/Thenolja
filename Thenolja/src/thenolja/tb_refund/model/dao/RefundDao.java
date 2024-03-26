package thenolja.tb_refund.model.dao;

import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import static thenolja.common.JDBCTemplate.*;
import thenolja.tb_refund.model.vo.Refund;
import thenolja.tb_reservation.model.dao.ReserDao;
import thenolja.tb_reservation.model.vo.Reservation;

public class RefundDao {
	
	private Properties prop = new Properties();
	
	public RefundDao() {
		String fileName = ReserDao.class.getResource("/sql/tb_refund/refund-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public int insertRefund(Connection conn, Refund refund) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertRefund");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, refund.getReserNo());
			pstmt.setInt(2, refund.getAccNo());
			pstmt.setString(3, refund.getRefundName());
			pstmt.setString(4, refund.getBank());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public Refund selectRefund(Connection conn, int reserNo) {
		
		Refund refund = new Refund();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectRefund");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reserNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				refund = new Refund();
				refund.setReserNo(rset.getInt("RF_RESER_NO"));
				refund.setRefundPrice(rset.getInt("REFUND_PRICE"));
				refund.setAccNo(rset.getInt("REFUND_ACC_NO"));
				refund.setRefundName(rset.getString("REFUND_NAME"));
				refund.setBank(rset.getString("BANK"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return refund;
	}
	/*
	public Refund selectRefundNo(Connection conn, int reserNo) {
		
		Refund refund = new Refund();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectRefundNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				refund = new Refund();
				refund.setReserNo(rset.getInt("RF_RESER_NO"));
				refund.setRefundPrice(rset.getInt("REFUND_PRICE"));
				refund.setAccNo(rset.getInt("REFUND_ACC_NO"));
				refund.setRefundName(rset.getString("REFUND_NAME"));
				refund.setBank(rset.getString("BANK"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return refund;
	}
	*/
	public Reservation selectRervation(Connection conn, int reserNo) {
		
		Reservation reser = new Reservation();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReservation");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reserNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				reser = new Reservation();
				reser.setReserNo(rset.getInt("RESER_NO"));
				reser.setReserDate(rset.getDate("RESER_DATE"));
				reser.setName(rset.getString("RESER_NAME"));
				reser.setPhone(rset.getString("RESER_PHONE"));
				reser.setBicycle(rset.getString("BICYCLE"));
				reser.setCheckIn(rset.getString("CHECKIN_TIME"));
				reser.setCheckOut(rset.getString("CHECKOUT_TIME"));
				reser.setPeople(rset.getInt("MAX_PEOPLE"));
				reser.setRoomNo(rset.getInt("ROOM_NO"));
				reser.setReMemNo(rset.getInt("RE_MEM_NO"));
				reser.setPayment(rset.getString("PAYMENT"));
				reser.setPaymentPrice(rset.getInt("PAYMENT_PRICE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return reser;
	}
	public int updateRefund(Connection conn, Refund refund) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateRefund");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, refund.getAccNo());
			pstmt.setString(2, refund.getRefundName());
			pstmt.setString(3, refund.getBank());
			pstmt.setInt(4, refund.getReserNo());

			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
}