public class MyException extends IllegalArgumentException{

	MyException(String message){
		super(message);

	}
	@Override
	public String getMessage(){
		return "Custom Exception"+super.getMessage();

	}


}