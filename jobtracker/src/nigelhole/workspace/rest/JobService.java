package nigelhole.workspace.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
@Path("/job")
public class JobService extends Service {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Job> get(@QueryParam("job") String job,
			@QueryParam("status") String status,
			@Context HttpServletRequest request) {

		
		User user = getLoginUser(request);
		List<Job> reply = new ArrayList<Job>(0);

		if (user != null) {
			if (status != null) {
				reply = databaseService
						.getJobs(user, JobStatus.valueOf(status));

			} else if (job != null) {
				reply.add(databaseService.getJob(Long.valueOf(job)));
			} else {
				reply = databaseService.getJobs(user);
			}

		}
		return reply;

	}
		

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(Job job ,@Context  HttpServletRequest request ) 
    {

		HttpSession session = request.getSession();
		if (session != null) {
			User user = (User) session.getAttribute(LoginService.USER);

			if (user != null) {
				databaseService.updateJob(job);

			}
		}
       
	}

}
