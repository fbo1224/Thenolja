package thenolja.nonmem.model.vo;

public class SelectNonmemReser {

	private int memNo;
	private String memName;
	private String memPhone;
	private String memStatus;
	private int reserNo;
	private String reserName;
	private String checkInDate;
	private String checkOutDate;
	private String bicycle;
	private int people;
	private String roomName;
	private int roomNum;
	private int maxPeople;
	private String checkInTime;
	private String checkOutTime;
	private String roomImg;
	
	public SelectNonmemReser() {
		super();
	}
	
	public SelectNonmemReser(int memNo, String memName, String memPhone, String memStatus, int reserNo,
			String reserName, String checkInDate, String checkOutDate, String bicycle, int people, String roomName,
			int roomNum, int maxPeople, String checkInTime, String checkOutTime, String roomImg) {
		super();
		this.memNo = memNo;
		this.memName = memName;
		this.memPhone = memPhone;
		this.memStatus = memStatus;
		this.reserNo = reserNo;
		this.reserName = reserName;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.bicycle = bicycle;
		this.people = people;
		this.roomName = roomName;
		this.roomNum = roomNum;
		this.maxPeople = maxPeople;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.roomImg = roomImg;
	}
	public int getMemNo() {
		return memNo;
	}
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public String getMemStatus() {
		return memStatus;
	}
	public void setMemStatus(String memStatus) {
		this.memStatus = memStatus;
	}
	public int getReserNo() {
		return reserNo;
	}
	public void setReserNo(int reserNo) {
		this.reserNo = reserNo;
	}
	public String getReserName() {
		return reserName;
	}
	public void setReserName(String reserName) {
		this.reserName = reserName;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public String getBicycle() {
		return bicycle;
	}
	public void setBicycle(String bicycle) {
		this.bicycle = bicycle;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public int getMaxPeople() {
		return maxPeople;
	}
	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
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
	public String getRoomImg() {
		return roomImg;
	}
	public void setRoomImg(String roomImg) {
		this.roomImg = roomImg;
	}
	@Override
	public String toString() {
		return "SelectNonmemReser [memNo=" + memNo + ", memName=" + memName + ", memPhone=" + memPhone + ", memStatus="
				+ memStatus + ", reserNo=" + reserNo + ", reserName=" + reserName + ", checkInDate=" + checkInDate
				+ ", checkOutDate=" + checkOutDate + ", bicycle=" + bicycle + ", people=" + people + ", roomName="
				+ roomName + ", roomNum=" + roomNum + ", maxPeople=" + maxPeople + ", checkInTime=" + checkInTime
				+ ", checkOutTime=" + checkOutTime + ", roomImg=" + roomImg + "]";
	}
	
	
	
}
