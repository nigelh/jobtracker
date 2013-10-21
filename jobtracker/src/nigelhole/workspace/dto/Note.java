package nigelhole.workspace.dto;

import java.text.ParseException;
import java.util.Date;

public class Note extends Record {
	private String text;
	private Date entryTime;
    private Long jobKey;
	
	public Note() {
		super(0L);
	}
	
	public Note(Long key) {
		super(key);
		
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getEntryTime() {
		return dateFormat.format(entryTime);
	}

	public void setEntryTime(String entryTime) {
		try {
		 this.entryTime = dateFormat.parse(entryTime);
		} catch (ParseException e)
		{
			this.entryTime = new Date();
		}
	}

	public Long getJobKey() {
		return jobKey;
	}

	public void setJobKey(Long jobKey) {
		this.jobKey = jobKey;
	}

	@Override
	public String toString() {
		return "Note [text=" + text + ", entryTime=" + entryTime + ", jobKey="
				+ jobKey + ", getKey()=" + getKey() + "]";
	}
	
	
	
	
}
