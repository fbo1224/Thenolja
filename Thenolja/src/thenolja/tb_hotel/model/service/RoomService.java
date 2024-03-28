package thenolja.tb_hotel.model.service;

import static thenolja.common.JDBCTemplate.*;


import java.sql.Connection;
import java.util.ArrayList;

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
	
	// 수정할 room 목록 가져오기 
	public ArrayList<Room> updateRoomList(int hotelNo) {
		Connection conn = getConnection();
		
		ArrayList<Room> result = new RoomDao().updateRoomList(conn, hotelNo);
		
		close(conn);
		
		return result;
	}
	
	// 수정할 room 하나 가져오기
	public Room updateRoomForm(int roomNo) {
		Connection conn = getConnection();
		
		Room r = new RoomDao().updateRoomForm(conn, roomNo);
		
		close(conn);
		
		return r;
	}
	
	public int updateRoom(int roomNo) {
		Connection conn = getConnection();
		
		int result = new RoomDao().updateRoom(conn, roomNo);
		
		if(result > 0) {
			commit(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
