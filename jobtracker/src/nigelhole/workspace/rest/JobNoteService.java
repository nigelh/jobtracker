package nigelhole.workspace.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import nigelhole.workspace.dto.Job;
import nigelhole.workspace.dto.Note;
import nigelhole.workspace.dto.User;

//Will map the resource to the URL jobtracker
@Path("/jobnotes")
public class JobNoteService extends Service {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Note> get(@QueryParam("job") String job,
			@Context HttpServletRequest request) {

		List<Note> reply = new ArrayList<Note>(0);
		User user = getLoginUser(request);
       
		if (job != null && user != null) {
			Job j = databaseService.getJob(Long.valueOf(job));
			reply = databaseService.getNotes(j);

		}
		return reply;

	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String post(@FormParam("job") String job,
			@FormParam("text") String text, @Context HttpServletRequest request) {
			User user = getLoginUser(request);
            String reply = FAILURE;
			if (user != null && text != null && job != null) {
				Job j = databaseService.getJob(Long.valueOf(job));
				databaseService.addNote(j, text);
                reply = SUCCESS;
			}
		    return reply;
            
	}

}
