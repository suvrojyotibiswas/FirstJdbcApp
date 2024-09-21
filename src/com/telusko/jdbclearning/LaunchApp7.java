package com.telusko.jdbclearning;
import java.sql.*;

public class LaunchApp7 {

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
		String sqlQuery = "INSERT INTO studentinfo(id, sname, sage, scity) values(10, 'Kalam', 26, 'Kolkata')";
		int rowNo = statement.executeUpdate(sqlQuery);
		
		//Process the result
		if(rowNo != 0)
			System.out.println("Updated");
		else
			System.out.println("Not Udated");
		

		//Close resources
		statement.close();
		connect.close();

	}

}
