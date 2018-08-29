package com.counsellor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.utilities.DBConnection;
import com.utilities.ResposeResult;

public class CounsellorDao {

	Gson gson 				= new GsonBuilder().disableHtmlEscaping().create();
	ResposeResult response  = new ResposeResult(true, null);

	/** 
	 - Store 
	 * */
	public ResposeResult store(Counsellor counsellor){

		try {	

			Connection con 			= DBConnection.connect();
			PreparedStatement stmt 	= con.prepareStatement("insert into consultants (salute, name, contact_no, email, address) values (?,?,?,?,?)");

			stmt.setString(1, counsellor.getSalute().toString());
			stmt.setString(2, counsellor.getName().toString());
			stmt.setString(3, counsellor.getContact_no().toString());
			stmt.setString(4, counsellor.getEmail().toString());
			stmt.setString(5, counsellor.getAddress().toString());

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
	/** 
	 - List them all 
	 * */
	public ResposeResult getAllCounsellors() {

		Vector<String> vector = new Vector<>();
		
		try {
			Connection con 			= DBConnection.connect();
			con 					= DBConnection.connect();;
			PreparedStatement stmt 	= con.prepareStatement(
					"SELECT con.salute, con.name, con.contact_no, sp.country, sp.subject, sp.id as sp_id, av.* " + 
					"FROM specialized sp " + 
					"INNER JOIN consultants con on con.id = sp.`consultant_id` " + 
					"INNER JOIN availabillities av on av.consultant_id = sp.`consultant_id`");     
			ResultSet result 		= stmt.executeQuery();

			while (result.next()) 
			{
				HashMap<String,String> map = new HashMap<>();
				
				map.put("id", result.getString("sp_id"));
				map.put("salute", result.getString("salute"));
				map.put("name", result.getString("name"));
				map.put("country", result.getString("country"));
				map.put("subject", result.getString("subject"));
				map.put("contact", result.getString("contact_no"));
				map.put("sun", result.getString("sun"));
				map.put("mon", result.getString("mon"));
				map.put("tue", result.getString("tue"));
				map.put("wed", result.getString("wed"));
				map.put("thu", result.getString("thu"));
				map.put("fri", result.getString("fri"));
				map.put("sat", result.getString("sat"));
				
				vector.add(gson.toJson(map));
			} 

		} catch (Exception e) {
			response.setIs_error(true);
			response.setResult(e.getMessage());
		}

		response.setIs_error(false);
		response.setResult(gson.toJson(vector));
		return response;
	}
	
	
	/** 
	 - All Counselors To HTML Select Box
	 * */
	public ResposeResult counsellorsAsOption() {
		
		String option				= "<option selected disabled> Please Select </option>";
		try {

			Connection con 			= DBConnection.connect();
			PreparedStatement stmt 	= con.prepareStatement("select * from consultants");     
			ResultSet result 		= stmt.executeQuery();

			while (result.next()) {
				option =  option+" <option value='"+String.valueOf(result.getInt(1))+"'> "+result.getString(3)+" </option> "; 
			} 

		} catch (Exception e) {
			response.setIs_error(true);
			response.setResult(e.getMessage()); 
		}

		response.setIs_error(false);
		response.setResult(gson.toJson(option));
		return response;
	}
}
