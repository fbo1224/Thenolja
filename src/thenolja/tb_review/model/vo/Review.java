package thenolja.tb_review.model.vo;

import java.sql.Date;

public class Review {

	private int reserNo;
	private String imgPath;
	private String content;
	private int score;
	private Date createDate;
	private String reviewYN;
	public Review() {
		super();
	}
	public Review(int reserNo, String imgPath, String content, int score, Date createDate, String reviewYN) {
		super();
		this.reserNo = reserNo;
		this.imgPath = imgPath;
		this.content = content;
		this.score = score;
		this.createDate = createDate;
		this.reviewYN = reviewYN;
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
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
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((imgPath == null) ? 0 : imgPath.hashCode());
		result = prime * result + reserNo;
		result = prime * result + ((reviewYN == null) ? 0 : reviewYN.hashCode());
		result = prime * result + score;
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
		if (imgPath == null) {
			if (other.imgPath != null)
				return false;
		} else if (!imgPath.equals(other.imgPath))
			return false;
		if (reserNo != other.reserNo)
			return false;
		if (reviewYN == null) {
			if (other.reviewYN != null)
				return false;
		} else if (!reviewYN.equals(other.reviewYN))
			return false;
		if (score != other.score)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Review [reserNo=" + reserNo + ", imgPath=" + imgPath + ", content=" + content + ", score=" + score
				+ ", createDate=" + createDate + ", reviewYN=" + reviewYN + "]";
	}
	
	
	
}
