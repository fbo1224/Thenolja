package thenolja.tb_hotel.model.vo;

import java.sql.Date;

public class Event {
	private int eventNo;
	private String eventTitle;
	private String eventContent;
	private String eventImg;
	private Date createDate;
	
	public Event() {
		super();
	}

	public Event(int eventNo, String eventTitle, String eventContent, String eventImg, Date createDate) {
		super();
		this.eventNo = eventNo;
		this.eventTitle = eventTitle;
		this.eventContent = eventContent;
		this.eventImg = eventImg;
		this.createDate = createDate;
	}

	public int getEventNo() {
		return eventNo;
	}

	public void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getEventContent() {
		return eventContent;
	}

	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}

	public String getEventImg() {
		return eventImg;
	}

	public void setEventImg(String eventImg) {
		this.eventImg = eventImg;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Event [eventNo=" + eventNo + ", eventTitle=" + eventTitle + ", eventContent=" + eventContent
				+ ", eventImg=" + eventImg + ", createDate=" + createDate + "]";
	}
	
}
