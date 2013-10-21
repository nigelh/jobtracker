package nigelhole.workspace.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

//Will map the resource to the URL jobtracker
@Path("/ping")
public class PingService {
	
	public static final String ALIVE = "alive";
  
	 @GET
	 @Produces(MediaType.TEXT_PLAIN)
    public String get(@Context HttpServletRequest request) {
			
	        return ALIVE;
    }
	 
	 

		

    

}
