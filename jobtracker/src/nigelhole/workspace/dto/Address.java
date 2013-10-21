package nigelhole.workspace.dto;



public class Address extends Record {
	private String address_line1;
	private String address_line2;
	private String address_line3;
	private String address_town;
	private String address_county;
	private String address_code;
	
	public Address() {
		super(0L);
	}
	
	public Address(Long key) {
		super(key);
		
	}
	
	public Address(String json) {
		super(0L);
		
		
	}
	
	public String getAddress_line1() {
		return address_line1;
	}
	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}
	public String getAddress_line2() {
		return address_line2;
	}
	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}
	public String getAddress_line3() {
		return address_line3;
	}
	public void setAddress_line3(String address_line3) {
		this.address_line3 = address_line3;
	}
	public String getAddress_town() {
		return address_town;
	}
	public void setAddress_town(String address_town) {
		this.address_town = address_town;
	}
	public String getAddress_county() {
		return address_county;
	}
	public void setAddress_county(String address_county) {
		this.address_county = address_county;
	}
	public String getAddress_code() {
		return address_code;
	}
	public void setAddress_code(String address_code) {
		this.address_code = address_code;
	}
	
	
}
