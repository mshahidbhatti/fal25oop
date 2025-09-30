public class ArrayDemo{

	public static void main(String args[]){


		//System.out.println("You entered: "+args[0]);

		//System.out.println(args.length);

		int a[]=new int[10];
		System.out.println(a[0]);
		// Reference type array, array of objects
		Seat seats[]=new Seat[10];
		seats[0]=new Seat();
		System.out.println(seats[0].toString());
		
		Seat seatsArray[]={new Seat(),new Seat(), new Seat()};

		// null.toString();

		double d[]={1.0,2.0,3.0};

		int[] x,y=new int[20], z=null;
		System.out.println(z);

		int t, n[], m;
		char ch[]=new char[10];
		System.out.println(ch[0]);
		getSeats(seats);

		displaySeats(seats);

	}
	public static void displaySeats(Seat []seats){
		for(int i=0;i<seats.length;i++)
			System.out.println("=>"+seats[i]);
	}
	public static Seat[] getSeats(Seat []seats){

		for(int i=0;i<seats.length;i++)
		seats[i]=new Seat();

		return seats;
	}
}