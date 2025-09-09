class Person{
	String name;
	String email;
	Person(String name, String email){
		System.out.println("Constructor is called");
		name=name;
		email=email;
	}
	void Person(String name, String email){
		System.out.println("method is called");
		name=name;
		email=email;
	}
}
public class Test{
public static void main(String args[]){
	(new Person("name","email")).Person("a","a");

	Person p=new Person("name","email");
	System.out.println(p);
	p.Person("a","c");
}

}