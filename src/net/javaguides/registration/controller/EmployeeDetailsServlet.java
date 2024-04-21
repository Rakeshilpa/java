package net.javaguides.registration.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.registration.Dao.EmployeeDetailsDao;
import net.javaguides.registration.model.EmployeeDetails;

@WebServlet("/submit")
public class EmployeeDetailsServlet extends HttpServlet 
{

	private static final long serialVersionUID = 1L;
	
	private EmployeeDetailsDao employeeDetailsDao;

    public void init() {
        employeeDetailsDao = new EmployeeDetailsDao();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException 
    {
    	//response.getWriter().append("Served at :").append(request.getContextPath());
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/views/EmployeeProfile.jsp");
    	dispatcher.forward(request, response);
    }
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
    	String employeename = request.getParameter("emp_name");
    	int employeeid =Integer.parseInt(request.getParameter("emp_id"));
    	String employeeQalification = request.getParameter("course");
    	int employeePercentage = Integer.parseInt(request.getParameter("percentage"));
    	String[] employeeSkills = request.getParameterValues("names");
    	List list = Arrays.asList(employeeSkills);
		request.setAttribute("names", list);
    	String employeeRole = request.getParameter("employeerole");
    	int employeeExperiance = Integer.parseInt(request.getParameter("experiance"));

        EmployeeDetails employeedetails = new EmployeeDetails();
        
        employeedetails.setEmployeeName(employeename);
        employeedetails.setEmployeeId(employeeid);
        employeedetails.setEmployeeQulification(employeeQalification);
        employeedetails.setEmployeePercentage(employeePercentage);
        employeedetails.setEmployeeSkill(employeeSkills);
        employeedetails.setEmployeeRole(employeeRole);
        employeedetails.setEmployeeExperiance(employeeExperiance);
        
        try {
        	employeeDetailsDao.updateEmployee(employeedetails);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/employeeProfileResult.jsp");
    	dispatcher.forward(request, response);
    }
	
	
	

}
