public class Demo{

	static Person persons[]=new Person[100];
		static{

		persons[0]=new Person("Person 1", "email@email.com");
		persons[1]=new Employee("Employee 1", "email@email.com","123213");
		persons[2]=new RegularEmployee("Employee 2", "email@email.com","123213",20000);
		persons[3]=new ContractEmployee("Employee 3", "email@email.com","123213",20000);
		persons[4]=new ContractCommissionEmployee("Employee 3", "email@email.com","123213",20000, 0.2,100000);



	}
	public static void main(String args[]){
		/*
		Person p1=new Person("Person 1", "email@email.com");
		System.out.println(p1);
		Employee e1=new Employee("Employee 1", "email@email.com","123213");
		System.out.println(e1);
		RegularEmployee e2=new RegularEmployee("Employee 2", "email@email.com","123213",20000);
		System.out.println(e2);

		ContractEmployee e3=new ContractEmployee("Employee 3", "email@email.com","123213",20000);
		System.out.println(e3);

		RegularEmployee e4=new RegularEmployee("Employee 4", "email@email.com","123213",20000, 0.10);
		System.out.println(e4);
		ContractCommissionEmployee e5=new ContractCommissionEmployee("Employee 3", "email@email.com","123213",20000, 0.2,100000);
		System.out.println(e5);



		System.out.println("Salary of Emp 1:"+ e1.calSalary());
		System.out.println("Salary of Emp 2:"+ e2.calSalary());

		System.out.println("Salary of Emp 3:"+ e3.calSalary());
		System.out.println("Salary of Emp 4:"+ e4.calSalary());
		System.out.println("Salary of Emp 5:"+ e5.calSalary());

		*/


		
		printSalaries(Demo.persons);
		

	}


	public static void printSalaries(Person persons[]){
		for(int i=0;i<persons.length;i++)
			if(persons[i]!=null)
				if(persons[i] instanceof Employee){
					Employee temp=(Employee)persons[i] ;
					System.out.println(temp.calSalary());		

					
				}

	}


}