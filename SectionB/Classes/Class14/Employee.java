public class Employee extends Person{

	String ssn;

	Employee(String name, String email, String ssn){
		super(name, email);
		this.ssn=ssn;

	}
	public String toString(){

		return String.format("%s %s",super.toString(),ssn);
	}

	public double calSalary(){
		return 0;	
	}

}