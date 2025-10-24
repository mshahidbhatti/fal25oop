public class Rectangle{

	int height;
	int width;

	Rectangle(){
		height=10;
		width=10;

	}

	Rectangle(int h, int w){
		height=h;
		width=w;
	}

	public int calArea(){
		return height*width;
	}

	@Override
	public String toString(){
		return String.format("height %d, width %d",this.height, width);
	}


}