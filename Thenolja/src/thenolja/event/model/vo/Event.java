package  thenolja.event.model.vo;

public class Event {
	
	private int eventNo;			// 이벤트 관리번호
	private String eventTitle;		// 이벤트 제목
	private String eventContent;	// 이벤트 내용
	private String eventDate;		// 이벤트 등록일
	private String eventYn;			// 이벤트 진행여부
	private String eventImg;		// 이벤트 이미지
	private int writerNo;			// 작성자 관리번호
	private String writer; 	   		// 상세화면 조회 시 작성자명
	
	public Event() {
		super();
}
	
		// 저장 시 파라미터 처리를 위한 생성자 생성
		public Event(String title, String content, String eventDate, String eventYn, String eventImg, int writerNo ) {
			this.eventTitle    = title;
			this.eventContent  = content;
			this.eventDate 		= eventDate;
			this.eventYn         = eventYn;
			this.eventImg        = eventImg;
			this.writerNo        = writerNo;
		}
		
		// 수정시 파라미터 처리를 위한 생성자 생성
		public Event(String title, String content, String eventDate, int eventNo) {
			this.eventTitle    = title;
			this.eventContent  = content;
			this.eventDate 		= eventDate;
			this.eventNo 		= eventNo;
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

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
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

}
