package thenolja.tb_hotel.model.vo;

import java.util.ArrayList;

// hotel detail page 에서 보여줄 데이터 VO
public class DetailHotel {
	private String hotelName;
	private String hotelPath; // 사진경로
	private String hotelCate;
	private String hotelIntro;
	
	private ArrayList<RoomInfo> roomList;
	private ArrayList<ServiceList> serList;
	private ArrayList<HotelReview> reviewList;
		
	public DetailHotel() {
		super();
	}

	public DetailHotel(String hotelName, String hotelPath, String hotelCate, String hotelIntro,
			ArrayList<RoomInfo> roomList, ArrayList<ServiceList> serList, ArrayList<HotelReview> reviewList) {
		super();
		this.hotelName = hotelName;
		this.hotelPath = hotelPath;
		this.hotelCate = hotelCate;
		this.hotelIntro = hotelIntro;
		this.roomList = roomList;
		this.serList = serList;
		this.reviewList = reviewList;
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

	public void setHotelPath(String hotelPath) {
		this.hotelPath = hotelPath;
	}

	public String getHotelCate() {
		return hotelCate;
	}

	public void setHotelCate(String hotelCate) {
		this.hotelCate = hotelCate;
	}

	public String getHotelIntro() {
		return hotelIntro;
	}

	public void setHotelIntro(String hotelIntro) {
		this.hotelIntro = hotelIntro;
	}

	public ArrayList<RoomInfo> getRoomList() {
		return roomList;
	}

	public void setRoomList(ArrayList<RoomInfo> roomList) {
		this.roomList = roomList;
	}

	public ArrayList<ServiceList> getSerList() {
		return serList;
	}

	public void setSerList(ArrayList<ServiceList> serList) {
		this.serList = serList;
	}

	public ArrayList<HotelReview> getReviewList() {
		return reviewList;
	}

	public void setReviewList(ArrayList<HotelReview> reviewList) {
		this.reviewList = reviewList;
	}

	@Override
	public String toString() {
		return "DetailHotel [hotelName=" + hotelName + ", hotelPath=" + hotelPath + ", hotelCate=" + hotelCate
				+ ", hotelIntro=" + hotelIntro + ", roomList=" + roomList + ", serList=" + serList + ", reviewList="
				+ reviewList + "]";
	}

	
}
