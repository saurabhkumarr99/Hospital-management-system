package CRUD_Implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database_Connector.ConnectionProvider;
import pojo_classes.Patient;

public class Patient_CRUD_Operations {

	// Get Connection
	static Connection connection = ConnectionProvider.getConnection();

	// Create -Insert Facility Object
	public static void addNewEntry(Patient patient) {

		try {

			String query = "insert into patient(patient_name,disease, sex, admit_status,age) values(?,?,?,?,?)";

			// Get PreparedStatement object
			PreparedStatement pstmt = connection.prepareStatement(query);

			// Set values to query
			pstmt.setString(1, patient.getPatient_name());
			pstmt.setString(2, patient.getDisease());
			pstmt.setString(3, patient.getSex());
			pstmt.setString(4, patient.getAdmit_status());
			pstmt.setInt(5, patient.getAge());

			// Execute query
			int res = pstmt.executeUpdate();

			if (res >= 1) {
				System.out.println("Patient added successfully");
			} else {
				System.out.println("Error");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Read -Print all patient details
	public static void existingPatientList() {

		String query = "select * from patient";

		try {

			// Get PreparedStatement object
			PreparedStatement pstmt = connection.prepareStatement(query);

			// Execute query
			ResultSet rs = pstmt.executeQuery();

			System.out.println("Patient id     " + "	Patient Name    " + "Disease		" + "Sex	"
					+ " Admit Status	" + "  Age");
			while (rs.next()) {

				int id = rs.getInt(1);
				String patient_name = rs.getString(2);
				String disease = rs.getString(3);
				String sex = rs.getString(4);
				String admit_status = rs.getString(5);
				int age = rs.getInt(6);

				System.out.println("     " + id + "    	" + patient_name + "        " + disease + "         " + sex
						+ "         " + admit_status + "        " + age);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Update - Update Patient Details
	public static void updatePatientDetails(Patient patient, int patient_id) {

		String query = "update patient  set patient_name =?,disease =?, sex =?, admit_status =?, age =? where patient_Id =?";

		try {

			// Get PreparedStatement object
			PreparedStatement pstmt = connection.prepareStatement(query);

			// Set values to query
			pstmt.setString(1, patient.getPatient_name());
			pstmt.setString(2, patient.getDisease());
			pstmt.setString(3, patient.getSex());
			pstmt.setString(4, patient.getAdmit_status());
			pstmt.setInt(5, patient.getAge());
			pstmt.setInt(6, patient_id);
			// Execute query
			int res = pstmt.executeUpdate();

			if (res >= 1) {
				System.out.println("Patient details updated successfully");
			} else {
				System.out.println("Error");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Search Search Patient
	public static void searchPatient(int patient_id) {

		try {
			// Get PreparedStatement object
			String query = "SELECT * FROM patient where patient_id =?";
			PreparedStatement pstmt = connection.prepareStatement(query);

			// Set values to query
			pstmt.setInt(1, patient_id);

			// Execute query
			ResultSet rs = pstmt.executeQuery();

			System.out.println("Patient id     " + "	Patient Name    " + "Disease		" + "Sex	"
					+ " Admit Status	" + "  Age");
			if (!rs.isBeforeFirst()) {
				System.out.println(" Patient not found.");
			} else {
				while (rs.next()) {
					int id = rs.getInt(1);
					String patient_name = rs.getString(2);
					String disease = rs.getString(3);
					String sex = rs.getString(4);
					String admit_status = rs.getString(5);
					int age = rs.getInt(6);

					System.out.println("     " + id + "    	" + patient_name + "        " + disease + "         " + sex
							+ "         " + admit_status + "        " + age);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Delete -patient details
	public static void deletePatientDetails(int id) {

		String query = "delete from patient where patient_Id =?";

		try {

			// Get PreparedStatement object
			PreparedStatement pstmt = connection.prepareStatement(query);

			// Set values to query
			pstmt.setInt(1, id);

			// Execute query
			int res = pstmt.executeUpdate();
			if (res >= 1) {
				System.out.println("Patient details deleted successfully");
			} else {
				System.out.println("Error");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
