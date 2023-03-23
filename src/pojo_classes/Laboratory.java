package pojo_classes;

public class Laboratory {

	
	private String labTestName;
	private double labTestCost;

	public Laboratory() {

	}

	public Laboratory(String labTestName, double labTestCost) {
		this.labTestName = labTestName;
		this.labTestCost = labTestCost;
	}

	public String getLabTestName() {
		return labTestName;
	}

	public void setLabTestName(String labTestName) {
		this.labTestName = labTestName;
	}

	public double getLabTestCost() {
		return labTestCost;
	}

	public void setLabTestCost(double labTestCost) {
		this.labTestCost = labTestCost;
	}

//	@Override
//	public String toString() {
//		return "Laboratory [labTestName=" + labTestName + ", labTestCost=" + labTestCost + "]";
//	}

}
