package com.telusko.jdbclearning;
import java.sql.*;
import java.util.Scanner;

public class DeleteDataWithPrepareStatement {

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
			
			System.out.println("Delete Data");
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Enter ID : ");
			int id = scan.nextInt();

			pstmnt.setInt(1, id);
			
			int efctRows = pstmnt.executeUpdate();
			//Process the result
			if(efctRows != 0) {
				System.out.println("Deleted");
			}
			else {
				System.out.println("Not Deleted");
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
