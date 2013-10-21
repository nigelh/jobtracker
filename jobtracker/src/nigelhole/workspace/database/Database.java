package nigelhole.workspace.database;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import nigelhole.workspace.dto.Address;
import nigelhole.workspace.dto.ContactDetails;
import nigelhole.workspace.dto.Job;
import nigelhole.workspace.dto.JobStatus;
import nigelhole.workspace.dto.JobSummary;
import nigelhole.workspace.dto.Location;
import nigelhole.workspace.dto.Note;
import nigelhole.workspace.dto.Record;
import nigelhole.workspace.dto.User;

/* A dummy database */

public class Database implements DatabaseService {
	
	static Database database;
	
	private Map <Long,User> users = new HashMap<Long,User>();
	private Map <Long,ContactDetails> contacts = new HashMap<Long,ContactDetails>();
	private Map <Long,Address> addresses = new HashMap<Long,Address>();
	private Map <Long,Job> jobs = new HashMap<Long,Job>();
	private Map <Long,Note > notes = new HashMap<Long,Note>();
	
	private Database() throws ParseException{
		
		
		ContactDetails details = new ContactDetails(100L);
		
		Address address = new Address(100L);
		address.setAddress_line1("360, Moston Lane");
		address.setAddress_line2("Moston");
		address.setAddress_line3("");
		address.setAddress_town("Manchester");
		address.setAddress_county("Lancshire");
		address.setAddress_code("M40 9JJ");
		addresses.put(address.getKey(), address);
		
		details.setUser_name("Nigel Hole");
		details.setHome_number("0161 428 6850");
		details.setEmail_address("nigelh@hotmail.com");
		details.setWork_number("07765343099");
		details.setImage("images/nigelhole.jpg");
	
		
		User user = new User(100L,"nigelh","password",false,details.getKey(),address.getKey());
		users.put(user.getKey(),user);
		contacts.put(details.getKey(), details);
		
		details = new ContactDetails(200L);
		address = new Address(200L);
		
		address.setAddress_line1("382,Kingsway");
		address.setAddress_line2("Burnage");
		address.setAddress_line3("");
		address.setAddress_town("Manchester");
		address.setAddress_county("Lancshire");
		address.setAddress_code("M19 1PL");
		addresses.put(address.getKey(), address);
		
		details.setUser_name("John Jones");
		details.setHome_number("0161 428 6850");
		details.setEmail_address("johnj@hotmail.com");
		details.setWork_number("07765343099");
		details.setImage("images/johnjones.jpg");

		
		user = new User(200L,"johnj","password",false,details.getKey(),address.getKey());
		users.put(user.getKey(),user);
		contacts.put(details.getKey(), details);
		
		details = new ContactDetails(300L);
		address = new Address(300L);
		addresses.put(address.getKey(), address);
		
		address.setAddress_line1("268,Trafford Road");
		address.setAddress_line2("Ecceles");
		address.setAddress_line3("");
		address.setAddress_town("Manchester");
		address.setAddress_county("Lancshire");
		address.setAddress_code("M20 0JJ");
		
		details.setUser_name("Mary Williams");
		details.setHome_number("0161 428 6850");
		details.setEmail_address("maryw@hotmail.com");
		details.setWork_number("07765343099");
		details.setImage("images/marywilliams.jpg");
	
		
		user = new User(300L,"maryw","password",false,details.getKey(),address.getKey());
		users.put(user.getKey(),user);
		contacts.put(details.getKey(), details);
		
		details = new ContactDetails(400L);
		address = new Address(400L);
		addresses.put(address.getKey(), address);
		address.setAddress_line1("39,Dewsbury Road");
		address.setAddress_line2("Cheackeaton");
		address.setAddress_line3("");
		address.setAddress_town("");
		address.setAddress_county("Yorkshire");
		address.setAddress_code("BD19 5BT");
		
		details.setUser_name("David Evens");
	
		details.setHome_number("0161 438 6851");
		details.setEmail_address("davide@hotmail.com");
		details.setWork_number("07765343088");
		details.setImage("images/davidevens.jpg");

		
		user = new User(400L,"davide","password",false,details.getKey(),address.getKey());
		users.put(user.getKey(),user);
		contacts.put(details.getKey(), details);
		
		//Location location = new Location(100L,"53.815247","-3.048363");
		
		
		
		address = new Address(1000L);
		address.setAddress_line1("130 Cornishway   ");
		address.setAddress_line2("Wood House Park");
		address.setAddress_line3("");
		address.setAddress_town("Manchester");
		address.setAddress_county("Lancshire");
		address.setAddress_code("M22 0WY");
		addresses.put(address.getKey(),address);
		
		Job job = new Job(100L);
		job.setTitle("Indigo Repair");
		job.setStartDate("01/01/2013 12:00");
		job.setDescription("Washing machine is reported not spinning and is under repair warranty. Suspected motor replacement.");
		job.setStatus(JobStatus.ASSIGNED);
		job.setCustomerName("Mrs Jane Dickison");
		job.setLocation(new Location(100L,"53.5137565","-2.1945615"));
		job.setAddressKey(address.getKey());
		job.setUserKey(100L);
		job.setContactNumber("0161 8290 87");
		jobs.put(job.getKey(),job);
		
		Note note = new Note(100L);
		note.setEntryTime(Record.dateFormat.format(new Date()));
		note.setText("New spare part required. Have ordered part with warehouse.");
		note.setJobKey(job.getKey());
		notes.put(note.getKey(), note);
		
		address = new Address(2000L);
		address.setAddress_line1("424, Barton Rd");
		address.setAddress_line2("Stretford");
		address.setAddress_line3("");
		address.setAddress_town("Stretford");
		address.setAddress_county("Lancshire");
		address.setAddress_code("M32 9RW");
		addresses.put(address.getKey(),address);
		
		job = new Job(200L);
		job.setTitle("Spinner Repair");
		job.setStartDate("02/01/2013 12:00");
		job.setDescription("Hotpoint spinner (Model G16) not working and is under repair warranty. Suspected motor replacement.");
		job.setStatus(JobStatus.ASSIGNED);
		job.setCustomerName("Mr John Jones");
		job.setLocation(new Location(200L,"53.4421816","-2.3127463"));
		job.setAddressKey(address.getKey());
		job.setUserKey(100L);
		job.setContactNumber("0161 1827 70");
		jobs.put(job.getKey(),job);
		
		note = new Note(200L);
		note.setEntryTime(Record.dateFormat.format(new Date()));
		note.setText("Could not gain entry to premises - phone customer with no reply");
		note.setJobKey(job.getKey());
		notes.put(note.getKey(), note);
		
		address = new Address(3000L);
		address.setAddress_line1("Connect House");
		address.setAddress_line2("Talbot Way");
		address.setAddress_line3("");
		address.setAddress_town("Birmingham");
		address.setAddress_county("West Midlands");
		address.setAddress_code("B10 0HJ");
		addresses.put(address.getKey(),address);
		
		job = new Job(300L);
		job.setTitle("Oven Repair");
		job.setStartDate("01/04/2013 12:00");
		job.setDescription("Oven (make and model unknown) not working and is not under warranty. To investigate cause and possible repair else replacement");
		job.setStatus(JobStatus.ASSIGNED);
		job.setCustomerName("Mrs N Williams");
		job.setLocation(new Location(300L,"52.4637417","-1.844148"));
		job.setAddressKey(address.getKey());
		job.setUserKey(100L);
		job.setContactNumber("0161 8257 3986");
		jobs.put(job.getKey(),job);
		
		note = new Note(300L);
		note.setEntryTime(Record.dateFormat.format(new Date()));
		note.setText("Customer has requested a new replacement under the terms of his warranty");
		note.setJobKey(job.getKey());
		notes.put(note.getKey(), note);
		
		address = new Address(4000L);
		address.setAddress_line1("594/596 Blackburn Road");
		address.setAddress_line2("Bolton");
		address.setAddress_line3("");
		address.setAddress_town("Bolton");
		address.setAddress_county("Lancashire");
		address.setAddress_code("BL1 7AL");
		addresses.put(address.getKey(),address);
		
		job = new Job(400L);
		job.setTitle("Vacuum Repair");
		job.setStartDate("07/15/2013 13:40");
		job.setDescription("Vaccuum cleaner requires a roller and motor replacement replacement parts are in the warehouse to collect.");
		job.setStatus(JobStatus.ASSIGNED);
		job.setCustomerName("Mrs K Kays");
		job.setLocation(new Location(500L,"53.6184856","-2.4378053"));
		job.setAddressKey(address.getKey());
		job.setUserKey(100L);
		job.setContactNumber("01678 9275");
		jobs.put(job.getKey(),job);
		
		note = new Note(400L);
		note.setEntryTime(Record.dateFormat.format(new Date()));
		note.setText("Have completed job but the customer is not present for signing off. Will call back later");
		note.setJobKey(job.getKey());
		notes.put(note.getKey(), note);
		
		address = new Address(4000L);
		address.setAddress_line1("Morley Way");
		address.setAddress_line2("Peterborough");
		address.setAddress_line3("");
		address.setAddress_town("Peterborough");
		address.setAddress_county("Cambridgeshire");
		address.setAddress_code("PE2 9JB");
		addresses.put(address.getKey(),address);
		
		job = new Job(500L);
		job.setTitle("Oven Repair");
		job.setStartDate("09/07/2013 12:19");
		job.setDescription("Oven electric ring is not working and needs replacement. Parts have been order and are in the warehouse for collection.");
		job.setStatus(JobStatus.ASSIGNED);
		job.setCustomerName("Mrs K Bates");
		job.setLocation(new Location(600L,"52.5545243","-0.2608745"));
		job.setAddressKey(address.getKey());
		job.setUserKey(100L);
		job.setContactNumber("0161 62398 02");
		jobs.put(job.getKey(),job);
		
		note = new Note(500L);
		note.setEntryTime(Record.dateFormat.format(new Date()));
		note.setText("Could not gain access to machine due to the customer locking the garage. Cannot find the key.");
		note.setJobKey(job.getKey());
		notes.put(note.getKey(), note);
		
		address = new Address(5000L);
		address.setAddress_line1("Abbey Hey Domestics");
		address.setAddress_line2("541 Abbey Hey Lane");
		address.setAddress_line3("");
		address.setAddress_town("Manchester");
		address.setAddress_county("Lancshire");
		address.setAddress_code("M18 8PF");
		addresses.put(address.getKey(),address);
		
		job = new Job(600L);
		job.setTitle("Fridge Repair");
		job.setStartDate("10/03/2013 14:00");
		job.setDescription("Ingist fridge freezer (Make Ingest,Model G67,) Bulb replacement. Will be in afternoon after 12 pm.");
		job.setStatus(JobStatus.ASSIGNED);
		job.setCustomerName("Mrs N Jones");
		job.setLocation(new Location(700L,"53.4641387","-2.1653917"));
		job.setAddressKey(address.getKey());
		job.setUserKey(100L);
		job.setContactNumber("0161 564 786");
		jobs.put(job.getKey(),job);
		
		note = new Note(600L);
		note.setEntryTime(Record.dateFormat.format(new Date()));
		note.setText("Could not gain entry to premises - phone customer with no reply");
		note.setJobKey(job.getKey());
		notes.put(note.getKey(), note);
		
	};
	
	public static Database instance() {
		
			if( database == null )
			{
				try {
				database = new Database();
				} catch (ParseException e)
				{
					System.out.println(e.toString());
				}
			}
			return database;
	}
	
	public ContactDetails getContactDetails(User user)
	{
		return contacts.get(user.getContactKey());
	}
	
	public ContactDetails updateContactDetails(User user,ContactDetails details){
	
			contacts.put(user.getContactKey(), details);
			return contacts.get(user.getContactKey());
	
	}
	
	public User getUser(String username) {
		Iterator < Entry<Long,User>> it = users.entrySet().iterator();
	    while (it.hasNext()) {
	        Entry<Long,User> row = it.next();
	        User user = row.getValue();
	        if( user.getUserName().equals(username) )
	        	return user;
	    }
		return null;
	}

	public User login(String username, String password) {
		Iterator < Entry<Long,User>> it = users.entrySet().iterator();
	    while (it.hasNext()) {
	        Entry<Long,User> row = it.next();
	        User user = row.getValue();
	        if( user.getUserName().equals(username) && user.getPassword().equals(password) )
	        	user.setLoggedin(true);
	        	return user;

	    }
		
		return null;
	}

	public void logout(User user) {
		
		 user.setLoggedin(false);
	
		
	}
	
	public List<ContactDetails> getWorkContacts(User user) {
		List<ContactDetails> reply = new ArrayList<ContactDetails>(users.size());
		Long key = null;
	    User row = null;
		for( Iterator<Long> i = users.keySet().iterator(); i.hasNext(); )
		{
			  key =  i.next();
			  row = users.get(key);
			  if( user.getKey() != row.getKey() )
			  {
			     reply.add(contacts.get(row.getContactKey()));
			
			  }
		}
		return reply;
	}

