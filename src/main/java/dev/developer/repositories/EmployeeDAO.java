package dev.developer.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.developer.models.Customer;
import dev.developer.models.Employee;
import dev.developer.utils.JDBCConnection;

public class EmployeeDAO implements GenericRepositories<Employee> {
    private static Connection conn = JDBCConnection.getConnection();
	@Override
	public Employee add(Employee e) {
		// TODO Auto-generated method stub
		String sql = "insert into employee values(default,?,?);";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				e.setId(rs.getInt("emp_id"));
				return e;
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Employee getById(Integer id) {
		// TODO Auto-generated method stub
		
       String sql = "select * from employee where id = ? ;";
		
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int colmID =rs.getInt(1);
			    System.out.println(colmID);
			}
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		List<Employee> employee = new ArrayList<Employee>();
		 String  sql  = "Select * from Employee;";
		 
		 try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				Employee e = new Employee();
				e.setId(rs.getInt("emp_id"));
				e.setName(rs.getString("emp_name"));
				
				employee.add(e);
			}
			
			
			return employee;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return employee;
	}

	@Override
	public boolean update(Employee change) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}
	

@Override
public  Employee registerNew(Employee e) {
		
		//public Customer(Integer id, String name, String userName, String passWord, Integer accountNumber, double deposit,
				//double balance, double withdrawl)
		
		//boolean  f = false;
		
		//String sql = "update  into table customer(cust_id,cust_name,cust_username, cust_password, cust_accountNumber,cust_deposit,cust_balance,cust_withdrawl) values(default,?,? ,?,?,?,?,?,?);";
		//String sql = "update table employee  emp_username =?, emp_password =? ; ";
		String sql = "insert into employee(emp_name, emp_username, emp_passWord,emp_post) VALUES (?,?,?,?);";  
		  try {
			PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setInt(1, c.getId());
			ps.setString(1,e.getName());
            ps.setString(2,e.getEmp_username());
            ps.setString(3, e.getEmp_password());
            ps.setString(4,e.getEmp_title());
          
            
            // ps.setDouble(3, c.getDeposit());
           // ps.setDouble(0, 0);
            
             ps.executeUpdate();
         
            
           
            return e;
            
			 
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//return null;
		return null;
		
		
	}

@Override
public Employee loginCheck(Employee e) {  //// Not working need attention
	// TODO Auto-generated method stub
	  List<Employee> employee = new ArrayList<Employee>();
	    String sql = "Select * from employee where emp_username = ? and emp_password = ?; ";
	
	    try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) { ////go throw each row and fetch the name and password 
				Employee checkE = new Employee();
			 // ps.setString(1,checkE.getEmp_username());
             // ps.setString(2, checkE.getEmp_password());
              
              // String pullRSname = rs.getString("emp_username");
               String PullRSPW = rs.getString("emp_password");
               
               
          
			}
			//if ((pullRSname.equals() && PullRSPW.equals()) )
			 
			
			return e;
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
	
	
	
	
	
	
	
	
	
	
	return null;
}

@Override
public Employee getByPassword(String p) {
	// TODO Auto-generated method stub
	
	  String sql = "Select * from employee where  emp_password = 'p' ; ";
		
	    try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) { ////go throw each row and fetch the name and password 
			 //Employee checkE = new Employee();
			 // ps.setString(1,checkE.getEmp_username());
           // ps.setString(2, checkE.getEmp_password());
            
            // String pullRSname = rs.getString("emp_username");
             String PullRSPW = rs.getString("emp_password");
             if(PullRSPW == p) {
             System.out.println(PullRSPW);
             }else {
            	 System.out.println("wrong password");
             }
            	 
             
        
			}
			//if ((pullRSname.equals() && PullRSPW.equals()) )
			 
			
	
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
	
//    String sql = "select * from employee where id = ? ;";
//		
//		
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			if(rs.next()) {
//				int colmID =rs.getInt(1);
//			    System.out.println(colmID);
//			}
//		
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		return null;
//	
	
	
	
	
	
	
	
	
	
	
	
	return null;
}

@Override
public Employee getSpecificColumnBypassword(String p) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Employee getByAccountID(Integer id) {
	// TODO Auto-generated method stub
	return null;
}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
