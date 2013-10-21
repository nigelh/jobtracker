package nigelhole.workspace.rest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.DELETE;
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
@Path("/login")
public class LoginService extends Service {
	
	
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
    public ContactDetails get(@Context HttpServletRequest request) {
			
            ContactDetails reply = new ContactDetails(0L);
            User user = getLoginUser(request);
			if( user != null )
			{
				reply = databaseService.getContactDetails(user);
			} 
	        return reply;
    }
	
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
    public ContactDetails post(@QueryParam("username") String username,@QueryParam("password") String password,@Context  HttpServletRequest request,@Context HttpServletResponse response ) 
    		throws IOException,ServletException {

			User user = databaseService.login(username,password);
			ContactDetails reply = new ContactDetails(0L);
			if( user != null )
			{
				HttpSession session = request.getSession(true);
				session.setAttribute(USER, user);
				reply = databaseService.getContactDetails(user);

			} 
			
           return reply;
		}

		 
    @DELETE
     public void delete(@Context  HttpServletRequest request ) 
    		 throws IOException,ServletException {
	
	    HttpSession session = request.getSession();
		if( session != null ) {
			session.invalidate();
			session = null;
		}
		request.logout();
	}

}
