package CRUD_Implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database_Connector.ConnectionProvider;
import pojo_classes.Doctor;

public class Doctor_CRUD_Operations {

	// Get Connection
	static Connection connection = ConnectionProvider.getConnection();

	// Create -Insert Facility Object
	public static void add_doctor(Doctor doctor) {

		try {

			String query = "insert into doctors(doctor_name,specialist,timing,qualification,room_no) values(?,?,?,?,?)";

			// Get PreparedStatement object
			PreparedStatement pstmt = connection.prepareStatement(query);

			// Set values to query
			pstmt.setString(1, doctor.getDoctor_name());
			pstmt.setString(2, doctor.getSpecialist());
			pstmt.setString(3, doctor.getTiming());
			pstmt.setString(4, doctor.getQualification());
			pstmt.setInt(5, doctor.getRoom_no());
			// Execute query
			int res = pstmt.executeUpdate();

			if (res >= 1) {
				System.out.println("Doctor added successfully");
			} else {
				System.out.println("Error");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Read -Print all facilities
	public static void AllDoctors() {

		String query = "select * from doctors";

		try {
			// Get PreparedStatement object
			PreparedStatement pstmt = connection.prepareStatement(query);

			// Execute query
			ResultSet rs = pstmt.executeQuery();

			System.out.println("Doctor id     " + "Doctor Name    " + "Specialist      " + "Timing    "
					+ "Qualification      " + "Room No   ");
			while (rs.next()) {
				int doctor_Id = rs.getInt(1);
				String doctor_name = rs.getString(2);
				String specialist = rs.getString(3);
				String timing = rs.getString(4);
				String qualification = rs.getString(5);
				int room_no = rs.getInt(6);

				System.out.println("     " + doctor_Id + "         " + doctor_name + "          " + specialist
						+ "         " + timing + "          " + qualification + "             " + room_no);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Update - Update Facilities
	public static void update_Doctor(Doctor doctor, int doctor_Id) {

		String query = "update  doctors  set doctor_name =?,specialist =?, timing =?, qualification =?, room_no =?  where doctor_Id =?";

		try {

			// Get PreparedStatement object
			PreparedStatement pstmt = connection.prepareStatement(query);

			// Set values to query
			pstmt.setString(1, doctor.getDoctor_name());
			pstmt.setString(2, doctor.getSpecialist());
			pstmt.setString(3, doctor.getTiming());
			pstmt.setString(4, doctor.getQualification());
			pstmt.setInt(5, doctor.getRoom_no());
			pstmt.setInt(6, doctor_Id);
			// Execute query
			int res = pstmt.executeUpdate();

			if (res >= 1) {
				System.out.println("Doctor updated successfully");
			} else {
				System.out.println("Error");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Delete -Delete Facilities
	public static void delete_Doctor(int doctor_Id) {
		String query = "delete from doctors where doctor_Id =?";

		try {

			// Get PreparedStatement object
			PreparedStatement pstmt = connection.prepareStatement(query);

			// Set values to query
			pstmt.setInt(1, doctor_Id);

			// Execute query
			int res = pstmt.executeUpdate();
			if (res >= 1) {
				System.out.println("Doctor deleted successfully");
			} else {
				System.out.println("Error");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Search Search Facility
	public static void search_Doctor(String doctor_name) {

		try {
			// Get PreparedStatement object
			String query = "SELECT * FROM doctors where doctor_name =?";
			PreparedStatement pstmt = connection.prepareStatement(query);

			// Set values to query
			pstmt.setString(1, doctor_name);

			// Execute query
			ResultSet rs = pstmt.executeQuery();

			System.out.println("Doctor id     " + "Doctor Name    " + "Specialist      " + "Timing    "
					+ "Qualification      " + "Room No   ");
			if (!rs.isBeforeFirst()) {
				System.out.println("Doctor is not available.");
			} else {
				while (rs.next()) {
					int doctor_Id = rs.getInt(1);
					doctor_name = rs.getString(2);
					String specialist = rs.getString(3);
					String timing = rs.getString(4);
					String qualification = rs.getString(5);
					int room_no = rs.getInt(6);

					System.out.println("     " + doctor_Id + "         " + doctor_name + "          " + specialist
							+ "         " + timing + "          " + qualification + "             " + room_no);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
