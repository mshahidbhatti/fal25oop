public class Init{


public static Person persons[]=new Person[100];
	static{

		persons[0]=new Person("Person 1","person@email.com");
		persons[1]=new Employee("Person 1","person@email.com","12321");
		persons[2]=new RegularEmployee("Person 3","person@email.com","12321",30000,0.5);
		persons[3]=new ContractEmployee("Employee 3","person@email.com","12321",40000);
		persons[4]=new ContractCommissionEmployee("Employee 3","person@email.com","12321",40000, 100000, 0.3);
		persons[5]=new HourlyEmployee("Employee 5","person@email.com","12321", 40, 10);
	}



	public static void printSalaries(Person persons[]){

	for(int i=0;i<persons.length;i++)
			if(persons[i]!=null)
			if(persons[i] instanceof Employee){
				Employee emp=(Employee)persons[i];
				System.out.println(emp.calSalary());
			}
	}

	public static void printList(Person persons[]){

		for(int i=0;i<persons.length;i++)
			if(persons[i]!=null)
			System.out.println(persons[i].toString());
	}


	public static void increaseHouseRent(Person persons[]){

		for(int i=0;i<persons.length;i++)
				if(persons[i]!=null)
					if(persons[i] instanceof RegularEmployee){
						RegularEmployee emp=(RegularEmployee)persons[i];

					double hr= emp.houseRent+emp.houseRent*.01;
					emp.houseRent=hr;
				}
		}





}