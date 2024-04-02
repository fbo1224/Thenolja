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
	 * 이벤트 목록 조회
	 * 
	 * */
	public ArrayList<Event> selectEventList(Connection conn){
		
		// 이벤트 목록 조회할 list 선언
		ArrayList<Event> list = new ArrayList();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectEventList");
		System.out.println("[EventDao selectEventList] " + sql);
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				// 조회 결과 Event 객체에 담기
				Event evnt = new Event();
				evnt.setEventNo(rset.getInt("EVENT_NO"));
				evnt.setEventTitle(rset.getString("EVENT_TITLE"));
				evnt.setEventContent(rset.getString("EVENT_CONTENT"));
				evnt.setEventStrtDt(rset.getString("EVENT_STRT_DT"));
				evnt.setEventEndDt(rset.getString("EVENT_END_DT"));
				evnt.setEventYn(rset.getString("EVENT_YN"));
				evnt.setEventImg(rset.getString("EVENT_IMG"));
				evnt.setWriter(rset.getString("WRITER"));
				
				// event객체에 담은 내용 list에 추가
				list.add(evnt);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}//method
	
	/*
	 * 공지사항 등록
	 * 
	 * */	
	public int insertEvent(Connection conn, Event event) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertEvent");
		System.out.println("[EventDao insert sql] " + sql);
		//데이터 입력받을 파일 NOtice파일
		System.out.println("[EVENT DAO INSERT] " + event.getEventTitle());
		System.out.println("[EVENT DAO INSERT] " + event.getEventContent());
		System.out.println("[EVENT DAO INSERT] " + event.getEventYn());
		System.out.println("[EVENT DAO INSERT] " + event.getEventStrtDt());
		System.out.println("[EVENT DAO INSERT] " + event.getEventEndDt());
		System.out.println("[EVENT DAO INSERT] " + event.getEventImg());
		
		try {
			
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, event.getEventTitle());
			pstmt.setString(2, event.getEventContent());
			pstmt.setString(3, event.getEventYn());
			pstmt.setString(4, event.getEventStrtDt());
			pstmt.setString(5, event.getEventEndDt());
			
			pstmt.setString (6, event.getEventImg());
		
			result = pstmt.executeUpdate();	
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		return result;
	}//method
	
	/*
	 * 이벤트 수정
	 * 
	 * */		
	public int updateEventOne(Connection conn, Event event) {
		
		System.out.println("[EventDAO PARAM 확인]");
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
			pstmt.setString(3, event.getEventStrtDt());
			pstmt.setString(4, event.getEventEndDt());
			pstmt.setString(5, event.getEventYn());
			pstmt.setInt   (6, event.getEventNo());
			pstmt.setString (7, event.getEventImg());
			
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
	
	/*
	 * 공지사항 삭제
	 * 
	 * */	
	public int deleteEventOne(Connection conn, int eventNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteEventOne");
		System.out.println("[EventDao delete sql] " + sql);
		System.out.println("[EVENT DAO DELETE] " + eventNo);
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eventNo);

			result = pstmt.executeUpdate();	
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		return result;
		
	}//method	
	

}//DAO의 역할 : DB 외부데이터를 "입력"하는곳
	
	
	
	
	

