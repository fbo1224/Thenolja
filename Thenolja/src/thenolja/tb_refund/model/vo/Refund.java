package thenolja.tb_refund.model.vo;

public class Refund {
	
	private int reserNo;
	private int refundPrice;
	private int accNo;
	private String refundName;
	private String bank;
	public Refund() {
		super();
	}
	public Refund(int reserNo, int refundPrice, int accNo, String refundName, String bank) {
		super();
		this.reserNo = reserNo;
		this.refundPrice = refundPrice;
		this.accNo = accNo;
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
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
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
		result = prime * result + accNo;
		result = prime * result + ((bank == null) ? 0 : bank.hashCode());
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
		Refund other = (Refund) obj;
		if (accNo != other.accNo)
			return false;
		if (bank == null) {
			if (other.bank != null)
				return false;
		} else if (!bank.equals(other.bank))
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
		return "Refund [reserNo=" + reserNo + ", refundPrice=" + refundPrice + ", accNo=" + accNo + ", refundName="
				+ refundName + ", bank=" + bank + "]";
	}
	
	

}
