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
	 * �씠踰ㅽ듃 紐⑸줉 議고쉶
	 * 
	 * */
	public ArrayList<Event> selectEventList(){
		
		Connection con = getConnection();	// SQL-MAPPER�옉�꽦�맂 SQL 諛쏆븘�떞湲�
		ArrayList<Event> list = null;
		
		try {
			// dao�뿉�꽌 db connection �깮�꽦�븯怨� �뜲�씠�꽣 議고쉶�빐�꽌 list�뿉 �떞�븘�꽌 諛섑솚
			list = new EventDao().selectEventList(con);
			System.out.println("[EventServiceImpl selectEventList] " + list);
			for(int i=0; i<list.size(); i++) {
				System.out.println("[EventServiceImpl content] " + list.get(i).getEventContent());
				System.out.println("[EventServiceImpl date] " + list.get(i).getEventDate());
				System.out.println("[EventServiceImpl eventYn] " + list.get(i).getEventYn());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}//method
	
	/*
	 * �씠踰ㅽ듃 �벑濡�
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
	 * �씠踰ㅽ듃 �닔�젙
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
		
		
	}	
	
}
