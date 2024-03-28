package thenolja.admin.review.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import thenolja.admin.review.model.dao.ReviewDao;
import thenolja.admin.review.model.vo.AdminComment;
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
	
	/**
	 * 리뷰 상세 조회
	 */
	public AdminReview detailMemberReview(int reserNo) {
		
		Connection conn  = JDBCTemplate.getConnection();
		
		AdminReview adminReview = new ReviewDao().detailMemberReview(conn, reserNo);
		
		JDBCTemplate.close(conn);
		
		return adminReview;
		
	}
	
	/**
	 * 리뷰 삭제
	 */
	
	public int deleteMemberReview(int reserNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new ReviewDao().deleteMemberReview(conn, reserNo);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
		
	}
	
	/**
	 * 대댓글 추가
	 */
	public int insertComment(AdminComment adminComment) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new ReviewDao().insertComment(conn, adminComment);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}
	
	
	/**
	 * 대댓글 조회
	 */
	public AdminComment selectCommentList(int reserNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		new ReviewDao().selectCommentList(conn, reserNo);
		
		
	}

}
