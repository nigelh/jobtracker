package nigelhole.workspace.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import nigelhole.workspace.database.Database;
import nigelhole.workspace.database.DatabaseService;
import nigelhole.workspace.dto.User;

public abstract class Service {
	
	protected DatabaseService databaseService = Database.instance();
	protected static final String USER = "USER";
	public static final String FAILURE = "failure";
	public static final String SUCCESS = "success";
	
	

	protected User getLoginUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(USER);
		if( user != null ) {
			return user;
		} else {
			return null;
		}
	}
}