	public Address getAddress(User user) {
		
		return addresses.get(user.getAddressKey());
	}

	public Address updateAddress(User user,Address address) {
		
		addresses.put(user.getAddressKey(),address);
		return addresses.get(user.getAddressKey());
	}

	public List<Job> getJobs(User user, JobStatus status) {
		List<Job> reply = new ArrayList<Job>(jobs.size());
	    Job row = null;
		for( Iterator<Job> i = jobs.values().iterator(); i.hasNext(); )
		{
			  row =  i.next();
			  if( user.getKey() == row.getUserKey() && status == row.getStatus() )
			  {
				 row.setAddress(getAddress(row.getAddressKey())); 
			     reply.add(jobs.get(row.getKey()));
			  }
		}
		return reply;
	}

	public List<Job> getJobs(User user) {
		List<Job> reply = new ArrayList<Job>(jobs.size());
	    Job row = null;
		for( Iterator<Job> i = jobs.values().iterator(); i.hasNext(); )
		{
			  row =  i.next();
			  if( user.getKey() == row.getUserKey()  )
			  {
				 row.setAddress(getAddress(row.getAddressKey())); 
			     reply.add(jobs.get(row.getKey()));	
			  }
		}
		return reply;
	}

	public Job updateJob(Job job) {
		jobs.put(job.getKey(), job);
		if( job.getAddress() != null )
		{
			updateAddress(job.getAddressKey(),job.getAddress());
		}
		return jobs.get(job.getKey());
	}

