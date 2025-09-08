public class Demo{

	public static void main(String args[]){
		BankAccount bankAccount= new BankAccount();
		bankAccount.display();

		bankAccount.deposit(500);
		System.out.println("New Balance");
		bankAccount.display();


		bankAccount.setTitle("Account 1");
		System.out.println("Updated Title");
		bankAccount.display();

		bankAccount.deposit(-400);
		System.out.println("New Balance");
		bankAccount.display();
		//bankAccount.balance=-300;

		System.out.println("New Balance");
		bankAccount.display();

		

	}



}