package CRUD_Implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database_Connector.ConnectionProvider;
import pojo_classes.Facility;

public class Facility_CRUD_Operations {

	// Get Connection
	static Connection connection = ConnectionProvider.getConnection();

	// Create -Insert Facility Object
	public static void addFcaility(Facility facility) {

		try {

			String query = "insert into all_facilities(facility_name,facility_cost) values(?,?)";

			// Get PreparedStatement object
			PreparedStatement pstmt = connection.prepareStatement(query);

			// Set values to query
			pstmt.setString(1, facility.getFacility_Name());
			pstmt.setFloat(2, facility.getFacility_cost());

			// Execute query
			int res = pstmt.executeUpdate();

			if (res >= 1) {
				System.out.println("Facility added successfully");
			} else {
				System.out.println("Error");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Read -Print all facilities
	public static void AllFacility() {

		String query = "select * from all_facilities";

		try {
			// Get PreparedStatement object
			PreparedStatement pstmt = connection.prepareStatement(query);

			// Execute query
			ResultSet rs = pstmt.executeQuery();

			System.out.println("Facility id     " + "Facility Name    " + "Facility Cost");
			while (rs.next()) {
				int id = rs.getInt(1);
				String Facility_Name = rs.getString(2);
				String Facility_Cost = rs.getString(3);

				System.out.println("     " + id + "             " + Facility_Name + "        " + Facility_Cost);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Update - Update Facilities
	public static void update(Facility facility, int id) {
		
		String query = "update  all_facilities  set facility_name =?,facility_cost =? where facilities_Id =?";

		try {

			// Get PreparedStatement object
			PreparedStatement pstmt = connection.prepareStatement(query);

			// Set values to query
			pstmt.setString(1, facility.getFacility_Name());
			pstmt.setFloat(2, facility.getFacility_cost());
			pstmt.setInt(3, id);

			// Execute query
			int res = pstmt.executeUpdate();

			if (res >= 1) {
				System.out.println("Facility updated successfully");
			} else {
				System.out.println("facility is not available.");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Delete -Delete Facilities
	public static void deleteFacility(int id) {
		String query = "delete from all_facilities where facilities_Id =?";

		try {

			// Get PreparedStatement object
			PreparedStatement pstmt = connection.prepareStatement(query);

			// Set values to query
			pstmt.setInt(1, id);

			// Execute query
			int res = pstmt.executeUpdate();
			if (res >= 1) {
				System.out.println("Facility deleted successfully");
			} else {
				System.out.println("facility is not available.");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Search Search Facility
	public static void searchFacility(String facility_name) {

		try {
			// Get PreparedStatement object
			String query = "SELECT * FROM all_facilities where facility_name =?";
			PreparedStatement pstmt = connection.prepareStatement(query);

			// Set values to query
			pstmt.setString(1, facility_name);

			// Execute query
			ResultSet rs = pstmt.executeQuery();

			System.out.println("Facility id     " + "Facility Name    " + "Facility Cost");
			if (!rs.isBeforeFirst()) {
				System.out.println(" facility is not available.");

			} else {
				while (rs.next()) {
					int id = rs.getInt(1);
					String Facility_Name = rs.getString(2);
					String Facility_Cost = rs.getString(3);

					System.out.println("     " + id + "             " + Facility_Name + "        " + Facility_Cost);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
