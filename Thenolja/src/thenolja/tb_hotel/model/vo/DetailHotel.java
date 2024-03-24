package thenolja.tb_hotel.model.vo;

import java.util.ArrayList;

// hotel detail page 에서 보여줄 데이터 VO
// 리뷰는 따로 만듬
public class DetailHotel {
	private String hotelName;
	private String hotelPath; // 사진경로
	private String hotelCate;
	private String hotelIntro;
	private String checkInTime;
	private String checkOutTime;
	private String roomName;
	private String roomImg;
	private int roomNum;
	private int roomPrice;
	private ArrayList<ServiceList> serList;
	private ArrayList<HotelReview> reviewList;
	
	
	public DetailHotel() {
		super();
	}

	public DetailHotel(String hotelName, String hotePath, String hoteCate, String hotelIntro, String checkInTime,
			String checkOutTime, String roomName, int roomNum, int roomPrice, String roomImg) {
		super();
		this.hotelName = hotelName;
		this.hotelPath = hotePath;
		this.hotelCate = hoteCate;
		this.hotelIntro = hotelIntro;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.roomName = roomName;
		this.roomNum = roomNum;
		this.roomPrice = roomPrice;
		this.roomImg = roomImg;
	}
	
	
	
	public ArrayList<HotelReview> getReviewList() {
		return reviewList;
	}

	public void setReviewList(ArrayList<HotelReview> reviewList) {
		this.reviewList = reviewList;
	}

	public ArrayList<ServiceList> getSerList() {
		return serList;
	}

	public void setSerList(ArrayList<ServiceList> serList) {
		this.serList = serList;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelPath() {
		return hotelPath;
	}

	public void setHotelPath(String hotePath) {
		this.hotelPath = hotePath;
	}

	public String getHotelCate() {
		return hotelCate;
	}

	public void setHotelCate(String hoteCate) {
		this.hotelCate = hoteCate;
	}

	public String getHotelIntro() {
		return hotelIntro;
	}

	public void setHotelIntro(String hotelIntro) {
		this.hotelIntro = hotelIntro;
	}

	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getRoomImg() {
		return roomImg;
	}

	public void setRoomImg(String roomImg) {
		this.roomImg = roomImg;
	}

	@Override
	public String toString() {
		return "DetailHotel [hotelName=" + hotelName + ", hotelPath=" + hotelPath + ", hotelCate=" + hotelCate
				+ ", hotelIntro=" + hotelIntro + ", checkInTime=" + checkInTime + ", checkOutTime=" + checkOutTime
				+ ", roomName=" + roomName + ", roomImg=" + roomImg + ", roomNum=" + roomNum + ", roomPrice="
				+ roomPrice + ", serList=" + serList + ", reviewList=" + reviewList + "]";
	}
	
}
