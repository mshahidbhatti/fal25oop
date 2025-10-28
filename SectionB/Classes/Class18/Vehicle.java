public abstract class Vehicle{

	String name;
	String maker;

	static int counter=0;

	String chasis="asdf12312";

	int a=5;

	public static void vehicleCounter(){
		System.out.println("Vehicle counter is called from vehicle");

	}

	public abstract void drive();

	public final void displayChasis(){
		System.out.println(chasis);
	}


}