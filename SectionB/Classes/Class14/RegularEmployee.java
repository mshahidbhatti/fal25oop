public class RegularEmployee extends Employee{

	double baseSalary;
	double medicalAllowance;


	RegularEmployee(String name, String email, String ssn, double baseSalary){
		super(name, email,ssn);
		this.baseSalary=baseSalary;
	}

	RegularEmployee(String name, String email, String ssn, double baseSalary, double medicalAllowance){
		super(name, email,ssn);
		this.baseSalary=baseSalary;
		this.medicalAllowance=medicalAllowance;
	}

	public String toString(){

		return String.format("%s %.2f",super.toString(),baseSalary);
	}


	@Override
	public double calSalary(){

		return baseSalary+(baseSalary*medicalAllowance);
	}

}