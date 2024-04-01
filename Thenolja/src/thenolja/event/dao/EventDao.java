package thenolja.event.dao;

import static thenolja.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import thenolja.event.model.vo.Event;
import thenolja.notice.model.vo.Notice;

public class EventDao {

	private Properties prop = new Properties();
	
	public EventDao() {
		String fileName = EventDao.class
								  .getResource("/sql/event/event-mapper.xml")
								  .getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 
	 * �씠踰ㅽ듃 紐⑸줉 議고쉶
	 * 
	 * */
	public ArrayList<Event> selectEventList(Connection conn){
		
		// �씠踰ㅽ듃 紐⑸줉 議고쉶�븷 list �꽑�뼵
		ArrayList<Event> list = new ArrayList();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectEventList");
		System.out.println("[EventDao selectEventList] " + sql);
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				// 議고쉶 寃곌낵 Event 媛앹껜�뿉 �떞湲�
				Event evnt = new Event();
				evnt.setEventNo(rset.getInt("EVENT_NO"));
				evnt.setEventContent(rset.getString("EVENT_CONTENT"));
				evnt.setEventDate(rset.getString("EVENT_DATE"));
				evnt.setEventYn(rset.getString("EVENT_YN"));
				evnt.setEventImg(rset.getString("EVENT_IMG"));
				evnt.setWriter(rset.getString("WRITER"));
				
				// event媛앹껜�뿉 �떞�� �궡�슜 list�뿉 異붽�
				list.add(evnt);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}//method
	
	/*
	 * 怨듭��궗�빆 �벑濡�
	 * 
	 * */	
	public int insertEvent(Connection conn, Event event) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertEvent");
		System.out.println("[EventDao insert sql] " + sql);
		//�뜲�씠�꽣 �엯�젰諛쏆쓣 �뙆�씪 NOtice�뙆�씪
		System.out.println("[EVENT DAO INSERT] " + event.getEventTitle());
		System.out.println("[EVENT DAO INSERT] " + event.getEventContent());
		System.out.println("[EVENT DAO INSERT] " + event.getEventYn());
		System.out.println("[EVENT DAO INSERT] " + event.getEventDate());
		System.out.println("[EVENT DAO INSERT] " + event.getEventImg());
		
		try {
			
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, event.getEventTitle());
			pstmt.setString(2, event.getEventContent());
			pstmt.setString(3, event.getEventYn());
			pstmt.setString(4, event.getEventDate());
			pstmt.setString (5, event.getEventImg());
		
			result = pstmt.executeUpdate();	
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		return result;
	}//method
	
	/*
	 * �씠踰ㅽ듃 �닔�젙
	 * 
	 * */		
	public int updateEventOne(Connection conn, Event event) {
		
		System.out.println("[EventDAO PARAM �솗�씤]");
		System.out.println(	event.getEventTitle());
		System.out.println(event.getEventContent());
		System.out.println(event.getEventNo());
		System.out.println(event.getEventImg());
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateEventOne");
		System.out.println("[EventDao updateEventOne] " + sql);
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, event.getEventTitle());
			pstmt.setString(2, event.getEventContent());
			pstmt.setString(3, event.getEventDate());
			pstmt.setString(4, event.getEventYn());
			pstmt.setInt   (5, event.getEventNo());
			pstmt.setString (6, event.getEventImg());
			
			result = pstmt.executeUpdate();
			
			System.out.println("[EventDAO updateEventOne] " + result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
		
		return result;
		
	}//method
	
	
	
}
