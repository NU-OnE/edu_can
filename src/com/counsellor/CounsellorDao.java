package com.counsellor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public ResposeResult getAllCounsellors() {
		List<Counsellor> counsellorList = new ArrayList<Counsellor>();
		try {

			Connection con = DBConnection.connect();
			PreparedStatement stmt = con.prepareStatement("select * from consultants");     
			ResultSet result = stmt.executeQuery();

			while (result.next()) 
			{
				Counsellor counsellor = new Counsellor
						(result.getInt(1), 
								result.getString(1), 
								result.getString(2), 
								result.getString(3), 
								result.getString(4), 
								result.getString(5));
				counsellorList.add(counsellor);

			} 

		} catch (Exception e) {
			response.setIs_error(true);
			response.setResult(e.getMessage());
		}

		response.setIs_error(false);
		response.setResult(gson.toJson(counsellorList));
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
