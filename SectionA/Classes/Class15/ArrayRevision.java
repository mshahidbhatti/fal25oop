public class ArrayRevision{



	public static void main(String args[]){

		Rectangle r1=new Rectangle();

		Rectangle row[] =new Rectangle[20];
		
		Rectangle rectGrid[][]=new AdRectangle[10][];

		initRectangles(rectGrid);

		initRectangles(rectGrid[0]);


	}



	public static void initRectangles(Rectangle row[]){
		for(int i=0;i<row.length;i++)
			row[i]=new AdRectangle();

	}
	public static void initRectangles(Rectangle grid[][]){
		for(int i=0;i<grid.length;i++){
			grid[i]=new AdRectangle[10];
			 initRectangles(grid[i]);
			}

	}

	public static void displayRectanglesArea(Rectangle row[]){
		for(int i=0;i<row.length;i++)
			System.out.println(row[i].calArea());

	}



}