package net.javaguides.registration.Dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/test")
public class LineManagerProfile extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
    {  
     PrintWriter out = res.getWriter();  
     res.setContentType("text/html");  
     out.println("<html><body>");  
     java.lang.String driver="com.mysql.cj.jdbc.Driver";
		java.lang.String url="jdbc:mysql://localhost:3306/employees";
		java.lang.String username="root";
		java.lang.String password="Rakesh@123";
		try {
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,username,password);
		Statement stmt=con.createStatement();
		//stmt.executeUpdate("insert into student values(1,'rakesh','electronics'),(2,'ramesh','electronics')");
		ResultSet resultset=stmt.executeQuery("select * from temp");
		/*
		 * if(resultset.next()) {
		 */
        
         
       
         
         out.println("<table border=1 width=50% height=50%>");
         out.println("<tr><th>employee mail</th><th>employee id</th><th>Qualification</th><th>percentage</th><th>Technical Skills</th>"
         		+ "<th>Designation</th><th>Experience</th></tr>"); 
        
         while (resultset.next()) 
         {  
           
             
             out.println("<tr><td>" + resultset.getString(1) + "</td><td>" + resultset.getString(2) + "</td>"
             		+ "<td>" + resultset.getString(3) +"</td><td>"+resultset.getString(4) +"</td><td>" + resultset.getString(5)+"</td><td>"
             +resultset.getString(6) + "</td><td>"+ resultset.getString(7)+"</td><td>"
             		+ "<form ><a href=\"approve\">Approve</a></form></td><td><form ><a href=\"reject\">Reject</a></form></td></tr>"); 
             
         }  
         /*}
         else
         {
        	 out.println("<h1>" + "No notifications" + "</h1>"); 
         }*/
         out.println("</table>");  
         out.println("</html></body>");  
         con.close();  
        }  
         catch (Exception e) 
        {  
         out.println("error");  
     }  
 }

}
