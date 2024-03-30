package thenolja.tb_hotel.model.vo;

import java.sql.Date;

public class HotelReview {
	
	private int hotelNo;
	private int roomNo;
	private int reserNo;
	private String reviewScore;
	private String reserName;
	private String reviewContent;
	private Date createDate;
	
	public HotelReview() {
		super();
	}

	public HotelReview(int hotelNo, int roomNo, String reviewScore, String reserName, String reviewContent,
			Date createDate) {
		super();
		this.hotelNo = hotelNo;
		this.roomNo = roomNo;
		this.reviewScore = reviewScore;
		this.reserName = reserName;
		this.reviewContent = reviewContent;
		this.createDate = createDate;
	}
	
	public int getReserNo() {
		return reserNo;
	}

	public void setReserNo(int reserNo) {
		this.reserNo = reserNo;
	}

	public int getHotelNo() {
		return hotelNo;
	}

	public void setHotelNo(int hotelNo) {
		this.hotelNo = hotelNo;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(String reviewScore) {
		this.reviewScore = reviewScore;
	}

	public String getReserName() {
		return reserName;
	}

	public void setReserName(String reserName) {
		this.reserName = reserName;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "HotelReview [hotelNo=" + hotelNo + ", roomNo=" + roomNo + ", reviewScore=" + reviewScore
				+ ", reserName=" + reserName + ", reviewContent=" + reviewContent + ", createDate=" + createDate + "]";
	}
	
}
