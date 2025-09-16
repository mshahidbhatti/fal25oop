public class Product{
	//instance variables
	private String id;
	private String name;
	private double price;
	private int quantity;

	//class variable
	static int counter=1;
	Product(String name, double price, int quantity){
		this.id=""+counter++;
		this.name=name;
		this.price=price;
		this.quantity=quantity;
	}


	Product(String id, String name, double price, int quantity){
		this.id=id;
		this.name=name;
		this.price=price;
		this.quantity=quantity;
	}
	// copy constructor
	Product(Product p){
		this.id=p.getId();
		this.name=p.getName();
		this.price=p.getPrice();
		this.quantity=p.getQuantity();

	}


	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public String getId(){
		return id;
	}
	public double getPrice(){
		return price;
	}

	public int getQuantity()
	{
		return quantity;
	}

/*
	public String toString(){
		return id+" "+name+" "+price+" "+quantity;

	} */

	@Override
	public String toString(){
		return String.format("%-4s %-20s %,.2f %d", id,name,price,quantity);
	//	return ""+this;
	} 


	// Object is a super type in java that can hold variable of any object
	@Override
	public boolean equals(Object o){
		Product temp=(Product)o;
		
		return temp.getName().equals(this.name);
	}


	public static void staticMethod(){
		System.out.println("Product.class");
	}





}