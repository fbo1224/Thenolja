package thenolja.tb_review.model.vo;

import java.sql.Date;

public class Review {

	private int reserNo;
	private String imgPath;
	private String content;
	private String score;
	private Date createDate;
	private String reviewYN;
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
	private String hotelName;
	private String roomName;
	private int roomPrice;
	private String checkInTime;
	private String checkOutTime;
	private int hotelNo;
	private int roomNum;
	private String hotelPath;
	private String nickName;
    private int fileNo;
    private int refBno;
    private String originName;
    private String changeName;
    private String filePath;
	
	public Review() {
		super();
	}
	public Review(int reserNo, String imgPath, String content, String score, Date createDate, String reviewYN) {
		super();
		this.reserNo = reserNo;
		this.imgPath = imgPath;
		this.content = content;
		this.score = score;
		this.createDate = createDate;
		this.reviewYN = reviewYN;
	}
	
	
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public int getRefBno() {
		return refBno;
	}
	public void setRefBno(int refBno) {
		this.refBno = refBno;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public String getChangeName() {
		return changeName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
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
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getHotelPath() {
		return hotelPath;
	}
	public void setHotelPath(String hotelPath) {
		this.hotelPath = hotelPath;
	}
	public int getReserNo() {
		return reserNo;
	}
	public void setReserNo(int reserNo) {
		this.reserNo = reserNo;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getReviewYN() {
		return reviewYN;
	}
	public void setReviewYN(String reviewYN) {
		this.reviewYN = reviewYN;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bicycle == null) ? 0 : bicycle.hashCode());
		result = prime * result + ((cancelYN == null) ? 0 : cancelYN.hashCode());
		result = prime * result + ((checkIn == null) ? 0 : checkIn.hashCode());
		result = prime * result + ((checkInTime == null) ? 0 : checkInTime.hashCode());
		result = prime * result + ((checkOut == null) ? 0 : checkOut.hashCode());
		result = prime * result + ((checkOutTime == null) ? 0 : checkOutTime.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((hotelName == null) ? 0 : hotelName.hashCode());
		result = prime * result + hotelNo;
		result = prime * result + ((hotelPath == null) ? 0 : hotelPath.hashCode());
		result = prime * result + ((imgPath == null) ? 0 : imgPath.hashCode());
		result = prime * result + memNo;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + ((payment == null) ? 0 : payment.hashCode());
		result = prime * result + paymentPrice;
		result = prime * result + people;
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + reMemNo;
		result = prime * result + ((reserDate == null) ? 0 : reserDate.hashCode());
		result = prime * result + reserNo;
		result = prime * result + ((reviewYN == null) ? 0 : reviewYN.hashCode());
		result = prime * result + ((roomName == null) ? 0 : roomName.hashCode());
		result = prime * result + roomNo;
		result = prime * result + roomNum;
		result = prime * result + roomPrice;
		result = prime * result + ((score == null) ? 0 : score.hashCode());
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
		Review other = (Review) obj;
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
		if (checkInTime == null) {
			if (other.checkInTime != null)
				return false;
		} else if (!checkInTime.equals(other.checkInTime))
			return false;
		if (checkOut == null) {
			if (other.checkOut != null)
				return false;
		} else if (!checkOut.equals(other.checkOut))
			return false;
		if (checkOutTime == null) {
			if (other.checkOutTime != null)
				return false;
		} else if (!checkOutTime.equals(other.checkOutTime))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
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
		if (imgPath == null) {
			if (other.imgPath != null)
				return false;
		} else if (!imgPath.equals(other.imgPath))
			return false;
		if (memNo != other.memNo)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
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
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
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
		if (reviewYN == null) {
			if (other.reviewYN != null)
				return false;
		} else if (!reviewYN.equals(other.reviewYN))
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
		if (roomPrice != other.roomPrice)
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Review [reserNo=" + reserNo + ", imgPath=" + imgPath + ", content=" + content + ", score=" + score
				+ ", createDate=" + createDate + ", reviewYN=" + reviewYN + "]";
	}
	
	
	
}
