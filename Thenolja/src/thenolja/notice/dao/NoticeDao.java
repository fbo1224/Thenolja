package thenoleja.notice.dao;

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
import static thenoleja.common.JDBCTemplate.*;

import thenoleja.notice.model.vo.Notice;


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
		
		return ;
	
	}//method
	
	/*
	 * 怨듭��궗�빆 紐⑸줉 議고쉶
	 * 
	 * */
	public ArrayList<Notice> selectNoticeList(Connection conn){ //selectNoticeList �샇異�
		
		System.out.println("[NoticeDao conn] " + conn);
		
		ArrayList<Notice> list = new ArrayList(); // �옓 �쁺�뿭 怨듦컙 二쇱냼媛�
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectNoticeList");
		System.out.println("[NoticeDao selectNoticeList sql] " + sql);
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery(); // �떎�젣 荑쇰━臾몄씠 �닔�뻾�릺�뒗 遺�遺�
			
			while(rset.next()) {
				//while 諛섎났臾� �븞�뿉 吏��뿭蹂��닔 
				Notice notice = new Notice();
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));		
				notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				notice.setNoticeContent(rset.getString("NOTICE_CONTENT"));
				notice.setWriter(rset.getString("WRITER"));
				notice.setCreateDate(rset.getString("CREATE_DATE"));
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
	 * 怨듭��궗�빆 �긽�꽭�솕硫� 議고쉶 (�쉶�썝)
	 * 
	 * */
	public Notice selectNoticeOne(Connection conn, int noticeNo) {
		
		System.out.println("[NoticeDao selectNoticeOne noticeNo] " + noticeNo);  
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Notice notice  = null;
		String sql = prop.getProperty("selectNoticeOne");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,noticeNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				notice = new Notice();
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));
				notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				notice.setNoticeContent(rset.getString("NOTICE_CONTENT"));
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
	
	public Notice selectNotice(Connection conn, int noticeNo) {
		
		Notice notice = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNotice");
		
		
		try {
			pstmt =conn.prepareStatement(sql);
		
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
	}//method          //諛섑솚 notice
	
	
	
	public int insertNotice(Connection conn, Notice notice) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNotice");
		System.out.println("[NoticeDao insert sql] " + sql);
		//�뜲�씠�꽣 �엯�젰諛쏆쓣 �뙆�씪 NOtice�뙆�씪
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
	
public int increaseCount(Connection conn, int noticeNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}//method


	public int update(Connection conn, Notice notice) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("update");
		
		try {
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2, notice.getNoticeContent());
			pstmt.setInt(3, notice.getNoticeNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
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
		
		
		
		
		
	
	







	
	
	
/*
	private Properties prop = new Properties();
	
	public ArrayList<NoticeVO> selectNoticeList(Connection conn){
		
		ArrayList<NoticeVO> list = new ArrayList(); // �옓 �쁺�뿭 怨듦컙 二쇱냼媛�
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
		//	}// while臾� �븞 吏��뿭蹂��닔
			
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


















}//DAO�쓽 �뿭�븷 : DB �쇅遺��뜲�씠�꽣瑜� "�엯�젰"�븯�뒗怨�
