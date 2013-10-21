package nigelhole.workspace.database;

import java.util.List;

import nigelhole.workspace.dto.Address;
import nigelhole.workspace.dto.ContactDetails;
import nigelhole.workspace.dto.Job;
import nigelhole.workspace.dto.JobStatus;
import nigelhole.workspace.dto.JobSummary;
import nigelhole.workspace.dto.Note;
import nigelhole.workspace.dto.User;

// Defines the database service
public interface DatabaseService {

	public ContactDetails getContactDetails(User user);
	
	public ContactDetails updateContactDetails(User user,ContactDetails details);
	
	public User login(String username,String password);
	
	public void logout(User user);
	
	public List<ContactDetails> getWorkContacts(User user);
	
	public Address getAddress(User user);
	
	public Address updateAddress(User user,Address address);
	
	public List<Job> getJobs(User user,JobStatus status);
	
	public List<Job> getJobs(User user);
	
	public Job getJob(Long key);
	
	public Job updateJob(Job job);
	
	public JobSummary getJobSummary(User user);
	
	public Address getAddress(Long key);
	
	public List<Note> getNotes(Job job);
	
	public List<Note> addNote(Job job,String text);
	
	public User getUser(String username);
	
}
