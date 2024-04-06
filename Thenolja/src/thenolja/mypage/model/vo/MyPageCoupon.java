package thenolja.mypage.model.vo;

public class MyPageCoupon {
	
	private int couponNo;
	private String couponContent;
	private String couponDate;
	private String couponCateCd;
	private String couponCateNm;
	private int couponPercent;
	public MyPageCoupon() {
		super();
	}
	public MyPageCoupon(int couponNo, String couponContent, String couponDate, String couponCateCd, String couponCateNm,
			int couponPercent) {
		super();
		this.couponNo = couponNo;
		this.couponContent = couponContent;
		this.couponDate = couponDate;
		this.couponCateCd = couponCateCd;
		this.couponCateNm = couponCateNm;
		this.couponPercent = couponPercent;
	}
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
	public int getCouponPercent() {
		return couponPercent;
	}
	public void setCouponPercent(int couponPercent) {
		this.couponPercent = couponPercent;
	}
	@Override
	public String toString() {
		return "MyPageCoupon [couponNo=" + couponNo + ", couponContent=" + couponContent + ", couponDate=" + couponDate
				+ ", couponCateCd=" + couponCateCd + ", couponCateNm=" + couponCateNm + ", couponPercent="
				+ couponPercent + "]";
	}

	
	
}
