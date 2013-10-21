package nigelhole.workspace.dto;

import java.text.ParseException;
import java.util.Date;

public class Job extends Record {
	
	private String title;
	private String customerName;
	private Long addressKey;
	private Location location;
	private String description;
	private JobStatus status;
	private String signature;
	private Long userKey;
	private Date startDate;
	private Date completedDate;
	private String contactNumber;
	private Address address;
	
	public Job(Long key) {
		super(key);
		
	}
	
	public Job() {
		super(0L);
		
	}

	public String getTitle() {
		return title;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getAddressKey() {
		return addressKey;
	}

	public void setAddressKey(Long addressKey) {
		this.addressKey = addressKey;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public JobStatus getStatus() {
		return status;
	}

	public void setStatus(JobStatus status) {
		this.status = status;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Long getUserKey() {
		return userKey;
	}

	public void setUserKey(Long userKey) {
		this.userKey = userKey;
	}

	public String getStartDate() {
		if( startDate != null )
		  return dateFormat.format(startDate);
		else
		  return null;	
	}

	
	public void setStartDate(String start_date) throws ParseException {
		if( start_date != null ) {
		   this.startDate = dateFormat.parse(start_date);
		} else 
			start_date = null;
	}

	public String getCompletedDate() {
		if( completedDate != null )
		 return dateFormat.format(completedDate);
		else 
		 return null;
		
	}

	

	public void setCompletedDate(String completed_date) throws ParseException {
		if( completed_date != null ) {
		  this.completedDate = dateFormat.parse(completed_date);
		} else {
			completed_date = null;
		}
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	

	@Override
	public String toString() {
		return "Job [title=" + title + ", customerName=" + customerName
				+ ", addressKey=" + addressKey + ", location=" + location
				+ ", description=" + description + ", status=" + status
				+ ", signature=" + signature + ", userKey=" + userKey
				+ ", startDate=" + startDate + ", completedDate="
				+ completedDate + ", contactNumber=" + contactNumber
				+ ", address=" + address + "]";
	}
	
	
	
	

}
