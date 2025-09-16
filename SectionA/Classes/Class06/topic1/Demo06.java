public class Demo06{

	public static void main(String args[]){

		//StaticADeeperLook.printSomething();

		StaticADeeperLook s1=new StaticADeeperLook();
		


		System.out.println(StaticTest.PI);

		System.out.println("Sum of two numbers:"+StaticTest.sum(4,5));


		int counter=0;
		Product p1=new Product("Laptop",100000,5);
		counter++;
		Product p2=new Product("Tablet",100000,5);


		Product p3=new Product("Phone",100000,5);
		System.out.println(p1);
		System.out.println(p2);

		System.out.println(p3);



	}

}