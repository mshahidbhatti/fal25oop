public class Demo{

	public static void main(String args[]){

		Vehicle v1;  
		v1=new FourWheelVehicle();
		v1.drive();
		v1=new TwoWheelVehicle();
		v1.drive();
		v1.displayChasis();

		v1.vehicleCounter();

		FourWheelVehicle v2=new FourWheelVehicle();
		v2.vehicleCounter();

		System.out.println(v1.a); // print 5
		System.out.println(v2.a); // print 10

		System.out.println(v1.counter); // print 0
		System.out.println(v2.counter); // print 11

	}


}