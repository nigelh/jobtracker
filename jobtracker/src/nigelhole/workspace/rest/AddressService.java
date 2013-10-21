package nigelhole.workspace.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import nigelhole.workspace.dto.Address;
import nigelhole.workspace.dto.User;

//Will map the resource to the URL jobtracker
@Path("/address")
public class AddressService extends Service {
  
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Address get(@Context HttpServletRequest request) {

		User user = getLoginUser(request);
		Address reply = new Address(0L);
		if (user != null) {
				reply = databaseService.getAddress(user);
		}
		return reply;

	}

		

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void post(Address address, @Context HttpServletRequest request) {

		User user = getLoginUser(request);	
		if (user != null) {
				databaseService.updateAddress(user, address);
		}
		
	} 
	

}
