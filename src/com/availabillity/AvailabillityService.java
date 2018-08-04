package com.availabillity;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import com.utilities.ResposeResult;

@Path("/availabillities")
public class AvailabillityService {

	AvailabillityDao availabillity_dao = new AvailabillityDao();
	ResposeResult response;

	@POST 
	@Path("/store")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResposeResult createUser(Availabillity availabillity,
			@Context HttpServletResponse servletResponse){
		
		ResposeResult response  = availabillity_dao.store(availabillity);
		return response; 
	}
	
	
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public ResposeResult getCounsellors()
	{
		response  = availabillity_dao.getAllAvilabillities();
		return response; 
	}
}
