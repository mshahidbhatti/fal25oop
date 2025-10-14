import java.lang.*;
public class Shape extends Object{


	public Shape(){
		super();
		//this();
		System.out.println("Empty argument constructor of Shape");


	}

	@Override
	public Object clone(){
		return this;

	}

 public static void printSomething(String text){
		System.out.println(text);

	}

}