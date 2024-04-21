<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcome</title>
<head>
 
 <link rel="stylesheet" href="reg.css"></link>
    <script type="text/javascript">
        function validate_form() {
            if (document.emp.emp_name.value == "") {
                alert("Please fill in the 'Your Employee email' box.");
                return false;
            }
            if (document.emp.num.value == "") {
                alert("Enter Employee Number");
                return false;
            }
            alert("sucessfully Submitted");
 
 
 
            if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/).test(document.emp.email_id.value)) {
                alert("You have entered an invalid email address!")
                return (false)
            }
        }
 
        function isNumberKey(evt) {
            var charCode = (evt.which) ? evt.which : event.keyCode;
            if (charCode != 46 && charCode > 31 &&
                (charCode < 48 || charCode > 57)) {
                alert("Enter Number");
                return false;
            }
            return true;
        }
 
 
       
    </script>
 
</head>
 
<body id="b">

    <form name="emp" action="<%=request.getContextPath()%>/submit" onsubmit="return validate_form();" method="post">
    
        <table align="center" width=40% width="100%" cellspacing="2" cellpadding="2" border="5" id="d">
            <tr>
                <td colspan="2" align="center"><b>EMPLOYEE PROFILE PAGE</b></td>
 
            </tr>
            <tr>
                <td align="left" valign="top" width="41%">Employee email<span style="color:red">*</span></td>
 
                <td width="57%"><input type="email" value="" name="emp_name" size="24"></td>
            </tr>
            <tr>
                <td align="left" valign="top" width="41%">Employee Id<span style="color:red">*</span></td>
                <td width="57%">
                    <input type="text" value="" name="emp_id" onkeypress="return isNumberKey(event)" size="24"></td>
            </tr>
            <tr>
                <td align="left" valign="top" width="41%">Higher education </td>
 
                <td width="57%">
  <select name="course">  
<option value="Course">Course</option>  
<option value="BCA">BCA</option>  
<option value="BBA">BBA</option>  
<option value="B.Tech">B.Tech</option>  
<option value="MBA">MBA</option>  
<option value="MCA">MCA</option>  
<option value="M.Tech">M.Tech</option>  
</select>  </td>
            </tr>
            <tr>
 
            <td align="left" valign="top" width="41%">Percentage</td>
            <td width="57%">
                <input type="number" value="" onkeypress="return isNumberKey(event)" name="percentage" size="24"></td>
            </tr>
            <tr>
                <td align="left" valign="top" width="41%">Technical Skills </td>
                <td width="57%">
<input type="checkbox" id="java" name="names" value="java">
<label for="java"> Core java</label><br>
<input type="checkbox" id="advjava" name="names" value="advjava">
<label for="advjava"> Advanced java(J2EE)</label><br>
<input type="checkbox" id="python" name="names" value="python">
<label for="python"> Python</label><br>
<input type="checkbox" id="php" name="names" value="php">
<label for="php">  php </label><br>
<input type="checkbox" id="sql" name="names" value="sql">
<label for="sql"> SQL</label><br>
<input type="checkbox" id="c#" name="names" value="c#">
<label for="c#"> C# </label><br> 
<input type="checkbox" id="c" name="names" value="c/c++">
<label for="c"> C/C++</label><br>
<input type="checkbox" id="abap" name="names" value="sap abap">
<label for="abap"> SAP ABAP </label><br>
<input type="checkbox" id=".net" name=".names" value=".NET">
<label for=".net"> .NET</label><br>
               </td>
 
 
            </tr>
 
            <tr>
                <td align="left" valign="top" width="41%">Designation</td>
                <td width="57%">
        <select name="employeerole">
<option value="Default">Default</option>
<option value="Trainee Engineer">Trainee Engineer</option>
<option value="junior developer">junior developer</option>
<option value="Middle developer">Middle developer</option>
<option value="Senior developer">Senior developer</option>
<option value="Architect">Architect</option>
<option value="Systems Engineer">System Engineer</option>
 
 
</select></td>
 
 
            </tr>
            <tr>
                <td align="left" valign="top" width="41%">Experience<span style="color:red">*</span></td>
                <td width="57%">
                   <select name="experiance">  
<option value="0">0</option>  
<option value="1">>1</option>  
<option value="3">2-3</option>  
<option value="5">4-5</option>  
<option value="6">5 </option>  
 
</select>Years</td>
            </tr>
			 <tr>
                <td align="left" valign="top" width="41%"> Upload Certificate</td>
 
                <td width="57%"><input type="file" name="file"></td>
            </tr>
 
            <tr>
                <td colspan="2">
                    <p align="center">
                        <input type="submit" value="Submit" name="B4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="reset" value="  Reset All   " name="B5"></td>
            </tr>
 
        </table>
     
    </form>
       
   
</body>
</html>