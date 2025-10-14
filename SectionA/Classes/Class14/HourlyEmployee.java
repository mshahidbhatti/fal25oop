public class HourlyEmployee extends Employee{
	int numOfHours;
	double hourlyWage;

	HourlyEmployee(String name,String email, String ssn, int numOfHours, double hourlyWage){
		super(name, email,ssn);
		this.numOfHours=numOfHours;
		this.hourlyWage=hourlyWage;
	}

	public String toString(){
		return String.format("%s %d %.2f",super.toString(),numOfHours, hourlyWage);
	}

	public double calSalary(){
		return super.calSalary()+numOfHours*hourlyWage;
	}

}