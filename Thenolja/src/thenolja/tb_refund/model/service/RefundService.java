package thenolja.tb_refund.model.service;

import java.sql.Connection;

import thenolja.tb_refund.model.vo.Refund;
import static thenolja.common.JDBCTemplate.*;

public class RefundService {

	public int insertRefund(Refund refund) {
		
		Connection conn = getConnection();
		return 0;
	}
	
	
	
	

}
