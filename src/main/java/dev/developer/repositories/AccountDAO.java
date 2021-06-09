package dev.developer.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.developer.models.Account;
import dev.developer.models.Customer;
import dev.developer.utils.JDBCConnection;

public class AccountDAO implements GenericRepositories<Account> {
  private Connection conn = JDBCConnection.getConnection();
	@Override
	public Account add(Account a) {
		// TODO Auto-generated method stub
		String sql = ("insert  into table account values(default,? ,?,?,?,?);");
		
		  try {
			PreparedStatement ps = conn.prepareStatement(sql);
			//ResultSet rs = ps.executeQuery();
         // ps.setString(1,c.getName(),c.getUserName(),c.getPassWord(),c.getAccountNumber(),c.getDeposit(),c.getBalance(),c.getWithdrawl());
             ps.setString(1,a.getCustomerName());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				a.setId(rs.getInt("acct_id"));
				return a;
			}
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
		
		
		
		//return null;
	}

	@Override
	public Account getById(Integer id) {
		// TODO Auto-generated method stub
	List<Account> myAccount = new ArrayList<Account>();
		//myAccount.setId(id);
		
		String sql = ("select * from account where id=?") ;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setInt(1,"acct_id");
			ResultSet rs = ps.executeQuery();
//			System.out.println("Execute Statement");
			rs.next();
//			myAccount.setId(rs.getInt(1));
//			System.out.println(myAccount.getId());
//			return myAccount;
			if(rs.next()) {
				Account accID = new Account();
				accID.setId(rs.getInt(1));
				//myAccount =rs.getInt("1");
			   // System.out.println(colmId);
				
				myAccount.add(accID);
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		return null;
	}

	@Override
	public List<Account> getAll() {
		// TODO Auto-generated method stub  
		
	//public Account(Integer id, String name, Integer account_number, double balance, double withDrew, double deposit)
		List<Account> account = new ArrayList<Account>();
		
		String sql = "select * from account;";
		try {
		PreparedStatement ps = conn.prepareStatement(sql); // ps is an object comes from java.sql class 
		 ResultSet rs = ps.executeQuery();
		 
		 while(rs.next()) {
			 Account  a = new Account();
			 a.setId(rs.getInt("acct_id"));
			 a.setName(rs.getString("cust_name"));
			// c.setUserName(rs.getString("cust_userName"));
			 a.setAccount_number(rs.getInt("cust_accountnumber"));
			 a.setBalance(rs.getDouble("balance"));
			 a.setWithDrew(rs.getDouble("withdrew"));
			// c.setUserName(rs.getString("cust_username"));
			// c.setPassWord(rs.getString("cust_password"));
             a.setDeposit(rs.getDouble("deposit"));
			 
			 account.add(a);
		 }
		
		 
		 return account;
		
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		
		return account;
		
		
		//return null;
	}

	public boolean update(Account change) {
		// TODO Auto-generated method stub
		return false;
	}

	public Account registerNew(Account t) {
		// TODO Auto-generated method stub
		return null;
	}

	public Account loginCheck(Account t) {
		// TODO Auto-generated method stub
		return null;
	}

	public Account getByPassword(String p) {
		// TODO Auto-generated method stub
		return null;
	}

	public Account getSpecificColumnBypassword(String p) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(Account t) {
		// TODO Auto-generated method stub
		return false;
	}

	public Account getByAccountID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
