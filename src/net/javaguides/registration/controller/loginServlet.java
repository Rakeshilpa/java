package net.javaguides.registration.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.javaguides.registration.Dao.LoginDao;
import net.javaguides.registration.model.LoginBean;
@WebServlet("/log")
public class loginServlet extends HttpServlet{
	
	 private static final long serialVersionUID = 1L;
	    private LoginDao loginDao;

	    public void init() {
	        loginDao = new LoginDao();
	    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException 
	{
        String jobrole= request.getParameter("jobrole");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginBean loginBean = new LoginBean();
		loginBean.setJobrole(jobrole);
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		
		HttpSession session=request.getSession();
		session.setAttribute("username", username);
		
		
		
		try {
			if (loginDao.validate(loginBean)) {
				if(jobrole.equalsIgnoreCase("Associate engineer"))
				{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/views/loginsuccess.jsp");
		    	dispatcher.forward(request, response);
				}
				else if(jobrole.equalsIgnoreCase("Line Manager"))
				{
					RequestDispatcher dispatcher = request.getRequestDispatcher("/views/loginsuccessline.jsp");
			    	dispatcher.forward(request, response);
				}
				else
				{
					RequestDispatcher dispatcher = request.getRequestDispatcher("/views/loginsuccesshr.jsp");
			    	dispatcher.forward(request, response);
				}

				
			} else {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/views/loginfail.jsp");
		    	dispatcher.forward(request, response);
				//session.setAttribute("user", username);
				//response.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
  
    	
    }
	

}
