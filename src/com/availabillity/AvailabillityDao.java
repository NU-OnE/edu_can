package com.availabillity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.utilities.DBConnection;
import com.utilities.ResposeResult;

public class AvailabillityDao {

	Connection con ;
	Gson gson 				= new Gson();
	ResposeResult response  = new ResposeResult(true, null);


	/** 
	 - store
	 * */
	public ResposeResult store(Availabillity availabillity){

		try { 
			con 					= DBConnection.connect();
			PreparedStatement stmt 	= con.prepareStatement("insert into availabillities (consultant_id, sun, mon, tue, wed, thu, fri, sat) values (?,?,?,?,?,?,?,?)");

			stmt.setInt(1, availabillity.getConsultant_id());
			stmt.setString(2, availabillity.getSun().toString());
			stmt.setString(3, availabillity.getMon().toString());
			stmt.setString(4, availabillity.getTue().toString());
			stmt.setString(5, availabillity.getWed().toString());
			stmt.setString(6, availabillity.getThu().toString());
			stmt.setString(7, availabillity.getFri().toString());
			stmt.setString(8, availabillity.getSat().toString());


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
	public ResposeResult getAllAvilabillities() {
		List<Availabillity> availabillityList = new ArrayList<Availabillity>();
		try {

			con 					= DBConnection.connect();;
			PreparedStatement stmt 	= con.prepareStatement("select * from availabillities");     
			ResultSet result 		= stmt.executeQuery();

			while (result.next()) 
			{
				Availabillity availabillity = new Availabillity
						(result.getInt(1), 
								result.getInt(2), 
								result.getString(3), 
								result.getString(4), 
								result.getString(5),
								result.getString(6),
								result.getString(7),
								result.getString(8),
								result.getString(9));
				availabillityList.add(availabillity);
			} 

		} catch (Exception e) {
			response.setIs_error(true);
			response.setResult(e.getMessage());
		}

		response.setIs_error(false);
		response.setResult(gson.toJson(availabillityList));
		return response;
	}
}
