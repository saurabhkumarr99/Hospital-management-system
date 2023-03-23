package MyDatabse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database_Connector.ConnectionProvider;

public class PatientTable {

	public static void Create_All_Patient() {

		// Get Connection
		Connection connection = ConnectionProvider.getConnection();

		String query = "CREATE TABLE `patient` (\r\n"
				+ "  `patient_id` INT NOT NULL AUTO_INCREMENT ,\r\n"
				+ "  `patient_name` VARCHAR(45) NULL,\r\n"
				+ "  `disease` VARCHAR(30) NULL,\r\n"
				+ "  `sex` VARCHAR(10) NULL,\r\n"
				+ "  `admit_status` VARCHAR(10),\r\n"
				+ "  `AGE` INT(5),\r\n"
				+ "  PRIMARY KEY (`patient_Id`));";

		// Get PreparedStatement object
		try {
			
			PreparedStatement pstmt = connection.prepareStatement(query);
			
			int res = pstmt.executeUpdate();

			System.out.println("Patient Table Created Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
