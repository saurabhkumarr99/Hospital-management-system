package pojo_classes;

public class Doctor {

	private String doctor_name;
	private String specialist;
	private String timing;
	private String qualification;
	private int room_no;

	public Doctor() {
		super();
	}

	public Doctor(String doctor_name, String specialist, String timing, String qualification, int room_no) {
		super();
		this.doctor_name = doctor_name;
		this.specialist = specialist;
		this.timing = timing;
		this.qualification = qualification;
		this.room_no = room_no;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public int getRoom_no() {
		return room_no;
	}

	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Doctor [doctor_name=");
		builder.append(doctor_name);
		builder.append(", specialist=");
		builder.append(specialist);
		builder.append(", timing=");
		builder.append(timing);
		builder.append(", qualification=");
		builder.append(qualification);
		builder.append(", room_no=");
		builder.append(room_no);
		builder.append("]");
		return builder.toString();
	}



}
