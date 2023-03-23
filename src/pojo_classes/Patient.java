package pojo_classes;

public class Patient {

	private String patient_name, disease, sex, admit_status;
	private int age;

	// default constructor

	public Patient() {
		super();
	}

	// parameterizes constructor

	public Patient(String patient_name, String disease, String sex, String admit_status, int age) {
		super();
		this.patient_name = patient_name;
		this.disease = disease;
		this.sex = sex;
		this.admit_status = admit_status;
		this.age = age;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAdmit_status() {
		return admit_status;
	}

	public void setAdmit_status(String admit_status) {
		this.admit_status = admit_status;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

//	@Override
//		public String toString() {
//			return "Patient [patient_name=" + patient_name + ", disease=" + disease + ", sex=" + sex + ", admit_status="
//					+ admit_status + ", age=" + age + "]";
//		}

}
