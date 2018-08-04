package com.counsellor;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.utilities.ResposeResult;

@Path("/counsellors")

public class CounsellorService {

	CounsellorDao counsellor_dao = new CounsellorDao();
	ResposeResult response;

	@POST 
	@Path("/store")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResposeResult createUser(Counsellor counsellor,
			@Context HttpServletResponse servletResponse){
		
		ResposeResult response  = counsellor_dao.store(counsellor);
		return response; 
	}
	
	
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public ResposeResult getCounsellors()
	{
		response  = counsellor_dao.getAllCounsellors();
		return response; 
	}
}
