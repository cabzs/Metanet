package dto;

import java.time.LocalDate;

public class Member {
	
	private String id; 
	private String pwd; 
	private String name; 
	private String account; 
	private LocalDate date; //가입일
	
	private int balance;
	private String level; //이용자 등급

	public Member(String id, String pwd, String name, String account, LocalDate date, int balance, String level) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.account = account;
		this.date = date;
		this.balance = balance;
		this.level = level;
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
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate now) {
		this.date = now;
	}

	
	
}
