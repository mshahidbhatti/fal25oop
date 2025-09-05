public class Demo{
public static void main(String args[]){
		// int i = "asdfasdf";

		//Square s;

		Rectangle r; //declaration of object reference
		Circle c; //declaration of object reference


		 r=new Rectangle();
		 c=new Circle();

		System.out.println("Height in rectangle r"+r.height);
		
		r.height=200;
		System.out.println("Height in rectangle r updated:"+r.height);


		r.width=30;
		double area=r.calArea();
		System.out.println("Area of Rectangle:"+area);
		System.out.println("This is circle class");
		System.out.println("Value in Rectanlge:"+r);
		System.out.println("Value in Circke:"+c);

		


	}

}