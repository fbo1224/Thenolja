package thenolja.mypage.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import thenolja.common.JDBCTemplate;
import thenolja.member.model.dao.MemberDao;
import thenolja.mypage.model.vo.MyPageHeartList;

public class MyPageDao {
	
	private Properties prop = new Properties();
	
	public MyPageDao() {
		String sqlFile = MemberDao.class.getResource("/sql/member/member-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(sqlFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MyPageHeartList> selectHeartList(Connection conn, int memNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MyPageHeartList> list = new ArrayList();
		
		String sql = prop.getProperty("selectHeartList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				MyPageHeartList heartList = new MyPageHeartList(rset.getString("HOTEL_NAME"),
																rset.getString("HOTEL_LOCATION"),
																rset.getString("HOTEL_ADDRESS"),
																rset.getString("HOTEL_PATH"));
				list.add(heartList);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
//--------------------------------- 프사 유무 확인----------------------------------
	
	public String selectProfile(Connection conn, int memNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String filePath = "";
		int count = 0;
		
		String sql = prop.getProperty("selectProfile");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			
			rset = pstmt.executeQuery();
			
			System.out.println(rset);
			
			rset.next();
			//count = rset.getInt("COUNT(*)");
			
			filePath = rset.getString("PROFILE_PATH");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return filePath;
	}
	
	
	
	
	
	
	
	
	
	
	
}
