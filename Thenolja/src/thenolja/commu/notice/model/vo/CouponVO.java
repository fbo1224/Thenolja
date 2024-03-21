package thenoleja.commu.notice.model.vo;

public class CouponVO {

	private String couponContent;
	private String couponDate;
	private String coponYN;
	private String coponCode;
	
	
	
	  
	public CouponVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CouponVO [couponContent=" + couponContent + ", couponDate=" + couponDate + ", coponYN=" + coponYN
				+ ", coponCode=" + coponCode + ", couponNo=" + couponNo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coponCode == null) ? 0 : coponCode.hashCode());
		result = prime * result + ((coponYN == null) ? 0 : coponYN.hashCode());
		result = prime * result + ((couponContent == null) ? 0 : couponContent.hashCode());
		result = prime * result + ((couponDate == null) ? 0 : couponDate.hashCode());
		result = prime * result + couponNo;
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
		CouponVO other = (CouponVO) obj;
		if (coponCode == null) {
			if (other.coponCode != null)
				return false;
		} else if (!coponCode.equals(other.coponCode))
			return false;
		if (coponYN == null) {
			if (other.coponYN != null)
				return false;
		} else if (!coponYN.equals(other.coponYN))
			return false;
		if (couponContent == null) {
			if (other.couponContent != null)
				return false;
		} else if (!couponContent.equals(other.couponContent))
			return false;
		if (couponDate == null) {
			if (other.couponDate != null)
				return false;
		} else if (!couponDate.equals(other.couponDate))
			return false;
		if (couponNo != other.couponNo)
			return false;
		return true;
	}
	private  int  couponNo;
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
	public String getCoponYN() {
		return coponYN;
	}
	public void setCoponYN(String coponYN) {
		this.coponYN = coponYN;
	}
	public String getCoponCode() {
		return coponCode;
	}
	public void setCoponCode(String coponCode) {
		this.coponCode = coponCode;
	}
	
	
	
	
	
	
}
