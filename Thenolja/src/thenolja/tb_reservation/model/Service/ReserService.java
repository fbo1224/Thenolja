package thenolja.tb_reservation.model.Service;

import static thenolja.common.JDBCTemplate.close;
import static thenolja.common.JDBCTemplate.commit;
import static thenolja.common.JDBCTemplate.getConnection;
import static thenolja.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import thenolja.tb_coupon.model.vo.Coupon;
import thenolja.tb_hotel.model.vo.Hotel;
import thenolja.tb_hotel.model.vo.Room;
import thenolja.tb_refund.model.vo.Refund;
import thenolja.tb_reservation.model.dao.ReserDao;
import thenolja.tb_reservation.model.vo.Reservation;

public class ReserService {

	public int insertReser(Reservation reser) {
		
		Connection conn = getConnection();
		
		int result = new ReserDao().insertReser(conn, reser);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public ArrayList<Coupon> selectCouponList() {
		
		Connection conn = getConnection();
		
		ArrayList<Coupon> list = new ReserDao().selectCouponList(conn);
		
		close(conn);
		
		return list;
	}
	/*
	public int selectReserNo(int reserNo) {
		
		Connection conn = getConnection();
		
		int result = new ReserDao().selectReserNo(conn, reserNo);
		
		close(conn);
		
		return result;
	}
	
	*/
	public Reservation selectReservation() {
		
		Connection conn = getConnection();
		
		Reservation reser = new ReserDao().selectReservation(conn);
		
		close(conn);
		
		return reser;
	}
	
	
	public Reservation selectReserNo(int reserNo) {
		
		Connection conn = getConnection();
		
		Reservation reser = new ReserDao().selectReserNo(conn, reserNo);
		
		close(conn);
		
		return reser;
	}

	public ArrayList<Reservation> selectList(int reMemNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Reservation> list = new ReserDao().selectList(conn, reMemNo);
		
		close(conn);
		
		return list;
	}
	public Hotel selectHotelNo(int hotelNo) {
		
		Connection conn = getConnection();
		
		Hotel hotel = new ReserDao().selectHotelNo(conn, hotelNo);
		
		close(conn);
		
		return hotel;
	}

	public Hotel selectHotel() {
		
		Connection conn = getConnection();
		
		Hotel hotel = new ReserDao().selectHotel(conn);
		
		close(conn);
		
		return hotel;
	}

	public Room selectRoom(int hotelNo, int roomNo) {
		Connection conn = getConnection();
		
		Room room = new ReserDao().selectRoom(conn, hotelNo, roomNo);
		
		close(conn);
		
		return room;
	}

	public Room selectRoomNo(int hotelNo, int roomNum) {
		Connection conn = getConnection();
		
		Room room = new ReserDao().selectRoomNo(conn, hotelNo, roomNum);
		
		close(conn);
		
		return room;
	}


	public int deleteReser(int reserNo) {

		Connection conn = getConnection();
		
		int result = new ReserDao().deleteReser(conn, reserNo);
		
		close(conn);
		
		return result;	
	}

	public Reservation selectReser(int reserNo) {
		
		Connection conn = getConnection();
		
		Reservation reser = new ReserDao().selectReser(conn, reserNo);
		
		close(conn);
		
		return reser;
	}

	public ArrayList<Coupon> selectCoupon(int memberNo) {
		Connection conn = getConnection();
		
		ArrayList<Coupon> couponList =  new ReserDao().selectCoupon(conn, memberNo);
		
		close(conn);
		
		return couponList;
	}





	

	
	
	
	
	
	
}
