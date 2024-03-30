package thenolja.tb_hotel.model.service;

import static thenolja.common.JDBCTemplate.close;
import static thenolja.common.JDBCTemplate.commit;
import static thenolja.common.JDBCTemplate.getConnection;
import static thenolja.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import thenolja.common.model.vo.PageInfo;
import thenolja.tb_hotel.model.dao.HotelDao;
import thenolja.tb_hotel.model.vo.DetailHotel;
import thenolja.tb_hotel.model.vo.Hotel;
import thenolja.tb_hotel.model.vo.HotelCard;

public class HotelService {

	
	public int insertHotel(Hotel h) {
		Connection conn = getConnection();
		
		int insertHotelResult = new HotelDao().insertHotel(conn, h);
		
		// 서비스목록 추가
		// h.getSerList() : String[]
		int insertSerList = new HotelDao().insertService(conn, h.getSerList());
		
		if((insertHotelResult * insertSerList)> 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
				
		return (insertHotelResult * insertSerList);
	}
	
	public int selectListCount() {
		Connection conn = getConnection();
		
		int result = new HotelDao().selectListCount(conn);
		
		close(conn);
		
		return result;
	}
	
	public int selectListCountRoomIn() {
		Connection conn = getConnection();
		
		int result = new HotelDao().selectListCountRoomIn(conn);
		
		close(conn);
		
		return result;
	}
	
	
	public ArrayList<HotelCard> selectAllList(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<HotelCard> list = new HotelDao().selectAllList(conn, pi); 
		
		close(conn);
		
		return list;
	}
	
	public ArrayList<HotelCard> selectList(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<HotelCard> list = new HotelDao().selectList(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	
	public DetailHotel selectHotel(int hotelNo) {
		Connection conn = getConnection();
		
		HotelDao selectHotelInfos = new HotelDao();
		
		DetailHotel dh = selectHotelInfos.selectHotel(conn, hotelNo);
						
		if(dh != null) {
			// 호텔정보를 정상적으로 가져왔다면
		    // 서비스 리스트, 선택한 호텔 리뷰 가져오기, 리뷰 갯수 가져오기
			dh.setSerList(selectHotelInfos.hotelServiceList(conn, hotelNo));
			dh.setRoomList(selectHotelInfos.hotelRoomList(conn, hotelNo));
			dh.setReviewList(selectHotelInfos.hotelReviews(conn, hotelNo));
			dh.setCountReviews(selectHotelInfos.countReviews(conn, hotelNo));
		}
		
		close(conn);
		
		return dh;
	}
	
	public Hotel updateForm(int hotelNo) {
		Hotel h = new Hotel();
		Connection conn = getConnection();
		
		h = new HotelDao().updateForm(conn, hotelNo);
		
		if(h != null) {
			h.setSerList(new HotelDao().updateFormSerList(conn, hotelNo));
		}
		
		close(conn);
		
		return h;
	}
	
	public int updateHotel(Hotel h) {
		Connection conn = getConnection();
		HotelDao hd = new HotelDao();
		
		int resultHotel = hd.updateHotel(conn, h);
		int resultSerListDel = hd.deleteAllServiceList(conn, h);
		int resultSerList = 0;
		
		if((resultHotel * resultSerListDel) > 0) {
			resultSerList = hd.updateService(conn, h);
		}
		
		if((resultHotel * resultSerListDel * resultSerList) > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return (resultHotel * resultSerListDel * resultSerList);
	}
	
	public int deleteHotel(int hotelNo) {
		Connection conn = getConnection();
		
		int result = new HotelDao().deleteHotel(conn, hotelNo);
		
		if(result > 0) {
			commit(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public ArrayList<String> selectLocation() {
		Connection conn = getConnection();
		
		ArrayList<String> result = new HotelDao().selectLocation(conn);
		
		close(conn);
		
		return result;
	}
	
	public ArrayList<HotelCard> selectPopular() {
		Connection conn = getConnection();
		
		ArrayList<HotelCard> plist = new HotelDao().selectPopular(conn);
		
		close(conn);
		
		return plist;
	}
	
	public ArrayList<HotelCard> selectRecomData() {
		Connection conn = getConnection();
		
		ArrayList<HotelCard> rList = new HotelDao().selectRecomData(conn);
		
		close(conn);
		
		return rList;
	}
	
	
	
	
	
	
	
	
	
	
}
