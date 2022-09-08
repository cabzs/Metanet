package exception;

public class BalanceInstufficientException extends Exception {
	public BalanceInstufficientException () {}
	
	public BalanceInstufficientException(String message) {
		super(message);
	}
}
