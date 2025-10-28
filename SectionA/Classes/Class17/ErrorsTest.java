import java.util.Scanner;  // next
import java.util.InputMismatchException;
import java.io.FileWriter;
import java.io.IOException;

public class ErrorsTest{
	public static void main(String args[]){
		try{
			Circle c1=new Circle(-1);
		}
		catch(MyException e){
			System.out.println(e.getMessage());
		}

		//compulsory or checked or compile time	
		try{
		FileWriter f=new FileWriter("data.txt");
		}
		catch(IOException e){}

		Scanner sc=new Scanner(System.in);

		System.out.println("Welcome to our ERP");
		int a=10;
		try{
			int b=sc.nextInt();
			int array[]={1,2,3};
			System.out.println(array[b]);  //risky
			System.out.println(a/b);  //risky
			throw new Exception();
		}

		catch(ArrayIndexOutOfBoundsException | InputMismatchException e){
			System.out.println("array index error");
		}
		catch(ArithmeticException e){
			System.out.println("Arithmetic :"+e.getMessage());

		}
		catch(RuntimeException e){

		}
		catch(Exception e){
			System.out.println("Exception :"+e.getMessage());

		}		

		catch(Throwable e){

		}
		finally{
			sc.close();
		}
		System.out.println("Thank you for using this ERP");

	}

}