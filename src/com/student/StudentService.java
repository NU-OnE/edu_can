package com.student;

import com.utilities.ResposeResult;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/students")

public class StudentService {

	StudentDao student_dao = new StudentDao();
	ResposeResult response;

	@POST
	@Path("/store")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResposeResult createUser(Student student,
			@Context HttpServletResponse servletResponse){
		
		ResposeResult response  = student_dao.addStudent(student);
		return response;
	}
	
	
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public ResposeResult getstudents()
	{
		response  = student_dao.getAllStudents();
		return response; 
	}
}
