public class ShapeTest{

	public static void main(String args[]){
		Shape shape=new Shape("Raw Shape");

		System.out.println(shape.equals(shape));

		Shape2D shape2d=new Shape2D();
		Shape3D shape3d=new Shape3D();

		Circle c1=new Circle();
		Shape shape2=(Shape)shape.clone();
		System.out.println();

		System.out.println(shape);
		System.gc();

		System.out.println(shape2d);
		System.out.println(shape3d);



	}


}