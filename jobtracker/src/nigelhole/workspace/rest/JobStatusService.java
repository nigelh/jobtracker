package nigelhole.workspace.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import nigelhole.workspace.dto.Job;
import nigelhole.workspace.dto.JobStatus;
import nigelhole.workspace.dto.User;

//Will map the resource to the URL jobtracker
@Path("/jobstatus")
public class JobStatusService extends Service {

    private static final String FAILURE = "failure";
    private static final String SUCCESS = "success";

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String post(@QueryParam("job") String job,@QueryParam("state") String state,@Context  HttpServletRequest request ) 
    {

		User user = getLoginUser(request);

        String reply = FAILURE;
		if( user != null && job != null && state != null)
		{
              Job j = databaseService.getJob(Long.valueOf(job));
              if( j != null ) {
                 j.setStatus(JobStatus.valueOf(state));
                 databaseService.updateJob(j);
                 reply = SUCCESS;
              }
		}
        return reply;
       
	}

}
