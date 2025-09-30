public class CityCinema{

		Cinema cinema[]=new Cinema[10];
		String cityName;

		CityCinema(String cityName){
			for(int i=0;i<cinema.length;i++)
				cinema[i]=new Cinema("cinema "+i,5);
			this.cityName=cityName;
		}


		@Override
		public String toString(){
			StringBuilder str=new StringBuilder(); 
			str.append(cityName);
			for(int i=0;i<cinema.length;i++){
				str.append("\n "+cinema[i]);
			}
			
			return str.toString();
		}

}