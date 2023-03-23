package pojo_classes;

public class Staff {

	private String staff_name, designation, gender;
	private int salary, staff_id;

	public Staff(int staff_id, String staff_name, String designation, String gender, int salary) {
		super();
		this.staff_name = staff_name;
		this.designation = designation;
		this.gender = gender;
		this.salary = salary;
		this.staff_id = staff_id;
	}

	public Staff(String staff_name, String designation, String gender, int salary) {
		super();
		this.staff_name = staff_name;
		this.designation = designation;
		this.gender = gender;
		this.salary = salary;

	}

	public String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}

}
