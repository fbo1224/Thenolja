package thenolja.tb_hotel.model.vo;

import java.util.ArrayList;
// 하나의 객실 정보 담을 VO
public class Room {
	private int roomNo;
	private int hotelNo;
	private int roomNum;
	private int roomPrice;
	private int maxPeople;
	private String roomName;
	private String checkInTime;
	private String checkOutTime;
	
	private int roomImgNo;
	private String roomImgPath;
	
	public Room() {
		super();
	}

	public Room(int roomNo, int hotelNo, String roomName, String checkInTime, String checkOutTime, int roomNum,
			int roomPrice, int maxPeople) {
		super();
		this.roomNo = roomNo;
		this.hotelNo = hotelNo;
		this.roomName = roomName;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.roomNum = roomNum;
		this.roomPrice = roomPrice;
		this.maxPeople = maxPeople;
	}
	
	
	public int getRoomImgNo() {
		return roomImgNo;
	}

	public void setRoomImgNo(int roomImgNo) {
		this.roomImgNo = roomImgNo;
	}

	public String getRoomImgPath() {
		return roomImgPath;
	}

	public void setRoomImgPath(String roomImgPath) {
		this.roomImgPath = roomImgPath;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public int getHotelNo() {
		return hotelNo;
	}

	public void setHotelNo(int hotelNo) {
		this.hotelNo = hotelNo;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	public int getMaxPeople() {
		return maxPeople;
	}

	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}

	@Override
	public String toString() {
		return "Room [roomNo=" + roomNo + ", hotelNo=" + hotelNo + ", roomNum=" + roomNum + ", roomPrice=" + roomPrice
				+ ", maxPeople=" + maxPeople + ", roomImgNo=" + roomImgNo + ", roomName=" + roomName + ", checkInTime="
				+ checkInTime + ", checkOutTime=" + checkOutTime + ", roomImgPath=" + roomImgPath + "]";
	}
	
}
