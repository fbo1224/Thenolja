package thenolja.admin.review.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import thenolja.admin.review.model.vo.AdminComment;
import thenolja.admin.review.model.vo.AdminReview;
import thenolja.common.JDBCTemplate;
import thenolja.common.model.vo.PageInfo;

public class ReviewDao {
	
	private Properties prop = new Properties();
	
	public ReviewDao() {
		
		String fileName = ReviewDao.class.getResource("/sql/admin/review/review-mapper.xml").getPath();		
	
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 페이징
	 */
	 public int selectReviewCount(Connection conn) {
		 
		 int listCount = 0;
		 PreparedStatement pstmt = null;
		 ResultSet rset = null;
		 String sql = prop.getProperty("selectReviewCount");
		 
		 try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			rset.next();
			
			listCount = rset.getInt("COUNT(*)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		 return listCount;
	 }
	 
	 /**
	  * 리뷰 목록 조회
	  */
	 public ArrayList<AdminReview> selectReviewMemberList(Connection conn, PageInfo pi){
		 
		 ArrayList<AdminReview> list = new ArrayList();
		 PreparedStatement pstmt = null;
		 ResultSet rset = null;
		 String sql = prop.getProperty("selectReviewMemberList");
		 
		 try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				AdminReview adminReview = new AdminReview();
				adminReview.setHotelName(rset.getString("HOTEL_NAME"));
				adminReview.setMemId(rset.getString("MEM_ID"));
				adminReview.setNickName(rset.getString("NICKNAME"));
				adminReview.setCreateDate(rset.getString("CREATE_DATE"));
				adminReview.setReserNo(rset.getInt("RV_RESER_NO"));
				list.add(adminReview);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		 
		 return list;
	 }
	 
	 /**
	  * 리뷰 상세 조회
	  */
	 public AdminReview detailMemberReview(Connection conn, int reserNo) {
		 
		 PreparedStatement pstmt = null;
		 AdminReview adminReview = null;
		 ResultSet rset = null;
		 String sql = prop.getProperty("detailMemberReview");
		 
		 try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reserNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				adminReview = new AdminReview();
				adminReview.setHotelName(rset.getString("HOTEL_NAME"));
				adminReview.setRoomName(rset.getString("ROOM_NAME"));
				adminReview.setReviewScore(rset.getString("REVIEW_SCORE"));
				adminReview.setReviewContent(rset.getString("REVIEW_CONTENT"));
				adminReview.setImgPath(rset.getString("IMG_PATH"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		 
		 return adminReview;
	 }
	 
	 /**
	  * 리뷰 삭제
	  */
	 public int deleteMemberReview(Connection conn, int reserNo) {
		 
		 int result = 0;
		 PreparedStatement pstmt = null;
		 ResultSet rset = null;
		 String sql = prop.getProperty("deleteMemberReview");
		 
		 try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reserNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		 
		 return result;
	 }
	 
	 
	 /**
	  * 대댓글 추가
	  */
	 public int insertComment(Connection conn, AdminComment adminComment) {
		 
		 int result = 0;
		 PreparedStatement pstmt = null;
		 String sql = prop.getProperty("insertComment");
		 
		 try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, adminComment.getCommentReserNo());
			pstmt.setString(2, adminComment.getCommentContent());
			pstmt.setInt(3, Integer.parseInt(adminComment.getCommentMemNo()));
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		 
		 return result;

	 }
	 
	 /**
	  * 대댓글 조회
	  */
	 public AdminComment selectCommentList(Connection conn, int reserNo) {
		 
		 AdminComment adminComment = null;
		 PreparedStatement pstmt = null;
		 ResultSet rset = null;
		 String sql = prop.getProperty("selectCommentList");
		 
		 
		 return adminComment;
	 }
	 
	 
}
