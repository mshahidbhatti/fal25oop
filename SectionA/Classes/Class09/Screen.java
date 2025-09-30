public class Screen{

		Seat [][]seats;
		String screenName;
		
		Screen(String name, int n){
			screenName=name;
			seats=new Seat[10][];
			for(int i=0;i<10;i++){
				seats[i]=new Seat[10+i];
				for(int j=0;j<seats[i].length+i;j++)
					seats[i][j]=new Seat();

			}

			

		}

		Screen(){}
}