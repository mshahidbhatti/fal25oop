public class StaticADeeperLook{
	static int x=20;

	{

		for(int i=0;i<10;i++)
			System.out.println(i);
	}
	{
	x=x+10;
	System.out.println("Orphan statement in code block 1");
	}
	static{
	System.out.println("Orphan static statement in code block 1");
	}
	StaticADeeperLook(){
		System.out.println("Constructor of StaticADeeperLook invoked");
	}
	{
	System.out.println("Orphan statement in code block 2");
	}

	public static void printSomething(){
		System.out.println(" print things==>" + x);

	}


}