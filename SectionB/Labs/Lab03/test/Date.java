public class Date{
	int day;
	int month;
	int year;
	

	public Date(int d, int m, int y){
		this.day=d;
		this.month=m;
		this.year=y;

	}

	@Override
	public String toString(){

		return String.format("%02d-%02d-%d",day,month,year);
	}


}