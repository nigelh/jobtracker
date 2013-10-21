package nigelhole.workspace.dto;

public class ContactDetails extends Record {
	
	
	private String user_name;
	private String home_number;
	private String work_number;
	private String email_address;
	private String image;
	
	
	public ContactDetails() {
		super(0L);
	}
	
	public ContactDetails(Long key) {
		super(key);
		
	}
	
	

	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	public String getHome_number() {
		return home_number;
	}
	public void setHome_number(String home_number) {
		this.home_number = home_number;
	}
	public String getWork_number() {
		return work_number;
	}
	public void setWork_number(String work_number) {
		this.work_number = work_number;
	}
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
	
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "ContactDetails [user_name=" + user_name + ", home_number="
				+ home_number + ", work_number=" + work_number
				+ ", email_address=" + email_address + ", image=" + image
				+ ", getKey()=" + getKey() + "]";
	}
	
	
	

}
