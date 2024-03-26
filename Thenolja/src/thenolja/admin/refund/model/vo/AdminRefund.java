package thenolja.admin.refund.model.vo;

public class AdminRefund {
	
	private int reserNo;
	private int refundPrice;
	private String refundAccNo;
	private String refundName;
	private String bank;
	private String memId;
	private String reserName;
	private String memPhone;
	
	
	
	public String getReserName() {
		return reserName;
	}

	public void setReserName(String reserName) {
		this.reserName = reserName;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public AdminRefund() {
		super();
	}

	public AdminRefund(int reserNo, int refundPrice, String refundAccNo, String refundName, String bank) {
		super();
		this.reserNo = reserNo;
		this.refundPrice = refundPrice;
		this.refundAccNo = refundAccNo;
		this.refundName = refundName;
		this.bank = bank;
	}

	public int getReserNo() {
		return reserNo;
	}

	public void setReserNo(int reserNo) {
		this.reserNo = reserNo;
	}

	public int getRefundPrice() {
		return refundPrice;
	}

	public void setRefundPrice(int refundPrice) {
		this.refundPrice = refundPrice;
	}

	public String getRefundAccNo() {
		return refundAccNo;
	}

	public void setRefundAccNo(String refundAccNo) {
		this.refundAccNo = refundAccNo;
	}

	public String getRefundName() {
		return refundName;
	}

	public void setRefundName(String refundName) {
		this.refundName = refundName;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bank == null) ? 0 : bank.hashCode());
		result = prime * result + ((refundAccNo == null) ? 0 : refundAccNo.hashCode());
		result = prime * result + ((refundName == null) ? 0 : refundName.hashCode());
		result = prime * result + refundPrice;
		result = prime * result + reserNo;
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
		AdminRefund other = (AdminRefund) obj;
		if (bank == null) {
			if (other.bank != null)
				return false;
		} else if (!bank.equals(other.bank))
			return false;
		if (refundAccNo == null) {
			if (other.refundAccNo != null)
				return false;
		} else if (!refundAccNo.equals(other.refundAccNo))
			return false;
		if (refundName == null) {
			if (other.refundName != null)
				return false;
		} else if (!refundName.equals(other.refundName))
			return false;
		if (refundPrice != other.refundPrice)
			return false;
		if (reserNo != other.reserNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AdminRefund [reserNo=" + reserNo + ", refundPrice=" + refundPrice + ", refundAccNo=" + refundAccNo
				+ ", refundName=" + refundName + ", bank=" + bank + "]";
	}
	

	
	
	
	
}
