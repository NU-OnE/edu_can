package com.token;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import com.user.User;
import com.utilities.ResposeResult;

@Path("/tokens")
public class TokenService {
	TokenDao token_dao = new TokenDao();
	ResposeResult response;

	@POST
	@Path("/new")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResposeResult getNewToken(User user, @Context HttpServletResponse servletResponse) {

		return token_dao.newToken(user);
	}

	@POST
	@Path("/validate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResposeResult validateToken(Token token, @Context HttpServletResponse servletResponse) {

		return token_dao.validate(token);
	}
}
