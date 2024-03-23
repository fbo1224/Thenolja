package thenolja.tb_reservation.model.dao;

import static thenolja.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import thenolja.tb_coupon.model.vo.Coupon;
import thenolja.tb_reservation.model.vo.Reservation;

public class ReserDao {
	
	private Properties prop = new Properties();
	
	public ReserDao() {
		String fileName = ReserDao.class.getResource("/sql/tb_reservation/reser-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertReser(Connection conn, Reservation reser) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReser");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reser.getName());
			pstmt.setString(2, reser.getPhone());
			pstmt.setString(3, reser.getBicycle());
			// pstmt.setString(4, reser.getCheckIn());
			// pstmt.setString(5, reser.getCheckOut());
			// pstmt.setInt(4, reser.getPeople());
			// pstmt.setString(7, reser.getPayment());
			// pstmt.setInt(8, reser.getPaymentPrice());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Coupon> selectCoupon(Connection conn) {
		
		ArrayList<Coupon> list = new ArrayList();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectCoupon");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Coupon c = new Coupon();
				c.setCouponNo(rset.getInt("COUPON_NO"));
				c.setCouponContent(rset.getString("COUPON_CONTENT"));
				c.setCouponDate(rset.getDate("COUPON_DATE"));
				//c.setCouponYN(rset.getString("COUPON_YN"));
				c.setCouponCode(rset.getString("COUPON_CODE"));
				
				list.add(c);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	public int selectReserNo(Connection conn, int reserNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectReserNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reserNo);
				
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	public Reservation selectReservation(Connection conn, int reserNo) {
		
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
	

	
	
	
	
	
	
}
