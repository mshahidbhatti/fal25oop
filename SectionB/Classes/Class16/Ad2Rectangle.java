public class Ad2Rectangle extends AdRectangle{

		
	Point topLeftCorner;

	Ad2Rectangle(int h, int w, String c, Point p){
		super(h,w,c);
		topLeftCorner=p;
		
	}


	public boolean isIntersect(Ad2Rectangle rec1,Ad2Rectangle rec2){
		boolean flag=false;
		if(rec1.topLeftCorner.x+rec1.width>=rec2.topLeftCorner.x)
			flag=true;
		return flag;

	}

	@Override
	public String toString(){
		return String.format("%s, %s ", super.toString(),topLeftCorner.toString());
	}


}

class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
	Point( ){
		this.x=5;
		this.y=5;
	}

	@Override
	public String toString(){
		return String.format("x:%d, y:%d",x,y);
	}

}