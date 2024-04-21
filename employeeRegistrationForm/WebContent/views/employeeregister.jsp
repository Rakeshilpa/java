<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<link rel="stylesheet" href="reg.css"></link>
<body id="a">

  <div  >
  <h1 align="center">Employee Registration Form</h1>
   
  <form action="register" method="post">
 
   <table style="with: 80%" align="center" >	
     <tr>
     <td>Job Role</td>
     <td>
     
     <select name="jobrole">  
     <option value="">select</option> 
<option value="Associate engineer">Associate</option>  
<option value="Line Manager">line manager</option>  
<option value="Hr Manager">hr manager</option> 

</select>    
     
     </td>
    </tr>
   <tr>
     <td>Employee id</td>
     <td><input type="text" name="id" /></td>
    </tr>
    <tr>
     <td>First Name</td>
     <td><input type="text" name="firstName" /></td>
    </tr>
    <tr>
     <td>Last Name</td>
     <td><input type="text" name="lastName" /></td>
    </tr>
    <tr>
     <td>UserName</td>
     <td><input type="email" name="username" placeholder="enter your mail"></input></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
    <tr>
     <td>Address</td>
     <td><input type="text" name="address" /></td>
    </tr>
    <tr>
     <td>Contact No</td>
     <td><input type="text" name="contact" /></td>
    </tr>
    <tr>
					<td></td>
					<td><input type="submit" value="Submit" /> or</td>
					
					
    </tr>
     <tr>
					<td></td>
					<td><a href="views/login.jsp">click </a>here to login</td>
					
					
    </tr>
   </table>
  </form>
 </div>

</body>
</html>