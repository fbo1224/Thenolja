package thenolja.tb_hotel.model.service;

import static thenolja.common.JDBCTemplate.close;
import static thenolja.common.JDBCTemplate.commit;
import static thenolja.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import thenolja.common.model.vo.PageInfo;
import thenolja.tb_hotel.model.dao.HotelDao;
import thenolja.tb_hotel.model.vo.Hotel;
import thenolja.tb_hotel.model.vo.HotelCard;

public class HotelService {

	
	public int insertHotel(Hotel h) {
		Connection conn = getConnection();
		
		int result = new HotelDao().insertHotel(conn, h);
		
		if(result > 0) {
			commit(conn);
		}
		
		close(conn);
				
		return result;
	}
	
	public int selectListCount() {
		Connection conn = getConnection();
		
		int result = new HotelDao().selectListCount(conn);
		
		close(conn);
		
		return result;
	}
	
	public ArrayList<HotelCard> selectList(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<HotelCard> list = new HotelDao().selectList(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	// VO 타입.
	// public selectHotel() {}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
