package com.kh.thenolja.tb_review.model.service;

import static com.kh.thenolja.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.thenolja.common.model.vo.PageInfo;
import com.kh.thenolja.tb_review.model.dao.ReviewDao;
import com.kh.thenolja.tb_review.model.vo.Review;

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
