package dev.developer.app;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.selector.BasicContextSelector;

import dev.developer.models.Account;
import dev.developer.models.Customer;
import dev.developer.models.Employee;
import dev.developer.models.Users;
import dev.developer.repositories.AccountDAO;
import dev.developer.repositories.CustomerDAO;
import dev.developer.repositories.EmployeeDAO;
import dev.developer.repositories.UsersDAO;
import dev.developer.utils.JDBCConnection;




public class Driver {
	//public  final Logger logger = LogManager.getLogger(Driver.class);
	public static void main(String[] args) { 
		//	 BasicContextSelector.configure();
		AppLogger.logger.info("Program started");

		CustomerDAO cstmer = new CustomerDAO();
		List<Customer> customer = cstmer.getAll();

		EmployeeDAO emply = new EmployeeDAO();
		List<Employee> employee = emply.getAll();
		
		AccountDAO accnt = new AccountDAO();
		List<Account> account = accnt.getAll();
		
		UsersDAO usr = new UsersDAO();
		List<Users> user = usr.getAll();

		//CustomerDAO cstmer1 = new CustomerDAO();

		// List<Customer> customerADD = cstmer1.add();

		System.out.println("welcome to the banking app");
		Scanner  input = new  Scanner(System.in);
		while(true) {

			System.out.println("pick option");
			System.out.println("1.Register");
			System.out.println("2.Login");
			System.out.println("3.Check balance And transfer functionality");
			System.out.println("4.To see add functionality of database");
			System.out.println("5.To pull  whole Database  data");
			System.out.println("6.Exit");


			//System.out.println("7.Exit");
			int value = input.nextInt();
			AppLogger.logger.info("User Choose a number");
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

					AppLogger.logger.info("Emplyee valued matched");

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

					AppLogger.logger.info("Customer valued matched");

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

					System.out.println("Here is the full database view of your customers");


					for(Customer c: customer) {
						System.out.println(c);
					}

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

					Customer dtLoad0 =cstmer.getSpecificColumnBypassword(pwCus);
					System.out.println(dtLoad0);

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
				System.out.println(" your balance is $$$$$$$"); 
				// Customer dtLoad2 = cstmer.getById(id);
				// System.out.println(dtLoad2);
				Customer dtLoad = cstmer.getById(1);
				System.out.println(dtLoad);
				Customer dtLoad1 = cstmer.getById(2);
				System.out.println(dtLoad1);

				System.out.println("If you want to make transfer enter account number ");
				int transferAccNum = input.nextInt();
				System.out.println("Enter amount");
				int   amtTs = input.nextInt();

				Connection conn1 = JDBCConnection.getConnection();

				//statement object 
				try {
					Statement st = conn1.createStatement();
					conn1.setAutoCommit(false);
					//add the query to batch
					//withdrram from source account and deposit to destination 

					st.addBatch("update customer set balance =balance-"+ amtTs +"where cust_accountnumber="+ logAnum  );
					st.addBatch("update customer set balance=balance+"+amtTs +"where cust_accountnumber="+transferAccNum);

					// execute the batch 
					int res[] = st.executeBatch();
					//perform transaction managemnet 
					boolean flag= false;
					for(int i=0;i < res.length; i++)
					{

						if (res[i]== 0) {
							flag = true;
							break;

						}
					}

					if (flag == true) {
						conn1.rollback(); // if transaction is not transferred sucessfully
						System.out.println("Transaction Not Sucessfully proceed : pick an option again");

					}else {
						conn1.commit();//if transaction is not completed sucessfully
						System.out.println("Transaction is sucessfully Processed");

					}//close the object jdbc
					st.close();
					//conn1.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}



				//Customer dtLoad0 = cstmer.getSpecificColumnBypassword(logPass);  /// java is pass by value string can't be passed  into a function
				// System.out.println(dtLoad0);
				//  

				

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
				AppLogger.logger.info("Customer Adding in progress waiting till dataBase  update");
				// String upCus= input.next();
				Customer addedCust = new Customer(nmAd,unAD,upAD,anAd,dpAdd,balanceAdd,wdlAd);

				System.out.println(addedCust.toString());
				cstmer.add(addedCust);
				System.out.println("YOU ARE added   AS new Customer");
				
				for(Customer c: customer) {
					System.out.println(c);
				}


				
			}else if (value == 5){

				// **************************to see the values from database*********************************
				//				 CustomerDAO cstmer = new CustomerDAO();
				
				AppLogger.logger.info("Here is the Updated dataBase ");
				for(Customer c: customer) {
					System.out.println(c);
				}

			    

				for(Employee e: employee) {
					System.out.println(e);
				}

				
				for(Account a: account) {
					System.out.println(a);
				}

				

				for(Users u: user) {
					System.out.println(u);
					//accnt.getById(1)
				}


				break;


			}else if (value == 6){

				break;
			}

		}

		System.out.println("Thank you for using application");

		System.out.println("see you soon");
	}


}
/*88888888888888888888888888888888888888888888888888888888888888888888888888888END OF PROGRAM BANK 
 * // System.out.println(addedCust.toString());
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
 * 
 * 
 */

