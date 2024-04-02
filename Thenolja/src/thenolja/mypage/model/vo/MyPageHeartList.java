package thenolja.mypage.model.vo;

public class MyPageHeartList {
	private int memNo;
	private String roomName;
	private String hotelName;
	private String hotelLocation;
	private String hotelAddress;
	private String hotelPath;
	public MyPageHeartList() {
		super();
	}
	public MyPageHeartList(int memNo, String roomName, String hotelName, String hotelLocation, String hotelAddress,
			String hotelPath) {
		super();
		this.memNo = memNo;
		this.roomName = roomName;
		this.hotelName = hotelName;
		this.hotelLocation = hotelLocation;
		this.hotelAddress = hotelAddress;
		this.hotelPath = hotelPath;
	}
	public int getMemNo() {
		return memNo;
	}
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelLocation() {
		return hotelLocation;
	}
	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}
	public String getHotelAddress() {
		return hotelAddress;
	}
	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
	public String getHotelPath() {
		return hotelPath;
	}
	public void setHotelPath(String hotelPath) {
		this.hotelPath = hotelPath;
	}
	@Override
	public String toString() {
		return "MyPageHeartList [memNo=" + memNo + ", roomName=" + roomName + ", hotelName=" + hotelName
				+ ", hotelLocation=" + hotelLocation + ", hotelAddress=" + hotelAddress + ", hotelPath=" + hotelPath
				+ "]";
	}
	
	
	
}
