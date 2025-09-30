package org.example;

public class Seat{


	String id;
	String seatType;
	double price;
	boolean isAvailable;



	Seat(){

	}
	Seat(int row, int col, double price){
		id=String.format("%d-%03d",row,col);
		this.price=price;
	}

	public String toString(){

		return String.format("%s %s %.2f %b",id,seatType,price,isAvailable);
	}


}