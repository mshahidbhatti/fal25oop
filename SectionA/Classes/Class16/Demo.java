public class Demo{

	public static void main(String args[]){
		Vehicle v1;   //=new Vehicle();


		v1=new FourWheelVehicle();
		v1.drive();

		v1=new TwoWheelVehicle();

		v1.drive();
		v1.displayChasis();

		v1.vehicleCounter();

		TwoWheelVehicle v2=new TwoWheelVehicle();
		v2.vehicleCounter();


	}

}