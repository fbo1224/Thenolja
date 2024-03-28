package thenolja.member.model.vo;

import java.sql.Date;

public class Member {
	private int memNo;
	
	private String memName;
	private String memPhone;
	private String memId;
	private String memPwd;
	private String nickname;
	private String email;
	
	
	private String bornDate; // 생년월일
	private Date joinDate; // 가입일
	
	private String memStatus; //비회원 / 회원 표시
	private String deleteYn; // 탈퇴 회원 표시
	
	public Member() {
		super();
	}
	

	public Member(String memId) {
		super();
		this.memId = memId;
	}


	public Member(int memNo, String memName, String memPhone, String memStatus) {
		super();
		this.memNo = memNo;
		this.memName = memName;
		this.memPhone = memPhone;
		this.memStatus = memStatus;
	}


	public Member(int memNo, String memName, String memPhone, String memId, String memPwd, String nickname,
			String email, String bornDate, Date joinDate, String memStatus, String deleteYn) {
		super();
		this.memNo = memNo;
		this.memName = memName;
		this.memPhone = memPhone;
		this.memId = memId;
		this.memPwd = memPwd;
		this.nickname = nickname;
		this.email = email;
		this.bornDate = bornDate;
		this.joinDate = joinDate;
		this.memStatus = memStatus;
		this.deleteYn = deleteYn;
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

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPwd() {
		return memPwd;
	}

	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBornDate() {
		return bornDate;
	}

	public void setBornDate(String bornDate) {
		this.bornDate = bornDate;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getMemStatus() {
		return memStatus;
	}

	public void setMemStatus(String memStatus) {
		this.memStatus = memStatus;
	}

	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	@Override
	public String toString() {
		return "Member [memNo=" + memNo + ", memName=" + memName + ", memPhone=" + memPhone + ", memId=" + memId
				+ ", memPwd=" + memPwd + ", nickname=" + nickname + ", email=" + email + ", bornDate=" + bornDate
				+ ", joinDate=" + joinDate + ", memStatus=" + memStatus + ", deleteYn=" + deleteYn + "]";
	}
	
	
	
	
}
