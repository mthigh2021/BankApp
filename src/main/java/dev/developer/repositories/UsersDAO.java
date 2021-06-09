package dev.developer.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.developer.models.Customer;
import dev.developer.models.Employee;
import dev.developer.models.Users;
import dev.developer.utils.JDBCConnection;

public class UsersDAO implements GenericRepositories<Users> {
	 private Connection conn = JDBCConnection.getConnection();

	@Override
	public Users add(Users u) {
		// TODO Auto-generated method stub
		String sql = "insert  into table user values(default,'?','?','?','?','?',?,?,?);";
		
		  try {
			PreparedStatement ps = conn.prepareStatement(sql);
         // ps.setString(1,c.getName(),c.getUserName(),c.getPassWord(),c.getAccountNumber(),c.getDeposit(),c.getBalance(),c.getWithdrawl());
            ps.setString(1,u.getCust_name());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				u.setUsr_id(rs.getInt("id"));
				return u;
			}
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public Users getById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from users where id = ? ";
		
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int colmId =rs.getInt(1);
			    System.out.println(colmId);
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Users> getAll() {
		// TODO Auto-generated method stub
		List<Users> user = new ArrayList<Users>();

         //public Users(Integer id, String userName, String passWord, Customer customer, Employee employee, String cust_name,
            //String emp_name, int cust_accountnumber, List<Customer> cust, List<Employee> emp) 
		
		String sql = "select * from users;";
		try {
		PreparedStatement ps = conn.prepareStatement(sql); // ps is an object comes from java.sql class 
		 ResultSet rs = ps.executeQuery();
		 
		 while(rs.next()) {
			 Users  u = new Users();
			 u.setUsr_id(rs.getInt("usr_id"));
			 u.setCust_id(rs.getInt("cust_id"));
			 u.setEmp_id(rs.getInt("emp_id"));
			 u.setUserName(rs.getString("username"));
			 u.setPassWord(rs.getString("password"));
			 u.setCust_name(rs.getString("cust_name"));
			 u.setEmp_name(rs.getString("emp_name"));
			 u.setCust_accountnumber(rs.getInt("cust_accountnumber"));
			 
			 u.setEmp_username(rs.getString("emp_username"));
			 u.setEmp_password(rs.getString("emp_password"));
			 u.setEmp_account(rs.getInt("emp_account"));
			 
			// c.setUserName(rs.getString("cust_userName"));
			 
			// u.setBalance(rs.getDouble("balance"));
			// c.setWithdrawl(rs.getDouble("withdrawl"));
			
			 
             //u.setDeposit(rs.getDouble("cust_deposit"));
			 
			 user.add(u);
		 }
		
		 
		 return user;
		
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		

		
		return null;
	}

	@Override
	public boolean update(Users change) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Users u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Users registerNew(Users t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users loginCheck(Users t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getByPassword(String p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getSpecificColumnBypassword(String p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getByAccountID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
