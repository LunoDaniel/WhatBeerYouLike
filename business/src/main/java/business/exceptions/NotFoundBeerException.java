package business.exceptions;

public class NotFoundBeerException extends Exception {
	private static final long serialVersionUID = -7246536095726280034L;
	private final String message;

	public NotFoundBeerException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
