package thenolja.tb_hotel.model.dao;

import static thenolja.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	
	public ArrayList<Room>updateRoomList(Connection conn, int hotelNo) {
		ArrayList<Room> rooms = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("updateRoomList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hotelNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Room r = new Room();
				r.setHotelNo(hotelNo);
				r.setRoomNo(rset.getInt("ROOM_NO"));
				r.setRoomName(rset.getString("ROOM_NAME"));
				r.setCheckInTime(rset.getString("CHECKIN_TIME")+":00");
				r.setCheckOutTime(rset.getString("CHECKOUT_TIME")+":00");
				r.setRoomNum(rset.getInt("ROOM_NUM"));
				r.setRoomPrice(rset.getInt("ROOM_PRICE"));
				r.setMaxPeople(rset.getInt("MAX_PEOPLE"));
				r.setRoomImgPath(rset.getString("ROOM_IMG"));
				r.setRoomImgNo(rset.getInt("ROOM_IMG_NO"));
				rooms.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return rooms;
	}
	
	public Room updateRoomForm(Connection conn, int roomNo) {
		Room r = new Room();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("updateRoomForm");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roomNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				r.setRoomName(rset.getString("ROOM_NAME"));
				r.setCheckInTime(rset.getString("CHECKIN_TIME")+":00");
				r.setCheckOutTime(rset.getString("CHECKOUT_TIME")+":00");
				r.setRoomNum(rset.getInt("ROOM_NUM"));
				r.setRoomPrice(rset.getInt("ROOM_PRICE"));
				r.setMaxPeople(rset.getInt("MAX_PEOPLE"));
				r.setRoomImgPath(rset.getString("ROOM_IMG"));
				r.setHotelNo(rset.getInt("HOTEL_NO"));
				r.setRoomImgNo(rset.getInt("ROOM_IMG_NO"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return r;
	}
	
	public int updateRoom(Connection conn, Room r) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateRoom");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getRoomName());
			pstmt.setInt(2, r.getMaxPeople());
			pstmt.setString(3, r.getCheckInTime());
			pstmt.setString(4, r.getCheckOutTime());
			pstmt.setInt(5, r.getRoomPrice());
			pstmt.setInt(6, r.getRoomNum());
			pstmt.setInt(7, r.getRoomNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateRoomImg(Connection conn, Room r) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateRoomImg");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getRoomImgPath());
			pstmt.setInt(2, r.getRoomNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}	
		return result;
	}
	
	public int deleteRoom(Connection conn, int roomNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteRoom");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roomNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
