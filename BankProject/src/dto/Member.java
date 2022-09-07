package dto;

public class Member {
	
	private String id; 
	private String pwd; 
	private String name; 
	private String account; 
	private String date; //가입일
	
	private int balance;
	private int point;

	public Member(String id, String pwd, String name, String account, int balance, int point) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.account = account;
		this.balance = balance;
		this.point = point;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}

	
	
}
