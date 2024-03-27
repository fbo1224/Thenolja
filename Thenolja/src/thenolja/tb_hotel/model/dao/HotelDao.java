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
import thenolja.tb_hotel.model.vo.RoomInfo;
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
			pstmt.setString(9, h.getHotelDetail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	// 추가한 호텔의 서비스 목록 추가
	public int insertService(Connection conn, String[] serList) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertService");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			for(int i = 0; i < serList.length; i++) {
				pstmt.setInt(1, Integer.parseInt(serList[i]));
				result += pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result == serList.length ? 1 : 0;
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
			
			listCnt = rset.getInt("COUNT(*)");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCnt;
	}
	
	public int selectListCountRoomIn(Connection conn) {
		int listCnt = 0;
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCountRoomIn");
		
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
	
	
	public ArrayList<HotelCard> selectAllList(Connection conn, PageInfo pi){
		ArrayList<HotelCard> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllList");
		
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
	
	// 객실이 등록된 호텔 가져오기
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
	
	// 객실리스트 가져오기
	public ArrayList<RoomInfo> hotelRoomList(Connection conn, int hotelNo){
		ArrayList<RoomInfo> riList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("hotelRoomList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hotelNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				RoomInfo ri = new RoomInfo();
				
				ri.setCheckInTime(rset.getString("CHECKIN_TIME"));
				ri.setCheckOutTime(rset.getString("CHECKOUT_TIME"));
				ri.setRoomNum(rset.getInt("ROOM_NUM"));
				ri.setRoomPrice(rset.getInt("ROOM_PRICE"));
				ri.setRoomImg(rset.getString("ROOM_IMG"));
				ri.setRoomName(rset.getString("ROOM_NAME"));
				
				riList.add(ri);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return riList;
		
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
	
	// 호텔 리뷰갯수 가져옴
	public int countReviews(Connection conn, int hotelNo){
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("countReviews");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hotelNo);
			rset = pstmt.executeQuery();
			
			rset.next();
			result = rset.getInt("COUNT(*)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
	
	public Hotel updateForm(Connection conn , int hotelNo) {
		Hotel h = new Hotel();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("updateForm");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hotelNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				h.setHotelNo(Integer.parseInt(rset.getString("HOTEL_NO")));
				h.setHotelName(rset.getString("HOTEL_NAME"));
				h.setHotelPhone(rset.getString("HOTEL_PHONE"));
				h.setHotelLocation(rset.getString("HOTEL_LOCATION"));
				h.setHotelAddress(rset.getString("HOTEL_ADDRESS"));
				h.setHotelCategory(rset.getString("HOTEL_CATEGORY"));
				h.setHotelPath(rset.getString("HOTEL_PATH"));
				h.setHotelIntro(rset.getString("HOTEL_INTRO"));
				h.setHostName(rset.getString("HOST_NAME"));
				h.setHotelDetail(rset.getString("DETAILLOCATION"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return h;
	}
	
	public String[] updateFormSerList(Connection conn, int hotelNo) {
		String[] serList = new String[8];
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("updateFormSerList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hotelNo);
			
			rset = pstmt.executeQuery();
			int cnt = 0;
			while(rset.next()) {
				serList[cnt] = rset.getString("SERVICE_NAME");
				cnt++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return serList;
	}
	
	public int updateHotel(Connection conn, Hotel h) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateHotel");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, h.getHotelName());
			pstmt.setString(2, h.getHotelLocation());
			pstmt.setString(3, h.getHotelAddress());
			pstmt.setString(4, h.getHotelCategory());
			pstmt.setString(5, h.getHotelIntro());
			pstmt.setString(6, h.getHostName());
			pstmt.setString(7, h.getHotelPath());
			pstmt.setString(8, h.getHotelDetail());
			pstmt.setInt(9, h.getHotelNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteAllServiceList(Connection conn, Hotel h) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteAllServiceList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, h.getHotelNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateService(Connection conn, Hotel h) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateService");
		try {
			pstmt = conn.prepareStatement(sql);
			if(h.getSerList() != null) {
				for(int i = 0; i < h.getSerList().length; i++) {
					pstmt.setInt(1, h.getHotelNo());
					pstmt.setInt(2, Integer.parseInt(h.getSerList()[i]));
					result += pstmt.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
