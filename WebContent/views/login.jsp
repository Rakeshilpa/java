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
	<div align="center" >
		<h1 align="center">Employee Login Form</h1>
		
		<form action="<%=request.getContextPath()%>/log" method="post">
			<table style="with: 100%">
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
					<td>UserName</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>

			</table>
			
		</form>
	</div>
</body>
</html>
