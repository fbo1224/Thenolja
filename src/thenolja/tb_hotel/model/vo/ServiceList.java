package thenolja.tb_hotel.model.vo;

// 호텔 서비스 담는 vo
public class ServiceList {
	private int serviceNo;
	private String serviceName;
	
	public ServiceList() {
		super();
	}

	public ServiceList(int serviceNo, String serviceName) {
		super();
		this.serviceNo = serviceNo;
		this.serviceName = serviceName;
	}

	public int getServiceNo() {
		return serviceNo;
	}

	public void setServiceNo(int serviceNo) {
		this.serviceNo = serviceNo;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Override
	public String toString() {
		return "ServiceList [serviceNo=" + serviceNo + ", serviceName=" + serviceName + "]";
	}
	
	
}
