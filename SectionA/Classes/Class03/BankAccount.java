public class BankAccount{
	String title;
	private double balance;

	public void deposit(double amount){
		if(amount>0)
			balance =balance +amount;
	}
	public void display(){
		System.out.println("Account Title:"+title);
		System.out.println("Account Balance:"+balance);

	}

	public void setTitle(String newTitle){
		title=newTitle;
	}

	public double withdraw(double withdrawAmount){
		if(withdrawAmount<=balance)
			balance=balance-withdrawAmount;


	}


}