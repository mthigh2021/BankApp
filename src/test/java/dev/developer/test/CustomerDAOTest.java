package dev.developer.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dev.developer.app.AppLogger;
import dev.developer.models.Customer;
import dev.developer.repositories.CustomerDAO;
import dev.developer.utils.JDBCConnection;
import junit.framework.Assert;

public class CustomerDAOTest  {
  
	public static final Logger log = LogManager.getLogger(CustomerDAOTest.class);
	
	private static Connection conn;
	private static Savepoint sp;
	private Integer expectedID = 4 ;
	
	
	private CustomerDAO  cusDao;
	
	@BeforeClass 
	public static void beforeClass() {
		 
		conn = JDBCConnection.getConnection();
	}
	@Before 
	public void before() {
		
		try {
			conn.setAutoCommit(false);
			sp = conn.setSavepoint();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
	

	@Test
	public void  add() {
		
		List<Customer> custAddedTest = new ArrayList<Customer>();
		List<Customer> custExpectedTest = new ArrayList<Customer>();

		custAddedTest.add(new Customer(2,"sam", "sam1", "oo8", 1002, 900,900,0));
		custAddedTest.add(new Customer(3,"tom", "tomm1", "oo9", 1003, 800,800,0));
		
		custExpectedTest.add(new Customer(1,"dip", "dip1", "122", 105, 100,900,0));
		custExpectedTest.add(new Customer(4,"puj", "puj1", "133", 1006, 200,800,0));
		
		
		
//		Customer expected = new Customer("cid","cn",);
//		Customer c = new Customer("test","test,true");
//		Customer result =cusDao.add(c);
		assertEquals(custAddedTest, custExpectedTest);
	
	   System.out.println("congrats Test passs");
	}
	
	@Test 
	public void getById() {
		Customer c1 = new Customer(1,"test");
		c1.setId(1);
        Customer c2 = new Customer(2,"SAvin");
		c2.setId(2);
        Customer expected = new Customer(3,"dkboss");
        expected.setId(3);
        Customer result = cusDao.getById(2);
	    Customer resultExp = cusDao.getById(3);
		assertEquals(result,resultExp);
		
		System.out.println("congrats test case passes");
	}
	
	
	
	
	@Test
	public void getAll() {
		
		
		List<Customer> customer = new ArrayList<Customer>();
		//List<Customer> customer = this.cusDao.getAll();
		List<Customer> custExpectedTest = new ArrayList<Customer>();
		
		customer.add(new Customer(2,"sam", "sam1", "oo8", 1002, 900,900,0));
		customer.add(new Customer(3,"tom", "tomm1", "oo9", 1003, 800,800,0));
		
		custExpectedTest.add(new Customer(1,"dip", "dip1", "122", 105, 100,900,0));
		custExpectedTest.add(new Customer(4,"puj", "puj1", "133", 1006, 200,800,0));
		
		int result =assertsEquals(2, cusDao.getAll());
		
		int resultExpected = assertsEquals(2, cusDao.getAll());
		
		assertEquals(result,resultExpected);
		
		System.out.println("testGetAllCustomer pass sucessfully");
		
		//assertsEquals(2, cusDao.getAll());
		//assertsEquals("cust_name",((List<Customer>) cusDao).get(0),getName());
		//assertsEquals("cust_")

		
	}

	private int assertsEquals(int i, Object size) {
		return i;
		// TODO Auto-generated method stub
		
	}

	private void assertsEquals(String string, Customer customer, Object name) {
		// TODO Auto-generated method stub
		
	}

	private Object getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@After
	public void after() {
		try {
			conn.rollback(sp);
			conn.setAutoCommit(true);
			String sql = String.format("alter sequence cust_id restart with %d:",expectedID);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			
		}catch(SQLException e ) {
			e.printStackTrace();
		}
	}

}
