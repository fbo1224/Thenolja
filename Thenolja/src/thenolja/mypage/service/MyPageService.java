package thenolja.mypage.service;

import java.sql.Connection;
import java.util.ArrayList;

import thenolja.common.JDBCTemplate;
import thenolja.mypage.dao.MyPageDao;
import thenolja.mypage.model.vo.MyPageHeartList;
import thenolja.mypage.model.vo.Profile;

public class MyPageService {
	
	public ArrayList<MyPageHeartList> selectHeartList(int memNo){
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<MyPageHeartList> list = new MyPageDao().selectHeartList(conn, memNo);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
//------------------------------프로필사진 있는지 확인---------------------------
	public String selectProfile(int memNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		String filePath = new MyPageDao().selectProfile(conn, memNo);
		
		JDBCTemplate.close(conn);
		
		return filePath;
	}
//----------------------------프로필 사진 인서트-----------------------------------------
	public int insertProfile(Profile profile) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MyPageDao().insertProfile(conn, profile);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
	
	
	
	
	
	
	
}
