package thenolja.nonmem.service;

import java.sql.Connection;

import thenolja.common.JDBCTemplate;
import thenolja.member.model.vo.Member;
import thenolja.nonmem.dao.NonmemDao;
import thenolja.nonmem.model.vo.SelectNonmemReser;

public class NonmemService {
	
	public Member selectNonmemReser(String nonmemName, String nonmemPhone) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		SelectNonmemReser nonmemReser = new NonmemDao().selectNonmemReser(conn, nonmemName, nonmemPhone);
		
		JDBCTemplate.close(conn);
		
		
		return nonmemReser;
	}
	
	
	
	
	
}
