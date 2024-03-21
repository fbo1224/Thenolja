package thenolja.admin.nonMember.model.dao;

import java.util.Properties;

public class NonMemDao {
	
	private Properties prop = new Properties();
	
	public NonMemDao() {
		
		String fileName = NonMemDao.class.getResource("/sql/admin/nonMember/nonMember-mapper.xml").getPath();
	}

}
