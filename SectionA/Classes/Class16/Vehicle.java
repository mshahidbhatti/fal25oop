public abstract class Vehicle{
	String name;
	String maker;
	
	String a;
	String chasisNo="asdfdsaf";


	public abstract void drive();

	public static void vehicleCounter(){

		System.out.println("static method of vehicle");
	}

	public final void displayChasis(){
		System.out.println(chasisNo);
	}

	public String toString(){

		return "";
	}


}