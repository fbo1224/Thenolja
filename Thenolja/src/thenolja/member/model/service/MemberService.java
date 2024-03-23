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
//-----------------------------아이디 중복확인-----------------------
	public int idCheck(String checkId) {
		Connection conn = JDBCTemplate.getConnection();
		
		int count = new MemberDao().idCheck(conn, checkId);
		
		JDBCTemplate.close(conn);
		
		return count;
	}
//---------------------------------정보수정-----------------------------
	public int updateMember(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().updateMember(conn, member);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	
	
	
	
}
