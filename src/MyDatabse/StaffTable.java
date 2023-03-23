package MyDatabse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database_Connector.ConnectionProvider;

public class StaffTable {
	// Get Connection
	public static void Create_All_Staff() {

		// Get Connection
		Connection connection = ConnectionProvider.getConnection();

		String query = "create table STAFF(\r\n"
				+ "STAFF_ID INT primary key,\r\n"
				+ "STAFF_NAME VARCHAR(50),\r\n"
				+ "DESIGNATION VARCHAR(50),\r\n"
				+ "GENDER VARCHAR(50),\r\n"
				+ "STAFF_SALARY INT\r\n"
				+ ");";

		// Get PreparedStatement object
		try {
			
			PreparedStatement pstmt = connection.prepareStatement(query);
			
			int res = pstmt.executeUpdate();

			System.out.println("Staff Table Created Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
