public class Demo{

public static void main(String args[]){
	B obj=new B();
	System.out.println(obj.a);
	System.out.println(obj.b);


	A objA=new B();
	System.out.println(((B)objA).b);

}


}