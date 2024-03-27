package thenolja.tb_hotel.model.service;

import static thenolja.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import thenolja.common.model.vo.PageInfo;
import thenolja.tb_hotel.model.dao.HotelDao;
import thenolja.tb_hotel.model.vo.DetailHotel;
import thenolja.tb_hotel.model.vo.Hotel;
import thenolja.tb_hotel.model.vo.HotelCard;
import thenolja.tb_hotel.model.vo.ServiceList;

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
