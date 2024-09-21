package com.telusko.jdbclearning;
import java.sql.*;
import java.util.Scanner;

public class LaunchAppExceptionHandled {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Statement statement = null;
		Connection connect = null;
		PreparedStatement pstmnt = null;
		
		try {
			connect = ConnectionUtility.getConnection();
			//Creating statement
			//Execute Query
			String sql = "INSERT INTO studentinfo (id, sname, sage, scity) VALUES (?,?,?,?)";
			pstmnt = connect.prepareStatement(sql );
			
			//taking from user
			
			System.out.println("Enter Details : ");
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Enter ID : ");
			int id = scan.nextInt();
			System.out.println("Enter Name :");
			String name = scan.next();
			System.out.println("Enter Age : ");
			int age = scan.nextInt();
			System.out.println("Enter City :");
			String city = scan.next();
			
			pstmnt.setInt(1, id);
			pstmnt.setString(2, name);
			pstmnt.setInt(3, age);
			pstmnt.setString(4, city);
			
			int efctRows = pstmnt.executeUpdate();
			//Process the result
			if(efctRows != 0) {
				System.out.println("Inserted");
			}
			else {
				System.out.println("Not inserted");
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				//Close resources
				ConnectionUtility.closeConnection(connect, pstmnt);
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
