package com.appointment;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.availabillity.Availabillity;
import com.google.gson.Gson;
import com.utilities.DBConnection;
import com.utilities.ResposeResult;

public class AppointmentDao {
	Connection con ;
	Gson gson 				= new Gson();
	ResposeResult response  = new ResposeResult(true, null);
	
	
	/** 
	 - store
	 * */
	public ResposeResult store(Appointment appointment){

		try { 
			con 					= DBConnection.connect();
			PreparedStatement stmt 	= con.prepareStatement("insert into appointments (consultant_id, student_id, user_id, day, date, time) values (?,?,?,?,?,?)");
			java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(appointment.getDate());
			//java.sql.Date sqlDate 	= new java.sql.Date(utilDate.getTime());
			
			stmt.setInt		(1, appointment.getConsultant_id());
			stmt.setInt		(2, appointment.getStudent_id());
			stmt.setInt		(3, appointment.getUser_id());
			stmt.setString	(4, appointment.getDay().toString());
			stmt.setDate	(5, new java.sql.Date(utilDate.getTime()));
			stmt.setString	(6, appointment.getTime().toString());

			if (stmt.executeUpdate() > 0) {
				response.setIs_error(false);
			}

			con.close();

		} catch (Exception e) {
			response.setResult(e.getMessage());
		}

		return response;
	}
	
	
	/** 
	 - List them all 
	 * */
	public ResposeResult getAllAppointments() {
		List<Appointment> appointmentList = new ArrayList<Appointment>();
		try {

			con 					= DBConnection.connect();;
			PreparedStatement stmt 	= con.prepareStatement("select * from appointments");     
			ResultSet result 		= stmt.executeQuery();

			while (result.next()) 
			{
				Appointment appointment = new Appointment
						(result.getInt(1), 
								result.getInt(2), 
								result.getInt(3), 
								result.getInt(4), 
								result.getString(5),
								result.getString(6), 
								result.getString(7),
								result.getString(8));
				appointmentList.add(appointment);
			} 

		} catch (Exception e) {
			response.setIs_error(true);
			response.setResult(e.getMessage());
		}

		response.setIs_error(false);
		response.setResult(gson.toJson(appointmentList));
		return response;
	}
}
