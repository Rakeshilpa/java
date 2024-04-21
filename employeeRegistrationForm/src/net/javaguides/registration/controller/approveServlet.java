package net.javaguides.registration.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/approve")
public class approveServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		java.lang.String driver="com.mysql.cj.jdbc.Driver";
		java.lang.String url="jdbc:mysql://localhost:3306/employees";
		java.lang.String username="root";
		java.lang.String password="Rakesh@123";
		try {
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,username,password);
		Statement stmt=con.createStatement();
		//stmt.executeUpdate("insert into student values(1,'rakesh','electronics'),(2,'ramesh','electronics')");
		
	    stmt.executeUpdate("INSERT employees.employeeprofile SELECT * FROM employees.temp");
	    stmt.executeUpdate("TRUNCATE TABLE temp");
	    HttpSession session = req.getSession();
		 String str2=(String) session.getAttribute("email");
		 System.out.println(str2);
	    
	    
		con.close();
		   

	    
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/approved.jsp");
    	dispatcher.forward(req, res);
    	

	}

}
