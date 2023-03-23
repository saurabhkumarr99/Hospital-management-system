package CRUD_Implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database_Connector.ConnectionProvider;
import pojo_classes.Staff;

public class Staff_CRUD_Operations {

	static Connection connection = ConnectionProvider.getConnection();

	public static void addStaff(Staff staff) {

		try {

			String query = "insert into STAFF(STAFF_ID,STAFF_NAME,DESIGNATION,GENDER,STAFF_SALARY) values(?,?,?,?,?)";

			PreparedStatement pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, staff.getStaff_id());
			pstmt.setString(2, staff.getStaff_name());
			pstmt.setString(3, staff.getDesignation());
			pstmt.setString(4, staff.getGender());
			pstmt.setInt(5, staff.getSalary());

			// Execute query
			int res = pstmt.executeUpdate();

			if (res >= 1) {
				System.out.println("Staff added successfully");
			} else {
				System.out.println("Error");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void staffDetails() {

		try {

			String query = "select * from STAFF";
			// Get PreparedStatement object
			PreparedStatement pstmt = connection.prepareStatement(query);

			// Execute query
			ResultSet results = pstmt.executeQuery();

			System.out.println(
					"Staff id" + "\t" + "Staff Name" + "\t" + "Designation" + "\t" + "Gender" + "\t\t" + "Salary");
			while (results.next()) {
				System.out.println(results.getInt("Staff_Id") + "\t\t" + results.getString("Staff_Name") + "\t\t"
						+ results.getString("Designation") + "\t\t" + results.getString("gender") + "\t\t"
						+ results.getInt("Staff_Salary"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void update(Staff staff, int id) {

		String query = "update  Staff  set Staff_name =?,Staff_Salary =?,DESIGNATION =?,Gender = ? where STAFF_Id =?";

		try {

			PreparedStatement pstmt = connection.prepareStatement(query);

			// Set values to query
			pstmt.setString(1, staff.getStaff_name());
			pstmt.setInt(2, staff.getSalary());
			pstmt.setString(3, staff.getDesignation());
			pstmt.setString(4, staff.getGender());
			pstmt.setInt(5, id);

			int res = pstmt.executeUpdate();

			if (res >= 1) {
				System.out.println("Staff updated successfully");
			} else {
				System.out.println("Error");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void removeStaff(int id) {
		String query = "delete from Staff where Staff_Id =?";

		try {

			PreparedStatement pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, id);

			int res = pstmt.executeUpdate();
			if (res == 1) {
				System.out.println("Staff deleted successfully");
			} else {
				System.out.println("Error");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void searchStaff(String Staff_name) {

		try {

			String query = "SELECT * FROM Staff where Staff_name =?";
			PreparedStatement pstmt = connection.prepareStatement(query);

			// Set values to query
			pstmt.setString(1, Staff_name);

			// Execute query
			ResultSet results = pstmt.executeQuery();

			System.out.println(
					"Staff id" + "\t" + "Staff Name" + "\t" + "Designation" + "\t" + "Gender" + "\t\t" + "Salary");
			if (!results.isBeforeFirst()) {
				System.out.println(" Staff does not exist");
			} else {
				while (results.next()) {
					System.out.println(results.getInt("Staff_Id") + "\t\t" + results.getString("Staff_Name") + "\t\t"
							+ results.getString("Designation") + "\t\t" + results.getString("gender") + "\t\t"
							+ results.getInt("Staff_Salary"));
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
