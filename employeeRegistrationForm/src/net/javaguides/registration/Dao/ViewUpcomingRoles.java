package net.javaguides.registration.Dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/upcoming")
public class ViewUpcomingRoles extends GenericServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		java.lang.String driver="com.mysql.cj.jdbc.Driver";
		java.lang.String url="jdbc:mysql://localhost:3306/employees";
		java.lang.String username="root";
		java.lang.String password="Rakesh@123";
		
		PrintWriter out = response.getWriter(); 
		response.setContentType("text/html");  
	       out.println("<html><body>");  
		try {
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,username,password);
		
		
		PreparedStatement preparedStatement = con
				.prepareStatement("select * from jobrole");
		
	
		
				ResultSet res = preparedStatement.executeQuery();
				out.println("<table border=1 width=50% height=50%>");
		           out.println("<tr><th>experience(years)</th><th>job role</th><th> description</th></tr>");
	   
			
		while(res.next())
		{
			/*
			 * out1.print(res.getString(1)+"           ");
			 * out1.print("           "+res.getString(2)+"       ");
			 * out1.print("              "+res.getString(3)); out1.println();
			 */
			 out.println("<tr><td>" + res.getString(1) + "</td><td>" + res.getString(2) + "</td><td>" + res.getString(3) +"</td></tr>");
			
		}
		
		
		
		
	    
		con.close();
		   

	    
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
