package nigelhole.workspace.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import nigelhole.workspace.dto.JobSummary;
import nigelhole.workspace.dto.User;

//Will map the resource to the URL jobtracker
@Path("/jobsummary")
public class JobSummaryService extends Service {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JobSummary get(@Context  HttpServletRequest request ) 
    {


		JobSummary reply = new JobSummary();

			User user = getLoginUser(request);
			if( user != null )
			{
				reply = databaseService.getJobSummary(user);		
			}
		
        return reply;
	}

}
