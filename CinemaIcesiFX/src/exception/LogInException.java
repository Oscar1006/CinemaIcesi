package exception;

public class LogInException extends Exception {

	@Override
	public String getMessage() {
		return "Incorrect Id. This id has not been registered previously";
	}

}
