package thenolja.admin.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import thenolja.admin.member.model.dao.MemberDao;
import thenolja.admin.member.model.vo.Member;
import thenolja.common.JDBCTemplate;


public class MemberService {
	
	

	public ArrayList<Member> selectMemberList() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> list = new MemberDao().selectMemberList(conn);
		
		JDBCTemplate.close(conn);
		
		return list;	
		
	}
	
	/*public Member selectIdMember(String memId) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Member member = new MemberDao().selectIdMember(conn, memId);
		
		JDBCTemplate.close(conn);
		
		return member;
		
	}*/
	
	public Member selectMember(int memNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Member member = new MemberDao().selectMember(conn, memNo);
		
		JDBCTemplate.close(conn);
		
		return member;
	}
	
	
	/**
	 * 
	 *삭제
	 */
	public int deleteMember(int memNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().deleteMember(conn, memNo);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	
	
	
	
	
}
