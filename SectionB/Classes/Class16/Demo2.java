public class Demo2{

	public static void main(String args[]){

		Ad2Rectangle rec1=new Ad2Rectangle(10,12,"black",new Point(10,7));
		Ad2Rectangle rec2=new Ad2Rectangle(10,12,"black",new Point(10,7));
		System.out.println(rec2.isIntersect(rec1,rec2));
		System.out.println(rec1);
		//Ad2Rectangle rec2=new Ad2Rectangle();

	}

}