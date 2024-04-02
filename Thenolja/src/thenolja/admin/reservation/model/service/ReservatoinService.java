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
	
	/**
	 * 환불처리
	 */
	public int refundReser(int reserNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new ReservationDao().refundReser(conn, reserNo);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	/**
	 * 비회원 예약 수
	 */
	public int selectNonMemCount() {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new ReservationDao().selectNonMemCount(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	
	/**
	 * 비회원 예약 목록
	 */
	public ArrayList<AdminReservation> selectReserNonMember(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<AdminReservation> list = new ReservationDao().selectReserNonMember(conn, pi);
		
		JDBCTemplate.close(conn);
		
		return list;
		
	}
	
	/**
	 * 예약 회원 검색
	 */
	public ArrayList<AdminReservation> searchReserMember(String keyword) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<AdminReservation> list = new ReservationDao().searchReserMember(conn, keyword);
		
		JDBCTemplate.close(conn);
		
		return list;
		
	}
	
	/**
	 * 예약 비회원 검색
	 */
	public ArrayList<AdminReservation> searchNonMemName(String keyword){
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<AdminReservation> list = new ReservationDao().searchNonMemName(conn, keyword);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	
	/**
	 * 메인 페이지 예약 
	 */
	public ArrayList<AdminReservation> reserTopFive(){
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<AdminReservation> list = new ReservationDao().reserTopFive(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	/**
	 * 메인페이지 예약 수
	 */
	public int todayReserCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new ReservationDao().todayReserCount(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	/**
	 * 메인페이지 가격
	 */
	public int todayPrice() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new ReservationDao().todayPrice(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	/**
	 * 오래된 회원 예약 
	 */
	public ArrayList<AdminReservation> reserOldestList(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<AdminReservation> list = new ReservationDao().reserOldestList(conn, pi);
		
		JDBCTemplate.close(conn);
		
		return list;
		
	}
	
	/**
	 * 오래된 비회원 예약
	 */
	public ArrayList<AdminReservation> oldReserNonMember(PageInfo pi){
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<AdminReservation> list = new ReservationDao().oldReserNonMember(conn, pi);
		
		JDBCTemplate.close(conn);
		
		return list;
		
		
	}
	

}
