package thenolja.admin.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import thenolja.admin.member.model.vo.Member;
import thenolja.common.JDBCTemplate;

public class MemberDao {
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		
		String fileName = MemberDao.class.getResource("/sql/admin/member/member-mapper.xml").getPath();		
	
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 멤버 전체 조회 페이지
	 */
	public ArrayList<Member> selectMemberList(Connection conn){

	      ArrayList<Member> list = new ArrayList();
	      ResultSet rset = null;
	      PreparedStatement pstmt = null;
	      
	      String sql = prop.getProperty("selectMemberList");
	      
	      try {
	    	  
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();

			while(rset.next()) {
				Member member = new Member();
	            member.setMemNo(rset.getInt("MEM_NO"));
	            member.setMemId(rset.getString("MEM_ID"));
	            member.setNickName(rset.getString("NICKNAME"));
	            member.setGradeName(rset.getString("GRADE_NAME"));
	            list.add(member);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	         JDBCTemplate.close(rset);
	         JDBCTemplate.close(pstmt);
	      }

	      return list;	
	}
	

}