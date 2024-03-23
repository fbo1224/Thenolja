package thenolja.tb_hotel.model.service;

import static thenolja.common.JDBCTemplate.*;

import java.sql.Connection;

import thenolja.tb_hotel.model.dao.HotelDao;
import thenolja.tb_hotel.model.vo.Hotel;

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
}
