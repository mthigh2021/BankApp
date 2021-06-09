package dev.developer.models;

import java.util.List;


public class Users {

	
	private Integer usr_id;
	private Integer cust_id;
	private Integer emp_id;
	private String  userName;
	private String  passWord;
	private String  cust_name;
	private String  emp_name; 
	private String emp_username;
	private String emp_password;
	private int cust_accountnumber;
	private int emp_account;
	
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Users(Integer usr_id, Integer cust_id, Integer emp_id, String userName, String passWord, String cust_name,
			String emp_name, String emp_username, String emp_password, int cust_accountnumber, int emp_account) {
		super();
		this.usr_id = usr_id;
		this.cust_id = cust_id;
		this.emp_id = emp_id;
		this.userName = userName;
		this.passWord = passWord;
		this.cust_name = cust_name;
		this.emp_name = emp_name;
		this.emp_username = emp_username;
		this.emp_password = emp_password;
		this.cust_accountnumber = cust_accountnumber;
		this.emp_account = emp_account;
	}


	public Integer getUsr_id() {
		return usr_id;
	}


	public void setUsr_id(Integer usr_id) {
		this.usr_id = usr_id;
	}


	public Integer getCust_id() {
		return cust_id;
	}


	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}


	public Integer getEmp_id() {
		return emp_id;
	}


	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
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


	public String getCust_name() {
		return cust_name;
	}


	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}


	public String getEmp_name() {
		return emp_name;
	}


	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}


	public String getEmp_username() {
		return emp_username;
	}


	public void setEmp_username(String emp_username) {
		this.emp_username = emp_username;
	}


	public String getEmp_password() {
		return emp_password;
	}


	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}


	public int getCust_accountnumber() {
		return cust_accountnumber;
	}


	public void setCust_accountnumber(int cust_accountnumber) {
		this.cust_accountnumber = cust_accountnumber;
	}


	public int getEmp_account() {
		return emp_account;
	}


	public void setEmp_account(int emp_account) {
		this.emp_account = emp_account;
	}


	@Override
	public String toString() {
		return "Users [usr_id=" + usr_id + ", cust_id=" + cust_id + ", emp_id=" + emp_id + ", userName=" + userName
				+ ", passWord=" + passWord + ", cust_name=" + cust_name + ", emp_name=" + emp_name + ", emp_username="
				+ emp_username + ", emp_password=" + emp_password + ", cust_accountnumber=" + cust_accountnumber
				+ ", emp_account=" + emp_account + "]";
	}
	
	

	
	
	
	
}
