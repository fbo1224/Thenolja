package thenolja.admin.refund.model.service;

import java.sql.Connection;

import thenolja.admin.refund.model.dao.RefundDao;
import thenolja.common.JDBCTemplate;

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

}
