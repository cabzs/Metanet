package ex0908;

public class Account {
	private long balance;
	
	public Account() {}
	
	public long getBalance() {
		return balance;
	}
	
	public void deposit(int money) {
		balance += money ;
	}
	
	public void withdraw(int money) throws BalanceInstufficientException {
		if(balance < money ) {
			throw new BalanceInstufficientException("잔고 부족:" +(money-balance)+ "모자랍니다");
		}
		
		balance -= money; //예외 발생시 실행 안됨
		
	}

}
