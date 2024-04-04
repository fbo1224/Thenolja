package thenolja.coupon.model.vo;

public class Coupon {

	private int couponNo;			// 荑좏룿踰덊샇
	private String couponContent;	// 荑좏룿�궡�슜
	private String couponDate;		// 荑좏룿�벑濡앹씪
	private String couponYn;		// 荑좏룿�궗�슜�뿬遺�
	private String couponCateCd;	// 荑좏룿移댄뀒怨좊━ 肄붾뱶
	private String couponCateNm;	// 荑좏룿 移댄뀒怨좊━紐�
	private String couponCode;		// 荑좏룿肄붾뱶
	private int couponPercent;		// 荑좏룿�븷�씤�쑉
	private String writer;			// �벑濡앹옄
	private int writerNo;			// �벑濡앹옄踰덊샇(�쉶�썝踰덊샇)
	

	public Coupon() {}
	
	public int getCouponNo() {
		return couponNo;
	}
	public void setCouponNo(int couponNo) {
		this.couponNo = couponNo;
	}
	public String getCouponContent() {
		return couponContent;
	}
	public void setCouponContent(String couponContent) {
		this.couponContent = couponContent;
	}
	public String getCouponDate() {
		return couponDate;
	}
	public void setCouponDate(String couponDate) {
		this.couponDate = couponDate;
	}
	public String getCouponYn() {
		return couponYn;
	}
	public void setCouponYn(String couponYn) {
		this.couponYn = couponYn;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public int getCouponPercent() {
		return couponPercent;
	}
	public void setCouponPercent(int couponPercent) {
		this.couponPercent = couponPercent;
	}
	
	public String getCouponCateCd() {
		return couponCateCd;
	}

	public void setCouponCateCd(String couponCateCd) {
		this.couponCateCd = couponCateCd;
	}

	public String getCouponCateNm() {
		return couponCateNm;
	}

	public void setCouponCateNm(String couponCateNm) {
		this.couponCateNm = couponCateNm;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getWriterNo() {
		return writerNo;
	}

	public void setWriterNo(int writerNo) {
		this.writerNo = writerNo;
	}

	@Override
	public String toString() {
		return "Coupon [couponNo=" + couponNo + ", couponContent=" + couponContent + ", couponDate=" + couponDate
				+ ", couponYn=" + couponYn + ", couponCateCd=" + couponCateCd + ", couponCateNm=" + couponCateNm
				+ ", couponCode=" + couponCode + ", couponPercent=" + couponPercent + ", writer=" + writer
				+ ", writerNo=" + writerNo + "]";
	}	
	
	
}
