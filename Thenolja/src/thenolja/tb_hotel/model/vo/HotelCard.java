package thenolja.tb_hotel.model.vo;

// hotelList에서 보여주는 카드내용 담는 vo
public class HotelCard {
	private String hotelName;
	private String hotelLocation;
	private String hotelCategory;
	private String hotelPath;
	private int roomPrice;
	
	public HotelCard() {
		super();
	}

	public HotelCard(String hotelName, String hotelLocation, String hotelCategory, String hotelPath, int roomPrice) {
		super();
		this.hotelName = hotelName;
		this.hotelLocation = hotelLocation;
		this.hotelCategory = hotelCategory;
		this.hotelPath = hotelPath;
		this.roomPrice = roomPrice;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelLocation() {
		return hotelLocation;
	}

	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
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

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	@Override
	public String toString() {
		return "HotelCard [hotelName=" + hotelName + ", hotelLocation=" + hotelLocation + ", hotelCategory="
				+ hotelCategory + ", hotelPath=" + hotelPath + ", roomPrice=" + roomPrice + "]";
	}
	
}
