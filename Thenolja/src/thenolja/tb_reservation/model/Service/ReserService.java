package thenolja.tb_reservation.model.Service;

import static thenolja.common.JDBCTemplate.close;
import static thenolja.common.JDBCTemplate.commit;
import static thenolja.common.JDBCTemplate.getConnection;
import static thenolja.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import thenolja.tb_coupon.model.vo.Coupon;
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

	public ArrayList<Coupon> selectCoupon() {
		
		Connection conn = getConnection();
		
		ArrayList<Coupon> list = new ReserDao().selectCoupon(conn);
		
		close(conn);
		
		return list;
	}
	
	public int selectReserNo(int reserNo) {
		
		Connection conn = getConnection();
		
		int result = new ReserDao().selectReserNo(conn, reserNo);
		
		close(conn);
		
		return result;
	}
	
	/*
	public Reservation selectReservation(int reserNo) {
		
		Connection conn = getConnection();
		
		Reservation reser = new ReserDao().selectReservation(conn, reserNo);
		
		close(conn);
		
		return reser;
	}
	*/
	
	public Reservation selectLastReservation() {
		
		Connection conn = getConnection();
		
		Reservation reser = new ReserDao().selectLastReservation(conn);
		
		close(conn);
		
		return reser;
	}
}
