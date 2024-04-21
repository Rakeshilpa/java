package net.javaguides.registration.Dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
 
@WebServlet("/updated")
public class viewUpdatedDetails  extends HttpServlet

{

	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    
		java.lang.String driver="com.mysql.cj.jdbc.Driver";
		java.lang.String url="jdbc:mysql://localhost:3306/employees";
		java.lang.String username="root";
		java.lang.String password="Rakesh@123";
		try {
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,username,password);
		
		
		PreparedStatement preparedStatement = con
				.prepareStatement("select * from employeeprofile where empName = ?");
		
		
		HttpSession session = request.getSession();
		 String str2=(String) session.getAttribute("username");

		 		
		preparedStatement.setString(1, str2);
		
				ResultSet res = preparedStatement.executeQuery();
	   
		PrintWriter out1 =response.getWriter();
		if(res.next())
		{
	   
	   
			response.setContentType("text/html");
			String title = "result"; 
			out1.println("<html>"); 
			out1.println("<head>"); 
			out1.println("<title>"+title+"</title>");
			out1.println("</head>");
			out1.println("<body>");
			out1.println("<table border=1 width=70% align=\"center\">");
			out1.println("<tr>");
			out1.println("<td>"+"email"+"</td>");
			out1.println("<td>");
			out1.println(res.getString(1));
			out1.println("</td>");
			out1.println("</tr>");
			out1.println("<tr>");
			out1.println("<td>"+"employee Id"+"</td>");
			out1.println("<td>");
			out1.println(res.getInt(2));
			out1.println("</td>");
			out1.println("</tr>");
			out1.println("<tr>");
			out1.println("<td>"+"degree"+"</td>");
			out1.println("<td>");
			out1.println(res.getString(3));
			out1.println("</td>");
			out1.println("</tr>");
			out1.println("<tr>");
			out1.println("<td>"+"percentage"+"</td>");
			out1.println("<td>");
			out1.println(res.getString(4));
			out1.println("</td>");
			out1.println("</tr>");
			out1.println("<tr>");
			out1.println("<td>"+"skills"+"</td>");
			out1.println("<td>");
			out1.println(res.getString(5));
			out1.println("</td>");
			out1.println("</tr>");
			out1.println("<tr>");
			out1.println("<td>"+"designation"+"</td>");
			out1.println("<td>");
			out1.println(res.getString(6));
			out1.println("</td>");
			out1.println("</tr>");
			out1.println("<tr>");
			out1.println("<td>"+"experiance"+"</td>");
			out1.println("<td>");
			out1.println(res.getString(7));
			out1.println("</td>");
			out1.println("</tr>");
			out1.println("</table>");
			out1.println("</body");
			out1.println("</html>");
			
			
		}
		else
		{
			out1.println("Details are not updated yet");
		}
		
		
		
		
		
	    
		con.close();
		   

	    
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
