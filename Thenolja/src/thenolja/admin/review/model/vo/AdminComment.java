package thenolja.admin.review.model.vo;

public class AdminComment {
	
	private int commentReserNo;
	private String commentContent;
	private String creaeteDate;
	private int commentMemNo;
	
	public AdminComment() {
		super();
	}

	public AdminComment(int commentReserNo, String commentContent, String creaeteDate, int commentMemNo) {
		super();
		this.commentReserNo = commentReserNo;
		this.commentContent = commentContent;
		this.creaeteDate = creaeteDate;
		this.commentMemNo = commentMemNo;
	}

	public int getCommentReserNo() {
		return commentReserNo;
	}

	public void setCommentReserNo(int commentReserNo) {
		this.commentReserNo = commentReserNo;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCreaeteDate() {
		return creaeteDate;
	}

	public void setCreaeteDate(String creaeteDate) {
		this.creaeteDate = creaeteDate;
	}

	public int getCommentMemNo() {
		return commentMemNo;
	}

	public void setCommentMemNo(int commentMemNo) {
		this.commentMemNo = commentMemNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentContent == null) ? 0 : commentContent.hashCode());
		result = prime * result + commentMemNo;
		result = prime * result + commentReserNo;
		result = prime * result + ((creaeteDate == null) ? 0 : creaeteDate.hashCode());
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
		AdminComment other = (AdminComment) obj;
		if (commentContent == null) {
			if (other.commentContent != null)
				return false;
		} else if (!commentContent.equals(other.commentContent))
			return false;
		if (commentMemNo != other.commentMemNo)
			return false;
		if (commentReserNo != other.commentReserNo)
			return false;
		if (creaeteDate == null) {
			if (other.creaeteDate != null)
				return false;
		} else if (!creaeteDate.equals(other.creaeteDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AdminComment [commentReserNo=" + commentReserNo + ", commentContent=" + commentContent
				+ ", creaeteDate=" + creaeteDate + ", commentMemNo=" + commentMemNo + "]";
	}
	
	
	

}
