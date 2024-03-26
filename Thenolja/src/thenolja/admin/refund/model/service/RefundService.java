package thenolja.admin.refund.model.service;

import java.sql.Connection;

import thenolja.admin.refund.model.dao.RefundDao;
import thenolja.common.JDBCTemplate;

public class RefundService {
	
	public void selectRefundMemCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		new RefundDao().selectRefundMemCount(conn);
		
		
		
		
	}

}
