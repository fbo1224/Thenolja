package thenolja.tb_reservation.model.vo;

import java.sql.Date;

public class Reservation {

	private int reserNo;
	private Date reserDate;
	private String bicycle;
	private String cancelYN;
	private String checkIn;
	private String checkOut;
	private int people;
	private int roomNo;
	private int reMemNo;
	private String payment;
	private int paymentPrice;
	private String phone;
	private String name;
	private int memNo;
	
	public Reservation() {
		super();
	}
	

	public Reservation(int reserNo, Date reserDate, String bicycle, String cancelYN, String checkIn, String checkOut,
			int people, int roomNo, int reMemNo, String payment, int paymentPrice, String phone, String name) {
		super();
		this.reserNo = reserNo;
		this.reserDate = reserDate;
		this.bicycle = bicycle;
		this.cancelYN = cancelYN;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.people = people;
		this.roomNo = roomNo;
		this.reMemNo = reMemNo;
		this.payment = payment;
		this.paymentPrice = paymentPrice;
		this.phone = phone;
		this.name = name;
	}
	public int getReserNo() {
		return reserNo;
	}
	public void setReserNo(int reserNo) {
		this.reserNo = reserNo;
	}
	public Date getReserDate() {
		return reserDate;
	}
	public void setReserDate(Date reserDate) {
		this.reserDate = reserDate;
	}
	public String getBicycle() {
		return bicycle;
	}
	public void setBicycle(String bicycle) {
		this.bicycle = bicycle;
	}
	public String getCancelYN() {
		return cancelYN;
	}
	public void setCancelYN(String cancelYN) {
		this.cancelYN = cancelYN;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMemNo() {
		return memNo;
	}
	
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bicycle == null) ? 0 : bicycle.hashCode());
		result = prime * result + ((cancelYN == null) ? 0 : cancelYN.hashCode());
		result = prime * result + ((checkIn == null) ? 0 : checkIn.hashCode());
		result = prime * result + ((checkOut == null) ? 0 : checkOut.hashCode());
		result = prime * result + ((payment == null) ? 0 : payment.hashCode());
		result = prime * result + paymentPrice;
		result = prime * result + people;
		result = prime * result + reMemNo;
		result = prime * result + ((reserDate == null) ? 0 : reserDate.hashCode());
		result = prime * result + reserNo;
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
		Reservation other = (Reservation) obj;
		if (bicycle == null) {
			if (other.bicycle != null)
				return false;
		} else if (!bicycle.equals(other.bicycle))
			return false;
		if (cancelYN == null) {
			if (other.cancelYN != null)
				return false;
		} else if (!cancelYN.equals(other.cancelYN))
			return false;
		if (checkIn == null) {
			if (other.checkIn != null)
				return false;
		} else if (!checkIn.equals(other.checkIn))
			return false;
		if (checkOut == null) {
			if (other.checkOut != null)
				return false;
		} else if (!checkOut.equals(other.checkOut))
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
		if (reserNo != other.reserNo)
			return false;
		if (roomNo != other.roomNo)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reservation [reserNo=" + reserNo + ", reserDate=" + reserDate + ", bicycle=" + bicycle + ", cancelYN="
				+ cancelYN + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", people=" + people + ", roomNo="
				+ roomNo + ", reMemNo=" + reMemNo + ", payment=" + payment + ", paymentPrice=" + paymentPrice + "]";
	}
	
	
	
	
}
