package thenolja.tb_hotel.model.vo;

public class SearchOptions {
	private int maxPeople;
	private String location;
	private String startDate;
	private String endDate;
	
	public SearchOptions() {
		super();
	}

	public SearchOptions(int maxPeople, String location, String startDate, String endDate) {
		super();
		this.maxPeople = maxPeople;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public int getMaxPeople() {
		return maxPeople;
	}
	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	@Override
	public String toString() {
		return "SearchOptions [maxPeople=" + maxPeople + ", location=" + location + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
}
