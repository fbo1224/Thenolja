package thenolja.tb_hotel.model.vo;

import java.sql.Date;

public class Comment {
	private int roomNo;
	private int reserNo;
	private String nickname;
	private String commentContent;
	private Date createDate;
	
	public Comment() {
		super();
	}

	public Comment(String commentContent, Date createDate, String nickname, int roomNo) {
		super();
		this.commentContent = commentContent;
		this.createDate = createDate;
		this.nickname = nickname;
		this.roomNo = roomNo;
	}
	
	public int getReserNo() {
		return reserNo;
	}

	public void setReserNo(int reserNo) {
		this.reserNo = reserNo;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	@Override
	public String toString() {
		return "Comment [commentContent=" + commentContent + ", createDate=" + createDate + ", nickname=" + nickname
				+ ", roomNo=" + roomNo + "]";
	}
	
}
