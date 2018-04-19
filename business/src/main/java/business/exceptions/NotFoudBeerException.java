package business.exceptions;

public class NotFoudBeerException extends Exception {
	private static final long serialVersionUID = 1L;
	private final String message;
	
	public NotFoudBeerException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
