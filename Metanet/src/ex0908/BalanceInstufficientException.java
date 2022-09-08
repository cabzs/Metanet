package ex0908;

public class BalanceInstufficientException extends Exception {
	
	public BalanceInstufficientException () {}
	
	public BalanceInstufficientException(String message) {
		super(message);
	}

}
