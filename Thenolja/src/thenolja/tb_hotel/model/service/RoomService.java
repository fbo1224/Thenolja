package thenolja.tb_hotel.model.service;

import static thenolja.common.JDBCTemplate.*;


import java.sql.Connection;

import thenolja.tb_hotel.model.dao.RoomDao;
import thenolja.tb_hotel.model.vo.Room;
public class RoomService {
	
	public int countRoom(int hotelNo) {
		int result = 0;
		
		Connection conn = getConnection();
		
		result = new RoomDao().countRoom(conn, hotelNo); 
		
		close(conn);
		
		return result;
	}
	
	public int insertRoom(Room r) {
		int roomResult = 0;
		int imgResult = 0;
		Connection conn = getConnection();
		
		roomResult = new RoomDao().insertRoom(conn, r);
		
		// 사진경로를 추가해야함.
		imgResult = new RoomDao().insertRoomImg(conn, r);
		
		if((roomResult * imgResult) > 0) {
			commit(conn);
		}
		
		close(conn);
		
		return (roomResult * imgResult);
	}
}
