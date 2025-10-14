public class RegularEmployee extends Employee{

	double baseSalary;
	double houseRent; 

	RegularEmployee(String name,String email, String ssn, double baseSalary,double houseRent){
		super(name, email,ssn);
		this.baseSalary=baseSalary;
		this.houseRent=houseRent;
	}

	public String toString(){
		return String.format("%s %.2f %.2f",super.toString(), baseSalary, houseRent);
	}

	public double calSalary(){
		return baseSalary+(baseSalary*houseRent);
	}

}