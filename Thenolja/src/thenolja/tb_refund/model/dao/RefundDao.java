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
			
			
			pstmt.setInt(1, refund.getAccNo());
			pstmt.setString(2, refund.getRefundName());
			pstmt.setString(3, refund.getBank());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public Refund selectRefund(Connection conn) {
		
		Refund refund = new Refund();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectRefund");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, refund.getReserNo());
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				refund = new Refund();
				refund.setReserNo(rset.getInt("RE_RESER_NO"));
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
	
	
	
	
	
	
	
	
	
	
	
}