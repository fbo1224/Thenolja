package thenolja.admin.nonMember.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import thenolja.admin.nonMember.model.dao.NonMemDao;
import thenolja.admin.nonMember.model.vo.NonMember;
import thenolja.common.JDBCTemplate;

public class NonMemService {
	
	public ArrayList<NonMember> selectNonMemberList() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<NonMember> list =new NonMemDao().selectNonMemberList(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	
	}

}
