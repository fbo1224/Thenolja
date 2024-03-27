package thenolja.notice.model.vo;

import java.util.Date;

public class Notice {
	
	private String noticeTitle;
	private String noticeContent;
	private String createDate;
	private String status;
	private int writerNo;
	private String writer; 	   // 상세화면 조회 시 작성자명
	private int viewCount;	   // 조회 수
	
	public Notice() {
		super();
	}
	// 저장 시 파라미터 처리를 위한 생성자 생성
	public Notice(String title, String content) {
		this.noticeTitle   = title;
		this.noticeContent = content;
	}	
	// 저장 시 파라미터 처리를 위한 생성자 생성
	public Notice(String title, String content, String status) {
		this.noticeTitle   = title;
		this.noticeContent = content;
		this.status = status;
	}	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	private int noticeNo;
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	
	
	
}
