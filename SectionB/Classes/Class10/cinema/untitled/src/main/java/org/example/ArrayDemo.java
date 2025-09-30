package org.example;

public class ArrayDemo{

	public static void main(String args[]){
//		System.out.println(args[0]);
//		System.out.println(args.length);


		int a[]=new int[10];
		int [] b,c,d;

		int m,n[]=new int[4],o;

		int t[]={1,2,3,4};


		String str[]=new String[30];
		String str2[]={null,null,null,"abc","adfdsa"};
		System.out.println(str2.length);
		Seat seats[]=new Seat[50];

	Seat seats2[]={new Seat(),new Seat(),new Seat(),new Seat(), null};
		ArrayDemo d1=new ArrayDemo();
		d1.displayArray(seats2);
		Seat[] ss=d1.getArray();

		d1.initSeats(seats2);
	}

	public void displayArray(Seat seats[]){
		for(Seat s:seats)
			System.out.println(s);

	}

	public Seat[] getArray(){

		return null;
	}


	public Seat[] initSeats(Seat seats[]){
		for(Seat s:seats) 
			s=new Seat();
		return seats;
	}


}