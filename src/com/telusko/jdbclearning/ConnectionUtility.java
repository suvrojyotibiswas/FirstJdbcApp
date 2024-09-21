package com.telusko.jdbclearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtility {
	
	static 
	{
		//Load and register the Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
	}
	
	public static Connection getConnection() throws SQLException {
		//Establish the connection
		String url = "jdbc:mysql://localhost:3306/course_data";
		String user = "root";
		String password = "admin";
		
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void closeConnection(Connection connect, Statement stmnt) throws SQLException {
		connect.close();
		stmnt.close();
	}
}
