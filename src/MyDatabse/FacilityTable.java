package MyDatabse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database_Connector.ConnectionProvider;

public class FacilityTable {

	public static void Create_All_Facilities() {

		// Get Connection
		Connection connection = ConnectionProvider.getConnection();

		String query = "CREATE TABLE `all_facilities` (\r\n" + "  `facilities_Id` INT NOT NULL AUTO_INCREMENT ,\r\n"
				+ "  `facility_name` VARCHAR(45) NULL,\r\n" + "  `facility_cost` FLOAT NULL,\r\n"
				+ "  PRIMARY KEY (`facilities_Id`));";

		// Get PreparedStatement object
		try {

			PreparedStatement pstmt = connection.prepareStatement(query);

			int res = pstmt.executeUpdate();

			System.out.println("Facility Table Created Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
