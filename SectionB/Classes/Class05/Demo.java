public class Demo{

	public static void main(String args[]){
		Product p0=new Product("001","Keyboard",400,3);
		Product p1=new Product("001","Keyboard",400,3);
		Product p2=new Product("002","Cable",5000,3);
		//p1==p2

		Product p3=p2;

		System.out.println(p1);

		System.out.println(p2);

		if(p2==p3)
			System.out.println("Objects are equal");


		p2.setName("LCD");
		System.out.println("======");
		System.out.println(p2);
		System.out.println(p3);

Product p4 =new Product(p2.getId(),p2.getName(),p2.getPrice(),p2.getQuantity());
	

		Product p5=new Product(p2);
		

		if(p0.equals(p1))
			System.out.println("=====>objects are equal");

		



	}

}