package net.javaguides.registration.model;

import java.io.Serializable;

public class EmployeeDetails implements Serializable 
{

	private static final long serialVersionUID = 1L;
	
	private String employeeName;
	private int employeeId;
	private String employeeQulification;
	private int employeePercentage;
	private String[] employeeSkill;
	
	private String employeeRole;
	private int employeeExperiance;
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeQulification() {
		return employeeQulification;
	}
	public void setEmployeeQulification(String employeeQulification) {
		this.employeeQulification = employeeQulification;
	}
	public int getEmployeePercentage() {
		return employeePercentage;
	}
	public void setEmployeePercentage(int employeePercentage) {
		this.employeePercentage = employeePercentage;
	}
	public String[] getEmployeeSkill() {
		return employeeSkill;
	}
	public void setEmployeeSkill(String[] employeeSkills) {
		this.employeeSkill = employeeSkills;
	}
	public String getEmployeeRole() {
		return employeeRole;
	}
	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}
	public int getEmployeeExperiance() {
		return employeeExperiance;
	}
	public void setEmployeeExperiance(int employeeExperiance2) {
		this.employeeExperiance = employeeExperiance2;
	}
	
}
