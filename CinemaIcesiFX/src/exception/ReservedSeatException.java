package exception;

public class ReservedSeatException extends Exception {
	@Override
	public String getMessage() {
		return "This seat had been reserved previously";
	}


}
