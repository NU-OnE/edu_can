package com.specialized;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
		List<Specialized> specializedList = new ArrayList<Specialized>();
		try {

			con 					= DBConnection.connect();;
			PreparedStatement stmt 	= con.prepareStatement("select * from specialized");     
			ResultSet result 		= stmt.executeQuery();

			while (result.next()) 
			{
				Specialized specialized = new Specialized(result.getInt(1), result.getInt(2), result.getString(3), result.getString(4));
				specializedList.add(specialized);
			} 

		} catch (Exception e) {
			response.setIs_error(true);
			response.setResult(e.getMessage());
		}

		response.setIs_error(false);
		response.setResult(gson.toJson(specializedList));
		return response;
	}
}
