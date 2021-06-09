package dev.developer.utils;

import java.util.ArrayList;
import java.util.List;

import dev.developer.models.Account;
import dev.developer.models.Customer;
import dev.developer.models.Employee;
import dev.developer.models.Users;

public class MockDB {
   
	public static List<Customer>  cust = new ArrayList<Customer>();
	public static List<Account>  acct = new ArrayList<Account>();
	public static List<Employee>  emp = new ArrayList<Employee>();
	public static List<Users> usr = new ArrayList<Users>();
	
	// making a mock data base 
	static {
		//public Customer(String name, String userName, String passWord, Integer accountNumber, double deposit,
	//			double balance, double withdrawl)
		Customer c1 = new Customer(1,"Ram", "ram1", "oo7", 1001, 1000,1000,0);
		cust.add(c1);
		
		//second way to add in cust List object
		cust.add(new Customer(2,"sam", "sam1", "oo8", 1002, 900,900,0));
		cust.add(new Customer(3,"tom", "tomm1", "oo9", 1003, 800,800,0));
		
	// adding account object in List  public Account(Integer id, String name, double balance, double withDrew, double deposit)
		acct.add(new Account(1, "Ram",1000,0,1000));
		acct.add(new Account(2, "sam",900,100,50));
		acct.add(new Account(3, "kam",500,25,20));
	
	// adding employye object in List public Employee(Integer id, String name)
		emp.add(new Employee(1, "David"));
		emp.add(new Employee(2, "savita"));
		emp.add(new Employee(3, "kabita"));


		
	// adding User object in List public Users(Integer id, String userName, String passWord, List<Customer> customers, List<Employee> employee)
		
//		usr.add(new Users(1,"ram1","007",null,null));
//		usr.add(new Users(2,"dam","010", null,null));
//		usr.add(new Users(3,"pam","006", null,null));
//		
	
	
	}

	
	
	
}
