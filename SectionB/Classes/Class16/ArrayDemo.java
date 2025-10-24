public class ArrayDemo{

	public static void main(String args[]){

		Rectangle r1=new Rectangle();

		Rectangle row[]= new Rectangle[10];
		System.out.println(row);
	
		initRects(row);
		
		System.out.println(row[0].height);
		displayRectsArea(row);


		Rectangle recGrid[][] = new Rectangle[10][];
		System.out.println(recGrid);

		initRects(recGrid);
		
		displayRectsArea(recGrid);
		System.out.println(recGrid[5][2]);
		
		Rectangle recGrid1[][] = new AdRectangle[10][];

			initRects(recGrid1);

	}

	public static void initRects(Rectangle [][] recGrid){
		for(int i=0; i<recGrid.length;i++){
			recGrid[i]=new AdRectangle[10];
			initRects(recGrid[i]);
			}
	}


	public static void initRects(Rectangle row[]){
		for(int i=0;i<row.length;i++)
			row[i]=new AdRectangle();

	}

	public static void displayRectsArea(Rectangle recGrid[][]){
		for(int i=0;i<recGrid.length;i++)
			{
			displayRectsArea(recGrid[i]);
			System.out.println();
			}

	}


	public static void displayRectsArea(Rectangle row[]){
		for(int i=0;i<row.length;i++)
			System.out.print(" "+row[i].calArea());

	}

}