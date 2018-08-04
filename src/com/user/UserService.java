package com.user;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import com.utilities.ResposeResult;


@Path("/users")
public class UserService {

	UserDao user_dao = new UserDao();
	ResposeResult response  = new ResposeResult(true, null);

	@POST
	@Path("/store")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResposeResult createUser(User user,
			@Context HttpServletResponse servletResponse){

		response  = user_dao.store(user);
		return response;
	}


	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public ResposeResult getUsers()
	{
		response  = user_dao.getAllUsers();
		return response; 
	}
}
