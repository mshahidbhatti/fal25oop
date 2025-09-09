public class BankAccount{

	private String title="Default Title";
	private double balance=100;

	// constructor
	public BankAccount(String t, double b){
		title="Default title";
		balance=100;
	}
	public void deposit(double dAmount){
		if(dAmount>0)
			balance=balance+dAmount;
	}

	public void setTitle(String newTitle){
		if(newTitle!=null)
			title=newTitle;
	}
	public String getTitle(){
		return title;
	}

	public double withdraw(double wAmount){
		if(wAmount<=balance)
			balance=balance-wAmount;
		return balance;	
	}


	public void display(){
		System.out.println("Account Title:"+title);
		System.out.println("Account Balance:"+balance);
	}



}