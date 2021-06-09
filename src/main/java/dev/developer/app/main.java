package dev.developer.app;

import java.util.List;

import dev.developer.models.Account;
import dev.developer.models.Customer;
import dev.developer.models.Employee;
import dev.developer.models.Users;
import dev.developer.repositories.AccountRepositories;
import dev.developer.repositories.CustomerRepositories;
import dev.developer.repositories.EmployeeRepositories;
import dev.developer.repositories.UsersRepositories;



public class main {
	
	public static void main(String[] args) {
		///presenting data from customer mock db
		CustomerRepositories  cr = new CustomerRepositories();
			
		List<Customer>  cust = cr.getAll();
	  
		   for(Customer c: cust) {
			   System.out.println("Customer table data:"); 
			    System.out.println(c);
			   
		   }
	/////presenting data from Acccount mock db
	    
        AccountRepositories ar = new AccountRepositories();
        List<Account>   acct = ar.getAll();
         
        for(Account a:acct) {
        	System.out.println("Account table data:");
        	System.out.println(a);
        }
    ///presenting data from employee mock db     
	    
    EmployeeRepositories er = new EmployeeRepositories();
    List<Employee>  emp = er.getAll();
    
     for(Employee e:emp) {
    	 System.out.println("Employee table data:");
    	 System.out.println(e);
     }
     
     UsersRepositories ur = new UsersRepositories();
     List<Users> usr = ur.getAll();
     
     for(Users u:usr) {
    	 System.out.println("Users table data:");
    	 System.out.println(u);
     }
     
    
	 
// TODO Auto-generated method stub

//		BreedRepository  br = new BreedRepository();
//		List<Breed>  breeds = br.getAll();
//		 
//		for (Breed b: breeds) {
//			 System.out.println(b);
//			 
//		 }
//		 
//		 
//	//System.out.println(	br.getById(1));
//	   Breed newBreed = new Breed("jaguar");
//	   br.add(newBreed);
//	   System.out.println(br.getAll());
		
	}	
	

}
