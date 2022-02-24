package exception;

public class FunctionException extends Exception {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Please fill all the fields";
	}

}
