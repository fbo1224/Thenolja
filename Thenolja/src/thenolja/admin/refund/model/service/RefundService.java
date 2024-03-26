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

}
