package thenolja.tb_hotel.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import thenolja.tb_hotel.model.vo.Hotel;
import static thenolja.common.JDBCTemplate.*;

public class HotelDao {
	private Properties prop = new Properties();
	
	public HotelDao() {
		String filePath = HotelDao.class.getResource("/sql/tb_hotel/tb_hotel-mapper.xml")
			    						.getPath();

		System.out.println(filePath);

		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 호텔추가
	public int insertHotel(Connection conn, Hotel h) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertHotel");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, h.getHostName());
			pstmt.setString(2, h.getHotelPhone());
			pstmt.setString(3, h.getHotelLocation());
			pstmt.setString(4, h.getHotelAddress());
			pstmt.setString(5, h.getHotelCategory());
			pstmt.setString(6, h.getHotelPath());
			pstmt.setString(7, h.getHotelIntro());
			pstmt.setString(8, h.getHostName());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
