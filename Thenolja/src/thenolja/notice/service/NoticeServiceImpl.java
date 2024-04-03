package thenolja.notice.service;

import static thenolja.common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import thenolja.notice.dao.NoticeDao;
import thenolja.notice.model.vo.Notice;


public class NoticeServiceImpl{

	
	/*
	 * 공지사항 목록 조회
	 * 
	 * */	
	public ArrayList<Notice> selectNoticeList(){
		
		Connection conn = getConnection(); // SQL-MAPPER작성된 SQL 받아담기
		ArrayList<Notice> list = null;
		
		try {
			// dao에서 db connection 생성하고 데이터 조회해서 list에 담아서 반환
			list = new NoticeDao().selectNoticeList(conn);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		// DB연결정보 종료
		close(conn);
		
		return list;
	}//method
	
	/*
	 * 공지사항 상세화면 조회 (회원)
	 * 
	 * */
	public Notice selectNoticeOne(int noticeNo, String flag) {
		
		System.out.println("[NoticeServiceimpl selectNoticeOne noticeNo] " + noticeNo);  
		System.out.println("[NoticeServiceimpl selectNoticeOne flag] " 	   + flag);  
		Connection conn = getConnection();
		Notice result = null;
		int viewCount = 0;
		
		try {
			
			// 1. 공지사항 상세페이지 진입 시 조회 수 업데이트 (상세페이지 진입 시에만)
			if("N".equals(flag)) viewCount = new NoticeDao().increaseViewCount(conn, noticeNo);
			else viewCount = 1; // 공지사항 수정/삭제 페이지 진입 시 조회 수 count 임의 값 설정
			
			if(viewCount > 0) {
				// 2. 공지사항 상세페이지 조회
				result = new NoticeDao().selectNoticeOne(conn,noticeNo);
				close(conn);
			}else {
				close(conn);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}//method

	/*
	 * 공지사항 상세페이지 진입 시 조회 수 업데이트
	 * 
	 * */
	public int increaseViewCount(int noticeNo) {
		
		System.out.println("[NoticeService increaseViewCount] " + noticeNo);
		Connection conn = getConnection(); // SQL-MAPPER작성된 SQL 받아담기
		int result = 0;
		
		result = new NoticeDao().increaseViewCount(conn, noticeNo);
		
		return result;
	}
	
	/*
	 * 공지사항 등록
	 * 
	 * */
	public int insertNotice(Notice notice) {
		
		Connection conn = getConnection();
		int result = 0;
		
		try {
			result = new NoticeDao().insertNotice(conn, notice);

			if(result > 0) commit(conn);
			else rollback(conn);
			
			close(conn);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}//method
	
	
	/*
	 * 공지사항 수정
	 * 
	 * */	
	public int updateNoticeOne(Notice notice) {
		
		Connection conn = getConnection();
		int result = 0;
		
		try {
			
			result = new NoticeDao().updateNoticeOne(conn,notice);
			
			if(result > 0)
				 commit(conn);
			else rollback(conn);
			
			close(conn);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		
		return result;
		
	}	
	
	/*
	 * 공지사항 삭제
	 * 
	 * */
	public int deleteNoticeOne(int noticeNo) {
		
		Connection conn = getConnection();
		int result = 0;
		
		try {
			
			result = new NoticeDao().deleteNoticeOne(conn, noticeNo);
			
			if(result > 0) commit(conn);
			else rollback(conn);
			
			close(conn);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}//method
		
}
