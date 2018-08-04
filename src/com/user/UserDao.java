package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.utilities.DBConnection;
import com.utilities.ResposeResult;

public class UserDao {
	
	Connection con ;
	Gson gson 				= new Gson();
	ResposeResult response  = new ResposeResult(true, null);
	
	/** 
	 - store
	 * */
	public ResposeResult store(User user){
		
		try {
			 
           con 						= DBConnection.connect();
           PreparedStatement stmt 	= con.prepareStatement("insert into users (name, role, email, password, active) values (?,?,?,?,?)");

           stmt.setString(1, user.getName().toString());
           stmt.setString(2, user.getRole().toString());
           stmt.setString(3, user.getEmail().toString());
           stmt.setString(4, user.getPassword().toString());
           stmt.setInt(5, user.getActive());

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
	public ResposeResult getAllUsers() {
		List<User> userList = new ArrayList<User>();
		try {

			con 					= DBConnection.connect();;
			PreparedStatement stmt 	= con.prepareStatement("select * from users");     
			ResultSet result 		= stmt.executeQuery();

			while (result.next()) 
			{
				User user = new User
						(result.getInt(1), 
								result.getString(2), 
								result.getString(3), 
								"pass", 
								result.getString(5),
								result.getInt(6));
				userList.add(user);
			} 

		} catch (Exception e) {
			response.setIs_error(true);
			response.setResult(e.getMessage());
		}

		response.setIs_error(false);
		response.setResult(gson.toJson(userList));
		return response;
	}
}
