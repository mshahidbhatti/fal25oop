public class ContractCommissionEmployee extends ContractEmployee{

	double commissionRate;
	double totalSale;


	ContractCommissionEmployee(String name, String email, String ssn, double fixedSalary){
		super(name, email,ssn,fixedSalary);
	}

	ContractCommissionEmployee(String name, String email, String ssn, double fixedSalary, double commissionRate, double totalSale){
		super(name, email,ssn,fixedSalary);
		this.fixedSalary=fixedSalary;
		this.commissionRate=commissionRate;
		this.totalSale=totalSale;
	}

	public String toString(){

		return String.format("%s %.2f %.2f",super.toString(),commissionRate,totalSale);
	}

	@Override
	public double calSalary(){

		return fixedSalary+(totalSale*commissionRate);
	}

}