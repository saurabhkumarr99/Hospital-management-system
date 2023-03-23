package database_Connector;
import java.sql.*;

public class ConnectionProvider {

	private static Connection connection;

	public static Connection getConnection() {

		try {

			if (connection == null) {
				// Step-1 --> Load JDBC Driver
				//Class.forName("com.mysql.jdbc.Driver");

				// Step-2 --> Create a connection
				String url = "jdbc:mysql://localhost:3306/hospital_management_system";
				//String url = "jdbc:mysql://localhost:3306/db4";
				String user = "root";
				String password = "root";

				connection = DriverManager.getConnection(url, user, password);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}

}
