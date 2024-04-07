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
import thenolja.tb_hotel.model.vo.Hotel;
import thenolja.tb_hotel.model.vo.Room;
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
			pstmt.setString(4, reser.getCheckIn());
			pstmt.setString(5, reser.getCheckOut());
			pstmt.setInt(6, reser.getPeople());
			pstmt.setInt(7, reser.getRoomNo());
			pstmt.setInt(8, reser.getReMemNo());
			pstmt.setInt(9, reser.getPaymentPrice());
		//	System.out.println(reser);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertNonReser(Connection conn, Reservation reser, int reMemNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNonReser");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reser.getName());
			pstmt.setString(2, reser.getPhone());
			pstmt.setString(3, reser.getBicycle());
			pstmt.setString(4, reser.getCheckIn());
			pstmt.setString(5, reser.getCheckOut());
			pstmt.setInt(6, reser.getPeople());
			pstmt.setInt(7, reser.getRoomNo());
			pstmt.setInt(8, reMemNo);
			pstmt.setInt(9, reser.getPaymentPrice());
		//	System.out.println(reser);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Coupon> selectCouponList(Connection conn) {
		
		ArrayList<Coupon> list = new ArrayList();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectCouponList");
		
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
				c.setCouponPercent(rset.getInt("COUPON_PERCENT"));
				
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
	public Reservation selectReservation(Connection conn) {
		
		Reservation reser = new Reservation();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReservation");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				reser = new Reservation();
				reser.setReserNo(rset.getInt("RESER_NO"));
				reser.setReserDate(rset.getDate("RESER_DATE"));
				reser.setName(rset.getString("RESER_NAME"));
				reser.setPhone(rset.getString("RESER_PHONE"));
				reser.setBicycle(rset.getString("BICYCLE"));
				reser.setCheckInTime(rset.getString("CHECKIN_TIME"));
				reser.setCheckOutTime(rset.getString("CHECKOUT_TIME"));
				reser.setCheckIn(rset.getString("CHECKIN_DATE"));
				reser.setCheckOut(rset.getString("CHECKOUT_DATE"));
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
	public Reservation selectReserNo(Connection conn, int reserNo) {
		
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		Reservation reser = new Reservation();
		String sql = prop.getProperty("selectReserNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reserNo);	
			rset = pstmt.executeQuery();
			if(rset.next()) {
				reser = new Reservation();
				reser.setReserNo(rset.getInt("RESER_NO"));
				reser.setReserDate(rset.getDate("RESER_DATE"));
				reser.setName(rset.getString("RESER_NAME"));
				reser.setPhone(rset.getString("RESER_PHONE"));
				reser.setBicycle(rset.getString("BICYCLE"));
				reser.setCheckInTime(rset.getString("CHECKIN_TIME"));
				reser.setCheckOutTime(rset.getString("CHECKOUT_TIME"));
				reser.setCheckIn(rset.getString("CHECKIN_DATE"));
				reser.setCheckOut(rset.getString("CHECKOUT_DATE"));
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
	/*
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
	*/

	public ArrayList<Reservation> selectList(Connection conn, int reMemNo) {
		
		ArrayList<Reservation> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reMemNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Reservation reser = new Reservation();
				reser.setHotelNo(rset.getInt("HOTEL_NO"));
				reser.setHotelName(rset.getString("HOTEL_NAME"));
				reser.setRoomName(rset.getString("ROOM_NAME"));
				reser.setCheckInTime(rset.getString("CHECKIN_TIME"));
				reser.setCheckOutTime(rset.getString("CHECKOUT_TIME"));
				reser.setReserNo(rset.getInt("RESER_NO"));
				reser.setReserDate(rset.getDate("RESER_DATE"));
				reser.setName(rset.getString("RESER_NAME"));
				reser.setPhone(rset.getString("RESER_PHONE"));
				reser.setBicycle(rset.getString("BICYCLE"));
				reser.setCheckIn(rset.getString("CHECKIN_DATE"));
				reser.setCheckOut(rset.getString("CHECKOUT_DATE"));
				reser.setPeople(rset.getInt("MAX_PEOPLE"));
				reser.setRoomNo(rset.getInt("ROOM_NO"));
				reser.setRoomPrice(rset.getInt("ROOM_PRICE"));
				reser.setReMemNo(rset.getInt("RE_MEM_NO"));
				reser.setPayment(rset.getString("PAYMENT"));
				reser.setPaymentPrice(rset.getInt("PAYMENT_PRICE"));
				reser.setHotelPath(rset.getString("HOTEL_PATH"));
				
				list.add(reser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	public Hotel selectHotelNo(Connection conn, int hotelNo) {
		
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		Hotel hotel = new Hotel();
		String sql = prop.getProperty("selectHotelNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hotelNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				hotel = new Hotel();
				hotel.setHotelNo(rset.getInt("HOTEL_NO"));
				hotel.setHotelName(rset.getString("HOTEL_NAME"));
				hotel.setHotelPhone(rset.getString("HOTEL_PHONE"));
				hotel.setHotelLocation(rset.getString("HOTEL_LOCATION"));
				hotel.setHotelAddress(rset.getString("HOTEL_ADDRESS"));
				hotel.setHotelCategory(rset.getString("HOTEL_CATEGORY"));
				hotel.setHotelPath(rset.getString("HOTEL_PATH"));
				hotel.setHotelIntro(rset.getString("HOTEL_INTRO"));
				hotel.setHostName(rset.getString("HOST_NAME"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return hotel;
	}

	public Hotel selectHotel(Connection conn) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		Hotel hotel = new Hotel();
		String sql = prop.getProperty("selectHotel");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				hotel = new Hotel();
				hotel.setHotelNo(rset.getInt("HOTEL_NO"));
				hotel.setHotelName(rset.getString("HOTEL_NAME"));
				hotel.setHotelPhone(rset.getString("HOTEL_PHONE"));
				hotel.setHotelLocation(rset.getString("HOTEL_LOCATION"));
				hotel.setHotelAddress(rset.getString("HOTEL_ADDRESS"));
				hotel.setHotelCategory(rset.getString("HOTEL_CATEGORY"));
				hotel.setHotelPath(rset.getString("HOTEL_PATH"));
				hotel.setHotelIntro(rset.getString("HOTEL_INTRO"));
				hotel.setHostName(rset.getString("HOST_NAME"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return hotel;
	}


	public Room selectRoom(Connection conn, int hotelNo, int roomNo) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		Room room = new Room();
		String sql = prop.getProperty("selectRoom");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hotelNo);
			pstmt.setInt(2, roomNo);
		//	System.out.println(roomNo);
		//	System.out.println(hotelNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				room = new Room();
				room.setRoomNo(rset.getInt("ROOM_NO"));
				room.setHotelNo(rset.getInt("HOTEL_NO"));
				room.setRoomName(rset.getString("ROOM_NAME"));
				room.setCheckInTime(rset.getString("CHECKIN_TIME"));
				room.setCheckOutTime(rset.getString("CHECKOUT_TIME"));
				room.setRoomNum(rset.getInt("ROOM_NUM"));
				room.setRoomPrice(rset.getInt("ROOM_PRICE"));
				room.setMaxPeople(rset.getInt("MAX_PEOPLE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return room;
		
	}

	public Room selectRoomNo(Connection conn, int hotelNo, int roomNum) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		Room room = new Room();
		String sql = prop.getProperty("selectRoomNo"); 
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hotelNo);
			pstmt.setInt(2, roomNum);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				room = new Room();
				room.setRoomNo(rset.getInt("ROOM_NO"));
				room.setHotelNo(rset.getInt("HOTEL_NO"));
				room.setRoomName(rset.getString("ROOM_NAME"));
				room.setCheckInTime(rset.getString("CHECKIN_TIME"));
				room.setCheckOutTime(rset.getString("CHECKOUT_TIME"));
				room.setRoomNum(rset.getInt("ROOM_NUM"));
				room.setRoomPrice(rset.getInt("ROOM_PRICE"));
				room.setMaxPeople(rset.getInt("MAX_PEOPLE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return room;
	}
	

	public int deleteReser(Connection conn, int reserNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteReser");
		
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

	public Reservation selectReser(Connection conn, int reserNo) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		Reservation reser = new Reservation();
		String sql = prop.getProperty("selectReser");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reserNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
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

	public ArrayList<Coupon> selectCoupon(Connection conn, int memberNo) {
		ArrayList<Coupon> cList = new  ArrayList();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectCoupon");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Coupon c = new Coupon();
				c.setCouponNo(rset.getInt("COUPON_NO"));
				c.setCouponContent(rset.getString("COUPON_CONTENT"));
				c.setCouponDate(rset.getDate("COUPON_DATE"));
				c.setCouponCode(rset.getString("COUPON_CODE"));
				c.setCouponPercent(rset.getInt("COUPON_PERCENT"));
				
				cList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return cList;
	}

	public Reservation selectNonReservation(Connection conn) {
		Reservation reser = new Reservation();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNonReservation");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				reser = new Reservation();
				reser.setReserNo(rset.getInt("CURRVAL"));
				reser.setReserDate(rset.getDate("RESER_DATE"));
				reser.setName(rset.getString("RESER_NAME"));
				reser.setPhone(rset.getString("RESER_PHONE"));
				reser.setBicycle(rset.getString("BICYCLE"));
				reser.setCheckInTime(rset.getString("CHECKIN_TIME"));
				reser.setCheckOutTime(rset.getString("CHECKOUT_TIME"));
				reser.setCheckIn(rset.getString("CHECKIN_DATE"));
				reser.setCheckOut(rset.getString("CHECKOUT_DATE"));
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

	public Coupon selectoCoupon(Connection conn, int couponNo) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		Coupon coupon = new Coupon();
		String sql = prop.getProperty("selectoCoupon");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, couponNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				coupon = new Coupon();
				coupon.setCouponNo(rset.getInt("COUPON_NO"));
				coupon.setCouponContent(rset.getString("COUPON_CONTENT"));
				coupon.setCouponDate(rset.getDate("COUPON_DATE"));
				coupon.setCouponCode(rset.getString("COUPON_CODE"));
				coupon.setCouponPercent(rset.getInt("COUPON_PERCENT"));
		
			}
			} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return coupon;
	}



	
	
	
	
	
	
}
