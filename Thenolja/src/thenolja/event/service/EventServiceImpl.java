package thenolja.event.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import thenolja.event.dao.EventDao;
import thenolja.event.model.vo.Event;
import thenolja.notice.dao.NoticeDao;
import thenolja.notice.model.vo.Notice;

import static thenolja.common.JDBCTemplate.*;

public class EventServiceImpl {

	
	/*
	 * 
	 * 이벤트 목록 조회
	 * 
	 * */
	public ArrayList<Event> selectEventList(){
		
		Connection con = getConnection();	// SQL-MAPPER작성된 SQL 받아담기
		ArrayList<Event> list = null;
		
		try {
			// dao에서 db connection 생성하고 데이터 조회해서 list에 담아서 반환
			list = new EventDao().selectEventList(con);
			System.out.println("[EventServiceImpl selectEventList] " + list);
			for(int i=0; i<list.size(); i++) {
				System.out.println("[EventServiceImpl content] " + list.get(i).getEventContent());
				System.out.println("[EventServiceImpl date] " + list.get(i).getEventStrtDt());
				System.out.println("[EventServiceImpl date]" + list.get(i).getEventEndDt());
				System.out.println("[EventServiceImpl eventYn] " + list.get(i).getEventYn());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}//method
	
	/*
	 * 이벤트 등록
	 * 
	 * */
	public int insertEvent(Event event) {
		
		Connection conn = getConnection();
		int result = 0;
		
		try {
			result = new EventDao().insertEvent(conn, event);

			if(result > 0) commit(conn);
			else rollback(conn);
			
			close(conn);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	
	
	
	
	
	
	
	}//method
	
	/*
	 * 이벤트 수정
	 * 
	 * */	
	public int updateEventOne(Event event) {
		
		Connection conn = getConnection();
		int result = 0;
		
		try {
			
			result = new EventDao().updateEventOne(conn,event);
			
			if(result > 0)
				 commit(conn);
			else rollback(conn);
			
			close(conn);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		
		return result;
		
		
	}//method
	
	/*
	 * 공지사항 삭제
	 * 
	 * */
	public int deleteEventOne(int eventNo) {
		
		Connection conn = getConnection();
		int result = 0;
		
		try {
			
			result = new EventDao().deleteEventOne(conn, eventNo);
			
			if(result > 0) commit(conn);
			else rollback(conn);
			
			close(conn);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}//method
	
	
}
