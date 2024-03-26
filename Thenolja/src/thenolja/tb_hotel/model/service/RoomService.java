package thenolja.tb_hotel.model.service;

import static thenolja.common.JDBCTemplate.close;
import static thenolja.common.JDBCTemplate.commit;
import static thenolja.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import thenolja.tb_hotel.model.dao.RoomDao;
import thenolja.tb_hotel.model.vo.Room;
public class RoomService {
	
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
