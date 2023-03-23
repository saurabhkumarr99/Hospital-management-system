import java.util.Scanner;

import CRUD_Implementations.Doctor_CRUD_Operations;
import CRUD_Implementations.Facility_CRUD_Operations;
import CRUD_Implementations.Laboratories_CRUD_Operations;
import CRUD_Implementations.Medicines_CRUD_Operations;
import CRUD_Implementations.Patient_CRUD_Operations;
import CRUD_Implementations.Staff_CRUD_Operations;
import pojo_classes.Doctor;
import pojo_classes.Facility;
import pojo_classes.Laboratory;
import pojo_classes.Medicine;
import pojo_classes.Patient;
import pojo_classes.Staff;

public class run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int choice, j, c1, status = 1, s1 = 1, s2 = 1, s3 = 1, s4 = 1, s5 = 1, s6 = 1;
		while (status == 1) {
			System.out.println("\n                                    MAIN MENU");
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println("1.Doctors  2.Patients  3.Medicines  4.Laboratories  5.Facilities  6.Staff  7.Exit");
			System.out.println("-----------------------------------------------------------------------------------------");
			choice = input.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("                      *DOCTOR SECTION*");
				System.out.println("--------------------------------------------------------------------------------");
				s1 = 1;
				while (s1 == 1) {
					System.out.println(
							"1.Add New Doctor \n2.Existing Doctors List \n3.Update Doctor \n4.Search Doctor \n5.Delete Doctor");
					c1 = input.nextInt();
					switch (c1) {
					case 1: {
						System.out.print("Enter Doctor Name-");
						String doctor_name = input.next();
						System.out.print("Enter Speciliasation-");
						String specialist = input.next();
						System.out.print("Enter Timings-");
						String timing = input.next();
						System.out.print("Enter Qualification-");
						String qualification = input.next();
						System.out.print("Enter Room No-");
						int room_no = input.nextInt();

						Doctor doctor = new Doctor(doctor_name, specialist, timing, qualification, room_no);
						Doctor_CRUD_Operations.add_doctor(doctor);
						break;
					}
					case 2: {
						Doctor_CRUD_Operations.AllDoctors();
						break;
					}
					case 3: {
						System.out.println("Enter Doctor Id");
						int doctor_Id = input.nextInt();
						System.out.print("Enter Doctor Name-");
						String doctor_name = input.next();
						System.out.print("Enter Speciliasation-");
						String specialist = input.next();
						System.out.print("Enter Timings-");
						String timing = input.next();
						System.out.print("Enter Qualification-");
						String qualification = input.next();
						System.out.print("Enter Room No-");
						int room_no = input.nextInt();

						Doctor doctor = new Doctor(doctor_name, specialist, timing, qualification, room_no);
						Doctor_CRUD_Operations.update_Doctor(doctor, doctor_Id);
						break;
					}
					case 4: {
						System.out.print("Enter Doctor Name-");
						String doctor_name = input.next();
						Doctor_CRUD_Operations.search_Doctor(doctor_name);
						break;
					}
					case 5: {
						System.out.println("Enter Doctor Id");
						int doctor_Id = input.nextInt();
						Doctor_CRUD_Operations.delete_Doctor(doctor_Id);
						break;
					}
					default:
						System.out.println(" You Have Enter Wrong Choice!!!");
					}
					System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
					s1 = input.nextInt();
				}
				break;
			}

			case 2: {
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("                     *PATIENT SECTION*");
				System.out.println("--------------------------------------------------------------------------------");
				s2 = 1;
				while (s2 == 1) {
					System.out.println(
							"1.Add New Entry\n2.Existing Patients List\n3.Update Patient details \n4.Search Patient \n5.Delete Patient Details");
					c1 = input.nextInt();
					switch (c1) {

					case 1: {

						// 1. add new entry

						System.out.print("Enter Patient Name: ");
						String patient_name = input.next();
						System.out.print("Enter Disease: ");
						String disease = input.next();
						System.out.print("Enter Sex: ");
						String sex = input.next();
						System.out.print("Enter Admit status: ");
						String admit_status = input.next();
						System.out.print("Enter Age: ");
						int age = input.nextInt();

						// creating object using Patient class
						Patient patient = new Patient(patient_name, disease, sex, admit_status, age);
						Patient_CRUD_Operations.addNewEntry(patient);
						break;

					}
					case 2: {
						// existing patient list
						Patient_CRUD_Operations.existingPatientList();
						break;
					}
					case 3: {
						// updatePatientDetails
						System.out.print("Enter Patient id: ");
						int patient_id = input.nextInt();
						System.out.print("Enter Patient Name: ");
						String patient_name = input.next();
						System.out.print("Enter Disease: ");
						String disease = input.next();
						System.out.print("Enter Sex: ");
						String sex = input.next();
						System.out.print("Enter Admit status: ");
						String admit_status = input.next();
						System.out.print("Enter Age: ");
						int age = input.nextInt();

						Patient patient = new Patient(patient_name, disease, sex, admit_status, age);
						Patient_CRUD_Operations.updatePatientDetails(patient, patient_id);
						break;

					}

					// search patient
					case 4: {
						System.out.print("Enter Patient id to search: ");
						int patient_id = input.nextInt();
						Patient_CRUD_Operations.searchPatient(patient_id);
						break;
					}
					// delete patient
					case 5: {
						System.out.println("Enter Patient id to delete:");
						int patient_id = input.nextInt();
						Patient_CRUD_Operations.deletePatientDetails(patient_id);
						break;
					}
					default:
						System.out.println(" You Have Enter Wrong Choice!!!");
					}
					System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
					s2 = input.nextInt();
				}
				break;
			}

			case 3: {
				s3 = 1;
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("                            *MEDICINE SECTION*");
				System.out.println("--------------------------------------------------------------------------------");
				while (s3 == 1) {
					System.out.println(
							"\n1.Add New Medicine \n2.Existing Medicine List \n3.Update Medicine \n4.Search Medicine \n5.Delete Medicine");
					c1 = input.nextInt();

					switch (c1) {

					case 1: {
						System.out.print("Enter Medicine Name: ");
						String med_name = input.next();
						System.out.print("Enter Medicine Company: ");
						String med_comp = input.next();
						System.out.print("Enter Expiry Date as YYYY-MM-DD: ");
						String exp_date = input.next();
						System.out.print("Enter Medicine Cost: ");
						float med_cost = input.nextFloat();
						System.out.print("Enter Medicine Count: ");
						int med_count = input.nextInt();

						Medicine medicines = new Medicine(med_name, med_comp, exp_date, med_count, med_cost);
						Medicines_CRUD_Operations.addMedicine(medicines);

						break;

					}

					case 2: {
						Medicines_CRUD_Operations.allMedicines();
						break;
					}

					case 3: {
						System.out.print("Enter Medicine Id: ");
						int id = input.nextInt();
						System.out.print("Enter Medicine Name: ");
						String med_name = input.next();
						System.out.print("Enter Medicine Company: ");
						String med_comp = input.next();
						System.out.print("Enter Expiry Date as YYYY-MM-DD: ");
						String exp_date = input.next();
						System.out.print("Enter Medicine Cost: ");
						float med_cost = input.nextFloat();
						System.out.print("Enter Medicine Count: ");
						int med_count = input.nextInt();

						Medicine medicines = new Medicine(med_name, med_comp, exp_date, med_count, med_cost);
						Medicines_CRUD_Operations.updateMedicine(medicines, id);
						break;
					}

					case 4: {
						System.out.print("Enter Medicine Name: ");
						String med_nam = input.next();
						Medicines_CRUD_Operations.searchMedicine(med_nam);
						break;
					}

					case 5: {
						System.out.print("Enter Medicine Id: ");
						int med_id = input.nextInt();
						Medicines_CRUD_Operations.deleteMedicine(med_id);
						break;
					}
					default:
						System.out.println(" You Have Enter Wrong Choice!!!");
					}

					System.out.println("\nTo return back Press 1 and for Main Menu Press 0");
					s3 = input.nextInt();
				}
				break;
			}

			case 4: {
				s4 = 1;
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("                    *LABORATORY SECTION*");
				System.out.println("--------------------------------------------------------------------------------");
				while (s4 == 1) {
					System.out.println(
							"1.Add New Lab Test \n2.Existing Lab Tests List \n3.Update Lab Test \n4.Search Lab Test \n5.Delete Lab Test");
					c1 = input.nextInt();
					switch (c1) {
					case 1: {

						System.out.print("Enter Lab Test Name-");
						String lab_test_name = input.next();
						System.out.print("Enter Lab Test Cost-");
						double lab_test_cost = input.nextDouble();

						Laboratory lab = new Laboratory(lab_test_name, lab_test_cost);
						Laboratories_CRUD_Operations.addLab(lab);
						break;
					}
					case 2: {
						Laboratories_CRUD_Operations.labTests();
						break;
					}
					case 3: {
						System.out.println("Enter Lab id");
						int lab_id = input.nextInt();
						System.out.print("Enter Lab Test Name-");
						String lab_test_name = input.next();
						System.out.print("Enter Lab Test Cost-");
						double lab_test_cost = input.nextDouble();

						Laboratory lab = new Laboratory(lab_test_name, lab_test_cost);
						Laboratories_CRUD_Operations.updateLab(lab, lab_id);
						break;
					}
					case 4: {
						System.out.print("Enter Lab Test Name-");
						String lab_test_name = input.next();
						Laboratories_CRUD_Operations.searchLab(lab_test_name);
						break;
					}
					case 5: {
						System.out.println("Enter Lab id");
						int lab_id = input.nextInt();
						Laboratories_CRUD_Operations.deleteLab(lab_id);
						break;
					}
					default:
						System.out.println(" You Have Enter Wrong Choice!!!");
					}
					System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
					s4 = input.nextInt();
				}
				break;
			}

			case 5: {
				s5 = 1;
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("                          **HOSPITAL FACILITY SECTION**");
				System.out.println("--------------------------------------------------------------------------------");
				while (s5 == 1) {
					System.out.println(
							"1.Add New Facility \n2.Existing Fecilities List \n3.Update Facility \n4.Search Fa"
							+ "cility \n5.Delete Facility");
					c1 = input.nextInt();
					switch (c1) {
					case 1: {

						System.out.print("Enter Facility Name-");
						String fac_name = input.next();
						System.out.print("Enter Facility Cost-");
						float Fac_cost = input.nextFloat();

						Facility facility = new Facility(fac_name, Fac_cost);
						Facility_CRUD_Operations.addFcaility(facility);
						break;
					}
					case 2: {
						Facility_CRUD_Operations.AllFacility();
						break;
					}
					case 3: {
						System.out.println("Enter Facility id");
						int fac_id = input.nextInt();
						System.out.print("Enter Facility Name-");
						String fac_name = input.next();
						System.out.print("Enter Facility Cost-");
						float Fac_cost = input.nextFloat();

						Facility facility = new Facility(fac_name, Fac_cost);
						Facility_CRUD_Operations.update(facility, fac_id);
						break;
					}
					case 4: {
						System.out.print("Enter Facility Name-");
						String fac_name = input.next();
						Facility_CRUD_Operations.searchFacility(fac_name);
						break;
					}
					case 5: {
						System.out.println("Enter Facility id");
						int fac_id = input.nextInt();
						Facility_CRUD_Operations.deleteFacility(fac_id);
						break;
					}
					default:
						System.out.println(" You Have Enter Wrong Choice!!!");
					}
					System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
					s5 = input.nextInt();
				}
				break;
			}

			case 6: {
				s6 = 1;
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("                               *STAFF SECTION*");
				System.out.println("--------------------------------------------------------------------------------");
				int option;
				while (s6 == 1) {

					System.out.println("1.Add New Staff Member: ");
					System.out.println("2.Show Staff List: ");
					System.out.println("3.Update Staff Details: ");
					System.out.println("4.Remove Staff: ");
					System.out.println("5.Search the Staff Member: ");

					Scanner sc = new Scanner(System.in);
					option = sc.nextInt();

					switch (option) {
					case 1:
						System.out.println("Enter Staff Id, name, " + "Designation, Gender and Salary");

						Staff st = new Staff(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.nextInt());
						Staff_CRUD_Operations.addStaff(st);
						System.out.println("Added Staff with ID: " + st.getStaff_id() + "\n");
						break;

					case 2:
						Staff_CRUD_Operations.staffDetails();
						break;

					case 3:
						System.out.println("Enter staff id ");
						int id = sc.nextInt();
						System.out.println("Enter updated Staff Name, Designation, Gender and Salary ");
						Staff st1 = new Staff(sc.next(), sc.next(), sc.next(), sc.nextInt());
						Staff_CRUD_Operations.update(st1, id);
						break;
					case 4:
						System.out.println("Enter staff id to be deleted");
						int id1 = sc.nextInt();
						Staff_CRUD_Operations.removeStaff(id1);
						break;
					case 5:
						System.out.println("Enter staff name to search");
						String search = sc.next();
						Staff_CRUD_Operations.searchStaff(search);
						break;
					default:
						System.out.println(" You Have Enter Wrong Choice!!!");

					}

					System.out.println("\nTo return back Press 1 and for Main Menu Press 0");
					s6 = input.nextInt();

				}
				break;

			}
			case 7: {
				System.out.println(" Thanks for using Hospital Mangement System!!! ");
				System.exit(0);
				input.close();
			}
			default: {
				System.out.println("You Have Enter Wrong Choice!!!");
			}
			}
			System.out.println("\nReturn to MAIN MENU Press 1");
			status = input.nextInt();
		}
		input.close();

	}

}
