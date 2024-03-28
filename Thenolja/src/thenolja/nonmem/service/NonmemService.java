package thenolja.nonmem.service;

import java.sql.Connection;
import java.util.ArrayList;

import thenolja.common.JDBCTemplate;
import thenolja.member.model.vo.Member;
import thenolja.nonmem.dao.NonmemDao;
import thenolja.nonmem.model.vo.SelectNonmemReser;


public class NonmemService {
	
	public ArrayList<SelectNonmemReser> selectNonmemReser(String nonmemName, String nonmemPhone) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<SelectNonmemReser> list = new NonmemDao().selectNonmemReser(conn, nonmemName, nonmemPhone);
		
		JDBCTemplate.close(conn);
		
		
		return list;
	}
	
	public int insertNonMem(Member nonmem) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new NonmemDao().insertNonMem(conn, nonmem);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public Member SelectNonmem() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Member member = new NonmemDao().selectNonMem(conn);
		
		JDBCTemplate.close(conn);
		
		return member;
	}
	
	public Member selectNonMemNo(int memNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Member member = new NonmemDao().selectNonMemNo(conn, memNo);
		
		JDBCTemplate.close(conn);
		
		return member;
	}
	


	
	
	
	
	
	
	
}
