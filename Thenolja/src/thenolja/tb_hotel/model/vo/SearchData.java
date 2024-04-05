package thenolja.tb_hotel.model.vo;

public class SearchData {
	private String daterange;
	private String location;
	private int maxPeople;
	
	public SearchData() {
		super();
	}

	public SearchData(String daterange, String location, int maxPeople) {
		super();
		this.daterange = daterange;
		this.location = location;
		this.maxPeople = maxPeople;
	}

	public String getDaterange() {
		return daterange;
	}

	public void setDaterange(String daterange) {
		this.daterange = daterange;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getMaxPeople() {
		return maxPeople;
	}

	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}

	@Override
	public String toString() {
		return "SearchData [daterange=" + daterange + ", location=" + location + ", maxPeople=" + maxPeople + "]";
	}
	
}
