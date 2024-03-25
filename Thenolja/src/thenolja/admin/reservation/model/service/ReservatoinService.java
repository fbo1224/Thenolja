package thenolja.admin.reservation.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import thenolja.admin.reservation.model.dao.ReservationDao;
import thenolja.admin.reservation.model.vo.AdminReservation;
import thenolja.common.JDBCTemplate;
import thenolja.common.model.vo.PageInfo;

public class ReservatoinService {
	
	
	/**
	 * RESER COUNT
	 */
	public int selectReserCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new ReservationDao().selectReserCount(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	
	/**
	 * 예약 회원 목록 조회
	 */
	public ArrayList<AdminReservation> selectReserMember(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<AdminReservation> list = new ReservationDao().selectReserMember(conn, pi);
	
		JDBCTemplate.close(conn);
		
		return list;
	
	}
	
	public void selectReserMember(int reserNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		new ReservationDao().selectReserMember(conn, reserNo);
	}
	
	
	

}
