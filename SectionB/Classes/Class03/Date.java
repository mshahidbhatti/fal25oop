public class Date{

	private int day;
	private int month;
	private int year;

	public void setDay(int newDay){
		if(newDay>=1&&newDay<=30)
			day=newDay;
	}
	public void setMonth(int newMonth){
		if(newMonth>=1&&newMonth<=12)
			month=newMonth;
	}
	public void setYear(int newYear){
		if(newYear>=1)
			year=newYear;
	}	

	public int getDay(){
		return day;
	}
	public int getMonth(){
		return month;
	}
	public int getYear(){
		return year;
	}


	public boolean isEqual(Date anotherDate){
		return false;
	}


	public void displayDate(){
		System.out.printf("%02d-%02d-%04d\n",day,month,year);
	}
}