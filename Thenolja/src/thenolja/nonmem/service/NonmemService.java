package thenolja.nonmem.service;

import java.sql.Connection;
import java.util.ArrayList;
import static thenolja.common.JDBCTemplate.*;
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
		
		Connection conn = getConnection();
		
		int result = new NonmemDao().insertNonMem(conn, nonmem);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public Member SelectNonmem() {
		
		Connection conn = getConnection();
		
		Member member = new NonmemDao().selectNonMem(conn);
		
		close(conn);
		
		return member;
	}
	/*
	public Member selectNonMemNo(int memNo) {
		
		Connection conn = getConnection();
		
		Member member = new NonmemDao().selectNonMemNo(conn, memNo);
		
		close(conn);
		
		return member;
	}
	*/
	
	
	
}
