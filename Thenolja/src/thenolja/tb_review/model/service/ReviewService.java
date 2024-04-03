package thenolja.tb_review.model.service;

import static thenolja.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import thenolja.common.model.vo.PageInfo;
import thenolja.tb_review.model.dao.ReviewDao;
import thenolja.tb_review.model.vo.Review;

public class ReviewService {

	public int selectListCount() {
		
      Connection conn = getConnection();
      
      int result = new ReviewDao().selectListCount(conn);
      
      if(result > 0) {commit(conn);
      } else {
    	  rollback(conn);
      }
      close(conn);
      
      return result;
	}

	public ArrayList<Review> selectList(PageInfo pi, int hotelNo) {
		
		Connection conn = getConnection();
		  
		ArrayList<Review> reviewList = new ReviewDao().selectList(conn, pi, hotelNo);
		  
		close(conn);
		
		return reviewList;
	}

	public int insertReview(Review review) {
		
		Connection conn = getConnection();
		
		int result = new ReviewDao().insertReview(conn, review);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public ArrayList<Review> selectReviewList(int reMemNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Review> reviewList = new ReviewDao().selectReviewList(conn, reMemNo);
		
		close(conn);
		
		return reviewList;
	}
	
	public Review selectReview(int reserNo) {
		
		Connection conn = getConnection();
		
		Review review = new ReviewDao().selectReview(reserNo);
		
		close(conn);
		
		return review;
	}

}
