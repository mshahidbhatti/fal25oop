public class DateTest{
	public static void main(String args[]){
		Date d1=new Date(1,2,3);

		Date d3=new Date(3,7,5);

		Date d2=new Date();

		d1.displayDate();

		d1.setMonth(10);

		Date d2=new Date();
		d2.setMonth(11);

		if(d1==d2)
			System.out.println("same");

		else
			System.out.println("Different");


		if(d1.getMonth()>d2.getMonth())
			System.out.println("dfasdf");


		d1.isEqual(d2);


	
	}

}