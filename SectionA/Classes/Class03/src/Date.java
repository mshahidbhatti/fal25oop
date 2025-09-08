public class Date{
	private int day;
	private int month;
	private int year;

	public void setDay(int newDay){
		if(newDay>=1 && newDay<=30)
			day=newDay;
	}
	public void setMonth(int newMonth){
		if(newMonth>=1&&newMonth<=12)
			month=newMonth;

	}



}