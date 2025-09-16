public class Product{
	//instance variables
	String id;
	String name;
	double price;
	int quantity;
	//class variables, a variable followed by static
	static int counter;

	public Product(String name, double price, int quantity){
		counter++;
		this.id=String.format("p%03d",counter);
		this.name=name;
		this.price=price;
		this.quantity=quantity;
	}

	public Product(String id, String name, double price, int quantity){
		this.id=id;
		this.name=name;
		this.price=price;
		this.quantity=quantity;
	}
	// copy constructor
	Product(Product p){
		this.id=p.getId();
		this.name=p.name;
		
	}


	public void setName(String name){
		this.name=name;
	}


	public String getId(){
		return id;
	}
	public String getName(){
		return name;
	}

	// super type is available named as Object which can hold any type of object
/*	public boolean equals(Object other){

		Product p=(Product)other;
		String tempName=p.getName();
		boolean b=this.name.equals(tempName);
		
		return b;
	} */
	
	public boolean equals(Object o){
		//Product p=(Product)o;
		return this.name.equals(((Product)o).getName());
	}


	//public String toString(){

	//	String temp=String.format("%-5s %-20s %,.2f %d",id,name,price,quantity);
	//	return temp;
	//}

	// automatically called where string representation of object is required
	public String toString(){
		return String.format("%-5s %-20s %,.2f %d",id,name,price,quantity);
	}

	public Product getAddress(){
		return this;
	}



}