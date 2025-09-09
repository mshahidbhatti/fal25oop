public class Time{

	private int seconds;
	private int minutes;
	private int hours;
	Time(Time t){
		this(t.getSeconds(),0,0); // call to three argument const
		//this.seconds=t.getSeconds();
		System.out.println("b");
		
		
	}
	Time(){}
	public Time(int seconds, int minutes, int hours){
		System.out.println("a");
		setSeconds(seconds);
		this.minutes=minutes;
		this.hours=hours;
	}

	public void setSeconds(int seconds){
		if(seconds>=0&&seconds<60)
			this.seconds=seconds;
		
	}
	public int getSeconds(){
		return seconds;
	}

	public void display(){

		System.out.println("Seconds:"+getSeconds());
	}


}