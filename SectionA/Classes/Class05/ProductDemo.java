public class ProductDemo{

	public static void main(String args[]){


		Product p1=new Product("001","Keyboard",500,4);
		Product p2=new Product("002","usb",2000,4);
		Product p3=new Product("003","Keyboard",2000,4);

		//Product temp=p1;
		Product temp=new Product(p1);
		if(p1.equals(p2))
			System.out.println("Objects are equal");

		if(p1.equals(p3))
			System.out.println("p1, and p3; Objects are equal");

		System.out.println(p1);
		System.out.println(p2);

		//System.out.println(" "+ p1.getAddress());

		p1.setName("LCD");
		System.out.println("After  changing name");
		System.out.println(p1);
		System.out.println(temp);



	}


}