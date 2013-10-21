package nigelhole.workspace.dto;

public class Location extends Record {
	
	private String latitude;
	private String longitude;
	
	public Location () {
	   super(0L);
	   
	}
	
	public Location(String json) {
		super(0L);
	}
	
	public Location(Long key) {
		super(key);
		// TODO Auto-generated constructor stub
	}
	
	
	public Location(Long key, String latitude, String longitude) {
		super(key);
		this.latitude = latitude;
		this.longitude = longitude;
	}


	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Location [latitude=" + latitude + ", longitude=" + longitude
				+ ", getKey()=" + getKey() + "]";
	}
	

}
