package com.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class ConnectionUtil extends HttpServlet {
public static Connection getConnection() {
	Connection con=null;
	
	   InitialContext context;
	try {
		context = new InitialContext();
		System.out.println(context); 
		DataSource ds = (DataSource)context.lookup("java:comp/env/my");
		con=ds.getConnection();
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 // context.lookup("java:comp/env/my"); System.out.println(ds);
 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  
	 
	/*
	 * try { System.out.println("1"); Class.forName("com.mysql.cj.jdbc.Driver");
	 * System.out.println("2"); con =
	 * DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root",
	 * "root"); System.out.println("3"); } catch (ClassNotFoundException |
	 * SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 */
	return con;
	

	  

}
}
