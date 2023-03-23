package pojo_classes;

public class Medicine {

	private String MedicineName, MedicineCompany, ExpiryDate;
	private int MedicineCount;
	private float MedicineCost;

	public String getMedicineName() {
		return MedicineName;
	}

	public void setMedicineName(String medicineName) {
		MedicineName = medicineName;
	}

	public String getMedicineCompany() {
		return MedicineCompany;
	}

	public void setMedicineCompany(String medicineCompany) {
		MedicineCompany = medicineCompany;
	}

	public String getExpiryDate() {
		return ExpiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		ExpiryDate = expiryDate;
	}

	public int getMedicineCount() {
		return MedicineCount;
	}

	public void setMedicineCount(int medicineCount) {
		MedicineCount = medicineCount;
	}

	public float getMedicineCost() {
		return MedicineCost;
	}

	public void setMedicineCost(float medicineCost) {
		MedicineCost = medicineCost;
	}

	public Medicine(String medicineName, String medicineCompany, String expiryDate, int medicineCount,
			float medicineCost) {
		super();
		MedicineName = medicineName;
		MedicineCompany = medicineCompany;
		ExpiryDate = expiryDate;
		MedicineCount = medicineCount;
		MedicineCost = medicineCost;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Medicine [MedicineName=");
		builder.append(MedicineName);
		builder.append(", MedicineCompany=");
		builder.append(MedicineCompany);
		builder.append(", ExpiryDate=");
		builder.append(ExpiryDate);
		builder.append(", MedicineCount=");
		builder.append(MedicineCount);
		builder.append(", MedicineCost=");
		builder.append(MedicineCost);
		builder.append("]");
		return builder.toString();
	}



}
