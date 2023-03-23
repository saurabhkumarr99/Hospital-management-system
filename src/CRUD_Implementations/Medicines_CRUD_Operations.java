package CRUD_Implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database_Connector.ConnectionProvider;
import pojo_classes.Medicine;

public class Medicines_CRUD_Operations {

	// Get Connection
	static Connection connection = ConnectionProvider.getConnection();

	// Create - Insert Medicine
	public static void addMedicine(Medicine medicines) {
		try {

			String query = "insert into medicines(med_name,med_comp,exp_date,med_cost,med_count) "
					+ "values(?,?,?,?,?)";

			// Get PreparedStatement object
			PreparedStatement pstmt = connection.prepareStatement(query);

			pstmt.setString(1, medicines.getMedicineName());
			pstmt.setString(2, medicines.getMedicineCompany());
			pstmt.setString(3, medicines.getExpiryDate());
			pstmt.setFloat(4, medicines.getMedicineCost());
			pstmt.setInt(5, medicines.getMedicineCount());

			// Execute query
			int res = pstmt.executeUpdate();

			if (res >= 1)
				System.out.println("Medicine Added Successfully");
			else
				System.out.println("Error");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Read - Print all medicines
	public static void allMedicines() {

		String query = "select * from medicines";

		try {

			// Get PreparedStatement object
			PreparedStatement pstmt = connection.prepareStatement(query);

			// Execute query
			ResultSet rs = pstmt.executeQuery();

			System.out.println("Medicine Id \t" + "Medicine Name \t" + "Medicine Company \t" + "Expiry Date \t"
					+ "Medicine Cost \t" + "Medicine Count \t");
			while (rs.next()) {
				int id = rs.getInt(1);
				String MedicineName = rs.getString(2);
				String MedicineCompany = rs.getString(3);
				String ExpiryDate = rs.getString(4);
				Float MedicineCost = rs.getFloat(5);
				int MedicineCount = rs.getInt(6);

				System.out.println("	" + id + "\t" + MedicineName + "\t" + "\t" + MedicineCompany + "\t" +"       "
						+ ExpiryDate + "\t" + MedicineCost + "\t" + "\t" + MedicineCount);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Update - Update Medicines
	public static void updateMedicine(Medicine medicines, int id) {

		String query = "update medicines set med_name=?, med_comp=?, exp_date=?, med_cost=?, med_count=? where med_id=?";

		try {

			// Get PreparedStatement object
			PreparedStatement pstmt = connection.prepareStatement(query);

			pstmt.setString(1, medicines.getMedicineName());
			pstmt.setString(2, medicines.getMedicineCompany());
			pstmt.setString(3, medicines.getExpiryDate());
			pstmt.setFloat(4, medicines.getMedicineCost());
			pstmt.setInt(5, medicines.getMedicineCount());
			pstmt.setInt(6, id);

			int res = pstmt.executeUpdate();

			if (res >= 1)
				System.out.println("Medicine Updated Successfully");
			else
				System.out.println("Error");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Delete - Delete Medicine
	public static void deleteMedicine(int id) {
		String query = "delete from medicines where med_id =?";

		try {

			// Get PreparedStatement object
			PreparedStatement pstmt = connection.prepareStatement(query);

			// Set values to query
			pstmt.setInt(1, id);

			// Execute query
			int res = pstmt.executeUpdate();
			if (res >= 1) {
				System.out.println("Medicine Deleted Successfully");
			} else {
				System.out.println("Error");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Search - Search Medicine
	public static void searchMedicine(String med_name) {

		try {

			// Get PreparedStatement object
			String query = "select * from medicines where med_name =?";

			PreparedStatement pstmt = connection.prepareStatement(query);

			// Set values to query
			pstmt.setString(1, med_name);

			ResultSet rs = pstmt.executeQuery();

			System.out.println("Medicine Id \t" + "Medicine Name \t" + "Medicine Company \t" + "Expiry Date \t"
					+ "Medicine Cost \t" + "Medicine Count \t");

			if (!rs.isBeforeFirst())
				System.out.println("Medicine is not available.");
			else {
				while (rs.next()) {
					int id = rs.getInt(1);
					String MedicineName = rs.getString(2);
					String MedicineCompany = rs.getString(3);
					String ExpiryDate = rs.getString(4);
					Float MedicineCost = rs.getFloat(5);
					int MedicineCount = rs.getInt(6);

					System.out.println("	" + id + "\t" + MedicineName + "\t" + "\t" + MedicineCompany + "\t" + "	\t"
							+ ExpiryDate + "\t" + MedicineCost + "\t" + "	\t" + MedicineCount);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
