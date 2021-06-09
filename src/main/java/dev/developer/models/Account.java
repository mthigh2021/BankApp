package dev.developer.models;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Account  {

	
	private Integer id ;
	private String name;
	private int account_number;
    private double balance;
	private double withDrew;
	private double deposit;
	
	

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Account(Integer id, String name, int account_number, double balance, double withDrew, double deposit) {
		super();
		this.id = id;
		this.name = name;
		this.account_number = account_number;
		this.balance = balance;
		this.withDrew = withDrew;
		this.deposit = deposit;
	}



	public Account(Integer id, String name, double balance, double withDrew, double deposit) {
		super();
		this.id = id;
		this.name =name;
		this.balance = balance;
		this.withDrew = withDrew;
		this.deposit = deposit;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getCustomerName() {
		return name;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setCustomerName(String customerName) {
		this.name = name;
	}



	public Integer getAccount_number() {
		return account_number;
	}



	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}



	public double getBalance() {
		return balance;
	}



	public void setBalance(double balance) {
		this.balance = balance;
	}



	public double getWithDrew() {
		return withDrew;
	}



	public void setWithDrew(double withDrew) {
		this.withDrew = withDrew;
	}



	public double getDeposit() {
		return deposit;
	}



	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		temp = Double.doubleToLongBits(deposit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		temp = Double.doubleToLongBits(withDrew);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(deposit) != Double.doubleToLongBits(other.deposit))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(withDrew) != Double.doubleToLongBits(other.withDrew))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Account [id=" + id + ", customerName=" + name + ", balance=" + balance + ", withDrew="
				+ withDrew + ", deposit=" + deposit + "]";
	}



	
}
