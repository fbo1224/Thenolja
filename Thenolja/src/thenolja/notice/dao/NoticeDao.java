package thenolja.notice.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import static thenolja.common.JDBCTemplate.*;

//import thenoleja.common.PagingVO;
import thenolja.notice.model.vo.Notice;


public class NoticeDao {

	private Properties prop = new Properties();
	
	public NoticeDao() {
	
	String fileName = NoticeDao.class
							   .getResource("/sql/notice/notice-mapper.xml")
							   .getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}//method
	
	/*
	 * 공지사항 목록 조회
	 * 
	 * */
	public ArrayList<Notice> selectNoticeList(Connection conn){ //selectNoticeList 호출
		
		System.out.println("[NoticeDao conn] " + conn);
		
		ArrayList<Notice> list = new ArrayList(); // 힙 영역 공간 주소값
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectNoticeList");
		System.out.println("[NoticeDao selectNoticeList sql] " + sql);
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery(); // 실제 쿼리문이 수행되는 부분
			
			while(rset.next()) {
				//while 반복문 안에 지역변수 
				Notice notice = new Notice();
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));		
				notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				notice.setNoticeContent(rset.getString("NOTICE_CONTENT"));
				notice.setWriter(rset.getString("WRITER"));
				notice.setCreateDate(rset.getString("CREATE_DATE"));
				notice.setViewCount(rset.getInt("NOTICE_VIEW_COUNT"));
				notice.setStatus(rset.getString("STATUS"));
				
				list.add(notice);
			}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	
	
	}//method
	
	/*
	 * 공지사항 상세화면 조회 (회원)
	 * 
	 * */
	public Notice selectNoticeOne(Connection conn, int noticeNo) {
		
		System.out.println("[NoticeDao selectNoticeOne noticeNo] " + noticeNo);  
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Notice notice  = null;
		String sql = prop.getProperty("selectNoticeOne");
		System.out.println("[NoticeDao selectNoticeOne] " + sql);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,noticeNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				notice = new Notice();
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));
				notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				notice.setNoticeContent(rset.getString("NOTICE_CONTENT"));
				notice.setStatus(rset.getString("STATUS"));
				notice.setCreateDate(rset.getString("CREATE_DATE"));
				notice.setWriter(rset.getString("WRITER"));
			}	
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn);
			close(pstmt);
		}
		
		return notice;
	
	}//method
	
	
	/*
	 * 공지사항 상세페이지 진입 시 조회 수 업데이트
	 * 
	 * */
	public int increaseViewCount(Connection conn, int noticeNo) {

		System.out.println("[NoticeDao increaseViewCount] " + noticeNo);

		int result = 0;
		Notice notice = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateNoticeViewCount");
		System.out.println(sql);
		
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			result = pstmt.executeUpdate();
			
			System.out.println("[NoticeDao increaseViewCount] result " + result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	/*
	 * 공지사항 상세페이지 진입 시 조회 수 업데이트
	 * 
	 * */	
	public Notice selectNotice(Connection conn, int noticeNo) {
		
		Notice notice = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				notice = new Notice();
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));
				notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				notice.setNoticeContent(rset.getString("NOTICE_CONTENT"));
				notice.setCreateDate(rset.getString("CREATE_DATE"));
				notice.setWriterNo(rset.getInt("WRITER_NO"));
				notice.setStatus(rset.getString("STATUS"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return notice;
	}//method          //반환 notice
	
	/*
	 * 공지사항 등록
	 * 
	 * */	
	public int insertNotice(Connection conn, Notice notice) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNotice");
		System.out.println("[NoticeDao insert sql] " + sql);
		//데이터 입력받을 파일 NOtice파일
		System.out.println("[NOTICE DAO INSERT] " + notice.getNoticeTitle());
		System.out.println("[NOTICE DAO INSERT] " + notice.getNoticeContent());
		System.out.println("[NOTICE DAO INSERT] " + notice.getStatus());
		
		try {
			
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2, notice.getNoticeContent());
			pstmt.setString(3, notice.getStatus());
		
			result = pstmt.executeUpdate();	
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		
		
		return result;
	}//method
	
	/*
	 * 공지사항 수정
	 * 
	 * */		
	public int updateNoticeOne(Connection conn, Notice notice) {
		
		System.out.println("[NOTICEDAO PARAM 확인]");
		System.out.println(notice);
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateNoticeOne");
		System.out.println("[NoticeDao updateNoticeOne] " + sql);
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2, notice.getNoticeContent());
			pstmt.setString(3, notice.getStatus());
			pstmt.setInt   (4, notice.getNoticeNo());
			
			result = pstmt.executeUpdate();
			
			System.out.println("[NoticeDao updateNoticeOne] " + result);
			
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
	public int deleteNoticeOne(Connection conn, int noticeNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteNoticeOne");
		System.out.println("[NoticeDao delete sql] " + sql);
		System.out.println("[NOTICE DAO DELETE] " + noticeNo);
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);

			result = pstmt.executeUpdate();	
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		return result;
		
	}//method	
	
	
	public int delete(Connection conn, String userNo) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("delete");
		
		try {
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setInt(1, Integer.parseInt(userNo));
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
			return result;
			
		}//method   try~ with ~ 
	
	
	// 전체 게시글 수
	public int getTotal(Connection conn) {
		int result = 0;
		
		
		
		return result;
	}
	
/*
	private Properties prop = new Properties();
	
	public ArrayList<NoticeVO> selectNoticeList(Connection conn){
		
		ArrayList<NoticeVO> list = new ArrayList(); // 힙 영역 공간 주소값
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectNoticeList");
		//								
		try {
			pstmt = conn.prepareStatement(sql);
		
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				/*NoticeVO noticeList = new NoticeVO();
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));		
				notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				notice.setNoticeWriter(rset.getString("USER_NAME"));
				notice.setCreateDate(rset.getDate("CREATE_DATE")); 
				
				list.add(notice);*/
		//	}// while문 안 지역변수
			
/*
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	
	}//method
*/	
/*
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
*/


















}//DAO의 역할 : DB 외부데이터를 "입력"하는곳
