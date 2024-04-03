package thenolja.tb_review.model.dao;

import static thenolja.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import thenolja.common.model.vo.PageInfo;
import thenolja.tb_review.model.vo.Review;

public class ReviewDao {
	
	private Properties prop = new Properties();
	
	public ReviewDao() {
		
		String filePath = ReviewDao.class.getResource("/sql/tb_review/review-mapper.xml")
							.getPath();
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public int selectListCount(Connection conn) {
		
	      int listCount = 0;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      String sql = prop.getProperty("selectListCount");
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	     //    pstmt.setInt(1, roomNo);
	         rset = pstmt.executeQuery();
	         
	         rset.next();
	         
	         listCount = rset.getInt("COUNT(*)");
	         
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	      
	      return listCount;
	}
	
	public ArrayList<Review> selectList(Connection conn, int hotelNo){
		
		ArrayList<Review> reviewList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
	        
	        pstmt.setInt(1, hotelNo);
	         
	        rset = pstmt.executeQuery();		
	        while(rset.next()) {
	        	
	        	Review r = new Review();
	        	r.setNickName(rset.getString("NICKNAME"));
	        	r.setReserNo(rset.getInt("RV_RESER_NO"));
	        	r.setImgPath(rset.getString("IMG_PATH"));
	        	r.setContent(rset.getString("REVIEW_CONTENT"));
	        	r.setScore(rset.getString("REVIEW_SCORE"));
	        	r.setCreateDate(rset.getDate("CREATE_DATE"));
	    		r.setHotelNo(rset.getInt("HOTEL_NO"));
				r.setHotelName(rset.getString("HOTEL_NAME"));
				r.setRoomName(rset.getString("ROOM_NAME"));
				r.setRoomNo(rset.getInt("ROOM_NO"));
				r.setRoomPrice(rset.getInt("ROOM_PRICE"));
				r.setMemNo(rset.getInt("MEM_NO"));
				r.setPaymentPrice(rset.getInt("PAYMENT_PRICE"));
				r.setHotelPath(rset.getString("HOTEL_PATH"));
	        	
	        	reviewList.add(r);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return reviewList;
	}
	public int insertReview(Connection conn, Review review) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, review.getReserNo());
			pstmt.setString(2, review.getImgPath());
			pstmt.setString(3, review.getContent());
			pstmt.setString(4, review.getScore());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


	public ArrayList<Review> selectReviewList(Connection conn, int reMemNo) {
		
		ArrayList<Review> myList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReviewList");
		
		try {
			pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, reMemNo);
	        rset = pstmt.executeQuery();		
	        while(rset.next()) {
	        	Review r = new Review();
	        	r.setNickName(rset.getString("NICKNAME"));
	        	r.setReserNo(rset.getInt("RV_RESER_NO"));
	        	r.setImgPath(rset.getString("IMG_PATH"));
	        	r.setContent(rset.getString("REVIEW_CONTENT"));
	        	r.setScore(rset.getString("REVIEW_SCORE"));
	        	r.setCreateDate(rset.getDate("CREATE_DATE"));
	    		r.setHotelNo(rset.getInt("HOTEL_NO"));
				r.setHotelName(rset.getString("HOTEL_NAME"));
				r.setRoomName(rset.getString("ROOM_NAME"));
				r.setRoomNo(rset.getInt("ROOM_NO"));
				r.setRoomPrice(rset.getInt("ROOM_PRICE"));
				r.setMemNo(rset.getInt("MEM_NO"));
				r.setPaymentPrice(rset.getInt("PAYMENT_PRICE"));
				r.setHotelPath(rset.getString("HOTEL_PATH"));
				
				myList.add(r);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return myList;
	
	}


	public Review selectReview(Connection conn, int reserNo) {
		
		Review review = new Review();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, reserNo);
	        rset = pstmt.executeQuery();		
			
		if(rset.next()) {
        	
        	review = new Review();
        	review.setNickName(rset.getString("NICKNAME"));
        	review.setReserNo(rset.getInt("RV_RESER_NO"));
        	review.setImgPath(rset.getString("IMG_PATH"));
        	review.setContent(rset.getString("REVIEW_CONTENT"));
        	review.setScore(rset.getString("REVIEW_SCORE"));
        	review.setCreateDate(rset.getDate("CREATE_DATE"));
        	review.setHotelNo(rset.getInt("HOTEL_NO"));
        	review.setHotelName(rset.getString("HOTEL_NAME"));
        	review.setRoomName(rset.getString("ROOM_NAME"));
        	review.setRoomNo(rset.getInt("ROOM_NO"));
        	review.setRoomPrice(rset.getInt("ROOM_PRICE"));
        	review.setMemNo(rset.getInt("MEM_NO"));
        	review.setPaymentPrice(rset.getInt("PAYMENT_PRICE"));
        	review.setHotelPath(rset.getString("HOTEL_PATH"));
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return review;
	}


	public int deleteReview(Connection conn, int reserNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, reserNo);
	        result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}



}
