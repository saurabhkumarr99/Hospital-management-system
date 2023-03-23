package MyDatabse;

public class CreateTable {

	public static void create() {
			
		FacilityTable.Create_All_Facilities();
		LabTable.Create_Lab();
		MedicineTable.Create_Medicine();
		PatientTable.Create_All_Patient();
		DoctorTable.Create_All_Doctor();
		StaffTable.Create_All_Staff();

	}

	
	
}
