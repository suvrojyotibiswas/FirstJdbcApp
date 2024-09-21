package com.telusko.jdbclearning;
import java.sql.*;
import java.util.Scanner;

public class UpdateWithPrepareStatement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Statement statement = null;
		Connection connect = null;
		PreparedStatement pstmnt = null;
		
		try {
			connect = ConnectionUtility.getConnection();
			//Creating statement
			//Execute Query
			String sql = "UPDATE studentinfo SET  sage = ? where id = ?";
			pstmnt = connect.prepareStatement(sql );
			
			//taking from user
			
			System.out.println("Enter Details : ");
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Enter ID : ");
			int id = scan.nextInt();
			System.out.println("Enter Age : ");
			int age = scan.nextInt();
			
			pstmnt.setInt(2, id);
			pstmnt.setInt(1, age);
			
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
