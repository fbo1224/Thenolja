package thenolja.nonmem.dao;

import static thenolja.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import thenolja.member.model.vo.Member;
import thenolja.tb_reservation.model.dao.ReserDao;

public class NonmemDao {

	private Properties prop = new Properties();
	
	public NonmemDao() {
		String fileName = ReserDao.class.getResource("/sql/nonmem/nonmem-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int insertNonMem(Connection conn, Member nonmem) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNonMem");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nonmem.getMemName());
			pstmt.setString(2, nonmem.getMemPhone());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
