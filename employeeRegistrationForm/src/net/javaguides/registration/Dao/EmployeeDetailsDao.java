package net.javaguides.registration.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.javaguides.registration.model.EmployeeDetails;

public class EmployeeDetailsDao {
	public int updateEmployee(EmployeeDetails employeedetails) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO temp" +
            "  (empName, empId, empQualification, empPercentage, empSkills, empRole, empExperiance) VALUES " +
            " (?, ?, ?, ?, ?,?,?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/employees", "root","Rakesh@123");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)
            ) 
        {
            preparedStatement.setString(1, employeedetails.getEmployeeName() );
            preparedStatement.setInt(2, employeedetails.getEmployeeId() );
            preparedStatement.setString(3, employeedetails.getEmployeeQulification() );
            
            preparedStatement.setInt(4, employeedetails.getEmployeePercentage());
            String lang[]=employeedetails.getEmployeeSkill();
            String EmployeeSkill="";
            for(int i=0;i<lang.length;i++){
                EmployeeSkill+=lang[i]+", ";
            }
            preparedStatement.setString(5, EmployeeSkill);
            preparedStatement.setString(6, employeedetails.getEmployeeRole());
            preparedStatement.setInt(7, employeedetails.getEmployeeExperiance());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
        
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    


}
