public class AdRectangle extends Rectangle{

	String fillColor;

	AdRectangle(){

		fillColor="white";
	}

	AdRectangle(int h, int w, String c){
		super(h,w);
		this.fillColor=c;
	}

	@Override
	public String toString(){
		return String.format("%s, color %s",super.toString(),fillColor);
	}


}