public class Circle extends Shape2D{
	double radius;

	Circle(){
		super();
		System.out.println("This is empty constructor of circle");

	}

	Circle(double radius){
			this();
		System.out.println("This is parameterized constructor of circle");
	}


}