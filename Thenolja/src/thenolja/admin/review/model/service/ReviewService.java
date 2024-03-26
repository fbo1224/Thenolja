package thenolja.admin.review.model.service;

import java.sql.Connection;

import thenolja.admin.review.model.dao.ReviewDao;
import thenolja.common.JDBCTemplate;

public class ReviewService {
	
	/**
	 * 페이징
	 */
	public int selectReviewCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new ReviewDao().selectReviewCount(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}

}
