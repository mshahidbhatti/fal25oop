public class Screen{

		Seat [][]seats;
		String screenName;
		
		Screen(String name, int n){
			screenName=name;
			seats=new Seat[10][];
			for(int i=0;i<seats.length;i++){
				seats[i]=new Seat[10+i];
				for(int j=0;j<seats[i].length;j++)
					seats[i][j]=new Seat(String.format("%d-%03d",i,j),"Standard",500,true);

			}

			

		}
		Screen(){}


	@Override
	public String toString(){
		StringBuilder str=new StringBuilder();
		str.append(screenName);
		for(int i=0;i<seats.length;i++)
			for(int j=0;j<seats[i].length;j++)
				str.append("\n"+seats[i][j].toString());	
		return str.toString();
	}

}