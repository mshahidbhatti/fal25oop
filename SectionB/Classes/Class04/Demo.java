public class Demo{

	public static void main(String args[]){

		int a;

		System.out.println(a);

		A a1=new A();

		System.out.println(a1.toString());

		a1=new A();

		new BankAccount("Title 1", 3000);
		BankAccount ba1=new BankAccount("Title 2",4000);

		ba1.display();

		ba1.deposit(500);
		System.out.println("Display after deposit amount");
		ba1.display();

		ba1.deposit(-200);
		System.out.println("Display after deposit amount");
		ba1.display();

		ba1.setTitle(null);

		//ba1.BankAccount();

		
	}
}