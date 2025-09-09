class Person{

	String name;
	String email;

	Person(String name, String email){
		System.out.println("Constructor is called");
		name=name;
		email=email;
	}

}
//////
public class Test{
public static void main(String args[]){
	Person p=new Person("name","email");
}

}