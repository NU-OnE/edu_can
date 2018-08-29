package com.appointment;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

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
		Vector v = new Vector<>();
		try {

			con 					= DBConnection.connect();;
			PreparedStatement stmt 	= con.prepareStatement(
					"select cons.salute, cons.name, ap.day, ap.date, ap.time, ap.created_at, spe.country, spe.subject " + 
					"from appointments ap " + 
					"INNER JOIN students st ON st.id = ap.student_id " + 
					"INNER JOIN consultants cons ON cons.id = ap.consultant_id "+
					"INNER JOIN specialized spe ON spe.consultant_id = ap.consultant_id ");    
			ResultSet result 		= stmt.executeQuery();

			while (result.next()) 
			{
				HashMap<String,String> hm = new HashMap<String,String>();  
				  hm.put("salute",result.getString(1));  
				  hm.put("consultant",result.getString(2));  
				  hm.put("day",result.getString(3));  
				  hm.put("date",result.getString(4));
				  hm.put("time",result.getString(5));  
				  hm.put("country",result.getString("country")); 
				  hm.put("subject",result.getString("subject")); 
				  
				  v.add(gson.toJson(hm));
			} 

		} catch (Exception e) {
			response.setIs_error(true);
			response.setResult(e.getMessage());
		}

		response.setIs_error(false);
		response.setResult(v.toString());
		return response;
	}
	
	
	/** 
	 - List Specific user appointment
	 * */
	public ResposeResult getUserAppointment(Integer user_id) {
		ResultSet result = null;
		Vector v = new Vector<>();
		
		try {

			con 					= DBConnection.connect();;
			PreparedStatement stmt 	= con.prepareStatement(
					"select cons.salute, cons.name, ap.day, ap.date, ap.time, ap.created_at, spe.country, spe.subject " + 
					"from appointments ap " + 
					"INNER JOIN students st ON st.id = ap.student_id " + 
					"INNER JOIN consultants cons ON cons.id = ap.consultant_id "+
					"INNER JOIN specialized spe ON spe.consultant_id = ap.consultant_id "+
					"where ap.user_id = "+user_id);     
			result 		= stmt.executeQuery();

			while (result.next()) 
			{
				 HashMap<String,String> hm = new HashMap<String,String>();  
				  hm.put("salute",result.getString(1));  
				  hm.put("consultant",result.getString(2));  
				  hm.put("day",result.getString(3));  
				  hm.put("date",result.getString(4));
				  hm.put("time",result.getString(5));  
				  hm.put("country",result.getString("country")); 
				  hm.put("subject",result.getString("subject")); 
				  
				  v.add(gson.toJson(hm));
			} 

		} catch (Exception e) {
			response.setIs_error(true);
			response.setResult(e.getMessage());
		}

		response.setIs_error(false);
		response.setResult(v.toString());
		return response;
	}
}
