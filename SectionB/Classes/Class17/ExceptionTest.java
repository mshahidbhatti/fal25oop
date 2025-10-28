import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class ExceptionTest{

	public static void main(String arg[]){

		System.out.println("Welcome to our software");
		Scanner sc=new Scanner(System.in);

		int a=10;
		// Exception handling

		try{
			int b=sc.nextInt();

			System.out.println(a/b);

			int array[]={1,2,3};
			System.out.println(array[b]);
			
			throw new MyException();

		}
		catch(ArithmeticException | ArrayIndexOutOfBoundsException e){
			System.out.println("exception occured:"+e.getMessage());

		}

		catch(InputMismatchException e){
			System.out.println(e.getMessage());

		}
		catch(RuntimeException e){

		}
		catch(MyException e){
			System.out.println("Exception :"+e.getMessage());

		}

		catch(Exception e){
			System.out.println("Exception :"+e.getMessage());

		}
		catch(Throwable e){

		}

		finally{
			System.out.println("finally block executed");
		}




		

		
		System.out.println("Thank you!");

	}


	public static void readText(){
		try{
			FileWriter fw=new FileWriter(new File("afd.txt"));
		}
		catch(IOException e){

		}

	}
	public static void readText(File f)throws IOException{

			FileWriter fw=new FileWriter(f);

	}

}