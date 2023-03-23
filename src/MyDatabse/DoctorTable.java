package MyDatabse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database_Connector.ConnectionProvider;

public class DoctorTable {

	// Get Connection
	public static void Create_All_Doctor() {

		// Get Connection
		Connection connection = ConnectionProvider.getConnection();

		String query = "CREATE TABLE `doctors` (\r\n"
				+ "  `doctor_Id` INT NOT NULL AUTO_INCREMENT ,\r\n"
				+ "  `doctor_name` VARCHAR(45) NULL,\r\n"
				+ "  `specialist` VARCHAR(20) NULL,\r\n"
				+ "  `timing` VARCHAR(20),\r\n"
				+ "  `qualification` VARCHAR(20),\r\n"
				+ "  `room_no` INT,\r\n"
				+ "  PRIMARY KEY (`doctor_Id`));\r\n"
				+ "";

		// Get PreparedStatement object
		try {

			PreparedStatement pstmt = connection.prepareStatement(query);

			int res = pstmt.executeUpdate();

			System.out.println("Doctor Table Created Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
