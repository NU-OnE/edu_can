package com.specialized;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import com.utilities.ResposeResult;
@Path("/specialities")

public class SpecializedService {

	SpecializedDao specialized_dao = new SpecializedDao();
	ResposeResult response;

	@POST 
	@Path("/store")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResposeResult createSpeciality(Specialized specialized,
			@Context HttpServletResponse servletResponse){
		
		ResposeResult response  = specialized_dao.store(specialized);
		return response; 
	}
	
	
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public ResposeResult getSpecialities()
	{
		response  = specialized_dao.getAllSpecialities();
		return response; 
	}
}
