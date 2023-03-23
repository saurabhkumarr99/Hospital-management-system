package MyDatabse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database_Connector.ConnectionProvider;

public class MedicineTable {

	public static void Create_Medicine() {

		// Get Connection
		Connection connection = ConnectionProvider.getConnection();

		String query = "CREATE TABLE medicines (\r\n"
				+ "	med_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,\r\n"
				+ "	med_name VARCHAR(50) NOT NULL,\r\n"
				+ "    med_comp VARCHAR(50) NOT NULL,\r\n"
				+ "    exp_date DATE,\r\n"
				+ "    med_cost FLOAT,\r\n"
				+ "    med_count INT\r\n"
				+ ");";

		// Get PreparedStatement object
		try {
			
			PreparedStatement pstmt = connection.prepareStatement(query);
			
			int res = pstmt.executeUpdate();

			System.out.println("Medicine Table Created Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
