public class Demo{

	public static void main(String args[]){
		BankAccount ba1=new BankAccount();

		ba1.display();

		ba1.deposit(500);
		System.out.println("Display after deposit amount");
		ba1.display();

		ba1.deposit(-200);
		System.out.println("Display after deposit amount");
		ba1.display();

		ba1.setTitle(null);

		
	}
}