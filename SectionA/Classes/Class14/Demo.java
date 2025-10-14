public class Demo{

	

	public static void main(String args[]){

		
		Init.printSalaries(Init.persons);

		//Init.printList(Init.persons);

		Init.increaseHouseRent(Init.persons);
		Init.printSalaries(Init.persons);

	}


}








/*		Person p1=new Person("Person 1","person@email.com");
		System.out.println(p1);
		Employee e1=new Employee("Person 1","person@email.com","12321");
		System.out.println(e1);
		System.out.println("Salary of Emp 1:"+e1.calSalary());
		RegularEmployee e2=new RegularEmployee("Person 3","person@email.com","12321",30000,0.5);
		System.out.println("Salary of Emp 2:"+e2.calSalary());
		ContractEmployee e3=new ContractEmployee("Employee 3","person@email.com","12321",40000);
		System.out.println(e3);
		System.out.println("Salary of Emp 3:"+e3.calSalary());
ContractCommissionEmployee e4=new ContractCommissionEmployee("Employee 3","person@email.com","12321",40000, 100000, 0.3);
		System.out.println(e4);
		System.out.println("Salary of Emp 4:"+e4.calSalary());
	HourlyEmployee e5=new HourlyEmployee("Employee 5","person@email.com","12321", 40, 10);
		System.out.println(e5);
		System.out.println("Salary of Emp 5:"+e5.calSalary());  */
