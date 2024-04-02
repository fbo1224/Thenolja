package thenolja.mypage.model.vo;

public class MyPageHeartList {
	
	private String hotelName;
	private String hotelLocation;
	private String hotelAddress;
	private String hotelPath;
	private String roomName;
	private int reviewScore;
	
	public MyPageHeartList() {
		super();
	}
	public MyPageHeartList(String hotelName, String hotelLocation, String hotelAddress, String hotelPath,
			String roomName, int reviewScore) {
		super();
		this.hotelName = hotelName;
		this.hotelLocation = hotelLocation;
		this.hotelAddress = hotelAddress;
		this.hotelPath = hotelPath;
		this.roomName = roomName;
		this.reviewScore = reviewScore;
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
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	@Override
	public String toString() {
		return "MyPageHeartList [hotelName=" + hotelName + ", hotelLocation=" + hotelLocation + ", hotelAddress="
				+ hotelAddress + ", hotelPath=" + hotelPath + ", roomName=" + roomName + ", reviewScore=" + reviewScore
				+ "]";
	}
	
	
}
