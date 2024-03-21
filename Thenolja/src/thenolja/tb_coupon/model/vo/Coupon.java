package thenolja.tb_coupon;

import java.sql.Date;

public class Coupon {
	
	private int couponNo;
	private String couponContent;
	private Date couponDate;
	private String couponYN;
	private String couponCode;
	
	public Coupon() {
		super();
	}
	
	public Coupon(int couponNo, String couponContent, Date couponDate, String couponYN, String couponCode) {
		super();
		this.couponNo = couponNo;
		this.couponContent = couponContent;
		this.couponDate = couponDate;
		this.couponYN = couponYN;
		this.couponCode = couponCode;
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

	public Date getCouponDate() {
		return couponDate;
	}

	public void setCouponDate(Date couponDate) {
		this.couponDate = couponDate;
	}

	public String getCouponYN() {
		return couponYN;
	}

	public void setCouponYN(String couponYN) {
		this.couponYN = couponYN;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((couponCode == null) ? 0 : couponCode.hashCode());
		result = prime * result + ((couponContent == null) ? 0 : couponContent.hashCode());
		result = prime * result + ((couponDate == null) ? 0 : couponDate.hashCode());
		result = prime * result + couponNo;
		result = prime * result + ((couponYN == null) ? 0 : couponYN.hashCode());
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
		Coupon other = (Coupon) obj;
		if (couponCode == null) {
			if (other.couponCode != null)
				return false;
		} else if (!couponCode.equals(other.couponCode))
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
		if (couponYN == null) {
			if (other.couponYN != null)
				return false;
		} else if (!couponYN.equals(other.couponYN))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coupon [couponNo=" + couponNo + ", couponContent=" + couponContent + ", couponDate=" + couponDate
				+ ", couponYN=" + couponYN + ", couponCode=" + couponCode + "]";
	}
	
	

	
	
	
	

}
