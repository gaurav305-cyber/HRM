package com.test.model;

public class EmployeeDTO {
private String employeeName;
private String departmentName;
private double salary;
private String status;

public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public String getDepartmentName() {
	return departmentName;
}
public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
}
