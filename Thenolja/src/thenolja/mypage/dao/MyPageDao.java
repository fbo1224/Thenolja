package thenolja.mypage.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import thenolja.member.model.dao.MemberDao;

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
	
	
	
	
	
}
