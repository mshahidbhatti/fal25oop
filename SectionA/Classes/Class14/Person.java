public class Person{

	String name;
	String email;

	Person(String name, String email){
		this.name=name;
		this.email=email;

	}

	public String toString(){
		return String.format("%s %s ",name, email);
	}


}