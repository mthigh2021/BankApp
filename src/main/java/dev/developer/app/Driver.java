package dev.developer.app;

import java.util.List;
import java.util.Scanner;
//import java.util.ArrayList;
import dev.developer.models.Customer;
import dev.developer.models.Employee;
import dev.developer.models.Users;
import dev.developer.repositories.AccountDAO;
import dev.developer.repositories.CustomerDAO;
import dev.developer.repositories.EmployeeDAO;
import dev.developer.repositories.UsersDAO;
import dev.developer.models.Account;

public class Driver {

	public static void main(String[] args) {  
		CustomerDAO cstmer = new CustomerDAO();
		List<Customer> customer = cstmer.getAll();

		EmployeeDAO emply = new EmployeeDAO();
		List<Employee> employee = emply.getAll();

		//CustomerDAO cstmer1 = new CustomerDAO();

		// List<Customer> customerADD = cstmer1.add();

		System.out.println("welcome to the banking app");
		Scanner  input = new  Scanner(System.in);
		while(true) {

			System.out.println("pick option");
			System.out.println("1.Register");
			System.out.println("2.Login");
			System.out.println("3.Check balance");
			System.out.println("4.To see add functionality of database");
			System.out.println("5.To perform a transfer");
			System.out.println("6.To perform a transfer");


			System.out.println("7.Exit");
			int value = input.nextInt();
			if(value == 1 ) {
				System.out.println("To register as employee choose 1:  To register as customer choose 2:"); 
				int register = input.nextInt();
				switch (register){

				case 1:
					System.out.println("Enter Employee name");
					String empRegName = input.next();

					System.out.println("Enter username");
					String empRegUn = input.next();

					System.out.println("enter password");
					String empRegPw = input.next();

					System.out.println("enter Title");
					String empRegTl = input.next();

					System.out.println("YOU ARE LOGGED IN AS EMPLOYEE");



					///IT is not hitting the databse Need to figure it out later  // fixed  
					Employee e = new Employee(empRegName, empRegUn, empRegPw,empRegTl );
					System.out.println(e.toString());
					emply.registerNew(e);
					System.out.println("YOU ARE added   AS new Employee");



					//				     boolean result = EmployeeDAO.registerNew(e);				     
					//        		     if (result = true ) {
					//					  System.out.println("Employee added sucessfully");
					//					  }else {
					//						  System.out.println("something went wrong");
					//					      }
					//						  
					//				        System.out.println(e);
					//				

					break;
				case 2:
					System.out.println("Enter Customer name");
					String cusRegName = input.next();

					System.out.println("Enter username");
					String cusRegUn = input.next();

					System.out.println("enter password");
					String cusRegPw = input.next();

					System.out.println("enter the amount Deposit to open account");
					double startDepo = input.nextDouble();

					///IT is not hitting the database Need to figure it out later  // Fixed


					Customer c = new Customer(cusRegName,cusRegUn, cusRegPw, startDepo);
					System.out.println(c.toString());
					cstmer.registerNew(c);
					System.out.println("YOU ARE added   AS new Customer");
					break; 

					//				     boolean answer = customer.registerNewCustomer(c);
					//        		     if (answer = true ) {
					//					  System.out.println("customer added sucessfully");
					//					  }else {
					//						  System.out.println("something went wrong");
					//					      }
					//						  
					//				        System.out.println(c);


				}


			}else if(value == 2) //////Login Functionality starts from here 
			{
				//login
				System.out.println("employee choose 1: customer choose 2:"); 
				int option2 = input.nextInt();
				switch (option2){

				case 1:
					System.out.println("Enter username");
					String unEmp = input.next();

					System.out.println("enter password");
					String upEmpPW = input.next();

					System.out.println("YOU ARE LOGGED IN AS EMPLOYEE");


					Employee logEmp = emply.getByPassword(upEmpPW);
					Employee  logEmp1 = new Employee(unEmp, upEmpPW);

					System.out.println(logEmp1.toString());
					emply.getByPassword(upEmpPW);  //// giving me null values not hitting the database 

					// System.out.println(addedCust.toString());
					// cstmer.add(addedCust)

					//  boolean result1 = EmployeeDAO.registerNew(e);

					//				     
					//        		     if (result1 = true ) {
					//					  System.out.println("Employee login sucessfully");
					//					  }else {
					//						  System.out.println("something went wrong");
					//					      }
					//						  
					//				        System.out.println(e);
					//					   
					break;

				case 2:
					System.out.println("Enter username");
					String unCus= input.next();
					System.out.println("enter password");
					String pwCus= input.next();


					Customer logCus = cstmer.getByPassword(pwCus);
					Customer  logCus1 = new Customer(unCus, pwCus);

					System.out.println(logCus1.toString());
					cstmer.getByPassword(pwCus); //giving me null values not hitting the database 

					System.out.println("YOU ARE LOGGED IN AS Customer");
					break;
				}








			}else if(value == 3) ///CHECK bALANACE FUNCTIONALITY STARTS FROM HERE 
			{
				//check balance
				System.out.println("Enter username");
				String logUsr = input.next();

				System.out.println("enter password");
				String logPass = input.next();

				System.out.println("enter Acc num");
				int logAnum = input.nextInt();
				
                
				Customer dtLoad0 = cstmer.getByAccountID(logAnum);  
				System.out.println(dtLoad0);

				//				 System.out.println("enter id value to check balance ");
				//				 int id = input.nextInt();

				// Customer dtLoad3 = cstmer.getById(id);
				// System.out.println(dtLoad3);

				System.out.println("Congratulation You are sucessfully logeed in:"); 




				//Customer dtLoad0 = cstmer.getSpecificColumnBypassword(logPass);  /// java is pass by value string can't be passed  into a function
				// System.out.println(dtLoad0);
				//  

				System.out.println(" your balance is $$$$$$$"); 
				// Customer dtLoad2 = cstmer.getById(id);
				// System.out.println(dtLoad2);
				Customer dtLoad = cstmer.getById(1);
				System.out.println(dtLoad);
				Customer dtLoad1 = cstmer.getById(2);
				System.out.println(dtLoad1);

			}else if(value == 4) /////PRINTING ALL THE VALUES FROM DATABASE STARTS FROM HERE 
			{
				System.out.println("Enter following info to add a student");
				System.out.println("Enter Name");
				String nmAd= input.next();

				System.out.println("Enter username");
				String unAD = input.next();

				System.out.println("enter password");
				String upAD= input.next();

				System.out.println("enter Account Number");
				int anAd= input.nextInt();

				System.out.println("enter Deposit");
				double dpAdd= input.nextDouble();

				System.out.println("enter balance");
				double balanceAdd= input.nextDouble();

				System.out.println("enter withdrawl");
				double wdlAd= input.nextDouble();

				System.out.println("Thank for the information you!!!");
				// String upCus= input.next();
				Customer addedCust = new Customer(nmAd,unAD,upAD,anAd,dpAdd,balanceAdd,wdlAd);

				System.out.println(addedCust.toString());
				cstmer.add(addedCust);
				System.out.println("YOU ARE added   AS new Customer");

				// **************************to see the values from database*********************************
				//				 CustomerDAO cstmer = new CustomerDAO();
				//				    List<Customer> customer = cstmer.getAll();
				//				    cstmer.getById(1);
				//				    cstmer.getById(2);

				for(Customer c: customer) {
					System.out.println(c);
				}

				//				    EmployeeDAO emply = new EmployeeDAO();
				//				    List<Employee> employee = emply.getAll();
				//emply.getById(1);

				for(Employee e: employee) {
					System.out.println(e);
				}

				AccountDAO accnt = new AccountDAO();
				List<Account> account = accnt.getAll();
				for(Account a: account) {
					System.out.println(a);
				}

				UsersDAO usr = new UsersDAO();
				List<Users> user = usr.getAll();

				for(Users u: user) {
					System.out.println(u);
					//accnt.getById(1)
				}

			}else if (value == 5){



				break;


			}else if (value == 6){

				break;
			}

		}

		System.out.println("Thank you for using application");

		System.out.println("see you soon");
	}


}	 

