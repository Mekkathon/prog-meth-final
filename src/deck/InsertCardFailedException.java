package deck;

public class InsertCardFailedException extends Exception {
	public String message;
	public InsertCardFailedException() {
		super();
	}
	public InsertCardFailedException(String e) {
		this.message = e;
	}
}
