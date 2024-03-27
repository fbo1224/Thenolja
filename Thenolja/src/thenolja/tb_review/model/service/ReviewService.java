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
      
      close(conn);
      
      return result;
	}

	public ArrayList<Review> selectList(PageInfo pi) {
		
		
		return null;
	}

}
