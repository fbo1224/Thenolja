package thenolja.tb_reservation.model.Service;

import thenolja.tb_reservation.model.dao.ReserDao;
import thenolja.tb_reservation.model.vo.Reservation;
import static thenolja.common.JDBCTemplate.*;

import java.sql.Connection;

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
	
	

}
