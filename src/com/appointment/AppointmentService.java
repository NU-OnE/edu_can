package com.appointment;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import com.utilities.ResposeResult;
@Path("/appointments")

public class AppointmentService {
	AppointmentDao appointment_dao = new AppointmentDao();
	ResposeResult response;

	@POST 
	@Path("/store")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResposeResult createAvailabillity(Appointment appointment,
			@Context HttpServletResponse servletResponse){
		
		ResposeResult response  = appointment_dao.store(appointment);
		//response = new ResposeResult(true, "sdfsf");
		return response; 
	}
	
	
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public ResposeResult getAvailabillities()
	{
		response  = appointment_dao.getAllAppointments();
		return response; 
	}
}
