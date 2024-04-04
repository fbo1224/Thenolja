package thenolja.nonmem.service;

import static thenolja.common.JDBCTemplate.close;
import static thenolja.common.JDBCTemplate.commit;
import static thenolja.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import thenolja.common.JDBCTemplate;
import thenolja.member.model.vo.Member;
import thenolja.nonmem.dao.NonmemDao;
import thenolja.nonmem.model.vo.SelectNonmemReser;
import thenolja.tb_reservation.model.dao.ReserDao;
import thenolja.tb_reservation.model.vo.Reservation;


public class NonmemService {
	
	public ArrayList<SelectNonmemReser> selectNonmemReser(String nonmemName, int nonmemNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<SelectNonmemReser> list = new NonmemDao().selectNonmemReser(conn, nonmemName, nonmemNo);
		
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
	
	public ArrayList<SelectNonmemReser> selectReserInfo(String memName, int memNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<SelectNonmemReser> list = new NonmemDao().selectReserInfo(conn, memName, memNo);
		
		JDBCTemplate.close(conn);
		
		
		return list;
	}

	public Member insertNonMember(Member nonmem) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new NonmemDao().insertNonMember(conn, nonmem);
		
		Member non = null;
		if(result > 0) {
			non = new NonmemDao().selectNonMemer(conn);
		if(non != null) {
			commit(conn);}
		} else {
			rollback(conn);
		}
			close(conn);
		
		return non;	
	}

	
	
	
	
	
	
	
}
