package exception;

public class LogInException extends Exception {

	private static final long serialVersionUID = 1L;
	@Override
	public String getMessage() {
		return "Incorrect Id. This id has not been registred previously";
	}

}
