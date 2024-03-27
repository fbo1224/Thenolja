package thenolja.tb_refund.model.service;

import java.sql.Connection;

import thenolja.tb_refund.model.dao.RefundDao;
import thenolja.tb_refund.model.vo.Refund;
import thenolja.tb_reservation.model.vo.Reservation;

import static thenolja.common.JDBCTemplate.*;

public class RefundService {

	public int insertRefund(Refund refund) {
		
		Connection conn = getConnection();
		
		int result = new RefundDao().insertRefund(conn, refund);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Refund selectRefund(int reserNo) {
		
		Connection conn = getConnection();
		
		Refund refund = new RefundDao().selectRefund(conn, reserNo);
		
		close(conn);
		
		return refund;
	}
/*
	public Refund selectRefundNo(int reserNo) {

		Connection conn = getConnection();
		
		Refund refund = new RefundDao().selectRefundNo(conn, reserNo);
		
		close(conn);
		
		return refund;
	}
	*/

	public Reservation selectReservation(int reserNo) {

		Connection conn = getConnection();
		
		Reservation reser = new RefundDao().selectRervation(conn, reserNo);
		
		close(conn);
		
		return reser;
	}

	public int updateRefund(Refund refund) {
		
		Connection conn = getConnection();
		
		int result = new RefundDao().updateRefund(conn, refund);
		
		if(result > 0 ) {
			commit(conn);
		} else{
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int deleteReser(int reserNo) {
		
		Connection conn = getConnection();
		
		int result = new RefundDao().deleteReser(conn, reserNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	
	
	

}
