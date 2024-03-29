package thenolja.admin.nonMember.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import thenolja.admin.nonMember.model.dao.NonMemDao;
import thenolja.admin.nonMember.model.vo.NonMember;
import thenolja.common.JDBCTemplate;
import thenolja.common.model.vo.PageInfo;

public class NonMemService {
	
	/**
	 * 페이징
	 */
	
	public int selectListCount() {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new NonMemDao().selectListCount(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	
	/**
	 * 비회원 전체 조회
	 */
	public ArrayList<NonMember> selectNonMemberList(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<NonMember> list =new NonMemDao().selectNonMemberList(conn, pi);
		
		JDBCTemplate.close(conn);
		
		return list;
	
	}
	
	/**
	 * 비회원 번호 가져오기
	 */
	public int deleteNonMember(int nonMemNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new NonMemDao().deleteNonMember(conn, nonMemNo);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	/**
	 * 비회원 이름으로 검색
	 */
	public NonMember selectNonMemberName(String keyword) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		NonMember nonMember = new NonMemDao().selectNonMemberName(conn, keyword);
		
		JDBCTemplate.close(conn);
		
		return nonMember;
	}
	
	
	
	
	
}
