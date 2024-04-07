package thenolja.event.service;

import java.sql.Connection;
import java.util.ArrayList;

import thenolja.common.JDBCTemplate;
import thenolja.common.model.vo.PageInfo;
import thenolja.event.dao.EventDao;
import thenolja.event.model.vo.Event;
import thenolja.notice.dao.NoticeDao;
import thenolja.event.dao.EventDao;
import thenolja.event.model.vo.Event;

import static thenolja.common.JDBCTemplate.*;

public class EventServiceImpl {

	
	/*
	 * 
	 * 이벤트 목록 조회
	 * 
	 * */
	public ArrayList<Event> selectEventList(PageInfo pi){
		
		Connection con = getConnection();	// SQL-MAPPER작성된 SQL 받아담기
		ArrayList<Event> list = null;
		
		try {
			// dao에서 db connection 생성하고 데이터 조회해서 list에 담아서 반환
			list = new EventDao().selectEventList(con, pi);
			System.out.println("[EventServiceImpl selectEventList] " + list);
			for(int i=0; i<list.size(); i++) {
				System.out.println("[EventServiceImpl content] " + list.get(i).getEventContent());
				System.out.println("[EventServiceImpl date] "    + list.get(i).getEventStrtDt());
				System.out.println("[EventServiceImpl date] "    + list.get(i).getEventEndDt());
				System.out.println("[EventServiceImpl eventYn] " + list.get(i).getEventYn());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}

	/**
	 * 페이징(관리자)
	 * @return
	 */
	
	public int selectListCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new NoticeDao().selectListCount(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}	
	
	/*
	 * 
	 * 이벤트 등록
	 * 
	 * */
	public int insertEventInfo(Event evt) {
	
		Connection conn = getConnection();
		int result = 0;
		
		try {
			result = new EventDao().insertEventInfo(conn, evt);

			if(result > 0) commit(conn);
			else rollback(conn);
			
			close(conn);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;			
	}
	
	/*
	 * 이벤트 수정
	 * 
	 * */	
	public int updateEventOne(Event event) {
		
		Connection conn = getConnection();
		int result = 0;
		
		try {
			
			result = new EventDao().updateEventOne(conn, event);
			
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
	 * 이벤트 삭제
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
	
	/*
	 * 이벤트 상세화면 조회 (회원)
	 * 
	 * */
	public Event selectEventOne(int eventNo, String flag) {
		
		System.out.println("[EventServiceImpl selectEventOne eventNo] " + eventNo);  
		System.out.println("[EventServiceImpl selectEventOne flag] " 	   + flag);  
		Connection conn = getConnection();
		Event result = null;
		int viewCount = 0;
		
		try {
			
			// 1. 이벤트 상세페이지 진입 시 조회 수 업데이트 (상세페이지 진입 시에만)
			//if("N".equals(flag)) viewCount = new EventDao().increaseViewCount(conn, eventNo);
			//else viewCount = 1; // 이벤트 수정/삭제 페이지 진입 시 조회 수 count 임의 값 설정
			viewCount=1;
			
			if(viewCount > 0) {
				// 2. 공지사항 상세페이지 조회
				result = new EventDao().selectEventOne(conn,eventNo);
				close(conn);
			}else {
				close(conn);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}	
	
	
}
