package dev.developer.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//import com.developer.utils.JDBCConnection;

public class JDBCConnection {

	
	private static Connection  conn = null;
	
	public static Connection getConnection() {
		
		
		try {
			if (conn == null) {
			
			Class.forName("org.postgresql.Driver");
			
			Properties props = new Properties();
			
			InputStream  input = JDBCConnection.class.getClassLoader().getResourceAsStream("connection.properties");
			
			 props.load(input);
			 
			 String url =props.getProperty("url");
			 String username =props.getProperty("username");
			 String password =props.getProperty("password");
			 
			 conn = DriverManager.getConnection(url,username,password);
			 return conn;
			}else {
				return conn;
			}
			
		} catch (SQLException | IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static void main(String[] args) {
		Connection conn = JDBCConnection.getConnection();
		if (conn != null) {
			System.out.println("Connection Sucessfull");
		}else {
			System.out.println("Connection UnSucessfull");

		}
			
		
	}
	
	
	
}
