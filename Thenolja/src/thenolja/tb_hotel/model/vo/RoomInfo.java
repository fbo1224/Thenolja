package thenolja.tb_hotel.model.vo;

// hotel detail page 안의 객실 정보
public class RoomInfo {
	private String checkInTime;
	private String checkOutTime;
	private String roomName;
	private String roomImg;
	private int roomNo;
	private int roomNum;
	private int roomPrice;
	 
	
	public RoomInfo() {
		super();
	}

	public RoomInfo(String checkInTime, String checkOutTime, String roomName, String roomImg, int roomNum,
			int roomPrice) {
		super();
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.roomName = roomName;
		this.roomImg = roomImg;
		this.roomNum = roomNum;
		this.roomPrice = roomPrice;
	}
	
	
	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
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

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomImg() {
		return roomImg;
	}

	public void setRoomImg(String roomImg) {
		this.roomImg = roomImg;
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

	@Override
	public String toString() {
		return "RoomInfo [checkInTime=" + checkInTime + ", checkOutTime=" + checkOutTime + ", roomName=" + roomName
				+ ", roomImg=" + roomImg + ", roomNum=" + roomNum + ", roomPrice=" + roomPrice + "]";
	}
	
	
}
