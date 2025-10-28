public class Circle{
	double radius;
	Circle(double radius){
		if(radius<0)
			throw new MyException("Invalid input");
		this.radius=radius;
	}


}