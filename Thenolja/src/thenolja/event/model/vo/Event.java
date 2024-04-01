package  thenolja.event.model.vo;

public class Event {
	
	private int eventNo;			// �씠踰ㅽ듃 愿�由щ쾲�샇
	private String eventTitle;		// �씠踰ㅽ듃 �젣紐�
	private String eventContent;	// �씠踰ㅽ듃 �궡�슜
	private String eventDate;		// �씠踰ㅽ듃 �벑濡앹씪
	private String eventYn;			// �씠踰ㅽ듃 吏꾪뻾�뿬遺�
	private String eventImg;		// �씠踰ㅽ듃 �씠誘몄�
	private int writerNo;			// �옉�꽦�옄 愿�由щ쾲�샇
	private String writer; 	   		// �긽�꽭�솕硫� 議고쉶 �떆 �옉�꽦�옄紐�
	
	public Event() {
		super();
}
	
		// ���옣 �떆 �뙆�씪誘명꽣 泥섎━瑜� �쐞�븳 �깮�꽦�옄 �깮�꽦
		public Event(String title, String content, String eventDate, String eventYn, String eventImg, int writerNo ) {
			this.eventTitle    = title;
			this.eventContent  = content;
			this.eventDate 		= eventDate;
			this.eventYn         = eventYn;
			this.eventImg        = eventImg;
			this.writerNo        = writerNo;
		}
		
		// �닔�젙�떆 �뙆�씪誘명꽣 泥섎━瑜� �쐞�븳 �깮�꽦�옄 �깮�꽦
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
