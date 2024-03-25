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
	
	/**
	 * 예약 회원 reserNo 가져오기
	 */
	public AdminReservation selectDetailReserMember(int reserNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		AdminReservation adminReser = new ReservationDao().selectDetailReserMember(conn, reserNo);
		
		JDBCTemplate.close(conn);
		
		return adminReser;
	
	}
	
	
	
	
	

}
