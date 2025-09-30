package org.example;

public class Cinema{

	//screen[0].seats[0][0]
	Screen screens[];
	String name;

	Cinema(String name, int n){
		screens=new Screen[n];
		for(int i=0;i<screens.length;i++)
			screens[i]=new Screen();

//		for(Screen s:screens)
//			s=new Screen();

		this.name=name;

	}


	public void display(){

		for(Screen s: screens){
			s.display();
		System.out.println("=========================");
		}


	}





}