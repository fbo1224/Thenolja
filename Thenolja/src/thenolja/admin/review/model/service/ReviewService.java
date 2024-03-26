package thenolja.admin.review.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import thenolja.admin.review.model.dao.ReviewDao;
import thenolja.admin.review.model.vo.AdminReview;
import thenolja.common.JDBCTemplate;
import thenolja.common.model.vo.PageInfo;

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
	
	/**
	 * 리뷰 목록 조회
	 */
	public ArrayList<AdminReview> selectReviewMemberList(PageInfo pi){
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<AdminReview> list = new ReviewDao().selectReviewMemberList(conn, pi);
		
		JDBCTemplate.close(conn);
		
		return list;
		
	}

}
