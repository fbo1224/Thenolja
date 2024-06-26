package thenolja.admin.refund.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import thenolja.admin.refund.model.dao.RefundDao;
import thenolja.admin.refund.model.vo.AdminRefund;
import thenolja.common.JDBCTemplate;
import thenolja.common.model.vo.PageInfo;

public class RefundService {
	
	
	/**
	 * 페이징
	 */
	public int selectRefundMemCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new RefundDao().selectRefundMemCount(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	/**
	 * 회원 환불 조회
	 */
	public ArrayList<AdminRefund> selectRefundMemberList(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<AdminRefund> list = new RefundDao().selectRefundMemberList(conn, pi);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	/**
	 * 회원 상세 조회
	 */
	public AdminRefund selectRefundMember(int reserNo) {
		
		Connection conn  = JDBCTemplate.getConnection();
		
		AdminRefund adminRefund = new RefundDao().selectRefundMember(conn, reserNo);
		
		JDBCTemplate.close(conn);
		
		return adminRefund;
	}
	
	/**
	 * 비회원 환불 수
	 */
	
	public int selectRefundNonMemberCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new RefundDao().selectRefundNonMemberCount(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	
	/**
	 * 비회원 목록
	 */
	public ArrayList<AdminRefund> selectRefundNonMemberList(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<AdminRefund> list = new RefundDao().selectRefundNonMemberList(conn, pi);
		
		JDBCTemplate.close(conn);
		
		return list;
		
	}
	
	/**
	 * 회원 환불
	 */
	public ArrayList<AdminRefund> selectRefundeMemberId(String keyword) {
		
		Connection conn =JDBCTemplate.getConnection();
		
		ArrayList<AdminRefund> list = new RefundDao().selectRefundeMemberId(conn, keyword);
		
		JDBCTemplate.close(conn);
		
		return list;
		
	}
	
	/**
	 * 비회원 환불 검색
	 */
	public ArrayList<AdminRefund> searchRefundNonMem(String keyword) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<AdminRefund> list = new RefundDao().searchRefundNonMem(conn, keyword);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	/**
	 * 메인페이지 환불
	 */
	public ArrayList<AdminRefund> selectRefundTop(){
		
		Connection conn  = JDBCTemplate.getConnection();
		
		ArrayList<AdminRefund> list = new RefundDao().selectRefundTop(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	/**
	 * 회원 환불 오래된 순
	 */
	
	public ArrayList<AdminRefund> OldRefundMemberList(PageInfo pi){
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<AdminRefund> list = new RefundDao().OldRefundMemberList(conn, pi);
		
		JDBCTemplate.close(conn);
		
		return list;
		
	}
	
	/**
	 * 비회원 환불 오래된 순
	 */
	public ArrayList<AdminRefund> oldRefundNonMemberList(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<AdminRefund> list = new RefundDao().oldRefundNonMemberList(conn, pi);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	
}
