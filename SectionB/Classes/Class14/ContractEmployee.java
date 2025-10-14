public class ContractEmployee extends Employee{

	double fixedSalary;


	ContractEmployee(String name, String email, String ssn, double fixedSalary){
		super(name, email,ssn);
		this.fixedSalary=fixedSalary;
	}

	public String toString(){

		return String.format("%s %.2f",super.toString(),fixedSalary);
	}

	@Override
	public double calSalary(){

		return fixedSalary;
	}

}