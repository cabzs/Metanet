package app;

public class Ex2 {
	
	private String userId;
	private String userPwd;
	private String userName;
	
	private String account; //���¹�ȣ
	private int balance; //�ܰ�
	
	
	public Ex2(String userId, String userPwd, String userName, String account, int balance) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.account = account;
		this.balance = balance;
	}
	
	
	
	public Ex2(String userId, String userPwd, String userName) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
	}


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	

}
