import java.time.LocalDate;
public class Demo{

	public static void main(String args[]){

		A o1=new A(5);
		B o2=new B(5,10);
		C o3=new C();

		A o4=new C(); // implicit upcasting

		System.out.println(o1);
		System.out.println(o2);
		System.out.println(o3);
		System.out.println(((B)o4).b);




		//    public Product(int id, String name, double price, String brand, String description) 

		Product p1=new Product(1,"Keyboard", 1000, "HP", "clicker");
		System.out.println(p1.getDetails());
		Grocery p2=new Grocery(1,"Bread", 1000, "HP", "clicker",LocalDate.now().plusDays(5));
		System.out.println(p2.getDetails());


	}


}