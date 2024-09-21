package com.telusko.jdbclearning;
import java.sql.*;

public class LaunchApp3 {

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
		String sqlRetriveQuery = "SELECT * FROM studentinfo";
		ResultSet rs = statement.executeQuery(sqlRetriveQuery);
		

		//Process the result
		while(rs.next()){
//			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
			System.out.println(rs.getInt("id") + " " + rs.getString("sname") + " " + rs.getInt("sage") + " " + rs.getString("scity"));
		}
		
		//Close resources
		rs.close();
		statement.close();
		connect.close();

	}

}
