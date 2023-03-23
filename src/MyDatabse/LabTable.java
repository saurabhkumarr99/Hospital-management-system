package MyDatabse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database_Connector.ConnectionProvider;

public class LabTable {

	public static void Create_Lab() {

		// Get Connection
		Connection connection = ConnectionProvider.getConnection();

		String query = "create table labs(\r\n"
				+ "lab_id int auto_increment,\r\n"
				+ "lab_test_name varchar(50) null,\r\n"
				+ "lab_test_cost decimal null,\r\n"
				+ "primary key (lab_id)\r\n"
				+ ");";

		// Get PreparedStatement object
		try {

			PreparedStatement pstmt = connection.prepareStatement(query);

			int res = pstmt.executeUpdate();

			System.out.println("Lab Table Created Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
