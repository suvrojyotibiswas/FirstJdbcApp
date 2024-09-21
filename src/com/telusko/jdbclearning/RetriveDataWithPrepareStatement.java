package com.telusko.jdbclearning;
import java.sql.*;
import java.util.Scanner;

public class RetriveDataWithPrepareStatement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Statement statement = null;
		Connection connect = null;
		PreparedStatement pstmnt = null;
		
		try {
			connect = ConnectionUtility.getConnection();
			//Creating statement
			//Execute Query
			String sql = "SELECT * FROM studentinfo where id = ?";
			pstmnt = connect.prepareStatement(sql );
			
			//taking from user
			
			System.out.println("Data Showing");
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Enter ID : ");
			int id = scan.nextInt();

			pstmnt.setInt(1, id);
			
			ResultSet data = pstmnt.executeQuery();
			//Process the result
			while(data.next()) {
				System.out.println(data.getInt(1) + " " + data.getString(2) + " " + data.getInt(3) + " " + data.getString(4));
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
