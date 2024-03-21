package thenolja.admin.nonMember.model.vo;

public class NonMember {
	
	private int memNo;
	private String memName;
	private String memPhone;
	private String memStatus;
	
	public NonMember() {
		super();
	}

	public NonMember(int memNo, String memName, String memPhone, String memStatus) {
		super();
		this.memNo = memNo;
		this.memName = memName;
		this.memPhone = memPhone;
		this.memStatus = memStatus;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	public String getMemStatus() {
		return memStatus;
	}

	public void setMemStatus(String memStatus) {
		this.memStatus = memStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memName == null) ? 0 : memName.hashCode());
		result = prime * result + memNo;
		result = prime * result + ((memPhone == null) ? 0 : memPhone.hashCode());
		result = prime * result + ((memStatus == null) ? 0 : memStatus.hashCode());
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
		NonMember other = (NonMember) obj;
		if (memName == null) {
			if (other.memName != null)
				return false;
		} else if (!memName.equals(other.memName))
			return false;
		if (memNo != other.memNo)
			return false;
		if (memPhone == null) {
			if (other.memPhone != null)
				return false;
		} else if (!memPhone.equals(other.memPhone))
			return false;
		if (memStatus == null) {
			if (other.memStatus != null)
				return false;
		} else if (!memStatus.equals(other.memStatus))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NonMember [memNo=" + memNo + ", memName=" + memName + ", memPhone=" + memPhone + ", memStatus="
				+ memStatus + "]";
	}
	
	
	
	

}
