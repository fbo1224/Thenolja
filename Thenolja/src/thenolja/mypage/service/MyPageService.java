package thenolja.mypage.service;

import java.sql.Connection;
import java.util.ArrayList;

import thenolja.common.JDBCTemplate;
import thenolja.mypage.dao.MyPageDao;
import thenolja.mypage.model.vo.MyPageHeartList;

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
	
	
	
	
	
	
	
	
}
