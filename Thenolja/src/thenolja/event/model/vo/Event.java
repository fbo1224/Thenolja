package thenolja.event.model.vo;

/**
 * 
 */
public class Event {
	
	private int eventNo;			// 이벤트 관리번호
	private String eventTitle;		// 이벤트 제목
	private String eventContent;	// 이벤트 내용
	private String eventStrtDt;		// 이벤트 시작일
	private String eventEndDt;		// 이벤트 종료일
	private String eventYn;			// 이벤트 진행여부
	private String eventImg;		// 이벤트 이미지
	private int writerNo;			// 작성자 관리번호
	private String writer; 	   		// 상세화면 조회 시 작성자명
	private String createDt;		// 등록일

	// 기본 생성자
	public Event() {}
	
	// 이벤트 등록시 사용 생성자
	public Event(String evtTitle, String evtContent, String evtYn,
				 String evtStrtDt, String evtEndDt, String eventImg, int writerNo) {
		this.eventTitle 	= evtTitle;
		this.eventContent 	= evtContent;
		this.eventYn 		= evtYn;
		this.eventStrtDt 	= evtStrtDt;
		this.eventEndDt 	= evtEndDt;
		this.eventImg 		= eventImg;
		this.writerNo 		= writerNo;
	}
	
	// 이벤트 업데이트 시 사용 생성자
	public Event(String evtTitle, String evtContent, String evtYn,
				 String evtStrtDt, String evtEndDt, String eventImg, 
				 int writerNo, int eventNo) {
		this.eventTitle 	= evtTitle;
		this.eventContent 	= evtContent;
		this.eventYn 		= evtYn;
		this.eventStrtDt 	= evtStrtDt;
		this.eventEndDt 	= evtEndDt;
		this.eventImg 		= eventImg;
		this.writerNo 		= writerNo;
		this.eventNo		= eventNo;
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

	public String getEventYn() {
		return eventYn;
	}

	public void setEventYn(String eventYn) {
		this.eventYn = eventYn;
	}

	public String getEventImg() {
		return eventImg;
	}

	public void setEventImg(String eventImg) {
		this.eventImg = eventImg;
	}

	public int getWriterNo() {
		return writerNo;
	}

	public void setWriterNo(int writerNo) {
		this.writerNo = writerNo;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getEventStrtDt() {
		return eventStrtDt;
	}

	public void setEventStrtDt(String eventStrtDt) {
		this.eventStrtDt = eventStrtDt;
	}

	public String getEventEndDt() {
		return eventEndDt;
	}

	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	public String getCreateDt() {
		return createDt;
	}

	public void setEventEndDt(String eventEndDt) {
		this.eventEndDt = eventEndDt;
	}	

	@Override
	public String toString() {
		return "Event [eventNo=" + eventNo + ", eventTitle=" + eventTitle + ", eventContent=" + eventContent
				+ ", eventStrtDt=" + eventStrtDt + ", eventEndDt=" + eventEndDt + ", eventYn=" + eventYn + ", eventImg="
				+ eventImg + ", writerNo=" + writerNo + ", writer=" + writer + ", createDt=" + createDt + "]";
	}
	
}
