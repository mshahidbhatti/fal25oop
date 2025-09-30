public class Cinema{

	Screen screens[];
	String name;

	Cinema(String name, int n){
		screens=new Screen[n];
		for(int i=0;i<screens.length;i++)
			screens[i]=new Screen();
		this.name=name;
	}


	public void display(){
		for(Screen s: screens){
			s.display();
		System.out.println("=========================");
		}
	}
	@Override
	public String toString(){
		StringBuilder str=new StringBuilder();
		str.append(name);
		for(Screen s:screens)
			str.append(", " +s);
		return str.toString();
	}




}