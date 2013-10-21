package nigelhole.workspace.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import nigelhole.workspace.dto.ContactDetails;
import nigelhole.workspace.dto.User;

//Will map the resource to the URL jobtracker
@Path("/contactdetails")
public class ContactDetailsService extends Service {
	 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ContactDetails> get(
			@QueryParam("workcontacts") String workcontacts,
			@Context HttpServletRequest request) {

		User user = getLoginUser(request);
		List<ContactDetails> reply = new ArrayList<ContactDetails>(0);
		if (user != null) {
			if (workcontacts != null) {
				reply = databaseService.getWorkContacts(user);
			} else {
				reply.add(databaseService.getContactDetails(user));
			}
		}

		return reply;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void post(ContactDetails details, @Context HttpServletRequest request) {

			User user = getLoginUser(request);
			if (user != null) {
				databaseService.updateContactDetails(user, details);
			}
		
       
	}

}
