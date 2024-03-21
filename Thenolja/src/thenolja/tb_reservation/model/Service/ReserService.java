package thenolja.tb_reservation.model.Service;

import thenolja.tb_reservation.cotroller.Coupon;
import thenolja.tb_reservation.model.dao.ReserDao;
import thenolja.tb_reservation.model.vo.Reservation;
import static thenolja.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

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
	
	

}
