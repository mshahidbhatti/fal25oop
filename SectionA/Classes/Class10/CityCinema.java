public class CityCinema{


	String city;
	Cinema cinemas[];


	CityCinema(String cityName, int n){
		this.city=cityName;
		cinemas=new Cinema[n];
		for(int i=0;i<cinemas.length;i++)
			cinemas[i]=new Cinema("Screen "+i,50);
		

	}

	public String toString(){

		StringBuilder str=new StringBuilder();

		str.append(city);
		for(int i=0;i<cinemas.length;i++){
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		str.append("\n"+cinemas[i].toString());
		}
		return str.toString();
	}




}