package com.student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;

import com.utilities.ResposeResult;
import com.counsellor.Counsellor;
import com.google.gson.Gson;
import com.utilities.DBConnection;

public class StudentDao {

	Gson gson 				= new Gson();
	Connection con ;
	ResposeResult response  = new ResposeResult(true, null);
	

	/** 
	 - store
	 * */
	public ResposeResult addStudent(Student student){
		
		try {
			 
            con 			= DBConnection.connect();
            PreparedStatement stmt 	= con.prepareStatement("insert into students (name, gender, contact_no, email) values (?,?,?,?)");

            stmt.setString(1, student.getName().toString());
            stmt.setString(2, student.getGender().toString());
            stmt.setString(3, student.getContact_no().toString());
            stmt.setString(4, student.getEmail().toString());

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
	public ResposeResult getAllStudents() {
		List<Student> studentList = new ArrayList<Student>();
		try {

			con 					= DBConnection.connect();;
			PreparedStatement stmt 	= con.prepareStatement("select * from students");     
			ResultSet result 		= stmt.executeQuery();

			while (result.next()) 
			{
				Student student = new Student
						(result.getInt(1), 
								result.getString(2), 
								result.getString(3), 
								result.getString(4), 
								result.getString(5));
				studentList.add(student);
			} 

		} catch (Exception e) {
			response.setIs_error(true);
			response.setResult(e.getMessage());
		}

		response.setIs_error(false);
		response.setResult(gson.toJson(studentList));
		return response;
	}
	
}
