package exception;

public class NullObjectException extends NullPointerException {

//	private String errorMessage;
	
	public NullObjectException(String errorMessage) {
		super(errorMessage);
	}
}
