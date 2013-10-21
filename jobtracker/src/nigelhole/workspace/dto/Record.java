package nigelhole.workspace.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Record {
	
	private Long key = 0L;
	public static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");

	public Record() {
		super();
	}
	public Record(Long key) {
		super();
		this.key = key;
	}

	public Long getKey() {
		return key;
	}
	
	public void setKey(Long key) {
		this.key = key;
	}
	
	
	
	public Record(String value) {
		key = new Long(value);
	}

	@Override
	public String toString() {
		return "Record [key=" + key + "]";
	}
	
	

}
