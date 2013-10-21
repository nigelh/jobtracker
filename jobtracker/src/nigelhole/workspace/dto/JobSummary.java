package nigelhole.workspace.dto;

public class JobSummary {
	
	private Integer assigned=0;
	private Integer started=0;
	private Integer completed=0;
	
	
	
	public JobSummary() {
		
	}

	public Integer getAssigned() {
		return assigned;
	}

	public void setAssigned(Integer assigned) {
		this.assigned = assigned;
	}

	public Integer getStarted() {
		return started;
	}

	public void setStarted(Integer started) {
		this.started = started;
	}

	public Integer getCompleted() {
		return completed;
	}

	public void setCompleted(Integer completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "JobSummary [assigned=" + assigned + ", started=" + started
				+ ", completed=" + completed + "]";
	}
	
}
