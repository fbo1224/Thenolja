package thenolja.nonmem.model.vo;

public class SelectNonmemReser {
	// nonmem
	private int memNo;
	private String memName;
	private String memPhone;
	private String memStatus;
	
	// reservation
	private int reserNo;
	private String reserName;
	private String reserPhone;
	private String checkInDate;
	private String checkOutDate;
	private String bicycle;
	private int people;
	private String paymentPrice;
	
	// room
	private int roomNo;
	private String roomName;
	private int roomNum;
	private int maxPeople;
	private String checkInTime;
	private String checkOutTime;
	
	// hotel
	private int hotelNo;
	private String hotelName;
	private String hotelLocation;
	private String hotelAddress;
	private String hotelPath;
	
	// roomimg
	private String roomImg;

	public SelectNonmemReser() {
		super();
	}

	public SelectNonmemReser(int memNo, String memName, String memPhone, String memStatus, int reserNo,
			String reserName, String reserPhone, String checkInDate, String checkOutDate, String bicycle, int people,
			String paymentPrice, int roomNo, String roomName, int roomNum, int maxPeople, String checkInTime,
			String checkOutTime, int hotelNo, String hotelName, String hotelLocation, String hotelAddress,
			String hotelPath, String roomImg) {
		super();
		this.memNo = memNo;
		this.memName = memName;
		this.memPhone = memPhone;
		this.memStatus = memStatus;
		this.reserNo = reserNo;
		this.reserName = reserName;
		this.reserPhone = reserPhone;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.bicycle = bicycle;
		this.people = people;
		this.paymentPrice = paymentPrice;
		this.roomNo = roomNo;
		this.roomName = roomName;
		this.roomNum = roomNum;
		this.maxPeople = maxPeople;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.hotelNo = hotelNo;
		this.hotelName = hotelName;
		this.hotelLocation = hotelLocation;
		this.hotelAddress = hotelAddress;
		this.hotelPath = hotelPath;
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

	public String getReserPhone() {
		return reserPhone;
	}

	public void setReserPhone(String reserPhone) {
		this.reserPhone = reserPhone;
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

	public String getPaymentPrice() {
		return paymentPrice;
	}

	public void setPaymentPrice(String paymentPrice) {
		this.paymentPrice = paymentPrice;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
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

	public int getHotelNo() {
		return hotelNo;
	}

	public void setHotelNo(int hotelNo) {
		this.hotelNo = hotelNo;
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

	public String getRoomImg() {
		return roomImg;
	}

	public void setRoomImg(String roomImg) {
		this.roomImg = roomImg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bicycle == null) ? 0 : bicycle.hashCode());
		result = prime * result + ((checkInDate == null) ? 0 : checkInDate.hashCode());
		result = prime * result + ((checkInTime == null) ? 0 : checkInTime.hashCode());
		result = prime * result + ((checkOutDate == null) ? 0 : checkOutDate.hashCode());
		result = prime * result + ((checkOutTime == null) ? 0 : checkOutTime.hashCode());
		result = prime * result + ((hotelAddress == null) ? 0 : hotelAddress.hashCode());
		result = prime * result + ((hotelLocation == null) ? 0 : hotelLocation.hashCode());
		result = prime * result + ((hotelName == null) ? 0 : hotelName.hashCode());
		result = prime * result + hotelNo;
		result = prime * result + ((hotelPath == null) ? 0 : hotelPath.hashCode());
		result = prime * result + maxPeople;
		result = prime * result + ((memName == null) ? 0 : memName.hashCode());
		result = prime * result + memNo;
		result = prime * result + ((memPhone == null) ? 0 : memPhone.hashCode());
		result = prime * result + ((memStatus == null) ? 0 : memStatus.hashCode());
		result = prime * result + ((paymentPrice == null) ? 0 : paymentPrice.hashCode());
		result = prime * result + people;
		result = prime * result + ((reserName == null) ? 0 : reserName.hashCode());
		result = prime * result + reserNo;
		result = prime * result + ((reserPhone == null) ? 0 : reserPhone.hashCode());
		result = prime * result + ((roomImg == null) ? 0 : roomImg.hashCode());
		result = prime * result + ((roomName == null) ? 0 : roomName.hashCode());
		result = prime * result + roomNo;
		result = prime * result + roomNum;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SelectNonmemReser other = (SelectNonmemReser) obj;
		if (bicycle == null) {
			if (other.bicycle != null)
				return false;
		} else if (!bicycle.equals(other.bicycle))
			return false;
		if (checkInDate == null) {
			if (other.checkInDate != null)
				return false;
		} else if (!checkInDate.equals(other.checkInDate))
			return false;
		if (checkInTime == null) {
			if (other.checkInTime != null)
				return false;
		} else if (!checkInTime.equals(other.checkInTime))
			return false;
		if (checkOutDate == null) {
			if (other.checkOutDate != null)
				return false;
		} else if (!checkOutDate.equals(other.checkOutDate))
			return false;
		if (checkOutTime == null) {
			if (other.checkOutTime != null)
				return false;
		} else if (!checkOutTime.equals(other.checkOutTime))
			return false;
		if (hotelAddress == null) {
			if (other.hotelAddress != null)
				return false;
		} else if (!hotelAddress.equals(other.hotelAddress))
			return false;
		if (hotelLocation == null) {
			if (other.hotelLocation != null)
				return false;
		} else if (!hotelLocation.equals(other.hotelLocation))
			return false;
		if (hotelName == null) {
			if (other.hotelName != null)
				return false;
		} else if (!hotelName.equals(other.hotelName))
			return false;
		if (hotelNo != other.hotelNo)
			return false;
		if (hotelPath == null) {
			if (other.hotelPath != null)
				return false;
		} else if (!hotelPath.equals(other.hotelPath))
			return false;
		if (maxPeople != other.maxPeople)
			return false;
		if (memName == null) {
			if (other.memName != null)
				return false;
		} else if (!memName.equals(other.memName))
			return false;
		if (memNo != other.memNo)
			return false;
		if (memPhone == null) {
			if (other.memPhone != null)
				return false;
		} else if (!memPhone.equals(other.memPhone))
			return false;
		if (memStatus == null) {
			if (other.memStatus != null)
				return false;
		} else if (!memStatus.equals(other.memStatus))
			return false;
		if (paymentPrice == null) {
			if (other.paymentPrice != null)
				return false;
		} else if (!paymentPrice.equals(other.paymentPrice))
			return false;
		if (people != other.people)
			return false;
		if (reserName == null) {
			if (other.reserName != null)
				return false;
		} else if (!reserName.equals(other.reserName))
			return false;
		if (reserNo != other.reserNo)
			return false;
		if (reserPhone == null) {
			if (other.reserPhone != null)
				return false;
		} else if (!reserPhone.equals(other.reserPhone))
			return false;
		if (roomImg == null) {
			if (other.roomImg != null)
				return false;
		} else if (!roomImg.equals(other.roomImg))
			return false;
		if (roomName == null) {
			if (other.roomName != null)
				return false;
		} else if (!roomName.equals(other.roomName))
			return false;
		if (roomNo != other.roomNo)
			return false;
		if (roomNum != other.roomNum)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SelectNonmemReser [memNo=" + memNo + ", memName=" + memName + ", memPhone=" + memPhone + ", memStatus="
				+ memStatus + ", reserNo=" + reserNo + ", reserName=" + reserName + ", reserPhone=" + reserPhone
				+ ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", bicycle=" + bicycle
				+ ", people=" + people + ", paymentPrice=" + paymentPrice + ", roomNo=" + roomNo + ", roomName="
				+ roomName + ", roomNum=" + roomNum + ", maxPeople=" + maxPeople + ", checkInTime=" + checkInTime
				+ ", checkOutTime=" + checkOutTime + ", hotelNo=" + hotelNo + ", hotelName=" + hotelName
				+ ", hotelLocation=" + hotelLocation + ", hotelAddress=" + hotelAddress + ", hotelPath=" + hotelPath
				+ ", roomImg=" + roomImg + "]";
	}

	
	
	
}
