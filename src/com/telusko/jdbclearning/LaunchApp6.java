package com.telusko.jdbclearning;
import java.sql.*;

public class LaunchApp6 {

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
		String sql = "SELECT * FROM studentinfo";
		String sqlUpdate = "update studentinfo set sage = 25 where id =3";
		boolean status = statement.execute(sqlUpdate);
		
		//Process the result
		if(status) {
			System.out.println("IF Block");
			//select
			ResultSet rs = statement.getResultSet();
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
			}
		}else {
			System.out.println("Else Block");
			//insert, update, delete
			int rows = statement.getUpdateCount();
			if(rows == 0) {
				System.out.println("Operation Failed!");
			}else {
				System.out.println("Operation successful!");
			}
		}
		
		//Close resources
		statement.close();
		connect.close();

	}

}
