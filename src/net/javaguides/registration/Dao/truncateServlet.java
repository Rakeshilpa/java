package net.javaguides.registration.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/reject")
public class truncateServlet extends GenericServlet

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
		try {
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,username,password);
		Statement stmt=con.createStatement();
		//stmt.executeUpdate("insert into student values(1,'rakesh','electronics'),(2,'ramesh','electronics')");
		
	    stmt.executeUpdate("TRUNCATE TABLE temp");
	    
		con.close();
		   

	    
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Rejected.jsp");
    	dispatcher.forward(request, response);
		
	}
	

}
