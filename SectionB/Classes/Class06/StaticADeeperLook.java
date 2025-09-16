public class StaticADeeperLook{

		static final double PI=3.14;
		private int serialId=123213;
		
		{
		System.out.println("Orphan code block 1");
		}

		static{
			System.out.println("Unnamed static code block 1");
		}

		static{
			for(int i=0;i<10;i++)
				System.out.println(i);

		}

		StaticADeeperLook(){
			System.out.println("Constructor invoked");

		}
		{
		System.out.println("Orphan code block 2");
		}		




}