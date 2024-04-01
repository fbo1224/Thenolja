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
	
	public ArrayList<Review> selectList(Connection conn, PageInfo pi, int hotelNo){
		
		ArrayList<Review> reviewList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
	        int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
	        int endRow = startRow + pi.getBoardLimit() - 1;
	        
	        pstmt.setInt(1, hotelNo);
	        pstmt.setInt(2, startRow);
	        pstmt.setInt(3, endRow);
	         
	        rset = pstmt.executeQuery();		
	        while(rset.next()) {
	        	
	        	Review r = new Review();
	        	r.setNickName(rset.getString("NICKNAME"));
	        	r.setReserNo(rset.getInt("RV_RESER_NO"));
	        	r.setImgPath(rset.getString("IMG_PATH"));
	        	r.setContent(rset.getString("REVIEW_CONTENT"));
	        	r.setScore(rset.getInt("REVIEW_SCORE"));
	        	r.setCreateDate(rset.getDate("CREATE_DATE"));
	    		r.setHotelNo(rset.getInt("HOTEL_NO"));
				r.setHotelName(rset.getString("HOTEL_NAME"));
				r.setRoomName(rset.getString("ROOM_NAME"));
				r.setCheckInTime(rset.getString("CHECKIN_TIME"));
				r.setCheckOutTime(rset.getString("CHECKOUT_TIME"));
				r.setReserDate(rset.getDate("RESER_DATE"));
				r.setName(rset.getString("RESER_NAME"));
				r.setPhone(rset.getString("RESER_PHONE"));
				r.setBicycle(rset.getString("BICYCLE"));
				r.setCheckIn(rset.getString("CHECKIN_TIME"));
				r.setCheckOut(rset.getString("CHECKOUT_TIME"));
				r.setPeople(rset.getInt("MAX_PEOPLE"));
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
			pstmt.setInt(4, review.getScore());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
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
	        while(rset.next()) {
	        	
	        	Review r = new Review();
	        	r.setReserNo(rset.getInt("RV_RESER_NO"));
	        	r.setImgPath(rset.getString("IMG_PATH"));
	        	r.setContent(rset.getString("REVIEW_CONTENT"));
	        	r.setScore(rset.getInt("REVIEW_SCORE"));
	        	r.setCreateDate(rset.getDate("CREATE_DATE"));
	        	
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return review;
	
	}

}
