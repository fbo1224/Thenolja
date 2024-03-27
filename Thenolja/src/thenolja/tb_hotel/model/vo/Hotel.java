package thenolja.tb_hotel.model.vo;

import java.util.Arrays;

public class Hotel {
	private int hotelNo;
	private String hotelName;
	private String hotelPhone;
	private String hotelLocation; // 지역
	private String hotelAddress;  // 주소
	private String hotelDetail;
	private String hotelCategory;
	private String hotelPath; // 숙소사진
	private String hotelIntro;
	private String hotelYN;
	private String hostName;
	private String[] serList;
	
	public Hotel() {
		super();
	}

	public Hotel(int hotelNo, String hotelName, String hotelPhone, String hotelLocation, String hotelAddress,
			String hotelCategory, String hotelPath, String hotelIntro, String hotelYN, String hostName,
			String[] serList) {
		super();
		this.hotelNo = hotelNo;
		this.hotelName = hotelName;
		this.hotelPhone = hotelPhone;
		this.hotelLocation = hotelLocation;
		this.hotelAddress = hotelAddress;
		this.hotelCategory = hotelCategory;
		this.hotelPath = hotelPath;
		this.hotelIntro = hotelIntro;
		this.hotelYN = hotelYN;
		this.hostName = hostName;
		this.serList = serList;
	}
	
	public String getHotelDetail() {
		return hotelDetail;
	}

	public void setHotelDetail(String hotelDetail) {
		this.hotelDetail = hotelDetail;
	}

	public String[] getSerList() {
		return serList;
	}

	public void setSerList(String[] serList) {
		this.serList = serList;
	}

	public int getHotelNo() {
		return hotelNo;
	}

	public void setHotelNo(int hotelNo) {
		this.hotelNo = hotelNo;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelPhone() {
		return hotelPhone;
	}

	public void setHotelPhone(String hotelPhone) {
		this.hotelPhone = hotelPhone;
	}

	public String getHotelLocation() {
		return hotelLocation;
	}

	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public String getHotelCategory() {
		return hotelCategory;
	}

	public void setHotelCategory(String hotelCategory) {
		this.hotelCategory = hotelCategory;
	}

	public String getHotelPath() {
		return hotelPath;
	}

	public void setHotelPath(String hotelPath) {
		this.hotelPath = hotelPath;
	}

	public String getHotelIntro() {
		return hotelIntro;
	}

	public void setHotelIntro(String hotelIntro) {
		this.hotelIntro = hotelIntro;
	}

	public String getHotelYN() {
		return hotelYN;
	}

	public void setHotelYN(String hotelYN) {
		this.hotelYN = hotelYN;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	@Override
	public String toString() {
		return "Hotel [hotelNo=" + hotelNo + ", hotelName=" + hotelName + ", hotelPhone=" + hotelPhone
				+ ", hotelLocation=" + hotelLocation + ", hotelAddress=" + hotelAddress + ", hotelCategory="
				+ hotelCategory + ", hotelPath=" + hotelPath + ", hotelIntro=" + hotelIntro + ", hotelYN=" + hotelYN
				+ ", hostName=" + hostName + ", serList=" + Arrays.toString(serList) + "]";
	}
	
}
