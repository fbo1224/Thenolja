package thenolja.mypage.model.vo;

public class Profile {
	
	private int memNo;
	private String profilePath;
	private String originName;
	private String changeName;
	public Profile() {
		super();
	}
	public Profile(int memNo, String profilePath, String originName, String changeName) {
		super();
		this.memNo = memNo;
		this.profilePath = profilePath;
		this.originName = originName;
		this.changeName = changeName;
	}
	public int getMemNo() {
		return memNo;
	}
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
	public String getProfilePath() {
		return profilePath;
	}
	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public String getChangeName() {
		return changeName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	@Override
	public String toString() {
		return "Profile [memNo=" + memNo + ", profilePath=" + profilePath + ", originName=" + originName
				+ ", changeName=" + changeName + "]";
	}
	
	
	
	
	
	
	
	
	
}
