public class FourWheelVehicle extends Vehicle{

	int a=10;

	static int counter=11;


	@Override
	public void drive(){
		System.out.println("drive method of FourWheelVehicle");
	}

	public static void vehicleCounter(){
	System.out.println("Vehicle counter is called from FourWheelVehicle"+Vehicle.counter);

	}




}