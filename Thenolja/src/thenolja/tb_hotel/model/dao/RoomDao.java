package thenolja.tb_hotel.model.dao;

import static thenolja.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import thenolja.tb_hotel.model.vo.Room;

public class RoomDao {
	private Properties prop = new Properties();
	
	public RoomDao() {
		String filePath = HotelDao.class.getResource("/sql/tb_hotel/tb_room-mapper.xml")
				.getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int countRoom(Connection conn, int hotelNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("countRoom");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hotelNo);
			
			rset = pstmt.executeQuery();
			rset.next();
			result = rset.getInt("COUNT(*)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
	
	public int insertRoom(Connection conn, Room r) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertRoom");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r.getHotelNo());
			pstmt.setString(2, r.getRoomName());
			pstmt.setString(3, r.getCheckInTime());
			pstmt.setString(4, r.getCheckOutTime());
			pstmt.setInt(5, r.getRoomNum());
			pstmt.setInt(6, r.getRoomPrice());
			pstmt.setInt(7, r.getMaxPeople());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int insertRoomImg(Connection conn, Room r) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertRoomImg");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getRoomImgPath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
