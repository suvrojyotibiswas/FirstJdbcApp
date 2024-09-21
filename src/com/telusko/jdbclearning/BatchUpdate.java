package com.telusko.jdbclearning;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BatchUpdate {

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
			
			
			pstmnt.setInt(1, 22);
			pstmnt.setInt(2, 1);
			pstmnt.addBatch();
			pstmnt.setInt(1, 22);
			pstmnt.setInt(2, 2);
			pstmnt.addBatch();
			pstmnt.setInt(1, 22);
			pstmnt.setInt(2, 3);
			pstmnt.addBatch();
			pstmnt.setInt(1, 22);
			pstmnt.setInt(2, 10);
			pstmnt.addBatch();
			
			pstmnt.executeBatch();

			
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
