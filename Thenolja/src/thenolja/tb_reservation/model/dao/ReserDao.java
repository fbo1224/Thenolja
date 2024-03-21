package thenolja.tb_reservation.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import static thenolja.common.JDBCTemplate.*;

import thenolja.tb_reservation.model.Service.Coupon;
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
			pstmt.setString(4, reser.getPayment());
			
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
		
		
		return list;
	}

}
