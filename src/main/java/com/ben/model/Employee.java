package com.ben.model;

public class Employee {
	
	private String employeeName;
	private String employeePassword;
	
	
	/**
	 * @param employeeName
	 * @param employeePassword
	 */
	public Employee(String employeeName, String employeePassword) {
		super();
		this.employeeName = employeeName;
		this.employeePassword = employeePassword;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeePassword=" + employeePassword + "]";
	}
	
	
	
	

}
