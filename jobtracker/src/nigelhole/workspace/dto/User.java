package nigelhole.workspace.dto;

public class User extends Record {
	
	private String userName;
	private String password;
	private Long contactKey;
	private Boolean loggedin;
	private Long addressKey;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getLoggedin() {
		return loggedin;
	}
	public void setLoggedin(Boolean loggedin) {
		this.loggedin = loggedin;
	}
	
	public void setContactKey(Long contactKey) {
		this.contactKey = contactKey;
	}
	public Long getContactKey() {
		return contactKey;
	}
	
	public Long getAddressKey() {
		return addressKey;
	}

	public void setAddressKey(Long key) {
		this.addressKey = key;
	}
	
	public void setAddressKey(String key)
	{
		this.addressKey = new Long(key);
	}
	
	public User(Long key,String userName, String password, Boolean loggedin,
			Long contactKey,Long addressKey) {
		super(key);
		this.userName = userName;
		this.password = password;
		this.loggedin = loggedin;
		this.contactKey = contactKey;
		this.addressKey = addressKey;
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password
				+ ", contactKey=" + contactKey + ", loggedin=" + loggedin
				+ ", getKey()=" + getKey() + "]";
	}
	
	

}
