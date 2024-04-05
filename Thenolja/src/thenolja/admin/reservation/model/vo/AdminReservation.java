package thenolja.admin.reservation.model.vo;

public class AdminReservation {
	
	private int reserNo;
	private String reserDate;
	private String reserName;
	private String reserPhone;
	private String bicycle;
	private String cancleYn;
	private String checkInTime;
	private String checkOutTime;
	private int people;
	private int roomNo;
	private int reMemNo;
	private String payment;
	private int paymentPrice;
	private String memId;
	private String memPhone;
	private String hotelName;
	private String hotelPath;
	
	
	


	public AdminReservation() {
		super();
	}

	public AdminReservation(int reserNo, String reserDate, String reserName, String reserPhone, String bicycle,
			String cancleYn, String checkInTime, String checkOutTime, int people, String payment, int paymentPrice) {
		super();
		this.reserNo = reserNo;
		this.reserDate = reserDate;
		this.reserName = reserName;
		this.reserPhone = reserPhone;
		this.bicycle = bicycle;
		this.cancleYn = cancleYn;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.people = people;
		this.payment = payment;
		this.paymentPrice = paymentPrice;
	}

	public int getReserNo() {
		return reserNo;
	}

	public void setReserNo(int reserNo) {
		this.reserNo = reserNo;
	}

	public String getReserDate() {
		return reserDate;
	}

	public void setReserDate(String reserDate) {
		this.reserDate = reserDate;
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

	public String getBicycle() {
		return bicycle;
	}

	public void setBicycle(String bicycle) {
		this.bicycle = bicycle;
	}

	public String getCancleYn() {
		return cancleYn;
	}

	public void setCancleYn(String cancleYn) {
		this.cancleYn = cancleYn;
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

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public int getReMemNo() {
		return reMemNo;
	}

	public void setReMemNo(int reMemNo) {
		this.reMemNo = reMemNo;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getPaymentPrice() {
		return paymentPrice;
	}

	public void setPaymentPrice(int paymentPrice) {
		this.paymentPrice = paymentPrice;
	}
	
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelPath() {
		return hotelPath;
	}

	public void setHotelPath(String hotelPath) {
		this.hotelPath = hotelPath;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bicycle == null) ? 0 : bicycle.hashCode());
		result = prime * result + ((cancleYn == null) ? 0 : cancleYn.hashCode());
		result = prime * result + ((checkInTime == null) ? 0 : checkInTime.hashCode());
		result = prime * result + ((checkOutTime == null) ? 0 : checkOutTime.hashCode());
		result = prime * result + ((payment == null) ? 0 : payment.hashCode());
		result = prime * result + paymentPrice;
		result = prime * result + people;
		result = prime * result + reMemNo;
		result = prime * result + ((reserDate == null) ? 0 : reserDate.hashCode());
		result = prime * result + ((reserName == null) ? 0 : reserName.hashCode());
		result = prime * result + reserNo;
		result = prime * result + ((reserPhone == null) ? 0 : reserPhone.hashCode());
		result = prime * result + roomNo;
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
		AdminReservation other = (AdminReservation) obj;
		if (bicycle == null) {
			if (other.bicycle != null)
				return false;
		} else if (!bicycle.equals(other.bicycle))
			return false;
		if (cancleYn == null) {
			if (other.cancleYn != null)
				return false;
		} else if (!cancleYn.equals(other.cancleYn))
			return false;
		if (checkInTime == null) {
			if (other.checkInTime != null)
				return false;
		} else if (!checkInTime.equals(other.checkInTime))
			return false;
		if (checkOutTime == null) {
			if (other.checkOutTime != null)
				return false;
		} else if (!checkOutTime.equals(other.checkOutTime))
			return false;
		if (payment == null) {
			if (other.payment != null)
				return false;
		} else if (!payment.equals(other.payment))
			return false;
		if (paymentPrice != other.paymentPrice)
			return false;
		if (people != other.people)
			return false;
		if (reMemNo != other.reMemNo)
			return false;
		if (reserDate == null) {
			if (other.reserDate != null)
				return false;
		} else if (!reserDate.equals(other.reserDate))
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
		if (roomNo != other.roomNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AdminReservation [reserNo=" + reserNo + ", reserDate=" + reserDate + ", reserName=" + reserName
				+ ", reserPhone=" + reserPhone + ", bicycle=" + bicycle + ", cancleYn=" + cancleYn + ", checkInTime="
				+ checkInTime + ", checkOutTime=" + checkOutTime + ", people=" + people + ", roomNo=" + roomNo
				+ ", reMemNo=" + reMemNo + ", payment=" + payment + ", paymentPrice=" + paymentPrice + "]";
	}
	
	
	
	

}
