package org.example;

public class Screen{

		Seat seats[][]=new Seat[5][];

		Screen(){

		for(int i=0;i<seats.length;i++)
			seats[i]=new Seat[10+i];

		for(int i=0;i<seats.length;i++)
			for(int j=0;j<seats[i].length;j++)
				seats[i][j]=new Seat(i,j,500);
	
	}

	public void display(){
		for(Seat[] s: seats)
			for(Seat a: s)
				System.out.println(a);

	}

}