
package CRUD_Implementations;

import java.sql.*;

import database_Connector.ConnectionProvider;
import pojo_classes.Laboratory;

public class Laboratories_CRUD_Operations {

	static Connection connection = ConnectionProvider.getConnection();

	public static void addLab(Laboratory lab) {
		try {

			String query = "insert into labs(lab_test_name,lab_test_cost) values(?,?)";
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, lab.getLabTestName());
			pstmt.setDouble(2, lab.getLabTestCost());

			int res = pstmt.executeUpdate();

			if (res >= 1) {
				System.out.println("Lab Test added successfully");
			} else {
				System.out.println("Error");
			}

		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void labTests() {

		String query = "select * from labs";

		try {

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);

			System.out.println("Lab id     " + "Lab Test Name    " + "Lab Test Cost");
			while (rs.next()) {
				int id = rs.getInt(1);
				String Lab_Test_Name = rs.getString(2);
				double Lab_Test_Cost = rs.getDouble(3);

				System.out.println("  " + id + "         " + Lab_Test_Name + "              " + Lab_Test_Cost);
			}

		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateLab(Laboratory lab, int id) {

		String query = "update  labs  set lab_test_name =?,lab_test_cost =? where lab_Id =?";

		try {

			// Get PreparedStatement object
			PreparedStatement pstmt = connection.prepareStatement(query);

			// Set values to query
			pstmt.setString(1, lab.getLabTestName());
			pstmt.setDouble(2, lab.getLabTestCost());
			pstmt.setInt(3, id);

			// Execute query
			int res = pstmt.executeUpdate();

			if (res >= 1) {
				System.out.println("Lab test updated successfully");
			} else {
				System.out.println("Error");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void deleteLab(int id) {
		String query = "delete from labs where lab_Id =?";

		try {

			// Get PreparedStatement object
			PreparedStatement pstmt = connection.prepareStatement(query);

			// Set values to query
			pstmt.setInt(1, id);

			// Execute query
			int res = pstmt.executeUpdate();
			if (res >= 1) {
				System.out.println("Lab test deleted successfully");
			} else {
				System.out.println("Error");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void searchLab(String labTestName) {

		try {
			// Get PreparedStatement object
			String query = "SELECT * FROM labs where lab_Test_Name =?";
			PreparedStatement pstmt = connection.prepareStatement(query);

			// Set values to query
			pstmt.setString(1, labTestName);

			// Execute query
			ResultSet rs = pstmt.executeQuery();

			System.out.println("Lab id     " + "Lab Test Name    " + "Lab Test Cost");
			if (!rs.isBeforeFirst()) {
				System.out.println(" lab test is not available.");
			} else {
				while (rs.next()) {
					int id = rs.getInt(1);
					String Lab_Test_Name = rs.getString(2);
					double Lab_Test_Cost = rs.getDouble(3);

					System.out.println("  " + id + "         " + Lab_Test_Name + "              " + Lab_Test_Cost);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}