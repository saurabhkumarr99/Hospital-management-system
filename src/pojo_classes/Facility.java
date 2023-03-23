package pojo_classes;

public class Facility {

	private String facility_Name;
	private float facility_cost;

	public String getFacility_Name() {
		return facility_Name;
	}

	public void setFacility_Name(String facility_Name) {
		this.facility_Name = facility_Name;
	}

	public float getFacility_cost() {
		return facility_cost;
	}

	public void setFacility_cost(float facility_cost) {
		this.facility_cost = facility_cost;
	}

	public Facility() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Facility(String facility_Name, float facility_cost) {
		super();
		this.facility_Name = facility_Name;
		this.facility_cost = facility_cost;
	}

	@Override
	public String toString() {
		return "Facility [facility_Name=" + facility_Name + ", facility_cost=" + facility_cost + "]";
	}

}
