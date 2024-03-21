package thenolja.member.model.service;

import java.sql.Connection;

import thenolja.common.JDBCTemplate;
import thenolja.member.model.dao.MemberDao;
import thenolja.member.model.vo.Member;

public class MemberService {
	
//-------------------로그인----------------------------
	public Member login(String memId, String memPwd) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Member loginUser = new MemberDao().login(conn, memId, memPwd);
		
		JDBCTemplate.close(conn);
		
		return loginUser;
		
	}
	
//----------------- 회원가입 ---------------------------------
	public int insertMember(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().insertMember(conn, member);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);;
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	
	
	
	
	
	
	
}
