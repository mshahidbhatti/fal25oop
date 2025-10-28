public class MyException extends Exception{

	@Override
	public String getMessage(){

		return "My Custom exception "+ super.getMessage();
	}

}