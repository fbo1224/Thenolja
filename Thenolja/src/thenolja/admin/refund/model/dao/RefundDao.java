package thenolja.admin.refund.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import thenolja.admin.refund.model.vo.AdminRefund;
import thenolja.common.JDBCTemplate;
import thenolja.common.model.vo.PageInfo;


public class RefundDao {
	
private Properties prop = new Properties();
	
	public RefundDao() {
		
		String fileName = RefundDao.class.getResource("/sql/admin/refund/refund-mapper.xml").getPath();		
	
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * 페이징
	 */
	public int selectRefundMemCount(Connection conn) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectRefundMemCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			rset.next();
			
			listCount = rset.getInt("COUNT(*)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return listCount;

	}
	
	
	
	
	/**
	 * 환불 회원 목록
	 */
	public ArrayList<AdminRefund> selectRefundMemberList(Connection conn, PageInfo pi) {
		
		ArrayList<AdminRefund> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectRefundMemberList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				AdminRefund adminRefund = new AdminRefund();
				
				adminRefund.setReserNo(rset.getInt("RF_RESER_NO"));
				adminRefund.setMemId(rset.getString("MEM_ID"));
				adminRefund.setReserName(rset.getString("RESER_NAME"));
				adminRefund.setMemPhone(rset.getString("MEM_PHONE"));
				
				list.add(adminRefund);
				
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
