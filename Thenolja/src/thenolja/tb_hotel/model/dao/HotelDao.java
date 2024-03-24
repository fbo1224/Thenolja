package thenolja.tb_hotel.model.dao;

import static thenolja.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import thenolja.common.model.vo.PageInfo;
import thenolja.tb_hotel.model.vo.DetailHotel;
import thenolja.tb_hotel.model.vo.Hotel;
import thenolja.tb_hotel.model.vo.HotelCard;
import thenolja.tb_hotel.model.vo.HotelReview;
import thenolja.tb_hotel.model.vo.ServiceList;

public class HotelDao {
	private Properties prop = new Properties();
	
	public HotelDao() {
		String filePath = HotelDao.class.getResource("/sql/tb_hotel/tb_hotel-mapper.xml")
			    						.getPath();

		// System.out.println(filePath);

		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 호텔추가
	public int insertHotel(Connection conn, Hotel h) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertHotel");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, h.getHotelName());
			pstmt.setString(2, h.getHotelPhone());
			pstmt.setString(3, h.getHotelLocation());
			pstmt.setString(4, h.getHotelAddress());
			pstmt.setString(5, h.getHotelCategory());
			pstmt.setString(6, h.getHotelPath());
			pstmt.setString(7, h.getHotelIntro());
			pstmt.setString(8, h.getHostName());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	// 현재등록된 호텔의 총 수 가져오기
	
	public int selectListCount(Connection conn) {
		int listCnt = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			rset.next();
			
			listCnt = rset.getInt("CNTS");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCnt;
	}
	
	// 모든 호텔정보 가져오기
	public ArrayList<HotelCard> selectList(Connection conn, PageInfo pi){
		ArrayList<HotelCard> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1 ) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			// 리뷰관련 컬럼 추가 해야함.
			while(rset.next()) {
				HotelCard hc = new HotelCard();
				hc.setHotelNo(rset.getInt("HOTEL_NO"));
				hc.setHotelName(rset.getString("HOTEL_NAME"));
				hc.setHotelLocation(rset.getString("HOTEL_LOCATION"));
				hc.setHotelCategory(rset.getString("HOTEL_CATEGORY"));
				hc.setHotelPath(rset.getString("HOTEL_PATH"));
				hc.setRoomPrice(rset.getInt("ROOM_PRICE"));
				list.add(hc);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	// 하나의 호텔정보 가져오기
	public DetailHotel selectHotel(Connection conn, int hotelNo) {
		DetailHotel dh = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectHotel");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hotelNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				dh = new DetailHotel();
				dh.setHotelName(rset.getString("HOTEL_NAME"));
				dh.setHotelPath(rset.getString("HOTEL_PATH"));
				dh.setHotelCate(rset.getString("HOTEL_CATEGORY"));
				dh.setHotelIntro(rset.getString("HOTEL_INTRO"));
				dh.setCheckInTime(rset.getString("CHECKIN_TIME"));
				dh.setCheckOutTime(rset.getString("CHECKOUT_TIME"));
				dh.setRoomNum(rset.getInt("ROOM_NUM"));
				dh.setRoomPrice(rset.getInt("ROOM_PRICE"));
				dh.setRoomImg(rset.getString("ROOM_IMG"));
				dh.setRoomName(rset.getString("ROOM_NAME"));	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return dh;
	}
	
	// 서비스리스트 가져오기
	public ArrayList<ServiceList> hotelServiceList(Connection conn, int hotelNo) {
		ArrayList<ServiceList> serList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("hotelServiceList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hotelNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ServiceList sl= new ServiceList();
				sl.setServiceNo(rset.getInt("SERVICE_NO"));
				sl.setServiceName(rset.getString("SERVICE_NAME"));
				serList.add(sl);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return serList;
	}
	
	// 해당 호텔의 리뷰 가져오기
	public ArrayList<HotelReview> hotelReviews(Connection conn, int hotelNo){
		ArrayList<HotelReview> hrList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("hotelReviews");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hotelNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				HotelReview hr = new HotelReview();
				
				hr.setHotelNo(rset.getInt("HOTEL_NO"));
				hr.setRoomNo(rset.getInt("ROOM_NO"));
				hr.setReserName(rset.getString("RESER_NAME"));
				hr.setCreateDate(rset.getDate("CREATE_DATE"));
				hr.setReviewScore(rset.getInt("REVIEW_SCORE"));
				hr.setReviewContent(rset.getString("REVIEW_CONTENT"));
				
				hrList.add(hr);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return hrList;
	}
	
	
	
	
	
	
	
	
	
}
