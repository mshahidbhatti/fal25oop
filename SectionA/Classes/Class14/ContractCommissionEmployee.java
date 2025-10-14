public class ContractCommissionEmployee extends ContractEmployee{

	double totalSale;
	double commissionRate;

	ContractCommissionEmployee (String name,String email, String ssn,double fixedSalary,double totalSale, double commissionRate){
		super(name, email,ssn, fixedSalary);

		this.totalSale=totalSale;
		this.commissionRate=commissionRate;
	}

	public String toString(){
		return String.format("%s %.2f %.2f",super.toString(), totalSale, commissionRate);
	}

	@Override
	public double calSalary(){
		return super.calSalary()+(commissionRate*totalSale);
	}

}