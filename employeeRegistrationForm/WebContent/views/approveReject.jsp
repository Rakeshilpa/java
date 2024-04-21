<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="java.io.*,java.util.*,java.sql.*"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="reg.css"></link>
<body id="a">
 
</body>
      <% java.lang.String driver="com.mysql.cj.jdbc.Driver";
		java.lang.String url="jdbc:mysql://localhost:3306/employees";
		java.lang.String username="root";
		java.lang.String password="Rakesh@123";
		try {
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,username,password);
		Statement stmt=con.createStatement();
		//stmt.executeUpdate("insert into student values(1,'rakesh','electronics'),(2,'ramesh','electronics')");
		ResultSet resultset=stmt.executeQuery("select * from temp");%>
		
      
	<%--    <%   String str=resultset.getString(1);
	       HttpSession sess=request.getSession();
           sess.setAttribute("email", str); %> --%>
       <%if(resultset.next()){session.setAttribute("email", resultset.getString(1));} %>
      <TABLE  border=1 width=50% height=50%>
      <TR>
      <TH>email</TH>
      <TH>Id</TH>
      <TH>qualification</TH>
      <TH>percentage</TH>
      <TH>skills</TH>
      <TH>job role</TH>
      <TH>experience</TH>
      <TH colspan="2">Action</TH>
      </TR>  
       <% while(resultset.next()){ %>    
      <TR>
       <TD> <%= resultset.getString(1) %></td>
       <TD> <%= resultset.getInt(2) %></TD>
       <TD> <%= resultset.getString(3) %></TD>
       <TD> <%= resultset.getString(4) %></TD>
       <TD> <%= resultset.getString(5) %></TD>
       <TD> <%= resultset.getString(6) %></TD>
       <TD> <%= resultset.getString(7) %></TD>
       <TD style="width:100px">  <p align="center">  <form > <a href="<%=request.getContextPath()%>/approve">approve </a>
                                 </form></TD>
       <TD style="width:100px">  <form>
                        <a href="<%=request.getContextPath()%>/reject">reject </a>
                     </form></TD>
      </TR>
      <% } %>
     </TABLE>
       <% if(!resultset.next()){ %>
        <h1>No Notifications</h1>
		   <%} %>
	    	
	    	<%con.close();	    	    
		    }
		catch(Exception e)
		{
			System.out.println(e);
		} %>
            
</html>