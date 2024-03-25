package thenolja.admin.reservation.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import thenolja.admin.member.model.vo.AdminMember;
import thenolja.admin.reservation.model.vo.AdminReservation;
import thenolja.common.JDBCTemplate;
import thenolja.common.model.vo.PageInfo;

public class ReservationDao {
		
		private Properties prop = new Properties();
		
		public ReservationDao() {
			
			String fileName = ReservationDao.class.getResource("/sql/admin/reservation/reservation-mapper.xml").getPath();		
		
			try {
				prop.loadFromXML(new FileInputStream(fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	
	
	/**
	 * RESER COUNT
	 */
	public int selectReserCount(Connection conn) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReserCount");
		
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
	 * 예약 목록 조회
	 */
	
	public ArrayList<AdminReservation> selectReserMember(Connection conn, PageInfo pi) {
		
		ArrayList<AdminReservation> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReserMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				AdminReservation adminReser = new AdminReservation();
				adminReser.setReserNo(rset.getInt("RESER_NO"));
				adminReser.setMemId(rset.getString("MEM_ID"));
				adminReser.setReserName(rset.getString("RESER_NAME"));
				adminReser.setMemPhone(rset.getString("MEM_PHONE"));
				
				list.add(adminReser);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	
	/**
	 * 예약 상세 조회
	 */
	public AdminReservation selectReserMember(Connection conn, int reserNo){
		
		AdminReservation adminReser = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReserMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				adminReser = new AdminReservation();
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return adminReser;
	}

	
	
	
	
}
