package thenolja.admin.review.model.vo;

public class AdminReview {
	
	private int reserNo;
	private String imgPath;
	private String reviewContent;
	private String reviewScore;
	private String createDate;
	private String reviewYn;
	private String hotelName;
	private String memId;
	private String nickName;
	private String roomName;
	
	public AdminReview() {
		super();
	}

	public AdminReview(int reserNo, String imgPath, String reviewContent, String reviewScore, String createDate,
			String reviewYn) {
		super();
		this.reserNo = reserNo;
		this.imgPath = imgPath;
		this.reviewContent = reviewContent;
		this.reviewScore = reviewScore;
		this.createDate = createDate;
		this.reviewYn = reviewYn;
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

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(String reviewScore) {
		this.reviewScore = reviewScore;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getReviewYn() {
		return reviewYn;
	}

	public void setReviewYn(String reviewYn) {
		this.reviewYn = reviewYn;
	}

	
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((imgPath == null) ? 0 : imgPath.hashCode());
		result = prime * result + reserNo;
		result = prime * result + ((reviewContent == null) ? 0 : reviewContent.hashCode());
		result = prime * result + ((reviewScore == null) ? 0 : reviewScore.hashCode());
		result = prime * result + ((reviewYn == null) ? 0 : reviewYn.hashCode());
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
		AdminReview other = (AdminReview) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (imgPath == null) {
			if (other.imgPath != null)
				return false;
		} else if (!imgPath.equals(other.imgPath))
			return false;
		if (reserNo != other.reserNo)
			return false;
		if (reviewContent == null) {
			if (other.reviewContent != null)
				return false;
		} else if (!reviewContent.equals(other.reviewContent))
			return false;
		if (reviewScore == null) {
			if (other.reviewScore != null)
				return false;
		} else if (!reviewScore.equals(other.reviewScore))
			return false;
		if (reviewYn == null) {
			if (other.reviewYn != null)
				return false;
		} else if (!reviewYn.equals(other.reviewYn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AdminReview [reserNo=" + reserNo + ", imgPath=" + imgPath + ", reviewContent=" + reviewContent
				+ ", reviewScore=" + reviewScore + ", createDate=" + createDate + ", reviewYn=" + reviewYn + "]";
	}

	
	
	
	
	
}