	public JobSummary getJobSummary(User user) {
		JobSummary reply = new JobSummary();
		Job job = null;
		JobStatus status = null;
		Iterator<Entry<Long,Job>> it = jobs.entrySet().iterator();
	    while (it.hasNext()) {
	        job = it.next().getValue();
	        status = job.getStatus();
	        if( job.getUserKey() == user.getKey() )
	        {
	        	if( status == JobStatus.ASSIGNED )
	        		reply.setAssigned(reply.getAssigned()+1);
	        	else if ( status == JobStatus.STARTED )
	        	    reply.setStarted(reply.getStarted()+1);
	        	else if (status == JobStatus.COMPLETED )
	        		reply.setCompleted(reply.getCompleted()+1);
	        }
	    }
		return reply;
	}

	public Address getAddress(Long key) {
		
		return addresses.get(key);
	}
	
    public Address updateAddress(Long key,Address address) {
		
    	addresses.put(key,address);
		return addresses.get(key);
	}

	public List<Note> getNotes(Job job) {
		Iterator<Entry<Long,Note>> it = notes.entrySet().iterator();
	    Note note = null;
	    List<Note> reply = new ArrayList<Note>(2);
	    while (it.hasNext()) {
	        note = it.next().getValue();
	        if( note.getJobKey() == job.getKey() )
	        	reply.add(note);
	    }
		return reply;
	}

	public List <Note> addNote(Job job,String text) {
		Note note = new Note((long) ((notes.size()+1)*100));
		note.setJobKey(job.getKey());
		note.setText(text);
		note.setEntryTime(Record.dateFormat.format(new Date()));
		notes.put(note.getKey(),note);
		return getNotes(job);
	}

	public Job getJob(Long key) {
		
		return jobs.get(key);
	}

	
}
