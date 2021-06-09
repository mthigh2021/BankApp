package dev.developer.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dev.developer.models.Customer;
import dev.developer.utils.JDBCConnection;

public class CustomerDAO implements GenericRepositories<Customer> {

	private static Connection conn = JDBCConnection.getConnection();

	@Override
	public Customer add(Customer c) {

		// public Customer(Integer id, String name, String userName, String passWord,
		// Integer accountNumber, double deposit,
		// double balance, double withdrawl)
		// String sql = "insert into table Customer values(default,? ,?,?,?,?,?,?);";

		List<Customer> custAdded = new ArrayList<Customer>();
		String sql = "insert into customer (cust_id, cust_Name,cust_username, cust_passWord,cust_accountNumber,cust_deposit,balance,withdrawl) VALUES (default,?,?,?,?,?,?,?);";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getUserName());
			ps.setString(3, c.getPassWord());
			ps.setInt(4, c.getAccountNumber());
			ps.setDouble(5, c.getDeposit());
			ps.setDouble(6, c.getBalance());
			ps.setDouble(7, c.getWithdrawl());

			ps.executeUpdate();

			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;

		
	}

	@Override
	public Customer getById(Integer id) {
		// TODO Auto-generated method stub
		Customer cusID = new Customer();
		// cusId.setId(getInt("cust_id"));
		String sql = "select * from customer where cust_id = ?;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			cusID.setId(rs.getInt("cust_id"));

			cusID.setName(rs.getString("cust_Name"));
			cusID.setUserName(rs.getString("cust_username"));
			cusID.setPassWord(rs.getString("cust_password"));
			cusID.setAccountNumber(rs.getInt("cust_accountnumber"));
			cusID.setDeposit(rs.getDouble("cust_deposit"));
			cusID.setBalance(rs.getDouble("balance"));
			cusID.setWithdrawl(rs.getDouble("withdrawl"));

			return cusID;

		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		return null;
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub

		List<Customer> customer = new ArrayList<Customer>();

		String sql = "select * from Customer;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql); // ps is an object comes from java.sql class
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getInt("cust_id"));
				c.setName(rs.getString("cust_name"));
				// c.setUserName(rs.getString("cust_userName"));
				c.setAccountNumber(rs.getInt("cust_accountnumber"));
				c.setBalance(rs.getDouble("balance"));
				c.setWithdrawl(rs.getDouble("withdrawl"));
				c.setUserName(rs.getString("cust_username"));
				c.setPassWord(rs.getString("cust_password"));
				c.setDeposit(rs.getDouble("cust_deposit"));

				customer.add(c);
			}

			return customer;

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return customer;
	}

	@Override
	public boolean update(Customer c) {

		//		boolean  f = false;
		//		String sql = "update table customer  cust_username =?, cust_password =? cust_deposit=? ; ";
		//		  try {
		//			PreparedStatement ps = conn.prepareStatement(sql);
		//			//ps.setInt(1, c.getId());
		//          ps.setString(1,c.getUserName());
		//          ps.setString(2, c.getPassWord());
		//          ps.setDouble(3, c.getDeposit());
		//         // ps.setDouble(0, 0);
		//          
		//         // ps.executeUpdate();
		//        //  ps.executeUpdate();
		//          
		//         
		//          
		//          
		//			 f = true;
		//			
		//		} catch (SQLException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		//		
		//		
		//		
		//		
		//		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Customer c) {
		// TODO Auto-generated method stub

		return false;
	}

	@Override
	public Customer registerNew(Customer c) {

		// public Customer(Integer id, String name, String userName, String passWord,
		// Integer accountNumber, double deposit,
		// double balance, double withdrawl)

		boolean f = false;

		// String sql = "update into table customer(cust_id,cust_name,cust_username,
		// cust_password, cust_accountNumber,cust_deposit,cust_balance,cust_withdrawl)
		// values(default,?,? ,?,?,?,?,?,?);";
		// String sql = "update table customer cust_username =?, cust_password =?
		// cust_deposit=? ; ";
		String sql = "insert into customer(cust_name, cust_username, cust_passWord,cust_deposit) VALUES (?,?,?,?);";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getUserName());
			ps.setString(3, c.getPassWord());
			ps.setDouble(4, c.getDeposit());

			ps.executeUpdate();

			return c;
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

	}

	@Override
	public Customer loginCheck(Customer t) {   
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getByPassword(String p) {
		// TODO Auto-generated method stub

		String sql = "Select * from customer where  cust_password = 'p' ; ";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { //// go throw each row and fetch the name and password

				String PullRSPW = rs.getString("cust_password");
				if (PullRSPW == p) {
					System.out.println(PullRSPW);
				} else {
					System.out.println("wrong password");
				}

			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return null;
	}

	@Override
	public Customer getSpecificColumnBypassword(String p) {
		// TODO Auto-generated method stub
		List<Customer> customer1 = new ArrayList<Customer>();
		Customer cusID = new Customer();

		// String sql = "Select (cust_id,cust_Name,
		// cust_username,cust_password,cust_accountnumber,cust_deposit,balance,withdrawl)
		// from customer where cust_password = ? ; ";
		String sql = "select * from customer where cust_password = 'p';";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs1 = ps.executeQuery();

			while (rs1.next()) { //// go throw each row and fetch the name and password

				String PullRSPW = rs1.getString("cust_password");

				if (PullRSPW == p) {
					// TODO Auto-generated method stub
					String sql1 = "select * from customer where cust_password = ?;";
					PreparedStatement ps1 = conn.prepareStatement(sql);

					ResultSet rs = ps.executeQuery();

					// ps.setRowId(1, "cust_id");
					ps.setString(1, PullRSPW);
					// rs2.next();
					// ps.setString(1, "cust_password");
					rs.next();
					cusID.setId(rs.getInt("cust_id"));

					cusID.setName(rs.getString("cust_Name"));
					cusID.setUserName(rs.getString("cust_username"));
					cusID.setPassWord(rs.getString("cust_password"));
					cusID.setAccountNumber(rs.getInt("cust_accountnumber"));
					cusID.setDeposit(rs.getDouble("cust_deposit"));
					cusID.setBalance(rs.getDouble("balance"));
					cusID.setWithdrawl(rs.getDouble("withdrawl"));

					customer1.add(cusID);

				} else {
					System.out.println("wrong password");
				}

			}

			return cusID;

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return null;
	}

	@Override
	public Customer getByAccountID(Integer id) {  
		// TODO Auto-generated method stub

		List<Customer> customer1 = new ArrayList<Customer>();
		Customer cusID = new Customer();

		// String sql = "Select (cust_id,cust_Name,
		// cust_username,cust_password,cust_accountnumber,cust_deposit,balance,withdrawl)
		// from customer where cust_password = ? ; ";
		String sql = "select * from customer where cust_accountnumber = ? ;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			// ps.setInt(1, "cust_id");
			rs.next();
			cusID.setId(rs.getInt("cust_id"));

			cusID.setName(rs.getString("cust_Name"));
			cusID.setUserName(rs.getString("cust_username"));
			cusID.setPassWord(rs.getString("cust_password"));
			cusID.setAccountNumber(rs.getInt("cust_accountnumber"));
			cusID.setDeposit(rs.getDouble("cust_deposit"));
			cusID.setBalance(rs.getDouble("balance"));
			cusID.setWithdrawl(rs.getDouble("withdrawl"));

			customer1.add(cusID);

			return cusID;

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return null;
	}
	
	
	
	

}
