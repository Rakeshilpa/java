package net.javaguides.registration.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.registration.Dao.EmployeeDao;
import net.javaguides.registration.model.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/register")
public class EmployeeServlet extends HttpServlet
{
	 private static final long serialVersionUID = 1L;
	    private EmployeeDao employeeDao;

	    public void init() {
	        employeeDao = new EmployeeDao();
	    }
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    	    throws ServletException, IOException 
	    {
	    	//response.getWriter().append("Served at :").append(request.getContextPath());
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/views/employeeregister.jsp");
	    	dispatcher.forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
            int id=Integer.parseInt(request.getParameter("id"));
	        String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        String address = request.getParameter("address");
	        String contact = request.getParameter("contact");
	        String jobRole = request.getParameter("jobrole");

	        Employee employee = new Employee();
	        
	        employee.setId(id);
	        employee.setFirstName(firstName);
	        employee.setLastName(lastName);
	        employee.setUsername(username);
	        employee.setPassword(password);
	        employee.setContact(contact);
	        employee.setAddress(address);
	        employee.setJobRole(jobRole);
	        
	        try {
				employeeDao.registerEmployee(employee);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	        

	        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/employeedetails.jsp");
	    	dispatcher.forward(request, response);
	    }

}
