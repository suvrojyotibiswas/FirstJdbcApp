package com.telusko.jdbclearning;
import java.sql.*;

public class LaunchApp4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		//Load and register the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Establish the connection
		String url = "jdbc:mysql://localhost:3306/course_data";
		String user = "root";
		String password = "admin";
		Connection connect = DriverManager.getConnection(url, user, password);
		
		//Creating statement
		Statement statement = connect.createStatement();
		
		//Execute Query
		//Delete Query
		String sqlDeleteQuery = "DELETE FROM studentinfo WHERE id = 2";
		int rowsAffected = statement.executeUpdate(sqlDeleteQuery);
		
		//Process the result
		if(rowsAffected == 0)
			System.out.println("Not Deleted");
		else
			System.out.println("Deleted Successfully");
		
		//Close resources
		statement.close();
		connect.close();

	}

}
