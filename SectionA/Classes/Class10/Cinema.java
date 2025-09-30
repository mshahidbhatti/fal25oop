public class Cinema{

	String name;
	Screen screens[];


	Cinema(String name, int n){
		this.name=name;
		screens=new Screen[n];
		for(int i=0;i<screens.length;i++)
			screens[i]=new Screen("Screen "+i, 50);

	}


	public String toString(){
		StringBuilder str=new StringBuilder();

		str.append(name);
		for(int i=0;i<screens.length;i++)
		{
		str.append("===============================");
		str.append("\n"+screens[i].toString());
		}
		
		return str.toString();
	}


}