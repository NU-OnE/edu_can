package com.specialized;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import java.util.Vector;

import com.google.gson.Gson;
import com.utilities.DBConnection;
import com.utilities.ResposeResult;

public class SpecializedDao {

	Connection con ;
	Gson gson 				= new Gson();
	ResposeResult response  = new ResposeResult(true, null);


	/** 
	 - store
	 * */
	public ResposeResult store(Specialized specialized){

		try { 
			con 					= DBConnection.connect();
			PreparedStatement stmt 	= con.prepareStatement("insert into specialized (consultant_id, country, subject) values (?,?,?)");

			stmt.setInt(1, specialized.getConsultant_id());
			stmt.setString(2, specialized.getCountry().toString());
			stmt.setString(3, specialized.getSubject().toString());

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
	public ResposeResult getAllSpecialities() {

		Vector<String> vector = new Vector<>();
		
		try {

			con 					= DBConnection.connect();;
			PreparedStatement stmt 	= con.prepareStatement(
					"SELECT con.salute, con.name, sp.country, sp.subject, sp.id as sp_id, av.* " + 
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
}
