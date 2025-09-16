public class Demo{

	public static void main(String args[]){

		//StaticADeeperLook s1=new StaticADeeperLook();
		
		new StaticADeeperLook();


		System.out.println(Calc.sum(5,6));


		System.out.println(Product.counter);

		Product.staticMethod();

		System.out.println("Product Demo.");

		Product p1=new Product("Product 1",21321,5);
		Product p2=new Product("Product 2",21321,5);

		Product p3=new Product("Product 2",21321,5);
		System.out.println(p1);
		System.out.println(p2);

		System.out.println(p3.counter);

		p3.staticMethod();

		

	}


}