package dev.developer.models;

import java.util.Scanner;

public class Customer {

	
    private Integer id;
    String Name ;
    String userName;
    String passWord;
    private Integer accountNumber;
    private double deposit;
    private double balance;
    private double withdrawl;
	//public String uName;
	//public String uPass;
    
    
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(Integer id, String name, String userName, String passWord, Integer accountNumber, double deposit,
			double balance, double withdrawl) {
		super();
		Name = name;
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.accountNumber = accountNumber;
		this.deposit = deposit;
		this.balance = balance;
		this.withdrawl = withdrawl;
	}


	
	public Customer(String name, String userName, String passWord, Integer accountNumber, double deposit,
			double balance, double withdrawl) {
		super();
		Name = name;
		this.userName = userName;
		this.passWord = passWord;
		this.accountNumber = accountNumber;
		this.deposit = deposit;
		this.balance = balance;
		this.withdrawl = withdrawl;
	}

	public Customer(Integer id, String name) {
		super();
		this.id = id;
		Name = name;
	}
	

	public Customer(String name, String userName, String passWord, double deposit) {
		super();
		Name = name;
		this.userName = userName;
		this.passWord = passWord;
		this.deposit = deposit;
	}


	public Customer(String userName, String passWord, double deposit) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.deposit = deposit;
	}


	public Customer(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}


	public String getName() {
		return Name;
	}


	


	public void setName(String name) {
		Name = name;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public Customer(Integer id, String name, String userName, String passWord) {
		super();
		this.id = id;
		Name = name;
		this.userName = userName;
		this.passWord = passWord;
	}


	public Integer getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}


	public double getDeposit() {
		return deposit;
	}


	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public double getWithdrawl() {
		return withdrawl;
	}


	public void setWithdrawl(double withdrawl) {
		this.withdrawl = withdrawl;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", Name=" + Name + ", userName=" + userName + ", passWord=" + passWord
				+ ", accountNumber=" + accountNumber + ", deposit=" + deposit + ", balance=" + balance + ", withdrawl="
				+ withdrawl + "]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


//	public String getuName() {
//		return uName;
//	}


//	public void setuName(String uName) {
//		this.uName = uName;
//	}
//
//
//	public String getuPass() {
//		return uPass;
//	}
//
//
//	public void setuPass(String uPass) {
//		this.uPass = uPass;
//	}


	


//	public static Customer openRegister(String valueName, String valuePassword) {
//		// TODO Auto-generated method stub
//		System.out.println("enter username");
//		Scanner registerId = new Scanner(System.in);
//		String uName = registerId.nextLine();
//		
//		System.out.println("enter Password");
//	    String uPass = registerId.nextLine();
//		
//		return new  Customer(uName, uPass);
//	}
//public static Customer  openRegister(String userName, String userPassword) {
//		
//		System.out.println("enter username");
//		Scanner registerId = new Scanner(System.in);
//		String uName = registerId.nextLine();
//		String uPass = registerId.nextLine();
//		
//		return new  Customer (uName, uPass);
//		String valueName, String valuePassword
//	}     


//	public void openRegister1(String string, String string2) {
//		// TODO Auto-generated method stub
//		
//	}


	
    
    
	
	
	
	
	
}
