package com.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection con;

	private DBConnection() {

	}

	private static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/edu_can", "root", "");       

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

	public static Connection connect() throws SQLException{
		if(con == null) {
			con = getConnection();

		}else if (con.isClosed()) {
			con = getConnection();
		}

		return con;
	}


}
