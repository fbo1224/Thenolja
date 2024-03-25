package thenoleja.notice.service;

import static thenoleja.common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import thenoleja.notice.dao.NoticeDao;
import thenoleja.notice.model.vo.Notice;


public class NoticeServiceImpl{

	
	public ArrayList<Notice> selectNoticeList(){
		
		Connection conn = getConnection(); // SQL-MAPPER�옉�꽦�맂 SQL 諛쏆븘�떞湲�
		
		try {
			System.out.println("[NoticeServiceImpl DriverName] " 	+ conn.getMetaData().getDriverName());
			System.out.println("[NoticeServiceImpl URL] " 			+ conn.getMetaData().getURL());
			System.out.println("[NoticeServiceImpl UserName] " 		+ conn.getMetaData().getUserName());
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// dao�뿉�꽌 db connection �깮�꽦�븯怨� �뜲�씠�꽣 議고쉶�빐�꽌 list�뿉 �떞�븘�꽌 諛섑솚
		ArrayList<Notice> list = new NoticeDao().selectNoticeList(conn);
		
		// DB�뿰寃곗젙蹂� 醫낅즺
		close(conn);
		
		return list;
	}//method

	
	/*
	 * 怨듭��궗�빆 �긽�꽭�솕硫� 議고쉶 (�쉶�썝)
	 * 공지사항 조회
	 * */
	public Notice selectNoticeOne(int noticeNo) {
		
		System.out.println("[NoticeServiceimpl selectNoticeOne noticeNo] " + noticeNo);  
		Connection conn = getConnection();
		
		Notice result = new NoticeDao().selectNoticeOne(conn,noticeNo);
		
		return result;
		
	}//method

	/*
	 * 怨듭��궗�빆 �벑濡�
	 * 공지사항 등록
	 * */
	public int insertNotice(Notice notice) {
		
		Connection conn = getConnection();
		
		int result = new NoticeDao().insertNotice(conn, notice);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
		
	}//method
	
	//공지사항 조회 수
public int increaseCount(int noticeNo) {
		
		Connection conn = getConnection();
		
		int result = new NoticeDao().increaseCount(conn, noticeNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	//공지사항 수정
	public int update(Notice notice) {
		
		
		Connection conn = getConnection();
		
		int result = new NoticeDao().update(conn,notice);
		
		if(result > 0)
			commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
		
		
	}//method
	
	public void delete() {
		
	}
	
	
	

}
